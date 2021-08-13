package com.fhec.define;


/**
 * UI变量定义
 */
public class ConstDefine {

	/**
	 * 本地数据保存主路径
	 */
	public static String local_dlog_path;

	/**
	 * 本地程序主路径
	 */
	public static String local_prog_path;

	/**
	 * 出现保存异常时临时路径的数据转移位置
	 */
	public static String local_errordata_folderpath;

	/**
	 * 测试过程中，数据临时存储位置
	 */
	public static String local_tempdata_folderpath;

	/**
	 * 本地UI 操作记录路径
	 */
	public static String local_UImessage_path;

	/**
	 * 服务器数据保存主路径
	 */
	public static String server_dlog_path;

	/**
	 * 服务器 UI 信息路径
	 */
	public static String server_UImessage_path;

	/**
	 * 出现保存异常时临时路径的数据转移位置
	 */
	public static String server_errordata_folderpath;

	/**
	 * 本地 mesfile 文件全路径
	 */
	public static String local_mes_filepath;

	/**
	 * UI模式
	 */
	public static String UImode;

	// Mesfie 服务器地址
	public static String server_mes_path;


	// 服务器程序主路径
	public static String server_prog_path;
	
	public static String alarm_M07_flag;
	public static String alarm_M08_flag;
	public static String alarm_O02_flag;
	public static String alarm_M05_flag;
	public static String alarm_M06_flag;
	public static String alarm_M09_flag;

	/**
	 * mes固定值
	 */
	public static final String MES="MESFILE";
	
	/**
	 * recipe固定值
	 */
	public static final String RECIPE="Recipe";

	/**
	 * 计算次数初始值
	 */
	public  static  Integer  systemCount = 0;
}
