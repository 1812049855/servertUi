
package com.fhec.config.Ini;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.fhec.style.BeautyEye;
import com.fhec.views.GridControl.Column;

public class TestSummary3 extends BeautyEye {
	private static JTable table;
	private static JTable table_1;
	private static JTable table_2;

	private static String head[] = null;
	private static Object[][] data = null;

	public static void main(String[] args) {
		JFrame jf = new JFrame("测试窗口");
		jf.setSize(1000, 800);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);

		// 创建选项卡面板
		final JTabbedPane tabbedPane = new JTabbedPane();

		// 创建第 1 个选项卡（选项卡只包含 标题）
		tabbedPane.addTab("All Devices", createTextPanel());

		// 创建第 2 个选项卡（选项卡包含 标题 和 图标）
		tabbedPane.addTab("Latest Devices", createTextPanel2());

		// 创建第 3 个选项卡（选项卡包含 标题、图标 和 tip提示）
		tabbedPane.addTab("Current Device", createTextPanel3());

		// 添加选项卡选中状态改变的监听器

		tabbedPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("当前选中的选项卡: " + tabbedPane.getSelectedIndex());
			}
		});

		// 设置默认选中的选项卡
		tabbedPane.setSelectedIndex(1);

		jf.setContentPane(tabbedPane);
		jf.setVisible(true);
	}

	/**
	 * 创建一个面板，面板中心显示一个标签，用于表示某个选项卡需要显示的内容
	 */

	public static class TestSummary {
		private String BinID;
		private String Total;
		private String Site1;
		private String Site2;
		private String Site3;
		private String Site4;

		public String getBinID() {
			return BinID;
		}

		public void setBinID(String binID) {
			BinID = binID;
		}

		public String getTotal() {
			return Total;
		}

		public void setTotal(String total) {
			Total = total;
		}

		public String getSite1() {
			return Site1;
		}

		public void setSite1(String site1) {
			Site1 = site1;
		}

		public String getSite2() {
			return Site2;
		}

		public void setSite2(String sitev2) {
			Site2 = sitev2;
		}

		public String getSite3() {
			return Site3;
		}

		public void setSite3(String site3) {
			Site3 = site3;
		}

		public String getSite4() {
			return Site4;
		}

		public void setSite4(String site4) {
			Site4 = site4;
		}

		public TestSummary(String binID, String total, String site1, String site2, String site3, String site4) {
			BinID = binID;
			Total = total;
			Site1 = site1;
			Site2 = site2;
			Site3 = site3;
			Site4 = site4;
		}
	}

	/**
	 * 第一个选项卡
	 * 
	 * @return
	 */

	private static JComponent createTextPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		List<Column> columns = new ArrayList<Column>();
		columns.add(new Column("", "BinID"));
		columns.add(new Column("Total", "Total"));
		columns.add(new Column("Site1", "Site1"));
		columns.add(new Column("Site2", "Site2"));
		columns.add(new Column("Site3", "Site3"));
		columns.add(new Column("Site4", "Site4"));
		columns.add(new Column("Site5", "Site5"));
		columns.add(new Column("Site6", "Site6"));
		columns.add(new Column("Site7", "Site7"));
		columns.add(new Column("Site8", "Site8"));
		columns.add(new Column("Site9", "Site9"));
		columns.add(new Column("Site10", "Site10"));
		columns.add(new Column("Site11", "Site11"));
		columns.add(new Column("Site12", "Site12"));
		columns.add(new Column("Site13", "Site13"));
		columns.add(new Column("Site14", "Site14"));
		columns.add(new Column("Site15", "Site15"));
		columns.add(new Column("Site16", "Site16"));
		columns.add(new Column("Site17", "Site17"));
		columns.add(new Column("Site18", "Site18"));
		List<Object> datas = new ArrayList<>();
		// GridControl gridControl = new GridControl(columns, datas);
		/*
		 * gridControl.AddRow(new TestSummary("1", "1", "1", "1", "1", "1"));
		 * gridControl.AddRow(new TestSummary("1", "1", "1", "1", "1", "1"));
		 * gridControl.AddRow(new TestSummary("1", "1", "1", "1", "1", "1"));
		 * gridControl.AddRow(new TestSummary("1", "1", "1", "1", "1", "1"));
		 * gridControl.AddRow(new TestSummary("1", "1", "1", "1", "1", "1"));
		 * gridControl.AddRow(new TestSummary("1", "1", "1", "1", "1", "1"));
		 * gridControl.setVisible(true); panel_1.add(gridControl);
		 */

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		List<Column> columns2 = new ArrayList<Column>();
		columns2.add(new Column("BinID", "BinID"));
		columns2.add(new Column("Total", "Total"));
		columns2.add(new Column("Site1", "Site1"));
		columns2.add(new Column("Site2", "Site2"));
		columns2.add(new Column("Site3", "Site3"));
		columns2.add(new Column("Site4", "Site4"));
		List<Object> datas2 = new ArrayList<Object>();
		// GridControl gridControl2 = new GridControl(columns2, datas2);
		/*
		 * gridControl2.setVisible(true); panel_2.add(gridControl2);
		 */

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		List<Column> columns3 = new ArrayList<Column>();
		columns3.add(new Column("BinID", "BinID"));
		columns3.add(new Column("Total", "Total"));
		columns3.add(new Column("Site1", "Site1"));
		columns3.add(new Column("Site2", "Site2"));
		columns3.add(new Column("Site3", "Site3"));
		columns3.add(new Column("Site4", "Site4"));
		List<Object> datas3 = new ArrayList<Object>();
		// GridControl gridControl3 = new GridControl(columns3, datas3);
		/*
		 * gridControl3.setVisible(true); panel_3.add(gridControl3);
		 */

		return panel;
	}

	/**
	 * 第二个选项卡
	 *
	 * @param text
	 * @return
	 */

	private static JComponent createTextPanel2() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		List<Column> columns = new ArrayList<Column>();
		columns.add(new Column("", "BinID"));
		columns.add(new Column("Total", "Total"));
		columns.add(new Column("Site1", "Site1"));
		columns.add(new Column("Site2", "Site2"));
		columns.add(new Column("Site3", "Site3"));
		columns.add(new Column("Site4", "Site4"));
		List<Object> datas = new ArrayList<Object>();
		/*
		 * GridControl gridControl = new GridControl(columns, datas);
		 * gridControl.setVisible(true); panel_1.add(gridControl);
		 */
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		List<Column> columns2 = new ArrayList<Column>();
		columns2.add(new Column("BinID", "BinID"));
		columns2.add(new Column("Total", "Total"));
		columns2.add(new Column("Site1", "Site1"));
		columns2.add(new Column("Site2", "Site2"));
		columns2.add(new Column("Site3", "Site3"));
		columns2.add(new Column("Site4", "Site4"));
		List<Object> datas2 = new ArrayList<Object>();
		/*
		 * GridControl gridControl2 = new GridControl(columns2, datas2);
		 * gridControl2.setVisible(true); panel_2.add(gridControl2);
		 */
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		List<Column> columns3 = new ArrayList<Column>();
		columns3.add(new Column("BinID", "BinID"));
		columns3.add(new Column("Total", "Total"));
		columns3.add(new Column("Site1", "Site1"));
		columns3.add(new Column("Site2", "Site2"));
		columns3.add(new Column("Site3", "Site3"));
		columns3.add(new Column("Site4", "Site4"));
		List<Object> datas3 = new ArrayList<Object>();
		/*
		 * GridControl gridControl3 = new GridControl(columns3, datas3);
		 * gridControl3.setVisible(true); panel_3.add(gridControl3);
		 */

		return panel;
	}

	/**
	 * 第三个选项卡
	 *
	 * @param text
	 * @return
	 */

	private static JComponent createTextPanel3() {
		// 创建面板, 使用一个 1 行 1 列的网格布局（为了让标签的宽高自动撑满面板）
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		List<Column> columns = new ArrayList<Column>();
		columns.add(new Column("test#", "test#"));
		columns.add(new Column("TestName", "TestName"));
		columns.add(new Column("Low Limit", "Low Limit"));
		columns.add(new Column("High Limit", "High Limit"));
		columns.add(new Column("Unit", "Unit"));
		columns.add(new Column("Site1", "Site1"));
		columns.add(new Column("Site2", "Site2"));
		columns.add(new Column("Site3", "Site3"));
		columns.add(new Column("Site4", "Site4"));
		/*
		 * List<Object> datas = new ArrayList<Object>(); GridControl gridControl = new
		 * GridControl(columns, datas); gridControl.setVisible(true);
		 * panel_1.add(gridControl);
		 */
		return panel;
	}

}
