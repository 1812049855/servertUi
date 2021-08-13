package com.fhec.clientnetty;



import com.fhec.entity.EntityVo;

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
        Thread.sleep(6000);
        EntityVo entityVo = new EntityVo();
        entityVo.setStatus(22222);
        ClientHandler.sendmsg(entityVo);
      /*
      Thread.sleep(6000);
        Message msg = new Message();
        msg.setId("2");
        msg.setContent("435345");
        ClientHandler.sendmsg(msg);
        Message msg2 = new Message();
        msg2.setId("3");
        msg2.setContent("33333");
        ClientHandler.sendmsg(msg2);*/

    }
}
