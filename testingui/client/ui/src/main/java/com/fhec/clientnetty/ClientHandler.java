package com.fhec.clientnetty;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.fhec.driver.TeradyneEvent;
import com.fhec.entity.EntityVo;
import com.fhec.mainstatus.MainStatus;
import com.fhec.refreshsummary.ReFSummary;
import com.fhec.views.MainWindow;
import com.fhec.views.SummaryView;
import com.fhec.views.Actions.InformationAction;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @Author:god
 * @Description:
 * @Date:Create in 2018/10/19 17:55
 */
public class ClientHandler extends ChannelHandlerAdapter {
	static ChannelHandlerContext ctx;

	/**
	 * 向服务端发送消息
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		this.ctx = ctx;
		System.out.println(ctx.channel().localAddress().toString() + "客户点活跃...");
		// 向服务端写字符串
		System.out.println("客户端连接服务端,开始发送数据.....");
		EntityVo entityVo = new EntityVo();
		entityVo.setStatus(1);
		System.out.println("发送数据为：" + entityVo.getStatus());
		ctx.writeAndFlush(entityVo);
		System.out.println("发送完毕...");
	}

	public static void sendmsg(EntityVo msg) {
		ctx.writeAndFlush(msg);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		// 读取客户端数据
		EntityVo entityVo = (EntityVo) msg;
		if (entityVo.getStatus() == 1) {
			JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel, "连接成功，连接状态：" + entityVo.getStatus(), "系统提示",
					JOptionPane.WARNING_MESSAGE);
		}
		// save之后结束测试
		if ("endStart".equals(entityVo.getCommand())) {
			System.exit(0);
		}
		// 类型区分 路劲
		if (entityVo.getType() == 1) {
			EntityVo.binPath = entityVo.getBintxtPath();
			EntityVo.Maxsite = entityVo.getMaxsite();
			TeradyneEvent.MaxSite = EntityVo.Maxsite;
			SummaryView.getSummaryView();
			MainStatus.status2();
			MainWindow.setSavetest("测试中，如需停止测试保存数据请点击“Save Test Result”！");
			InformationAction.lastBatch();
			while (true) {
				TeradyneEvent.TsCompletes(EntityVo.binPath);
				if ("end".equals(EntityVo.endTest)) {
					new Thread(new ReFSummary()).start();
					List<JTextArea> jtext = MainWindow.getTextArea();
					for (int z = 0; z < TeradyneEvent.MaxSite; z++) {
						jtext.get(z).setOpaque(false);
						jtext.get(z).setText("");
					}
					break;
				}
			}

		}

		// 主界面uilog
		if (entityVo.getType() == 2) {
			MainWindow.setUilog(entityVo.getMainUIlog());
		}
		// 主界面按钮状态
		if (entityVo.getType() == 3) {
			int mainStatus = entityVo.getMainStatus();
			if (mainStatus == 0) {
				MainStatus.status0();
			}
			if (mainStatus == 1) {
				MainStatus.status1();
			}
			if (mainStatus == 2) {
				MainStatus.status2();
			}
			if (mainStatus == 3) {
				MainStatus.status3();
				EntityVo.endTest = entityVo.getCommand();
				
			}
		}
		// 主界面进度条
		if (entityVo.getType() == 4) {
			MainWindow.progress(true);
			MainWindow.redJProgressBar(entityVo.getSize(), entityVo.getRedfile());
			MainWindow.setProgressTxt("["+entityVo.getFileName()+"]文件上传成功");
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.out.println("客户端异常：" + cause.getMessage() + "==============" + cause);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		System.out.println("客户端完成请求....");
		ctx.flush();
	}

}
