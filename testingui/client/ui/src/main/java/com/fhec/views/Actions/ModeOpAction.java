package com.fhec.views.Actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import com.fhec.abstracts.AbstractActionListener;
import com.fhec.clientnetty.ClientHandler;
import com.fhec.context.ConfigFilePath;
import com.fhec.context.EnvConFigConfig;
import com.fhec.context.GlobalContext;
import com.fhec.context.MesFileConfig;
import com.fhec.entity.EntityVo;
import com.fhec.ftp.FtpClient;
import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;
import com.fhec.utils.FileUtils;
import com.fhec.views.MainWindow;
import com.fhec.views.ModeSelectionDialog;
import com.fhec.views.PasswordVerifiersView;
import com.fhec.views.ProgressBarView;

import javax.swing.*;

public class ModeOpAction extends AbstractActionListener<ModeSelectionDialog> {

	public ModeOpAction(ModeSelectionDialog window) {
		super(window);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GlobalContext.UImode = "OP";
		EntityVo entityVo = new EntityVo();
		entityVo.setMode(GlobalContext.UImode);
		ClientHandler.sendmsg(entityVo);
		EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();

		// 服务器下载的路径
		String server_password_txt = envConFigConfig.getMainPath().getServer_password_path() + "password.txt";

		//本地下载的路径
		String localpath ="password";

		FtpClient ftp = FtpClient.get(envConFigConfig.getServerProgramIP().getServer_pgm_IP());
		try {

			// 判断文件服务器上文件是否存在
			Boolean existFile = ftp.doFunc(new FtpClient.IFunc() {
				@Override
				public Boolean doFunc(FtpClient ftpClient) throws Exception {
					return ftp.existFile(server_password_txt);

				}
			});

			if (!existFile) {
				JOptionPane.showConfirmDialog(null, "文件不存在", "提示",
						JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
				// 删除文件
				ExitUninstall exitUninstall = new ExitUninstall();
				exitUninstall.exitUnistall();
				// 日志
				Log.info("卸载ui，退出程序");
				System.exit(0);

			} else {
				// 进度条
				try {
					ftp.doAction(new FtpClient.IAction() {
						@Override
						public void doAction(FtpClient ftpClient) {
							try {

								ftp.downloadFile(envConFigConfig.getMainPath().getServer_password_path(),
										localpath+File.separator,  "password.txt");
								ProgressBarView.getText("下载 password.txt文件成功");
								Log.info("下载 password.txt文件成功");
								Log.info("网络存在");
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, e.getMessage(), "错误",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					});
					ConfigFilePath.PASSWORD_PATH = localpath+File.separator+"password.txt";
					GlobalContext.CreatPassWordConfig();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JPanel jPanel = new JPanel();
			JOptionPane.showConfirmDialog(jPanel, "文件下载失败!", "提示", JOptionPane.CLOSED_OPTION,
					JOptionPane.WARNING_MESSAGE);
			MainStatus.status1();

		}
		boolean isOk = PasswordVerifiersView.Show();
		if (isOk) {
			window.dispose();
			Log.info("选择为op模式");
			MainWindow.setUilog("选择为op模式");
		}

	}

}
