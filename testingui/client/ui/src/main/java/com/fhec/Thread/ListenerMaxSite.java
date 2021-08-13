package com.fhec.Thread;

import java.io.File;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.fhec.context.EnvConFigConfig;
import com.fhec.context.GlobalContext;
import com.fhec.context.LocalConfig;
import com.fhec.context.MesFileConfig;
import com.fhec.context.Temporary;
import com.fhec.driver.TeradyneDriverInit;
import com.fhec.driver.TeradyneEvent;
import com.fhec.eqp.TeradyneEquipment;
import com.fhec.mainstatus.MainStatus;
import com.fhec.views.InformationConfirmationView;
import com.fhec.views.MainWindow;
import com.fhec.views.SummaryView;
import com.fhec.views.Actions.InformationAction;

public class ListenerMaxSite implements Runnable{
	@Override
	public void run() {
		boolean runstatus=true;
		TeradyneEquipment teradyneInstantia = TeradyneDriverInit.TeradyneInstantia();
		while (runstatus) {
			if(TeradyneEvent.MaxSite>0) {
				MainWindow.progress(true);
				MainWindow.setProgressTxt("测试程序加载完成");
				MainWindow.redJProgressBar(100, 99);
				runstatus=false;
				InformationAction info=new InformationAction(null, null, null, null);
				if("MES".equals(GlobalContext.UImode)) {
					MesFileConfig mesFileConfig = GlobalContext.getMesFileConfig();
					String program_Folder = mesFileConfig.getProgram_Folder();
					String test_Flow = mesFileConfig.getTest_Flow();
					
					EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
				    String local_prog_path = envConFigConfig.getMainPath().getLocal_prog_path();
				 
					
				        String local_testflow_path = local_prog_path + program_Folder + File.separator;
				        String protxtpath = local_testflow_path + "LoadFile" + File.separator + test_Flow;
				        Map<String, String> programinfo = info.getPrograminfo(protxtpath);
				        String DatalogSetupFile = programinfo.get("DatalogSetupFile");
				        String txt = envConFigConfig.getMainPath().getLocal_dlog_path() + GlobalContext.TempData + File.separator
				                + LocalConfig.datalog_name_rules + ".txt";
				        String sum = envConFigConfig.getMainPath().getLocal_dlog_path() + GlobalContext.TempData + File.separator
				                + LocalConfig.datalog_name_rules + ".sum";
				        String std = envConFigConfig.getMainPath().getLocal_dlog_path() + GlobalContext.TempData + File.separator
				                + LocalConfig.datalog_name_rules + ".std";
				        TeradyneEvent.stdffilefolder = envConFigConfig.getMainPath().getLocal_dlog_path() + GlobalContext.TempData;
				        TeradyneEvent.stdffilepath = std;
				        Temporary.stdUnkName=LocalConfig.datalog_name_rules+".std";
				        String device_Name = mesFileConfig.getDevice_Name();
				        String program_Name = mesFileConfig.getProgram_Name();
				        String zipfile_Name = mesFileConfig.getZipfile_Name();
				        String customer_LotNo = mesFileConfig.getCustomer_LotNo();
				        String sub_LotNo = mesFileConfig.getSub_LotNo();
				 
				        JLabel jLabel = InformationConfirmationView.jLabelMap.get("Operator_ID");
				        String Operator_ID = jLabel.getText();
				        JLabel jLabel2 = InformationConfirmationView.jLabelMap.get("Test_BinNo");
				        String Test_BinNo = jLabel2.getText();
				        JLabel jLabel3 = InformationConfirmationView.jLabelMap.get("Test_Code");
				       
				        String Test_Code = jLabel3.getText();
				        //
				        String mode_Code = mesFileConfig.getMode_Code();
				        // bin
				        String setup_id = "PRODUCTION";
				        String customer_ID = mesFileConfig.getCustomer_ID();
				        String facil_id = "ForeHope";
				        // flow_id
				        // rest_cod
				        String lot_Type = mesFileConfig.getLot_Type();
				        if ("M".equals(lot_Type) || "MP".equals(lot_Type)) {
				            lot_Type = "P";
				        } else if ("E".equals(lot_Type) || "Q".equals(lot_Type)) {
				            lot_Type = "E";
				        }
				        String[] stdfmir = new String[15];
				        stdfmir[0] = device_Name; // PART_TYPE
				        stdfmir[1] = device_Name; // DSGN_REV
				        stdfmir[2] = customer_LotNo; // LOT_ID
				        stdfmir[3] = sub_LotNo; // SBLOT_ID
				        stdfmir[4] = ""; // TST_TEMP
				        stdfmir[5] = program_Name; // JOB_NAM
				        stdfmir[6] = Test_BinNo; // USER_TXT
				        stdfmir[7] = lot_Type; // MODE_COD
				        stdfmir[8] = Test_Code; // FLOW_ID
				        stdfmir[9] = facil_id; // FACIL_ID
				        stdfmir[10] = Operator_ID; // OPER_NAM
				        stdfmir[11] = customer_ID; // FAMLY_ID
				        stdfmir[12] = mode_Code; // TEST_COD
				        stdfmir[13] = zipfile_Name; // JOB_REV
				        stdfmir[14] = setup_id; // SETUP_ID
						teradyneInstantia.STDFMIR(stdfmir);
						teradyneInstantia.SetDataLogStdf(std, txt);
						teradyneInstantia.SetSummaryStdf(std, sum);
						String setupfilepath = local_testflow_path + File.separator + DatalogSetupFile;
						System.out.println(setupfilepath);
						teradyneInstantia.SetupFile(setupfilepath);
						teradyneInstantia.FileOutPut(true);
						teradyneInstantia.ApplySetup();
						boolean calibrateTDR = teradyneInstantia.CalibrateTDR();
						if(calibrateTDR) {
							TeradyneEvent.runflag=true;
					        teradyneInstantia.StartPolling();	
						}else {
									 JOptionPane.showConfirmDialog(null, "TDR校验失败 ",
	                                "error", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
									 teradyneInstantia.UnloadTestProgram();
									 MainWindow.setProgressTxt("TDR校验失败 ");
									 MainStatus.status1();
									 return ;
						}
				        
				        
				}else if("OP".equals(GlobalContext.UImode)) {

//					MesFileConfig mesFileConfig = GlobalContext.getMesFileConfig();
					String program_Folder = Temporary.Program_Folder;
					String test_Flow = Temporary.test_Flow;
					
					EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
				    String local_prog_path = envConFigConfig.getMainPath().getLocal_prog_path();
				 
					
				        String local_testflow_path = local_prog_path + program_Folder + File.separator;
				        String protxtpath = local_testflow_path + "LoadFile" + File.separator + test_Flow;
				        Map<String, String> programinfo = info.getPrograminfo(protxtpath);
				        String DatalogSetupFile = programinfo.get("DatalogSetupFile");
				        String txt = envConFigConfig.getMainPath().getLocal_dlog_path() + GlobalContext.TempData + File.separator
				                + LocalConfig.datalog_name_rules + ".txt";
				        String sum = envConFigConfig.getMainPath().getLocal_dlog_path() + GlobalContext.TempData + File.separator
				                + LocalConfig.datalog_name_rules + ".sum";
				        String std = envConFigConfig.getMainPath().getLocal_dlog_path() + GlobalContext.TempData + File.separator
				                + LocalConfig.datalog_name_rules + ".std";
				        TeradyneEvent.stdffilefolder = envConFigConfig.getMainPath().getLocal_dlog_path() + GlobalContext.TempData;
				        TeradyneEvent.stdffilepath = std;
				        Temporary.stdUnkName=LocalConfig.datalog_name_rules+".std";
				        String device_Name = InformationConfirmationView.jLabelMap.get("Device_Name").getText();
				        String program_Name =Temporary.opprogeamName;
				        String zipfile_Name =Temporary.Zipfile_Name;
				        String customer_LotNo = InformationConfirmationView.jLabelMap.get("Customer_LotNo").getText();
				        String sub_LotNo =InformationConfirmationView.jLabelMap.get("Sub_LotNo").getText();				 
				        JLabel jLabel = InformationConfirmationView.jLabelMap.get("Operator_ID");
				        String Operator_ID = jLabel.getText();
				        JLabel jLabel2 = InformationConfirmationView.jLabelMap.get("Test_BinNo");
				        String Test_BinNo = jLabel2.getText();
				        JLabel jLabel3 = InformationConfirmationView.jLabelMap.get("Test_Code");
				       
				        String Test_Code = jLabel3.getText();
				        //
				        String mode_Code = InformationConfirmationView.jLabelMap.get("Mode_Code").getText();
				        // bin
				        String setup_id = "PRODUCTION";
				        String customer_ID ="";
				        String facil_id = "ForeHope";
				        // flow_id
				        // rest_cod
				        String lot_Type = "";
				        if ("M".equals(lot_Type) || "MP".equals(lot_Type)) {
				            lot_Type = "P";
				        } else if ("E".equals(lot_Type) || "Q".equals(lot_Type)) {
				            lot_Type = "E";
				        }
				        String[] stdfmir = new String[15];
				        stdfmir[0] = device_Name; // PART_TYPE
				        stdfmir[1] = device_Name; // DSGN_REV
				        stdfmir[2] = customer_LotNo; // LOT_ID
				        stdfmir[3] = sub_LotNo; // SBLOT_ID
				        stdfmir[4] = ""; // TST_TEMP
				        stdfmir[5] = program_Name; // JOB_NAM
				        stdfmir[6] = Test_BinNo; // USER_TXT
				        stdfmir[7] = lot_Type; // MODE_COD
				        stdfmir[8] = Test_Code; // FLOW_ID
				        stdfmir[9] = facil_id; // FACIL_ID
				        stdfmir[10] = Operator_ID; // OPER_NAM
				        stdfmir[11] = customer_ID; // FAMLY_ID
				        stdfmir[12] = mode_Code; // TEST_COD
				        stdfmir[13] = zipfile_Name; // JOB_REV
				        stdfmir[14] = setup_id; // SETUP_ID
						teradyneInstantia.STDFMIR(stdfmir);
						teradyneInstantia.SetDataLogStdf(std, txt);
						teradyneInstantia.SetSummaryStdf(std, sum);
						String setupfilepath = local_testflow_path + File.separator + DatalogSetupFile;
						System.out.println(setupfilepath);
						teradyneInstantia.SetupFile(setupfilepath);
						teradyneInstantia.FileOutPut(true);
						teradyneInstantia.ApplySetup();
						boolean calibrateTDR = teradyneInstantia.CalibrateTDR();
						if(calibrateTDR) {
							TeradyneEvent.runflag=true;
					        teradyneInstantia.StartPolling();	
						}else {
									 JOptionPane.showConfirmDialog(null, "TDR校验失败 ",
	                                "error", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
									 teradyneInstantia.UnloadTestProgram();
									 MainWindow.setProgressTxt("TDR校验失败 ");
									 MainStatus.status1();
									 return ;
						}
				        runstatus=false;
				}
				
				SummaryView.getSummaryView();
				MainWindow.progress(false);
				
			}
			
		}
	}

}
