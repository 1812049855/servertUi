package com.fhec.utils;

import com.fhec.log.Log;
import de.innosystec.unrar.Archive;
import de.innosystec.unrar.NativeStorage;
import de.innosystec.unrar.rarfile.FileHeader;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.tools.tar.TarEntry;
import org.apache.tools.tar.TarInputStream;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.*;

/**
 * 
 * 压缩包工具类
 * 
 * @author Jacob
 * @date 2020-09-23
 * @remark 支持类型 zip rar gz tar.gz tar
 */
public class CompressFileUtils {

	/**
	 * 解压rar
	 * 
	 * @param sourceRarPath 需要解压的rar文件全路径
	 * @param destDirPath   需要解压到的文件目录
	 * @throws Exception
	 */
	public static boolean unRar(String sourceRarPath, String destDirPath) throws Exception {
		boolean success = false;
		File f = new File(sourceRarPath);
		NativeStorage sourceRar = new NativeStorage(f);
		File destDir = new File(destDirPath);
		Archive archive = null;
		FileOutputStream fos = null;
		System.out.println("Starting 开始解压...");
		try {
			archive = new Archive(sourceRar);
			FileHeader fh = archive.nextFileHeader();
			File destFileName = null;
			while (fh != null) {
				String fileNameW = fh.getFileNameString();
				System.out.println("already decompression file ->" + fileNameW);
				System.out.println(fh.isDirectory());
				destFileName = new File(destDir.getAbsolutePath() + File.separator + fileNameW);

				if (fh.isDirectory()) {
					if (!destFileName.exists()) {
						destFileName.mkdirs();
					}
					fh = archive.nextFileHeader();
					continue;
				}
				if (!destFileName.getParentFile().exists()) {
					destFileName.getParentFile().mkdirs();
				}
				fos = new FileOutputStream(destFileName);
				archive.extractFile(fh, fos);
				fos.close();
				fos = null;
				fh = archive.nextFileHeader();
			}

			archive.close();
			archive = null;
			System.out.println("Finished 解压完成!");
			success = true;
		} catch (Exception e) {
			throw e;
		} finally {
			if (fos != null) {
				try {
					fos.close();
					fos = null;
				} catch (Exception e) {
				}
			}
			if (archive != null) {
				try {
					archive.close();
					archive = null;
				} catch (Exception e) {
				}
			}
		}
		return success;
	}

	/**
	 * 解压缩zipFile
	 * 
	 * @param unpath    要解压的zip文件路径
	 * @param outputDir 要解压到某个指定的目录下
	 * @throws IOException
	 */
	public static boolean unZip(String unpath, String outputDir) throws IOException {
		//MainWindow.progress(true);
		ZipFile zipFile = null;
		boolean success = false;
		File file = new File(unpath);
		try {
			Charset CP866 = Charset.forName("CP866"); // specifying alternative
														// (non UTF-8) charset
			// ZipFile zipFile = new ZipFile(zipArchive, CP866);
			zipFile = new ZipFile(file, CP866);
			createDirectory(outputDir, null);// 创建输出目录
			
			long zipsize = 0;
			long redfile=0;
		    String zipname = zipFile.getName();
			//MainWindow.setProgressTxt("正在解压"+"["+zipname+"]文件");
			
		 
			Enumeration<? extends ZipEntry> enums = zipFile.entries();
			while (enums.hasMoreElements()) {
				ZipEntry entry = enums.nextElement();
				if (!entry.isDirectory()) {
					long size = entry.getSize();
					zipsize+=size;
				}
				
			} 
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				String filename = entry.getName();
				System.out.println("already decompression file -> " + filename);
				Log.info("正在解压" +filename);
			//	MainWindow.setUilog("正在解压" + filename);
				if (entry.isDirectory()) {// 是目录
					createDirectory(outputDir,filename);// 创建空目录
				} else {// 是文件
					File tmpFile = new File(outputDir + "/" + filename);
					createDirectory(tmpFile.getParent() + "/", null);// 创建输出目录

					InputStream in = null;
					OutputStream out = null;
					try {
						in = zipFile.getInputStream(entry);
						out = new FileOutputStream(tmpFile);
						int length = 0;
						
						byte[] b = new byte[2048];
						while ((length = in.read(b)) != -1) {
							out.write(b, 0, length);
							redfile+=length;
						//	MainWindow.redJProgressBar(zipsize, redfile);
						}
					} catch (IOException ex) {
						throw ex;
					} finally {
						if (in != null)
							in.close();
						if (out != null)
							out.close();
					}
				}
			}
		//	MainWindow.setProgressTxt("["+zipname+"]文件解压完成");
			success = true;
		//	MainWindow.progress(false);
		} catch (IOException e) {
			
			throw new IOException("解压缩文件出现异常", e);
		} finally {
			try {
				if (zipFile != null) {
					zipFile.close();
				}
			} catch (IOException ex) {
				throw new IOException("关闭zipFile出现异常", ex);
			}
		}
		return success;
	}

	public static void createDirectory(String outputDir, String subDir) {
		File file = new File(outputDir);
		if (!(subDir == null || subDir.trim().equals(""))) {// 子目录不为空
			file = new File(outputDir + "/" + subDir);
		}
		if (!file.exists()) {
			if (!file.getParentFile().exists())
				file.getParentFile().mkdirs();
			file.mkdirs();
		}
	}

	/**
	 * 解压 .gz
	 * 
	 * @param sourcedir
	 */
	public static boolean unGzipFile(String sourcedir) {
		boolean success = false;
		String ouputfile = "";
		try {
			// 建立gzip压缩文件输入流
			FileInputStream fin = new FileInputStream(sourcedir);
			// 建立gzip解压工作流
			GZIPInputStream gzin = new GZIPInputStream(fin);
			// 建立解压文件输出流
			ouputfile = sourcedir.substring(0, sourcedir.lastIndexOf('.'));
			ouputfile = ouputfile.substring(0, ouputfile.lastIndexOf('.'));
			FileOutputStream fout = new FileOutputStream(ouputfile);
			int num;
			byte[] buf = new byte[1024];

			while ((num = gzin.read(buf, 0, buf.length)) != -1) {
				fout.write(buf, 0, num);
			}

			gzin.close();
			fout.close();
			fin.close();
			success = true;
		} catch (Exception ex) {
			System.err.println(ex.toString());
		}
		return success;
	}

	/**
	 * 解压 tar.gz格式
	 * 
	 * @param outpath tar.gz文件路径
	 * @param inpath  tar.gz文件解压路径
	 * @return
	 */
	public static boolean unTargz(String inpath, String outpath) throws IOException {
		boolean success = false;
		TarInputStream tarIn = null;
		File file = new File(inpath);
		try {
			tarIn = new TarInputStream(new GZIPInputStream(new BufferedInputStream(new FileInputStream(file))),
					1024 * 2);

			createDirectory(outpath, null);// 创建输出目录

			TarEntry entry = null;
			while ((entry = tarIn.getNextEntry()) != null) {
				System.out.println("  already decompression file -> " + entry.getName());
				if (entry.isDirectory()) {// 是目录
					entry.getName();
					createDirectory(outpath, entry.getName());// 创建空目录
				} else {// 是文件
					File tmpFile = new File(outpath + "/" + entry.getName());
					createDirectory(tmpFile.getParent() + "/", null);// 创建输出目录
					OutputStream out = null;
					try {
						out = new FileOutputStream(tmpFile);
						int length = 0;

						byte[] b = new byte[2048];

						while ((length = tarIn.read(b)) != -1) {
							out.write(b, 0, length);
						}

					} catch (IOException ex) {
						throw ex;
					} finally {

						if (out != null)
							out.close();
					}
				}
			}
			success = true;
		} catch (IOException ex) {
			throw new IOException("解压归档文件出现异常", ex);
		} finally {
			try {
				if (tarIn != null) {
					tarIn.close();
				}
			} catch (IOException ex) {
				throw new IOException("关闭tarFile出现异常", ex);
			}
		}

		return success;
	}

	/**
	 * 解压 tar格式
	 * 
	 * @param decompressFilePath tar文件路径
	 * @param resultDirPath      文件解压路径
	 * @return
	 */
	public static boolean unTar(String decompressFilePath, String resultDirPath) {
		boolean success = false;
		TarArchiveInputStream tais = null;
		FileInputStream fis = null;
		try {
			File file = new File(decompressFilePath);
			fis = new FileInputStream(file);
			tais = new TarArchiveInputStream(fis);
			TarArchiveEntry tae = null;
			while ((tae = tais.getNextTarEntry()) != null) {
				BufferedOutputStream bos = null;
				FileOutputStream fos = null;
				String name = tae.getName();

				try {
					System.out.println("  already decompression file -> " + name);

					String dir = resultDirPath + File.separator + name;// tar档中文件
					File dirFile = new File(dir);
					if (!dirFile.exists()) {
						if (tae.isDirectory())
							dirFile.mkdir();
					}
					if (tae.isFile()) {
						fos = new FileOutputStream(dirFile);
						bos = new BufferedOutputStream(fos);
						int count;
						byte[] data = new byte[1024];
						while ((count = tais.read(data, 0, 1024)) != -1) {
							bos.write(data, 0, count);
						}
					}

					success = true;
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (bos != null)
						bos.close();
					if (fos != null)
						fos.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (tais != null)
					tais.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		System.out.println(" tarDecompression -> Decompression end!");
		return success;

	}

	/**
	 * 寻找文件后缀
	 * 
	 * @param str     文件路径
	 * @param needstr 查找目标
	 * @return
	 */
	public static int findStr(String str, char needstr) {
		int count = 0;
		int flag = 0;
		char[] charArray = str.toCharArray();
		for (int i = charArray.length - 1; i >= 0; i--) {
			if (count > 1)
				break;
			if (needstr == charArray[i]) {
				count++;
				flag = i;
			}

		}

		return flag;

	}
 
	/**
	 * 自动匹配文件类型解压
	 * 
	 * @param filepath   需要解压的文件
	 * @param outfilepth 解压路径
	 * @return
	 * @throws Exception
	 */
	public static boolean autoPkg(String filepath, String outfilepth) throws Exception {
		boolean success = false;
		File f = new File(filepath);
		String name = f.getName();
		int findStr = findStr(name, '.');
		String lastfilename = name.substring(findStr);
		switch (lastfilename) {
		case ".tar.gz":
			success = unTargz(filepath, outfilepth);
			break;
		case ".gz":
			success = unGzipFile(filepath);
			break;
		case ".tar":
			success = unTar(filepath, outfilepth);
			break;
		case ".rar":
			success = unRar(filepath, outfilepth);
			break;
		case ".zip":
			success = unZip(filepath, outfilepth);
			break;

		default:

			break;
		}
		return success;
	}

	public static List<File> getAllFile(File dirFile) {
		List<File> fileList = new ArrayList<>();
		File[] listFiles = dirFile.listFiles();
		for (File file : listFiles) {
			if (file.isFile()) {
				fileList.add(file);
			} else {
				if (file.listFiles().length != 0) {
					fileList.addAll(getAllFile(file));
				} else {
					fileList.add(file);
				}
			}
		}
		return fileList;
	}

	public static String getRelativePath(String path, File file) {
		File f = new File(path);
		String name = file.getName();
		while (true) {
			file = file.getParentFile();
			if (file == null)
				break;
			if (file.equals(f)) {
				break;
			} else {
				name = file.getName() + File.separator + name;
			}
		}
		return name;
	}

	/**
	 * 压缩单个文件
	 * 
	 * @param localpath
	 * @param targetpath
	 * @param zipfilename
	 * @param suffix
	 * @return
	 */
	public static boolean singLeComPress(String localpath, String targetpath, String zipfilename, String suffix) {
		String zip = targetpath + zipfilename;
		File localpathfiles = new File(localpath);

		List<File> files = getAllFile(localpathfiles);
		int BUFFER = 1024;
		byte[] buffer = new byte[BUFFER];

		ZipEntry zipentry = null;
		int readlength = 0;
		try {
			for (File file : files) {

				String filename = file.getName();
				String filesuffix = filename.substring(filename.lastIndexOf("."));
				String comparessname = zip + filesuffix + suffix;
				CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(comparessname), new CRC32());
				ZipOutputStream zos = new ZipOutputStream(cos);
				zipentry = new ZipEntry(getRelativePath(localpath, file));
				zipentry.setSize(file.length());
				zipentry.setTime(file.lastModified());
				zos.putNextEntry(zipentry);
				int redfile=0;
				InputStream is = new BufferedInputStream(new FileInputStream(file));
			//	MainWindow.setProgressTxt("正在压缩["+file.getName()+"]文件");
				while ((readlength = is.read(buffer, 0, BUFFER)) != -1) {
					zos.write(buffer, 0, readlength);
					redfile+=readlength;
			//		MainWindow.redJProgressBar(file.length(), redfile);
				}
				is.close();
				zos.close();
			//	MainWindow.setProgressTxt("["+file.getName()+"]压缩完成");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * 压缩所有 文件
	 * 
	 */
	public static boolean compress(String localpath, String targetpath, String zipfilename, String suffix) {
		String zip = targetpath + zipfilename + suffix;
		File localpathfiles = new File(localpath);

		List<File> files = getAllFile(localpathfiles);
		int BUFFER = 1024;
		byte[] buffer = new byte[BUFFER];

		ZipEntry zipentry = null;
		int readlength = 0;
		try {
			CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(zip), new CRC32());
			ZipOutputStream zos = new ZipOutputStream(cos);
			for (File file : files) {
				if (file.isFile()) {
					zipentry = new ZipEntry(getRelativePath(localpath, file));
					zipentry.setSize(file.length());
					zipentry.setTime(file.lastModified());
					zos.putNextEntry(zipentry);
					int redfile=0;
					InputStream is = new BufferedInputStream(new FileInputStream(file));
			//		MainWindow.setProgressTxt("正在压缩["+file.getName()+"]文件");
					while ((readlength = is.read(buffer, 0, BUFFER)) != -1) {
						zos.write(buffer, 0, readlength);
						redfile+=readlength;
			//			MainWindow.redJProgressBar(file.length(), redfile);
					}
			//			MainWindow.setProgressTxt("["+file.getName()+"]压缩完成");
					is.close();

				} else {
					// 目录
					zipentry = new ZipEntry(getRelativePath(localpath, file));
					zos.putNextEntry(zipentry);
				}
			}
			zos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
 
}
