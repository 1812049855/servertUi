package com.fhec.views.Actions;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.fhec.Thread.ListenerMaxSite;
import com.fhec.Thread.LoadTestProgram;
import com.fhec.abstracts.AbstractActionListener;
import com.fhec.app.AppStart;
import com.fhec.clientnetty.ClientHandler;
import com.fhec.context.ConfigFilePath;
import com.fhec.context.EnvConFigConfig;
import com.fhec.context.GlobalContext;
import com.fhec.context.LastConfig;
import com.fhec.context.LastContext;
import com.fhec.context.LocalConfig;
import com.fhec.context.MesFileConfig;
import com.fhec.context.RecipeConfig;
import com.fhec.context.Temporary;
import com.fhec.driver.TeradyneDriverInit;
import com.fhec.driver.TeradyneEvent;
import com.fhec.encode.EnCode;
import com.fhec.entity.EntityVo;
import com.fhec.eqp.TeradyneEquipment;
import com.fhec.ftp.FtpClient;
import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;
import com.fhec.utils.FileUtils;
import com.fhec.utils.SectionReader;
import com.fhec.views.InformationConfirmationView;
import com.fhec.views.MainWindow;
import com.fhec.views.SummaryView;

public class InformationAction extends AbstractActionListener<InformationConfirmationView> {

    private static Map<String, JLabel> jLabelMap;
    private static Map<String, JLabel> jLabelKeyMap;
    private static List<String> nameList;

    public InformationAction(InformationConfirmationView window, Map<String, JLabel> jLabelMap,
                             Map<String, JLabel> jLabelKeyMap,List<String> nameList) {
        super(window);
        this.jLabelMap = jLabelMap;
        this.jLabelKeyMap = jLabelKeyMap;
        this.nameList=nameList;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // 初始化envconfig文件
        EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();

        // recipe 配置文件的内容
        RecipeConfig recipeConfig = GlobalContext.getRecipeConfig();

        // last
        LastConfig lastConfig = GlobalContext.getLastConfig();
        // mes
        MesFileConfig mesFileConfig = GlobalContext.getMesFileConfig();
        // 检查批次输入界面每个栏位是否存在空格
        Boolean isEmpty = this.window.getIsEmpty();
        if (isEmpty) {
            LocalConfig.check20 = true;
            Log.info("批次输入界面每个栏位不存在空格");
            MainWindow.setUilog("批次输入界面每个栏位不存在空格");
        } else {
            LocalConfig.check20 = false;
            Log.info("批次输入界面每个栏位存在空格");
            MainWindow.setUilog("批次输入界面每个栏位存在空格");
        }

        // jLabelMap存放的是确认界面的值
        for (String s : jLabelMap.keySet()) {
            // 判断 lot_device_name Device_Name与 last_device_name 是否一致
            if ("Device_Name".equals(s)) {
                System.out.println(jLabelMap.get(s).getText());
                System.out.println(lastConfig.getLast_device_name());
                if (jLabelMap.get(s).getText().equals(lastConfig.getLast_device_name())) {
                    LocalConfig.check21 = true;
                    Log.info("lot_device_name Device_Name与 last_device_name 一致");
                    MainWindow.setUilog("Log.info(lot_device_name Device_Name与 last_device_name 一致);");
                } else {
                    LocalConfig.check21 = false;
                    Log.info("lot_device_name Device_Name与 last_device_name 不一致");
                    MainWindow.setUilog("Log.info(lot_device_name Device_Name与 last_device_name 不 一致);");
                }
            }
        }
        // 判断 mesfile_TesterOS 与 current_TesterOS 是否一致，current_TesterOS当前机台生效的测试软件版本
        if (mesFileConfig.getTesterOS_Version().equals(LocalConfig.currentTesterOS)) {
            LocalConfig.check22 = true;
            Log.info(" mesfile_TesterOS 与 current_TesterOS 一致");
            MainWindow.setUilog(" mesfile_TesterOS 与 current_TesterOS 一致);");
        } else {
            LocalConfig.check22 = false;
            Log.info(" mesfile_TesterOS 与 current_TesterOS 不 一致");
            MainWindow.setUilog(" mesfile_TesterOS 与 current_TesterOS 不一致);");
        }
        // 测试机暂时不做 判断当前测试机是否已安装 mesfile_TesterOS check23=true，

        // 检查批次输入界面 Test_Code 内容是否符合 recipe testcode 卡控规则
        for (String s : jLabelMap.keySet()) {
            if ("Test_Code".equals(s)) {
                if (jLabelMap.get(s).getText().matches(recipeConfig.getInputOITestCode().getPattern())) {
                    LocalConfig.check24 = true;
                    Log.info(" 检查批次输入界面 Test_Code 内容符合 recipe testcode 卡控规则");
                    MainWindow.setUilog(" 检查批次输入界面 Test_Code 内容符合 recipe testcode 卡控规则;");
                } else {
                    LocalConfig.check24 = false;
                    Log.info(" 检查批次输入界面 Test_Code 内容不符合 recipe testcode 卡控规则");
                    MainWindow.setUilog(" 检查批次输入界面 Test_Code 内容不符合 recipe testcode 卡控规则;");
                }
            }
        }
        // 检查批次输入界面 Mode_Code 内容是否符合 recipe modecode 卡控规则
        for (String s : jLabelMap.keySet()) {
            if ("Mode_Code".equals(s)) {
                if (jLabelMap.get(s).getText().matches(recipeConfig.getInputOIModeCode().getPattern())) {
                    LocalConfig.check25 = true;
                    Log.info(" 检查批次输入界面 Mode_Code 内容符合 recipe modecode 卡控规则");
                    MainWindow.setUilog(" 检查批次输入界面 Mode_Code 内容符合 recipe modecode 卡控规则;");
                } else {
                    LocalConfig.check25 = false;
                    Log.info(" 检查批次输入界面 Mode_Code 内容不符合 recipe modecode 卡控规则");
                    MainWindow.setUilog(" 检查批次输入界面 Mode_Code 内容不符合 recipe modecode 卡控规则");
                }

            }
        }

        // 检查批次输入界面 Test_BinNo 内容是否符合 recipe testbinno 卡控规则
        for (String s : jLabelMap.keySet()) {
            if ("Test_BinNo".equals(s)) {
                if (jLabelMap.get(s).getText().matches(recipeConfig.getInputOITestBinNo().getPattern())) {
                    LocalConfig.check26 = true;
                    Log.info("检查批次输入界面 Test_BinNo 内容符合 recipe testbinno 卡控规则");
                    MainWindow.setUilog("检查批次输入界面 Test_BinNo 内容符合 recipe testbinno 卡控规则");
                } else {
                    LocalConfig.check26 = false;
                    Log.info("检查批次输入界面 Test_BinNo 内容不符合 recipe testbinno 卡控规则");
                    MainWindow.setUilog("检查批次输入界面 Test_BinNo 内容不符合 recipe testbinno 卡控规则");
                }
            }
        }

        // 检查当前测试机校准日期与当天日期的间隔是否超过[Tester_caldata_check]定义的天数 check28 = true

        // 当批次输入界面中的 customer id 为”SETUP”、”RL”、”FL”、”OTHERS”、”IR1” 、”IR2” 、”IR3” 时则不执行行
        for (String s : jLabelMap.keySet()) {
            if ("Customer_ID".equals(s)) {
                if (jLabelMap.get(s).getText().equals("SETUP") || jLabelMap.get(s).getText().equals("RL")
                        || jLabelMap.get(s).getText().equals("FL") || jLabelMap.get(s).getText().equals("OTHERS")
                        || jLabelMap.get(s).getText().equals("IR1") || jLabelMap.get(s).getText().equals("IR2")
                        || jLabelMap.get(s).getText().equals("IR3")) {
                    // 依据 recipe 中的[TestCode_Config] 规则，将批次输入界面的 testcode 转换，
                    // 转换 得到=右面的值
                    // 变量存值
                    try {
                        testCode();
                        Log.info("将批次输入界面的 testcode 转换");
                        MainWindow.setUilog("将批次输入界面的 testcode 转换");
                        // 把页面得到的值写出去
                        // 写出的状态
                        LocalConfig.status = 1;

                        // 创建本地测试数据文件夹路径
                        localPath();
                        Log.info("创建本地测试数据文件夹路径");
                        MainWindow.setUilog("创建本地测试数据文件夹路径");
                        // 创建服务器测试数据文件夹路径
                        serverPath();
                        pathTest();
                        Log.info("创建服务器测试数据文件夹路径");
                        MainWindow.setUilog("创建服务器测试数据文件夹路径");
                        this.window.dispose();
                        // 把信息输入到主界面 jLabelKeyMap 存放的是确认界面名字
                        bacth();
                        //赋值
                        dataRuleName();
                        MainWindow.setTextAreaLotInfo("\n");
                        Log.info("打开summary汇总界面");
                        MainWindow.setUilog("打开summary汇总界面");
                        // 加载程序
                      //  loadProgram();
                        startLot();
                        SummaryView.getSummaryView();
                        MainStatus.status2();
                        lastBatch();
                        return;
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        JOptionPane.showConfirmDialog(null, e.getMessage(), "error", JOptionPane.CLOSED_OPTION,
                                JOptionPane.WARNING_MESSAGE);
                        MainStatus.status1();
                    }
                } else {
                    // 当 check28 为 false 时
                    if (!LocalConfig.check28) {
                        Log.info("check28 = false");
                        JOptionPane.showConfirmDialog(null, "alarm M10:tester need to do calibration,pls call ME !",
                                "提示", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);

                        // OP 点击 OK 按钮后，返回点击 start lot 之前的界面，重新操作

                        Log.error("check28 为 false,关闭窗体，返回主界面成功");
                        MainWindow.setUilog("关闭窗体，返回主界面成功");
                        this.window.dispose();
                        MainStatus.status1();
                        return;
                    } else {
                        // 当 check20，check24，check25，check26，check27 中任意一个非 true 时
                        if (LocalConfig.check20 && LocalConfig.check24 && LocalConfig.check25 && LocalConfig.check26) {
                            Log.info("check20，check24，check25，check26，check27 = true");
                            MainWindow.setUilog("check20，check24，check25，check26，check27 = true");
                            // 全部为true 进行下一步
                            // 判断 Device_Name 前后输入是否一致
                            if (LocalConfig.systemCount > 0 && !LocalConfig.check21) {
                                Log.info("systemCount > 0 && check21 = true");
                                MainWindow.setUilog("systemCount > 0 && heck21 = true");
                                JOptionPane.showConfirmDialog(null,
                                        "alarm M12:DeviceName is not match，please call ME setup !", "提示",
                                        JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);

                                // env_config 中的 alarm_M12_flag = 1，
                                if (EnvConFigConfig.uninstall
                                        .equals(envConFigConfig.getAlarmControLFlag().getAlarm_M12_flag())) {

                                    // 进行卸载测试程序，退出 UI，删除本地程序
                                    FileUtils.removeDir(new File(envConFigConfig.getMainPath().getLocal_dlog_path()));
                                    // 保存 UI log 并上传 待做
                                    Log.error("alarm M12 = 1,卸载测试程序，退出 UI");
                                    ExitUninstall exitUninstall = new ExitUninstall();
                                    exitUninstall.exitUnistall();
                                    System.exit(0);
                                } else if (EnvConFigConfig.recover
                                        .equals(envConFigConfig.getAlarmControLFlag().getAlarm_M12_flag())) {
                                    // 若 alarm_M12_flag= 0，则返回点击 start lot 之前的界面
                                    this.window.dispose();
                                    Log.info("alarm M12 = 0,返回主界面成功");
                                    MainWindow.setUilog("alarm M12 = 0,返回主界面成功");
                                    MainStatus.status1();
                                    return;
                                }
                                // 若 system count >0 且 check21 均为 true 时，则进入下一步骤
                            } else if (LocalConfig.systemCount >= 0 && LocalConfig.check21) {
                                Log.info("system count >0 且 check21 均为 true");
                                MainWindow.setUilog("system count >0 且 check21 均为 true");
                                // 判断测试机软件版本是否存在 若 check23 为 false 时，需求测试机版本未安装
                                if (!LocalConfig.check23) {
                                    Log.info("需求测试机版本未安装");
                                    MainWindow.setUilog("需求测试机版本未安装");
                                    JOptionPane.showConfirmDialog(null,
                                            "alarm M13:tester software is not install，please call ME !", "提示",
                                            JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);

                                    if (EnvConFigConfig.uninstall
                                            .equals(envConFigConfig.getAlarmControLFlag().getAlarm_M13_flag())) {

                                        // 进行卸载测试程序，退出 UI，删除本地程序3
                                        FileUtils.removeDir(
                                                new File(envConFigConfig.getMainPath().getLocal_dlog_path()));
                                        // 保存 UI log 并上传 待做
                                        Log.info("alarm M13 = 1,卸载测试程序，退出 UI");
                                        ExitUninstall exitUninstall = new ExitUninstall();
                                        exitUninstall.exitUnistall();
                                        System.exit(0);
                                    } else if (EnvConFigConfig.recover
                                            .equals(envConFigConfig.getAlarmControLFlag().getAlarm_M13_flag())) {

                                        // 若 alarm_M13_flag= 0，则返回 UI 启动界面
                                        Log.info("alarm M13 = 0,返回主界面成功");
                                        MainWindow.setUilog("alarm M13 = 0,返回主界面成功");
                                        this.window.dispose();
                                        MainStatus.status1();
                                        return;
                                    }
                                } else {
                                    // 若 check23 均为 true 时，则进入下一步骤依据 recipe 中的[TestCode_Config] 规则，将批次输入界面的 testcode
                                    // 转换，获取 convert_testcode 信息
                                    try {
                                        Log.info("需求测试机版本已经安装");
                                        MainWindow.setUilog("需求测试机版本已经安装");
                                        // convert_testcode转换后的测试步序
                                        // 转换先不做 得到=右面的值
                                        // 变量存值
                                        testCode();
                                        Log.info("将批次输入界面的 testcode 转换");
                                        MainWindow.setUilog("将批次输入界面的 testcode 转换");


                                        // 创建本地测试数据文件夹路径
                                        localPath();
                                        Log.info("创建本地测试数据文件夹路径");
                                        MainWindow.setUilog("创建本地测试数据文件夹路径");

                                        // 创建服务器测试数据文件夹路径
                                        serverPath();
                                        pathTest();

                                        Log.info("创建服务器测试数据文件夹路径");
                                        MainWindow.setUilog("创建服务器测试数据文件夹路径");
                                        this.window.dispose();
                                        // 把信息输入到主界面 jLabelKeyMap 存放的是确认界面名字
                                        bacth();
                                        //赋值
                                        dataRuleName();
                                        Log.info("打开summary汇总界面");
                                        MainWindow.setUilog("打开summary汇总界面");
                                        // 加载程序
                                        //loadProgram();
                                        startLot();
                                       
                                        return;
                                    } catch (Exception e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                        JOptionPane.showConfirmDialog(null, e.getMessage(), "error",
                                                JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
                                        // 1
                                        MainStatus.status1();
                                    }
                                }
                            }
                        } else {
                            // 有一个为false
                            JOptionPane.showConfirmDialog(null,
                                    "alarm M11:lot information check fail，please do it again !", "提示",
                                    JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);

                            // 窗体
                            Log.error("有一个为false返回主界面成功");
                            MainWindow.setUilog("返回主界面成功");
                            this.window.dispose();
                            // 1
                            MainStatus.status1();
                        }
                    }
                }
            }
        }

    }

    /**
     * 创建本地测试数据文件夹路径
     */
    private void localPath() {
        EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
        String Customer_ID = null;
        String Device_Name = null;
        String Customer_LotNo = null;
        String Sub_LotNo = null;
        for (String key : jLabelKeyMap.keySet()) {
            if ("Customer_ID".equals(key)) {
                Customer_ID = jLabelMap.get(key).getText();
            }
            if ("Device_Name".equals(key)) {
                Device_Name = jLabelMap.get(key).getText();
            }
            if ("Customer_LotNo".equals(key)) {
                Customer_LotNo = jLabelMap.get(key).getText();
            }
            if ("Sub_LotNo".equals(key)) {
                Sub_LotNo = jLabelMap.get(key).getText();
            }
        }
        Temporary.local_datalog_name_rule1 = envConFigConfig.getMainPath().getLocal_dlog_path() + Customer_ID
                + File.separator + Device_Name + File.separator + Customer_LotNo + File.separator + Sub_LotNo;
        // csvdir 文件夹：local_csvdir_folderpath =D:\datalog\datalog_name_rule_1\csvdir
        Temporary.local_csvdir_folderpath = Temporary.local_datalog_name_rule1 + File.separator + "csvdir";

        // SingleFile
        // 文件夹：local_singlefile_folderpath=D:\datalog\datalog_name_rule_1\SingleFile
        Temporary.local_singlefile_folderpath = Temporary.local_datalog_name_rule1 + File.separator + "SingleFile";

        // 汇总 summary 文件夹：local_fulllotfile_folderpath
        // =D:\datalog\datalog_name_rule_1\FullLotFile
        Temporary.local_fulllotfile_folderpath = Temporary.local_datalog_name_rule1 + File.separator + "FullLotFile";

        // 判断本地文件是否存在
        FileUtils.CreateFolders(Temporary.local_csvdir_folderpath);
        Log.info("文件夹" + Temporary.local_csvdir_folderpath + "创建成功");
        MainWindow.setUilog("文件夹" + Temporary.local_csvdir_folderpath + "创建成功");
        FileUtils.CreateFolders(Temporary.local_singlefile_folderpath);
        Log.info("文件夹" + Temporary.local_singlefile_folderpath + "创建成功");
        MainWindow.setUilog("文件夹" + Temporary.local_singlefile_folderpath + "创建成功");
        FileUtils.CreateFolders(Temporary.local_fulllotfile_folderpath);
        Log.info("文件夹" + Temporary.local_fulllotfile_folderpath + "创建成功");
        MainWindow.setUilog("文件夹" + Temporary.local_fulllotfile_folderpath + "创建成功");
    }

    /**
     * 创建服务器测试数据文件夹路径
     *
     * @throws IOException
     */
    private void serverPath() {
        EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
        FtpClient ftp = FtpClient.get(envConFigConfig.getServerDataIP().getServer_data_IP());
        String Customer_ID = null;
        String Device_Name = null;
        String Customer_LotNo = null;
        String Sub_LotNo = null;
        for (String key : jLabelKeyMap.keySet()) {
            if ("Customer_ID".equals(key)) {
                Customer_ID = jLabelMap.get(key).getText();
            }
            if ("Device_Name".equals(key)) {
                Device_Name = jLabelMap.get(key).getText();
            }
            if ("Customer_LotNo".equals(key)) {
                Customer_LotNo = jLabelMap.get(key).getText();
            }
            if ("Sub_LotNo".equals(key)) {
                Sub_LotNo = jLabelMap.get(key).getText();
            }
        }
        Temporary.server_datalog_name_rule1 = envConFigConfig.getMainPath().getServer_dlog_path() + Customer_ID
                + File.separator + Device_Name + File.separator + Customer_LotNo + File.separator + Sub_LotNo;
        // csvdir 文件夹：server_csvdir_folderpath =\\datalog_name_rule_1\csvdir
        Temporary.server_csvdir_folderpath = Temporary.server_datalog_name_rule1 + File.separator + "csvdir";

        // SingleFile 文件夹：server_singlefile_folderpath =\\datalog_name_rule_1\SingleFile
        Temporary.server_singlefile_folderpath = Temporary.server_datalog_name_rule1 + File.separator + "SingleFile";

        // 汇总 summary 文件夹：server_fulllotfile_folderpath
        // =\\datalog_name_rule_1\FullLotFile
        Temporary.server_fulllotfile_folderpath = Temporary.server_datalog_name_rule1 + File.separator + "FullLotFile";

        try {
            // 判断服务器上文件夹是否存在
            Boolean existFile = ftp.doFunc(new FtpClient.IFunc() {
                @Override
                public Boolean doFunc(FtpClient ftpClient) {
                    try {
                        return ftp.existFile(Temporary.server_csvdir_folderpath);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                        MainStatus.status1();
                    }
                    return null;
                }
            });
            if (!existFile) {
                /**
                 * 初始化得到值 不需要赋值
                 */
                MesFileConfig mesFileConfig = GlobalContext.getMesFileConfig();

                // 替换特殊字符
                String replaceCustomer_ID = replaceSpecialCharacters(mesFileConfig.getCustomer_ID());
                if (replaceCustomer_ID == null || "".equals(replaceCustomer_ID)) {
                    return;
                }
                String replaceCustomer_LotNo = replaceSpecialCharacters(mesFileConfig.getCustomer_LotNo());
                if (replaceCustomer_LotNo == null || "".equals(replaceCustomer_LotNo)) {
                    return;
                }
                String replaceDevice_Name = replaceSpecialCharacters(mesFileConfig.getDevice_Name());
                if (replaceDevice_Name == null || "".equals(replaceDevice_Name)) {
                    return;
                }
                String replaceSub_LotNo = replaceSpecialCharacters(mesFileConfig.getSub_LotNo());
                if (replaceSub_LotNo == null || "".equals(replaceSub_LotNo)) {
                    return;
                }
                ftp.doAction(new FtpClient.IAction() {
                    @Override
                    public void doAction(FtpClient ftpClient) {
                        try {
                            ftp.createDirecroty(Temporary.server_csvdir_folderpath);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                            MainStatus.status1();
                        }
                    }
                });

            } else {
                Log.info("文件夹" + Temporary.server_csvdir_folderpath + "创建成功");
                MainWindow.setUilog("文件夹" + Temporary.server_csvdir_folderpath + "创建成功");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            MainStatus.status1();
        }
        try {
            Boolean existFilesinglefile = ftp.doFunc(new FtpClient.IFunc() {
                @Override
                public Boolean doFunc(FtpClient ftpClient) {
                    try {
                        return ftp.existFile(Temporary.server_singlefile_folderpath);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                        MainStatus.status1();
                    }
                    return null;
                }
            });
            if (!existFilesinglefile) {
                /**
                 * 初始化得到值 不需要赋值
                 */
                MesFileConfig mesFileConfig = GlobalContext.getMesFileConfig();

                // 替换特殊字符
                String replaceCustomer_ID = replaceSpecialCharacters(mesFileConfig.getCustomer_ID());
                if (replaceCustomer_ID == null || "".equals(replaceCustomer_ID)) {
                    return;
                }
                String replaceCustomer_LotNo = replaceSpecialCharacters(mesFileConfig.getCustomer_LotNo());
                if (replaceCustomer_LotNo == null || "".equals(replaceCustomer_LotNo)) {
                    return;
                }
                String replaceDevice_Name = replaceSpecialCharacters(mesFileConfig.getDevice_Name());
                if (replaceDevice_Name == null || "".equals(replaceDevice_Name)) {
                    return;
                }
                String replaceSub_LotNo = replaceSpecialCharacters(mesFileConfig.getSub_LotNo());
                if (replaceSub_LotNo == null || "".equals(replaceSub_LotNo)) {
                    return;
                }
                ftp.doAction(new FtpClient.IAction() {
                    @Override
                    public void doAction(FtpClient ftpClient) {
                        try {
                            ftp.createDirecroty(Temporary.server_singlefile_folderpath);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                            MainStatus.status1();
                        }
                    }
                });

            } else {
                Log.info("文件夹" + Temporary.server_singlefile_folderpath + "创建成功");
                MainWindow.setUilog("文件夹" + Temporary.server_singlefile_folderpath + "创建成功");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            MainStatus.status1();
        }

        try {
            Boolean existFilefolderpath = ftp.doFunc(new FtpClient.IFunc() {
                @Override
                public Boolean doFunc(FtpClient ftpClient) {
                    try {
                        return ftp.existFile(Temporary.server_fulllotfile_folderpath);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                        MainStatus.status1();
                    }
                    return null;
                }
            });
            if (!existFilefolderpath) {
                /**
                 * 初始化得到值 不需要赋值
                 */
                MesFileConfig mesFileConfig = GlobalContext.getMesFileConfig();

                // 替换特殊字符
                String replaceCustomer_ID = replaceSpecialCharacters(mesFileConfig.getCustomer_ID());
                if (replaceCustomer_ID == null || "".equals(replaceCustomer_ID)) {
                    return;
                }
                String replaceCustomer_LotNo = replaceSpecialCharacters(mesFileConfig.getCustomer_LotNo());
                if (replaceCustomer_LotNo == null || "".equals(replaceCustomer_LotNo)) {
                    return;
                }
                String replaceDevice_Name = replaceSpecialCharacters(mesFileConfig.getDevice_Name());
                if (replaceDevice_Name == null || "".equals(replaceDevice_Name)) {
                    return;
                }
                String replaceSub_LotNo = replaceSpecialCharacters(mesFileConfig.getSub_LotNo());
                if (replaceSub_LotNo == null || "".equals(replaceSub_LotNo)) {
                    return;
                }
                ftp.doAction(new FtpClient.IAction() {
                    @Override
                    public void doAction(FtpClient ftpClient) {
                        try {
                            ftp.createDirecroty(Temporary.server_fulllotfile_folderpath);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                            MainStatus.status1();
                        }
                    }
                });

            } else {
                Log.info("文件夹" + Temporary.server_fulllotfile_folderpath + "创建成功");
                MainWindow.setUilog("文件夹" + Temporary.server_fulllotfile_folderpath + "创建成功");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            MainStatus.status1();

        }

    }

    /**
     * 替换特殊字符
     *
     * @param dirPath
     * @return
     */
    private static String replaceSpecialCharacters(String dirPath) {
        if ("".equals(dirPath)) {
            return null;
        } else {

            // 文件名中不能含有 \ / : * ? " < > | 特殊字符， 用"-"进行替换

            dirPath = dirPath.replaceAll("[/\\\\:*?|]", "-");
            dirPath = dirPath.replaceAll("[\"<>]", "-");
            return dirPath;
        }
    }

    public void simTest(TeradyneEquipment teradyneInstantia) {
        TeradyneEvent.runflag = true;
        Thread a = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    while (TeradyneEvent.runflag) {
                        Thread.sleep(1000);
                        teradyneInstantia.StartTest();
                    }

                } catch (InterruptedException e) {

                    e.printStackTrace();
                }

            }
        });
        a.start();

    }

    public Map<String, String> getPrograminfo(String path) {
        Map<String, String> map = new HashMap<String, String>();
        File file = new File(path);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            String Program = "Program";
            String JobName = "JobName";
            String ChanMap = "ChanMap";
            String DatalogSetupFile = "DatalogSetupFile";
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                String trim = tempString.replaceAll(" ", "");
                switch (line) {
                    case 1:
                        String substring2 = trim.substring(Program.length(), trim.length());
                        map.put("Program", substring2);
                        break;
                    case 2:
                        String substring = trim.substring(JobName.length(), trim.length());
                        map.put("JobName", substring);
                        break;
                    case 3:
                        String substring3 = trim.substring(ChanMap.length(), trim.length());
                        map.put("ChanMap", substring3);
                        break;
                    case 4:
                        String substring4 = trim.substring(DatalogSetupFile.length(), trim.length());
                        map.put("DatalogSetupFile", substring4);
                        break;

                    default:
                        break;
                }
                // 显示行号
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return map;
    }

    public void loadProgram() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String format = sdf.format(new Date());
        TeradyneEvent.prostattime = format;
        MesFileConfig mesFileConfig = GlobalContext.getMesFileConfig();
        String program_Folder = mesFileConfig.getProgram_Folder();
        String test_Flow = mesFileConfig.getTest_Flow();
        EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
        String local_prog_path = envConFigConfig.getMainPath().getLocal_prog_path();
        String local_testflow_path = local_prog_path + program_Folder + File.separator;
        TeradyneEvent en = new TeradyneEvent();
        TeradyneEquipment teradyneInstantia = TeradyneDriverInit.TeradyneInstantia();
        teradyneInstantia.Event(en);
        teradyneInstantia.SelectDriver("DeltaEclipse");
        teradyneInstantia.SetSimVisible(TeradyneDriverInit.DriverModel);
        teradyneInstantia.Connection();
        String protxtpath = local_testflow_path + "LoadFile" + File.separator + test_Flow;
        Map<String, String> programinfo = getPrograminfo(protxtpath);
        String Programpath = programinfo.get("Program");
        System.out.println(local_testflow_path + Programpath);
        File pro = new File(local_testflow_path + Programpath);
        if (!pro.exists())
            throw new Exception("测试程序不存在");

       
        boolean programLoaded = teradyneInstantia.isProgramLoaded();
        if(programLoaded) {
        	String last_zipfile = Temporary.last_zipfile;
        	String last_testflow =Temporary.last_testflow;
        	String zipfile_Name = mesFileConfig.getZipfile_Name();
        	if(!last_zipfile.equals(zipfile_Name)&&!test_Flow.equals(last_testflow)) {
        		Thread th=new Thread(new LoadTestProgram(local_testflow_path,Programpath));
        		th.start();
        	}
        }else {
        	Thread th=new Thread(new LoadTestProgram(local_testflow_path,Programpath));
    		th.start();
        }
        Thread siteTh=new Thread(new ListenerMaxSite());
        siteTh.start();
        
//        TeradyneEvent.MaxSite = 6;
//        String txt = envConFigConfig.getMainPath().getLocal_dlog_path() + GlobalContext.TempData + File.separator
//                + LocalConfig.datalog_name_rules + ".txt";
//        String sum = envConFigConfig.getMainPath().getLocal_dlog_path() + GlobalContext.TempData + File.separator
//                + LocalConfig.datalog_name_rules + ".sum";
//        String std = envConFigConfig.getMainPath().getLocal_dlog_path() + GlobalContext.TempData + File.separator
//                + LocalConfig.datalog_name_rules + ".std";
//        TeradyneEvent.stdffilefolder = envConFigConfig.getMainPath().getLocal_dlog_path() + GlobalContext.TempData;
//        TeradyneEvent.stdffilepath = std;
//        Temporary.stdUnkName=LocalConfig.datalog_name_rules+".std";
//        String device_Name = mesFileConfig.getDevice_Name();
//        String program_Name = mesFileConfig.getProgram_Name();
//        String zipfile_Name = mesFileConfig.getZipfile_Name();
//        String customer_LotNo = mesFileConfig.getCustomer_LotNo();
//        String sub_LotNo = mesFileConfig.getSub_LotNo();
        // testid
        // opid
//        JLabel jLabel = jLabelMap.get("Operator_ID");
//        String Operator_ID = jLabel.getText();
//        JLabel jLabel2 = jLabelMap.get("Test_BinNo");
//        String Test_BinNo = jLabel2.getText();
//        JLabel jLabel3 = jLabelMap.get("Test_Code");
//        String Test_Code = jLabel3.getText();
//        //
//        String mode_Code = mesFileConfig.getMode_Code();
//        // bin
//        String setup_id = "PRODUCTION";
//        String customer_ID = mesFileConfig.getCustomer_ID();
//        String facil_id = "ForeHope";
//        // flow_id
//        // rest_cod
//        String lot_Type = mesFileConfig.getLot_Type();
//        if ("M".equals(lot_Type) || "MP".equals(lot_Type)) {
//            lot_Type = "P";
//        } else if ("E".equals(lot_Type) || "Q".equals(lot_Type)) {
//            lot_Type = "E";
//        }
//        String[] stdfmir = new String[15];
//        stdfmir[0] = device_Name; // PART_TYPE
//        stdfmir[1] = device_Name; // DSGN_REV
//        stdfmir[2] = customer_LotNo; // LOT_ID
//        stdfmir[3] = sub_LotNo; // SBLOT_ID
//        stdfmir[4] = ""; // TST_TEMP
//        stdfmir[5] = program_Name; // JOB_NAM
//        stdfmir[6] = Test_BinNo; // USER_TXT
//        stdfmir[7] = lot_Type; // MODE_COD
//        stdfmir[8] = Test_Code; // FLOW_ID
//        stdfmir[9] = facil_id; // FACIL_ID
//        stdfmir[10] = Operator_ID; // OPER_NAM
//        stdfmir[11] = customer_ID; // FAMLY_ID
//        stdfmir[12] = mode_Code; // TEST_COD
//        stdfmir[13] = zipfile_Name; // JOB_REV
//        stdfmir[14] = setup_id; // SETUP_ID
//		teradyneInstantia.STDFMIR(stdfmir);
//		teradyneInstantia.SetDataLogStdf(std, txt);
//		teradyneInstantia.SetSummaryStdf(std, sum);
//		String setupfilepath = local_testflow_path + File.separator + DatalogSetupFile;
//		System.out.println(setupfilepath);
//		teradyneInstantia.SetupFile(setupfilepath);
//		teradyneInstantia.FileOutPut(true);
//		teradyneInstantia.ApplySetup();
//		teradyneInstantia.CalibrateTDR();
//    	TeradyneEvent.runflag=true;
//        teradyneInstantia.StartPolling();
    }

    /**
     * 定义last信息
     */
    public static void lastBatch() {
        // 1.先实例化一个Properties对象
        Properties properties = new Properties();
        LastConfig lastConfig = GlobalContext.getLastConfig();
        try {

            // 2.创建一个输出流对象,选择正确的目标文件路径(注意:该配置文件放在src目录下)
            FileOutputStream fos = new FileOutputStream("last/mesBatchlast.properties");

            // 引入Writer,可以明确该输出流的字符集,确保写入配置文件的中文编码正确
            OutputStreamWriter opw = new OutputStreamWriter(fos, EnCode.enCode);

            // 3.将需要写入的属性内容通过set方法,存入properties对象中 last_device_name
            for (String s : jLabelMap.keySet()) {
                if ("Device_Name".equals(s)) {
                    properties.setProperty(LastContext.LAST_DEVICE_NAME, jLabelMap.get(s).getText());
                    lastConfig.setLast_device_name( jLabelMap.get(s).getText());
                }
                // last_testcode
                if ("Test_Code".equals(s)) {
                    properties.setProperty(LastContext.LAST_TESTCODE, jLabelMap.get(s).getText());
                    lastConfig.setLast_testcode(jLabelMap.get(s).getText());
                }
            }
            LocalConfig.systemCount += 1;
            // 4.调用properties的存储方法
            properties.store(opw, "测试用数据");

            // 实例化last 中内容
            Log.info("last信息定义成功");
            MainWindow.setUilog("last信息定义成功");
            // 5.关闭资源
            fos.close();
            // 状态2
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * 设置数据生成路径信息到测试机测试软件
     */
    private void pathTest() {
        // 初始化envConfig
        EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();

        // local_stdf_filepath_temp
        GlobalContext.local_stdf_filepath_temp = envConFigConfig.getMainPath().getLocal_dlog_path()
                + RecipeConfig.DatalogPath.NAME_DATALOG_NAME_RULE_4;

        // local_log_filepath_temp
        GlobalContext.local_log_filepath_temp = envConFigConfig.getMainPath().getLocal_dlog_path()
                + RecipeConfig.DatalogPath.NAME_DATALOG_NAME_RULE_6;

        // local_summary_filepath_temp
        GlobalContext.local_summary_filepath_temp = envConFigConfig.getMainPath().getLocal_dlog_path()
                + RecipeConfig.DatalogPath.NAME_DATALOG_NAME_RULE_5;

        // 判断是否存在
        FileUtils.CreateFolder(GlobalContext.local_stdf_filepath_temp);
        Log.info(GlobalContext.local_stdf_filepath_temp + "文件夹创建成功");
        MainWindow.setUilog(GlobalContext.local_stdf_filepath_temp + "文件夹创建成功");
        FileUtils.CreateFolder(GlobalContext.local_log_filepath_temp);
        Log.info(GlobalContext.local_log_filepath_temp + "文件夹创建成功");
        MainWindow.setUilog(GlobalContext.local_log_filepath_temp + "文件夹创建成功");
        FileUtils.CreateFolder(GlobalContext.local_summary_filepath_temp);
        Log.info(GlobalContext.local_summary_filepath_temp + "文件夹创建成功");
        MainWindow.setUilog(GlobalContext.local_summary_filepath_temp + "文件夹创建成功");

        Log.info("数据生成路径信息到测试机测试软件成功");
        MainWindow.setUilog("数据生成路径信息到测试机测试软件成功");

    }

    private void testCode() {
        String test_code = null;
        for (String s : jLabelMap.keySet()) {
            // last_testcode
            if ("Test_Code".equals(s)) {
                test_code = jLabelMap.get(s).getText();
            }
        }

        // 转换先不做 得到=右面的值
        SectionReader sectionReader = new SectionReader(ConfigFilePath.RECIPE_PATH);

        // 变量存值
        GlobalContext.testCode = sectionReader.getValue("TestCode_Config", test_code);
    }

//    // 追加
//    private static void appendMethod(String fileName, String content) {
//        try {
//            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件,如果为 true，则将字节写入文件末尾处，而不是写入文件开始处
//            FileWriter writer = new FileWriter(fileName, true);
//            writer.write(content);
//            writer.close();
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
//        }
//    }

    // 主界面显示批次的信息
    private void bacth() {
    	String str="";
    	for (String string : nameList) {
    		 for (String s : jLabelKeyMap.keySet()) {
                 if (s.equals(string)) {
                	 str+=string + ":" + jLabelMap.get(s).getText()+"\n";
//                     MainWindow.setTextAreaLotInfo(string + ":" + jLabelMap.get(s).getText());
                 }
             }
		}
    	MainWindow.setTextAreaLotInfo(str);
    }

    /**
     * 出值datarulename
     */

    private void dataRuleName() {
        ArrayList<String> list = new ArrayList<>();
        String tester_id = null;
        String program_name = null;
        String device_name = null;
        String customer_lotNo = null;
        String sub_lotNo = null;
        String mode_code = null;
        String test_code = null;
        for (String key : jLabelKeyMap.keySet()) {
            for (String s : jLabelMap.keySet()) {
                if (key.equals(s)) {
                    list.add(key + "=" + jLabelMap.get(s).getText());
                }
                if ("Tester_ID".equals(key)) {
                    tester_id = jLabelMap.get(key).getText();
                }
                if ("Device_Name".equals(key)) {
                    device_name = jLabelMap.get(key).getText();
                }
                if ("Customer_LotNo".equals(key)) {
                    customer_lotNo = jLabelMap.get(key).getText();
                }
                if ("Sub_LotNo".equals(key)) {
                    sub_lotNo = jLabelMap.get(key).getText();
                }
                if ("Mode_Code".equals(key)) {
                    mode_code = jLabelMap.get(key).getText();
                }
                if ("Test_Code".equals(key)) {
                    test_code = jLabelMap.get(key).getText();
                }
                if ("Program_Name".equals(key)) {
                    program_name = jLabelMap.get(key).getText();
                }
            }
        }
         LocalConfig.datalog_name_rules = "ForeHope" + "_" + tester_id + "_" + device_name + "_" + customer_lotNo + "_" + sub_lotNo + "_" + mode_code + "_" + test_code + "_" + program_name + "_" + LocalConfig.stratDate;
    }

    /**
     * @author Archer
     * @date 2021/05/27 15:29
     * @return
     */
    private  void  startLot(){
        EntityVo entityVo = new EntityVo();
        //commandconfig
        entityVo.setCommandConfig(GlobalContext.getCommandConfig());
       //envcomfig
        entityVo.setEnvConFigConfig(GlobalContext.getEnvConFigConfig());
        //ftpmodecofig
        entityVo.setFtpmodeConfig(GlobalContext.getFtpmodeConfig());
       //lastconfig
        entityVo.setLastConfig(GlobalContext.getLastConfig());
        //mesfileconfig
        entityVo.setMesFileConfig(GlobalContext.getMesFileConfig());
        //recipeconfig
        entityVo.setRecipeConfig(GlobalContext.getRecipeConfig());

         // 测试过程中，测试机数据临时存储文件夹
        entityVo.setTempData(GlobalContext.TempData);
        //二次批次界面的值
        entityVo.setjLabelKeyMap(jLabelKeyMap);
        entityVo.setjLabelMap(jLabelMap);
        //测试机路劲
        entityVo.setDatalog_name_rules(LocalConfig.datalog_name_rules);
      //指令
        entityVo.setCommand(GlobalContext.getCommandConfig().getStartLot());
       //连接状态
        entityVo.setStatus(0);
        //选择模式
        entityVo.setMode(GlobalContext.UImode);
        
        entityVo.setPaname(AppStart.pcname);
        entityVo.setServer_fulllotfile_folderpath(Temporary.server_fulllotfile_folderpath);
        entityVo.setServer_datalog_name_rule1(Temporary.server_datalog_name_rule1);
        entityVo.setServer_singlefile_folderpath(Temporary.server_singlefile_folderpath);
        entityVo.setLocal_csvdir_folderpath(Temporary.server_csvdir_folderpath);

        //发送开始测试
        ClientHandler.sendmsg(entityVo);
    }
}
