package com.fhec.app.rules;

import static com.fhec.app.AppStart.pcname;

import java.io.File;
import java.net.InetAddress;

import com.fhec.app.IRule;
import com.fhec.context.EnvConFigConfig;
import com.fhec.context.GlobalContext;
import com.fhec.context.Temporary;
import com.fhec.log.Log;

public class InitUIVariableRule implements IRule {

    @Override
    public boolean doRule() throws Exception {

        InitVariable();

        return true;
    }

    private void InitVariable() throws Exception {
        /**
         * 实例化
         */
        Log.info("开始EnvConFigConfig初始化");
        GlobalContext.CreatEnvConFigConfig();
        EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
        Log.info(EnvConFigConfig.ServerDataIP.NAME_SERVER_DATA_IP + " : " + envConFigConfig.getServerDataIP().getServer_data_IP());
        Log.info(EnvConFigConfig.ServerDataIP.NAME_SERVER_DATA_USER + " : " + envConFigConfig.getServerDataIP().getServer_data_user());
        Log.info(EnvConFigConfig.ServerDataIP.NAME_SERVER_DATA_PASSWORD + " : " + envConFigConfig.getServerDataIP().getServer_data_password());

        Log.info(EnvConFigConfig.ServerProgramIP.NAME_SERVER_PGM_IP + " : " + envConFigConfig.getServerProgramIP().getServer_pgm_IP());
        Log.info(EnvConFigConfig.ServerProgramIP.NAME_SERVER_PGM_USER + " : " + envConFigConfig.getServerProgramIP().getServer_pgm_user());
        Log.info(EnvConFigConfig.ServerProgramIP.NAME_SERVER_PGM_PASSWORD + " : " + envConFigConfig.getServerProgramIP().getServer_pgm_password());

        Log.info(EnvConFigConfig.ProjectPassword.PROJECT_PASSWORD + " : " + envConFigConfig.getProjectPassword().getProject_password());

        Log.info(EnvConFigConfig.MainPath.NAME_LOCAL_DLOG_PATH + " : " + envConFigConfig.getMainPath().getLocal_dlog_path());
        Log.info(EnvConFigConfig.MainPath.NAME_LOCAL_PROG_PATH + " : " + envConFigConfig.getMainPath().getLocal_prog_path());
        Log.info(EnvConFigConfig.MainPath.NAME_SERVER_DLOG_PATH + " : " + envConFigConfig.getMainPath().getServer_dlog_path());
        Log.info(EnvConFigConfig.MainPath.NAME_SERVER_PROG_PATH + " : " + envConFigConfig.getMainPath().getServer_prog_path());
        Log.info(EnvConFigConfig.MainPath.NAME_SERVER_MES_PATH + " : " + envConFigConfig.getMainPath().getServer_mes_path());
        Log.info(EnvConFigConfig.MainPath.NAME_SERVER_PASSWORD_PATH + " : " + envConFigConfig.getMainPath().getServer_password_path());

        Log.info(EnvConFigConfig.UiControlFlag.NAME_EXIT_CLEAR_PGM_FLAG + " : " + envConFigConfig.getUiControlFlag().getExit_clear_pgm_flag());
        Log.info(EnvConFigConfig.UiControlFlag.NAME_UI_CLEAR_PGM_FLAG + " : " + envConFigConfig.getUiControlFlag().getUi_clear_pgm_flag());
        Log.info(EnvConFigConfig.UiControlFlag.NAME_START_CLEAR_PGM_FLAG + " : " + envConFigConfig.getUiControlFlag().getStart_clear_pgm_flag());

        Log.info(EnvConFigConfig.ManualKeyinControl.MANUALINPUTIMEGAP + " : " + envConFigConfig.getManualKeyinControl().getManualInputTimeGap());

        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_M01_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_M02_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_M03_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_M04_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_M05_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_M06_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_M07_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_M08_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_M09_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_M10_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_M11_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_M12_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_M13_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_M14_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());


        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_O01_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_O02_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_O03_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_O04_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_O05_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_O06_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_O07_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_O08_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_O09_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_O10_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_O11_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_O12_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_O13_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_O14_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_M01_flag());


        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_U01_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_U01_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_U02_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_U02_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_U03_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_U03_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_U04_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_U04_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_U05_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_U05_flag());
        Log.info(EnvConFigConfig.AlarmControLFlag.NAME_ALARM_U06_FLAG + " : " + envConFigConfig.getAlarmControLFlag().getAlarm_U06_flag());

        GlobalContext.CreatFtpMode();
        GlobalContext.CreatSocketPort();
        GlobalContext.CreatCommand();

        /**
         * 赋值
         */
        Temporary.path = envConFigConfig.getMainPath().getLocal_dlog_path() + GlobalContext.UI_message+ File.separator + InetAddress.getLocalHost().getHostName();
        GlobalContext.local_errordata_folderpath = envConFigConfig.getMainPath().getLocal_dlog_path() + "\\"
                + GlobalContext.ErrorData;
        GlobalContext.local_tempdata_folderpath = envConFigConfig.getMainPath().getLocal_dlog_path() + "\\"
                + GlobalContext.TempData;
        GlobalContext.local_UImessage_path = envConFigConfig.getMainPath().getLocal_dlog_path() + "\\"
                + GlobalContext.UI_message + "\\" + pcname;
        GlobalContext.server_UImessage_path = envConFigConfig.getMainPath().getLocal_dlog_path() + "\\"
                + GlobalContext.UI_message + "\\" + pcname;
        GlobalContext.server_errordata_folderpath =  envConFigConfig.getMainPath().getServer_dlog_path()+
                GlobalContext.ErrorData;
        GlobalContext.local_mes_filepath = envConFigConfig.getMainPath().getLocal_dlog_path() + "\\"
                + GlobalContext.MES;
    }
}