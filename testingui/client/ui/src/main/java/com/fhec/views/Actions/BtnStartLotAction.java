package com.fhec.views.Actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import com.fhec.abstracts.AbstractActionListener;
import com.fhec.context.EnvConFigConfig;
import com.fhec.context.GlobalContext;
import com.fhec.context.LocalConfig;
import com.fhec.entity.EntityVo;
import com.fhec.log.Log;
import com.fhec.mainstatus.MainStatus;
import com.fhec.clientnetty.ClientHandler;
import com.fhec.utils.FileUtils;
import com.fhec.views.MESDownloadView;
import com.fhec.views.MainWindow;
import com.fhec.views.OPDownloadView;
//import com.sun.xml.internal.bind.v2.model.runtime.RuntimeTypeRef;

public class BtnStartLotAction extends AbstractActionListener<MainWindow> {

	public BtnStartLotAction(MainWindow window) {
		super(window);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		MESDownloadView.setsub_LotNo();
		EnvConFigConfig envConFigConfig = GlobalContext.getEnvConFigConfig();
		int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Do you want to start lot？", "系统提示",
				JOptionPane.YES_NO_OPTION);
		if (showConfirmDialog == 0) {
			if (LocalConfig.stratDate == null) {
				LocalConfig.stratDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
			}
			Log.info("进入start lot 模式");
			MainWindow.setUilog("进入start lot 模式");
			// 状态
			MainStatus.status0();
			if (LocalConfig.systemCount == 0) {
				if (EnvConFigConfig.uninstall.equals(envConFigConfig.getUiControlFlag().getUi_clear_pgm_flag())) {
					File file = new File(envConFigConfig.getMainPath().getLocal_prog_path());
					FileUtils.removeDir(file);
					Log.info("清空" + file + "文件夹成功");
				}
				startOpAndMes();
			} else {
				startOpAndMes();
			}

		} else {
			// 不需要清空文件夹
			MainStatus.status1();
			this.window.setOk(false);
			// MainWindow.startComboBox();
			Log.info("ui没有进行任何操作");
			MainWindow.setUilog("ui没有进行任何操作");
			return;

		}
		// 禁用下拉框
		// this.window.DisableComboBox();
	}

	// 打开下载界面
	private void startOpAndMes() {
		if ("MES".equals(GlobalContext.UImode)) {
			Log.info("打开mes模式下载界面");
			MESDownloadView mesDownloadView = new MESDownloadView(this.window);
			mesDownloadView.setVisible(true);
		}
		if ("OP".equals(GlobalContext.UImode)) {
			Log.info("打开op模式下载界面");
			OPDownloadView.Show();
		}
	}
}
