package com.fhec.views.Actions;

import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.Timer;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.fhec.abstracts.AbstractActionListener;
import com.fhec.context.Temporary;
import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;
import com.fhec.views.BatchInputInformationView;
import com.fhec.views.InformationConfirmationView;
import com.fhec.views.MainWindow;

public class BatchInputOKAction extends AbstractActionListener<BatchInputInformationView> {

	public Map<String, JTextField> textFieldMap;
	Timer tt;
	public BatchInputOKAction(BatchInputInformationView window,Map<String, JTextField> textFieldMap,Timer tt) {
		super(window);
		this.textFieldMap = textFieldMap;
		this.tt=tt;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		tt.cancel();
		Map<String, JTextField> textPaneMap = this.window.textFieldHashMap;
		for (String s : textPaneMap.keySet()) {
			if ("Test_Code".equals(s)) {
				JTextField textField = textPaneMap.get(s);
				Temporary.textTest_Code = textField.getText();
			}
		}
		String[] split = Temporary.textTest_Code.split("\\.");
		if (split.length>2){
			JOptionPane.showConfirmDialog(null, "testcode输入有误，只能输入一个小数点", "提示",JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
			this.window.dispose();
			MainStatus.status1();
		}else {
			Log.info("输入完成进入二次信息确认页面");
			MainWindow.setUilog("输入完成进入二次信息确认页面");
			InformationConfirmationView informationConfirmationView = new InformationConfirmationView(this.window,textPaneMap);
			informationConfirmationView.setVisible(true);
			this.window.dispose();
		}
	}

}
