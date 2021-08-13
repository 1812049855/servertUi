package com.fhec.groupId.nio;

import com.fhec.groupId.entity.EntityVo;
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
        this.ctx=ctx;
        System.out.println(ctx.channel().localAddress().toString()+"客户点活跃...");
        //向服务端写字符串
        System.out.println("客户端连接服务端,开始发送数据.....");
        EntityVo entityVo = new EntityVo();
        entityVo.setStatus(11);
        System.out.println("发送数据为："+entityVo.getStatus());
        ctx.writeAndFlush(entityVo);
        System.out.println("发送完毕...");
    }
    public static void sendmsg(EntityVo msg){
        ctx.writeAndFlush(msg);
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        //读取客户端数据
        /*Message message = (Message) msg;
        System.out.println("from server---->>" + message.toString());*/
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("客户端异常："+cause.getMessage()+"=============="+cause);
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端完成请求....");
        ctx.flush();
    }
}
