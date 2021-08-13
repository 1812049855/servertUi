package com.fhec.views.Actions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.commons.lang3.StringUtils;

import com.fhec.context.ConfigFilePath;
import com.fhec.context.EnvConFigConfig;
import com.fhec.context.GlobalContext;
import com.fhec.context.LastContext;
import com.fhec.context.MesFileConfig;
import com.fhec.context.Temporary;
import com.fhec.encode.EnCode;
import com.fhec.ftp.FtpClient;
import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;
import com.fhec.utils.FileUtils;
import com.fhec.views.MESDownloadView;
import com.fhec.views.MainWindow;
import com.fhec.views.ProgressBarView;

public class MesFileAction {
	private MESDownloadView window;
	private MainWindow mainWindow;

	public MesFileAction(MESDownloadView window, MainWindow mainWindow) {
		this.window = window;
		this.mainWindow = mainWindow;
	}

	// MESfile下载检查
	public boolean mesCheckFile() throws Exception {
		window.dispose();
		EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();

		// MES文件分割内容
		String sub_lotNo = MESDownloadView.getSub_LotNo().trim();
		String modeCode = MESDownloadView.getModeCode().trim();
		// QA切FT报错
		if(Temporary.last_modecode.contains("QA")&&modeCode.contains("FT")) {
			JOptionPane.showConfirmDialog(null, "current program and last program is not match !", "提示",
					JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			ExitUninstall exitUninstall = new ExitUninstall();
			exitUninstall.exitUnistall();
			// 日志
			Log.info("current program and last program is not match  卸载ui，退出程序");
			System.exit(0);
		}
		Temporary.last_modecode=MESDownloadView.getModeCode().trim();
		// 服务器下载的路劲
		String mespath = sub_lotNo + File.separator + sub_lotNo + "_" + modeCode + ".mes";

		//
		String local = envConFigConfig.getMainPath().getLocal_dlog_path()+sub_lotNo + File.separator;
		// 本地文件路径
		String localpath = envConFigConfig.getMainPath().getLocal_dlog_path() + mespath;
		File file = new File(localpath);
		FtpClient ftp = FtpClient.get(envConFigConfig.getServerProgramIP().getServer_pgm_IP());

		try {

			// 服务器文件地址路径
			String loda = envConFigConfig.getMainPath().getServer_mes_path() + mespath;
			System.out.println(loda);
			// 判断文件服务器上文件是否存在
			Boolean existFile = ftp.doFunc(new FtpClient.IFunc() {
				@Override
				public Boolean doFunc(FtpClient ftpClient) throws Exception {
					return ftp.existFile(loda);
					// return
					// ftp.existFile("/meslog/GDT2037F011.001.002/GDT2037F011.001.002_FT1.mes");
				}
			});

			if (!existFile) {
				JOptionPane.showConfirmDialog(null, "alarm M02:mesfile is not exist in server,please call PTE !", "提示",
						JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
				if (EnvConFigConfig.uninstall.equals(envConFigConfig.getAlarmControLFlag().getAlarm_M02_flag())) {
					// 删除文件
					ExitUninstall exitUninstall = new ExitUninstall();
					exitUninstall.exitUnistall();
					// 日志
					Log.info("M02=1，卸载ui，退出程序");
					System.exit(0);
				} else if (EnvConFigConfig.recover.equals(envConFigConfig.getAlarmControLFlag().getAlarm_M02_flag())) {
					Log.info("M02=0，关闭窗体，返回主界面");
					this.window.setuiLog("M02=0，关闭窗体返回主界面");
					this.window.dispose();
					MainStatus.status1();
				}
				return false;
			} else {

				// 判断文件是否存在 存在不创建 不存在创建文件夹
				FileUtils.CreateFolder(localpath.substring(0, localpath.lastIndexOf(File.separator)));
				Log.info("文件服务器上文件存在");

				// 删除本地文件
				FileUtils.delete(file);
				String sublotMode = sub_lotNo + "_" + modeCode + ".mes";

				// 进度条
				try {
					ftp.doAction(new FtpClient.IAction() {
						@Override
						public void doAction(FtpClient ftpClient) {
							try { 
								
								ftp.downloadFile(envConFigConfig.getMainPath().getServer_mes_path() + sub_lotNo,
										local, sublotMode);
								ProgressBarView.getText("下载" + sublotMode + "文件成功");
								Log.info("下载" + sublotMode + "文件成功");
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
				}
 
				// UI 获取 mes file 中内容
				// 读取的文件内容
				ConfigFilePath.MESFILE_PATH = local + File.separator + sub_lotNo + "_" + modeCode + ".mes";
				System.out.println(ConfigFilePath.MESFILE_PATH);
				GlobalContext.CreatMesFileConfig();
				Log.info("开始" + ConfigFilePath.MESFILE_PATH + "初始化");
				MesFileConfig mesFileConfig = GlobalContext.getMesFileConfig();

				// last 信息写入
				writeToProperties();

				Log.info("last 信息写入成功");
				this.window.setuiLog("last 信息写入成功");

				// UI 检查 mes file
				// 判断文件服务器上文件是否存在
				String ziploda = envConFigConfig.getMainPath().getServer_prog_path() + mesFileConfig.getZipfile_Name();

				// 判断文件服务器上文件是否存在
				Boolean existzipfile = ftp.doFunc(new FtpClient.IFunc() {
					@Override
					public Boolean doFunc(FtpClient ftpClient) throws Exception {
						return ftp.existFile(ziploda);
					}
				});
				if (!existzipfile) {
					Log.info("压缩包不存在");
					JOptionPane.showConfirmDialog(null,
							"alarm M05:program file is not exist in server,please call PTE !", "提示",
							JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
					if (EnvConFigConfig.uninstall.equals(envConFigConfig.getAlarmControLFlag().getAlarm_M05_flag())) {
						// 删除本地文件
						ExitUninstall exitUninstall = new ExitUninstall();
						exitUninstall.exitUnistall();
						Log.info("M05 = 1，卸载ui，退出程序");
						System.exit(0);
					} else if (EnvConFigConfig.recover
							.equals(envConFigConfig.getAlarmControLFlag().getAlarm_M05_flag())) {
						Log.info("M05 = 0，关闭窗体返回主界面");
						this.window.setuiLog("M05 = 0，关闭窗体返回主界面");
						this.window.dispose();
						MainStatus.status1();
					}
					return false;
				} else {
					if (!modeCode.equals(mesFileConfig.getMode_Code())) {
						Log.info("程序下载输入界面中的 modecode 与程序下载输入界面modecode不一致");
						JOptionPane.showConfirmDialog(null,
								"alarm  :mesfile modecode check fail，please call MFG leader !", "提示",
								JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
						if (EnvConFigConfig.uninstall
								.equals(envConFigConfig.getAlarmControLFlag().getAlarm_M06_flag())) {
							// 删除本地文件
							ExitUninstall exitUninstall = new ExitUninstall();
							exitUninstall.exitUnistall();
							Log.info(" M06 = 1，卸载ui，退出程序");
							System.exit(0);
						} else if (EnvConFigConfig.recover
								.equals(envConFigConfig.getAlarmControLFlag().getAlarm_M06_flag())) {
							Log.info(" M06 = 0，关闭窗体返回主界面");
							this.window.setuiLog("M06 = 0，关闭窗体返回主界面");
							this.window.dispose();
							MainStatus.status1();
						}
						return false;
					}
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JPanel jPanel = new JPanel();
			JOptionPane.showConfirmDialog(jPanel, "文件下载失败!", "提示", JOptionPane.CLOSED_OPTION,
					JOptionPane.WARNING_MESSAGE);
			MainStatus.status1();
			return false;

		}
		return true;
	}

	// 定义last信息
	public void writeToProperties() {
		MesFileConfig mesFileConfig = GlobalContext.getMesFileConfig();
		String modeCode = this.window.getModeCode();

		// 1.先实例化一个Properties对象
		Properties properties = new Properties();
		try {

			// 2.创建一个输出流对象,选择正确的目标文件路径(注意:该配置文件放在src目录下)
			FileOutputStream fos = new FileOutputStream("last/last.properties");

			// 引入Writer,可以明确该输出流的字符集,确保写入配置文件的中文编码正确
			OutputStreamWriter opw = new OutputStreamWriter(fos, EnCode.enCode);

			// 3.将需要写入的属性内容通过set方法,存入properties对象中
			if (StringUtils.isNotEmpty(mesFileConfig.getProgram_Name())) {
				properties.setProperty(LastContext.LAST_PROGRAMNAME, mesFileConfig.getProgram_Name());
			}
			if (mesFileConfig.getProgram_Folder() != null) {
				properties.setProperty(LastContext.LAST_PROGFOLDER, mesFileConfig.getProgram_Folder());
			}
			if (mesFileConfig.getTest_Flow() != null) {
				properties.setProperty(LastContext.LAST_TESTFLOW, mesFileConfig.getTest_Flow());
			}
			if (mesFileConfig.getTesterOS_Version() != null) {
				properties.setProperty(LastContext.LAST_TESTEROS, mesFileConfig.getTesterOS_Version());
			}
			if (modeCode != null) {
				properties.setProperty(LastContext.LAST_MODECODE, modeCode);
			}
			if (mesFileConfig.getZipfile_Name() != null) {
				properties.setProperty(LastContext.LAST_ZIPFILE, mesFileConfig.getZipfile_Name());
			}
			if (mesFileConfig.getDevice_Name() != null) {
				properties.setProperty(LastContext.LAST_DEVICE_NAME, mesFileConfig.getDevice_Name());
			}
			properties.setProperty(LastContext.LAST_TESTCODE, "");

			properties.setProperty(LastContext.LAST_PROGRAM_NAME, "");

			// 4.调用properties的存储方法
			properties.store(opw, "测试用数据");

			// 实例化last 中内容
			ConfigFilePath.LAST_PATH = "last\\last.properties";
			GlobalContext.CreatLastConfig();
			// 5.关闭资源
			fos.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
		}
	}

}
