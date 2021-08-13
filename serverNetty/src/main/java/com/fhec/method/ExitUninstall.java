package com.fhec.method;

import java.io.File;

import javax.swing.JOptionPane;

import com.esotericsoftware.minlog.Log;
import com.fhec.context.EnvConFigConfig;
import com.fhec.driver.TeradyneDriverInit;
import com.fhec.driver.TeradyneEvent;
import com.fhec.entity.EntityVo;
import com.fhec.eqp.TeradyneEquipment;
import com.fhec.utils.FileUtils;

import io.netty.channel.ChannelHandlerContext;

public class ExitUninstall {
	private EntityVo entityVo;

	private ChannelHandlerContext channelHandlerContext;
	public ExitUninstall() {
	}

	public ExitUninstall(EntityVo entityVo,ChannelHandlerContext channelHandlerContext) {
		this.entityVo = entityVo;
		this.channelHandlerContext=channelHandlerContext;
	}

	public void exitUnistall() {
		EnvConFigConfig envConFigConfig = entityVo.getEnvConFigConfig();
		
		
		// 卸载程序
		 TeradyneEquipment teradyneEquipment = TeradyneDriverInit.TeradyneInstantia();
		TeradyneEvent.runflag = false;
		

		TeradyneEquipment teradyneInstantia = TeradyneDriverInit.TeradyneInstantia();
		boolean connectionStatus = teradyneInstantia.ConnectionStatus();
	    teradyneInstantia.UnloadTestProgram();
		if(connectionStatus) {
			 teradyneInstantia.StopPolling();
			 teradyneInstantia.Disconnect();
		}

		// 若 env_config 中的 exit_clear_pgm_flag = 1，则卸载测试程序，退出 UI，删除本地程序保存 UI log 并上传
		if (EnvConFigConfig.uninstall.equals(envConFigConfig.getUiControlFlag().getExit_clear_pgm_flag())) {

			// 删除本地文件夹
			File file = new File(envConFigConfig.getMainPath().getLocal_prog_path());
			FileUtils.removeDir(file);
			Log.info("删除" + file.getName() + "成功");

			// 保存uilog上传
			try {
				UiLogUploadServer uiLogUploadServer = new UiLogUploadServer(entityVo,channelHandlerContext);
				uiLogUploadServer.UiuploadServer();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
				// 1
				//MainStatus.status1();
			}

			// 若 env_config 中的 exit_clear_pgm_flag = 0，则卸载测试程序，退出 UI，保存 UI log并上传
		} else if (EnvConFigConfig.recover.equals(envConFigConfig.getUiControlFlag().getExit_clear_pgm_flag())) {
			// 保存uilog上传
			try {
				UiLogUploadServer uiLogUploadServer = new UiLogUploadServer(entityVo,channelHandlerContext);
				uiLogUploadServer.UiuploadServer();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
				// 1
			//	MainStatus.status1();
			}
		}
	}
	
}
