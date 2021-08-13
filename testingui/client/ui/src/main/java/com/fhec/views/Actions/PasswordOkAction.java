package com.fhec.views.Actions;

import com.fhec.abstracts.AbstractActionListener;
import com.fhec.context.GlobalContext;
import com.fhec.context.PasswordConfig;
import com.fhec.log.Log;
import com.fhec.views.PasswordVerifiersView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PasswordOkAction extends AbstractActionListener<PasswordVerifiersView> {

	public PasswordOkAction(PasswordVerifiersView passwordVerifiersView) {
		super(passwordVerifiersView);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// 获取路径
			PasswordConfig passwordConfig = GlobalContext.getPasswordConfig();
			String[] operator_mode_passwords = passwordConfig.getOperatorModePassword().getOperator_mode_passwords();
			System.out.println(this.window.getText());
			for (String operator_mode_password : operator_mode_passwords) {
				if (this.window.getText().equals(operator_mode_password)) {
					this.window.setOk(true);
					this.window.dispose();
					Log.info("op模式密码校验成功");
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "alarm O01:password fail !", "提示", JOptionPane.WARNING_MESSAGE);
			this.window.setOk(false);
			this.window.dispose();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
		}
	}
}
