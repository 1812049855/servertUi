package com.fhec.refreshsummary;

import com.fhec.driver.TeradyneDriverInit;

import javax.swing.*;

public class ReFSummary implements Runnable {
	@Override
	public void run() {
//		while (TeradyneEvent.runflag) {
			try {
				Thread.sleep(1000);
				TeradyneDriverInit.refreshHardBin();
				Thread.sleep(500);
				TeradyneDriverInit.reFreshLast100();
			
			} catch (InterruptedException e) {
				 JOptionPane.showConfirmDialog(null,"刷新实时界面异常", "error",
                         JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			}
//		}
	}

}
