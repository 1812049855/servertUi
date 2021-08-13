package com.fhec.machinetype;

import com.fhec.typepath.TypePath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 服务启动读取驱动机台类型
 *
 * @author Archer.W
 * @date 2021/04/24 21:12
 **/
public class MachineTypeUtils {
    public static String readProperties(){
        try {
            Properties properties = new Properties();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(TypePath.machineTypePath));
            properties.load(bufferedReader);
            return properties.getProperty("MachineType");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
