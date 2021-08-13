package com.fhec.views.Actions;

import com.fhec.abstracts.AbstractActionListener;
import com.fhec.context.EnvConFigConfig;
import com.fhec.context.GlobalContext;
import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;
import com.fhec.views.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainAction extends AbstractActionListener<MainWindow> {

    public MainAction(MainWindow mainWindow) {
        super(mainWindow);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Log.info("请输入project密码");
        MainWindow.setUilog("请输入project密码");
        String projectPwd = JOptionPane.showInputDialog("请输入project密码：");
        boolean bool = false;
        do {
            if (projectPwd==null){
                Log.info("点击取消不输入密码，返回主界面成功");
                MainWindow.setUilog("点击取消不输入密码，返回主界面成功");
                return;
            }
            if ("".equals(projectPwd.trim())){
                JOptionPane.showMessageDialog(null, "project password check fail", "提示", JOptionPane.WARNING_MESSAGE);
                projectPwd = JOptionPane.showInputDialog("请输入project密码：");
            }else {
                EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
                if (envConFigConfig.getProjectPassword().getProject_password() == null) {
                    return;
                } else {
                    if (projectPwd.trim().equals(envConFigConfig.getProjectPassword().getProject_password().trim())) {
                        //this.window.ChangeComboBox();
                        bool = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "project password check fail", "提示", JOptionPane.WARNING_MESSAGE);
                        projectPwd = JOptionPane.showInputDialog("请输入project密码：");
                    }

                }
            }


        } while (!bool);
    }
}
