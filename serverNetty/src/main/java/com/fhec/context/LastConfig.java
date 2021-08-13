package com.fhec.context;

import java.io.Serializable;

/**
 * LastConfig
 *
 * @author Archer.W
 * @date 2021/04/16 11:16
 **/
public class LastConfig  {
    private String last_TesterOS;
    private String last_device_name;
    private String last_modecode;
    private String last_progfolder;
    private String last_program_name;
    private String last_programname;
    private String last_testcode;
    private String last_testflow;
    private String last_zipfile;

    public String getLast_TesterOS() {
        return last_TesterOS;
    }

    public void setLast_TesterOS(String last_TesterOS) {
        this.last_TesterOS = last_TesterOS;
    }

    public String getLast_device_name() {
        return last_device_name;
    }

    public void setLast_device_name(String last_device_name) {
        this.last_device_name = last_device_name;
    }

    public String getLast_modecode() {
        return last_modecode;
    }

    public void setLast_modecode(String last_modecode) {
        this.last_modecode = last_modecode;
    }

    public String getLast_progfolder() {
        return last_progfolder;
    }

    public void setLast_progfolder(String last_progfolder) {
        this.last_progfolder = last_progfolder;
    }

    public String getLast_program_name() {
        return last_program_name;
    }

    public void setLast_program_name(String last_program_name) {
        this.last_program_name = last_program_name;
    }

    public String getLast_programname() {
        return last_programname;
    }

    public void setLast_programname(String last_programname) {
        this.last_programname = last_programname;
    }

    public String getLast_testcode() {
        return last_testcode;
    }

    public void setLast_testcode(String last_testcode) {
        this.last_testcode = last_testcode;
    }

    public String getLast_testflow() {
        return last_testflow;
    }

    public void setLast_testflow(String last_testflow) {
        this.last_testflow = last_testflow;
    }

    public String getLast_zipfile() {
        return last_zipfile;
    }

    public void setLast_zipfile(String last_zipfile) {
        this.last_zipfile = last_zipfile;
    }

    @Override
    public String toString() {
        return "LastConfig{" +
                "last_TesterOS='" + last_TesterOS + '\'' +
                ", last_device_name='" + last_device_name + '\'' +
                ", last_modecode='" + last_modecode + '\'' +
                ", last_progfolder='" + last_progfolder + '\'' +
                ", last_program_name='" + last_program_name + '\'' +
                ", last_programname='" + last_programname + '\'' +
                ", last_testcode='" + last_testcode + '\'' +
                ", last_testflow='" + last_testflow + '\'' +
                ", last_zipfile='" + last_zipfile + '\'' +
                '}';
    }
}
