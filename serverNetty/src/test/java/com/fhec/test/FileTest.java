package com.fhec.test;

import com.fhec.log.Log;
import org.junit.Test;

import java.io.*;
import java.net.URL;

/**
 * @author Archer.W
 * @date 2021/06/10 13:34
 **/
public class FileTest {
    boolean b = true;

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            String one;
            String two;
            String three;
            String fore;
            while ((tempString = reader.readLine()) != null) {
                b = true;
                // 显示行号
                System.out.println("第" + line + "行:" + tempString);
                //读出来一行以,分割
                String[] split = tempString.split(",");
                one = split[0];
                two = split[1];
                three = split[2];
                fore = split[3];
                System.out.println(one);
                System.out.println(two);
                System.out.println(three);
                System.out.println(fore);
                System.out.println("=========================");
                line++;
            }

            reader.close();
            b = false;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    @Test
    public void testFile() throws Exception {
        File directory = new File("");//参数为空
        String courseFile = directory.getCanonicalPath() ;
        String binpath = courseFile + File.separator + "EquipmentInfo\\size_bin.txt";
        System.out.println(binpath);


        readFileByLines(binpath);


    }

    private void OutPutEquipmentInfo(String str) {
        FileWriter fw = null;
        try {
            String property = System.getProperty("line.separator");

            String path = "D:\\copy\\serverNetty\\EquipmentInfo\\size_bin.txt";
            File file = new File(path);
            fw = new FileWriter(file, true);

            fw.write(str + property);
            fw.flush();
        } catch (IOException e) {
            //异常待处理
            e.printStackTrace();
        } finally {
            if (null != fw) {
                try {
                    fw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
