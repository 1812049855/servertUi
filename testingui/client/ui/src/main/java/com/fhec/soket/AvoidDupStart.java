package com.fhec.soket;

import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
 

public class AvoidDupStart {
	public  static ServerSocket  srvSocket =null;
 
	public static void checkSingleInstance() {   
		    try {   
				 
		    	srvSocket=new ServerSocket(2020);
				 
		    } catch (IOException ex) {   
		    	 JPanel panel = new JPanel();
		    	 JOptionPane.showMessageDialog(panel,"UI已启动","系统提示",JOptionPane.WARNING_MESSAGE);
		    	 System.exit(0);
//		         if(ex.getMessage().indexOf("Address already in use: JVM_Bind")>=0)   
		           
		    }   
		  } 
}