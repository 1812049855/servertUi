package com.fhec.context;

import java.io.Serializable;

/**
 * Envconfig
 *
 * @author Archer.W
 * @date 2021/04/16 11:10
 **/
public class EnvConFigConfig {

    private AlarmControLFlag alarmControLFlag;
    private MainPath mainPath;
    private ManualKeyinControl manualKeyinControl;
    private ProjectPassword projectPassword;
    private ServerDataIP serverDataIP;
    private ServerProgramIP serverProgramIP;
    private UiControlFlag uiControlFlag;
    /**
     * \
     * 卸载程序
     */
    public final static String uninstall = "1";
    /**
     * 返回上一步
     */
    public final static String recover = "0";

    public AlarmControLFlag getAlarmControLFlag() {
        return alarmControLFlag;
    }

    public void setAlarmControLFlag(AlarmControLFlag alarmControLFlag) {
        this.alarmControLFlag = alarmControLFlag;
    }

    public MainPath getMainPath() {
        return mainPath;
    }

    public void setMainPath(MainPath mainPath) {
        this.mainPath = mainPath;
    }

    public ManualKeyinControl getManualKeyinControl() {
        return manualKeyinControl;
    }

    public void setManualKeyinControl(ManualKeyinControl manualKeyinControl) {
        this.manualKeyinControl = manualKeyinControl;
    }

    public ProjectPassword getProjectPassword() {
        return projectPassword;
    }

    public void setProjectPassword(ProjectPassword projectPassword) {
        this.projectPassword = projectPassword;
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

    public UiControlFlag getUiControlFlag() {
        return uiControlFlag;
    }

    public void setUiControlFlag(UiControlFlag uiControlFlag) {
        this.uiControlFlag = uiControlFlag;
    }

    public static class AlarmControLFlag {
        /**
         * alarm_M01_flag : 1
         * alarm_M02_flag : 1
         * alarm_M03_flag : 1
         * alarm_M04_flag : 1
         * alarm_M05_flag : 1
         * alarm_M06_flag : 1
         * alarm_M07_flag : 1
         * alarm_M08_flag : 1
         * alarm_M09_flag : 1
         * alarm_M10_flag : 1
         * alarm_M11_flag : 1
         * alarm_M12_flag : 1
         * alarm_M13_flag : 1
         * alarm_M14_flag : 1
         * alarm_O01_flag : 1
         * alarm_O02_flag : 1
         * alarm_O03_flag : 1
         * alarm_O04_flag : 1
         * alarm_O05_flag : 1
         * alarm_O06_flag : 1
         * alarm_O07_flag : 1
         * alarm_O08_flag : 1
         * alarm_O09_flag : 1
         * alarm_O10_flag : 1
         * alarm_O11_flag : 1
         * alarm_O12_flag : 1
         * alarm_O13_flag : 1
         * alarm_O14_flag : 1
         * alarm_U01_flag : 1
         * alarm_U02_flag : 1
         * alarm_U03_flag : 1
         * alarm_U04_flag : 1
         * alarm_U05_flag : 1
         * alarm_U06_flag : 1
         */

        private String alarm_M01_flag;
        private String alarm_M02_flag;
        private String alarm_M03_flag;
        private String alarm_M04_flag;
        private String alarm_M05_flag;
        private String alarm_M06_flag;
        private String alarm_M07_flag;
        private String alarm_M08_flag;
        private String alarm_M09_flag;
        private String alarm_M10_flag;
        private String alarm_M11_flag;
        private String alarm_M12_flag;
        private String alarm_M13_flag;
        private String alarm_M14_flag;
        private String alarm_O01_flag;
        private String alarm_O02_flag;
        private String alarm_O03_flag;
        private String alarm_O04_flag;
        private String alarm_O05_flag;
        private String alarm_O06_flag;
        private String alarm_O07_flag;
        private String alarm_O08_flag;
        private String alarm_O09_flag;
        private String alarm_O10_flag;
        private String alarm_O11_flag;
        private String alarm_O12_flag;
        private String alarm_O13_flag;
        private String alarm_O14_flag;
        private String alarm_U01_flag;
        private String alarm_U02_flag;
        private String alarm_U03_flag;
        private String alarm_U04_flag;
        private String alarm_U05_flag;
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

    public static class MainPath {
        /**
         * local_dlog_path : D:\datalog\
         * local_prog_path : D:\Devices\
         * server_dlog_path : \
         * server_mes_path : \meslog\
         * server_password_path : \password\
         * server_prog_path : \J750\product\
         */

        private String local_dlog_path;
        private String local_prog_path;
        private String server_dlog_path;
        private String server_mes_path;
        private String server_password_path;
        private String server_prog_path;

        public String getLocal_dlog_path() {
            return local_dlog_path;
        }

        public void setLocal_dlog_path(String local_dlog_path) {
            this.local_dlog_path = local_dlog_path;
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

        public String getServer_prog_path() {
            return server_prog_path;
        }

        public void setServer_prog_path(String server_prog_path) {
            this.server_prog_path = server_prog_path;
        }
    }

    public static class ManualKeyinControl {
        /**
         * manualInputTimeGap : 30
         */

        private String manualInputTimeGap;

        public String getManualInputTimeGap() {
            return manualInputTimeGap;
        }

        public void setManualInputTimeGap(String manualInputTimeGap) {
            this.manualInputTimeGap = manualInputTimeGap;
        }
    }

    public static class ProjectPassword{
        /**
         * project_password : AAA
         */

        private String project_password;

        public String getProject_password() {
            return project_password;
        }

        public void setProject_password(String project_password) {
            this.project_password = project_password;
        }
    }

    public static class ServerDataIP {
        /**
         * server_data_IP : 172.16.200.31
         * server_data_password : user
         * server_data_user : user
         */

        private String server_data_IP;
        private String server_data_password;
        private String server_data_user;

        public String getServer_data_IP() {
            return server_data_IP;
        }

        public void setServer_data_IP(String server_data_IP) {
            this.server_data_IP = server_data_IP;
        }

        public String getServer_data_password() {
            return server_data_password;
        }

        public void setServer_data_password(String server_data_password) {
            this.server_data_password = server_data_password;
        }

        public String getServer_data_user() {
            return server_data_user;
        }

        public void setServer_data_user(String server_data_user) {
            this.server_data_user = server_data_user;
        }
    }

    public static class ServerProgramIP {
        /**
         * server_pgm_IP : 172.16.204.114
         * server_pgm_password : test
         * server_pgm_user : test
         */

        private String server_pgm_IP;
        private String server_pgm_password;
        private String server_pgm_user;

        public String getServer_pgm_IP() {
            return server_pgm_IP;
        }

        public void setServer_pgm_IP(String server_pgm_IP) {
            this.server_pgm_IP = server_pgm_IP;
        }

        public String getServer_pgm_password() {
            return server_pgm_password;
        }

        public void setServer_pgm_password(String server_pgm_password) {
            this.server_pgm_password = server_pgm_password;
        }

        public String getServer_pgm_user() {
            return server_pgm_user;
        }

        public void setServer_pgm_user(String server_pgm_user) {
            this.server_pgm_user = server_pgm_user;
        }
    }

    public static class UiControlFlag {
        /**
         * exit_clear_pgm_flag : 1
         * start_clear_pgm_flag : 1
         * ui_clear_pgm_flag : 1
         */

        private String exit_clear_pgm_flag;
        private String start_clear_pgm_flag;
        private String ui_clear_pgm_flag;

        public String getExit_clear_pgm_flag() {
            return exit_clear_pgm_flag;
        }

        public void setExit_clear_pgm_flag(String exit_clear_pgm_flag) {
            this.exit_clear_pgm_flag = exit_clear_pgm_flag;
        }

        public String getStart_clear_pgm_flag() {
            return start_clear_pgm_flag;
        }

        public void setStart_clear_pgm_flag(String start_clear_pgm_flag) {
            this.start_clear_pgm_flag = start_clear_pgm_flag;
        }

        public String getUi_clear_pgm_flag() {
            return ui_clear_pgm_flag;
        }

        public void setUi_clear_pgm_flag(String ui_clear_pgm_flag) {
            this.ui_clear_pgm_flag = ui_clear_pgm_flag;
        }
    }
}
