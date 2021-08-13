package com.fhec.views.Actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import com.fhec.Thread.opDownLoadZip;
import com.fhec.abstracts.AbstractActionListener;
import com.fhec.context.ConfigFilePath;
import com.fhec.context.EnvConFigConfig;
import com.fhec.context.GlobalContext;
import com.fhec.context.LastConfig;
import com.fhec.context.LastContext;
import com.fhec.context.LocalConfig;
import com.fhec.context.Temporary;
import com.fhec.encode.EnCode;
import com.fhec.ftp.FtpClient;
import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;
import com.fhec.utils.BarCodeFileUtils;
import com.fhec.utils.FileUtils;
import com.fhec.views.MESDownloadView;
import com.fhec.views.MainWindow;
import com.fhec.views.OPDownloadView;
import com.fhec.views.ProgressBarView;

public class OpDownLoadAction extends AbstractActionListener<OPDownloadView> {

	public OpDownLoadAction(OPDownloadView window) {
		super(window);
	}

	// 方法整合
	@Override
	public void actionPerformed(ActionEvent e) {
		Temporary.opprogeamName = this.window.getProgramName().trim();
		Temporary.oprecipemodecode = this.window.getModeCode().trim();
		String modeCode = this.window.getModeCode().trim();
		Temporary.deviceNametextField = this.window.getDeviceName().trim();

		// QA切FT报错
		if (Temporary.last_modecode.contains("QA") && modeCode.contains("FT")) {
			JOptionPane.showConfirmDialog(null, "current program and last program is not match !", "提示",
					JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			ExitUninstall exitUninstall = new ExitUninstall();
			exitUninstall.exitUnistall();
			// 日志
			Log.info("current program and last program is not match  卸载ui，退出程序");
			System.exit(0);
		}
		Temporary.last_modecode = this.window.getModeCode();
		// op下载检查

		EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();

		Temporary.customerId = this.window.getCustomerId().trim();

		// 服务器下载的路径
		String server_barcode_filepath = envConFigConfig.getMainPath().getServer_prog_path() + Temporary.customerId
				+ File.separator + "BarCodeDefinition.txt";

		// 本地路径
		String local_barcode_filepath = envConFigConfig.getMainPath().getLocal_prog_path() + "BarCodeDefinition.txt";
		ConfigFilePath.BARCODEDEFINITION = local_barcode_filepath;

		try {

			// 连接服务器
			FtpClient ftp = FtpClient.get(envConFigConfig.getServerProgramIP().getServer_pgm_IP());
			// 判断文件服务器上文件是否存在
			Boolean existFile = ftp.doFunc(new FtpClient.IFunc() {
				@Override
				public Boolean doFunc(FtpClient ftpClient) {
					try {
						return ftp.existFile(server_barcode_filepath);
					} catch (Exception ex) {
						JOptionPane.showConfirmDialog(null, ex.getMessage(), "提示", JOptionPane.CLOSED_OPTION,
								JOptionPane.WARNING_MESSAGE);
						MainStatus.status1();
					}
					return null;
				}
			});

			if (!existFile) {
				JOptionPane.showConfirmDialog(null, "alarm O02:barcodefile is not exist in server,please call PTE !",
						"提示", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
				if (envConFigConfig.getAlarmControLFlag().getAlarm_O02_flag().equals(EnvConFigConfig.uninstall)) {

					// 删除文件
					ExitUninstall exitUninstall = new ExitUninstall();
					exitUninstall.exitUnistall();

					// 日志
					Log.info("O02=1，卸载ui，退出程序");
					System.exit(0);
				} else if (EnvConFigConfig.recover.equals(envConFigConfig.getAlarmControLFlag().getAlarm_O02_flag())) {
					Log.info("O02=0，关闭窗体，返回主界面");
					MainWindow.setUilog("O02=0，关闭窗体返回主界面");
					this.window.dispose();
					MainStatus.status1();
				}

			} else {

				// 存在 删除本地文件
				FileUtils.delete(new File(local_barcode_filepath));
				Log.info("删除本地文件成功");
				MainWindow.setUilog("删除本地文件成功");

				// 下载 barcodefile 到本地
				try {
					ftp.doAction(new FtpClient.IAction() {
						@Override
						public void doAction(FtpClient ftpClient) {
							try {
								ftp.downloadFile(
										envConFigConfig.getMainPath().getServer_prog_path() + Temporary.customerId,
										envConFigConfig.getMainPath().getLocal_prog_path(), "BarCodeDefinition.txt");
								ProgressBarView.getText("下载BarCodeDefinition.txt文件成功");
								Log.info("下载BarCodeDefinition.txt文件成功");
								Log.info("网络存在");
							} catch (Exception e) {
								JOptionPane.showConfirmDialog(null, e.getMessage(), "提示", JOptionPane.CLOSED_OPTION,
										JOptionPane.WARNING_MESSAGE);
								MainStatus.status1();
							}
						}
					});

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(null, e1.getMessage(), "提示", JOptionPane.CLOSED_OPTION,
							JOptionPane.WARNING_MESSAGE);
					MainStatus.status1();
				}

				// UI 获取 barcode file 中内容 #不读取
				List<String> strings = BarCodeFileUtils.readTxt(ConfigFilePath.BARCODEDEFINITION);

				// UI 检查 barcode file 内容 判断 Program_Name(pgm_program_name)是否存在于 barcode file 中
				String programName = this.window.getProgramName().trim();
				int count = 0;
				String[] split;
				for (String string : strings) {
					split = string.split(",");
					if (programName.equals(split[0].trim())) {
						count += 1;
					}
				}
				// 循环结束 没有匹配
				if (count == 0) {
					// 不存在
					JOptionPane.showConfirmDialog(null,
							"alarm O03:Program_Name is not exist in barcodefile,please call PTE !", "提示",
							JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);

					if (envConFigConfig.getAlarmControLFlag().getAlarm_O03_flag().equals(EnvConFigConfig.uninstall)) {

						// 删除文件
						ExitUninstall exitUninstall = new ExitUninstall();
						exitUninstall.exitUnistall();

						// 日志
						Log.info("O03=1，卸载ui，退出程序");
						System.exit(0);
					} else if (EnvConFigConfig.recover
							.equals(envConFigConfig.getAlarmControLFlag().getAlarm_O03_flag())) {
						Log.info("o03=0，关闭窗体，返回主界面");
						MainWindow.setUilog("o03=0，关闭窗体返回主界面");
						this.window.dispose();
						MainStatus.status1();
					}
				} else if (count > 1) {
					JOptionPane.showConfirmDialog(null,
							"alarm O04:more than one Program_Name exist in barcodefile，please call PTE !", "提示",
							JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);

					if (envConFigConfig.getAlarmControLFlag().getAlarm_O04_flag().equals(EnvConFigConfig.uninstall)) {

						// 删除文件
						ExitUninstall exitUninstall = new ExitUninstall();
						exitUninstall.exitUnistall();

						// 日志
						Log.info("O04=1，卸载ui，退出程序");
						System.exit(0);
					} else if (EnvConFigConfig.recover
							.equals(envConFigConfig.getAlarmControLFlag().getAlarm_O04_flag())) {
						Log.info("o04=0，关闭窗体，返回主界面");
						MainWindow.setUilog("o03=0，关闭窗体返回主界面");
						this.window.dispose();
						MainStatus.status1();
					}
				} else {

					// 唯一
					String zipFilename = null;
					for (int i = 0; i <= strings.size(); i++) {
						if (strings.get(i).split(",")[0].equals(programName)) {
							String[] split1 = strings.get(i).split(",");
							// 拿到压缩包的名字
							zipFilename = split1[1].trim();
							System.out.println(zipFilename + "======zipname");
							break;
						}
					}
					// 程序压缩包(barcodefile_ zipfile)存在性检查 server_zip_filepath
					String barcodefile_zipfile = envConFigConfig.getMainPath().getServer_prog_path() + zipFilename;
					System.out.println(barcodefile_zipfile + "======zippath");
					// 判断文件服务器上压缩包是否存在
					Boolean existzipfile = ftp.doFunc(new FtpClient.IFunc() {
						@Override
						public Boolean doFunc(FtpClient ftpClient) {
							try {
								return ftp.existFile(barcodefile_zipfile);
							} catch (Exception ex) {
								JOptionPane.showConfirmDialog(null, ex.getMessage(), "提示", JOptionPane.CLOSED_OPTION,
										JOptionPane.WARNING_MESSAGE);
								MainStatus.status1();

							}
							return null;
						}
					});
					if (!existzipfile) {
						Log.info("压缩包不存在");
						JOptionPane.showConfirmDialog(null,
								"alarm O05:program file is not exist in server,please call PTE !", "提示",
								JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);

						if (EnvConFigConfig.uninstall
								.equals(envConFigConfig.getAlarmControLFlag().getAlarm_O05_flag())) {
							// 删除本地文件
							ExitUninstall exitUninstall = new ExitUninstall();
							exitUninstall.exitUnistall();
							Log.info("O05 = 1，卸载ui，退出程序");
							System.exit(0);
						} else if (EnvConFigConfig.recover
								.equals(envConFigConfig.getAlarmControLFlag().getAlarm_O05_flag())) {
							Log.info("O05 = 0，关闭窗体返回主界面");
							MainWindow.setUilog("O05 = 0，关闭窗体返回主界面");
							this.window.dispose();
							MainStatus.status1();
						}

					} else {
						Log.info("压缩包存在");
						MainWindow.setUilog("压缩包存在");
						// 程序下载输入界面中的 modecode(pgm_mode_code)存在性检查 Program_Name,
						// Zipfile_Name,Program_Folder, Test_Flow, TesterOS_Version, Mode_Code
//						String modeCode = this.window.getModeCode();
						for (int i = 0; i < strings.size(); i++) {
							if (strings.get(i).trim().split(",")[0].equals(programName)) {
								String[] split1 = strings.get(i).split(",");
								// 定义last信息
								writeToProperties(split1);
								Temporary.Zipfile_Name = split1[1].trim();
								Temporary.Program_Folder = split1[2].trim();
								Temporary.test_Flow = split1[3].trim();
								Temporary.testerOS_Version = split1[4].trim();
								Temporary.opmodecode = split1[5].trim();
							}
						}
						if (Temporary.opmodecode.contains(modeCode)) {
							// baohan 进入程序下载检查 barcodefile_program 与 barcodefile_testflow 是否一致
							if (Temporary.test_Flow.contains(programName)) {
								if (programName.length() == Temporary.test_Flow.length()) {
									LocalConfig.check100 = true;
									Log.info(" barcodefile_program 与 barcodefile_testflow 一致");
									MainWindow.setUilog(" barcodefile_program 与 barcodefile_testflow 一致");
								} else if (programName.length() < Temporary.test_Flow.length()) {
									String s1 = Temporary.test_Flow.substring(0, Temporary.test_Flow.lastIndexOf("."));
									if (programName.equals(s1)) {
										LocalConfig.check100 = true;
										Log.info(" barcodefile_program 与 barcodefile_testflow 一致");
										MainWindow.setUilog(" barcodefile_program 与 barcodefile_testflow 一致");
									} else {
										LocalConfig.check100 = false;
										Log.info(" barcodefile_program 与 barcodefile_testflow不 一致");
										MainWindow.setUilog(" barcodefile_program 与 barcodefile_testflow不 一致");
									}
								}
							} else {
								LocalConfig.check100 = false;
								Log.info(" barcodefile_program 与 barcodefile_testflow不 一致");
								MainWindow.setUilog(" barcodefile_program 与 barcodefile_testflow不 一致");
							}
							// barcodefile_program 与 last_programname 是否一致
							LastConfig lastConfig = GlobalContext.getLastConfig();
							if (programName.equals(lastConfig.getLast_programname())) {
								LocalConfig.check101 = true;
								Log.info("  barcodefile_program 与 last_programname 一致");
								MainWindow.setUilog("  barcodefile_program 与 last_programname 一致");
							} else {
								LocalConfig.check101 = false;
								Log.info("  barcodefile_program 与 last_programname不 一致");
								MainWindow.setUilog(" barcodefile_program 与 last_programname不 一致");
							}

							// barcodefile_progfolder 与 last_progfolder 是否一致
							if (replaceBlank(Temporary.Program_Folder)
									.equals(lastConfig.getLast_progfolder().replace("\\\\", "\\"))) {
								LocalConfig.check102 = true;
								Log.info("  barcodefile_progfolder 与 last_progfolder  一致");
								MainWindow.setUilog("  barcodefile_progfolder 与 last_progfolder  一致");
							} else {
								LocalConfig.check102 = false;
								Log.info("  barcodefile_progfolder 与 last_progfolder 不 一致");
								MainWindow.setUilog(" barcodefile_progfolder 与 last_progfolder 不 一致");
							}

							// barcodefile_TesterOS 与 last_TesterOS 是否一致
							if (replaceBlank(Temporary.testerOS_Version).equals(lastConfig.getLast_TesterOS())) {
								LocalConfig.check103 = true;
								Log.info("  barcodefile_TesterOS 与 last_TesterOS  一致");
								MainWindow.setUilog(" barcodefile_TesterOS 与 last_TesterOS一致");
							} else {
								LocalConfig.check103 = false;
								Log.info("barcodefile_TesterOS 与 last_TesterOS不 一致");
								MainWindow.setUilog("barcodefile_TesterOS 与 last_TesterOS不 一致");
							}

							// barcodefile_ zipfile 与 last_zipfile 是否一致
							System.out.println(Temporary.Zipfile_Name);
							System.out.println(lastConfig.getLast_zipfile());
							System.out.println();
							if (replaceBlank(Temporary.Zipfile_Name)
									.equals(lastConfig.getLast_zipfile().replace("\\\\", "\\"))) {
								LocalConfig.check104 = true;
								Log.info("barcodefile_ zipfile 与 last_zipfile一致");
								MainWindow.setUilog("barcodefile_ zipfile 与 last_zipfile一致");
							} else {
								LocalConfig.check104 = false;
								Log.info("barcodefile_ zipfile 与 last_zipfile不 一致");
								MainWindow.setUilog("barcodefile_ zipfile 与 last_zipfile不 一致");
							}

							// 遍历 local_prog_path 下第一级目录 判断是否只有 1 个压缩包
							FileUtils.CreateFolder(envConFigConfig.getMainPath().getLocal_prog_path());
							String[] fileList = new File(envConFigConfig.getMainPath().getLocal_prog_path()).list();
							int resoult = 0;
							for (int i = 0; i < fileList.length; i++) {
								if (new File(envConFigConfig.getMainPath().getLocal_prog_path() + fileList[i])
										.isDirectory()) {
									continue;
								} else {
									String local_prog_path_zip = fileList[i]
											.substring(fileList[i].lastIndexOf(".") + 1);
									if ("zip".equals(local_prog_path_zip) || "tar".equals(local_prog_path_zip)
											|| "gz".equals(local_prog_path_zip)) {
										resoult += 1;
									}
								}
							}
							if (resoult <= 1) {
								LocalConfig.check105 = true;
							} else {
								LocalConfig.check105 = false;
							}

							// 执行下载程序检查 当 check100 = false 时
							if (!LocalConfig.check100) {
								Log.info(" check100 = false ");
								MainWindow.setUilog("check10 = false");
								JOptionPane.showConfirmDialog(null,
										"alarm O07:barcodefile program and testflow not match，please call PTE !", "提示",
										JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);

								// env_config 中的 alarm_O07_flag = 1
								if (EnvConFigConfig.uninstall
										.equals(envConFigConfig.getAlarmControLFlag().getAlarm_O07_flag())) {
									FileUtils.removeDir(new File(envConFigConfig.getMainPath().getLocal_prog_path()));

									Log.info("env_config 中的 alarm_O07_flag = 1,保存文件上传");
									MainWindow.setUilog("env_config 中的 alarm_O07_flag = 1，保存文件上传");
									// 保存 UI log 并上传 待做
									ExitUninstall exitUninstall = new ExitUninstall();
									exitUninstall.exitUnistall();
									System.exit(0);
								} else if (EnvConFigConfig.recover
										.equals(envConFigConfig.getAlarmControLFlag().getAlarm_O07_flag())) {
									Log.info("env_config 中的 alarm_O07_flag = 0,返回主界面");
									MainWindow.setUilog("env_config 中的 alarm_O07_flag = 0，返回主界面");
									this.window.dispose();
									MainStatus.status1();
								}
							} else {
								// 检查程序信息不一致时是否需要退出重新下载程序包(QA 切 FT 或 FT 切 FT 检查此项)
								// 当 check100 = true 且 system count > 0 且 当 pgm_mode_code 包含”FT”时
								OpDownLoadZipAction bs = new OpDownLoadZipAction(this.window);
								if (LocalConfig.check100 && LocalConfig.systemCount > 0
										&& MESDownloadView.getModeCode().contains("FT")
										|| MESDownloadView.getModeCode().contains("QA")) {
									if (LocalConfig.check101 && LocalConfig.check102 && LocalConfig.check103
											&& LocalConfig.check104 && LocalConfig.check105) {
										Log.info("check101，check102，check103，check104，check105 全部为 true");
										MainWindow.setUilog("check101，check102，check103，check104，check105 全部为 true");
										// 下载测试程序
										try {
											Thread th = new Thread(new opDownLoadZip(this.window, bs));
											th.start();
											this.window.dispose();
										} catch (Exception e1) {
											JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",
													JOptionPane.ERROR_MESSAGE);
											MainStatus.status1();

										}
									} else {
										JOptionPane.showConfirmDialog(null,
												"alarm O08:current program and last program is  not match !", "提示",
												JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);

										// 若 env_config 中的 alarm_O08_flag = 1
										if (EnvConFigConfig.uninstall
												.equals(envConFigConfig.getAlarmControLFlag().getAlarm_O08_flag())) {
											FileUtils.removeDir(
													new File(envConFigConfig.getMainPath().getLocal_prog_path()));
											Log.info("env_config 中的 alarm_O08_flag = 1,保存文件上传");
											MainWindow.setUilog("env_config 中的 alarm_O08_flag = 1，保存文件上传");
											// 保存 UI log 并上传
											ExitUninstall exitUninstall = new ExitUninstall();
											exitUninstall.exitUnistall();
											System.exit(0);
										} else if (EnvConFigConfig.recover
												.equals(envConFigConfig.getAlarmControLFlag().getAlarm_O08_flag())) {
											Log.info("env_config 中的 alarm_O08_flag = 0,返回主界面");
											MainWindow.setUilog("env_config 中的 alarm_O08_flag = 0，返回主界面");
											this.window.dispose();
											MainStatus.status1();
										}

									}
								} else if (LocalConfig.check100 && LocalConfig.systemCount == 0) {
									// check100 = true 时进入下一步
									Log.info(" check100 = true ");
									MainWindow.setUilog("check10 = true");
									// 下载测试程序
									Thread th = new Thread(new opDownLoadZip(this.window, bs));
									th.start();
									this.window.dispose();
								}
							}
						} else {
							// 不一致
							JOptionPane.showConfirmDialog(null,
									"alarm O05:program file is not exist in server,please call PTE !", "提示",
									JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);

							if (EnvConFigConfig.uninstall
									.equals(envConFigConfig.getAlarmControLFlag().getAlarm_O06_flag())) {
								// 删除本地文件
								ExitUninstall exitUninstall = new ExitUninstall();
								exitUninstall.exitUnistall();
								Log.info("O06 = 1，卸载ui，退出程序");
								System.exit(0);
							} else if (EnvConFigConfig.recover
									.equals(envConFigConfig.getAlarmControLFlag().getAlarm_O06_flag())) {
								Log.info("O06 = 0，关闭窗体返回主界面");
								MainWindow.setUilog("O06 = 0，关闭窗体返回主界面");
								this.window.dispose();
								MainStatus.status1();
							}
						}

					}
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showConfirmDialog(null, e1.getMessage(), "提示", JOptionPane.CLOSED_OPTION,
					JOptionPane.WARNING_MESSAGE);
			this.window.dispose();
			MainStatus.status1();
		}

	}

	/**
	 * 定义last信息
	 */
	private void writeToProperties(String[] split) {

		// 1.先实例化一个Properties对象
		Properties properties = new Properties();
		try {

			// 2.创建一个输出流对象,选择正确的目标文件路径(注意:该配置文件放在src目录下)
			FileOutputStream fos = new FileOutputStream("last/last.properties");

			// 引入Writer,可以明确该输出流的字符集,确保写入配置文件的中文编码正确
			OutputStreamWriter opw = new OutputStreamWriter(fos, EnCode.enCode);

			// last_programname = barcodefile_program
			if (StringUtils.isNotEmpty(split[0])) {
				properties.setProperty(LastContext.LAST_PROGRAMNAME, replaceBlank(split[0]).trim());
			}

			// last_zipfielName = barcodefile_Zipfile_Name
			if (StringUtils.isNotEmpty(split[1])) {
				properties.setProperty(LastContext.LAST_ZIPFILE, replaceBlank(split[1]).trim());
			}

			// last_progfolder = barcodefile_progfolder
			if (StringUtils.isNotEmpty(split[2])) {
				properties.setProperty(LastContext.LAST_PROGFOLDER, replaceBlank(split[2]).trim());
			}

			// last_testflow = barcodefile_testflow
			if (StringUtils.isNotEmpty(split[3])) {
				properties.setProperty(LastContext.LAST_TESTFLOW, replaceBlank(split[3]).trim());
			}

			// last_TesterOS =barcodefile_TesterOS

			if (StringUtils.isNotEmpty(split[4])) {
				properties.setProperty(LastContext.LAST_TESTEROS, replaceBlank(split[4]).trim());
			}
			// last_modecode =pgm_mode_code
			if (StringUtils.isNotEmpty(split[5])) {
				properties.setProperty(LastContext.LAST_MODECODE, this.window.getModeCode().trim());
			}

			// 4.调用properties的存储方法
			properties.store(opw, "测试用数据");

			ConfigFilePath.LAST_PATH = "last\\last.properties";
			try {
				GlobalContext.CreatLastConfig();
			} catch (Exception e) {
				e.printStackTrace();
			}

			LastConfig lastConfig = GlobalContext.getLastConfig();
			// 5.关闭资源
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String replaceBlank(String str) {
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	public static void main(String[] args) {
		String str = "3.60.20";
		String str1 = "3.60.20.";
		if (str1.contains(str)) {
			if (str.length() == str1.length()) {
				System.out.println(true);
			} else if (str.length() < str1.length()) {
				String s1 = str1.substring(0, str1.lastIndexOf("."));
				if (str.equals(s1)) {
					System.out.println("wzz");
				}
			}
		}
	}
}
