package com.fhec.utils;


import com.fhec.entity.EntityVo;
import com.fhec.method.ExitUninstall;

import io.netty.channel.ChannelHandlerContext;

public class ExitUpload implements Runnable{
	private EntityVo entiyVo;
	private ChannelHandlerContext channelHandlerContext;
	 public ExitUpload(EntityVo entiyVo,ChannelHandlerContext channelHandlerContext) {
	        this.entiyVo = entiyVo;
	        this.channelHandlerContext=channelHandlerContext;
	    }

	@Override
	public void run() {
		startUpload();
	}
	public void startUpload() {
	    ExitUninstall exitUninstall = new ExitUninstall(entiyVo,channelHandlerContext);
        exitUninstall.exitUnistall();
        entiyVo.setCommand("endStart");
        channelHandlerContext.writeAndFlush(entiyVo);
        System.out.println("=======");
	}
}
