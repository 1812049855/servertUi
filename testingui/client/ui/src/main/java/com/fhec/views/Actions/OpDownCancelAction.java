package com.fhec.views.Actions;

import java.awt.event.ActionEvent;

import com.fhec.abstracts.AbstractActionListener;
import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;
import com.fhec.views.OPDownloadView;

public class OpDownCancelAction extends AbstractActionListener<OPDownloadView> {

	public OpDownCancelAction(OPDownloadView mainWindow) {
		super(mainWindow);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Log.info("没有进行下载文件 关闭下载界面");
		this.window.dispose();
		  //1
        MainStatus.status1();
	}
}
