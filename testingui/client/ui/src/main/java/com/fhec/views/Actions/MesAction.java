package com.fhec.views.Actions;

import com.fhec.abstracts.AbstractActionListener;
import com.fhec.views.MESDownloadView;
import com.fhec.views.MainWindow;

import java.awt.event.ActionEvent;

public class MesAction extends AbstractActionListener<MESDownloadView> {
	 private  MainWindow mainWindow;
	public  MesAction(MESDownloadView window, MainWindow mainWindow) {
		super(window);
		this.mainWindow=mainWindow;
	}

	// 方法整合
	@Override
	public void actionPerformed(ActionEvent e) {
		this.window.setOk(true);
		// mesfile下载检查
		MesFileAction mesFileAction = new MesFileAction(this.window,mainWindow);
		try {
			boolean checkFile = mesFileAction.mesCheckFile();
			if (checkFile) {
				// mes程序下载检查
				MesDownLoadAction buttonMesDownLoadActionListener = new MesDownLoadAction(this.window,mainWindow);
				buttonMesDownLoadActionListener.mesDownLode();
			}else {
				this.window.dispose();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
