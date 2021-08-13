package com.fhec.context;

import com.fhec.config.ini.INISection;
import com.fhec.config.ini.INISectionNode;

public class SocketPort {
    public  final static  String GROUPNAME_SCOKET_PORT = "socket_port";

    @INISection(name = GROUPNAME_SCOKET_PORT,isRequired = false)
    private  Socketport  socketport;

    public Socketport getSocketport() {
        return socketport;
    }

    public void setSocketport(Socketport socketport) {
        this.socketport = socketport;
    }

    public static  class  Socketport{
        public final static  String NAME_SOCKET_PORT = "socket_port";
        public final static  String NAME_SOCKET_HOOST = "socket_host";
        public final static  String NAME_SOCKET_NAME= "socket_name";

        @INISectionNode(name = NAME_SOCKET_PORT,isRequired = false)
        private  int socketPort;
        @INISectionNode(name = NAME_SOCKET_HOOST,isRequired = false)
        private  String socketHost;
        @INISectionNode(name = NAME_SOCKET_NAME,isRequired = false)
        private  String socketName;

        public String getSocketName() {
            return socketName;
        }

        public void setSocketName(String socketName) {
            this.socketName = socketName;
        }

        public String getSocketHost() {
            return socketHost;
        }

        public void setSocketHost(String socketHost) {
            this.socketHost = socketHost;
        }

        public int getSocketPort() {
            return socketPort;
        }

        public void setSocketPort(int socketPort) {
            this.socketPort = socketPort;
        }
    }
}