package com.fhec.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {
	
	/**
	 * 创建单文件夹
	 * @param path
	 */
   public  static void CreateFolder (String path){
	   File file =new File(path);
	   if(!file.exists()) file.mkdir();
   }
   /**
    * 创建多文件夹
    */
   public static void CreateFolders(String ... paths){
	   for (String path : paths) {
		   File file =new File(path);
		   if(!file.exists()) 
			  file.mkdirs();
	   }
   }
   
   /**
    * 清除文件夹内的所有内容,保留文件夹
    * @param file
    */
   public static void removeDire(File file) {
	   
	   if (file == null) {
		   return;
	   }
	   File[] listFiles = file.listFiles();
	   if (listFiles == null) {
		   return;
	   } 
	   for (File file2 : listFiles) {
		 
		   if (file2.isDirectory()) {
			   removeDir(file2);
			   continue;
		   }
		   file2.delete();
	   }
   }
   
   /**
    * 清除文件夹内的所有内容,不保留文件夹
    * @param file
    */
   public static void removeDir(File file) {
	   
	   if (file == null) {
		   return;
	   }
	   File[] listFiles = file.listFiles();
	   if (listFiles == null) {
		   return;
	   } 
	   for (File file2 : listFiles) {
		 
		   if (file2.isDirectory()) {
			   removeDir(file2);
		   }
		   file2.delete();
	   }
   }
   
   /**
    * 复制文件
    * @param srcPath 源文件
    * @param destDir 目标文件
    * @return
    */
 
   public static boolean copyFile(String srcPath, String destDir) {
		boolean flag = false;

		File srcFile = new File(srcPath);
		if (!srcFile.exists()) { // 源文件不存在
			System.out.println("源文件不存在");
			return false;
		}
		// 获取待复制文件的文件名
		File file = new File(srcPath);
		String fileName = file.getName();
		
		String destPath = destDir + fileName;
		if (destPath.equals(srcPath)) { // 源文件路径和目标文件路径重复
			System.out.println("源文件路径和目标文件路径重复!");
			return false;
		}
		File destFile = new File(destPath);
		if (destFile.exists() && destFile.isFile()) { // 该路径下已经有一个同名文件
			System.out.println("目标目录下已有同名文件!");
			return false;
		}

		File destFileDir = new File(destDir);
		destFileDir.mkdirs();
		try {
			FileInputStream fis = new FileInputStream(srcPath);
			FileOutputStream fos = new FileOutputStream(destFile);
			byte[] buf = new byte[1024];
			int c;
			while ((c = fis.read(buf)) != -1) {
				fos.write(buf, 0, c);
			}
			fis.close();
			fos.close();

			flag = true;
		} catch (IOException e) {
			//
		}

		if (flag) {
			System.out.println("复制文件成功!");
		}

		return flag;
	}

	public static boolean delete(File file){
		if(null!=file) return file.delete(); return false;
	}
}
