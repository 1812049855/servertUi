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
import com.fhec.views.Actions.OpDownCancelAction;
import com.fhec.views.Actions.OpDownLoadAction;

public class OPDownloadView extends JDialog {
	private final JPanel panel = new JPanel();
	private final JTextField txtCustomer = new JTextField();
	private final JTextField txtProgramName = new JTextField();
	private final JTextField txtModeCode = new JTextField();
	private JTextField deviceNametextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					OPDownloadView window = new OPDownloadView();
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
	public OPDownloadView() {
		initialize();
	}

	public static void Show() {
		OPDownloadView opDownloadView = new OPDownloadView();
		opDownloadView.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@Override
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			MainStatus.status1();
		}
	}

	private void initialize() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(ConfigFilePath.SWING_PATH);
		setIconImage(image);
		setModal(true);
		setBounds(100, 100, 783, 470);
		getContentPane().setLayout(null);
		panel.setBounds(0, 0, 777, 441);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Customer ID");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(168, 60, 104, 37);
		panel.add(lblNewLabel);

		txtCustomer.setBounds(320, 60, 215, 30);
		panel.add(txtCustomer);
//        txtCustomer.setText("GDT");

		txtProgramName.setBounds(320, 193, 215, 30);
		panel.add(txtProgramName);
//        txtProgramName.setText("MAS1102A1_AA_J750HD36020_F1_25_8C");

		JLabel lblProgramName = new JLabel("Program Name");
		lblProgramName.setFont(new Font("宋体", Font.PLAIN, 18));
		lblProgramName.setBounds(168, 186, 111, 37);
		panel.add(lblProgramName);

		JLabel lblModeCode = new JLabel("Mode Code");
		lblModeCode.setFont(new Font("宋体", Font.PLAIN, 18));
		lblModeCode.setBounds(168, 259, 117, 37);
		panel.add(lblModeCode);

		txtModeCode.setBounds(320, 266, 215, 30);
		panel.add(txtModeCode);
//        txtModeCode.setText("FT1");
		JButton btnDoenLoad = new JButton("DownLoad");
		btnDoenLoad.setBounds(202, 324, 111, 44);
		panel.add(btnDoenLoad);
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(374, 324, 125, 44);
		panel.add(btnCancel);

		JLabel lblDeviceName = new JLabel("Device Name");
		lblDeviceName.setFont(new Font("宋体", Font.PLAIN, 18));
		lblDeviceName.setBounds(168, 119, 111, 37);
		panel.add(lblDeviceName);

		deviceNametextField = new JTextField();
		deviceNametextField.setBounds(320, 126, 215, 30);
		panel.add(deviceNametextField);
		setResizable(false);
		setLocationRelativeTo(null);

		btnDoenLoad.addActionListener(new OpDownLoadAction(this));
		btnCancel.addActionListener(new OpDownCancelAction(this));
	}

	public String getProgramName() {
		return txtProgramName.getText();

	}

	public String getCustomerId() {
		return txtCustomer.getText();

	}

	public String getModeCode() {
		return txtModeCode.getText();

	}

	public String getDeviceName() {
		return deviceNametextField.getText();

	}
}
