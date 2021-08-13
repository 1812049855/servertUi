package com.fhec.views.Actions;

import com.fhec.abstracts.AbstractActionListener;
import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;
import com.fhec.views.MESDownloadView;
import com.fhec.views.MainWindow;

import java.awt.event.ActionEvent;

public class MesDownCancelAction extends AbstractActionListener<MESDownloadView> {

    public MesDownCancelAction(MESDownloadView mainWindow) {
        super(mainWindow);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Log.info("没有进行下载文件 关闭下载界面");
        this.window.dispose();
        //1
        MainStatus.status1();
        //MainWindow.startComboBox();
    }
}
