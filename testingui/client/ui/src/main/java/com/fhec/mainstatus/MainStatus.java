package com.fhec.mainstatus;

import com.fhec.views.MainWindow;

public class MainStatus {

    public static void status0() {
        MainWindow.getStartLot().setEnabled(false);
        MainWindow.getBtnSaveResult().setEnabled(false);
        MainWindow.getBtnEndLot().setEnabled(false);
        MainWindow.getBtnExit().setEnabled(false);
    }

    public static void status1() {
        MainWindow.getStartLot().setEnabled(true);
        MainWindow.getBtnSaveResult().setEnabled(false);
        MainWindow.getBtnEndLot().setEnabled(false);
        MainWindow.getBtnExit().setEnabled(true);
    }

    public static void status2() {

        MainWindow.getStartLot().setEnabled(false);
        MainWindow.getBtnSaveResult().setEnabled(true);
        MainWindow.getBtnEndLot().setEnabled(false);
        MainWindow.getBtnExit().setEnabled(true);
    }

    public static void status3() {
        MainWindow.getStartLot().setEnabled(true);
        MainWindow.getBtnSaveResult().setEnabled(false);
        MainWindow.getBtnEndLot().setEnabled(true);
        MainWindow.getBtnExit().setEnabled(true);

    }
}
