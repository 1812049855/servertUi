package com.fhec.views;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import com.fhec.context.ConfigFilePath;
import com.fhec.context.GlobalContext;
import com.fhec.views.Actions.BtnStartLotAction;
import com.fhec.views.Actions.ExitAction;
import com.fhec.views.Actions.FullEndLotAction;
import com.fhec.views.Actions.SaveTestResultAction;

public class MainWindow extends JDialog {
	private static final int MIN_PROGRESS = 0;
	private static final int MAX_PROGRESS = 100;
	public static int currentProgress = MIN_PROGRESS;
	private static JLabel progresstxt = new JLabel();

	static JPasswordField passwd = new JPasswordField(10);

	private static final JTextArea txtHtml1 = new JTextArea();

	private static final JButton btnStartLot = new JButton("Start Lot");

	private static final JButton btnSaveResult = new JButton("Save Test Result");

	private static final JButton btnEndLot = new JButton("Full End Lot");

	private static final JButton btnExit = new JButton("Exit");

	private static final JLabel lblLoGo = new JLabel("");

	private static final JTextArea txtHtml2 = new JTextArea();

	private static final JTextArea txtHtml3 = new JTextArea();

	private static final JTextArea txtHtml4 = new JTextArea();

	private static final JTextArea txtHtml5 = new JTextArea();

	private static final JTextArea txtHtml6 = new JTextArea();

	private static final JTextArea txtHtml7 = new JTextArea();

	private static final JTextArea txtHtml8 = new JTextArea();

	private static final JTextArea txtHtml9 = new JTextArea();

	private static final JTextArea txtHtml10 = new JTextArea();

	private static final JTextArea txtHtml11 = new JTextArea();

	private static final JTextArea txtHtml12 = new JTextArea();

	private static final JTextArea txtHtml13 = new JTextArea();

	private static final JTextArea txtHtml14 = new JTextArea();

	private static final JTextArea txtHtml15 = new JTextArea();

	private static final JTextArea txtHtml16 = new JTextArea();

	public static JLabel lblNewLabel = new JLabel();
	public static JLabel lblIndexTimems = new JLabel();

	public static final JTextArea txtrUiOperationLog = new JTextArea();
	private static  final JTextArea textLotInfo = new JTextArea();

	private final JPanel panel_4 = new JPanel();
	private static final JLabel savetestlable = new JLabel();
	private static List<JTextArea> textAreaList;
	private static JProgressBar progressBar = new JProgressBar();

	static {
		if (textAreaList == null) {
			textAreaList = new ArrayList<>();
		}
		textAreaList.add(txtHtml1);
		textAreaList.add(txtHtml2);
		textAreaList.add(txtHtml3);
		textAreaList.add(txtHtml4);
		textAreaList.add(txtHtml5);
		textAreaList.add(txtHtml6);
		textAreaList.add(txtHtml7);
		textAreaList.add(txtHtml8);
		textAreaList.add(txtHtml9);
		textAreaList.add(txtHtml10);
		textAreaList.add(txtHtml11);
		textAreaList.add(txtHtml12);
		textAreaList.add(txtHtml13);
		textAreaList.add(txtHtml14);
		textAreaList.add(txtHtml15);
		textAreaList.add(txtHtml16);
	}

	/**
	 * 静态赋值
	 *
	 * @return
	 */
	public static List<JTextArea> getTextArea() {

		return textAreaList;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// 设置本属性将改变窗口边框样式定义

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	protected void processWindowEvent(WindowEvent e) {
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
		} else {
			super.processWindowEvent(e);
		}

	}

	private boolean ok;

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public static Boolean Show() {
		MainWindow mainWindow = new MainWindow();
		mainWindow.setVisible(true);
		return mainWindow.isOk();
	}

	/**
	 * Create the application.
	 */
	public MainWindow(Dialog owner) {
		super(owner, false);
		textLotInfo.setBounds(1, 1, 548, 248);
		textLotInfo.setColumns(10);
		initialize();
	}

	public MainWindow() {
		textLotInfo.setBounds(1, 1, 548, 248);
		textLotInfo.setColumns(10);
		initialize();
	}

	public static void Show(Dialog owner, Thread thread) {
		MainWindow mainWindow = new MainWindow(owner);
		thread.start();
		mainWindow.setVisible(true);
	}

	public static void setProgressTxt(String text) {
		progresstxt.setText(text);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 1143, 789);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1137, 203);
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		JLabel lblLabel = new JLabel("XXX");
		lblLabel.setFont(new java.awt.Font("宋体", 1, 0));

		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 4, 0, 0));

		btnStartLot.setFont(new Font("微软雅黑", Font.PLAIN, 28));
		panel_7.add(btnStartLot);

		panel_7.add(btnSaveResult);
		btnSaveResult.setEnabled(false);
		btnSaveResult.setFont(new Font("微软雅黑", Font.PLAIN, 28));
		btnEndLot.setFont(new Font("微软雅黑", Font.PLAIN, 28));
		panel_7.add(btnEndLot);
		btnEndLot.setEnabled(false);

		btnExit.setFont(new Font("微软雅黑", Font.PLAIN, 28));
		panel_7.add(btnExit);

		JPanel panel = new JPanel();
		panel.setBounds(0, 204, 1137, 292);
		getContentPane().add(panel);

		// LOGOTU 图片

		ImageIcon icon = new ImageIcon(GlobalContext.getFileLocker().readBytes());
		panel.setLayout(null);
		lblLoGo.setBounds(0, 0, 567, 250);
		lblLoGo.setIcon(icon);
		panel.add(lblLoGo);
		textLotInfo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textLotInfo.setEditable(false);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(ConfigFilePath.SWING_PATH);
		setIconImage(image);
		panel.add(textLotInfo);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 541, 1137, 219);
		getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		// 添加滚动条
		textLotInfo.setLineWrap(true);// 设置bai自动换行，之后则不需要du设置水zhi平滚动条

		JScrollPane scrolltextLotInfo = new JScrollPane(textLotInfo);
		scrolltextLotInfo.setBounds(569, 0, 567, 235);
		scrolltextLotInfo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrolltextLotInfo);

		lblNewLabel.setText("Tets Time(ms):");

		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel.setBounds(577, 237, 300, 36);
		panel.add(lblNewLabel);

		lblIndexTimems.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblIndexTimems.setBounds(877, 237,300, 36);
		lblIndexTimems.setText("Index Time(ms):");
		panel.add(lblIndexTimems);

		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		txtHtml1.setBounds(1, 0, 133, 45);
		txtHtml1.setEditable(false);
		txtHtml1.setOpaque(false);
		txtHtml2.setBounds(144, 0, 133, 45);

		txtHtml2.setEditable(false);
		txtHtml2.setEditable(false);
		txtHtml2.setOpaque(false);
		txtHtml3.setBounds(287, 0, 133, 45);

		txtHtml3.setLineWrap(true);
		txtHtml3.setEditable(false);
		txtHtml3.setOpaque(false);
		txtHtml4.setBounds(430, 0, 133, 45);

		txtHtml4.setLineWrap(true);
		txtHtml4.setEditable(false);
		txtHtml4.setOpaque(false);
		txtHtml5.setBounds(573, 0, 133, 45);

		txtHtml5.setLineWrap(true);
		txtHtml5.setEditable(false);
		txtHtml5.setOpaque(false);
		txtHtml6.setBounds(716, 0, 133, 45);

		txtHtml6.setLineWrap(true);
		txtHtml6.setEditable(false);
		txtHtml6.setOpaque(false);
		txtHtml7.setBounds(859, 0, 133, 45);

		txtHtml7.setLineWrap(true);
		txtHtml7.setEditable(false);
		txtHtml7.setOpaque(false);
		txtHtml8.setBounds(1002, 0, 133, 45);

		txtHtml8.setLineWrap(true);
		txtHtml8.setEditable(false);
		txtHtml8.setOpaque(false);
		txtHtml9.setBounds(1, 55, 133, 45);

		txtHtml9.setLineWrap(true);
		txtHtml9.setEditable(false);
		txtHtml9.setOpaque(false);
		txtHtml10.setBounds(144, 55, 133, 45);

		txtHtml10.setLineWrap(true);
		txtHtml10.setEditable(false);
		txtHtml10.setOpaque(false);
		txtHtml11.setBounds(287, 55, 133, 45);

		txtHtml11.setLineWrap(true);
		txtHtml11.setEditable(false);
		txtHtml11.setOpaque(false);
		txtHtml12.setBounds(430, 55, 133, 45);

		txtHtml12.setLineWrap(true);
		txtHtml12.setEditable(false);
		txtHtml12.setOpaque(false);
		txtHtml13.setBounds(573, 55, 133, 45);

		txtHtml13.setLineWrap(true);
		txtHtml13.setEditable(false);
		txtHtml13.setOpaque(false);
		txtHtml14.setBounds(716, 55, 133, 45);

		txtHtml14.setLineWrap(true);
		txtHtml14.setEditable(false);
		txtHtml14.setOpaque(false);
		txtHtml15.setBounds(859, 55, 133, 45);

		txtHtml15.setLineWrap(true);
		txtHtml15.setEditable(false);
		txtHtml15.setOpaque(false);
		txtHtml16.setBounds(1002, 55, 133, 45);

		txtHtml16.setLineWrap(true);
		txtHtml16.setEditable(false);
		txtHtml16.setOpaque(false);
		panel_6.setLayout(null);

		panel_6.add(txtHtml1);
		panel_6.add(txtHtml2);
		panel_6.add(txtHtml3);
		panel_6.add(txtHtml4);
		panel_6.add(txtHtml5);
		panel_6.add(txtHtml6);
		panel_6.add(txtHtml7);
		panel_6.add(txtHtml8);
		panel_6.add(txtHtml9);
		panel_6.add(txtHtml10);
		panel_6.add(txtHtml11);
		panel_6.add(txtHtml12);
		panel_6.add(txtHtml13);

		panel_6.add(txtHtml14);
		panel_6.add(txtHtml15);
		panel_6.add(txtHtml16);

		JPanel panel_2 = new JPanel();
		panel_3.add(panel_2);
		txtrUiOperationLog.setBounds(1, 1, 1118, 120);
		DefaultCaret caret = (DefaultCaret)txtrUiOperationLog.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		txtrUiOperationLog.setTabSize(4);

		txtrUiOperationLog.setFont(new Font("Monospaced", Font.PLAIN, 19));
		txtrUiOperationLog.append("UI operation log\n");
		panel_2.setLayout(null);
		txtrUiOperationLog.setEditable(false);
		panel_2.add(txtrUiOperationLog);

		// 添加滚动条
		txtrUiOperationLog.setLineWrap(true);// 设置bai自动换行，之后则不需要du设置水zhi平滚动条

		//添加进度条
		addJprogressBar();
	    progress(false);

		JScrollPane scroll = new JScrollPane(txtrUiOperationLog);
		scroll.setBounds(0, 0, 1137, 101);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(360, 100));

		panel_2.add(scroll);

		btnSaveResult.setEnabled(false);
		btnEndLot.setEnabled(false);

		panel_1.add(panel_4);
		panel_4.setLayout(null);
		savetestlable.setFont(new Font("黑体", Font.PLAIN, 38));
		savetestlable.setBounds(10, 10, 1117, 105);

		panel_4.add(savetestlable);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 517, 1137, 27);
		getContentPane().add(panel_5);
		progresstxt.setFont(new Font("宋体", Font.PLAIN, 15));

		panel_5.add(progresstxt);

		// start lot事件
		btnStartLot.addActionListener(new BtnStartLotAction(this));

		// saveTestResult 监听
		btnSaveResult.addActionListener(new SaveTestResultAction(this));

		// full end lot监听
		btnEndLot.addActionListener(new FullEndLotAction(this));

		// 关闭程序监听事件
		btnExit.addActionListener(new ExitAction(this));

	}

	// uilog日志显示
	public static void setUilog(String uilog) {
		txtrUiOperationLog.append(uilog + "\n");
		txtrUiOperationLog.setFont(new java.awt.Font("黑体", 0, 13));

	}

	// 提示显示
	public static void setSavetest(String savettestresult) {
		savetestlable.setText(savettestresult);

	}

	// lotinfo显示为文本框
	public static void setTextAreaLotInfo(String information) {
		textLotInfo.setText(null);
		textLotInfo.setText(information);

	}

	// 结束时间显示
	public static void setIndexTime(Date date) {
		lblIndexTimems.setText("Index Time(ms):" + date.getTime());

	}

	// 拿到按钮设置按钮状态 start
	public static JButton getStartLot() {
		return btnStartLot;

	}

	public static void getText(String text) {
		progresstxt.setText(text);

	}

	// saveTestResult
	public static JButton getBtnSaveResult() {
		return btnSaveResult;
	}

	// EndLot
	public static JButton getBtnEndLot() {
		return btnEndLot;
	}

	// exit
	public static JButton getBtnExit() {
		return btnExit;
	}

	//添加进度条
	public   void addJprogressBar() {

		// 添加到内容面板
		getContentPane().add(progressBar);
		// 设置进度的 最小值 和 最大值
		progressBar.setMinimum(MIN_PROGRESS);
		progressBar.setMaximum(MAX_PROGRESS);
		progressBar.setBounds(0, 495, 1137, 20);
		progressBar.setPreferredSize(new Dimension(700, 20));
		// 设置当前进度值
		progressBar.setValue(currentProgress);

		// 绘制百分比文本（进度条中间显示的百分数）
		progressBar.setStringPainted(true);
	}
	// 进度条/显示隐藏
	public static void progress(boolean toggle) {
			progresstxt.setVisible(toggle);
			progressBar.setVisible(toggle);

	}
	/**
	 *
	 * @param size 文件总大小
	 * @param now  已读取文件大小
	 */
	public static void redJProgressBar(long size,long now) {
		float c1=(float)now/size*100;
		progressBar.setValue((int)c1);
		 if(progressBar.getValue()==100||size==now) progressBar.setValue(0);

	}

	public static int getProgressBarVal() {

		return progressBar.getValue();
	}
	/*
	 * // jpenal public void removejPanelview(JProgressBar jProgressBar) {
	 * jPanelview.remove(jProgressBar); getContentPane().remove(jPanelview);
	 * validate();// 重构内容面板 repaint();// 重绘内容面 }
	 */
}
