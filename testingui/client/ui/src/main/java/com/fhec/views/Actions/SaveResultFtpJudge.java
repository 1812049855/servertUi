package com.fhec.views.Actions;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.commons.io.FileExistsException;

import com.fhec.context.ConfigFilePath;
import com.fhec.context.EnvConFigConfig;
import com.fhec.context.GlobalContext;
import com.fhec.context.LocalConfig;
import com.fhec.context.RecipeConfig;
import com.fhec.context.RecipeConfig.PackTestResult;
import com.fhec.context.Temporary;
import com.fhec.ftp.FtpClient;
import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;
import com.fhec.utils.CompressFileUtils;
import com.fhec.utils.FileUtils;
import com.fhec.views.MainWindow;
import com.fhec.views.ProgressBarUploadView;

public class SaveResultFtpJudge {

	private MainWindow window;

	public SaveResultFtpJudge(MainWindow window) {
		this.window = window;
	}

	public SaveResultFtpJudge() {

	}

	public boolean ftpInit() throws Exception {
		// 测试数据上传 判断网络是否存在
		EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
		FtpClient ftp = FtpClient.get(envConFigConfig.getServerProgramIP().getServer_pgm_IP());
		try {
			ftp.doAction(new FtpClient.IAction() {

				@Override
				public void doAction(FtpClient ftpClient) {
					try {
						uploadSingleFile();
						uploadCsvir();
						Log.info("网络存在");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
						MainStatus.status2();
					}

				}
			});

		} catch (Exception ex) {
			JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel, "alarm U01:can not connect server,please call ME !", "系统提示",
					JOptionPane.WARNING_MESSAGE);
			// 关闭窗体
			Log.error("网络不存在");
			MainWindow.setUilog("网络不存在");
			MainStatus.status2();
			return false;
		}
		return true;
	}

	/**
	 * 测试机数据上传 通过ftp将local_singlefile_folderpath
	 * 下所有文件移动(剪切)到server_singlefile_folderpath
	 */

	private void uploadSingleFile() {
		EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
		FtpClient ftp = FtpClient.get(envConFigConfig.getServerDataIP().getServer_data_IP());

		/**
		 * 服务器路劲 String server_singlefile =
		 * envConFigConfig.getMainPath().getServer_dlog_path() +
		 * RecipeConfig.DatalogPath.NAME_DATALOG_NAME_RULE_1 + File.separator +
		 * GlobalContext.singleFile; 判断路径是否存在
		 */
		try {
			ftp.doAction(new FtpClient.IAction() {
				@Override
				public void doAction(FtpClient ftpClient) {
					try {
						Boolean singleFile = ftp.existDirectory(Temporary.server_datalog_name_rule1,
								GlobalContext.singleFile);
						System.out.println(singleFile);
						// 存在
						if (!singleFile) {
							ftp.createDirecroty(Temporary.server_singlefile_folderpath);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
						MainStatus.status2();
					}
				}
			});
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
			MainStatus.status2();
		}

		/**
		 * 本地需要传服务器的路劲 String local_singlefile_folderpath =
		 * envConFigConfig.getMainPath().getLocal_dlog_path() + File.separator +
		 * RecipeConfig.DatalogPath.NAME_DATALOG_NAME_RULE_1 + File.separator +
		 * GlobalContext.singleFile 遍历文件夹
		 */
		String[] fileList = new File(Temporary.local_singlefile_folderpath).list();
		for (int i = 0; i < fileList.length; i++) {
			String suffix = fileList[i].substring(fileList[i].lastIndexOf(".") + 1);
			if ("zip".equals(suffix) || "rar".equals(suffix) || "gz".equals(suffix)) {
				int finalI = i;
				try {
					FtpClient ftp2 = FtpClient.get(envConFigConfig.getServerDataIP().getServer_data_IP());
					ftp2.doAction(new FtpClient.IAction() {
						@Override
						public void doAction(FtpClient ftpClient) {
							try {
								ProgressBarUploadView.getText("");
								ftp2.uploadFile(Temporary.server_singlefile_folderpath, fileList[finalI],
										new File(Temporary.local_singlefile_folderpath + File.separatorChar
												+ fileList[finalI]));
								ProgressBarUploadView.getText("上传" + fileList[finalI] + "文件成功");
								Log.info("上传" + fileList[finalI] + "文件成功");
								Log.info("网络存在");
								MainWindow.setUilog("上传" + fileList[finalI] + "文件成功\"");

							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, e.getMessage(), "错误",
										JOptionPane.ERROR_MESSAGE);
							}

						}
					});
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
					MainStatus.status2();
				}
//				Thread thread = new Thread(new Runnable() {
//					@Override
//					public void run() {
//						try {
//							FtpClient ftp = FtpClient.get(envConFigConfig.getServerDataIP().getServer_data_IP());
//							ftp.doAction(new FtpClient.IAction() {
//								@Override
//								public void doAction(FtpClient ftpClient) {
//									try {
//										Thread.sleep(1000);
//										ProgressBarUploadView.getText("");
//										ftp.uploadFile(Temporary.server_singlefile_folderpath, fileList[finalI],
//												new File(Temporary.local_singlefile_folderpath + File.separatorChar
//														+ fileList[finalI]));
//										ProgressBarUploadView.getText("上传" + fileList[finalI] + "文件成功");
//										Log.info("上传" + fileList[finalI] + "文件成功");
//										Log.info("网络存在");
//										MainWindow.setUilog("上传" + fileList[finalI] + "文件成功\"");
//
//									} catch (Exception e) {
//										JOptionPane.showMessageDialog(null, e.getMessage(), "错误",
//												JOptionPane.ERROR_MESSAGE);
//									}
//
//								}
//							});
//						} catch (Exception e1) {
//							// TODO Auto-generated catch block
//							JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
//							MainStatus.status2();
//						}
//					}
//				});
//				ProgressBarUploadView.string(fileList[finalI]);
//				ProgressBarUploadView.Show(null, thread);
			}
		}
		FileUtils.removeDire(new File(Temporary.local_singlefile_folderpath));
	}

	/**
	 * 通过 ftp 将 local_csvdir_folderpath 下的所有文件复制(copy)到 server_csvdir_folderpath
	 */

	private void uploadCsvir() throws Exception {
		EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();

		// 服务器
		FtpClient ftp = FtpClient.get(envConFigConfig.getServerDataIP().getServer_data_IP());

		/**
		 * 服务器路劲 server_csvdir_folderpath = {server_dlog_path}
		 * /{datalog_name_rule_1}/”csvdir”/ String server_csvdir =
		 * envConFigConfig.getMainPath().getServer_dlog_path() +
		 * RecipeConfig.DatalogPath.NAME_DATALOG_NAME_RULE_1 + File.separator +
		 * GlobalContext.csvdir;
		 */

		ftp.doAction(new FtpClient.IAction() {
			@Override
			public void doAction(FtpClient ftpClient) {
				try {
					Boolean csvdirFile = ftp.existDirectory(Temporary.server_datalog_name_rule1, GlobalContext.csvdir);
					System.out.println(csvdirFile);
					// 存在
					if (!csvdirFile) {
						ftp.createDirecroty(Temporary.server_csvdir_folderpath);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
					MainStatus.status2();
				}

			}
		});

		/**
		 * 
		 * 本地local_csvdir_folderpath = D:\datalog\datalog_name_rule_1\csvdir String
		 * local_csvdir_folderpath = envConFigConfig.getMainPath().getLocal_dlog_path()
		 * + File.separator + RecipeConfig.DatalogPath.NAME_DATALOG_NAME_RULE_1
		 * +File.separator + GlobalContext.csvdir;
		 * 
		 */
		String[] fileList = new File(Temporary.local_csvdir_folderpath).list();
		for (int i = 0; i < fileList.length; i++) {
			int finalI = i;
			try {
				FtpClient ftp2 = FtpClient.get(envConFigConfig.getServerDataIP().getServer_data_IP());
				ftp2.doAction(new FtpClient.IAction() {
					@Override
					public void doAction(FtpClient ftpClient) {
						try {
							Thread.sleep(1000);
							ProgressBarUploadView.getText("");
							ftp2.uploadFile(Temporary.server_csvdir_folderpath, fileList[finalI], new File(
									Temporary.local_csvdir_folderpath + File.separatorChar + fileList[finalI]));
							ProgressBarUploadView.getText("上传" + fileList[finalI] + "文件成功");
							Log.info("上传" + fileList[finalI] + "文件成功");
							MainWindow.setUilog("上传" + fileList[finalI] + "文件成功\"");
							Log.info("网络存在");
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage(), "错误",
									JOptionPane.ERROR_MESSAGE);

						}
					}
				});
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
				MainStatus.status2();
			}
//			Thread thread = new Thread(new Runnable() {
//				@Override
//				public void run() {
//					try {
//						FtpClient ftp = FtpClient.get(envConFigConfig.getServerDataIP().getServer_data_IP());
//						ftp.doAction(new FtpClient.IAction() {
//							@Override
//							public void doAction(FtpClient ftpClient) {
//								try {
//									Thread.sleep(1000);
//									ProgressBarUploadView.getText("");
//									ftp.uploadFile(Temporary.server_csvdir_folderpath, fileList[finalI], new File(
//											Temporary.local_csvdir_folderpath + File.separatorChar + fileList[finalI]));
//									ProgressBarUploadView.getText("上传" + fileList[finalI] + "文件成功");
//									Log.info("上传" + fileList[finalI] + "文件成功");
//									MainWindow.setUilog("上传" + fileList[finalI] + "文件成功\"");
//									Log.info("网络存在");
//								} catch (Exception e) {
//									JOptionPane.showMessageDialog(null, e.getMessage(), "错误",
//											JOptionPane.ERROR_MESSAGE);
//
//								}
//							}
//						});
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
//						MainStatus.status2();
//					}
//				}
//			});
//			ProgressBarUploadView.string(fileList[finalI]);
//			ProgressBarUploadView.Show(null, thread);
		}

	}

	/**
	 * SingFile文件压缩
	 * 
	 * @param
	 * @param
	 * @return
	 */
	public boolean SingFileCompress() {
		String singfilepath = Temporary.local_singlefile_folderpath + File.separator;
		String zipfilename = LocalConfig.datalog_name_rules;
		RecipeConfig recipeConfig = GlobalContext.getRecipeConfig();
		PackTestResult packTestResult = recipeConfig.getPackTestResult();
		String packTestResult2 = packTestResult.getPackTestResult();
		boolean compress = true;
		if ("true".equals(packTestResult2)) {
			String packFileType = packTestResult.getPackFileType();
			String packFileSet = packTestResult.getPackFileSet();
			/**
			 * 压缩后的文件名
			 */
			
			if ("S".equals(packFileSet.toUpperCase())) {
				compress = CompressFileUtils.singLeComPress(singfilepath, singfilepath, zipfilename,
						"." + packFileType);
			} else {
				compress = CompressFileUtils.compress(singfilepath, singfilepath, zipfilename, "." + packFileType);
			}
		}
		if (!compress) {
			JOptionPane.showMessageDialog(null, "压缩文件失败", "error", JOptionPane.ERROR_MESSAGE);
		}
		return compress;
	}

	/**
	 * 
	 * 将 temp 路径下的数据剪切到 local_singlefile_folderpath 中
	 * 
	 * 
	 */
	public void shearLocalSingFile() {
		try {
			if (new File(ConfigFilePath.TEST_TEMPDATA).list().length == 0) {
				return;
			} else {
				moveDirectory(new File(ConfigFilePath.TEST_TEMPDATA), new File(Temporary.local_singlefile_folderpath));
				MainWindow.setUilog("将 temp 路径下的数据剪切到 local_singlefile_folderpath成功");
				FileUtils.removeDire(new File(ConfigFilePath.TEST_TEMPDATA));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
			MainStatus.status2();
		}

	}

	public void moveDirectory(final File srcDir, final File destDir) throws IOException {
		if (!srcDir.isDirectory()) {
			throw new IOException("Source '" + srcDir + "' is not a directory");
		}
		if (!destDir.exists()) {
			throw new FileExistsException("Destination '" + destDir + "' already exists");
		}
		final boolean rename = srcDir.renameTo(destDir);
		if (!rename) {
			if (destDir.getCanonicalPath().startsWith(srcDir.getCanonicalPath() + File.separator)) {
				throw new IOException("Cannot move directory: " + srcDir + " to a subdirectory of itself: " + destDir);
			}
			org.apache.commons.io.FileUtils.copyDirectory(srcDir, destDir);

			if (!srcDir.exists()) {
				throw new IOException(
						"Failed to delete original directory '" + srcDir + "' after copy to '" + destDir + "'");
			}
		}
	}
}
