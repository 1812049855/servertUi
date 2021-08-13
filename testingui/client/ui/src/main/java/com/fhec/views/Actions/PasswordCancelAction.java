package com.fhec.views.Actions;

import java.awt.event.ActionEvent;

import com.fhec.abstracts.AbstractActionListener;
import com.fhec.context.GlobalContext;
import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;
import com.fhec.views.PasswordVerifiersView;

public class PasswordCancelAction extends AbstractActionListener<PasswordVerifiersView> {

	public PasswordCancelAction(PasswordVerifiersView passwordVerifiersView) {
		super(passwordVerifiersView);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.window.dispose();
		Log.info("op模式密码页面关闭");
		GlobalContext.UImode = null;
		// 1
		// MainWindow.startComboBox();
		MainStatus.status1();
	}
}
