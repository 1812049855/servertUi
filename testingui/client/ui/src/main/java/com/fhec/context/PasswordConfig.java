package com.fhec.context;

import com.fhec.config.ini.INISection;
import com.fhec.config.ini.INISectionNode;

public class PasswordConfig {
    public final static String NAME_OPERATOR_MODE_PASSWORD = "operator_mode_password";

    public final static String NAME_ALARM_PASSWORD = "alarm_password";

    public final static String NAME_SITE_ALARM_PASSWORD = "site_alarm_password";

    @INISection(name = NAME_OPERATOR_MODE_PASSWORD,isRequired = false)
    private OperatorModePassword operatorModePassword;

    @INISection(name = NAME_ALARM_PASSWORD,isRequired = false)
    private AlarmPassword alarmPassword;

    @INISection(name = NAME_SITE_ALARM_PASSWORD,isRequired = false)
    private SiteAlarmPassword siteAlarmPassword;

    public OperatorModePassword getOperatorModePassword() {
        return operatorModePassword;
    }

    public void setOperatorModePassword(OperatorModePassword operatorModePassword) {
        this.operatorModePassword = operatorModePassword;
    }

    public AlarmPassword getAlarmPassword() {
        return alarmPassword;
    }

    public void setAlarmPassword(AlarmPassword alarmPassword) {
        this.alarmPassword = alarmPassword;
    }

    public SiteAlarmPassword getSiteAlarmPassword() {
        return siteAlarmPassword;
    }

    public void setSiteAlarmPassword(SiteAlarmPassword siteAlarmPassword) {
        this.siteAlarmPassword = siteAlarmPassword;
    }

    public static class OperatorModePassword {

        public final static String NAME_OPERATOR_MODE_PASSWORD = "operator_mode_password";

        @INISectionNode(name = NAME_OPERATOR_MODE_PASSWORD, arrayCount = 2)
        private String[] operator_mode_passwords;

        public String[] getOperator_mode_passwords() {
            return operator_mode_passwords;
        }

        public void setOperator_mode_passwords(String[] operator_mode_passwords) {
            this.operator_mode_passwords = operator_mode_passwords;
        }

    }

    public static class AlarmPassword {

        public final static String NAME_ALARM_PASSWORD = "alarm_password";

        @INISectionNode
        private String alarm_password;

        public String getAlarm_password() {
            return alarm_password;
        }

        public void setAlarm_password(String alarm_password) {
            this.alarm_password = alarm_password;
        }

    }

    public static class SiteAlarmPassword {

        public final static String NAME_PASSWORD1 = "password1";
        public final static String NAME_PASSWORD2 = "password2";

        @INISectionNode
        private String password1;

        @INISectionNode
        private String password2;

        public String getPassword1() {
            return password1;
        }

        public void setPassword1(String password1) {
            this.password1 = password1;
        }

        public String getPassword2() {
            return password2;
        }

        public void setPassword2(String password2) {
            this.password2 = password2;
        }

    }

}
