package com.fhec.views;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import org.apache.commons.configuration2.SubnodeConfiguration;

import com.fhec.app.AppStart;
import com.fhec.context.ConfigFilePath;
import com.fhec.context.EnvConFigConfig;
import com.fhec.context.GlobalContext;
import com.fhec.context.MesFileConfig;
import com.fhec.mainstatus.MainStatus;
import com.fhec.utils.BatchReader;
import com.fhec.utils.MesFileRead;
import com.fhec.views.Actions.BatchInputCancelAction;
import com.fhec.views.Actions.BatchInputOKAction;

public class BatchInputInformationView extends JDialog {

	private final JTextPane tXTTester_ID = new JTextPane();

	private final JTextPane textCustomer_ID = new JTextPane();

	private final JTextPane textProgram_Name = new JTextPane();

	private final JTextPane textOperator_ID = new JTextPane();

	private final JTextPane textDevice_Name = new JTextPane();

	private final JTextPane textCustomer_LotNo = new JTextPane();

	private final JTextPane textSub_LotNo = new JTextPane();

	private final JTextPane textMode_Code = new JTextPane();

	private final JTextPane textTest_Code = new JTextPane();

	private final JTextPane textTest_BinNo = new JTextPane();

	private Map<String, JTextPane> map = new HashMap<>();

	private JLabel label = null;
	private JTextField textField = null;
	public Map<String, JTextField> textFieldHashMap = new HashMap<String, JTextField>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BatchInputInformationView window = new BatchInputInformationView();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			MainStatus.status1();
		}
	}

	/**
	 * Create the application.
	 */
	public BatchInputInformationView() {
		initialize();
	}

	public static void Show() {
		BatchInputInformationView batchInputInformationView = new BatchInputInformationView();
		batchInputInformationView.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// 取值 初始化mes文件里面的内容
		MesFileConfig mesFileConfig = GlobalContext.getMesFileConfig();

		// envconfig
		EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(ConfigFilePath.SWING_PATH);
		setIconImage(image);
		setModal(true);
		setBackground(new Color(204, 204, 204));
		getContentPane().setBackground(UIManager.getColor("control"));
		setForeground(new Color(51, 51, 102));
		setTitle("Input  Lot  Information");
		setBounds(100, 100, 666, 463);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 660, 434);
		panel.setBackground(UIManager.getColor("control"));
		getContentPane().add(panel);

		// 读取文件变成动态
		BatchReader batchReader = new BatchReader(ConfigFilePath.RECIPE_PATH);
		// 不能超过 ManualInputTimeGap 定义时间
		java.util.Timer tt = new Timer();// 定时类
		int x = 37;
		int y = 22;
		int width = 116;
		int height = 25;
		int txx = 140;
		int txy = 22;
		int txwidth = 475;
		int txheight = 21;
		String result = null;
		for (int i = 0; i < batchReader.mapList.size(); i++) {
			Map<String, SubnodeConfiguration> map = batchReader.mapList.get(i);
			for (String s : map.keySet()) {
				if (String.valueOf(i).equals(batchReader.getValue(s, "Index"))) {
					String name = batchReader.getValue(s, "Name");
					if ("MES".equals(GlobalContext.UImode)) {
						String mesfileVal = MesFileRead.getMesfileVal(ConfigFilePath.MESFILE_PATH, name);
						if (result != null) {
							label = new JLabel(name);
							textField = new JTextField();
							if ("Operator_ID".equals(name) || "Test_Code".equals(name) || "Test_BinNo".equals(name)) {
								JTextField finalTextPane1 = textField;
								finalTextPane1.addMouseListener(new MouseListener() {
									@Override
									public void mouseClicked(MouseEvent e) {
										tt.schedule(new TimerTask() {
											@Override
											public void run() {
												finalTextPane1.setText("");
											}
										}, 0, Integer.parseInt(envConFigConfig.getManualKeyinControl().getManualInputTimeGap())	* 1000);// 从0秒开始，每隔30秒执dao行一次

									}

									@Override
									public void mousePressed(MouseEvent e) {
									}

									@Override
									public void mouseReleased(MouseEvent e) {

									}

									@Override
									public void mouseEntered(MouseEvent e) {

									}

									@Override
									public void mouseExited(MouseEvent e) {

									}
								});
							} else {
								textField.setText(mesfileVal);
								textField.setEnabled(false);
							}
							label.setBounds(x, y += 35, width, height);
							textField.setBounds(txx, txy += 35, txwidth, txheight);
							panel.add(textField);
							panel.add(label);
							System.out.println(name);
						}
						if (result == null) {
							label = new JLabel(name);
							textField = new JTextField();
							label.setBounds(x, y, width, height);
							textField.setBounds(txx, txy, txwidth, txheight);
							panel.add(label);
							panel.add(textField);
						}

						if (name.equals("Tester_ID")) {
							textField.setText(AppStart.pcname);
							textField.setEnabled(false);
						}
						result = name;
						textFieldHashMap.put(name, textField);
					}
					if ("OP".equals(GlobalContext.UImode)) {
						if (result != null) {
							label = new JLabel(name);
							textField = new JTextField();
							label.setBounds(x, y += 35, width, height);
							textField.setBounds(txx, txy += 35, txwidth, txheight);
							panel.add(textField);
							panel.add(label);
							JTextField finalTextPane = textField;
							textField.setEnabled(true);
							finalTextPane.addMouseListener(new MouseListener() {
								@Override
								public void mouseClicked(MouseEvent e) {

									tt.schedule(new TimerTask() {
										@Override
										public void run() {
											finalTextPane.setText("");
										}
									}, 0, Integer.parseInt(envConFigConfig.getManualKeyinControl().getManualInputTimeGap())	* 1000);// 从0秒开始，每隔30秒执dao行一次

								}

								@Override
								public void mousePressed(MouseEvent e) {
								}

								@Override
								public void mouseReleased(MouseEvent e) {

								}

								@Override
								public void mouseEntered(MouseEvent e) {

								}

								@Override
								public void mouseExited(MouseEvent e) {

								}
							});
						}
						if (result == null) {
							label = new JLabel(name);
							textField = new JTextField();
							label.setBounds(x, y, width, height);
							textField.setBounds(txx, txy, txwidth, txheight);
							panel.add(label);
							panel.add(textField);
						}
						if (name.equals("Tester_ID")) {
							textField.setText(AppStart.pcname);
							textField.setEnabled(false);
						}
						result = name;
						textFieldHashMap.put(name, textField);
					}
				}
			}
		}
		panel.setLayout(null);
		JButton btnNewButtonCancel = new JButton("Cancel");
		btnNewButtonCancel.setBounds(337, 383, 93, 23);
		panel.add(btnNewButtonCancel);
		JButton btnNewButtonOK = new JButton("OK");
		btnNewButtonOK.setBounds(181, 383, 93, 23);
		panel.add(btnNewButtonOK);
		// 监听
		btnNewButtonOK.addActionListener(new BatchInputOKAction(this, textFieldHashMap,tt));
		btnNewButtonCancel.addActionListener(new BatchInputCancelAction(this));
	}

}
