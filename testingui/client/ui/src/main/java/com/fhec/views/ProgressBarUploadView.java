package com.fhec.views;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.fhec.context.ConfigFilePath;
import com.fhec.context.EnvConFigConfig;
import com.fhec.context.GlobalContext;
import com.fhec.ftp.FtpClient;
import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;

public class ProgressBarUploadView extends JDialog {
	private static final int MIN_PROGRESS = 0;
	private static final int MAX_PROGRESS = 100;

	public static int currentProgress = MIN_PROGRESS;
	private  static JLabel jLabel = new JLabel();

	public static void main(String[] args) {
		// 设置本属性将改变窗口边框样式定义

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ProgressBarUploadView window = new ProgressBarUploadView(null);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProgressBarUploadView(Dialog owner) {
		super(owner, false);
		initialize();
	}

	public static void Show(Dialog owner, Thread thread) {
		ProgressBarUploadView progressBarView = new ProgressBarUploadView(owner);
		thread.start();
		progressBarView.setVisible(true);
	}

	@Override
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			MainStatus.status1();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setModal(true);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(ConfigFilePath.SWING_PATH);
		setIconImage(image);
		setBounds(800, 800, 850, 100);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		setLocationRelativeTo(null);
		// 创建一个进度条
		final JProgressBar progressBar = new JProgressBar();
		// 设置进度的 最小值 和 最大值
		progressBar.setMinimum(MIN_PROGRESS);
		progressBar.setMaximum(MAX_PROGRESS);
		progressBar.setPreferredSize(new Dimension(700,20));

		// 设置当前进度值
		progressBar.setValue(currentProgress);

		// 绘制百分比文本（进度条中间显示的百分数）
		progressBar.setStringPainted(true);

		// 添加进度改变通知
		progressBar.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				Log.info("当前进度值: " + progressBar.getValue() + "; " + "进度百分比: " + progressBar.getPercentComplete());
			}
		});

		// 添加到内容面板
		panel.add(progressBar);
		setContentPane(panel);
		jLabel.setBounds(177, 44, 584, 15);
		panel.add(jLabel);
		// 模拟延时操作进度, 每隔 0.5 秒更新进度
		EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
		FtpClient ftp = FtpClient.get(envConFigConfig.getServerDataIP().getServer_data_IP());
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				do {

					currentProgress = ftp.getUploadWatcher().getPercent();
					if (currentProgress > MAX_PROGRESS) {
						currentProgress = MIN_PROGRESS;
					}

					progressBar.setValue(currentProgress);

				} while (!ftp.getUploadWatcher().isFinished());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {

				}
				setVisible(false);
				ftp.getUploadWatcher().reset();
			}
		});
		thread.start();
	}

	public static  void  getText(String text){
		jLabel.setText(text);

	}

	public static void  string(String text){
		jLabel.setText("正在上传"+text+"文件");
	}
}
