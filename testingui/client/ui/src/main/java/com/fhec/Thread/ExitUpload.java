package com.fhec.Thread;

import com.fhec.views.Actions.ExitUninstall;

public class ExitUpload implements Runnable{

	@Override
	public void run() {
		startUpload();
	}
	public void startUpload() {
	    ExitUninstall exitUninstall = new ExitUninstall();
        exitUninstall.exitUnistall();
        System.exit(0);
	}
}
