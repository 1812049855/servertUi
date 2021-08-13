package com.fhec.views.Actions;

import java.io.File;

import javax.swing.JOptionPane;

import com.fhec.Thread.MesDownLoadZip;
import com.fhec.context.EnvConFigConfig;
import com.fhec.context.GlobalContext;
import com.fhec.context.LastConfig;
import com.fhec.context.LocalConfig;
import com.fhec.context.MesFileConfig;
import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;
import com.fhec.utils.FileUtils;
import com.fhec.views.MESDownloadView;
import com.fhec.views.MainWindow;

public class MesDownLoadAction {

 
    private MESDownloadView window;
    private MainWindow mainWindow;
    public MesDownLoadAction(MESDownloadView window,MainWindow mainWindow) {
        this.window = window;
        this.mainWindow = mainWindow;
    }

    // 程序下载检查
    public void mesDownLode() throws Exception {

        // 读取envconfig中内容
        EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
        // UI 获取 mes file 中内容
        MesFileConfig mesFileConfig = GlobalContext.getMesFileConfig();
        LastConfig lastConfig = GlobalContext.getLastConfig();

        // 程序下载检查
        // 判断 mesfile_program 与 mesfile_testflow 是否一致
        String Test_Flow_substring = mesFileConfig.getTest_Flow().substring(
                mesFileConfig.getTest_Flow().lastIndexOf("/", mesFileConfig.getTest_Flow().lastIndexOf("/")) + 1,
                mesFileConfig.getTest_Flow().lastIndexOf("."));
        if (mesFileConfig.getProgram_Name().equals(Test_Flow_substring)) {
            LocalConfig.check10 = true;
            Log.info("mesfile_program 与 mesfile_testflow 一致");
            this.window.setuiLog("mesfile_program 与 mesfile_testflow 一致");
        } else {
            LocalConfig.check10 = false;
            Log.info("mesfile_program 与 mesfile_testflow 不一致");
            this.window.setuiLog("mesfile_program 与 mesfile_testflow 不一致");
        }

        // 判断 mesfile_program 与 last_programname 是否一致
        if (mesFileConfig.getProgram_Name().equals(lastConfig.getLast_programname())) {
            LocalConfig.check11 = true;
            Log.info("mesfile_program 与 last_programname 一致");
            this.window.setuiLog("mesfile_program 与 last_programname 一致");
        } else {
            LocalConfig.check11 = false;
            Log.info("mesfile_program 与 last_programname 不一致");
            this.window.setuiLog("mesfile_program 与 last_programname 不一致");
        }

        // 判断 mesfile_progfolder 与 last_progfolder 是否一致
        String program_Folder = mesFileConfig.getProgram_Folder().replaceAll("\\\\", "\\\\\\\\");
        if (program_Folder.equals(lastConfig.getLast_progfolder())) {
            LocalConfig.check12 = true;
            Log.info("mesfile_progfolder 与 last_progfolder一致");
            this.window.setuiLog("mesfile_progfolder 与 last_progfolder一致");
        } else {
            LocalConfig.check12 = false;
            Log.info("mesfile_progfolder 与 last_progfolder 不一致");
            this.window.setuiLog("mesfile_progfolder 与 last_progfolder 不一致");
        }

        // 判断 mesfile_TesterOS 与 last_TesterOS 是否一致
        if (mesFileConfig.getTesterOS_Version().equals(lastConfig.getLast_TesterOS())) {
            LocalConfig.check13 = true;
            Log.info("mesfile_TesterOS 与 last_TesterOS一致");
            this.window.setuiLog("mesfile_TesterOS 与 last_TesterOS一致");
        } else {
            LocalConfig.check13 = false;
            Log.info("mesfile_TesterOS 与 last_TesterOS 不一致");
            this.window.setuiLog("mesfile_TesterOS 与 last_TesterOS不一致");
        }

        // 判断 mesfile_ zipfile 与 last_zipfile 是否一致
        String zipfile_Name = mesFileConfig.getZipfile_Name().replaceAll("\\\\", "\\\\\\\\");
        if (zipfile_Name.equals(lastConfig.getLast_zipfile())) {
            LocalConfig.check14 = true;
            Log.info("mesfile_ zipfile 与 last_zipfile 一致");
            this.window.setuiLog("mesfile_ zipfile 与 last_zipfile 一致");
        } else {
            LocalConfig.check14 = false;
            Log.info("mesfile_ zipfile 与 last_zipfile 不一致");
            this.window.setuiLog("mesfile_ zipfile 与 last_zipfile 不一致");
        }

        // 遍历 local_prog_path 下第一级目录，判断是否只有 1 个压缩包\
        // 判断文件是否存在
        FileUtils.CreateFolder(envConFigConfig.getMainPath().getLocal_prog_path());
        String[] fileList = new File(envConFigConfig.getMainPath().getLocal_prog_path()).list();
        int count = 0;
        for (int i = 0; i < fileList.length; i++) {
            if (new File(envConFigConfig.getMainPath().getLocal_prog_path() + fileList[i]).isDirectory()) {
                continue;
            } else {
                String local_prog_path_zip = fileList[i].substring(fileList[i].lastIndexOf(".") + 1);
                if ("zip".equals(local_prog_path_zip) || "tar".equals(local_prog_path_zip) || "gz".equals(local_prog_path_zip)) {
                    count += 1;
                }
            }
        }
        if (count <= 1) {
            LocalConfig.check15 = true;
            Log.info("local_prog_path 下第一级目录只有 1 个压缩包");
            this.window.setuiLog("local_prog_path 下第一级目录只有 1 个压缩包");
        } else {
            LocalConfig.check15 = false;
            Log.info(" local_prog_path 下第一级目录压缩包不唯一");
            this.window.setuiLog("  local_prog_path 下第一级目录压缩包不唯一");
        }

        // 执行下载程序检查
        // 当 check10 = false 时
        if (!LocalConfig.check10) {
            Log.info(" check10 = false ");
            this.window.setuiLog(" check10 = false ");
            JOptionPane.showConfirmDialog(null, "alarm M07:mesfile program and testflow not match,please call PTE !",
                    "提示", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);

            // env_config 中的 alarm_M07_flag = 1
            if (EnvConFigConfig.uninstall.equals(envConFigConfig.getAlarmControLFlag().getAlarm_M07_flag())) {
                FileUtils.removeDir(new File(envConFigConfig.getMainPath().getLocal_prog_path()));

                // 保存 UI log 并上传 待做
                Log.error("alarm_M07_flag = 1,卸载程序，退出ui");
                ExitUninstall exitUninstall = new ExitUninstall();
                exitUninstall.exitUnistall();
                System.exit(0);
            } else if (EnvConFigConfig.recover.equals(envConFigConfig.getAlarmControLFlag().getAlarm_M07_flag())) {
                Log.info("alarm_M07_flag = 0,关闭窗体");
                this.window.setuiLog("alarm_M07_flag = 0,关闭窗体");
                this.window.dispose();
                MainStatus.status1();
            }

        } else {
            MesDownLoadZipAction bs = new MesDownLoadZipAction(this.window,mainWindow);
            //检查程序信息不一致时是否需要退出重新下载程序包(QA 切 FT 或 FT 切 FT 检查此项)
            // 当 check10 = true 且 system count > 0 且 当 pgm_mode_code 包含”FT”时
            if (LocalConfig.check10&&LocalConfig.systemCount>0&&MESDownloadView.getModeCode().contains("FT")||MESDownloadView.getModeCode().contains("QA")) {
                if (LocalConfig.check11 && LocalConfig.check12 && LocalConfig.check13 && LocalConfig.check14 && LocalConfig.check15) {
                    Log.info("check11，check12，check13，check14，check15 全部为 true");
                    this.window.setuiLog("check11，check12，check13，check14，check15 全部为 true");
                    try {
                    	
                    	Thread th=new Thread (new MesDownLoadZip(bs,this.window));
                    	th.start();
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                    }

                }else{
                    JOptionPane.showConfirmDialog(null, "“alarm M08:current program and last program is not match !", "提示",
                            JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);

                    // 若 env_config 中的 alarm_M08_flag = 1

                    if (EnvConFigConfig.uninstall.equals(envConFigConfig.getAlarmControLFlag().getAlarm_M08_flag())) {
                        FileUtils.removeDir(new File(envConFigConfig.getMainPath().getLocal_prog_path()));
                        // 保存 UI log 并上传 待做
                        Log.error("alarm_M08_flag = 1,卸载程序，退出ui");
                        ExitUninstall exitUninstall = new ExitUninstall();
                        exitUninstall.exitUnistall();
                        System.exit(0);
                    } else {
                        Log.info("alarm_M08_flag = 0,关闭窗体");
                        this.window.setuiLog("alarm_M08_flag = 0,关闭窗体");
                        this.window.dispose();
                        MainStatus.status1();
                    }

                }
            }else if (LocalConfig.check10 && LocalConfig.systemCount == 0) {
                    Log.info("check10 = true 且 system count = 0");
                    this.window.setuiLog("check10 = true 且 system count = 0");
                    // 压缩包下载测试
                try {
                	Thread th=new Thread (new MesDownLoadZip(bs,this.window));
                	th.start();
//                    boolean downLoadMesZip = bs.downLoadMesZip();
//                    if (downLoadMesZip) {
//                        boolean downLoadMesRecipe = bs.downLoadMesRecipe();
//                        if (downLoadMesRecipe) {
//                            // 读取recipeFile文件
//                            MesRecipeAction mesRecipeAction = new MesRecipeAction(this.window);
//                            mesRecipeAction.mesRecipeFile();
//                        }
//                    }else {
//                        MainStatus.status1();
//                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                    MainStatus.status1();
                }
            }
        }
    }
 

}
