package com.fhec.views.Actions;

import com.fhec.abstracts.AbstractActionListener;
import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;
import com.fhec.views.InformationConfirmationView;
import com.fhec.views.MainWindow;

import java.awt.event.ActionEvent;

public class InformationNoAction extends AbstractActionListener<InformationConfirmationView> {


    public InformationNoAction(InformationConfirmationView window) {
        super(window);
    }

    public void actionPerformed(ActionEvent arg0) {
        this.window.dispose();
        Log.info("关闭二次确认界面，返回主界面成功");
        //1
        MainStatus.status1();
        //MainWindow.startComboBox();
    }
}
