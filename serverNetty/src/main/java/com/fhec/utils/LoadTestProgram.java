package com.fhec.utils;

import com.fhec.driver.TeradyneDriverInit;
import com.fhec.driver.TeradyneEvent;
import com.fhec.eqp.TeradyneEquipment;

public class LoadTestProgram implements Runnable{
	private  String local_testflow_path;
	private String Programpath;
	public LoadTestProgram(String local_testflow_path, String Programpath) {
		this.local_testflow_path=local_testflow_path;
		this.Programpath=Programpath;
	}
	@Override
	public void run() {
		load();
	}
	private void load() {
		TeradyneEvent.MaxSite=0;
		TeradyneEquipment teradyneInstantia = TeradyneDriverInit.TeradyneInstantia();
		teradyneInstantia.UnloadTestProgram();
//		MainWindow.progress(true);
//		MainWindow.redJProgressBar(100, 20);
//		MainWindow.setProgressTxt("正在加载测试程序");
		teradyneInstantia.LoadThisTestProgram(local_testflow_path, Programpath);
		TeradyneEvent.MaxSite = teradyneInstantia.MaxSites();
	}
}
