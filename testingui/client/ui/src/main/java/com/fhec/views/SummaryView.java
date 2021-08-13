package com.fhec.views;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.fhec.bin.Bin;
import com.fhec.bin.Site;
import com.fhec.context.ConfigFilePath;
import com.fhec.driver.TeradyneDriverInit;
import com.fhec.driver.TeradyneEvent;
import com.fhec.views.GridControl.Column;

public class SummaryView extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static SummaryView summaryView = null;
	public static JTabbedPane tabbedPane = new JTabbedPane();

	/**
	 * Launch the application.
	 */
	public static SummaryView getSummaryView() {
		if (summaryView == null) {
			summaryView = new SummaryView();
			summaryView.setVisible(true);
//			//启动刷新线程
//			new Thread(new ReFSummary()).start();
			System.out.println("new SummaryView");
		}
		return summaryView;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					SummaryView window = new SummaryView();
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
	public SummaryView() {
		initialize();
		 
	}
 
    @Override
     protected void processWindowEvent(WindowEvent e) {
    	    // 直接返回，阻止默认动作，阻止窗口关闭
			if (e.getID() == WindowEvent.WINDOW_CLOSING)
				return;
			// 该语句会执行窗口事件的默认动作(如：隐藏)
			super.processWindowEvent(e); 
     }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(ConfigFilePath.SWING_PATH);
		setIconImage(image);
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		Component[] components = tabbedPane.getComponents();
		for (Component component : components) {
			if (component != null) {
				tabbedPane.remove(component);
			}
		}
		// 创建第 1 个选项卡（选项卡只包含 标题）
		// 图片
		tabbedPane.addTab("All Devices",
				allDevices(TeradyneDriverInit.gridcontrol, TeradyneEvent.MaxSite, TeradyneDriverInit.getHardBinSites()));
		tabbedPane.addTab("Latest100Devices", Latest100Devices(TeradyneDriverInit.gridcontrol, TeradyneEvent.MaxSite,
				TeradyneDriverInit.getLast100()));

//        // 创建第 2 个选项卡（选项卡包含 标题 和 图标）
//        tabbedPane.addTab("Latest Devices", createTextPanel2());
//
//        // 创建第 3 个选项卡（选项卡包含 标题、图标 和 tip提示）
//        tabbedPane.addTab("Current Device", createTextPanel3());

		// 设置默认选中的选项卡
		tabbedPane.setSelectedIndex(0);

		setContentPane(tabbedPane);
		setVisible(true);
	}

	public static class ob {
		public String Site1;

		public String getSite1() {
			return Site1;
		}

		public void setSite1(String site1) {
			this.Site1 = site1;
		}

	}

	public static void addrow() {

	}

	/**
	 * 
	 * @param maxsite
	 * @param list    实时site数据
	 * @return
	 */
	public static JComponent Latest100Devices(GridControl[] gridcontrol, int maxsite, List<Site> list) {
		if (list == null)
			list = new ArrayList<>();

		// 创建面板, 使用一个 1 行 1 列的网格布局（为了让标签的宽高自动撑满面板）
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		List<Column> columns = new ArrayList<Column>();
		columns.add(new Column("", ""));
		columns.add(new Column("Total", "Total"));
		for (int i = 1; i <= maxsite; i++) {
			columns.add(new Column("Site" + i, "Site" + i));
		}

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		List<Column> columns2 = new ArrayList<Column>();
		columns2.add(new Column("BinID", "BinID"));
		columns2.add(new Column("Total", "Total"));
		for (int j = 1; j <= maxsite; j++) {
			columns2.add(new Column("Site" + j, "siteno"));
		}
		Object[] totallist = new Object[maxsite + 2];
		Object[] passtotal = new Object[maxsite + 2];
		Object[] Failtotal = new Object[maxsite + 2];
		Object[] yieldtotal = new Object[maxsite + 2];
		if (list != null) {
			List<Object> datas2 = new ArrayList<>();
			Map<String, Map<String, Object>> sitemap = new HashMap<>();
			Map<String, Map<String, Object>> softbinsitemap = new HashMap<>();
			Map<String, Object> binmap = null;
			Map<String, Object> softbinmap = null;
			totallist[0] = "Tested";
			passtotal[0] = "Pass";
			Failtotal[0] = "Fail";
			yieldtotal[0] = "Yield";
			for (int j = 0; j < list.size(); j++) {
				Site site = list.get(j);
				if(site!=null) {
					int siteno = site.getSiteno();
					totallist[siteno + 2] = site.getTotal();
					passtotal[siteno + 2] = site.getPass();
					Failtotal[siteno + 2] = site.getFail();
					if (site.getTotal() == 0) {
						yieldtotal[siteno + 2] = "0%";
					} else {
						float yield = (float) site.getPass() / site.getTotal() * 100;
						DecimalFormat df = new DecimalFormat("0.00");// 格式化小数，不足的补0
						String filesize = df.format(yield);// 返回的是String类型的
						yieldtotal[siteno + 2] = filesize + "%";
					}

					List<Bin> bin = site.getBin();
					binmap = new HashMap<>();
					softbinmap = new HashMap<>();
					for (int k = 0; k < bin.size(); k++) {
						Bin bi = bin.get(k);
						if(bi==null)  
							continue;
						 
						String no = bi.getHardbinno();
						int softbinno = bi.getSoftbinno();
						softbinmap.put(String.valueOf(softbinno), bi.getTotal());
						binmap.put(no, bi.getTotal());
					}
					datas2.add(site);
					sitemap.put("site" + (siteno + 1), binmap);
					softbinsitemap.put("site" + (siteno + 1), softbinmap);
					
				}
				
					
				
			}

			List<String> allbinno = TeradyneDriverInit.getAllHardBinno();
			List<Object[]> ls = new ArrayList<>();
			for (int j = 0; j < allbinno.size(); j++) {
				Object[] rowbin = new Object[maxsite + 2];
				rowbin[0] = Integer.parseInt(allbinno.get(j));
				int totolsum = 0;
				for (int k = 0; k < rowbin.length; k++) {
					if (k == 0 || k == 1)
						continue;
					Map<String, Object> map = sitemap.get("site" + (k - 1));
					if (map != null) {
						if (map.get(allbinno.get(j)) != null) {
							int bintotal = Integer.parseInt(map.get(allbinno.get(j)).toString());
							rowbin[k] = bintotal;
							totolsum += bintotal;
						}
					}

				}
				rowbin[1] = totolsum;
				ls.add(rowbin);
			}
			List<Object[]> softbinls = new ArrayList<>();
			List<Integer> allsoftbinno = TeradyneDriverInit.getAllsoftbinno();
			for (int j = 0; j < allsoftbinno.size(); j++) { 
				Object[] softrowbin = new Object[maxsite + 2];
				softrowbin[0] = allsoftbinno.get(j);
				int totolsum = 0;
				for (int k = 0; k < softrowbin.length; k++) {
					if (k == 0 || k == 1)
						continue;
					Map<String, Object> softmap = softbinsitemap.get("site" + (k - 1));
					if (softmap != null) {
						if (softmap.get(allsoftbinno.get(j).toString()) != null) {
							int bintotal = Integer.parseInt(softmap.get(allsoftbinno.get(j).toString()).toString());
							softrowbin[k] = bintotal;
							totolsum += bintotal;
						}
					}

				}
				softrowbin[1] = totolsum;
				softbinls.add(softrowbin);
			}
			int size = ls.size();
			Object[][] rowvalues = new Object[size][];

			for (int j = 0; j < ls.size(); j++) {
				rowvalues[j] = ls.get(j);
			}
			int softbinsize = softbinls.size();
			Object[][] softrowvalues = new Object[softbinsize][];
			
			for (int j = 0; j < softbinls.size(); j++) {
				softrowvalues[j] = softbinls.get(j);
			}
			
				if (gridcontrol[3] == null) {
					gridcontrol[3] = new GridControl(columns2, datas2, rowvalues);
					gridcontrol[3].setVisible(true);
					panel_2.add(gridcontrol[3]);
				} else {
						gridcontrol[3].SetData(rowvalues);
				}
				
				if (gridcontrol[5] == null) {
					gridcontrol[5] = new GridControl(columns2, null, softrowvalues);
					gridcontrol[5].setVisible(true);
					panel_2.add(gridcontrol[5]);
				} else {
					gridcontrol[5].SetData(softrowvalues);

				}

		}

		int totalsum = 0;
		int passsum = 0;
		int failsum = 0;
		for (int i = 2; i < maxsite + 2; i++) {
			totalsum += totallist[i] == null ? 0 : (int) totallist[i];
			passsum += passtotal[i] == null ? 0 : (int) passtotal[i];
			failsum += Failtotal[i] == null ? 0 : (int) Failtotal[i];

		}
		totallist[1] = totalsum;
		passtotal[1] = passsum;
		Failtotal[1] = failsum;
		if (totalsum > 0) {
			float yield = (float) passsum / totalsum * 100;
			DecimalFormat df = new DecimalFormat("0.00");// 格式化小数，不足的补0
			String filesize = df.format(yield);// 返回的是String类型的
			yieldtotal[1] = filesize + "%";
		}
		Object[][] objvals = new Object[][] { totallist, passtotal, Failtotal, yieldtotal };
		if (gridcontrol[2] == null) {
			gridcontrol[2] = new GridControl(columns, null, objvals);
			gridcontrol[2].setVisible(true);
			panel_1.add(gridcontrol[2]);
		} else {
			gridcontrol[2].SetData(objvals);
		}

		return panel;
	}

	public static JComponent allDevices(GridControl[] gridcontrol, int maxsite, List<Site> list) {
		if (list == null) {
			list = new ArrayList<>();
		}
		// 创建面板, 使用一个 1 行 1 列的网格布局（为了让标签的宽高自动撑满面板）
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		List<Column> columns = new ArrayList<Column>();
		columns.add(new Column("", ""));
		columns.add(new Column("Total", "Total"));

		for (int i = 1; i <= maxsite; i++) {
			columns.add(new Column("Site" + i, "Site" + i));
		}

		JPanel panel_2 = new JPanel();

		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		panel.add(panel_2);
		List<Column> columns2 = new ArrayList<Column>();
		columns2.add(new Column("BinID", "BinID"));
		columns2.add(new Column("Total", "Total"));
		for (int j = 1; j <= maxsite; j++) {
			columns2.add(new Column("Site" + j, "siteno"));
		}

		Object[] totallist = new Object[maxsite + 2];
		Object[] passtotal = new Object[maxsite + 2];
		Object[] Failtotal = new Object[maxsite + 2];
		Object[] yieldtotal = new Object[maxsite + 2];
		Map<String, Map<String, Object>> hardbinsitemap = new HashMap<>();
		Map<String, Object> hardbinmap = null;
		Map<String, Map<String, Object>> softbinsitemap = new HashMap<>();
		Map<String, Object> softbinmap = null;
		totallist[0] = "Tested";
		passtotal[0] = "Pass";
		Failtotal[0] = "Fail";
		yieldtotal[0] = "Yield";
		for (int j = 0; j < list.size(); j++) {
			Site site = list.get(j);
			if(site!=null) {
				int siteno = site.getSiteno();
					totallist[siteno + 2] = site.getTotal();
					passtotal[siteno + 2] = site.getPass();
					Failtotal[siteno + 2] = site.getFail();
					if (site.getTotal() == 0) {
						yieldtotal[siteno + 2] = "0%";
					} else {
						float yield = (float) site.getPass() / site.getTotal() * 100;
						DecimalFormat df = new DecimalFormat("0.00");// 格式化小数，不足的补0
						String filesize = df.format(yield);// 返回的是String类型的
						yieldtotal[siteno + 2] = filesize + "%";
					}
					List<Bin> bin = site.getBin();
					hardbinmap = new HashMap<>();
					softbinmap = new HashMap<>();
					for (int k = 0; k < bin.size(); k++) {
						Bin bi = bin.get(k);
						if(bi==null)  
							continue;
						String no = bi.getHardbinno();
						int softbinno = bi.getSoftbinno();
						hardbinmap.put(no, bi.getTotal());
						softbinmap.put(String.valueOf(softbinno), bi.getTotal());
					}
					hardbinsitemap.put("site" + (siteno + 1), hardbinmap);
					softbinsitemap.put("site" + (siteno + 1), softbinmap);
				 
			}
			

			
		}

		List<Object[]> hardbinls = new ArrayList<>();
		List<Object[]> softbinls = new ArrayList<>();
		List<String> allhardbinno = TeradyneDriverInit.getAllHardBinno();
		List<Integer> allsoftbinno = TeradyneDriverInit.getAllsoftbinno();
		for (int j = 0; j < allhardbinno.size(); j++) {
			Object[] hardrowbin = new Object[maxsite + 2]; 
			hardrowbin[0] = Integer.parseInt(allhardbinno.get(j));
			int totolsum = 0;
			for (int k = 0; k < hardrowbin.length; k++) {
				if (k == 0 || k == 1)
					continue;
				Map<String, Object> hardmap = hardbinsitemap.get("site" + (k - 1));
				if (hardmap != null) {
					if (hardmap.get(allhardbinno.get(j)) != null) {
						int bintotal = Integer.parseInt(hardmap.get(allhardbinno.get(j)).toString());
						hardrowbin[k] = bintotal;
						totolsum += bintotal;
					}
				}

			}
			hardrowbin[1] = totolsum;
			hardbinls.add(hardrowbin);
		}
		
		for (int j = 0; j < allsoftbinno.size(); j++) { 
			Object[] softrowbin = new Object[maxsite + 2];
			softrowbin[0] = allsoftbinno.get(j);
			int totolsum = 0;
			for (int k = 0; k < softrowbin.length; k++) {
				if (k == 0 || k == 1)
					continue;
				Map<String, Object> softmap = softbinsitemap.get("site" + (k - 1));
				if (softmap != null) {
					if (softmap.get(allsoftbinno.get(j).toString()) != null) {
						int bintotal = Integer.parseInt(softmap.get(allsoftbinno.get(j).toString()).toString());
						softrowbin[k] = bintotal;
						totolsum += bintotal;
					}
				}

			}
			softrowbin[1] = totolsum;
			softbinls.add(softrowbin);
		}

		int hardbinsize = hardbinls.size();
		Object[][] hardrowvalues = new Object[hardbinsize][];
		
		int softbinsize = softbinls.size();
		Object[][] softrowvalues = new Object[softbinsize][];

		for (int j = 0; j < hardbinls.size(); j++) {
			hardrowvalues[j] = hardbinls.get(j);
		}
		for (int j = 0; j < softbinls.size(); j++) {
			softrowvalues[j] = softbinls.get(j);
		}

//		}
		if (gridcontrol[1] == null) {
			gridcontrol[1] = new GridControl(columns2, null, hardrowvalues);
			gridcontrol[1].setVisible(true);
			panel_2.add(gridcontrol[1]);
		} else {
			gridcontrol[1].SetData(hardrowvalues);

		}
		
		
		if (gridcontrol[4] == null) {
			gridcontrol[4] = new GridControl(columns2, null, softrowvalues);
			gridcontrol[4].setVisible(true);
			panel_2.add(gridcontrol[4]);
		} else {
			gridcontrol[4].SetData(softrowvalues);

		}
		
		int totalsum = 0;
		int passsum = 0;
		int failsum = 0;
		for (int i = 2; i < maxsite + 2; i++) {
			totalsum += totallist[i] == null ? 0 : (int) totallist[i];
			passsum += passtotal[i] == null ? 0 : (int) passtotal[i];
			failsum += Failtotal[i] == null ? 0 : (int) Failtotal[i];

		}
		totallist[1] = totalsum;
		passtotal[1] = passsum;
		Failtotal[1] = failsum;
		if (totalsum > 0) {
			float yield = (float) passsum / totalsum * 100;
			DecimalFormat df = new DecimalFormat("0.00");// 格式化小数，不足的补0
			String filesize = df.format(yield);// 返回的是String类型的
			yieldtotal[1] = filesize + "%";
		}
		Object[][] objvals = new Object[][] { totallist, passtotal, Failtotal, yieldtotal };
		if (gridcontrol[0] == null) {
			gridcontrol[0] = new GridControl(columns, null, objvals);
			gridcontrol[0].setVisible(true);
			panel_1.add(gridcontrol[0]);
		} else {
			gridcontrol[0].SetData(objvals);
		}

		return panel;
	}

	 

}
