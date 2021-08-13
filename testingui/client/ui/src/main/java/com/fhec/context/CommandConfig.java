package com.fhec.context;

import com.fhec.config.ini.INISectionNode;

/**
 * Socket指令传输
 *
 * @author Archer.W
 * @date 2021/04/15 16:06
 **/
public class CommandConfig {

    //startlot
    private final static  String NAME_STARTLOT = "STARTLOT";
    //savetestresult
    private final static  String NAME_SAVETESTRESULT = "SAVETESTRESULT";
    //fullend
    private final static  String NAME_FULLEND = "FULLEND";
    //exit
    private final static  String NAME_EXIT = "EXIT";


    @INISectionNode(name = NAME_STARTLOT, isRequired = false)
    private String startLot;
    @INISectionNode(name = NAME_SAVETESTRESULT, isRequired = false)
    private String saveTestResult;
    @INISectionNode(name = NAME_FULLEND, isRequired = false)
    private String fullEnd;
    @INISectionNode(name = NAME_EXIT, isRequired = false)
    private String exit; 


    /**
     * get set
     */

    public String getStartLot() {
        return startLot;
    }

    public void setStartLot(String startLot) {
        this.startLot = startLot;
    }

    public String getSaveTestResult() {
        return saveTestResult;
    }

    public void setSaveTestResult(String saveTestResult) {
        this.saveTestResult = saveTestResult;
    }

    public String getFullEnd() {
        return fullEnd;
    }

    public void setFullEnd(String fullEnd) {
        this.fullEnd = fullEnd;
    }

    public String getExit() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit = exit;
    }
}
