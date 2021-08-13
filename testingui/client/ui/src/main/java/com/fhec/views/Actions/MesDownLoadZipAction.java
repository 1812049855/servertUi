package com.fhec.views.Actions;

import java.io.File;

import javax.swing.JOptionPane;

import com.fhec.context.ConfigFilePath;
import com.fhec.context.EnvConFigConfig;
import com.fhec.context.GlobalContext;
import com.fhec.context.MesFileConfig;
import com.fhec.context.Temporary;
import com.fhec.ftp.FtpClient;
import com.fhec.log.Log;
import com.fhec.utils.CompressFileUtils;
import com.fhec.views.MESDownloadView;
import com.fhec.views.MainWindow;
import com.fhec.views.ProgressBarView;

public class MesDownLoadZipAction {

	private MESDownloadView window;
	private MainWindow mainWindow;

	public MesDownLoadZipAction(MESDownloadView window, MainWindow mainWindow) {
		this.window = window;
		this.mainWindow = mainWindow;
	}

	public MesDownLoadZipAction() {
	}

	private String localrecipefilepath;

	public String getLocalrecipefilepath() {
		return localrecipefilepath;
	}

	public void setLocalrecipefilepath(String localrecipefilepath) {
		this.localrecipefilepath = localrecipefilepath;
	}

	public boolean downLoadMesZip() throws Exception {
		EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
		MesFileConfig mesFileConfig = GlobalContext.getMesFileConfig();
		boolean success = false;
		FtpClient ftp = FtpClient.get(envConFigConfig.getServerProgramIP().getServer_pgm_IP());
		ftp.doAction(new FtpClient.IAction() {
			@Override
			public void doAction(FtpClient ftpClient) {
				Log.info("网络存在");
			}
		});
		String repzipfilename=null;
		String zipfile_Name = mesFileConfig.getZipfile_Name();
		if(zipfile_Name!=null) {
			if(zipfile_Name.contains("\\")) {
				String replaceAll = zipfile_Name.replaceAll("\\\\", "/");
				repzipfilename=replaceAll;
			}else {
				repzipfilename=zipfile_Name;
			}
			 
		}
		
		String zipfilepath = repzipfilename.substring(0,
				repzipfilename.lastIndexOf("/"));
		String zipfilename = repzipfilename
				.substring(repzipfilename.lastIndexOf("/") + 1);
		String serzippath = envConFigConfig.getMainPath().getServer_prog_path() + File.separator + zipfilepath;
		String local_zip_path = envConFigConfig.getMainPath().getLocal_prog_path() + File.separator + zipfilepath;
		System.out.println(local_zip_path);
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
					}
				}
			});
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
		}
			this.window.setuiLog(zipfilename + "压缩包下载成功");
			String unzippath = local_zip_path + File.separator + zipfilename;
			try {
				success = CompressFileUtils.autoPkg(unzippath, local_zip_path);
				Log.info(zipfilename + "压缩包解压成功");
				this.window.setuiLog(zipfilename + "压缩包解压成功");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
			}
		
		return success;
	}

	private String getRecipePaht(String typepath, String device_Name,String customer_ID,String pgmpathcode, String recipe_foldername) {
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

	public boolean downLoadMesRecipe() throws Exception {
		EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
		MesFileConfig mesFileConfig = GlobalContext.getMesFileConfig();
		String customer_ID = mesFileConfig.getCustomer_ID();
		String device_Name = mesFileConfig.getDevice_Name();
		boolean success = false;
		FtpClient ftp = FtpClient.get(envConFigConfig.getServerProgramIP().getServer_pgm_IP());

		String repzipfilename=null;
		String zipfile_Name = mesFileConfig.getZipfile_Name();
		if(zipfile_Name!=null) {
			if(zipfile_Name.contains("\\")) {
				String replaceAll = zipfile_Name.replaceAll("\\\\", "/");
				repzipfilename=replaceAll;
			}else {
				repzipfilename=zipfile_Name;
			}
		}
		
		String pgmpathcode = repzipfilename.substring(0,
				repzipfilename.lastIndexOf("/"));
		String recipe_foldername = repzipfilename.substring(
				repzipfilename.lastIndexOf("/") + 1,
				CompressFileUtils.findStr(repzipfilename, '.'));
		String localreppath = "";
		String serverrecipePaht = getRecipePaht("server", device_Name, customer_ID, pgmpathcode, recipe_foldername);
		System.out.println(serverrecipePaht);
		String localrecipePaht = getRecipePaht("local", device_Name, customer_ID, pgmpathcode, recipe_foldername);
		localreppath = localrecipePaht;
		String recipefile = mesFileConfig.getMode_Code() + "_recipe.cfg";
		localrecipefilepath = localrecipePaht + recipefile;
		Temporary.localrecipefilepath = localrecipefilepath;

		String zipname = repzipfilename
				.substring(repzipfilename.lastIndexOf("/") + 1);
		try {
			ftp.doAction(new FtpClient.IAction() {
				@Override
				public void doAction(FtpClient ftpClient) {
					try {

						ftp.downloadFile(serverrecipePaht, localrecipePaht, recipefile);
						Log.info("网络存在");
						Log.info(zipname + "压缩包下载成功");
						ProgressBarView.getText("下载" + zipname + "文件成功");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
		}
 
		this.window.setuiLog(recipefile + "下载成功");
//		try {
//			success = CompressFileUtils.autoPkg(localrecipePaht + File.separator + zipname, localrecipePaht);
//			Log.info(zipname + "压缩包解压成功");
//			this.window.setuiLog(zipname + "压缩包解压成功");
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
//		}
		File f = new File(localrecipePaht);
		if (!f.exists()) {
			Log.info("本地 recipe file目录不存在");
			this.window.setuiLog("本地 recipe file目录不存在");
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
			this.window.setuiLog("开始" + ConfigFilePath.RECIPE_PATH + "初始化");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		String path = "C:\\Devices\\LTC\\Recipe\\MAS1102A1_AA_J750HD36020_F1_25_8C\\MAS1102A1_AA_J750HD36020_F1_25_8C\\FT1_recipe.cfg";
		ConfigFilePath.RECIPE_PATH = path;
		GlobalContext.CreatRecipeConfig();
	}
}
