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

public class FullEndLotAction extends AbstractActionListener<MainWindow> {

    public FullEndLotAction(MainWindow window) {
        super(window);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Do you want to lot end？", "系统提示",
                JOptionPane.YES_NO_OPTION);
        if (showConfirmDialog == 0) {

            fullEnd();

			/*TeradyneEquipment teradyneInstantia = TeradyneDriverInit.TeradyneInstantia();

			teradyneInstantia.StopPolling();
			teradyneInstantia.Disconnect();

			MainStatus.status0();
			TeradyneEvent.runflag = false;
			Log.info("lot end");
			MainWindow.setUilog("End Lot 开始执行");
			TeradyneDriverInit.CleanAllList();

			// 判断 config 是否存在
			File file = new File(Temporary.configTxt);
			// 不存在
			if (!file.exists()) {
				JOptionPane.showConfirmDialog(null, "alarm U05:config is not exist ，please call MFG leader !", "提示",
						JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
				MainStatus.status3();
			} else {
				Thread th=new Thread(new FullLotEndUpload());
				th.start();
			}*/
        } else {
            this.window.setOk(false);
            Log.info("不进行任何操作，返回主页面成功");
            MainWindow.setUilog("FullEndLot 不进行任何操作，返回主页面成功");
        }

    }

    //发送指令 生成html
    private void fullEnd() {
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
        entityVo.setCommand(GlobalContext.getCommandConfig().getFullEnd());
        //连接状态
        entityVo.setStatus(0);
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

        //发送
        ClientHandler.sendmsg(entityVo);
    }
}
