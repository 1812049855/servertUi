package com.fhec.utils;

import org.apache.commons.configuration2.INIConfiguration;
import org.apache.commons.configuration2.SubnodeConfiguration;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * 
 * @author Jacob
 * @date 2020-09-17
 *
 */
public class BatchReader {

	public   List<Map<String, SubnodeConfiguration>> mapList = new ArrayList<>();

	private   HashMap<String,SubnodeConfiguration>cof=new HashMap<String,SubnodeConfiguration>();

	public BatchReader(String path){
		init(path);
	}
	private List init(String path){
		INIConfiguration instance= new INIConfiguration();

		try {
			instance.read(new FileReader(new File(path)));
			Set<String> sections=instance.getSections();
				for (String string : sections) {
					if (string.contains("INPUT_OI_")) {
						cof.put(string, instance.getSection(string));
						mapList.add(cof);
					}
				}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "系统提示", JOptionPane.WARNING_MESSAGE);
		}
		return mapList;
		
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
}
