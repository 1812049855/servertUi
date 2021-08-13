package com.fhec.config.Ini;

import com.fhec.style.BeautyEye;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TestSummary2 extends BeautyEye {
    private static JTable table;
    private static JTable table_1;
    private static JTable table_2;

    private String head[] = null;
    private Object[][] data = null;

    public static void main(String[] args) {
        JFrame jf = new JFrame("测试选项卡表格");
        jf.setSize(800, 600);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);

        // 创建选项卡面板
        final JTabbedPane tabbedPane = new JTabbedPane();

        // 创建第 1 个选项卡（选项卡只包含 标题）
        tabbedPane.addTab("Tab01", createTextPanel("TAB 01"));

        // 创建第 2 个选项卡（选项卡包含 标题 和 图标）
        tabbedPane.addTab("Tab02", new ImageIcon("bb.jpg"), createTextPanel2("TAB 02"));

        // 创建第 3 个选项卡（选项卡包含 标题、图标 和 tip提示）
        tabbedPane.addTab("Tab03", new ImageIcon("bb.jpg"), createTextPanel3("TAB 03"));

        // 添加选项卡选中状态改变的监听器
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("当前选中的选项卡: " + tabbedPane.getSelectedIndex());
            }
        });

        // 设置默认选中的选项卡
        tabbedPane.setSelectedIndex(1);

        jf.setContentPane(tabbedPane);
        jf.setVisible(true);
    }

    /**
     * 创建一个面板，面板中心显示一个标签，用于表示某个选项卡需要显示的内容
     */

    private static JComponent createTextPanel(String text) {
        // 创建面板, 使用一个 1 行 1 列的网格布局（为了让标签的宽高自动撑满面板）
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1);
        panel_1.setLayout(new GridLayout(0, 1, 0, 0));

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{{null, "Total", "Site1", "Site2", "Site3", "Site4"},
                        {null, null, null, null, null, null}, {null, null, null, null, null, null},
                        {null, null, null, null, null, null}, {null, null, null, null, null, null},},
                new String[]{"New column", "New column", "New column", "New column", "New column", "New column"}));
        panel_1.add(table);

        JPanel panel_1_1 = new JPanel();
        panel.add(panel_1_1);
        panel_1_1.setLayout(new GridLayout(0, 1, 0, 0));

        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(
                new Object[][]{{"BinID", "Total", "Site1", "Site2", "Site3", "Site4"},
                        {null, null, null, null, null, null}, {null, null, null, null, null, null},
                        {null, null, null, null, null, null}, {null, null, null, null, null, null},},
                new String[]{"New column", "New column", "New column", "New column", "New column", "New column"}));
        panel_1_1.add(table_1);

        JPanel panel_1_1_1 = new JPanel();
        panel.add(panel_1_1_1);
        panel_1_1_1.setLayout(new GridLayout(0, 1, 0, 0));

        table_2 = new JTable();
        table_2.setModel(new DefaultTableModel(
                new Object[][]{{"BinID", "Total", "Site1", "Site2", "Site3", "Site4"},
                        {null, null, null, null, null, null}, {null, null, null, null, null, null},
                        {null, null, null, null, null, null}, {null, null, null, null, null, null},},
                new String[]{"New column", "New column", "New column", "New column", "New column", "New column"}));
        panel_1_1_1.add(table_2);
        centerTable(table);
        centerTable(table_1);
        centerTable(table_2);
        table.setShowHorizontalLines(true); // 水平线不显示
        table.setShowVerticalLines(true); // 垂直线不显示
        table_1.setShowHorizontalLines(true); // 水平线不显示
        table_1.setShowVerticalLines(true); // 垂直线不显示
        table_2.setShowHorizontalLines(true); // 水平线不显示
        table_2.setShowVerticalLines(true); // 垂直线不显示

        return panel;
    }

    private static void centerTable(JTable table) {
        // TODO Auto-generated method stub
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table.setDefaultRenderer(Object.class, renderer);
    }

    /**
     * 第二个选项卡
     *
     * @param text
     * @return
     */
    private static JComponent createTextPanel2(String text) {
        // 创建面板, 使用一个 1 行 1 列的网格布局（为了让标签的宽高自动撑满面板）
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1);
        panel_1.setLayout(new GridLayout(0, 1, 0, 0));

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{{null, "Total", "Site1", "Site2", "Site3", "Site4"},
                        {null, null, null, null, null, null}, {null, null, null, null, null, null},
                        {null, null, null, null, null, null}, {null, null, null, null, null, null},},
                new String[]{"New column", "New column", "New column", "New column", "New column", "New column"}));
        panel_1.add(table);

        JPanel panel_1_1 = new JPanel();
        panel.add(panel_1_1);
        panel_1_1.setLayout(new GridLayout(0, 1, 0, 0));

        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(
                new Object[][]{{"BinID", "Total", "Site1", "Site2", "Site3", "Site4"},
                        {null, null, null, null, null, null}, {null, null, null, null, null, null},
                        {null, null, null, null, null, null}, {null, null, null, null, null, null},},
                new String[]{"New column", "New column", "New column", "New column", "New column", "New column"}));
        panel_1_1.add(table_1);

        JPanel panel_1_1_1 = new JPanel();
        panel_1_1_1.setLayout(null);
        panel.add(panel_1_1_1);

        table_2 = new JTable();
        table_2.setModel(new DefaultTableModel(
                new Object[][]{{"BinID", "Total", "Site1", "Site2", "Site3", "Site4"},
                        {null, null, null, null, null, null}, {null, null, null, null, null, null},
                        {null, null, null, null, null, null}, {null, null, null, null, null, null},},
                new String[]{"New column", "New column", "New column", "New column", "New column", "New column"}));
        table_2.setBounds(0, 0, 800, 199);
        panel_1_1_1.add(table_2);
        centerTable(table);
        centerTable(table_1);
        centerTable(table_2);

        table.setShowHorizontalLines(true); // 水平线不显示
        table.setShowVerticalLines(true); // 垂直线不显示
        table_1.setShowHorizontalLines(true); // 水平线不显示
        table_1.setShowVerticalLines(true); // 垂直线不显示
        table_2.setShowHorizontalLines(true); // 水平线不显示
        table_2.setShowVerticalLines(true); // 垂直线不显示

        return panel;
    }

    /**
     * 第三个选项卡
     *
     * @param text
     * @return
     */
    private static JComponent createTextPanel3(String text) {
        // 创建面板, 使用一个 1 行 1 列的网格布局（为了让标签的宽高自动撑满面板）
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1);
        panel_1.setLayout(new GridLayout(0, 1, 0, 0));

        table = new JTable();
        table.setModel(
                new DefaultTableModel(
                        new Object[][]{
                                {"test#", "TestName", "Low Limit", "High Limit", "Unit", "Site1", "Site2", "Site3",
                                        "Site4"},
                                {null, null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null},},
                        new String[]{"New column", "New column", "New column", "New column", "New column",
                                "New column", "New column", "New column", "New column"}));
        panel_1.add(table);
        centerTable(table);
        table.setShowHorizontalLines(true); // 水平线不显示
        table.setShowVerticalLines(true); // 垂直线不显示
        return panel;
    }

    // 生成表格数据

    /**
     * @return
     */
    public Object[][] queryData() {
        List<String> list = new ArrayList<String>();
        data = new Object[list.size()][head.length];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                /*
                 * data[i][0] = list.get(i).getId(); data[i][1] = list.get(i).getName();
                 * data[i][2] = list.get(i).getPassword(); data[i][3] = list.get(i).getSex();
                 * data[i][4] = list.get(i).getAge(); data[i][5] = list.get(i).getAddress();
                 */
            }
        }
        return data;
    }

}