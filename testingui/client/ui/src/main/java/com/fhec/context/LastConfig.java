package com.fhec.context;

import com.fhec.config.ini.INISectionNode;

public class LastConfig {
    public final static String NAMEW_LAST_DEVICE_NAME = "last_device_name";
    public final static String NAMEW_LAST_PROGRAM_NAME = "last_program_name";
    public final static String NAMEW_LAST_TESTEROS = "last_TesterOS";
    public final static String NAMEW_LAST_TESTFLOW = "last_testflow";
    public final static String NAMEW_LAST_TESTCODE = "last_testcode";
    public final static String NAMEW_LAST_PROGRAMNAME = "last_programname";
    public final static String NAMEW_LAST_PROGFOLDER = "last_progfolder";
    public final static String NAMEW_LAST_ZIPFILE = "last_zipfile";
    public final static String NAMEW_LAST_MODECODE = "last_modecode";
//    public final static String NAMEW_LASTTESTFLOW = "lasttestflow";
//    public final static String NAMEW_LASZIPFILE = "lastzipfile";
    
//    @INISectionNode(name = NAMEW_LASTTESTFLOW,isRequired = false)
//    private String lasttestflow;
//    @INISectionNode(name = NAMEW_LASZIPFILE,isRequired = false)
//    private String lastzipfile;
    @INISectionNode(name = NAMEW_LAST_DEVICE_NAME,isRequired = false)
    private String last_device_name;
    @INISectionNode(name = NAMEW_LAST_PROGRAM_NAME, isRequired = false)
    private String last_program_name;
    @INISectionNode(name = NAMEW_LAST_TESTEROS,isRequired = false)
    private String last_TesterOS;
    @INISectionNode(name = NAMEW_LAST_TESTFLOW,isRequired = false)
    private String last_testflow;
    @INISectionNode(name = NAMEW_LAST_TESTCODE, isRequired = false)
    private String last_testcode;
    @INISectionNode(name = NAMEW_LAST_PROGRAMNAME,isRequired = false)
    private String last_programname;
    @INISectionNode(name = NAMEW_LAST_PROGFOLDER,isRequired = false)
    private String last_progfolder;
    @INISectionNode(name = NAMEW_LAST_ZIPFILE,isRequired = false)
    private String last_zipfile;
    @INISectionNode(name = NAMEW_LAST_MODECODE,isRequired = false)
    private String last_modecode;

//    public String getLasttestflow() {
//		return lasttestflow;
//	}
//
//	public void setLasttestflow(String lasttestflow) {
//		this.lasttestflow = lasttestflow;
//	}
//
//	public String getLastzipfile() {
//		return lastzipfile;
//	}
//
//	public void setLastzipfile(String lastzipfile) {
//		this.lastzipfile = lastzipfile;
//	}

	public String getLast_device_name() {
        return last_device_name;
    }

    public void setLast_device_name(String last_device_name) {
        this.last_device_name = last_device_name;
    }

    public String getLast_program_name() {
        return last_program_name;
    }

    public void setLast_program_name(String last_program_name) {
        this.last_program_name = last_program_name;
    }

    public String getLast_TesterOS() {
        return last_TesterOS;
    }

    public void setLast_TesterOS(String last_TesterOS) {
        this.last_TesterOS = last_TesterOS;
    }

    public String getLast_testflow() {
        return last_testflow;
    }

    public void setLast_testflow(String last_testflow) {
        this.last_testflow = last_testflow;
    }

    public String getLast_testcode() {
        return last_testcode;
    }

    public void setLast_testcode(String last_testcode) {
        this.last_testcode = last_testcode;
    }

    public String getLast_programname() {
        return last_programname;
    }

    public void setLast_programname(String last_programname) {
        this.last_programname = last_programname;
    }

    public String getLast_progfolder() {
        return last_progfolder;
    }

    public void setLast_progfolder(String last_progfolder) {
        this.last_progfolder = last_progfolder;
    }

    public String getLast_zipfile() {
        return last_zipfile;
    }

    public void setLast_zipfile(String last_zipfile) {
        this.last_zipfile = last_zipfile;
    }

    public String getLast_modecode() {
        return last_modecode;
    }

    public void setLast_modecode(String last_modecode) {
        this.last_modecode = last_modecode;
    }
    
}
