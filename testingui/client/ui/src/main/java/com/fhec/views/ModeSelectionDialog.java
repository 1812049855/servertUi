package com.fhec.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.fhec.context.ConfigFilePath;
import com.fhec.mainstatus.MainStatus;
import com.fhec.views.Actions.ModeMesAction;
import com.fhec.views.Actions.ModeOpAction;

public class ModeSelectionDialog extends JDialog {

	private final JButton btnMes = new JButton("MES");
	private final JButton btnOperator = new JButton("Operator");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ModeSelectionDialog dialog = new ModeSelectionDialog();
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModeSelectionDialog() {
		initialize();
	}

	public static void Close() {
		ModeSelectionDialog modeSelectionDialog = new ModeSelectionDialog();
		modeSelectionDialog.dispose();

	}

	@Override
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			MainStatus.status1();
			System.exit(0);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setModal(true);
		setTitle("Mode Selector");
		setBounds(100, 100, 550, 343);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(ConfigFilePath.SWING_PATH);
		setIconImage(image);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 534, 304);
		getContentPane().add(panel);
		panel.setLayout(null);
		btnMes.setFont(new Font("宋体", Font.PLAIN, 27));
		btnMes.setBounds(280, 104, 163, 75);
		panel.add(btnMes);
		btnOperator.setFont(new Font("宋体", Font.PLAIN, 25));
		btnOperator.setBounds(80, 104, 163, 75);
		panel.add(btnOperator);

		// mes监听
		btnMes.addActionListener(new ModeMesAction(this));
		// op监听
		btnOperator.addActionListener(new ModeOpAction(this));
	}
}
