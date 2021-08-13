package com.fhec.views.Actions;

import java.io.File;

import javax.swing.JOptionPane;

import com.fhec.context.ConfigFilePath;
import com.fhec.context.EnvConFigConfig;
import com.fhec.context.GlobalContext;
import com.fhec.context.Temporary;
import com.fhec.ftp.FtpClient;
import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;
import com.fhec.utils.CompressFileUtils;
import com.fhec.views.MainWindow;
import com.fhec.views.OPDownloadView;
import com.fhec.views.ProgressBarView;

public class OpDownLoadZipAction {

	private OPDownloadView window;

	public OpDownLoadZipAction(OPDownloadView window) {
		this.window = window;
	}

	public OpDownLoadZipAction() {
	}

	private String localrecipefilepath;

	public String getLocalrecipefilepath() {
		return localrecipefilepath;
	}

	public void setLocalrecipefilepath(String localrecipefilepath) {
		this.localrecipefilepath = localrecipefilepath;
	}

	public boolean downLoadOpZip() throws Exception {
		MainWindow.progress(true);
		EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
		boolean success = false;
		FtpClient ftp = FtpClient.get(envConFigConfig.getServerProgramIP().getServer_pgm_IP());
		ftp.doAction(new FtpClient.IAction() {
			@Override
			public void doAction(FtpClient ftpClient) {
				Log.info("网络存在");
			}
		});
		System.out.println(Temporary.Zipfile_Name);
		String zipfilepath = Temporary.Zipfile_Name.substring(0,
				Temporary.Zipfile_Name.replace("/", "\\").lastIndexOf("\\"));
		String zipfilename = Temporary.Zipfile_Name
				.substring(Temporary.Zipfile_Name.replace("/", "\\").lastIndexOf("\\") + 1);
		String serzippath = envConFigConfig.getMainPath().getServer_prog_path() + File.separator + zipfilepath;
		String local_zip_path = envConFigConfig.getMainPath().getLocal_prog_path() + File.separator + zipfilepath;
		try {
			ftp.doAction(new FtpClient.IAction() {
				@Override
				public void doAction(FtpClient ftpClient) {
					try {
						ftp.downloadFile(serzippath, local_zip_path, zipfilename);
						ProgressBarView.getText("下载" + zipfilename + "文件成功");
						Log.info(zipfilename + "压缩包下载成功");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
						MainStatus.status1();
					}
				}
			});
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
			MainStatus.status1();
		}

		MainWindow.setUilog(zipfilename + "压缩包下载成功");
		MainWindow.progress(false);
		String unzippath = local_zip_path + File.separator + zipfilename;
		try {
			success = CompressFileUtils.autoPkg(unzippath, local_zip_path);
			Log.info(zipfilename + "压缩包解压成功");
			MainWindow.setUilog(zipfilename + "压缩包解压成功");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
			MainStatus.status1();

		}
		return success;
	}

	private String getRecipePaht(String typepath, String device_Name, String customer_ID, String pgmpathcode,
			String recipe_foldername) {
		EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
		StringBuilder recipestr = new StringBuilder();
		if ("server".equals(typepath)) {
			recipestr.append(envConFigConfig.getMainPath().getServer_prog_path());
			recipestr.append(customer_ID);
			recipestr.append(File.separator);
			recipestr.append(GlobalContext.RECIPE);
			recipestr.append(File.separator);
			recipestr.append(device_Name);
			recipestr.append(File.separator);
		}

		if ("local".equals(typepath)) {
			recipestr.append(envConFigConfig.getMainPath().getLocal_prog_path());
			recipestr.append(File.separator);
			recipestr.append(pgmpathcode);
			recipestr.append(File.separator);
			recipestr.append(GlobalContext.RECIPE);
			recipestr.append(File.separator);
			recipestr.append(recipe_foldername);
			recipestr.append(File.separator);
		}

		return recipestr.toString();
	}

	public boolean downLoadOpRecipe() throws Exception {
		EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
		String customer_ID = Temporary.customerId;
		String device_Name = Temporary.deviceNametextField;
		boolean success = false;
		FtpClient ftp = FtpClient.get(envConFigConfig.getServerProgramIP().getServer_pgm_IP());
		String repzipfilename = null;
		String zipfile_Name = Temporary.Zipfile_Name;
		if (zipfile_Name != null) {
			if (zipfile_Name.contains("\\")) {
				String replaceAll = zipfile_Name.replaceAll("\\\\", "/");
				repzipfilename = replaceAll;
			} else {
				repzipfilename = zipfile_Name;
			}
		}

		String pgmpathcode = repzipfilename.substring(0, repzipfilename.lastIndexOf("/"));
		String recipe_foldername = repzipfilename.substring(repzipfilename.lastIndexOf("/") + 1,
				CompressFileUtils.findStr(repzipfilename, '.'));
		String localreppath = "";

		String serverrecipePaht = getRecipePaht("server", device_Name, customer_ID, pgmpathcode, recipe_foldername);
		String localrecipePaht = getRecipePaht("local", device_Name, customer_ID, pgmpathcode, recipe_foldername);
		localreppath = localrecipePaht;
		String recipefile = Temporary.oprecipemodecode + "_recipe.cfg";

		localrecipefilepath = localrecipePaht + recipefile;
		Temporary.localrecipefilepath = localrecipefilepath;

		try {
			ftp.doAction(new FtpClient.IAction() {
				@Override
				public void doAction(FtpClient ftpClient) {
					try {
						ftp.downloadFile(serverrecipePaht, localrecipePaht, recipefile);
						Log.info("网络存在");
						Log.info(recipefile + "下载成功");
						ProgressBarView.getText("下载" + recipefile + "文件成功");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
						MainStatus.status1();
					}
				}
			});
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
			MainStatus.status1();
		}
		File f = new File(localrecipePaht);
		if (!f.exists()) {
			Log.info("本地 recipe file目录不存在");
			MainWindow.setUilog("本地 recipe file目录不存在");
			return success;
		}
		File[] listFiles = f.listFiles();
		boolean finddir = false;
		String addpath = null;
		for (int i = 0; i < listFiles.length; i++) {
			File fs = listFiles[i];
			if (fs.isDirectory()) {
				String name = fs.getName();
				addpath = name;
				finddir = true;
				break;
			}
		}
		if (finddir) {
			localreppath += File.separator + addpath + File.separator + recipefile;
			ConfigFilePath.RECIPE_PATH = localreppath;
			Temporary.localrecipefilepath = localreppath;
		} else {
			ConfigFilePath.RECIPE_PATH = localrecipefilepath;
		}
		try {
			GlobalContext.CreatRecipeConfig();
			Log.info("开始" + ConfigFilePath.RECIPE_PATH + "recipe file初始化");
			MainWindow.setUilog("开始" + ConfigFilePath.RECIPE_PATH + "初始化");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
		}

		return true;
	}
}
