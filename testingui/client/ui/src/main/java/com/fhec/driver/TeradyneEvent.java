package com.fhec.driver;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JTextArea;

import com.fhec.bin.Bin;
import com.fhec.bin.EQPresult;
import com.fhec.bin.Site;
import com.fhec.entity.EntityVo;
import com.fhec.refreshsummary.ReFSummary;
import com.fhec.views.MainWindow;

public class TeradyneEvent {
	public static Integer MaxSite = 0;
	public static boolean runflag = false;
	public static String stdffilepath = null;
	public static String stdffilefolder = null;
	public static String csvfile;
	public static String prostattime = null;
	public static String proendtime = null;
	public static Integer goodqty = 0;
	public static Integer failqty = 0;

	public static void TsCompletes(String fileName) {
		/**
		 * 以行为单位读取文件，常用于读面向行的格式化文件
		 */
		BufferedReader br = null;

		try {
			// 一次读入一行，直到读入null为文件结束
			while (true) {
				if("end".equals(EntityVo.endTest)) break;
				FileReader fr = new FileReader(fileName);
				br = new BufferedReader(fr);
				String line = "";
				String[] arrs = null;
				while ((line = br.readLine()) != null) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (line.isEmpty())
						continue;
					arrs = line.split(",");
					System.out.println(arrs[0] + " : " + arrs[1] + " : " + arrs[2]+ " : " + arrs[3]);
				
						System.out.println(arrs.length
								+ "==========~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~========" + line);
						String bin = arrs[0];
						int sort = Integer.parseInt(arrs[1]);
						int result = Integer.parseInt(arrs[2]);
						int site = Integer.parseInt(arrs[3]);
						List<JTextArea> jtext = MainWindow.getTextArea();
						for (int i = 0; i < MaxSite; i++) {
							jtext.get(i).setOpaque(true);
							if (i == site) {
								if (result != -1) {
									Site st = new Site();
									st.setSiteno(i);
									st.setResult(result);
									Bin bn = new Bin();
									bn.setHardbinno(bin);
									bn.setSoftbinno(sort);
									bn.setResult(result);
									TeradyneDriverInit.setAllHardBinno(bin, result);
									TeradyneDriverInit.setAllsoftbinno(sort, result);
									TeradyneDriverInit.setHardBinSites(st, bn);
									jtext.get(i).setText("Site" + (i + 1));
									jtext.get(i).append("\n" + bin + "/" + sort);
								}

								if (result == 1) {
									jtext.get(i).setBackground(Color.GREEN);
								} else if (result == 2) {
									jtext.get(i).setBackground(Color.RED);
								} else if (result == -1) {
									jtext.get(i).setBackground(Color.GRAY);
									jtext.get(i).setText("Site" + (i + 1));
									jtext.get(i).append("\n" + "HB" + "/" + "SB");
								}
							}
							Thread thread = new Thread(new ReFSummary());
							thread.start();
						}
						if (result != -1) {
							EQPresult req = new EQPresult(bin, site, result, sort);
							TeradyneDriverInit.setList100device(req, MaxSite);
						}
					
				}
				br.close();
				fr.close();

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e1) {
				}
			}
		}
	}

}
