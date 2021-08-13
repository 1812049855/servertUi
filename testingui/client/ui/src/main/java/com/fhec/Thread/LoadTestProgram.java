package com.fhec.Thread;

import com.fhec.driver.TeradyneDriverInit;
import com.fhec.driver.TeradyneEvent;
import com.fhec.eqp.TeradyneEquipment;
import com.fhec.views.MainWindow;

public class LoadTestProgram implements Runnable{
	String local_testflow_path;
	String Programpath;
	public LoadTestProgram(String local_testflow_path,String Programpath) {
		this.local_testflow_path=local_testflow_path;
		this.Programpath=Programpath;
	}
	@Override
	public void run() {
		load();
	}
	public void load() {
		TeradyneEvent.MaxSite=0;
		TeradyneEquipment teradyneInstantia = TeradyneDriverInit.TeradyneInstantia();
		teradyneInstantia.UnloadTestProgram();
		MainWindow.progress(true);
		MainWindow.redJProgressBar(100, 20);
		MainWindow.setProgressTxt("正在加载测试程序");
		teradyneInstantia.LoadThisTestProgram(local_testflow_path, Programpath);
		TeradyneEvent.MaxSite = teradyneInstantia.MaxSites();
	}
}
