package com.fhec.clientnetty;

import com.fhec.entity.EntityVo;
import com.fhec.serialization.KryoDecoder;
import com.fhec.serialization.KryoEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.StandardCharsets;


/**
 * @Author:god
 * @Description:
 * @Date:Create in 2018/10/19 17:53
 */
public class Client {

	
    private String host;
    private int port;

    /**
     * 连接服务器端
     * @param host
     * @param port
     */
    public Client(String host, int port) {
        super();
        this.host = host;
        this.port = port;
    }

    public void connect(){
        EventLoopGroup workGroup=new NioEventLoopGroup();
        Bootstrap bootstrap=new Bootstrap();
        bootstrap.group(workGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                System.out.println("客户端触发连接......");
                ch.pipeline().addLast("decoder", new KryoDecoder());
                ch.pipeline().addLast("encoder", new KryoEncoder());
                ch.pipeline().addLast(new StringEncoder(StandardCharsets.UTF_8));
                ch.pipeline().addLast(new StringEncoder(StandardCharsets.UTF_8));
                ch.pipeline().addLast(new ClientHandler());
            }
        }).option(ChannelOption.TCP_NODELAY, true);
        //客户端开始连接
        try {
            System.out.println("连接到服务器......");
            ChannelFuture future=bootstrap.connect(host,port).sync();
            System.out.println("=========连接成功===========");
            //等待连接关闭
            EntityVo.status1=1;
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            workGroup.shutdownGracefully();
        }
    }
}
