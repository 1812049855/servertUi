package com.fhec.app;

import java.awt.EventQueue;
import java.io.File;
import java.net.InetAddress;

import javax.swing.JOptionPane;

import com.fhec.Thread.NettyConnect;
import com.fhec.Thread.RunLoading;
import com.fhec.context.EnvConFigConfig;
import com.fhec.context.GlobalContext;
import com.fhec.context.Temporary;
import com.fhec.style.BeautyEye;

public class Program extends BeautyEye {

    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                	GlobalContext.CreatEnvConFigConfig();
                    EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
                    Temporary.path = envConFigConfig.getMainPath().getLocal_dlog_path() + GlobalContext.UI_message + File.separator + InetAddress.getLocalHost().getHostName();
                    System.setProperty("log.dir", Temporary.path);
                    System.setProperty("log.info.file", "bocai-thrift.log");
                    System.setProperty("log.debug.file", "bocai-thrift-debug.log");
                    System.setProperty("log.error.file", "bocai-thrift-error.log");
                   
                    Thread th2=new Thread(new RunLoading());
                	th2.start();
                	 Thread th1=new Thread(new NettyConnect());
                     th1.start();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
