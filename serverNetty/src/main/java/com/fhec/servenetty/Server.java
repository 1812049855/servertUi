package com.fhec.servenetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import com.fhec.serialization.KryoDecoder;
import com.fhec.serialization.KryoEncoder;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;


/**
 * @Author:god
 * @Description:
 * @Date:Create in 2018/10/19 17:47
 */
public class Server {

    private int port;

    /**
     * 构造器初始化监听端口
     * @param port
     */
    public Server(int port) {
        super();
        this.port = port;
    }

    public  void start(){
        //引导辅助程序
        ServerBootstrap b = new ServerBootstrap();
        //通过nio方式来接收连接和处理请求
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            b.group(group);
            //设置nio类型的channnel
            b.channel(NioServerSocketChannel.class);
            //设置监听端口
            b.localAddress(new InetSocketAddress(port));
            //有连接到达时会创建一个channel
            b.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    //注册handler
                    ch.pipeline().addLast("decoder", new KryoDecoder());
                    ch.pipeline().addLast("encoder", new KryoEncoder());
                    ch.pipeline().addLast(new StringEncoder(Charset.forName("UTF-8")));
                    ch.pipeline().addLast(new StringEncoder(Charset.forName("UTF-8")));
                    ch.pipeline().addLast(new ServerHandler());
                }
            }).childOption(ChannelOption.TCP_NODELAY, true);
            //配置完成,开始绑定server,通过调用sync同步方法阻塞直到绑定成功
            ChannelFuture f = b.bind().sync();
            System.out.println(Server.class.getName()+"开始监听："+f.channel().localAddress());
            //应用程序会一直等待直到channel关闭
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭EventLoopGroup,释放掉所有资源包括创建的线程
                group.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
