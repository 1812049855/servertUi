package com.fhec.utils;

import java.io.File;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.fhec.context.EnvConFigConfig;
import com.fhec.context.MesFileConfig;
import com.fhec.driver.TeradyneDriverInit;
import com.fhec.driver.TeradyneEvent;
import com.fhec.entity.EntityVo;
import com.fhec.eqp.TeradyneEquipment;
import com.fhec.method.MESCommandMethod;
import com.fhec.method.OPCommandMethod;

import io.netty.channel.ChannelHandlerContext;

public class ListenerMaxSite implements Runnable {
	private EntityVo entityVo;
	private ChannelHandlerContext channelHandlerContext;

	public ListenerMaxSite(EntityVo entityVo, ChannelHandlerContext channelHandlerContext) {
		this.channelHandlerContext = channelHandlerContext;
		this.entityVo = entityVo;
	}

	@Override
	public void run() {
		boolean runstatus = true;
		TeradyneEquipment teradyneInstantia = TeradyneDriverInit.TeradyneInstantia();
		while (runstatus) {
			if (TeradyneEvent.MaxSite > 0) {
//                MainWindow.progress(true);
//                MainWindow.setProgressTxt("测试程 序加载完成");
//                MainWindow.redJProgressBar(100, 99);
				runstatus = false;
				// InformationAction info=new InformationAction(null, null, null, null);
				MESCommandMethod mesCommandMethod = new MESCommandMethod();
				OPCommandMethod opCommandMethod = new OPCommandMethod();
				if ("MES".equals(entityVo.getMode())) {
					System.out.println("MES===========================================");
					MesFileConfig mesFileConfig = entityVo.getMesFileConfig();
					String program_Folder = mesFileConfig.getProgram_Folder();
					String test_Flow = mesFileConfig.getTest_Flow();

					EnvConFigConfig envConFigConfig = entityVo.getEnvConFigConfig();
					String local_prog_path = envConFigConfig.getMainPath().getLocal_prog_path();

					String local_testflow_path = local_prog_path + program_Folder + File.separator;
					String protxtpath = local_testflow_path + "LoadFile" + File.separator + test_Flow;
					Map<String, String> programinfo = mesCommandMethod.getPrograminfo(protxtpath);
					String DatalogSetupFile = programinfo.get("DatalogSetupFile");
					String txt = envConFigConfig.getMainPath().getLocal_dlog_path() + entityVo.getTempData()
							+ File.separator + entityVo.getDatalog_name_rules() + ".txt";
					String sum = envConFigConfig.getMainPath().getLocal_dlog_path() + entityVo.getTempData()
							+ File.separator + entityVo.getDatalog_name_rules() + ".sum";
					String std = envConFigConfig.getMainPath().getLocal_dlog_path() + entityVo.getTempData()
							+ File.separator + entityVo.getDatalog_name_rules() + ".std";
					TeradyneEvent.stdffilefolder = envConFigConfig.getMainPath().getLocal_dlog_path()
							+ entityVo.getTempData();
					TeradyneEvent.stdffilepath = std;
					EntityVo.stdUnkName = entityVo.getDatalog_name_rules() + ".std";
					String device_Name = mesFileConfig.getDevice_Name();

					String program_Name = mesFileConfig.getProgram_Name();
					String zipfile_Name = mesFileConfig.getZipfile_Name();
					String customer_LotNo = mesFileConfig.getCustomer_LotNo();
					String sub_LotNo = mesFileConfig.getSub_LotNo();

					JLabel jLabel = entityVo.getjLabelMap().get("Operator_ID");
					String Operator_ID = jLabel.getText();
					JLabel jLabel2 = entityVo.getjLabelMap().get("Test_BinNo");
					String Test_BinNo = jLabel2.getText();
					JLabel jLabel3 = entityVo.getjLabelMap().get("Test_Code");

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
					String[] stdfmir = new String[16];
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
					stdfmir[15] = ""; // 
					teradyneInstantia.STDFMIR(stdfmir);
					teradyneInstantia.SetDataLogStdf(std, txt);
					teradyneInstantia.SetSummaryStdf(std, sum);
					String setupfilepath = local_testflow_path + File.separator + DatalogSetupFile;
					System.out.println(setupfilepath);
					teradyneInstantia.SetupFile(setupfilepath);
					teradyneInstantia.FileOutPut(true);
					teradyneInstantia.ApplySetup();
					boolean calibrateTDR = teradyneInstantia.CalibrateTDR();
					if (calibrateTDR)
						TeradyneEvent.runflag = true;
					teradyneInstantia.StartPolling();
				} else {
					JOptionPane.showConfirmDialog(null, "TDR校验失败 ", "error", JOptionPane.CLOSED_OPTION,
							JOptionPane.WARNING_MESSAGE);
					teradyneInstantia.UnloadTestProgram();
					// MainWindow.setProgressTxt("TDR校验失败 ");
					// MainStatus.status1();
					entityVo.setStatus(0);
					entityVo.setMainStatus(1);
					channelHandlerContext.writeAndFlush(entityVo);
					return;
				}
				teradyneInstantia.StartPolling();
				File directory = new File("");// 参数为空
				String courseFile = null;
				try {
					courseFile = directory.getCanonicalPath();
					EntityVo.binPath = courseFile + File.separator + "EquipmentInfo\\size_bin.txt";
				} catch (Exception e) {
					e.printStackTrace();
				}
				entityVo.setType(1);
				entityVo.setStatus(0);
				entityVo.setBintxtPath("");
				entityVo.setMaxsite(TeradyneEvent.MaxSite);
				channelHandlerContext.writeAndFlush(entityVo);
				

			} else if ("OP".equals(entityVo.getCommand())) {

//					MesFileConfig mesFileConfig = GlobalContext.getMesFileConfig();
				OPCommandMethod opCommandMethod = new OPCommandMethod();
				String program_Folder = entityVo.getProgram_Folder();
				String test_Flow = entityVo.getTest_Flow();

				EnvConFigConfig envConFigConfig = entityVo.getEnvConFigConfig();
				String local_prog_path = envConFigConfig.getMainPath().getLocal_prog_path();

				String local_testflow_path = local_prog_path + program_Folder + File.separator;
				String protxtpath = local_testflow_path + "LoadFile" + File.separator + test_Flow;

				Map<String, String> programinfo = opCommandMethod.getPrograminfo(protxtpath);
				String DatalogSetupFile = programinfo.get("DatalogSetupFile");
				String txt = envConFigConfig.getMainPath().getLocal_dlog_path() + entityVo.getTempData()
						+ File.separator + entityVo.getDatalog_name_rules() + ".txt";
				String sum = envConFigConfig.getMainPath().getLocal_dlog_path() + entityVo.getTempData()
						+ File.separator + entityVo.getDatalog_name_rules() + ".sum";
				String std = envConFigConfig.getMainPath().getLocal_dlog_path() + entityVo.getTempData()
						+ File.separator + entityVo.getDatalog_name_rules() + ".std";
				TeradyneEvent.stdffilefolder = envConFigConfig.getMainPath().getLocal_dlog_path()
						+ entityVo.getTempData();
				TeradyneEvent.stdffilepath = std;
				EntityVo.stdUnkName = entityVo.getDatalog_name_rules() + ".std";
				String device_Name = entityVo.getjLabelMap().get("Device_Name").getText();
				String program_Name = entityVo.getOpprogeamName();
				String zipfile_Name = entityVo.getZipfile_Name();
				String customer_LotNo = entityVo.getjLabelMap().get("Customer_LotNo").getText();
				String sub_LotNo = entityVo.getjLabelMap().get("Sub_LotNo").getText();
				JLabel jLabel = entityVo.getjLabelMap().get("Operator_ID");
				String Operator_ID = jLabel.getText();
				JLabel jLabel2 = entityVo.getjLabelMap().get("Test_BinNo");
				String Test_BinNo = jLabel2.getText();
				JLabel jLabel3 = entityVo.getjLabelMap().get("Test_Code");

				String Test_Code = jLabel3.getText();
				//
				String mode_Code = entityVo.getjLabelMap().get("Mode_Code").getText();
				// bin
				String setup_id = "PRODUCTION";
				String customer_ID = "";
				String facil_id = "ForeHope";
				// flow_id
				// rest_cod
				String lot_Type = "";
				if ("M".equals(lot_Type) || "MP".equals(lot_Type)) {
					lot_Type = "P";
				} else if ("E".equals(lot_Type) || "Q".equals(lot_Type)) {
					lot_Type = "E";
				}
				String[] stdfmir = new String[16];
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
				stdfmir[15] = ""; // 
				teradyneInstantia.STDFMIR(stdfmir);
				teradyneInstantia.SetDataLogStdf(std, txt);
				teradyneInstantia.SetSummaryStdf(std, sum);
				String setupfilepath = local_testflow_path + File.separator + DatalogSetupFile;
				System.out.println(setupfilepath);
				teradyneInstantia.SetupFile(setupfilepath);
				teradyneInstantia.FileOutPut(true);
				teradyneInstantia.ApplySetup();
				boolean calibrateTDR = teradyneInstantia.CalibrateTDR();
				if (calibrateTDR) {
					TeradyneEvent.runflag = true;
					teradyneInstantia.StartPolling();
				} else {
					JOptionPane.showConfirmDialog(null, "TDR校验失败 ", "error", JOptionPane.CLOSED_OPTION,
							JOptionPane.WARNING_MESSAGE);
					teradyneInstantia.UnloadTestProgram();
//                        MainWindow.setProgressTxt("TDR校验失败 ");
//                        MainStatus.status1();
					return;
				}
				runstatus = false;
			}

			// SummaryView.getSummaryView();
			// MainWindow.progress(false);

		}

	}
}
