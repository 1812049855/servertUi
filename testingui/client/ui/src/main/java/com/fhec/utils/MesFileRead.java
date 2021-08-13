package com.fhec.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.commons.configuration2.INIConfiguration;
/**
 * mesfile 文件读取
 * @author Jacob
 * @date  2020-9-17
 */
public class MesFileRead {
	
	/**
	 * 获取单键值
	 * @param path 文件路径
	 * @param key 键
	 * @return
	 */
	public static String getMesfileVal(String path,String key){
		
		INIConfiguration instance = new INIConfiguration();
		FileReader fr=null;
		try {
			fr=new FileReader(new File(path));
			instance.read(fr);
			String val = instance.getString(key);
			return val;
		} catch (Exception e) {
			JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel, "文件不存在", "系统提示", JOptionPane.WARNING_MESSAGE);

			System.out.println("文件不存在");
			e.printStackTrace(); 
			
		}finally {
			if(fr!=null){
				try {
					fr.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return null;
	}
	/**
	 * mesfile map集合
	 * @param path 文件路径
	 * @return
	 */
	public static Map<String, String>getMesFile(String path){
		Map<String, String>map=new HashMap<String, String>();
		INIConfiguration instance = new INIConfiguration();
		FileReader fr=null;
		try {
			fr=new FileReader(new File(path));
			instance.read(fr);
			Iterator<String> keys = instance.getKeys();
			while(keys.hasNext()){ 
				String next = keys.next(); 
				String value = instance.getString(next);
				map.put(next, value);
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
			JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel, "文件不存在", "系统提示", JOptionPane.WARNING_MESSAGE);

			System.out.println("文件不存在");
			e.printStackTrace(); 
		}finally{
			if(fr!=null){
				try {
					fr.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		return map;
	}
}
