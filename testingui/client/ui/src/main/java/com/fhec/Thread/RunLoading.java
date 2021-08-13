package com.fhec.Thread;

import com.fhec.app.AppStart;
import com.fhec.entity.EntityVo;
import com.fhec.views.Actions.ExitUninstall;

public class RunLoading implements Runnable {

    @Override
    public void run() {

        load();
    }

    public void load() {
        try {
            while (true) {
                Thread.sleep(1000);
                new EntityVo();
                if (EntityVo.status1 == 1) {
                    new AppStart().start();
                    break;
                }
            }
        } catch (Exception e) {
            ExitUninstall ul = new ExitUninstall();
            ul.exitUnistall();
        }
    }

}
