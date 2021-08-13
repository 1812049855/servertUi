package com.fhec.Thread;

import javax.swing.JOptionPane;

import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;
import com.fhec.views.MainWindow;
import com.fhec.views.Actions.FullEndLotFtpJudge;

public class FullLotEndUpload implements Runnable{

	@Override
	public void run() {
		startUpload();
	}
	public void startUpload() {
		// 存在
		FullEndLotFtpJudge fullEndLotFtpJudge = new FullEndLotFtpJudge();

		try {
			boolean b = fullEndLotFtpJudge.ftpInit();
			if (b) {
				Log.info("lot end执行完毕");
				MainWindow.setUilog("lot end执行完毕");
				// 1
				MainStatus.status1();
			} else {
				Log.error("lot end连接服务器失败");
				MainWindow.setUilog("返回lot end之前的状态");
				MainStatus.status3();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "系统提示", JOptionPane.WARNING_MESSAGE);
			MainStatus.status3();
		}
	}

}
