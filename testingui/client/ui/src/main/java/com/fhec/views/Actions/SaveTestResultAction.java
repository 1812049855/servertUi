package com.fhec.views.Actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import com.fhec.abstracts.AbstractActionListener;
import com.fhec.app.AppStart;
import com.fhec.clientnetty.ClientHandler;
import com.fhec.context.GlobalContext;
import com.fhec.context.LocalConfig;
import com.fhec.context.Temporary;
import com.fhec.entity.EntityVo;
import com.fhec.log.Log;
import com.fhec.views.InformationConfirmationView;
import com.fhec.views.MainWindow;

public class SaveTestResultAction extends AbstractActionListener<MainWindow> {

	public SaveTestResultAction(MainWindow window) {
		super(window);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Do you want to save test result？", "系统提示",
				JOptionPane.YES_NO_OPTION);
		if (showConfirmDialog == 0) {
			saveTestesult();
            /*Temporary.saveDate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
			EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
			ConfigFilePath.TEST_TEMPDATA = envConFigConfig.getMainPath().getLocal_dlog_path() + "TempData";
			// 状态
			MainStatus.status0();
			Log.info("save test result");
			MainWindow.setUilog("save test result");
			// 5.3.1 针对 tempdata 下的数据执行 close 动作
			LocalConfig.status = 0;
			Log.info("针对 tempdata 下的数据执行 close 动作");
			MainWindow.setUilog("针对 tempdata 下的数据执行 close 动作");

			//关闭通讯

			*//*TeradyneEquipment teradyneInstantia = TeradyneDriverInit.TeradyneInstantia();
			teradyneInstantia.EndLot();
			teradyneInstantia.FileOutPut(false);
			teradyneInstantia.ApplySetup();
			teradyneInstantia.StopPolling();
			teradyneInstantia.Disconnect();
*//*
			SaveResultFtpJudge saveResultFtpJudge = new SaveResultFtpJudge(this.window);
			// 判断测试数据是否存在
			FileUtils.CreateFolder(ConfigFilePath.TEST_TEMPDATA);
			String[] fileList = new File(ConfigFilePath.TEST_TEMPDATA).list();
			if (fileList.length == 0) {
				// 测试数据不存在
				JOptionPane.showConfirmDialog(null, "alarm U02:datalog is not exist，please call ME & PTE !", "提示",
						JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
				Log.error("测试数据不存在");
				MainWindow.setUilog("测试数据不存在");
				MainStatus.status2();
			} else {
				Log.info("测试数据存在");
				MainWindow.setUilog("测试数据存在");
				Log.info("网络存在");
				MainWindow.setUilog("网络存在");
				
				try {
					// 生成summary 以csv结尾
					CSVUtils csv = new CSVUtils();
					csv.CSVOutPut();
					// 记录config信息
					if ("MES".equals(GlobalContext.UImode)) {
						RecordConfig.recordConfig();
					}
					if ("OP".equals(GlobalContext.UImode)) {
						RecordConfig.recordOpConfig();
					}

					// 将 temp 路径下的数据剪切到 local_singlefile_folderpath 中
					saveResultFtpJudge.shearLocalSingFile();

					// 文件压缩
					saveResultFtpJudge.SingFileCompress();
					
					LastConfig lastConfig = GlobalContext.getLastConfig();
					Temporary.last_testflow = lastConfig.getLast_testflow();
					Temporary.last_zipfile = lastConfig.getLast_zipfile();

					// 测试数据上传
					Thread th=new Thread(new upLoadFtp(saveResultFtpJudge));
					th.start();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
					MainStatus.status2();
					Log.error(e1.getMessage());
					return;
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
					MainStatus.status2();
					Log.error(e1.getMessage());
					return;
				}

			}*/

		} else {
			this.window.setOk(false);
			Log.info("不进行任何操作，返回主页面成功");
			MainWindow.setUilog("SaveTestResult 不进行任何操作，返回主页面成功");
		}
	}

	private  void  saveTestesult(){
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
        entityVo.setjLabelKeyMap(InformationConfirmationView.jLabelKeyMap);
        entityVo.setjLabelMap(InformationConfirmationView.jLabelMap);
        //测试机路劲
        entityVo.setDatalog_name_rules(LocalConfig.datalog_name_rules);
        //指令
        entityVo.setCommand(GlobalContext.getCommandConfig().getSaveTestResult());
        //连接状态
        entityVo.setStatus(0);
        //选择模式
       // entityVo.setMode(GlobalContext.UImode);
        //每一行数据 barcode
        entityVo.setOpmodecode(Temporary.opmodecode);
        entityVo.setOprecipemodecode(Temporary.oprecipemodecode);
        entityVo.setProgram_Folder(Temporary.Program_Folder);
        entityVo.setTest_Flow(Temporary.test_Flow);
        entityVo.setTesterOS_Version(Temporary.testerOS_Version);
        entityVo.setZipfile_Name(Temporary.Zipfile_Name);
        entityVo.setOpprogeamName(Temporary.opprogeamName);
        //路径
        entityVo.setLocal_csvdir_folderpath(Temporary.local_csvdir_folderpath);
        entityVo.setLocal_singlefile_folderpath(Temporary.local_singlefile_folderpath);
        entityVo.setLocal_fulllotfile_folderpath(Temporary.local_fulllotfile_folderpath);

        //BatchInputInformationView 页面手动输入的 textTest_Code
        entityVo.setTextTest_Code(Temporary.textTest_Code);
        entityVo.setPaname(AppStart.pcname);
        entityVo.setServer_fulllotfile_folderpath(Temporary.server_fulllotfile_folderpath);
        entityVo.setServer_datalog_name_rule1(Temporary.server_datalog_name_rule1);
        entityVo.setServer_singlefile_folderpath(Temporary.server_singlefile_folderpath);
        entityVo.setServer_csvdir_folderpath(Temporary.server_csvdir_folderpath);
        ClientHandler.sendmsg(entityVo);
    }

}
