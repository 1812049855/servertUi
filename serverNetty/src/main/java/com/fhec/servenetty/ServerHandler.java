package com.fhec.servenetty;

import com.fhec.context.EnvConFigConfig;
import com.fhec.context.FtpmodeConfig;
import com.fhec.driver.TeradyneDriverInit;
import com.fhec.entity.EntityVo;
import com.fhec.eqp.TeradyneEquipment;
import com.fhec.ftp.FtpClient;
import com.fhec.ftp.FtpClient.IAction;
import com.fhec.machinetype.MachineTypeUtils;
import com.fhec.method.MESCommandMethod;
import com.fhec.method.OPCommandMethod;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @Author:god
 * @Description:
 * @Date:Create in 2018/10/19 17:50
 */
public class ServerHandler extends ChannelHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		System.out.println(ctx.channel().localAddress().toString() + "通道活跃....");
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println(ctx.channel().localAddress().toString() + "通道不活跃....");

	}

	/**
	 *
	 * 读取客户端传过来的消息
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String command = MachineTypeUtils.readProperties();
		System.out.println(command + "======================类型");
		// 业务处理类
		if ("J750".equals(command)) {
			// 业务处理类
			EntityVo entityVo = (EntityVo) msg;
			System.out.println(entityVo.toString());
			if (entityVo.getStatus() == 1) {
				entityVo.setStatus(1);
				ctx.writeAndFlush(entityVo);

			}
			if ("MES".equals(entityVo.getMode())) {
				EntityVo.modecode = "MES";
				EnvConFigConfig envConFigConfig = entityVo.getEnvConFigConfig();
				FtpmodeConfig ftpmodeConfig = entityVo.getFtpmodeConfig();
				System.out.println("客户端连接成功");
				FtpClient ftpClient = FtpClient.uploadCreate(envConFigConfig.getServerDataIP().getServer_data_IP(),
						envConFigConfig.getServerDataIP().getServer_data_user(),
						envConFigConfig.getServerDataIP().getServer_data_password(), 21,
						Integer.valueOf(ftpmodeConfig.getServerpgmftpmode().getServer_pgm_ftpmode()));
				FtpClient ftp = FtpClient.create(envConFigConfig.getServerProgramIP().getServer_pgm_IP(),
						envConFigConfig.getServerProgramIP().getServer_pgm_user(),
						envConFigConfig.getServerProgramIP().getServer_pgm_password(), 21,
						Integer.valueOf(ftpmodeConfig.getServerpgmftpmode().getServer_pgm_ftpmode()));
				ftpClient.doAction(new IAction() {

					@Override
					public void doAction(FtpClient ftpClient) {

						System.out.println("网络初始化成功");
					}
				});
				ftp.doAction(new IAction() {

					@Override
					public void doAction(FtpClient ftpClient) {

						System.out.println("网络初始化成功");
					}
				});
			}
			if ("MES".equals(EntityVo.modecode)) {
				System.out.println("选择为mes");
				MESCommandMethod mesCommandMethod = new MESCommandMethod(entityVo, ctx);
				if ("startLot".equals(entityVo.getCommand())) {
					mesCommandMethod.startLotloadProgram();

				}
				if ("saveTestResult".equals(entityVo.getCommand())) {
					mesCommandMethod.saveTestResultCommand();
				}

				if ("fullEnd".equals(entityVo.getCommand())) {
					mesCommandMethod.fullEndCommand();
				}

				if ("exit".equals(entityVo.getCommand())) {
					mesCommandMethod.exitCommand();
				}

			} else if ("op".equals(EntityVo.modecode)) {
				System.out.println("选择为OP");
				OPCommandMethod opCommandMethod = new OPCommandMethod(entityVo, ctx);
				if ("startLot".equals(entityVo.getCommand())) {
					opCommandMethod.loadOPProgram();
				}
				if ("saveTestResult".equals(entityVo.getCommand())) {
					opCommandMethod.saveTestResultCommand();
				}
				if ("fullEnd".equals(entityVo.getCommand())) {
					opCommandMethod.fullEndCommand();
				}
				if ("exit".equals(entityVo.getCommand())) {
					opCommandMethod.exitCommand();
				}

			}
		}

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// 出现异常，关闭连
		System.out.println("服务端出现异常：" + cause.getMessage() + "============" + cause);
		 TeradyneEquipment teradyneInstantia = TeradyneDriverInit.TeradyneInstantia();
		 teradyneInstantia.UnloadTestProgram();
		ctx.close();
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		System.out.println("服务端完成请求!");
		ctx.flush();
	}

}
