package com.fhec.driver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.fhec.eqp.TeradyneEquipment;
import com.jacob.com.Variant;

public class TeradyneEvent {
	public static Integer MaxSite = 0;
	public static boolean runflag = false;
	public static String stdffilepath = null;
	public static String stdffilefolder = null;
    public static String csvfile;
	public static String prostattime = null;
	public static String proendtime = null;
	public static Integer goodqty=0;
	public static Integer failqty=0;
	long endtime=0;
	long strtime=0;
	long lasttime=0;
	
	public void OutPutEquipmentInfo(String str) {
		FileWriter fw=null;
		try {
			String property = System.getProperty("line.separator");
			String path="EquipmentInfo/size_bin.txt";
			File file=new File(path);
			fw=new FileWriter(file,true);
		 
			fw.write(str+property);
			fw.flush();
		} catch (IOException e) {
			//异常待处理 
			e.printStackTrace();
		}finally {
			if(null!=fw) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
 
	}
	public void TsCompletesTime(Variant[] args) {
		 endtime=System.currentTimeMillis();
		 long testtime=endtime-strtime;
		 String timetxt="Tets Time(ms):";
		// MainWindow.lblNewLabel.setText(timetxt+String.valueOf(testtime));
	}
	public void StartOfTestTime(Variant[] args) {
		strtime=System.currentTimeMillis();
		lasttime=endtime;
		String timetxt="Index Time(ms):";
		//if(endtime==0)
			//MainWindow.lblIndexTimems.setText(timetxt+String.valueOf(0));
		// else {
			long indextime=strtime-lasttime;
		//	MainWindow.lblIndexTimems.setText(timetxt+String.valueOf(indextime));
		//}
		
	}
	@SuppressWarnings("deprecation")
	public void TsCompletes(Variant[] args) {
		TeradyneEquipment teradyneInstantia = TeradyneDriverInit.TeradyneInstantia();
		// DriverTEst
		boolean isStop = teradyneInstantia.getIsStop();
		if (!isStop) {
			String bin = args[0].toString();
			int sort = args[1].toInt();
			int result = args[2].toInt();
			int site =args[3].toInt();
			for (int i = 0; i < MaxSite; i++) {
				if (i==site) {
					if(result != -1) {
						 String info=bin+","+sort+","+result+","+site;
						    OutPutEquipmentInfo(info);
					}
				}
			}

		}
	}

}
