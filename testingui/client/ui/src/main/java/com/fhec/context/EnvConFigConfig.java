package com.fhec.context;

import com.fhec.config.ini.INISection;
import com.fhec.config.ini.INISectionNode;

public class EnvConFigConfig {
    public final static String GROUPNAME_SERVER_DATA_IP = "server_data_IP";
    public final static String GROUPNAME_SERVER_PROGRAM_IP = "server_program_IP";
    public final static String GROUPNAME_PROJECT_PASSWORD = "project_password";
    public final static String GROUPNAME_MAIN_PATH = "main path";
    public final static String GROUPNAME_UI_CONTROL_FLAG = "ui_control_flag";
    public final static String GROUPNAME_MANUAL_KEYIN_CONTROL = "manual_keyin_control";
    public final static String GROUPNAME_ALARM_CONTROL_FLAG = "alarm_control_flag";
    /**
     * \
     * 卸载程序
     */
    public final static String uninstall = "1";
    /**
     * 返回上一步
     */
    public final static String recover = "0";

    @INISection(name = GROUPNAME_SERVER_DATA_IP,isRequired = false)
    private ServerDataIP serverDataIP;

    @INISection(name = GROUPNAME_SERVER_PROGRAM_IP,isRequired = false)
    private ServerProgramIP serverProgramIP;

    @INISection(name = GROUPNAME_PROJECT_PASSWORD,isRequired = false)
    private ProjectPassword projectPassword;

    @INISection(name = GROUPNAME_MAIN_PATH,isRequired = false)
    private MainPath mainPath;

    @INISection(name = GROUPNAME_UI_CONTROL_FLAG,isRequired = false)
    private UiControlFlag uiControlFlag;

    @INISection(name = GROUPNAME_MANUAL_KEYIN_CONTROL,isRequired = false)
    private ManualKeyinControl manualKeyinControl;

    @INISection(name = GROUPNAME_ALARM_CONTROL_FLAG,isRequired = false)
    private AlarmControLFlag alarmControLFlag;

    public static class ServerDataIP {
        public final static String NAME_SERVER_DATA_IP = "server_data_IP";
        public final static String NAME_SERVER_DATA_USER = "server_data_user";
        public final static String NAME_SERVER_DATA_PASSWORD = "server_data_password";
        @INISectionNode(name = NAME_SERVER_DATA_IP,isRequired = false)
        private String server_data_IP;
        @INISectionNode(name = NAME_SERVER_DATA_USER,isRequired = false)
        private String server_data_user;
        @INISectionNode(name = NAME_SERVER_DATA_PASSWORD,isRequired = false)
        private String server_data_password;
        public String getServer_data_IP() {
            return server_data_IP;
        }

        public void setServer_data_IP(String server_data_IP) {
            this.server_data_IP = server_data_IP;
        }

        public String getServer_data_user() {
            return server_data_user;
        }

        public void setServer_data_user(String server_data_user) {
            this.server_data_user = server_data_user;
        }

        public String getServer_data_password() {
            return server_data_password;
        }

        public void setServer_data_password(String server_data_password) {
            this.server_data_password = server_data_password;
        }
    }

    public static class ServerProgramIP {
        public final static String NAME_SERVER_PGM_IP = "server_pgm_IP";
        public final static String NAME_SERVER_PGM_USER = "server_pgm_user";
        public final static String NAME_SERVER_PGM_PASSWORD = "server_pgm_password";

        @INISectionNode(name = NAME_SERVER_PGM_IP,isRequired = false)
        private String server_pgm_IP;
        @INISectionNode(name = NAME_SERVER_PGM_USER,isRequired = false)
        private String server_pgm_user;
        @INISectionNode(name = NAME_SERVER_PGM_PASSWORD,isRequired = false)
        private String server_pgm_password;

        public String getServer_pgm_IP() {
            return server_pgm_IP;
        }

        public void setServer_pgm_IP(String server_pgm_IP) {
            this.server_pgm_IP = server_pgm_IP;
        }

        public String getServer_pgm_user() {
            return server_pgm_user;
        }

        public void setServer_pgm_user(String server_pgm_user) {
            this.server_pgm_user = server_pgm_user;
        }

        public String getServer_pgm_password() {
            return server_pgm_password;
        }

        public void setServer_pgm_password(String server_pgm_password) {
            this.server_pgm_password = server_pgm_password;
        }
    }

    public static class ProjectPassword {
        public final static String PROJECT_PASSWORD = "project_password";
        @INISectionNode(name = PROJECT_PASSWORD,isRequired = false)
        private String project_password;

        public String getProject_password() {
            return project_password;
        }

        public void setProject_password(String project_password) {
            this.project_password = project_password;
        }
    }

    public static class MainPath {
        public final static String NAME_LOCAL_DLOG_PATH = "Local_dlog_path";
        public final static String NAME_LOCAL_PROG_PATH = "local_prog_path";
        public final static String NAME_SERVER_DLOG_PATH = "server_dlog_path";
        public final static String NAME_SERVER_PROG_PATH = "server_prog_path";
        public final static String NAME_SERVER_MES_PATH = "server_mes_path";
        public final static String NAME_SERVER_PASSWORD_PATH = "server_password_path";
        @INISectionNode(name = NAME_LOCAL_DLOG_PATH,isRequired = false)
        private String Local_dlog_path;
        @INISectionNode(name = NAME_LOCAL_PROG_PATH,isRequired = false)
        private String local_prog_path;
        @INISectionNode(name = NAME_SERVER_DLOG_PATH,isRequired = false)
        private String server_dlog_path;
        @INISectionNode(name = NAME_SERVER_PROG_PATH,isRequired = false)
        private String server_prog_path;
        @INISectionNode(name = NAME_SERVER_MES_PATH,isRequired = false)
        private String server_mes_path;
        @INISectionNode(name = NAME_SERVER_PASSWORD_PATH,isRequired = false)
        private String server_password_path;

        public String getLocal_dlog_path() {
            return Local_dlog_path;
        }

        public void setLocal_dlog_path(String local_dlog_path) {
            Local_dlog_path = local_dlog_path;
        }

        public String getLocal_prog_path() {
            return local_prog_path;
        }

        public void setLocal_prog_path(String local_prog_path) {
            this.local_prog_path = local_prog_path;
        }

        public String getServer_dlog_path() {
            return server_dlog_path;
        }

        public void setServer_dlog_path(String server_dlog_path) {
            this.server_dlog_path = server_dlog_path;
        }

        public String getServer_prog_path() {
            return server_prog_path;
        }

        public void setServer_prog_path(String server_prog_path) {
            this.server_prog_path = server_prog_path;
        }

        public String getServer_mes_path() {
            return server_mes_path;
        }

        public void setServer_mes_path(String server_mes_path) {
            this.server_mes_path = server_mes_path;
        }

        public String getServer_password_path() {
            return server_password_path;
        }

        public void setServer_password_path(String server_password_path) {
            this.server_password_path = server_password_path;
        }
    }

    public static class UiControlFlag {
        public final static String NAME_UI_CLEAR_PGM_FLAG = "ui_clear_pgm_flag";
        public final static String NAME_START_CLEAR_PGM_FLAG = "start_clear_pgm_flag";
        public final static String NAME_EXIT_CLEAR_PGM_FLAG = "exit_clear_pgm_flag";
        @INISectionNode(name = NAME_UI_CLEAR_PGM_FLAG,isRequired = false)
        private String ui_clear_pgm_flag;
        @INISectionNode(name = NAME_START_CLEAR_PGM_FLAG,isRequired = false)
        private String start_clear_pgm_flag;
        @INISectionNode(name = NAME_EXIT_CLEAR_PGM_FLAG,isRequired = false)
        private String exit_clear_pgm_flag;

        public String getUi_clear_pgm_flag() {
            return ui_clear_pgm_flag;
        }

        public void setUi_clear_pgm_flag(String ui_clear_pgm_flag) {
            this.ui_clear_pgm_flag = ui_clear_pgm_flag;
        }

        public String getStart_clear_pgm_flag() {
            return start_clear_pgm_flag;
        }

        public void setStart_clear_pgm_flag(String start_clear_pgm_flag) {
            this.start_clear_pgm_flag = start_clear_pgm_flag;
        }

        public String getExit_clear_pgm_flag() {
            return exit_clear_pgm_flag;
        }

        public void setExit_clear_pgm_flag(String exit_clear_pgm_flag) {
            this.exit_clear_pgm_flag = exit_clear_pgm_flag;
        }
    }

    public static class ManualKeyinControl {
        public final static String MANUALINPUTIMEGAP = "ManualInputTimeGap";
        @INISectionNode(name = MANUALINPUTIMEGAP,isRequired = false)
        private String manualInputTimeGap;

        public String getManualInputTimeGap() {
            return manualInputTimeGap;
        }

        public void setManualInputTimeGap(String manualInputTimeGap) {
            this.manualInputTimeGap = manualInputTimeGap;
        }
    }

    public static class AlarmControLFlag {
        public final static String NAME_ALARM_M01_FLAG = "alarm_M01_flag";
        public final static String NAME_ALARM_M02_FLAG = "alarm_M02_flag";
        public final static String NAME_ALARM_M03_FLAG = "alarm_M03_flag";
        public final static String NAME_ALARM_M04_FLAG = "alarm_M04_flag";
        public final static String NAME_ALARM_M05_FLAG = "alarm_M05_flag";
        public final static String NAME_ALARM_M06_FLAG = "alarm_M06_flag";
        public final static String NAME_ALARM_M07_FLAG = "alarm_M07_flag";
        public final static String NAME_ALARM_M08_FLAG = "alarm_M08_flag";
        public final static String NAME_ALARM_M09_FLAG = "alarm_M09_flag";
        public final static String NAME_ALARM_M10_FLAG = "alarm_M10_flag";
        public final static String NAME_ALARM_M11_FLAG = "alarm_M11_flag";
        public final static String NAME_ALARM_M12_FLAG = "alarm_M12_flag";
        public final static String NAME_ALARM_M13_FLAG = "alarm_M13_flag";
        public final static String NAME_ALARM_M14_FLAG = "alarm_M14_flag";
        public final static String NAME_ALARM_O01_FLAG = "alarm_O01_flag";
        public final static String NAME_ALARM_O02_FLAG = "alarm_O02_flag";
        public final static String NAME_ALARM_O03_FLAG = "alarm_O03_flag";
        public final static String NAME_ALARM_O04_FLAG = "alarm_O04_flag";
        public final static String NAME_ALARM_O05_FLAG = "alarm_O05_flag";
        public final static String NAME_ALARM_O06_FLAG = "alarm_O06_flag";
        public final static String NAME_ALARM_O07_FLAG = "alarm_O07_flag";
        public final static String NAME_ALARM_O08_FLAG = "alarm_O08_flag";
        public final static String NAME_ALARM_O09_FLAG = "alarm_O09_flag";
        public final static String NAME_ALARM_O10_FLAG = "alarm_O10_flag";
        public final static String NAME_ALARM_O11_FLAG = "alarm_O11_flag";
        public final static String NAME_ALARM_O12_FLAG = "alarm_O12_flag";
        public final static String NAME_ALARM_O13_FLAG = "alarm_O13_flag";
        public final static String NAME_ALARM_O14_FLAG = "alarm_O14_flag";
        public final static String NAME_ALARM_U01_FLAG = "alarm_U01_flag";
        public final static String NAME_ALARM_U02_FLAG = "alarm_U02_flag";
        public final static String NAME_ALARM_U03_FLAG = "alarm_U03_flag";
        public final static String NAME_ALARM_U04_FLAG = "alarm_U04_flag";
        public final static String NAME_ALARM_U05_FLAG = "alarm_U05_flag";
        public final static String NAME_ALARM_U06_FLAG = "alarm_U06_flag";

        @INISectionNode(name = NAME_ALARM_M01_FLAG,isRequired = false)
        private String alarm_M01_flag;
        @INISectionNode(name = NAME_ALARM_M02_FLAG,isRequired = false)
        private String alarm_M02_flag;
        @INISectionNode(name = NAME_ALARM_M03_FLAG,isRequired = false)
        private String alarm_M03_flag;
        @INISectionNode(name = NAME_ALARM_M04_FLAG,isRequired = false)
        private String alarm_M04_flag;
        @INISectionNode(name = NAME_ALARM_M05_FLAG,isRequired = false)
        private String alarm_M05_flag;
        @INISectionNode(name = NAME_ALARM_M06_FLAG,isRequired = false)
        private String alarm_M06_flag;
        @INISectionNode(name = NAME_ALARM_M07_FLAG,isRequired = false)
        private String alarm_M07_flag;
        @INISectionNode(name = NAME_ALARM_M08_FLAG,isRequired = false)
        private String alarm_M08_flag;
        @INISectionNode(name = NAME_ALARM_M09_FLAG,isRequired = false)
        private String alarm_M09_flag;
        @INISectionNode(name = NAME_ALARM_M10_FLAG,isRequired = false)
        private String alarm_M10_flag;
        @INISectionNode(name = NAME_ALARM_M11_FLAG,isRequired = false)
        private String alarm_M11_flag;
        @INISectionNode(name = NAME_ALARM_M12_FLAG,isRequired = false)
        private String alarm_M12_flag;
        @INISectionNode(name = NAME_ALARM_M13_FLAG,isRequired = false)
        private String alarm_M13_flag;
        @INISectionNode(name = NAME_ALARM_M14_FLAG,isRequired = false)
        private String alarm_M14_flag;
        @INISectionNode(name = NAME_ALARM_O01_FLAG,isRequired = false)
        private String alarm_O01_flag;
        @INISectionNode(name = NAME_ALARM_O02_FLAG,isRequired = false)
        private String alarm_O02_flag;
        @INISectionNode(name = NAME_ALARM_O03_FLAG,isRequired = false)
        private String alarm_O03_flag;
        @INISectionNode(name = NAME_ALARM_O04_FLAG,isRequired = false)
        private String alarm_O04_flag;
        @INISectionNode(name = NAME_ALARM_O05_FLAG,isRequired = false)
        private String alarm_O05_flag;
        @INISectionNode(name = NAME_ALARM_O06_FLAG,isRequired = false)
        private String alarm_O06_flag;
        @INISectionNode(name = NAME_ALARM_O07_FLAG,isRequired = false)
        private String alarm_O07_flag;
        @INISectionNode(name = NAME_ALARM_O08_FLAG,isRequired = false)
        private String alarm_O08_flag;
        @INISectionNode(name = NAME_ALARM_O09_FLAG,isRequired = false)
        private String alarm_O09_flag;
        @INISectionNode(name = NAME_ALARM_O10_FLAG,isRequired = false)
        private String alarm_O10_flag;
        @INISectionNode(name = NAME_ALARM_O11_FLAG,isRequired = false)
        private String alarm_O11_flag;
        @INISectionNode(name = NAME_ALARM_O12_FLAG,isRequired = false)
        private String alarm_O12_flag;
        @INISectionNode(name = NAME_ALARM_O13_FLAG,isRequired = false)
        private String alarm_O13_flag;
        @INISectionNode(name = NAME_ALARM_O14_FLAG,isRequired = false)
        private String alarm_O14_flag;
        @INISectionNode(name = NAME_ALARM_U01_FLAG,isRequired = false)
        private String alarm_U01_flag;
        @INISectionNode(name = NAME_ALARM_U02_FLAG,isRequired = false)
        private String alarm_U02_flag;
        @INISectionNode(name = NAME_ALARM_U03_FLAG,isRequired = false)
        private String alarm_U03_flag;
        @INISectionNode(name = NAME_ALARM_U04_FLAG,isRequired = false)
        private String alarm_U04_flag;
        @INISectionNode(name = NAME_ALARM_U05_FLAG,isRequired = false)
        private String alarm_U05_flag;
        @INISectionNode(name = NAME_ALARM_U06_FLAG,isRequired = false)
        private String alarm_U06_flag;

        public String getAlarm_M01_flag() {
            return alarm_M01_flag;
        }

        public void setAlarm_M01_flag(String alarm_M01_flag) {
            this.alarm_M01_flag = alarm_M01_flag;
        }

        public String getAlarm_M02_flag() {
            return alarm_M02_flag;
        }

        public void setAlarm_M02_flag(String alarm_M02_flag) {
            this.alarm_M02_flag = alarm_M02_flag;
        }

        public String getAlarm_M03_flag() {
            return alarm_M03_flag;
        }

        public void setAlarm_M03_flag(String alarm_M03_flag) {
            this.alarm_M03_flag = alarm_M03_flag;
        }

        public String getAlarm_M04_flag() {
            return alarm_M04_flag;
        }

        public void setAlarm_M04_flag(String alarm_M04_flag) {
            this.alarm_M04_flag = alarm_M04_flag;
        }

        public String getAlarm_M05_flag() {
            return alarm_M05_flag;
        }

        public void setAlarm_M05_flag(String alarm_M05_flag) {
            this.alarm_M05_flag = alarm_M05_flag;
        }

        public String getAlarm_M06_flag() {
            return alarm_M06_flag;
        }

        public void setAlarm_M06_flag(String alarm_M06_flag) {
            this.alarm_M06_flag = alarm_M06_flag;
        }

        public String getAlarm_M07_flag() {
            return alarm_M07_flag;
        }

        public void setAlarm_M07_flag(String alarm_M07_flag) {
            this.alarm_M07_flag = alarm_M07_flag;
        }

        public String getAlarm_M08_flag() {
            return alarm_M08_flag;
        }

        public void setAlarm_M08_flag(String alarm_M08_flag) {
            this.alarm_M08_flag = alarm_M08_flag;
        }

        public String getAlarm_M09_flag() {
            return alarm_M09_flag;
        }

        public void setAlarm_M09_flag(String alarm_M09_flag) {
            this.alarm_M09_flag = alarm_M09_flag;
        }

        public String getAlarm_M10_flag() {
            return alarm_M10_flag;
        }

        public void setAlarm_M10_flag(String alarm_M10_flag) {
            this.alarm_M10_flag = alarm_M10_flag;
        }

        public String getAlarm_M11_flag() {
            return alarm_M11_flag;
        }

        public void setAlarm_M11_flag(String alarm_M11_flag) {
            this.alarm_M11_flag = alarm_M11_flag;
        }

        public String getAlarm_M12_flag() {
            return alarm_M12_flag;
        }

        public void setAlarm_M12_flag(String alarm_M12_flag) {
            this.alarm_M12_flag = alarm_M12_flag;
        }

        public String getAlarm_M13_flag() {
            return alarm_M13_flag;
        }

        public void setAlarm_M13_flag(String alarm_M13_flag) {
            this.alarm_M13_flag = alarm_M13_flag;
        }

        public String getAlarm_M14_flag() {
            return alarm_M14_flag;
        }

        public void setAlarm_M14_flag(String alarm_M14_flag) {
            this.alarm_M14_flag = alarm_M14_flag;
        }

        public String getAlarm_O01_flag() {
            return alarm_O01_flag;
        }

        public void setAlarm_O01_flag(String alarm_O01_flag) {
            this.alarm_O01_flag = alarm_O01_flag;
        }

        public String getAlarm_O02_flag() {
            return alarm_O02_flag;
        }

        public void setAlarm_O02_flag(String alarm_O02_flag) {
            this.alarm_O02_flag = alarm_O02_flag;
        }

        public String getAlarm_O03_flag() {
            return alarm_O03_flag;
        }

        public void setAlarm_O03_flag(String alarm_O03_flag) {
            this.alarm_O03_flag = alarm_O03_flag;
        }

        public String getAlarm_O04_flag() {
            return alarm_O04_flag;
        }

        public void setAlarm_O04_flag(String alarm_O04_flag) {
            this.alarm_O04_flag = alarm_O04_flag;
        }

        public String getAlarm_O05_flag() {
            return alarm_O05_flag;
        }

        public void setAlarm_O05_flag(String alarm_O05_flag) {
            this.alarm_O05_flag = alarm_O05_flag;
        }

        public String getAlarm_O06_flag() {
            return alarm_O06_flag;
        }

        public void setAlarm_O06_flag(String alarm_O06_flag) {
            this.alarm_O06_flag = alarm_O06_flag;
        }

        public String getAlarm_O07_flag() {
            return alarm_O07_flag;
        }

        public void setAlarm_O07_flag(String alarm_O07_flag) {
            this.alarm_O07_flag = alarm_O07_flag;
        }

        public String getAlarm_O08_flag() {
            return alarm_O08_flag;
        }

        public void setAlarm_O08_flag(String alarm_O08_flag) {
            this.alarm_O08_flag = alarm_O08_flag;
        }

        public String getAlarm_O09_flag() {
            return alarm_O09_flag;
        }

        public void setAlarm_O09_flag(String alarm_O09_flag) {
            this.alarm_O09_flag = alarm_O09_flag;
        }

        public String getAlarm_O10_flag() {
            return alarm_O10_flag;
        }

        public void setAlarm_O10_flag(String alarm_O10_flag) {
            this.alarm_O10_flag = alarm_O10_flag;
        }

        public String getAlarm_O11_flag() {
            return alarm_O11_flag;
        }

        public void setAlarm_O11_flag(String alarm_O11_flag) {
            this.alarm_O11_flag = alarm_O11_flag;
        }

        public String getAlarm_O12_flag() {
            return alarm_O12_flag;
        }

        public void setAlarm_O12_flag(String alarm_O12_flag) {
            this.alarm_O12_flag = alarm_O12_flag;
        }

        public String getAlarm_O13_flag() {
            return alarm_O13_flag;
        }

        public void setAlarm_O13_flag(String alarm_O13_flag) {
            this.alarm_O13_flag = alarm_O13_flag;
        }

        public String getAlarm_O14_flag() {
            return alarm_O14_flag;
        }

        public void setAlarm_O14_flag(String alarm_O14_flag) {
            this.alarm_O14_flag = alarm_O14_flag;
        }

        public String getAlarm_U01_flag() {
            return alarm_U01_flag;
        }

        public void setAlarm_U01_flag(String alarm_U01_flag) {
            this.alarm_U01_flag = alarm_U01_flag;
        }

        public String getAlarm_U02_flag() {
            return alarm_U02_flag;
        }

        public void setAlarm_U02_flag(String alarm_U02_flag) {
            this.alarm_U02_flag = alarm_U02_flag;
        }

        public String getAlarm_U03_flag() {
            return alarm_U03_flag;
        }

        public void setAlarm_U03_flag(String alarm_U03_flag) {
            this.alarm_U03_flag = alarm_U03_flag;
        }

        public String getAlarm_U04_flag() {
            return alarm_U04_flag;
        }

        public void setAlarm_U04_flag(String alarm_U04_flag) {
            this.alarm_U04_flag = alarm_U04_flag;
        }

        public String getAlarm_U05_flag() {
            return alarm_U05_flag;
        }

        public void setAlarm_U05_flag(String alarm_U05_flag) {
            this.alarm_U05_flag = alarm_U05_flag;
        }

        public String getAlarm_U06_flag() {
            return alarm_U06_flag;
        }

        public void setAlarm_U06_flag(String alarm_U06_flag) {
            this.alarm_U06_flag = alarm_U06_flag;
        }
    }

    public ServerDataIP getServerDataIP() {
        return serverDataIP;
    }

    public void setServerDataIP(ServerDataIP serverDataIP) {
        this.serverDataIP = serverDataIP;
    }

    public ServerProgramIP getServerProgramIP() {
        return serverProgramIP;
    }

    public void setServerProgramIP(ServerProgramIP serverProgramIP) {
        this.serverProgramIP = serverProgramIP;
    }

    public ProjectPassword getProjectPassword() {
        return projectPassword;
    }

    public void setProjectPassword(ProjectPassword projectPassword) {
        this.projectPassword = projectPassword;
    }

    public MainPath getMainPath() {
        return mainPath;
    }

    public void setMainPath(MainPath mainPath) {
        this.mainPath = mainPath;
    }

    public UiControlFlag getUiControlFlag() {
        return uiControlFlag;
    }

    public void setUiControlFlag(UiControlFlag uiControlFlag) {
        this.uiControlFlag = uiControlFlag;
    }

    public ManualKeyinControl getManualKeyinControl() {
        return manualKeyinControl;
    }

    public void setManualKeyinControl(ManualKeyinControl manualKeyinControl) {
        this.manualKeyinControl = manualKeyinControl;
    }

    public AlarmControLFlag getAlarmControLFlag() {
        return alarmControLFlag;
    }

    public void setAlarmControLFlag(AlarmControLFlag alarmControLFlag) {
        this.alarmControLFlag = alarmControLFlag;
    }
}
