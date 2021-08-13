package com.fhec.method;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import com.fhec.log.Log;

public class ExitAction  {
    /*public ExitAction(MainWindow window) {
        super(window);
    }*/


    public void actionPerformed(ActionEvent e) {
        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Do you want to Exit？", "系统提示",
                JOptionPane.YES_NO_OPTION);
        if (showConfirmDialog == 0) {
            Log.info("退出程序");

        } else {
            //this.window.setOk(false);
            Log.info("取消关闭程序，返回主页面成功");
          //  MainWindow.setUilog("取消关闭程序，返回主页面成功");

        }
    }
}
