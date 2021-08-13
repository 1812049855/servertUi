package com.fhec.views;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.fhec.context.*;
import org.apache.commons.configuration2.SubnodeConfiguration;

import com.fhec.encode.EnCode;
import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;
import com.fhec.utils.BatchReader;
import com.fhec.views.Actions.InformationAction;
import com.fhec.views.Actions.InformationNoAction;
import com.fhec.views.Actions.InformationOpAction;

public class InformationConfirmationView extends JDialog {
	private JLabel labelKey = null;
	private JLabel label = null;
	private JLabel labelValue = null;
	private Map<String, JTextField> textPaneMap;
	public static Map<String, JLabel> jLabelMap;
	public static Map<String, JLabel> jLabelKeyMap;
	public static List<String> nameList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					InformationConfirmationView window = new InformationConfirmationView();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the application.
	 */
	public InformationConfirmationView() {
		initialize();
	}

	private BatchInputInformationView window;

	public InformationConfirmationView(BatchInputInformationView window, Map<String, JTextField> textPaneMap) {
		this.window = window;
		this.textPaneMap = textPaneMap;
		initialize();
	}

	@Override
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
		jLabelMap = new HashMap<String, JLabel>();
		jLabelKeyMap = new HashMap<String, JLabel>();
		nameList = new ArrayList<String>();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(ConfigFilePath.SWING_PATH);
		setIconImage(image);
		setModal(true);
		setTitle("Input  Lot  Information");
		setBounds(100, 100, 1003, 543);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 997, 514);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("  =  Please confirm the following  lot  information =");
		lblNewLabel.setBounds(167, 23, 328, 15);

		JLabel lblNewLabel_1 = new JLabel(
				"-----------------------------------------------------------------------------------------------------");
		lblNewLabel_1.setBounds(177, 44, 700, 15);
		panel.add(lblNewLabel_1);

		panel.add(lblNewLabel);
		// 1
		int x = 177;
		int y = 65;
		int width = 90;
		int height = 15;
		// 2 301, 61, 54, 15
		int txx = 301;
		int txy = 65;
		int txwidth = 54;
		int txheight = 15;
		// 3 365, 61, 122, 23
		int lax = 365;
		int lay = 65;
		int lawidth = 300;
		int laheight = 23;
		String result = null;
		// 读取文件变成动态
		BatchReader batchReader = new BatchReader(ConfigFilePath.RECIPE_PATH);
		for (int i = 0; i < batchReader.mapList.size(); i++) {
			Map<String, SubnodeConfiguration> map = batchReader.mapList.get(i);
			for (String s : map.keySet()) {
				if (String.valueOf(i).equals(batchReader.getValue(s, "Index"))) {
					String name = batchReader.getValue(s, "Name");
					if (result != null) {
						labelKey = new JLabel(name);
						label = new JLabel("=");
						// 存放的是批次界面输入的文本框的值
						for (String textPane : textPaneMap.keySet()) {
							if (name.equals(textPane)) {
								String text = textPaneMap.get(name).getText();
								labelValue = new JLabel(text);
							}
						}
						labelKey.setBounds(x, y += 35, width, height);
						label.setBounds(txx, txy += 35, txwidth, txheight);
						labelValue.setBounds(lax, lay += 35, lawidth, laheight);
						panel.add(labelKey);
						panel.add(label);
						panel.add(labelValue);
					}
					if (result == null) {
						// 存放的是批次界面输入的文本框的值
						for (String textPane : textPaneMap.keySet()) {
							labelKey = new JLabel(name);
							label = new JLabel("=");
							if (name.equals(textPane)) {
								String text = textPaneMap.get(name).getText();
								labelValue = new JLabel(text);
							}
						}
						labelKey.setBounds(x, y, width, height);
						label.setBounds(txx, txy, txwidth, txheight);
						labelValue.setBounds(lax, lay, lawidth, laheight);
						panel.add(labelKey);
						panel.add(label);
						panel.add(labelValue);
					}
					result = name;
					nameList.add(name);
					jLabelMap.put(name, labelValue);
					jLabelKeyMap.put(name, labelKey);
				}
			}
		}

		JLabel lblNewLabel_1_1 = new JLabel(
				"-----------------------------------------------------------------------------------------------------");
		lblNewLabel_1_1.setBounds(177, 410, 700, 15);
		panel.add(lblNewLabel_1_1);
		JButton btnNo = new JButton("No");
		btnNo.setBounds(467, 467, 93, 23);
		panel.add(btnNo);

		JButton btnYes = new JButton("Yes");
		btnYes.setBounds(319, 467, 93, 23);
		panel.add(btnYes);

		// 监听
		
		
		if ("MES".equals(GlobalContext.UImode)) {
			Log.info("打开mes模式下载界面");
			btnYes.addActionListener(new InformationAction(this, jLabelMap, jLabelKeyMap, nameList));
			btnNo.addActionListener(new InformationNoAction(this));
		}
		if ("OP".equals(GlobalContext.UImode)) {
			btnYes.addActionListener(new InformationOpAction(this, jLabelMap, jLabelKeyMap,nameList));
			btnNo.addActionListener(new InformationNoAction(this));
		}
	}

	// 判断输入的值是否为空
	public Boolean getIsEmpty() {
		for (String key : jLabelMap.keySet()) {
			JLabel label = jLabelMap.get(key);
			if (label.getText().split(" ").length >= 1) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * 定义last信息
	 */
	public void lastOpBatch() {
		// 1.先实例化一个Properties对象
		Properties properties = new Properties();
		LastConfig lastConfig = GlobalContext.getLastConfig();
		try {

			// 2.创建一个输出流对象,选择正确的目标文件路径(注意:该配置文件放在src目录下)
			FileOutputStream fos = new FileOutputStream("last/lastOpBatch.properties");

			// 引入Writer,可以明确该输出流的字符集,确保写入配置文件的中文编码正确
			OutputStreamWriter opw = new OutputStreamWriter(fos, EnCode.enCode);

			// 3.将需要写入的属性内容通过set方法,存入properties对象中 last_device_name
			for (String s : textPaneMap.keySet()) {
				System.out.println(textPaneMap.get(s).getText());
			}

			for (String s : textPaneMap.keySet()) {
				if ("Device_Name".equals(s)) {
					properties.setProperty(LastContext.LAST_DEVICE_NAME, textPaneMap.get(s).getText());
					lastConfig.setLast_device_name(textPaneMap.get(s).getText());
				}
				// last_testcode
				if ("Test_Code".equals(s)) {
					properties.setProperty(LastContext.LAST_TESTCODE, textPaneMap.get(s).getText());
					lastConfig.setLast_testcode(textPaneMap.get(s).getText());
				}
			}
			LocalConfig.systemCount += 1;
			// 4.调用properties的存储方法
			properties.store(opw, "测试用数据");

			Log.info("last信息定义成功");
			MainWindow.setUilog("last信息定义成功");
			// 5.关闭资源
			fos.close();
			// 状态2
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
