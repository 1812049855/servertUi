package com.fhec.Thread;

import com.fhec.clientnetty.Client;

/**
 * @author Archer.W
 * @date 2021/05/27 09:46
 **/
public class NettyConnect implements Runnable{
    @Override
    public void run() {
        clientConnect();
    }
    public void clientConnect(){
        Client client = new Client("127.0.0.1", 8888);
        client.connect();
    }
}
