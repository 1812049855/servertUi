package com.fhec.views.Actions;

import com.fhec.abstracts.AbstractActionListener;
import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;
import com.fhec.views.BatchInputInformationView;
import com.fhec.views.MainWindow;

import java.awt.event.ActionEvent;

public class BatchInputCancelAction extends AbstractActionListener<BatchInputInformationView> {
	public BatchInputCancelAction(BatchInputInformationView window) {
        super(window);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		window.dispose();
		Log.info("关闭批次输入信息界面，返回主界面成功");
		MainWindow.setUilog("关闭批次输入信息界面，返回主界面成功");
		MainStatus.status1();
		//MainWindow.startComboBox();
	}
}
