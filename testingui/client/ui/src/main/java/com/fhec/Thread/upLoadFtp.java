package com.fhec.Thread;

import java.util.List;

import javax.swing.JTextArea;

import com.fhec.driver.TeradyneDriverInit;
import com.fhec.driver.TeradyneEvent;
import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;
import com.fhec.refreshsummary.ReFSummary;
import com.fhec.views.MainWindow;
import com.fhec.views.Actions.SaveResultFtpJudge;

public class upLoadFtp implements Runnable{
	SaveResultFtpJudge saveResultFtpJudge;
	public upLoadFtp(SaveResultFtpJudge saveResultFtpJudge) {
		this.saveResultFtpJudge=saveResultFtpJudge;
	}
	@Override
	public void run() {
		startUpLoad();
		
	}
	public void startUpLoad() {
		// 测试数据上传
		boolean b;
		try {
			b = saveResultFtpJudge.ftpInit();
			if (b) {
				MainStatus.status3();
				TeradyneDriverInit.CleanAllList();
				new Thread(new ReFSummary()).start();
				List<JTextArea> jtext = MainWindow.getTextArea();
				for (int z = 0; z < TeradyneEvent.MaxSite; z++) {
					jtext.get(z).setOpaque(false);
					jtext.get(z).setText("");
				}
				return;
			} else {
				Log.error("SaveTestResult 连接网络失败");
				MainWindow.setUilog("SaveTestResult 连接网络失败，返回之前的页面");
				MainStatus.status2();
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
