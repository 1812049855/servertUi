package com.fhec.method;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import com.fhec.context.EnvConFigConfig;
import com.fhec.context.LastConfig;
import com.fhec.context.MesFileConfig;
import com.fhec.driver.TeradyneDriverInit;
import com.fhec.driver.TeradyneEvent;
import com.fhec.entity.EntityVo;
import com.fhec.eqp.TeradyneEquipment;
import com.fhec.log.Log;
import com.fhec.utils.CSVUtils;
import com.fhec.utils.ExitUpload;
import com.fhec.utils.FileUtils;
import com.fhec.utils.FullLotEndUpload;
import com.fhec.utils.ListenerMaxSite;
import com.fhec.utils.LoadTestProgram;
import com.fhec.utils.RecordConfig;
import com.fhec.utils.upLoadFtp;

import io.netty.channel.ChannelHandlerContext;

/**
 * 通过指令执行相对应的方法
 *
 * @author Archer.W
 * @date 2021/04/16 09:26
 **/
public class MESCommandMethod {

    private EntityVo entiyVo;
    private ChannelHandlerContext channelHandlerContext;

    public MESCommandMethod() {
    }

    public MESCommandMethod(EntityVo entiyVo, ChannelHandlerContext channelHandlerContext) {
        this.entiyVo = entiyVo;
        this.channelHandlerContext = channelHandlerContext;
    }


    //SatrtLot mes
    public void startLotloadProgram() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String format = sdf.format(new Date());
        TeradyneEvent.prostattime = format;
        MesFileConfig mesFileConfig = entiyVo.getMesFileConfig();
        String program_Folder = mesFileConfig.getProgram_Folder();
        String test_Flow = mesFileConfig.getTest_Flow();
        EnvConFigConfig envConFigConfig = entiyVo.getEnvConFigConfig();
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
        if (programLoaded) {
            String last_zipfile = EntityVo.last_zipfile;
            String last_testflow = EntityVo.last_testflow;
            String zipfile_Name = mesFileConfig.getZipfile_Name();
            if (!last_zipfile.equals(zipfile_Name) && !test_Flow.equals(last_testflow)) {
                Thread th = new Thread(new LoadTestProgram(local_testflow_path, Programpath));
                th.start();
            }
        } else {
            Thread th = new Thread(new LoadTestProgram(local_testflow_path, Programpath));
            th.start();
        }
        Thread siteTh = new Thread(new ListenerMaxSite(entiyVo,channelHandlerContext));
        siteTh.start();
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        return map;
    }

    //SaveTestResult
    public void saveTestResultCommand() {
        System.out.println("savetestresult");
        EntityVo.saveDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        System.out.println( EntityVo.saveDate);
        EnvConFigConfig envConFigConfig = entiyVo.getEnvConFigConfig();
        EntityVo.TEST_TEMPDATA = envConFigConfig.getMainPath().getLocal_dlog_path() + "TempData";
        System.out.println(  EntityVo.TEST_TEMPDATA );
        // 状态
        //   MainStatus.status0();
        entiyVo.setType(3);
        entiyVo.setStatus(0);
        entiyVo.setMainStatus(0);
        channelHandlerContext.writeAndFlush(entiyVo);
        Log.info("save test result");

        //MainWindow.setUilog("save test result");
        entiyVo.setType(2);
        entiyVo.setStatus(0);
        entiyVo.setMainUIlog("save test result");
        channelHandlerContext.writeAndFlush(entiyVo);

        // 5.3.1 针对 tempdata 下的数据执行 close 动作
        EntityVo.saveStatus = 0;
        Log.info("针对 tempdata 下的数据执行 close 动作");
        //  MainWindow.setUilog("针对 tempdata 下的数据执行 close 动作");
        entiyVo.setType(2);
        entiyVo.setStatus(0);
        entiyVo.setMainUIlog("针对 tempdata 下的数据执行 close 动作");
        channelHandlerContext.writeAndFlush(entiyVo);


        //关闭通讯
        TeradyneEquipment teradyneInstantia = TeradyneDriverInit.TeradyneInstantia();
        teradyneInstantia.EndLot();
        teradyneInstantia.FileOutPut(false);
        teradyneInstantia.ApplySetup();
        teradyneInstantia.StopPolling();
        teradyneInstantia.Disconnect();
        SaveResultFtpJudge saveResultFtpJudge = new SaveResultFtpJudge(entiyVo,channelHandlerContext);
        // 判断测试数据是否存在
        FileUtils.CreateFolder(EntityVo.TEST_TEMPDATA);
        String[] fileList = new File(EntityVo.TEST_TEMPDATA).list();
        if (fileList.length == 0) {
            // 测试数据不存在
            JOptionPane.showConfirmDialog(null, "alarm U02:datalog is not exist，please call ME & PTE !", "提示",
                    JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
            Log.error("测试数据不存在");

            //MainWindow.setUilog("测试数据不存在");
            entiyVo.setType(2);
            entiyVo.setStatus(0);
            entiyVo.setMainUIlog("测试数据不存在");
            channelHandlerContext.writeAndFlush(entiyVo);

            //MainStatus.status2();
            entiyVo.setType(3);
            entiyVo.setMainStatus(2);
            entiyVo.setStatus(0);
            channelHandlerContext.writeAndFlush(entiyVo);
        } else {
            Log.info("测试数据存在");
            entiyVo.setType(2);
            entiyVo.setStatus(0);
            entiyVo.setMainUIlog("测试数据存在");
            channelHandlerContext.writeAndFlush(entiyVo);
            Log.info("网络存在");

            //MainWindow.setUilog("网络存在");
            entiyVo.setType(2);
            entiyVo.setMainUIlog("网络存在");
            entiyVo.setStatus(0);
            channelHandlerContext.writeAndFlush(entiyVo);

            try {
                // 生成summary 以csv结尾
                CSVUtils csv = new CSVUtils();
                csv.CSVOutPut(entiyVo);
                // 记录config信息
            	
                RecordConfig recordConfig = new RecordConfig();
                recordConfig.recordConfig(entiyVo);

                // 将 temp 路径下的数据剪切到 local_singlefile_folderpath 中
                saveResultFtpJudge.shearLocalSingFile();
             // 文件压缩
                saveResultFtpJudge.SingFileCompress();

                

                LastConfig lastConfig = entiyVo.getLastConfig();
                EntityVo.last_testflow = lastConfig.getLast_testflow();
                EntityVo.last_zipfile = lastConfig.getLast_zipfile();

                // 测试数据上传
                Thread th = new Thread(new upLoadFtp(saveResultFtpJudge,channelHandlerContext,entiyVo));
                th.start();
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);

                //MainStatus.status2();
                entiyVo.setType(3);
                entiyVo.setStatus(0);
                entiyVo.setMainStatus(2);
                channelHandlerContext.writeAndFlush(entiyVo);

                Log.error(e1.getMessage());
                return;
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                e1.printStackTrace();
                // MainStatus.status2();
                entiyVo.setType(3);
                entiyVo.setMainStatus(2);
                entiyVo.setStatus(0);
                channelHandlerContext.writeAndFlush(entiyVo);

                Log.error(e1.getMessage());
                return;
            }
        }
    }

    //FullEnd
    public void fullEndCommand() {
        System.out.println("fullend");
        TeradyneEquipment teradyneInstantia = TeradyneDriverInit.TeradyneInstantia();

        teradyneInstantia.StopPolling();
        teradyneInstantia.Disconnect();

        //    MainStatus.status0();
        entiyVo.setType(3);
        entiyVo.setMainStatus(0);
        entiyVo.setStatus(0);
        channelHandlerContext.writeAndFlush(entiyVo);

        TeradyneEvent.runflag = false;
        Log.info("lot end");
        //  MainWindow.setUilog("End Lot 开始执行");
        entiyVo.setType(2);
        entiyVo.setMainUIlog("End Lot 开始执行");
        entiyVo.setStatus(0);
        channelHandlerContext.writeAndFlush(entiyVo);
        TeradyneDriverInit.CleanAllList();

        // 判断 config 是否存在
        File file = new File(EntityVo.configTxt);
        // 不存在
        if (!file.exists()) {
            JOptionPane.showConfirmDialog(null, "alarm U05:config is not exist ，please call MFG leader !", "提示",
                    JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
            //  MainStatus.status3();
            entiyVo.setType(3);
            entiyVo.setStatus(0);
            entiyVo.setMainStatus(3);
            channelHandlerContext.writeAndFlush(entiyVo);
        } else {
            Thread th = new Thread(new FullLotEndUpload(entiyVo,channelHandlerContext));
            th.start();
        }
    }

    //Exit
    public void exitCommand() {
        Thread th = new Thread(new ExitUpload(entiyVo,channelHandlerContext));
        th.start();
        System.out.println("exit");
    }
}

