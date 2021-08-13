package com.fhec.method;

import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.fhec.context.EnvConFigConfig;
import com.fhec.entity.EntityVo;
import com.fhec.ftp.FtpClient;
import com.fhec.log.Log;
import com.fhec.utils.FileUtils;

import io.netty.channel.ChannelHandlerContext;

public class FullEndLotFtpJudge {
	public FullEndLotFtpJudge() {
	}

	private EntityVo entityVo;
	 private ChannelHandlerContext channelHandlerContext;

	public FullEndLotFtpJudge(EntityVo entityVo, ChannelHandlerContext channelHandlerContext) {
		this.entityVo = entityVo;
		this.channelHandlerContext=channelHandlerContext;
	}


	// 服务器

	public boolean ftpInit() throws Exception {
		 EnvConFigConfig envConFigConfig = entityVo.getEnvConFigConfig();
		// 判断网络是否存在
		try {
			FtpClient ftp = FtpClient.get(envConFigConfig.getServerDataIP().getServer_data_IP());
			if (ftp != null) {
				Log.info("网络存在");
				
				//MainWindow.setUilog("网络存在");
				entityVo.setType(2);
				entityVo.setStatus(0);
				entityVo.setMainUIlog("网络存在");
				channelHandlerContext.writeAndFlush(entityVo);
				//SummaryHtml.summaryHtmlOutPut(entityVo);
				Log.info("通 过 ftp 方 式 ， 将 local_fulllotfile_folderpath 下 所 有 数 据 复 制 到 server_fulllotfile_folderpath");
				
//				MainWindow.setUilog(
//						"通 过 ftp 方 式 ， 将 local_fulllotfile_folderpath 下 所 有 数 据 复 制 到 server_fulllotfile_folderpath");
				entityVo.setType(2);
				entityVo.setStatus(0);
				entityVo.setMainUIlog("通 过 ftp 方 式 ， 将 local_fulllotfile_folderpath 下 所 有 数 据 复 制 到 server_fulllotfile_folderpath");
				channelHandlerContext.writeAndFlush(entityVo);
				uploadFullotFile();
				Log.info("通过 ftp 方式，将 errordata 下所有文件剪切到服务器");
				
				//MainWindow.setUilog("通过 ftp 方式，将 errordata 下所有文件剪切到服务器");
				entityVo.setType(2);
				entityVo.setStatus(0);
				entityVo.setMainUIlog("通过 ftp 方式，将 errordata 下所有文件剪切到服务器");
				channelHandlerContext.writeAndFlush(entityVo);
				upladErrordata();
			}

		} catch (Exception ex) {
			Log.error("连接服务器失败");
		//	MainWindow.setUilog("连接服务器失败");
			JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel,ex.getMessage(), "系统提示",
					JOptionPane.WARNING_MESSAGE);
		//	MainStatus.status3();
			return false;
		}
		return true;
	}

 

	// 通 过 ftp 方 式 ， 将 local_fulllotfile_folderpath 下 所 有 数 据 复 制 到
	// server_fulllotfile_folderpath
	private void uploadFullotFile() throws Exception {
		// 服务器路劲
		FtpClient ftp = FtpClient.get(entityVo.getEnvConFigConfig().getServerDataIP().getServer_data_IP());
		// String fulllotfile = envConFigConfig.getMainPath().getServer_dlog_path() +
		// RecipeConfig.DatalogPath.NAME_DATALOG_NAME_RULE_1 + File.separator +
		// GlobalContext.fulllotfile;

		Log.info("服务器地址" + entityVo.getServer_fulllotfile_folderpath());
		//MainWindow.setUilog("服务器地址" + Temporary.server_fulllotfile_folderpath);

		// 判断路径是否存在
		Log.info("判断路径是否存在");
	//	MainWindow.setUilog("判断路径是否存在");
		ftp.doAction(new FtpClient.IAction() {
			@Override
			public void doAction(FtpClient ftpClient) {
				try {
					boolean fullFile = ftp.existDirectory(entityVo.getServer_fulllotfile_folderpath(),
							EntityVo.fulllotfile);
					// 存在
					if (!fullFile) {
						ftp.createDirecroty(entityVo.getServer_fulllotfile_folderpath());
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
				//	MainStatus.status3();
				}
			}
		});

		// 本地需要传服务器的路劲
		// String local_fulllotfile_folderpath =
		// envConFigConfig.getMainPath().getLocal_dlog_path() + File.separator +
		// RecipeConfig.DatalogPath.NAME_DATALOG_NAME_RULE_1 + File.separator +
		// GlobalContext.fulllotfile;
		Log.info("本地路劲" + entityVo.getLocal_fulllotfile_folderpath());
	//	MainWindow.setUilog("本地路劲" + Temporary.local_fulllotfile_folderpath);
		// 遍历文件夹
		String[] files = new File( entityVo.getLocal_fulllotfile_folderpath()).list();
		for (int i = 0; i < files.length; i++) {
			File file = new File( entityVo.getLocal_fulllotfile_folderpath() + File.separator + files[i]);
			if (file.isDirectory()) {
				String[] list = file.list();
				for (String s : list) {
					int finalI1 = i;
					try {
						FtpClient ftp1 = FtpClient.get(entityVo.getEnvConFigConfig().getServerDataIP().getServer_data_IP());
						ftp1.doAction(new FtpClient.IAction() {
							@Override
							public void doAction(FtpClient ftpClient) {
								try {
									ftp1.uploadFile(entityVo.getServer_fulllotfile_folderpath(), s,
											new File( entityVo.getLocal_fulllotfile_folderpath() + File.separatorChar
													+ files[finalI1] + File.separator + s),entityVo,channelHandlerContext);
								//	ProgressBarUploadView.getText("上传" + s + "文件成功");
									Log.info("上传" + s + "文件成功");
									Log.info("网络存在");
								//	MainWindow.setUilog("上传" + s + "文件成功");
								} catch (Exception e) {
									JOptionPane.showMessageDialog(null, e.getMessage(), "错误",
											JOptionPane.ERROR_MESSAGE);
								//	MainStatus.status3();
								}

							}
						});
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
						//MainStatus.status3();
					}
				}
			}
			if (file.isFile()) {
				// 上传
				Log.info("文件" + files[i] + "开始上传");
			//	MainWindow.setUilog("文件" + files[i] + "开始上传");
				int finalI = i;
				try {
					FtpClient ftp2 = FtpClient.get(entityVo.getEnvConFigConfig().getServerDataIP().getServer_data_IP());
					ftp2.doAction(new FtpClient.IAction() {
						@Override
						public void doAction(FtpClient ftpClient) {
							try {
								ftp2.uploadFile(entityVo.getServer_fulllotfile_folderpath(), files[finalI],
										new File(entityVo.getLocal_fulllotfile_folderpath() + File.separatorChar
												+ files[finalI]),entityVo,channelHandlerContext);
							//	ProgressBarUploadView.getText("上传" + files[finalI] + "文件成功");
								Log.info("上传" + files[finalI] + "文件成功");
						//		MainWindow.setUilog("上传" + files[finalI] + "文件成功");
								Log.info("网络存在");
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, e.getMessage(), "错误",
										JOptionPane.ERROR_MESSAGE);
							//	MainStatus.status3();
							}

						}
					});
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
				//	MainStatus.status3();
				}

			}

		}

	}

	// 通过 ftp 方式，将 errordata 下所有文件移动(剪切)到服务器
	private void upladErrordata() throws Exception {
		EnvConFigConfig envConFigConfig = entityVo.getEnvConFigConfig();

		FtpClient ftp = FtpClient.get(entityVo.getEnvConFigConfig().getServerDataIP().getServer_data_IP());
		// 服务器路劲
		String server_errordata = envConFigConfig.getMainPath().getServer_dlog_path() + EntityVo.ErrorData
				+ File.separator;
		Log.info("服务器地址" + server_errordata);
	//	MainWindow.setUilog("服务器地址" + server_errordata);

		Log.info("判断路径是否存在");
	//	MainWindow.setUilog("判断路径是否存在");
		ftp.doAction(new FtpClient.IAction() {
			@Override
			public void doAction(FtpClient ftpClient) {
				// boolean errordataFile = ftp.existFile(server_errordata);
				try {
					Boolean errordataFile = ftp.existDirectory(envConFigConfig.getMainPath().getServer_dlog_path(),
							EntityVo.fulllotfile);
					// 存在
					if (!errordataFile) {
						ftp.createDirecroty(server_errordata);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
				//	MainStatus.status3();
				}

			}
		});

		// 本地
		String local_errordata = envConFigConfig.getMainPath().getLocal_dlog_path() + File.separator
				+ EntityVo.ErrorData;
		Log.info("本地路劲" + local_errordata);
	//	MainWindow.setUilog("本地路劲" + local_errordata);
		String[] fileList = new File(local_errordata).list();
		for (int i = 0; i < fileList.length; i++) {
			Log.info("文件" + fileList[i] + "开始上传");
	//		MainWindow.setUilog("文件" + fileList[i] + "开始上传");
			// 上传
			int finalI = i;
			try {
				FtpClient ftp1 = FtpClient.get(envConFigConfig.getServerDataIP().getServer_data_IP());
				ftp1.doAction(new FtpClient.IAction() {
					@Override
					public void doAction(FtpClient ftpClient) {
						try {
							ftp1.uploadFile(server_errordata, fileList[finalI],
									new File(local_errordata + File.separatorChar + fileList[finalI]),entityVo,channelHandlerContext);
						//	ProgressBarUploadView.getText("上传" + fileList[finalI] + "文件成功");
							Log.info("上传" + fileList[finalI] + "文件成功");
					//		MainWindow.setUilog("上传" + fileList[finalI] + "文件成功");
							Log.info("网络存在");
							FileUtils.delete(new File(local_errordata+File.separator+fileList[finalI]));
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage(), "错误",
									JOptionPane.ERROR_MESSAGE);
					//		MainStatus.status3();
						}

					}
				});
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
			//	MainStatus.status3();
			}
 
		}
	}


}