package com.fhec.groupId.nio;

import com.fhec.groupId.entity.EntityVo;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @Author:god
 * @Description:
 * @Date:Create in 2018/10/19 17:50
 */
public class ServerHandler extends ChannelHandlerAdapter {



    @Override
    public void channelActive(ChannelHandlerContext ctx){
        System.out.println(ctx.channel().localAddress().toString()+"通道活跃....");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().localAddress().toString()+"通道不活跃....");

    }

    /**
     *
     * 读取客户端传过来的消息
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //业务处理类
        EntityVo entityVo = (EntityVo)msg;
        System.out.println(entityVo.toString());
        if (entityVo.getStatus()==11){
            System.out.println("客户端连接成功");
        }
        System.out.println(entityVo.getStatus());
        if (entityVo.getStatus()==22){
            System.out.println("客户端连接");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //出现异常，关闭连
        System.out.println("服务端出现异常："+cause.getMessage()+"============"+cause);
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("服务端完成请求!");
        ctx.flush();
    }

}
