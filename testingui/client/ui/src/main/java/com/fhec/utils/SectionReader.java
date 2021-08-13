package com.fhec.utils;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.commons.configuration2.INIConfiguration;
import org.apache.commons.configuration2.SubnodeConfiguration;
/**
 * 
 * @author Jacob
 * @date 2020-09-17
 *
 */
public class SectionReader {

	public   List<Map<String, SubnodeConfiguration>> mapList = new ArrayList<>();
	
	private   HashMap<String,SubnodeConfiguration>cof=new HashMap<String,SubnodeConfiguration>();

	public SectionReader(String path){
		init(path);
	}
	private void init(String path){
		JPanel panel = new JPanel();
		INIConfiguration instance= new INIConfiguration();

		try {
			instance.read(new FileReader(new File(path)));
			Set<String> sections=instance.getSections();
				for (String string : sections) {
						cof.put(string,instance.getSection(string));
						 
				}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(panel, "文件不存在", "系统提示", JOptionPane.WARNING_MESSAGE);

			System.out.println("文件不存在");
			e.printStackTrace();
		}
		
	}

	
	
	public Set<String> getAllSectionKey() {
		return  cof.keySet();
	}
	/**
	 * 获取key值
	 * @param section [section]
	 * @param name key值
	 * @return
	 */
	public  String getValue(String section, String name) {
		SubnodeConfiguration subnodeConfiguration = cof.get(section);
	    return subnodeConfiguration.getString(name);

	}
	/**
	 * 获取相同Key
	 * @param section [section]
	 * @param name  key值
	 * @return
	 */
	public  String[] getValues(String section, String name){
		SubnodeConfiguration subnodeConfiguration = cof.get(section);
		return subnodeConfiguration.getStringArray(name);
	}
}
