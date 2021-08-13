package com.fhec.views.Actions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JLabel;

import com.fhec.context.GlobalContext;
import com.fhec.context.LocalConfig;
import com.fhec.context.MesFileConfig;
import com.fhec.context.Temporary;
import com.fhec.driver.TeradyneEvent;
import com.fhec.views.InformationConfirmationView;

/**
 * 记录config
 */
public class RecordConfig {
	public static void recordConfig() throws Exception {
		MesFileConfig mesFileConfig = GlobalContext.getMesFileConfig();
		ArrayList<String> list = new ArrayList<>();
		String Mode_Code = null;
		String Tester_ID = null;
		Map<String, JLabel> jLabelKeyMap = InformationConfirmationView.jLabelKeyMap;
		Map<String, JLabel> jLabelMap = InformationConfirmationView.jLabelMap;
		list.add("[Header Info " + Temporary.textTest_Code + "]");
		list.add("TesterOS_Version" + ":" + mesFileConfig.getTesterOS_Version());
		list.add("Start_Time" + ":" + LocalConfig.stratDate);
		list.add("End_Time" + ":" + Temporary.saveDate);
		for (String key : jLabelKeyMap.keySet()) {
			for (String s : jLabelMap.keySet()) {

				if (key.equals(s)) {
					list.add(jLabelKeyMap.get(key).getText() + ":" + jLabelMap.get(s).getText());
				}
				if ("Mode_Code".equals(key)) {
					Mode_Code = jLabelMap.get(key).getText();
				}
				if ("Tester_ID".equals(key)) {
					Tester_ID = jLabelMap.get(key).getText();
				}
			}
		}
		list.add("Tested_Qty" + ":" + (TeradyneEvent.goodqty + TeradyneEvent.failqty));
		list.add("Good_Qty" + ":" + TeradyneEvent.goodqty);
		list.add("Fail_Qty" + ":" + TeradyneEvent.failqty);
		list.add("CSV File" + ":" + Temporary.local_csvdir_folderpath + File.separator + LocalConfig.datalog_name_rules
				+ ".csv");
		list.add("STDF File" + ":" + Temporary.local_singlefile_folderpath + File.separator + Temporary.stdUnkName);
		// 文件名字 D:\datalog\datalog_name_rule_1\csvdir\Mode_Code+Tester_ID_config.txt
		String configTxt = Temporary.local_csvdir_folderpath + File.separator + Mode_Code + "_" + Tester_ID
				+ "_config.txt";
		Temporary.configTxt = configTxt;
		File file = new File(configTxt);

		if (!file.exists()) {
			file.createNewFile();
		} else {
			for (String s : list) {
				s += "\r\n";
				appendMethodB(configTxt, s);
			}
			return;
		}
		FileOutputStream fosTxt = new FileOutputStream(file);
		for (String s : list) {
			s += "\r\n";
			fosTxt.write(s.getBytes(StandardCharsets.UTF_8));
		}
		fosTxt.close();

	}

	public static void recordOpConfig() throws Exception {
		Map<String, JLabel> jLabelKeyMap = InformationConfirmationView.jLabelKeyMap;
		Map<String, JLabel> jLabelMap = InformationConfirmationView.jLabelMap;
		ArrayList<String> list = new ArrayList<>();
		String Mode_Code = null;
		String Tester_ID = null;
		list.add("[Header Info " + Temporary.textTest_Code + "]");
		list.add("TesterOS_Version" + ":" + Temporary.testerOS_Version);
		list.add("Start_Time" + ":" + LocalConfig.stratDate);
		list.add("End_Time" + ":" + Temporary.saveDate);
		for (String key : jLabelKeyMap.keySet()) {
			for (String s : jLabelMap.keySet()) {

				if (key.equals(s)) {
					list.add(jLabelKeyMap.get(key).getText() + ":" + jLabelMap.get(s).getText());
				}
				if ("Mode_Code".equals(key)) {
					Mode_Code = jLabelMap.get(key).getText();
				}
				if ("Tester_ID".equals(key)) {
					Tester_ID = jLabelMap.get(key).getText();
				}
			}
		}
		list.add("Tested_Qty" + ":" + (TeradyneEvent.goodqty + TeradyneEvent.failqty));
		list.add("Good_Qty" + ":" + TeradyneEvent.goodqty);
		list.add("Fail_Qty" + ":" + TeradyneEvent.failqty);
		list.add("CSV File" + ":" + Temporary.local_csvdir_folderpath + File.separator + LocalConfig.datalog_name_rules
				+ ".csv");
		list.add("STDF File" + ":" + Temporary.local_singlefile_folderpath + File.separator + Temporary.stdUnkName);
		// 文件名字 D:\datalog\datalog_name_rule_1\csvdir\Mode_Code+Tester_ID_config.txt
		String configTxt = Temporary.local_csvdir_folderpath + File.separator + Mode_Code + "_" + Tester_ID
				+ "_config.txt";
		Temporary.configTxt = configTxt;
		File file = new File(configTxt);

		if (!file.exists()) {
			file.createNewFile();
		} else {
			for (String s : list) {
				s += "\r\n";
				appendMethodB(configTxt, s);
			}
			return;
		}
		FileOutputStream fosTxt = new FileOutputStream(file);
		for (String s : list) {
			s += "\r\n";
			fosTxt.write(s.getBytes(StandardCharsets.UTF_8));
		}
		fosTxt.close();
	}

	private static void appendMethodB(String fileName, String content) {
		try {
			// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件,如果为 true，则将字节写入文件末尾处，而不是写入文件开始处
			FileWriter writer = new FileWriter(fileName, true);
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
