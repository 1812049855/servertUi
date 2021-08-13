package com.fhec.app;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import com.fhec.app.rules.CheckSingleInstanceRule;
import com.fhec.app.rules.InitUIVariableRule;
import com.fhec.context.EnvConFigConfig;
import com.fhec.context.FtpmodeConfig;
import com.fhec.context.GlobalContext;
import com.fhec.context.MainStart;
import com.fhec.ftp.FtpClient;
import com.fhec.log.Log;
import com.fhec.utils.FileUtils;
import com.fhec.views.Loading;

/**
 * @author hua
 */
public class AppStart {
    private static List<IRule> beforeRules = new ArrayList<>();
    // 获取机器名
    public static String pcname = null;

    {
        beforeRules.add(new CheckSingleInstanceRule());
        beforeRules.add(new InitUIVariableRule());
        try {
            pcname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws Exception
     * @author Jacob 程序启动初始化
     */

    private void doBeforeRule() throws Exception {
        // 防重复启动
        for (IRule rule : beforeRules) {
            if (rule.doRule()) {
                continue;
            }
            return;
        }
    }

    public void start () throws Exception {
        try {
       
            doBeforeRule();
            
            Loading z =new Loading();
        	z.setUndecorated(true);
        	z.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        	z.setVisible(true);
            // 初始化目录
            init();
            // 创建文件夹
            creMdr();
            // 网络测试
            ftpInit();
            Log.info("ui启动成功");
            // 弹出模式选择界面
            Loading.setVisible(z, false);
            MainStart mainStart = new MainStart();
            mainStart.mainStart();
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "系统提示", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void creMdr() {
        EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
        String[] uipath = {envConFigConfig.getMainPath().getLocal_dlog_path(),
                envConFigConfig.getMainPath().getLocal_prog_path(), GlobalContext.local_errordata_folderpath,
                GlobalContext.server_UImessage_path, GlobalContext.local_tempdata_folderpath,
                GlobalContext.local_UImessage_path, GlobalContext.server_errordata_folderpath};
        FileUtils.CreateFolders(uipath);
        Log.info("ui已经创建本地数据程序存放路径");
        Loading.setLabTxt("ui已经创建本地数据程序存放路径");
    }

    /**
     * @author Jacob 初始化启动目录 清空/移动
     */
    private void init() {
        EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
        if (envConFigConfig.getUiControlFlag().getUi_clear_pgm_flag().equals("1")) {
            File file = new File(envConFigConfig.getMainPath().getLocal_prog_path());
            FileUtils.removeDir(file);
        }
        // 测试异常数据转移文件夹
        File fs = new File(GlobalContext.local_tempdata_folderpath);
        File[] listFiles = fs.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            String nowfile = file.getPath();
            System.out.println(nowfile);
            FileUtils.copyFile(nowfile, GlobalContext.local_errordata_folderpath + "\\");
            FileUtils.delete(file);
        }
        Log.info("ui已清除本地程序");
        Loading.setLabTxt("ui已清除本地程序");
    }

    public void ftpInit() {
        EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
        FtpmodeConfig ftpmodeConfig = GlobalContext.getFtpmodeConfig();
        Loading.setLabTxt("创建网络连接");
        try {
            FtpClient ftp = FtpClient.create(envConFigConfig.getServerProgramIP().getServer_pgm_IP(),
                    envConFigConfig.getServerProgramIP().getServer_pgm_user(),
                    envConFigConfig.getServerProgramIP().getServer_pgm_password(), 21,
                    Integer.valueOf(ftpmodeConfig.getServerpgmftpmode().getServer_pgm_ftpmode()));
            ftp.doAction(new FtpClient.IAction() {

                @Override
                public void doAction(FtpClient ftpClient) {
                    try {
                        Log.info("网络测试");
                        Loading.setLabTxt("创建网络连接成功");
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            Loading.setLabTxt("上传服务器初始化");
            FtpClient uploadftp = FtpClient.uploadCreate(envConFigConfig.getServerDataIP().getServer_data_IP(),
                    envConFigConfig.getServerDataIP().getServer_data_user(),
                    envConFigConfig.getServerDataIP().getServer_data_password(), 21,
                    Integer.valueOf(ftpmodeConfig.getServerpgmftpmode().getServer_pgm_ftpmode()));
            uploadftp.doAction(ftpClient -> {
                try {
                    Log.info("网络存在");
                    Loading.setLabTxt("初始化成功");
                    Thread.sleep(1000);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                }
            });

        } catch (Exception e) {
            JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "alarm U01:can not connect server,please call ME !", "系统提示",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }

    }
}
