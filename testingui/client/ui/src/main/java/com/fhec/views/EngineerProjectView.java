package com.fhec.views;

import com.fhec.context.ConfigFilePath;
import com.fhec.mainstatus.MainStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class EngineerProjectView extends JDialog {

    private final JTextField txtEnginner = new JTextField();

    private final JTextField textField = new JTextField();

    private final JTextField textField_1 = new JTextField();

    private final JTextField textField_2 = new JTextField();

    private final JTextField textField_3 = new JTextField();

    private final JTextField textField_4 = new JTextField();

    private final JTextField textField_5 = new JTextField();

    private final JTextField textField_6 = new JTextField();

    private final JTextField textField_7 = new JTextField();

    private final JTextField textField_8 = new JTextField();

    private final JTextField textField_9 = new JTextField();

    private final JTextField textField_10 = new JTextField();

    private final JTextField textField_11 = new JTextField();

    private final JTextField textField_12 = new JTextField();

    private final JTextField textField_13 = new JTextField();

    private final JTextField textField_14 = new JTextField();

    private final JTextField textField_15 = new JTextField();


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EngineerProjectView window = new EngineerProjectView();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public static void Show() {
        EngineerProjectView engineerProjectView=new EngineerProjectView();
        engineerProjectView.setVisible(true);
    }

    /**
     * Create the application.
     */
    public EngineerProjectView() {
        initialize();
    }

    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            MainStatus.status1();
        }
    }
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setModal(true);
        setBounds(100, 100, 925, 754);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 919, 69);
        getContentPane().add(panel);
        panel.setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        txtEnginner.setEditable(false);
        txtEnginner.setFont(new Font("宋体", Font.PLAIN, 17));
        txtEnginner.setText("engineer project interface");
        txtEnginner.setBounds(114, 10, 389, 39);
        panel.add(txtEnginner);
        txtEnginner.setColumns(10);

        JLabel lblEnginner = new JLabel("engineer project interface");
        lblEnginner.setFont(new Font("宋体", Font.PLAIN, 16));
        lblEnginner.setBounds(143, 22, 54, 15);
        panel.add(lblEnginner);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 66, 919, 167);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JButton btnTTL = new JButton("TTL");
        btnTTL.setBounds(232, 10, 99, 54);
        panel_1.add(btnTTL);

        JButton btnLoad = new JButton("Load");
        btnLoad.setBounds(373, 10, 99, 54);
        panel_1.add(btnLoad);

        JButton btnConnect = new JButton("Connect");
        btnConnect.setBounds(513, 10, 99, 54);
        panel_1.add(btnConnect);

        JButton btnGPIB = new JButton("GPIB");
        btnGPIB.setBounds(232, 79, 99, 54);
        panel_1.add(btnGPIB);

        JButton btnLoad1 = new JButton("Load");
        btnLoad1.setBounds(373, 79, 99, 54);
        panel_1.add(btnLoad1);

        JButton btnDisconnect = new JButton("Disconnect");
        btnDisconnect.setBounds(513, 79, 99, 54);
        panel_1.add(btnDisconnect);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 230, 919, 179);
        getContentPane().add(panel_2);
        panel_2.setLayout(null);

        JButton btnManualTest = new JButton("manual test");
        btnManualTest.setBounds(31, 10, 144, 39);
        panel_2.add(btnManualTest);

        JButton btnStop = new JButton("stop");
        btnStop.setBounds(185, 10, 144, 39);
        panel_2.add(btnStop);

        JButton btnTestCount = new JButton("test count");
        btnTestCount.setBounds(31, 59, 144, 39);
        panel_2.add(btnTestCount);

        JButton btnNewButton_3 = new JButton("");
        btnNewButton_3.setBounds(185, 59, 144, 39);
        panel_2.add(btnNewButton_3);

        JButton btnWaitTime = new JButton("wait time");
        btnWaitTime.setBounds(31, 108, 144, 39);
        panel_2.add(btnWaitTime);

        JButton btnNewButton_5 = new JButton("");
        btnNewButton_5.setBounds(185, 108, 144, 39);
        panel_2.add(btnNewButton_5);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(0, 407, 919, 318);
        getContentPane().add(panel_3);
        panel_3.setLayout(null);

        textField.setBounds(36, 10, 148, 47);
        panel_3.add(textField);
        textField.setColumns(10);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage(ConfigFilePath.SWING_PATH);
        setIconImage(image);
        textField_1.setColumns(10);
        textField_1.setBounds(202, 10, 148, 47);
        panel_3.add(textField_1);

        textField_2.setColumns(10);
        textField_2.setBounds(371, 10, 148, 47);
        panel_3.add(textField_2);

        textField_3.setColumns(10);
        textField_3.setBounds(548, 10, 148, 47);
        panel_3.add(textField_3);

        textField_4.setColumns(10);
        textField_4.setBounds(36, 67, 148, 47);
        panel_3.add(textField_4);

        textField_5.setColumns(10);
        textField_5.setBounds(202, 67, 148, 47);
        panel_3.add(textField_5);

        textField_6.setColumns(10);
        textField_6.setBounds(371, 67, 148, 47);
        panel_3.add(textField_6);

        textField_7.setColumns(10);
        textField_7.setBounds(548, 67, 148, 47);
        panel_3.add(textField_7);

        textField_8.setColumns(10);
        textField_8.setBounds(36, 124, 148, 47);
        panel_3.add(textField_8);

        textField_9.setColumns(10);
        textField_9.setBounds(202, 124, 148, 47);
        panel_3.add(textField_9);

        textField_10.setColumns(10);
        textField_10.setBounds(371, 124, 148, 47);
        panel_3.add(textField_10);

        textField_11.setColumns(10);
        textField_11.setBounds(548, 124, 148, 47);
        panel_3.add(textField_11);

        textField_12.setColumns(10);
        textField_12.setBounds(36, 181, 148, 47);
        panel_3.add(textField_12);

        textField_13.setColumns(10);
        textField_13.setBounds(202, 181, 148, 47);
        panel_3.add(textField_13);

        textField_14.setColumns(10);
        textField_14.setBounds(371, 181, 148, 47);
        panel_3.add(textField_14);

        textField_15.setColumns(10);
        textField_15.setBounds(548, 181, 148, 47);
        panel_3.add(textField_15);
    }
}
