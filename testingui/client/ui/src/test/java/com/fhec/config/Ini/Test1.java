package com.fhec.config.Ini;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Test1 extends JDialog {
	private JPanel contentPane;
	private JTable table;
	private String head[] = null;
	private Object[][] data = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Test1 frame = new Test1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test1() {
		setResizable(false);

		setTitle("\u673A\u7968\u9884\u8BA2\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		Dimension us = this.getSize();
		Dimension them = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (them.width - us.width) / 2;
		int y = (them.height - us.height) / 2;

		this.setLocation(x, y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 700, 250);

		table = new JTable();

		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		head = new String[] { "id", "姓名", "密码", "性别", "年龄", "住址", "\u7968\u4EF7", };

		DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(tableModel);

		scrollPane.setViewportView(table);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
						.addGap(66)));
		contentPane.setLayout(gl_contentPane);

	}

	// 生成表格数据
	/**
	 * @return
	 */
	public Object[][] queryData() {
		List<String> list = new ArrayList<String>();
		data = new Object[list.size()][head.length];

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < head.length; j++) {
				/*
				 * data[i][0]=list.get(i).getId(); data[i][1]=list.get(i).getName();
				 * data[i][2]=list.get(i).getPassword(); data[i][3]=list.get(i).getSex();
				 * data[i][4]=list.get(i).getAge(); data[i][5]=list.get(i).getAddress();
				 */
			}
		}
		return data;
	}

}
