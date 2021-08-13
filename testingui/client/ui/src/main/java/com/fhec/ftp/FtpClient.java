package com.fhec.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fhec.exceptions.FTPReplyException;
import com.fhec.views.MainWindow;

public class FtpClient {

	// 主动模式
	public static int ACTIVE_LOCAL_DATA_CONNECTION_MODE = 0;

	// 被动模式
	public static int PASSIVE_LOCAL_DATA_CONNECTION_MODE = 1;

	private Lock lock = new ReentrantLock();

	private static final Logger log = LoggerFactory.getLogger(FtpClient.class);

	public int dataConnctionModel = 0;

	// ftp服务器地址
	public String hostname;
	// ftp服务器端口号默认为21
	public Integer port;
	// ftp登录账号
	public String username;
	// ftp登录密码
	public String password;

	private Watcher uploadWatcher = new Watcher();

	private Watcher downloadWatcher = new Watcher();

	public FTPClient ftpClient = new FTPClient();

	public static HashMap<String, FtpClient> clients = new HashMap<String, FtpClient>();

	public static HashMap<String, FtpClient> uploadClients = new HashMap<String, FtpClient>();

	private FtpClient(String hostname, String username, String password, int port, int dataConnctionModel) {

		this.hostname = StringUtils.trim(hostname);
		this.username = StringUtils.trim(username);
		this.password = StringUtils.trim(password);
		this.port = port;
		this.dataConnctionModel = dataConnctionModel;
	}

	public String getWorkingDirectory() throws IOException {
		return ftpClient.printWorkingDirectory();
	}

	public static FtpClient create(String hostname, String username, String password, int port,
			int dataConnctionModel) {
		String key = hostname;
		FtpClient client = clients.get(key);
		if (client != null) {
			throw new RuntimeException("重复创建，请调用get");
		}
		client = new FtpClient(hostname, username, password, port, dataConnctionModel);
		clients.put(key, client);
		return client;
	}

	/**
	 * @author Jacob 上传服务器初始化
	 */
	public static FtpClient uploadCreate(String hostname, String username, String password, int port,
			int dataConnctionModel) {
		String key = hostname;
		FtpClient client = uploadClients.get(key);
		if (client != null) {
			throw new RuntimeException("重复创建，请调用get");
		}
		client = new FtpClient(hostname, username, password, port, dataConnctionModel);
		clients.put(key, client);
		return client;
	}

	public static FtpClient get(String hostname) {
		String key = hostname;
		FtpClient client = clients.get(key);
		if (client == null) {
			throw new RuntimeException("ftp未初始化");
		}
		return client;
	}

	private void enterDataConnctionModel() {
		// 被动模式: PASSIVE_LOCAL_DATA_CONNECTION_MODE=1
		// 主动模式:ACTIVE_LOCAL_DATA_CONNECTION_MODE=0
		if (dataConnctionModel == ACTIVE_LOCAL_DATA_CONNECTION_MODE) {
			ftpClient.enterLocalActiveMode();
			return;
		}
		if (dataConnctionModel == PASSIVE_LOCAL_DATA_CONNECTION_MODE) {
			ftpClient.enterLocalPassiveMode();
			return;
		}
		throw new RuntimeException("传输模式只支持被动模式=1和主动模式=0");
	}

	public interface IAction {

		void doAction(FtpClient ftpClient) throws Exception;
	}

	public interface IFunc {

		<T> T doFunc(FtpClient ftpClient) throws Exception;
	}

	public void doAction(IAction action) throws Exception {
		lock.lock();
		try {
			this.login(4, 10);
			if (action == null) {
				return;
			}
			action.doAction(this);
		} finally {
			this.logout();
			lock.unlock();
		}

	}

	public <T> T doFunc(IFunc func) throws Exception {
		lock.lock();
		try {
			this.login(4, 10);
			if (func == null) {
				return null;
			}
			return func.doFunc(this);
		} finally {
			this.logout();
			lock.unlock();
		}

	}

	public void login(int retryCount, int seconds) throws Exception {
		int count = 0;
		do {
			try {
				_login();
				return;
			} catch (Exception ex) {
				Thread.sleep(seconds * 1000);
				if (count >= retryCount) {
					throw ex;
				}
				count++;
			}

		} while (true);
	}

	/**
	 * 初始化ftp服务器
	 *
	 * @throws Exception
	 * @throws IOException
	 * @throws SocketException
	 * @throws InterruptedException
	 */
	private void _login() throws Exception {

		ftpClient.setControlEncoding("utf-8");

		log.info("connecting...ftp服务器:" + this.hostname + ":" + this.port);
		ftpClient.connect(hostname, port);
		if (!ftpClient.isConnected()) {
			throw new FTPReplyException(ftpClient, "网络连接失败");
		}
		if (ftpClient.login(username, password)) {
			this.enterDataConnctionModel();
			log.info("login当前路径：" + ftpClient.printWorkingDirectory());
			return;
		}
		int replyCode = ftpClient.getReplyCode(); // 是否成功登录服务器
		log.info("登录 ftp服务器失败:" + this.hostname + ":" + this.port);
		log.info("登录失败，FTP状态码：" + replyCode);
		throw new FTPReplyException(ftpClient, "登录失败,FTP状态码:" + replyCode);
	}

	/**
	 * 上传文件
	 *
	 * @param pathname ftp服务保存地址
	 * @param fileName 上传到ftp的文件名
	 * @param file     上传的文件
	 * @return
	 * @throws Exception
	 */
	public void uploadFile(String pathname, String fileName, File file) throws Exception {
		MainWindow.progress(true);
		log.info("uploadFile当前路径：" + ftpClient.printWorkingDirectory());
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			log.info("开始上传文件");
			ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
			createDirecroty(pathname);

			OutputStream outputStream = ftpClient.storeFileStream(fileName);

			byte[] bytes = new byte[1024];
			int count = 0;
			int redfile=0;
			long size = file.length();
			while ((count = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, count);
				outputStream.flush();
				redfile+=count;
				MainWindow.redJProgressBar(size, redfile);
			}
			MainWindow.setProgressTxt("["+fileName+"]文件上传成功");
			outputStream.close();

			log.info("上传文件成功");
			MainWindow.progress(false);
		} finally {
			if (null != inputStream) {
				inputStream.close();
			}
		}
	}

	// 创建多层目录文件，如果有ftp服务器已存在该文件，则不创建，如果无，则创建
	public void createDirecroty(String pathname) throws Exception {
		log.info("createDirecroty当前路径：" + ftpClient.printWorkingDirectory());
		pathname = new String(pathname.getBytes("GBK"), "iso-8859-1");

		pathname = StringUtils.replaceChars(pathname, '\\', '/');
		String[] dirnames = pathname.split("/");
		for (String dirname : dirnames) {
			if (StringUtils.isBlank(dirname)) {
				continue;
			}
			int filetype = exist(dirname);
			if (filetype == -1) {
				if (!ftpClient.makeDirectory(dirname)) {
					throw new FTPReplyException(ftpClient, "目录创建失败,错误状态码" + ftpClient.getReplyCode());
				}
				filetype = FTPFile.DIRECTORY_TYPE;
			}
			if (filetype != FTPFile.DIRECTORY_TYPE) {
				throw new FTPReplyException(ftpClient, "当前相对路径名称不是文件夹：" + dirname);
			}
			if (!changeWorkingDirectory(dirname)) {
				throw new FTPReplyException(ftpClient, "切换工作路径失败:" + dirname);
			}
		}

	}

	private boolean changeWorkingDirectory(String pathname) throws IOException {
		log.info("changeWorkingDirectory 前当前路径：" + ftpClient.printWorkingDirectory());
		boolean flag = ftpClient.changeWorkingDirectory(pathname);
		log.info("changeWorkingDirectory 后当前路径：" + ftpClient.printWorkingDirectory());
		return flag;
	}

	public int exist(String name) throws IOException {
		// this.changeWorkingDirectory(name);
		return exist("", name);
	}

	public int exist(String pathname, String name) throws IOException {
		log.info("exist当前路径：" + ftpClient.printWorkingDirectory());

		FTPFile[] ftpFiles = ftpClient.listFiles(pathname, new FTPFileFilter() {

			@Override
			public boolean accept(FTPFile file) {
				return file != null && StringUtils.equalsIgnoreCase(file.getName(), name);
			}
		});
		if (ftpFiles == null || ftpFiles.length == 0) {
			return -1;
		}
		return ftpFiles[0].getType();
	}

	public boolean existserverFile(String filename) throws IOException {
		return existFile("", filename);
	}

	// 判断ftp服务器文件是否存在
	public boolean existFile(String pathname, String filename) throws IOException {
		log.info("existFile当前路径：" + ftpClient.printWorkingDirectory());
		FTPFile[] ftpFiles = ftpClient.listFiles(pathname, new FTPFileFilter() {

			@Override
			public boolean accept(FTPFile file) {
				return file != null && file.isFile() && StringUtils.equalsIgnoreCase(file.getName(), filename);
			}
		});
		if (ftpFiles == null || ftpFiles.length == 0) {
			return false;
		}
		return true;
	}

	// 判断ftp服务器文件是否存在
	public boolean existFile(String path) throws Exception {
		String replace = path.replace("\\", "/");
		boolean flag = false;
		try {
			FTPFile[] ftpFileArr = ftpClient.listFiles(replace);
			if (ftpFileArr.length > 0) {
				flag = true;
			}
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return flag;
	}

	public Boolean existDirectory(String dirname) throws IOException {
		return existDirectory("", dirname);
	}

	/**
	 * 判断ftp服务器文件路劲是否存在
	 *
	 * @param dirname
	 * @return
	 * @throws IOException
	 */
	public Boolean existDirectory(String pathname, String dirname) throws IOException {
		log.info("existDirectory当前路径：" + ftpClient.printWorkingDirectory());
		FTPFile[] ftpFiles = ftpClient.listFiles(pathname, new FTPFileFilter() {

			@Override
			public boolean accept(FTPFile file) {

				return file != null && file.isDirectory() && StringUtils.equalsIgnoreCase(file.getName(), dirname);
			}
		});
		if (ftpFiles == null || ftpFiles.length == 0) {
			return false;
		}

		return true;
	}

	/**
	 * * 下载文件 *
	 *
	 * @param remotepath FTP服务器文件目录 *
	 * @param filename   文件名称 *
	 * @param localdir   下载后的文件路径 *
	 * @return
	 * @throws Exception
	 */
	public void downloadFile(String remotepath, String localdir, String filename) throws Exception {
		MainWindow.progress(true);
		String replace = remotepath.replace("\\", "/");
		log.info("downloadFile当前路径：" + ftpClient.printWorkingDirectory());
		File directory = new File(localdir);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		log.info("开始下载文件");
		// 切换FTP目录
		FTPFile ftpFile = getFile(replace, filename);
		if (ftpFile == null) {
			throw new FTPReplyException(ftpClient, "文件不存在：" + replace + "/" + filename);
		}
		downloadWatcher.start(ftpFile.getSize());
		File localFile = new File(localdir + "/" + ftpFile.getName());
		OutputStream outputStream = null;
		InputStream inputStream = null;
		try {
			outputStream = new FileOutputStream(localFile);
			System.out.println(ftpFile.getName());
			this.changeWorkingDirectory(replace);
			ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
			inputStream = ftpClient.retrieveFileStream(ftpFile.getName());
			if (inputStream == null) {
				throw new FTPReplyException(ftpClient, "获取文件失败");
			}
			long size = ftpFile.getSize();
			int count = 0;
			long redfile=0;
			byte[] bytes = new byte[10240];
			MainWindow.setProgressTxt("正在下载"+"["+ftpFile.getName()+"]文件");
			while ((count = inputStream.read(bytes)) != -1) {
			    redfile+=count;
				outputStream.write(bytes, 0, count);
				outputStream.flush();
				MainWindow.redJProgressBar(size, redfile);
				downloadWatcher.watch(count);
			}

			log.info("下载文件成功");
			MainWindow.setProgressTxt("["+ftpFile.getName()+"]文件下载完成");
//			downloadWatcher.stop();
			MainWindow.progress(false);
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

	private FTPFile getFile(String pathname, String filename) throws Exception {
		log.info("getFile当前路径：" + ftpClient.printWorkingDirectory());
		FTPFile[] ftpFiles = ftpClient.listFiles(pathname, new FTPFileFilter() {

			@Override
			public boolean accept(FTPFile file) {
				return file != null && file.isFile() && StringUtils.equalsIgnoreCase(file.getName(), filename);
			}
		});
		if (ftpFiles.length > 0) {
			return ftpFiles[0];
		}
		return null;
	}

	/**
	 * * 删除文件 *
	 *
	 * @param pathname FTP服务器保存目录 *
	 * @param filename 要删除的文件名称 *
	 * @return
	 * @throws IOException
	 */
	public void deleteFile(String pathname, String filename) throws IOException {
		log.info("deleteFile当前路径：" + ftpClient.printWorkingDirectory());
		// 切换FTP目录
		if (!changeWorkingDirectory(pathname)) {
			log.info("目录不存在:" + pathname);
			return;
		}
		log.info("开始删除文件" + filename);
		ftpClient.dele(filename);
		log.info("删除文件成功");
	}

	public void logout() throws Exception {
		if (!ftpClient.isConnected()) {
			return;
		}
		ftpClient.logout();
		ftpClient.disconnect();
	}

	public Watcher getUploadWatcher() {
		return uploadWatcher;
	}

	public Watcher getDownloadWatcher() {
		return downloadWatcher;
	}

	public static class Watcher {

		private long length = 0;

		private long position = 0;

		private boolean finished;

		private volatile int percent = 0;

		public long getLength() {
			return length;
		}

		public long getPosition() {
			return position;
		}

		public boolean isFinished() {
			return finished;
		}

		public void reset() {
			this.length = 0;
			this.position = 0;
			this.percent = 0;
			this.finished = false;
		}

		public void start(long length) {
			this.length = length;
			this.position = 0;
			this.percent = 0;
			this.finished = false;
		}

		public int getPercent() {
			return percent;
		}

		public synchronized void watch(int count) {
			this.position += count;
			percent = this.length == 0 ? 0 : (int) (this.position * 100 / this.length);
		}

		public void stop() {
			this.finished = true;
		}

	}

}
