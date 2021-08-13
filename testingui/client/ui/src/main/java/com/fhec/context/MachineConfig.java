package com.fhec.context;

import java.net.InetAddress;

public class MachineConfig {

    private static volatile MachineConfig machineConfig;

    private String hostName;

    public static MachineConfig GetOrCreate() throws Exception {
        if (machineConfig != null) {
            return machineConfig;
        }
        synchronized (MachineConfig.class) {
            if (machineConfig == null) {
                machineConfig = new MachineConfig();
            }
        }
        return machineConfig;
    }

    private MachineConfig() throws Exception {
        hostName = InetAddress.getLocalHost().getHostName();
    }

    public String getHostName() {
        return hostName;
    }

}
