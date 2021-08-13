package com.fhec.utils;

import javax.swing.JOptionPane;

import com.esotericsoftware.minlog.Log;
import com.fhec.entity.EntityVo;
import com.fhec.method.FullEndLotFtpJudge;

import io.netty.channel.ChannelHandlerContext;

public class FullLotEndUpload implements Runnable {

	private EntityVo entiyVo;
	private ChannelHandlerContext channelHandlerContext;

	 public FullLotEndUpload(EntityVo entiyVo, ChannelHandlerContext channelHandlerContext) {
	        this.entiyVo = entiyVo;
	        this.channelHandlerContext = channelHandlerContext;
	    }
	 public FullLotEndUpload() {
	     
	    }
	@Override
	public void run() {
		startUpload();
	}

	public void startUpload() {
		// 存在
		FullEndLotFtpJudge fullEndLotFtpJudge = new FullEndLotFtpJudge(entiyVo,channelHandlerContext);

		try {
			boolean b = fullEndLotFtpJudge.ftpInit();
			if (b) {
				Log.info("lot end执行完毕");
				// MainWindow.setUilog("lot end执行完毕");
				entiyVo.setType(2);
				entiyVo.setStatus(0);
				entiyVo.setMainUIlog("lot end执行完毕");
				channelHandlerContext.writeAndFlush(entiyVo);
				// 1
				// MainStatus.status1();
				entiyVo.setType(3);
				entiyVo.setStatus(0);
				entiyVo.setMainStatus(1);
				channelHandlerContext.writeAndFlush(entiyVo);
			} else {
				Log.error("lot end连接服务器失败");
				// MainWindow.setUilog("返回lot end之前的状态");
				// MainStatus.status3();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "系统提示", JOptionPane.WARNING_MESSAGE);
			// MainStatus.status3();
		}
	}

}
