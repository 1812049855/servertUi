package com.fhec.groupId.nio;


import com.fhec.groupId.entity.EntityVo;

import java.net.UnknownHostException;

/**
 * @Author:god
 * @Description:
 * @Date:Create in 2018/10/19 17:56
 */
public class ClientMain {

    public static void main(String[] args) throws UnknownHostException, Exception {
        Thread th =new Thread(new Runnable() {
            public void run() {
                Client client = new Client("127.0.0.1", 8888);
                client.connect();
            }
        });
        th.start();

    }
}
