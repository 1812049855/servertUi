package com.fhec.context;

import com.fhec.views.MainWindow;
import com.fhec.views.ModeSelectionDialog;

public class MainStart {

	public void mainStart() {
		ModeSelectionDialog modeSelectionDialog = new ModeSelectionDialog();
		MainWindow mainWindow = new MainWindow();
		modeSelectionDialog.setVisible(true);
		if ("MES".equals(GlobalContext.UImode)) {
			modeSelectionDialog.dispose();
			mainWindow.setVisible(true);
		} else if ("OP".equals(GlobalContext.UImode)) {
			modeSelectionDialog.dispose();
			mainWindow.setVisible(true);
		}

	}
}
