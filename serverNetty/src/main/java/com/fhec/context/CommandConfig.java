package com.fhec.context;

import java.io.Serializable;

/**
 * CommandConfig
 *
 * @author Archer.W
 * @date 2021/04/16 13:43
 **/
public class CommandConfig  {

    private String exit;
    private String fullEnd;
    private String saveTestResult;
    private String startLot;

    public String getExit() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit = exit;
    }

    public String getFullEnd() {
        return fullEnd;
    }

    public void setFullEnd(String fullEnd) {
        this.fullEnd = fullEnd;
    }

    public String getSaveTestResult() {
        return saveTestResult;
    }

    public void setSaveTestResult(String saveTestResult) {
        this.saveTestResult = saveTestResult;
    }

    public String getStartLot() {
        return startLot;
    }

    public void setStartLot(String startLot) {
        this.startLot = startLot;
    }
}
