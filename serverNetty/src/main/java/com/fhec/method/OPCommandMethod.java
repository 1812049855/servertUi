package com.fhec.method;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import com.fhec.context.EnvConFigConfig;
import com.fhec.driver.TeradyneDriverInit;
import com.fhec.driver.TeradyneEvent;
import com.fhec.entity.EntityVo;
import com.fhec.eqp.TeradyneEquipment;
import com.fhec.log.Log;
import com.fhec.utils.CSVUtils;
import com.fhec.utils.ExitUpload;
import com.fhec.utils.FullLotEndUpload;
import com.fhec.utils.ListenerMaxSite;
import com.fhec.utils.LoadTestProgram;
import com.fhec.utils.RecordConfig;

import io.netty.channel.ChannelHandlerContext;

/**
 * 通过指令执行相对应的方法
 *
 * @author Archer.W
 * @date 2021/04/16 09:26
 **/
public class OPCommandMethod {

    private  EntityVo entiyVo;

    private ChannelHandlerContext channelHandlerContext;
    public OPCommandMethod() {
    }

    public OPCommandMethod(EntityVo entiyVo,ChannelHandlerContext channelHandlerContext) {
        this.entiyVo = entiyVo;
        this.channelHandlerContext = channelHandlerContext;
    }
    //SatrtLot op
    /**
     * 加载程序
     * @throws Exception
     */
    public void loadOPProgram() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String format = sdf.format(new Date());
        TeradyneEvent.prostattime = format;
        String program_Folder = entiyVo.getProgram_Folder();
        String test_Flow = entiyVo.getTest_Flow();
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
//        String DatalogSetupFile = programinfo.get("DatalogSetupFile");
        System.out.println(local_testflow_path + Programpath);
        File pro = new File(local_testflow_path + Programpath);
        if (!pro.exists())
            throw new Exception("测试程序不存在");


        boolean programLoaded = teradyneInstantia.isProgramLoaded();
        if(programLoaded) {
            String last_zipfile = EntityVo.last_zipfile;
            String last_testflow =EntityVo.last_testflow;
            String zipfile_Name =entiyVo.getZipfile_Name();
            if(!last_zipfile.equals(zipfile_Name)&&!test_Flow.equals(last_testflow)) {
                Thread th=new Thread(new LoadTestProgram(local_testflow_path,Programpath));
                th.start();
            }
        }else {
            Thread th=new Thread(new LoadTestProgram(local_testflow_path,Programpath));
            th.start();

        }
        Thread siteTh=new Thread(new ListenerMaxSite(entiyVo,channelHandlerContext));
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


    //SaveTestResult
    public  void saveTestResultCommand(){
        //5.2  断开测试机与 handler 通讯信号
        TeradyneEquipment terrineInstanter = TeradyneDriverInit.TeradyneInstantia();
        terrineInstanter.EndLot();
        terrineInstanter.FileOutPut(false);
        terrineInstanter.ApplySetup();
        terrineInstanter.StopPolling();
        terrineInstanter.Disconnect();
        try {
            // 生成summary 以csv结尾
            CSVUtils csv = new CSVUtils();
            csv.CSVOutPut(entiyVo);
            //记录config信息
            RecordConfig recordConfig = new RecordConfig();
            recordConfig.recordOpConfig(entiyVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("savetestresult");

    }
    //FullEnd
    public   void  fullEndCommand(){
        System.out.println("fullend");
        TeradyneEquipment teradyneInstantia = TeradyneDriverInit.TeradyneInstantia();
        teradyneInstantia.StopPolling();
        teradyneInstantia.Disconnect();
       // MainStatus.status0();
        TeradyneEvent.runflag = false;
        Log.info("lot end");
     //   MainWindow.setUilog("End Lot 开始执行");
        TeradyneDriverInit.CleanAllList();

        // 判断 config 是否存在
        File file = new File(EntityVo.configTxt);
        // 不存在
        if (!file.exists()) {
            JOptionPane.showConfirmDialog(null, "alarm U05:config is not exist ，please call MFG leader !", "提示",
                    JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
     //       MainStatus.status3();
        } else {
            Thread th = new Thread(new FullLotEndUpload());
            th.start();
        }

    }
    //Exit
    public  void exitCommand(){
        Thread th=new Thread(new ExitUpload(entiyVo,channelHandlerContext));
        th.start();
        System.out.println("exit");
        System.out.println("exit");
    }
}
