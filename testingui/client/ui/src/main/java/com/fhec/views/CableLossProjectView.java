package com.fhec.views;

import com.fhec.context.ConfigFilePath;
import com.fhec.mainstatus.MainStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class CableLossProjectView extends JDialog{

	private final JTextField txeCable = new JTextField();
	private  final JPanel panel_1 = new JPanel();
	private  final  JTextField textField = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CableLossProjectView window = new CableLossProjectView();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void Show() {
		CableLossProjectView cableLossProjectView = new CableLossProjectView();
		cableLossProjectView.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public CableLossProjectView() {
		initialize();
	}

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
		setBounds(100, 100, 621, 454);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 615, 425);
		getContentPane().add(panel);
		panel.setLayout(null);
		setLocationRelativeTo(null);

		txeCable.setEditable(false);
		txeCable.setFont(new Font("宋体", Font.PLAIN, 19));
		txeCable.setText("cable loss project interface");
		txeCable.setBounds(34, 22, 349, 36);
		panel.add(txeCable);
		txeCable.setColumns(10);

		panel_1.setBounds(10, 90, 552, 247);
		panel.add(panel_1);
		panel_1.setLayout(null);

		textField.setBounds(28, 10, 496, 227);
		panel_1.add(textField);
		textField.setColumns(10);
	}
}
