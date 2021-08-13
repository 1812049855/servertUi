package com.fhec.views.Actions;

import java.awt.event.ActionEvent;

import com.fhec.abstracts.AbstractActionListener;
import com.fhec.context.GlobalContext;
import com.fhec.log.Log;
import com.fhec.views.MainWindow;
import com.fhec.views.ModeSelectionDialog;

public class ModeMesAction extends AbstractActionListener<ModeSelectionDialog> {

	public ModeMesAction(ModeSelectionDialog window) {
		super(window);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GlobalContext.UImode = "MES";
		this.window.dispose();
		Log.info("选择为mes模式");
		MainWindow.setUilog("选择为mes模式");
	}

}
