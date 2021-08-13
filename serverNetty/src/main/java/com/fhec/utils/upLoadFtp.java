package com.fhec.utils;

import com.fhec.driver.TeradyneDriverInit;
import com.fhec.entity.EntityVo;
import com.fhec.log.Log;
import com.fhec.method.SaveResultFtpJudge;

import io.netty.channel.ChannelHandlerContext;

public class upLoadFtp implements Runnable {
    SaveResultFtpJudge saveResultFtpJudge;
    private ChannelHandlerContext channelHandlerContext;

    private EntityVo entityVo;
    public upLoadFtp(SaveResultFtpJudge saveResultFtpJudge,ChannelHandlerContext channelHandlerContext,EntityVo entityVo) {
        this.saveResultFtpJudge = saveResultFtpJudge;
        this.channelHandlerContext=channelHandlerContext;
        this.entityVo = entityVo;
    }

    @Override
    public void run() {
        startUpLoad();

    }

    public void startUpLoad() {
        // 测试数据上传
        boolean b;
        try {
            b = saveResultFtpJudge.ftpInit();
            if (b) {
                	//MainStatus.status3();
                TeradyneDriverInit.CleanAllList();
                entityVo.setType(3);
                entityVo.setStatus(0);
                entityVo.setMainStatus(3);
                entityVo.setCommand("end");
                TeradyneDriverInit.TeradyneInstantia();
                channelHandlerContext.writeAndFlush(entityVo);
                return;
            } else {
                Log.error("SaveTestResult 连接网络失败");
                //	MainWindow.setUilog("SaveTestResult 连接网络失败，返回之前的页面");
                entityVo.setType(2);
                entityVo.setStatus(0);
                entityVo.setMainUIlog("SaveTestResult 连接网络失败，返回之前的页面");
                channelHandlerContext.writeAndFlush(entityVo);
                //MainStatus.status2();
                entityVo.setType(3);
                entityVo.setStatus(0);
                entityVo.setMainStatus(2);
                channelHandlerContext.writeAndFlush(entityVo);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
