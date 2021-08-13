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
import com.fhec.context.GlobalContext;
import com.fhec.mainstatus.MainStatus;
import com.fhec.views.Actions.PasswordCancelAction;
import com.fhec.views.Actions.PasswordOkAction;

public class PasswordVerifiersView extends JDialog {
	private final JButton btnOK = new JButton("OK");
	private final JButton btnCancel = new JButton("Cancel");
	private final JTextField txtrFsefwef = new JTextField();

	private boolean ok;

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public static boolean Show() {
		PasswordVerifiersView passwordVerifiersView = new PasswordVerifiersView();
		passwordVerifiersView.setVisible(true);
		return passwordVerifiersView.isOk();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PasswordVerifiersView window = new PasswordVerifiersView();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private PasswordVerifiersView() {
		initialize();
	}

	@Override
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			GlobalContext.UImode = null;
			MainStatus.status1();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(ConfigFilePath.SWING_PATH);
		setIconImage(image);
		setTitle("Simple Operator  Intefacer");
		setModal(true);
		setBounds(100, 100, 676, 504);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 673, 474);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Please input  Custrmer ID");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(132, 73, 257, 46);
		panel.add(lblNewLabel);

		btnOK.setBounds(164, 215, 101, 36);
		panel.add(btnOK);

		btnCancel.setBounds(351, 214, 101, 38);
		panel.add(btnCancel);

		txtrFsefwef.setBounds(132, 129, 349, 36);
		panel.add(txtrFsefwef);

		JLabel lblPassword = new JLabel("please input Mode Password !");
		lblPassword.setFont(new Font("宋体", Font.PLAIN, 18));
		lblPassword.setBounds(10, 10, 275, 29);
		panel.add(lblPassword);
		setResizable(false);
		setLocationRelativeTo(null);

		// 点击op模式 弹出框 点击ok判断密码
		btnOK.addActionListener(new PasswordOkAction(this));
		// 点击Cancel
		btnCancel.addActionListener(new PasswordCancelAction(this));
	}

	public String getText() {
		return txtrFsefwef.getText();
	}

}
