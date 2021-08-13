package com.fhec.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.fhec.context.ConfigFilePath;
import com.fhec.mainstatus.MainStatus;
import com.fhec.views.Actions.MesAction;
import com.fhec.views.Actions.MesDownCancelAction;

public class MESDownloadView extends JDialog {
	private final JPanel panel = new JPanel();
	private static final JTextField txtSub_LotNo = new JTextField();
	private static final JTextField txtModeCode = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MESDownloadView window = new MESDownloadView();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private boolean ok;

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	private MainWindow window;

	public static boolean Show() {
		MESDownloadView mesDownloadView = new MESDownloadView();
		mesDownloadView.setVisible(true);
		return mesDownloadView.isOk();
	}

	public MESDownloadView(MainWindow window) {
		this.window = window;
		initialize();
	}

	public void setuiLog(String uilog) {
		MainWindow.setUilog(uilog);

	}

	@Override
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			MainStatus.status1();
		}
	}

	/**
	 * Create the application.
	 */
	public MESDownloadView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame .
	 */
	private void initialize() {
		setModal(true);
		setBounds(100, 100, 783, 470);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		panel.setBounds(0, 0, 777, 441);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblSub_LotNo = new JLabel("Sub_LotNo");
		lblSub_LotNo.setFont(new Font("宋体", Font.PLAIN, 18));
		lblSub_LotNo.setBounds(168, 60, 104, 37);
		panel.add(lblSub_LotNo);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(ConfigFilePath.SWING_PATH);
		setIconImage(image);

		txtSub_LotNo.setBounds(320, 60, 215, 30);
		panel.add(txtSub_LotNo);

		JLabel lblModeCode = new JLabel("Mode Code");
		lblModeCode.setFont(new Font("宋体", Font.PLAIN, 18));
		lblModeCode.setBounds(168, 140, 117, 37);
		panel.add(lblModeCode);

		txtModeCode.setBounds(320, 147, 215, 30);
		panel.add(txtModeCode);

		JButton btnNewButton = new JButton("DownLoad");
		btnNewButton.setBounds(202, 336, 111, 44);
		panel.add(btnNewButton);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(374, 336, 125, 44);
		panel.add(btnCancel);

		setResizable(false);
		setLocationRelativeTo(null);

		// 监听
		btnNewButton.addActionListener(new MesAction(this, window));
		btnCancel.addActionListener(new MesDownCancelAction(this));
	}

	public static String getSub_LotNo() {
		return txtSub_LotNo.getText();
	}

	public static String getModeCode() {
		return txtModeCode.getText();
	}

	public static void setsub_LotNo() {
		txtSub_LotNo.setText("");
		txtModeCode.setText("");
	}

}
