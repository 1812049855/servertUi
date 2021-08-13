package com.fhec.ftp;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.fhec.context.ConfigFilePath;
import com.fhec.ftp.FtpClient.IAction;
import com.fhec.mainstatus.MainStatus;

public class FtpClientTest extends JDialog {
	private static final int MIN_PROGRESS = 0;
	private static final int MAX_PROGRESS = 100;

	private static int currentProgress = MIN_PROGRESS;

	public static void main(String[] args) {
		// 设置本属性将改变窗口边框样式定义

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FtpClientTest window = new FtpClientTest();
					window.test();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FtpClientTest() {
		initialize();
	}

	public static void Show() {
		FtpClientTest uploadUI = new FtpClientTest();
		uploadUI.setVisible(true);
	}

	@Override
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			MainStatus.status1();
		}
	}

	public void upload() {
		try {
			// FtpClient ftpClient = FtpClient.get("119.3.2.204");
			FtpClient ftpClient = FtpClient.get("172.16.200.31");

			File file = new File("D:\\datalog\\datalog_name_rule_1\\SingleFile");
			String name = "/datalog_name_rule_1/SingleFile";
			String[] list = file.list();
			for (String s : list) {
				ftpClient.doAction(new IAction() {

					@Override
					public void doAction(FtpClient ftpClient) {
						try {
							ftpClient.uploadFile(name, s,
									new File("D:\\datalog\\datalog_name_rule_1\\SingleFile"+File.separator+s));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});


			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void download() {
		try {
			FtpClient ftpClient = FtpClient.get("172.16.204.114");

			ftpClient.doAction(new IAction() {

				@Override
				public void doAction(FtpClient ftpClient) {
					String pathname = "/meslog/GDT2037F011.001.002";

					try {
						ftpClient.downloadFile(pathname, "F:\\", "GDT2037F011.001.002_FT1.mes");
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println(11);
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test() {
		try {
			// FtpClient ftpClient = FtpClient.create("119.3.2.204", "hzkj",
			// "hz.sdysg.9527.001", 21, 0);
			FtpClient ftpClient = FtpClient.create("172.16.200.31", "user", "user", 21, 1);
			ftpClient.doAction(new IAction() {

				@Override
				public void doAction(FtpClient ftpClient){

					System.out.println(11);
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(ConfigFilePath.SWING_PATH);
		setIconImage(image);
		setBounds(80, 80, 800, 100);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 932, 72);
		getContentPane().add(panel);
		setLocationRelativeTo(null);
		// 创建一个进度条
		final JProgressBar progressBar = new JProgressBar();

		// 设置进度的 最小值 和 最大值

		progressBar.setMinimum(MIN_PROGRESS);
		progressBar.setMaximum(MAX_PROGRESS);

		// 设置当前进度值
		progressBar.setValue(currentProgress);

		// 绘制百分比文本（进度条中间显示的百分数）
		progressBar.setStringPainted(true);

		// 添加进度改变通知
		progressBar.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println(
						"当前进度值: " + progressBar.getValue() + "; " + "进度百分比: " + progressBar.getPercentComplete());
			}
		});

		// 添加到内容面板
		panel.add(progressBar);

		setContentPane(panel);
		setVisible(true);
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					FtpClient ftp = FtpClient.create("119.3.2.204", "hzkj", "hz.sdysg.9527.001", 21, 1);
					ftp.doAction(new FtpClient.IAction() {
						@Override
						public void doAction(FtpClient ftpClient){
							upload();
							currentProgress = ftp.getUploadWatcher().getPercent();
							if (currentProgress > MAX_PROGRESS) {
								currentProgress = MIN_PROGRESS;
							}
							progressBar.setValue(currentProgress);
						}
					});

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		thread.start();

	}

}

/*
 * FtpClient ftp = FtpClient.create("119.3.2.204", "hzkj","hz.sdysg.9527.001",
 * 21);
 *
 */
