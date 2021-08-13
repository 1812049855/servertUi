package com.fhec.entity;


import java.util.Map;

import javax.swing.JLabel;

import com.fhec.context.CommandConfig;
import com.fhec.context.EnvConFigConfig;
import com.fhec.context.FtpmodeConfig;
import com.fhec.context.LastConfig;
import com.fhec.context.MesFileConfig;
import com.fhec.context.RecipeConfig;

/**
 * 传输配置文件赋值过的类
 *
 * @author Archer.W
 * @date 2021/04/16 09:34
 **/
public class EntityVo {
	//MAXSite
	public Integer maxsite;
	
	

	public Integer getMaxsite() {
		return maxsite;
	}

	public void setMaxsite(Integer maxsite) {
		this.maxsite = maxsite;
	}

	//binpath
    public static  String binPath;
    private   String bintxtPath;

    public String getBintxtPath() {
        return bintxtPath;
    }

    public void setBintxtPath(String bintxtPath) {
        this.bintxtPath = bintxtPath;
    }

    //类型
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    //commandconfig
    private CommandConfig commandConfig;
    //envcomfig
    private EnvConFigConfig envConFigConfig;
    //ftpmodecofig
    private FtpmodeConfig ftpmodeConfig ;
    //lastconfig
    private LastConfig lastConfig ;
    //mesfileconfig
    private MesFileConfig mesFileConfig ;
    //recipeconfig
    private RecipeConfig recipeConfig ;

    //二次批次界面的值
    //value
    private Map<String, JLabel> jLabelMap;
    //key
    private Map<String, JLabel> jLabelKeyMap;
    private String Customer_LotNo;
    private String Mode_Code;
    private String Tester_ID;
    private String Device_Name;
    private String Customer_ID;
    private String Sub_LotNo;
    private String Program_Name;
    private String Test_BinNo;
    private String Operator_ID;
    private String Test_Code;

    /**
     * 测试过程中，测试机数据临时存储文件夹
     */
    private String TempData;

    //测试机路劲
    private String datalog_name_rules;
    //指令
    private String command;
    //连接状态
    private int status;
    //主界面状态
    //选择模式
    private  String mode;
    public  static   String modecode;


    /**
     * barcode一行数据
     */

    private String opmodecode;
    private String oprecipemodecode;
    private String Program_Folder;
    private String test_Flow;
    private String testerOS_Version;
    private String Zipfile_Name;
    private String opprogeamName;

    /**
     * local_csvdir_folderpath local_singlefile_folderpath
     * local_fulllotfile_folderpath
     */
    private String local_csvdir_folderpath;
    private String local_singlefile_folderpath;
    private String local_fulllotfile_folderpath;


    /**
     * BatchInputInformationView 页面手动输入的 textTest_Code
     */
    private   String textTest_Code;



    /**
     * congig路劲
     */
    public static String configTxt;
    /**
     * 压缩后的文件名字
     */
  public  static    String stdUnkName;
    public  static    String last_testflow;

    public  static   String last_zipfile;


    public static  int  saveStatus;



    /**
     * 主界面得进度条  uilog   按钮状态
     * @return
     */
    private String mainUIlog;
    //总长度
    private  long size ;
  
	private long redfile;
    //上传文件的名字
    private String fileName;
    public String getFileName() {
  		return fileName;
  	}

  	public void setFileName(String fileName) {
  		this.fileName = fileName;
  	}


    /**
     *服务器文件夹名字
     */
    public static  String singleFile = "SingleFile";
    public static  String csvdir = "csvdir";

    public static  String fulllotfile = "FullLotFile";
    /**
     * 测试异常数据转移文件夹
     */
    public static String ErrorData = "errordata";
    /**
     * 测试过程中，测试机数据临时存储文件夹
     */
    public static String TempDataTest = "tempdata";

    /**
     * UI 操作记录路径
     */
     public static String UI_message = "UI_message";
     public static String saveDate;
     //开始时间
     public static String startDate;

    /**
     *
     */
    //按钮状态
    private  int mainStatus;


    //主机名
    private String paname;

    //服务器上传的文件路劲
    private String server_fulllotfile_folderpath;
    private String  server_datalog_name_rule1;
    private String server_singlefile_folderpath;
    private String server_csvdir_folderpath;


    //path路径
   public static String TEST_TEMPDATA;




    public String getServer_csvdir_folderpath() {
        return server_csvdir_folderpath;
    }

    public void setServer_csvdir_folderpath(String server_csvdir_folderpath) {
        this.server_csvdir_folderpath = server_csvdir_folderpath;
    }

    public String getServer_singlefile_folderpath() {
        return server_singlefile_folderpath;
    }

    public void setServer_singlefile_folderpath(String server_singlefile_folderpath) {
        this.server_singlefile_folderpath = server_singlefile_folderpath;
    }

    public String getServer_datalog_name_rule1() {
        return server_datalog_name_rule1;
    }

    public void setServer_datalog_name_rule1(String server_datalog_name_rule1) {
        this.server_datalog_name_rule1 = server_datalog_name_rule1;
    }

    public String getServer_fulllotfile_folderpath() {
        return server_fulllotfile_folderpath;
    }

    public void setServer_fulllotfile_folderpath(String server_fulllotfile_folderpath) {
        this.server_fulllotfile_folderpath = server_fulllotfile_folderpath;
    }



    public String getPaname() {
        return paname;
    }

    public void setPaname(String paname) {
        this.paname = paname;
    }

    public String getMainUIlog() {
        return mainUIlog;
    }

    public void setMainUIlog(String mainUIlog) {
        this.mainUIlog = mainUIlog;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getRedfile() {
        return redfile;
    }

    public void setRedfile(long redfile) {
        this.redfile = redfile;
    }

    public int getMainStatus() {
        return mainStatus;
    }

    public void setMainStatus(int mainStatus) {
        this.mainStatus = mainStatus;
    }

    public String getTextTest_Code() {
        return textTest_Code;
    }

    public void setTextTest_Code(String textTest_Code) {
        this.textTest_Code = textTest_Code;
    }

    public String getOpmodecode() {
        return opmodecode;
    }

    public void setOpmodecode(String opmodecode) {
        this.opmodecode = opmodecode;
    }

    public String getOprecipemodecode() {
        return oprecipemodecode;
    }

    public void setOprecipemodecode(String oprecipemodecode) {
        this.oprecipemodecode = oprecipemodecode;
    }

    public String getProgram_Folder() {
        return Program_Folder;
    }

    public void setProgram_Folder(String program_Folder) {
        Program_Folder = program_Folder;
    }

    public String getTest_Flow() {
        return test_Flow;
    }

    public void setTest_Flow(String test_Flow) {
        this.test_Flow = test_Flow;
    }

    public String getTesterOS_Version() {
        return testerOS_Version;
    }

    public void setTesterOS_Version(String testerOS_Version) {
        this.testerOS_Version = testerOS_Version;
    }

    public String getZipfile_Name() {
        return Zipfile_Name;
    }

    public void setZipfile_Name(String zipfile_Name) {
        Zipfile_Name = zipfile_Name;
    }

    public String getOpprogeamName() {
        return opprogeamName;
    }

    public void setOpprogeamName(String opprogeamName) {
        this.opprogeamName = opprogeamName;
    }

    public String getLocal_csvdir_folderpath() {
        return local_csvdir_folderpath;
    }

    public void setLocal_csvdir_folderpath(String local_csvdir_folderpath) {
        this.local_csvdir_folderpath = local_csvdir_folderpath;
    }

    public String getLocal_singlefile_folderpath() {
        return local_singlefile_folderpath;
    }

    public void setLocal_singlefile_folderpath(String local_singlefile_folderpath) {
        this.local_singlefile_folderpath = local_singlefile_folderpath;
    }

    public String getLocal_fulllotfile_folderpath() {
        return local_fulllotfile_folderpath;
    }

    public void setLocal_fulllotfile_folderpath(String local_fulllotfile_folderpath) {
        this.local_fulllotfile_folderpath = local_fulllotfile_folderpath;
    }

    public Map<String, JLabel> getjLabelMap() {
        return jLabelMap;
    }

    public void setjLabelMap(Map<String, JLabel> jLabelMap) {
        this.jLabelMap = jLabelMap;
    }

    public Map<String, JLabel> getjLabelKeyMap() {
        return jLabelKeyMap;
    }

    public void setjLabelKeyMap(Map<String, JLabel> jLabelKeyMap) {
        this.jLabelKeyMap = jLabelKeyMap;
    }



    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public EntityVo() {
    }

    public EntityVo(CommandConfig commandConfig, EnvConFigConfig envConFigConfig, FtpmodeConfig ftpmodeConfig, LastConfig lastConfig, MesFileConfig mesFileConfig, RecipeConfig recipeConfig, String customer_LotNo, String mode_Code, String tester_ID, String device_Name, String customer_ID, String sub_LotNo, String program_Name, String test_BinNo, String operator_ID, String test_Code, String tempData, String datalog_name_rules, String command, int status) {
        this.commandConfig = commandConfig;
        this.envConFigConfig = envConFigConfig;
        this.ftpmodeConfig = ftpmodeConfig;
        this.lastConfig = lastConfig;
        this.mesFileConfig = mesFileConfig;
        this.recipeConfig = recipeConfig;
        Customer_LotNo = customer_LotNo;
        Mode_Code = mode_Code;
        Tester_ID = tester_ID;
        Device_Name = device_Name;
        Customer_ID = customer_ID;
        Sub_LotNo = sub_LotNo;
        Program_Name = program_Name;
        Test_BinNo = test_BinNo;
        Operator_ID = operator_ID;
        Test_Code = test_Code;
        TempData = tempData;
        this.datalog_name_rules = datalog_name_rules;
        this.command = command;
        this.status = status;
    }

    @Override
    public String toString() {
        return "EntityVo{" +
                "commandConfig=" + commandConfig +
                ", envConFigConfig=" + envConFigConfig +
                ", ftpmodeConfig=" + ftpmodeConfig +
                ", lastConfig=" + lastConfig +
                ", mesFileConfig=" + mesFileConfig +
                ", recipeConfig=" + recipeConfig +
                ", Customer_LotNo='" + Customer_LotNo + '\'' +
                ", Mode_Code='" + Mode_Code + '\'' +
                ", Tester_ID='" + Tester_ID + '\'' +
                ", Device_Name='" + Device_Name + '\'' +
                ", Customer_ID='" + Customer_ID + '\'' +
                ", Sub_LotNo='" + Sub_LotNo + '\'' +
                ", Program_Name='" + Program_Name + '\'' +
                ", Test_BinNo='" + Test_BinNo + '\'' +
                ", Operator_ID='" + Operator_ID + '\'' +
                ", Test_Code='" + Test_Code + '\'' +
                ", TempData='" + TempData + '\'' +
                ", datalog_name_rules='" + datalog_name_rules + '\'' +
                ", command='" + command + '\'' +
                ", status=" + status +
                '}';
    }

    public CommandConfig getCommandConfig() {
        return commandConfig;
    }

    public void setCommandConfig(CommandConfig commandConfig) {
        this.commandConfig = commandConfig;
    }

    public EnvConFigConfig getEnvConFigConfig() {
        return envConFigConfig;
    }

    public void setEnvConFigConfig(EnvConFigConfig envConFigConfig) {
        this.envConFigConfig = envConFigConfig;
    }

    public FtpmodeConfig getFtpmodeConfig() {
        return ftpmodeConfig;
    }

    public void setFtpmodeConfig(FtpmodeConfig ftpmodeConfig) {
        this.ftpmodeConfig = ftpmodeConfig;
    }

    public LastConfig getLastConfig() {
        return lastConfig;
    }

    public void setLastConfig(LastConfig lastConfig) {
        this.lastConfig = lastConfig;
    }

    public MesFileConfig getMesFileConfig() {
        return mesFileConfig;
    }

    public void setMesFileConfig(MesFileConfig mesFileConfig) {
        this.mesFileConfig = mesFileConfig;
    }

    public RecipeConfig getRecipeConfig() {
        return recipeConfig;
    }

    public void setRecipeConfig(RecipeConfig recipeConfig) {
        this.recipeConfig = recipeConfig;
    }

    public String getCustomer_LotNo() {
        return Customer_LotNo;
    }

    public void setCustomer_LotNo(String customer_LotNo) {
        Customer_LotNo = customer_LotNo;
    }

    public String getMode_Code() {
        return Mode_Code;
    }

    public void setMode_Code(String mode_Code) {
        Mode_Code = mode_Code;
    }

    public String getTester_ID() {
        return Tester_ID;
    }

    public void setTester_ID(String tester_ID) {
        Tester_ID = tester_ID;
    }

    public String getDevice_Name() {
        return Device_Name;
    }

    public void setDevice_Name(String device_Name) {
        Device_Name = device_Name;
    }

    public String getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(String customer_ID) {
        Customer_ID = customer_ID;
    }

    public String getSub_LotNo() {
        return Sub_LotNo;
    }

    public void setSub_LotNo(String sub_LotNo) {
        Sub_LotNo = sub_LotNo;
    }

    public String getProgram_Name() {
        return Program_Name;
    }

    public void setProgram_Name(String program_Name) {
        Program_Name = program_Name;
    }

    public String getTest_BinNo() {
        return Test_BinNo;
    }

    public void setTest_BinNo(String test_BinNo) {
        Test_BinNo = test_BinNo;
    }

    public String getOperator_ID() {
        return Operator_ID;
    }

    public void setOperator_ID(String operator_ID) {
        Operator_ID = operator_ID;
    }

    public String getTest_Code() {
        return Test_Code;
    }

    public void setTest_Code(String test_Code) {
        Test_Code = test_Code;
    }

    public String getTempData() {
        return TempData;
    }

    public void setTempData(String tempData) {
        TempData = tempData;
    }

    public String getDatalog_name_rules() {
        return datalog_name_rules;
    }

    public void setDatalog_name_rules(String datalog_name_rules) {
        this.datalog_name_rules = datalog_name_rules;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
