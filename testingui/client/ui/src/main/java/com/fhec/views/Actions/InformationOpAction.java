package com.fhec.views.Actions;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.fhec.context.LocalConfig;
import com.fhec.context.RecipeConfig;
import com.fhec.context.Temporary;
import com.fhec.driver.TeradyneDriverInit;
import com.fhec.driver.TeradyneEvent;
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

public class InformationOpAction extends AbstractActionListener<InformationConfirmationView> {

    private Map<String, JLabel> jLabelMap;

    private Map<String, JLabel> jLabelKeyMap;
    private List<String> nameList;

    public InformationOpAction(InformationConfirmationView window, Map<String, JLabel> jLabelMap,
                               Map<String, JLabel> jLabelKeyMap, List<String> nameList) {
        super(window);
        this.jLabelMap = jLabelMap;
        this.jLabelKeyMap = jLabelKeyMap;
        this.nameList = nameList;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        this.window.lastOpBatch();

        // 初始化envconfig文件
        EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();

        // recipe 配置文件的内容
        RecipeConfig recipeConfig = GlobalContext.getRecipeConfig();

        // last
        LastConfig lastConfig = GlobalContext.getLastConfig();

        Boolean isEmpty = this.window.getIsEmpty();

        // 检查批次输入界面每个栏位是否存在空格
        if (isEmpty) {
            LocalConfig.check200 = true;
            Log.info("批次输入界面每个栏位不存在空格");
            MainWindow.setUilog("批次输入界面每个栏位不存在空格");
        } else {
            LocalConfig.check200 = false;
            Log.info("批次输入界面每个栏位存在空格");
            MainWindow.setUilog("批次输入界面每个栏位存在空格");
        }

        // 判断 lot_device_name Device_Name与 last_device_name 是否一致
        //jLabelMap存放的是确认界面的值
        for (String s : jLabelMap.keySet()) {
            // 判断 lot_device_name Device_Name与 last_device_name 是否一致
            if ("Device_Name".equals(s)) {
                System.out.println(jLabelMap.get(s).getText());
                System.out.println(lastConfig.getLast_device_name());
                if (jLabelMap.get(s).getText().equals(lastConfig.getLast_device_name())) {
                    LocalConfig.check201 = true;
                    Log.info("lot_device_name Device_Name与 last_device_name 一致");
                    MainWindow.setUilog("Log.info(lot_device_name Device_Name与 last_device_name 一致);");
                } else {
                    LocalConfig.check201 = false;
                    Log.info("lot_device_name Device_Name与 last_device_name 不一致");
                    MainWindow.setUilog("Log.info(lot_device_name Device_Name与 last_device_name 不 一致);");
                }
            }
        }

        //判断 barcodefile_TesterOS 与 current_TesterOS 是否一致，一致则 check202=true 不一致则 check202= false
        if (Temporary.testerOS_Version.equals(LocalConfig.currentOpTesterOS)) {
            LocalConfig.check202 = true;
            Log.info("barcodefile_TesterOS 与 current_TesterOS 一致");
            MainWindow.setUilog("barcodefile_TesterOS 与 current_TesterOS 一致");
        } else {
            LocalConfig.check202 = false;
            Log.info("barcodefile_TesterOS 与 current_TesterOS 不一致");
            MainWindow.setUilog("barcodefile_TesterOS 与 current_TesterOS不 一致");
        }

        //判断当前测试机是否已安装 barcodefile_TesterOS，已安装则 check203=true，未安装则 check203=false


        // 检查批次输入界面 Test_Code 内容是否符合 recipe testcode 卡控规则
        for (String s : jLabelMap.keySet()) {
            if ("Test_Code".equals(s)) {
                if (jLabelMap.get(s).getText().matches(recipeConfig.getInputOITestCode().getPattern())) {
                    LocalConfig.check204 = true;
                    Log.info(" 检查批次输入界面 Test_Code 内容符合 recipe testcode 卡控规则");
                    MainWindow.setUilog(" 检查批次输入界面 Test_Code 内容符合 recipe testcode 卡控规则;");
                } else {
                    LocalConfig.check204 = false;
                    Log.info(" 检查批次输入界面 Test_Code 内容不符合 recipe testcode 卡控规则");
                    MainWindow.setUilog(" 检查批次输入界面 Test_Code 内容不符合 recipe testcode 卡控规则;");
                }
            }
        }

        // 检查批次输入界面 Mode_Code 内容是否符合 recipe modecode 卡控规则
        for (String s : jLabelMap.keySet()) {
            if ("Mode_Code".equals(s)) {
                if (jLabelMap.get(s).getText().matches(recipeConfig.getInputOIModeCode().getPattern())) {
                    LocalConfig.check205 = true;
                    Log.info(" 检查批次输入界面 Mode_Code 内容符合 recipe modecode 卡控规则");
                    MainWindow.setUilog(" 检查批次输入界面 Mode_Code 内容符合 recipe modecode 卡控规则;");
                } else {
                    LocalConfig.check205 = false;
                    Log.info(" 检查批次输入界面 Mode_Code 内容不符合 recipe modecode 卡控规则");
                    MainWindow.setUilog(" 检查批次输入界面 Mode_Code 内容不符合 recipe modecode 卡控规则");
                }

            }
        }
        // 检查批次输入界面 Test_BinNo 内容是否符合 recipe testbinno 卡控规则
        for (String s : jLabelMap.keySet()) {
            if ("Test_BinNo".equals(s)) {
                if (jLabelMap.get(s).getText().matches(recipeConfig.getInputOITestBinNo().getPattern())) {
                    LocalConfig.check206 = true;
                    Log.info("检查批次输入界面 Test_BinNo 内容符合 recipe testbinno 卡控规则");
                    MainWindow.setUilog("检查批次输入界面 Test_BinNo 内容符合 recipe testbinno 卡控规则");
                } else {
                    LocalConfig.check206 = false;
                    Log.info("检查批次输入界面 Test_BinNo 内容不符合 recipe testbinno 卡控规则");
                    MainWindow.setUilog("检查批次输入界面 Test_BinNo 内容不符合 recipe testbinno 卡控规则");
                }
            }
        }

        //检查程序下载界面的 Program_Name 与批次输入界面的 Program_Name 是否一致
        for (String s : jLabelMap.keySet()) {
            if ("Program_Name".equals(s)) {
                if (jLabelMap.get(s).getText().equals(Temporary.opprogeamName)) {
                    LocalConfig.check207 = true;
                    Log.info("检查程序下载界面的 Program_Name 与批次输入界面的 Program_Name 一致");
                    MainWindow.setUilog("检查程序下载界面的 Program_Name 与批次输入界面的 Program_Name 一致");
                } else {
                    LocalConfig.check207 = false;
                    Log.info("检查程序下载界面的 Program_Name 与批次输入界面的 Program_Name 不一致");
                    MainWindow.setUilog("检查程序下载界面的 Program_Name 与批次输入界面的 Program_Name不 一致");
                }
            }
        }
        //检查当前测试机校准日期与当天日期的间隔是否超过[Tester_caldata_check]定义的天数


        //当批次输入界面中的 customer id 为”SETUP”、”RL”、”FL”、”OTHERS”、”IR1” 、”IR2” 、”IR3”时则不执行 4.3.2 所有项目的检查
        for (String s : jLabelMap.keySet()) {
            if ("Customer_ID".equals(s)) {
                if (jLabelMap.get(s).getText().equals("SETUP") || jLabelMap.get(s).getText().equals("RL")
                        || jLabelMap.get(s).getText().equals("FL") || jLabelMap.get(s).getText().equals("OTHERS")
                        || jLabelMap.get(s).getText().equals("IR1") || jLabelMap.get(s).getText().equals("IR2")
                        || jLabelMap.get(s).getText().equals("IR3")) {

                    // 依据 recipe 中的[TestCode_Config] 规则，将批次输入界面的 testcode 转换，
                    // 转换 得到=右面的值
                    // 变量存值
                    testCode();
                    Log.info("将批次输入界面的 testcode 转换");
                    MainWindow.setUilog("将批次输入界面的 testcode 转换");
                    // 写出的状态
                    LocalConfig.status = 1;

                    try {

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
                        // 把信息输入到主界面
                        // 把信息输入到主界面   jLabelKeyMap 存放的是确认界面名字
                        bacth();
                        //赋值
                        dataRuleName();
                        MainWindow.setTextAreaLotInfo("\n");
                        Log.info("打开summary汇总界面");
                        MainWindow.setUilog("打开summary汇总界面");
                        // 加载程序
                       //loadProgram();
                        startLot();
                        SummaryView.getSummaryView();
                        MainStatus.status2();
                        return;

                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        JOptionPane.showConfirmDialog(null, e.getMessage(), "提示",
                                JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
                        MainStatus.status1();
                    }

                }
            } else {
                //当 check208 为 false 时
                if (!LocalConfig.check208) {
                    Log.info("check208 = false");
                    JOptionPane.showConfirmDialog(null, "alarm O10:tester need to do calibration,pls call ME !", "提示",
                            JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
                    // OP 点击 OK 按钮后，返回点击 start lot 之前的界面，重新操作

                    Log.error("check208 为 false,关闭窗体，返回主界面成功");
                    MainWindow.setUilog("关闭窗体，返回主界面成功");
                    this.window.dispose();
                    MainStatus.status1();
                    return;
                } else {
                    //批次信息栏位输入规则比对check200，check204，check205，check206，check207 中任意一个非 true 时
                    if (LocalConfig.check200 && LocalConfig.check204 && LocalConfig.check205 && LocalConfig.check206 && LocalConfig.check207) {

                        //若 system count >0 且 check201 为 false 时，Device_Name 前后不一致
                        if (LocalConfig.systemCount > 0 && !LocalConfig.check201) {
                            Log.info("system count >0 且 check201 为 false ");
                            JOptionPane.showConfirmDialog(null, " alarm O12:DeviceName is not match,pls call ME setup !!", "提示",
                                    JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);

                            // env_config 中的 alarm_O12_flag = 1，
                            if (EnvConFigConfig.uninstall.equals(envConFigConfig.getAlarmControLFlag().getAlarm_O12_flag())) {
                                // 进行卸载测试程序，退出 UI，删除本地程序
                                FileUtils.removeDir(new File(envConFigConfig.getMainPath().getLocal_dlog_path()));
                                // 保存 UI log 并上传 待做
                                Log.error("alarm O12 = 1,卸载测试程序，退出 UI");
                                ExitUninstall exitUninstall = new ExitUninstall();
                                exitUninstall.exitUnistall();
                                System.exit(0);
                            } else if (EnvConFigConfig.recover.equals(envConFigConfig.getAlarmControLFlag().getAlarm_O12_flag())) {
                                // 若 alarm_O12_flag= 0，则返回点击 start lot 之前的界面
                                this.window.dispose();
                                Log.info("alarm O12 = 0,返回主界面成功");
                                MainWindow.setUilog("alarm O12 = 0,返回主界面成功");
                                MainStatus.status1();
                                return;
                            }

                        } else if (LocalConfig.systemCount >= 0 && LocalConfig.check201) {
                            //1若 check203 为 false 时，需求测试机版本未安装
                            if (!LocalConfig.check203) {
                                Log.info("check203 为 false ");
                                JOptionPane.showConfirmDialog(null, "alarm O13:tester software is not install，please call ME !", "提示",
                                        JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
                                if (EnvConFigConfig.uninstall.equals(envConFigConfig.getAlarmControLFlag().getAlarm_O13_flag())) {

                                    // 进行卸载测试程序，退出 UI，删除本地程序
                                    FileUtils.removeDir(new File(envConFigConfig.getMainPath().getLocal_dlog_path()));
                                    // 保存 UI log 并上传 待做
                                    Log.error("alarm O13 = 1,卸载测试程序，退出 UI");
                                    ExitUninstall exitUninstall = new ExitUninstall();
                                    exitUninstall.exitUnistall();
                                    System.exit(0);
                                } else if (EnvConFigConfig.recover.equals(envConFigConfig.getAlarmControLFlag().getAlarm_O13_flag())) {
                                    // 若 alarm_O12_flag= 0，则返回点击 start lot 之前的界面
                                    this.window.dispose();
                                    Log.info("alarm O13 = 0,返回主界面成功");
                                    MainWindow.setUilog("alarm O13 = 0,返回主界面成功");
                                    MainStatus.status1();
                                    return;
                                }

                            } else {

                                // 依据 recipe 中的[TestCode_Config] 规则，将批次输入界面的 testcode 转换，
                                // 转换 得到=右面的值
                                // 变量存值
                                testCode();
                                Log.info("将批次输入界面的 testcode 转换");
                                MainWindow.setUilog("将批次输入界面的 testcode 转换");
                                // 写出的状态
                                LocalConfig.status = 1;

                                try {

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

                                    // 把信息输入到主界面
                                    bacth();
                                    //赋值
                                    dataRuleName();
                                    MainWindow.setTextAreaLotInfo("\n");
                                    Log.info("打开summary汇总界面");
                                    MainWindow.setUilog("打开summary汇总界面");
                                    // 加载程序
                                    // loadProgram();
                                    startLot();
                                    SummaryView.getSummaryView();
                                    MainStatus.status2();
                                    return;
                                } catch (Exception e) {
                                    // TODO Auto-generated catch block
                                    JOptionPane.showConfirmDialog(null, e.getMessage(), "提示",
                                            JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
                                    MainStatus.status1();
                                }
                            }
                        }

                    } else {
                        Log.info("check200，check204，check205，check206，check207 中任意一个非 true ");
                        JOptionPane.showConfirmDialog(null, "alarm O11:tester need to do calibration,pls call ME !", "提示",
                                JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);

                        // OP 点击 OK 按钮后，返回点击 start lot 之前的界面，重新操作
                        Log.error("check200，check204，check205，check206，check207 中任意一个非 true");
                        MainWindow.setUilog("关闭窗体，返回主界面成功");
                        this.window.dispose();
                        MainStatus.status1();
                        return;
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
        Temporary.local_datalog_name_rule1 = envConFigConfig.getMainPath().getLocal_dlog_path() + Customer_ID + File.separator + Device_Name
                + File.separator + Customer_LotNo + File.separator + Sub_LotNo;
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

        Temporary.server_datalog_name_rule1 = envConFigConfig.getMainPath().getServer_dlog_path() + Customer_ID + File.separator + Device_Name
                + File.separator + Customer_LotNo + File.separator + Sub_LotNo;
        // csvdir 文件夹：server_csvdir_folderpath =\\datalog_name_rule_1\csvdir
        Temporary.server_csvdir_folderpath = Temporary.server_datalog_name_rule1 + File.separator + "csvdir";

        // SingleFile 文件夹：server_singlefile_folderpath =\\datalog_name_rule_1\SingleFile
        Temporary.server_singlefile_folderpath = Temporary.server_datalog_name_rule1 + File.separator + "SingleFile";

        // 汇总 summary 文件夹：server_fulllotfile_folderpath
        // =\\datalog_name_rule_1\FullLotFile
        Temporary.server_fulllotfile_folderpath = Temporary.server_datalog_name_rule1 + File.separator + "FullLotFile";

        // 判断服务器上文件夹是否存在 server_csvdir_folderpath
        try {
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
                // 替换特殊字符
                for (String s : jLabelMap.keySet()) {
                    if ("Customer_ID".equals(s)) {
                        String specialCharacters = replaceSpecialCharacters(jLabelMap.get(s).getText());
                        if (specialCharacters == null || "".equals(specialCharacters)) {
                            return;
                        }
                    }
                    if ("Device_Name".equals(s)) {
                        String specialCharacters = replaceSpecialCharacters(jLabelMap.get(s).getText());
                        if (specialCharacters == null || "".equals(specialCharacters)) {
                            return;
                        }
                    }
                    if ("Customer_LotNo".equals(s)) {
                        String specialCharacters = replaceSpecialCharacters(jLabelMap.get(s).getText());
                        if (specialCharacters == null || "".equals(specialCharacters)) {
                            return;
                        }
                    }
                    if ("Sub_LotNo".equals(s)) {
                        String specialCharacters = replaceSpecialCharacters(jLabelMap.get(s).getText());
                        if (specialCharacters == null || "".equals(specialCharacters)) {
                            return;
                        }
                    }

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
            JOptionPane.showConfirmDialog(null, e.getMessage(), "提示",
                    JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
            // 1
            MainStatus.status1();
        }

        //server_singlefile_folderpath
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
                for (String s : jLabelMap.keySet()) {
                    if ("Customer_ID".equals(s)) {
                        String specialCharacters = replaceSpecialCharacters(jLabelMap.get(s).getText());
                        if (specialCharacters == null || "".equals(specialCharacters)) {
                            return;
                        }
                    }
                    if ("Device_Name".equals(s)) {
                        String specialCharacters = replaceSpecialCharacters(jLabelMap.get(s).getText());
                        if (specialCharacters == null || "".equals(specialCharacters)) {
                            return;
                        }
                    }
                    if ("Customer_LotNo".equals(s)) {
                        String specialCharacters = replaceSpecialCharacters(jLabelMap.get(s).getText());
                        if (specialCharacters == null || "".equals(specialCharacters)) {
                            return;
                        }
                    }
                    if ("Sub_LotNo".equals(s)) {
                        String specialCharacters = replaceSpecialCharacters(jLabelMap.get(s).getText());
                        if (specialCharacters == null || "".equals(specialCharacters)) {
                            return;
                        }
                    }

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
            JOptionPane.showConfirmDialog(null, e.getMessage(), "提示",
                    JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
            // 1
            MainStatus.status1();
        }
        //server_fulllotfile_folderpath

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
                for (String s : jLabelMap.keySet()) {
                    if ("Customer_ID".equals(s)) {
                        String specialCharacters = replaceSpecialCharacters(jLabelMap.get(s).getText());
                        if (specialCharacters == null || "".equals(specialCharacters)) {
                            return;
                        }
                    }
                    if ("Device_Name".equals(s)) {
                        String specialCharacters = replaceSpecialCharacters(jLabelMap.get(s).getText());
                        if (specialCharacters == null || "".equals(specialCharacters)) {
                            return;
                        }
                    }
                    if ("Customer_LotNo".equals(s)) {
                        String specialCharacters = replaceSpecialCharacters(jLabelMap.get(s).getText());
                        if (specialCharacters == null || "".equals(specialCharacters)) {
                            return;
                        }
                    }
                    if ("Sub_LotNo".equals(s)) {
                        String specialCharacters = replaceSpecialCharacters(jLabelMap.get(s).getText());
                        if (specialCharacters == null || "".equals(specialCharacters)) {
                            return;
                        }
                    }

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
            // 1
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

    /**
     * 加载程序
     *
     * @throws Exception
     */
    public void loadProgram() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String format = sdf.format(new Date());
        TeradyneEvent.prostattime = format;
        String program_Folder = Temporary.Program_Folder;
        String test_Flow = Temporary.test_Flow;
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
//        String DatalogSetupFile = programinfo.get("DatalogSetupFile");
        System.out.println(local_testflow_path + Programpath);
        File pro = new File(local_testflow_path + Programpath);
        if (!pro.exists())
            throw new Exception("测试程序不存在");


        boolean programLoaded = teradyneInstantia.isProgramLoaded();
        if (programLoaded) {
            String last_zipfile = Temporary.last_zipfile;
            String last_testflow = Temporary.last_testflow;
            String zipfile_Name = Temporary.Zipfile_Name;
            if (!last_zipfile.equals(zipfile_Name) && !test_Flow.equals(last_testflow)) {
                Thread th = new Thread(new LoadTestProgram(local_testflow_path, Programpath));
                th.start();
            }
        } else {
            Thread th = new Thread(new LoadTestProgram(local_testflow_path, Programpath));
            th.start();

        }
        Thread siteTh = new Thread(new ListenerMaxSite());
        siteTh.start();
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

    //转换
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


    // 主界面显示批次的信息
    private void bacth() {
        String str = "";
        for (String string : nameList) {
            for (String s : jLabelKeyMap.keySet()) {
                if (s.equals(string)) {
                    str += string + ":" + jLabelMap.get(s).getText() + "\n";
//                    MainWindow.setTextAreaLotInfo(string + ":" + jLabelMap.get(s).getText());
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
     * @return
     * @author Archer
     * @date 2021/05/27 15:29
     */
    private void startLot() {
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
        entityVo.setStatus(EntityVo.status1);
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
