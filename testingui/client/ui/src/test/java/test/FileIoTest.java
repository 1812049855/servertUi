package test;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.fhec.driver.TeradyneEvent;
import com.fhec.views.SummaryView;

public class FileIoTest {

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
	            while(true) {
	            	  while ((tempString = reader.readLine()) != null) {
	  	                // 显示行号
	            		  if(tempString.isEmpty()) continue;
	  	                System.out.println("第" + line + "行:" + tempString);
	  	                //读出来一行以,分割
	  	                System.out.println("=========================");
	  	                line++;
	  	            }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (Exception e1) {
	                }
	            }
	        }

	    }
	    @Test
	    public void testFile() throws Exception {
	        String binpath = "C:\\copy\\serverNetty\\EquipmentInfo\\size_bin.txt";
	        System.out.println(binpath);


	        readFileByLines(binpath);


	    }	  
	    
	    @Test
	    public void test2() throws FileNotFoundException {
	    	
	    	String binpath = "C:\\copy\\serverNetty\\EquipmentInfo\\size_bin.txt";
	    	realtimeShowLog(new File(binpath));
	        
	        
	    }
	    
	    
	    public void realtimeShowLog(File logFile) throws FileNotFoundException {
	    	long lastTimeFileSize = 0;
	    	//指定文件可读可写

	    	final RandomAccessFile randomAccessFile = new RandomAccessFile(logFile, "rw");

	    	//启动一个线程每10秒钟读取新增的日志信息

	    	ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);

	    	exec.scheduleWithFixedDelay(new Runnable() {
	    	@Override

	    	public void run() {
	    	try {
	    	//获得变化部分的

	    	randomAccessFile.seek(lastTimeFileSize);

	    	String tmp = "";

	    	while ( (tmp = randomAccessFile.readLine()) != null) {
	    	// 输出文件内容

	    	System.out.println(new String(tmp.getBytes("utf-8")));

	    

	    	}

	    	} catch (Exception e) {
	    	e.printStackTrace();

	    	}

	    	}

	    	}, 0, 10, TimeUnit.SECONDS);

	    	}
	    
	    public static void main(String[] args) {
	    	TeradyneEvent.MaxSite = 4;
	    	EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					try {
						 SummaryView.getSummaryView();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	    	String binpath = "C:\\server\\serverNetty\\EquipmentInfo\\size_bin.txt";
	    	 TeradyneEvent.TsCompletes(binpath);
		}
	    
	    	}


