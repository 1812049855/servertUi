package com.fhec.groupId.nio;


/**
 * @Author:god
 * @Description:
 * @Date:Create in 2018/10/19 17:56
 */
public class ServerMain {

    private static Server server = new Server(8888);
    public static void main(String[] args) {
        System.out.println("服务端启动.......");
        server.start();
    }

}
