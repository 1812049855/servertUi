package com.fhec.views;

import com.fhec.context.ConfigFilePath;
import com.fhec.mainstatus.MainStatus;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowEvent;

public class AutoView extends JDialog{
	private final JTextField txtAutoOffsetProject =  new JTextField();

	private final JButton btnNewButton = new JButton("KGU number list");

	private final JButton btnCreateOffset = new JButton("create offset");

	private final JButton btnCreateTest = new JButton("Test");

	private final JButton btnCreateCompare = new JButton("Compare");

	private final JButton btnCreateClear = new JButton("Clear all");

	private final JButton btnCreateCurrent = new JButton("Clear current");

	private final JButton btnCreateConfirm = new JButton("confirm");

	private final JButton btnCheckOffset = new JButton("check offset");

	private final JButton btnCheckTest = new JButton("Test");

	private final JButton btnCheckCompare = new JButton("Compare");

	private final JButton btnCheckClear = new JButton("Clear all");

	private final JButton btnCheckCurrent = new JButton("Clear current");

	private final JButton btnCheckConfirm = new JButton("confirm");

	private final JButton btnSaveOffset = new JButton("save offset");

	private final JTextField txtList =  new JTextField();

	private final  JTable table  = new JTable();


	
	public static void main(String[] args) {
		//设置本属性将改变窗口边框样式定义
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutoView window = new AutoView();
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
	public AutoView() {
		initialize();
	}
	public static void Show() {
		AutoView autoView = new AutoView();
		autoView.setVisible(true);
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
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(ConfigFilePath.SWING_PATH);
		setIconImage(image);
		setModal(true);
		setBounds(100, 100, 958, 582);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 932, 72);
		getContentPane().add(panel);
		panel.setLayout(null);
		setLocationRelativeTo(null);

		txtAutoOffsetProject.setFont(new Font("宋体", Font.PLAIN, 16));
		txtAutoOffsetProject.setText("Auto offset project interface");
		txtAutoOffsetProject.setEditable(false);
		txtAutoOffsetProject.setBounds(262, 10, 363, 35);
		panel.add(txtAutoOffsetProject);
		txtAutoOffsetProject.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 71, 932, 193);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		

		btnNewButton.setBounds(20, 10, 123, 30);
		panel_1.add(btnNewButton);
		

		btnCreateOffset.setBounds(20, 50, 123, 30);
		panel_1.add(btnCreateOffset);

		btnCreateTest.setBounds(163, 50, 123, 30);
		panel_1.add(btnCreateTest);

		btnCreateCompare.setBounds(308, 50, 123, 30);
		panel_1.add(btnCreateCompare);

		btnCreateClear.setBounds(453, 50, 123, 30);
		panel_1.add(btnCreateClear);

		btnCreateCurrent.setBounds(596, 50, 123, 30);
		panel_1.add(btnCreateCurrent);

		btnCreateConfirm.setBounds(744, 50, 123, 30);
		panel_1.add(btnCreateConfirm);

		btnCheckOffset.setBounds(20, 90, 123, 30);
		panel_1.add(btnCheckOffset);

		btnCheckTest.setBounds(163, 90, 123, 30);
		panel_1.add(btnCheckTest);

		btnCheckCompare.setBounds(308, 90, 123, 30);
		panel_1.add(btnCheckCompare);

		btnCheckClear.setBounds(453, 90, 123, 30);
		panel_1.add(btnCheckClear);

		btnCheckCurrent.setBounds(596, 90, 123, 30);
		panel_1.add(btnCheckCurrent);

		btnCheckConfirm.setBounds(744, 90, 123, 30);
		panel_1.add(btnCheckConfirm);

		btnSaveOffset.setBounds(20, 128, 123, 30);
		panel_1.add(btnSaveOffset);

		txtList.setBounds(163, 15, 123, 25);
		panel_1.add(txtList);
		txtList.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 261, 932, 292);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		

		table.setModel(new DefaultTableModel(
			new Object[][] {
				{ "site", "KGU", "test number", "test number", "test number", "test number", "test number"}
			},
			new String[] {
				"site", "KGU", "test number", "test number", "test number", "test number", "test number"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(85);
		table.getColumnModel().getColumn(4).setPreferredWidth(87);
		table.getColumnModel().getColumn(5).setPreferredWidth(99);
		table.getColumnModel().getColumn(6).setPreferredWidth(92);
		table.setBounds(24, 10, 883, 180);
		panel_2.add(table);
		
	}
}
