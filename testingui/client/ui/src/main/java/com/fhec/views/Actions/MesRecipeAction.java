package com.fhec.views.Actions;

import com.fhec.context.EnvConFigConfig;
import com.fhec.context.GlobalContext;
import com.fhec.context.RecipeConfig;
import com.fhec.context.Temporary;
import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;
import com.fhec.utils.FileUtils;
import com.fhec.views.BatchInputInformationView;
import com.fhec.views.MESDownloadView;

import javax.swing.*;
import java.io.File;

public class MesRecipeAction{

    private MESDownloadView window;

    public MesRecipeAction(MESDownloadView window) {
        this.window = window;
    }

    public MesRecipeAction( ) {
    }

    private  RecipeConfig recipeConfig;

    public RecipeConfig getRecipeConfig() {
        return recipeConfig;
    }

    public void setRecipeConfig(RecipeConfig recipeConfig) {
        this.recipeConfig = recipeConfig;
    }

    //UI 读取 recipe file 内容
    public void mesRecipeFile() {
        EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
        String recipeFile = Temporary.localrecipefilepath;
        //判断对应的 recipe文件(local_recipe_filepath)是否存在
        if (!new File(recipeFile).exists()) {
            Log.info("recipe文件(local_recipe_filepath)不存在");
            this.window.setuiLog("recipe文件(local_recipe_filepath)不存在");
            JOptionPane.showConfirmDialog(null, "alarm M09:recipe file is not exist，please call PTE !", "提示", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
            //OP 点击 OK 按钮后
                //env_config 中的 alarm_M09_flag = 1
                if (EnvConFigConfig.uninstall.equals(envConFigConfig.getAlarmControLFlag().getAlarm_M09_flag())) {
                    FileUtils.removeDir(new File(envConFigConfig.getMainPath().getLocal_prog_path()));
                    Log.error("alarm_M09_flag = 1,进行卸载测试程序，退出 UI");
                    ExitUninstall exitUninstall = new ExitUninstall();
                    exitUninstall.exitUnistall();
                    System.exit(0);
                }else if (EnvConFigConfig.recover.equals(envConFigConfig.getAlarmControLFlag().getAlarm_M09_flag())){
                    Log.info("alarm_M09_flag = 0,关闭窗口，返回主界面");
                    this.window.dispose();
                    MainStatus.status1();

                }

        } else {
            //若 recipe file 存在，则执行下一步骤
            //UI 自动获取 recipe file 内容，
            Log.info("recipe文件(local_recipe_filepath)存在");
            this.window.setuiLog("recipe文件(local_recipe_filepath)存在");
            recipeConfig = GlobalContext.getRecipeConfig();
            Log.info("获取recipe file文件 内容");
            this.window.setuiLog("获取recipe file文件 内容");
            Log.info("弹出批次信息输入界面");
            this.window.setuiLog("弹出批次信息输入界面");
            BatchInputInformationView.Show();
        }
    }
}
