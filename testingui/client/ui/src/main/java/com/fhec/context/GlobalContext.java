package com.fhec.context;

import com.fhec.config.ini.INIConfigObject;
import com.fhec.locker.FileLocker;

public class GlobalContext {
    public static GlobalContext Instance = new GlobalContext();
    private static String uiIconPath = ConfigFilePath.IMAGE_PATH;
    private static FileLocker fileLocker;
    private static MachineConfig machineConfig;
    private static EnvConFigConfig envConFigConfig;
    private static FtpmodeConfig ftpmodeConfig;
    private static LastConfig lastConfig;
    private static LocalConfig localConfig;
    private static PasswordConfig passwordConfig;
    private static RecipeConfig recipeConfig;
    private static MesFileConfig mesFileConfig;
    private static  SocketPort socketPort;
    private static CommandConfig commandConfig;
    /**
     * 按钮状态
     */
    public static  boolean status_s0;

    /**
     *服务器文件夹名字
     */
    public static  String singleFile = "SingleFile";
    public static  String csvdir = "csvdir";

    public static  String fulllotfile = "FullLotFile";


    /**
     * 存放变量testcode
     */
    public static String testCode;

    /**
     *设置数据生成路径信息到测试机测试软件  local_stdf_filepath_temp
     */
    public static String local_stdf_filepath_temp;

    /**
     *local_log_filepath_temp
     */
    public static String local_log_filepath_temp;

    /**
     *local_summary_filepath_temp
     */
    public static String local_summary_filepath_temp;

    /**
     * 出现保存异常时临时路径的数据转移位置
     */
    public static String local_errordata_folderpath;
    /**
     * 本地UI 操作记录路径
     */
    public static String local_UImessage_path;
    /**
     * 本地 mesfile 文件全路径
     */
    public static String local_mes_filepath;
    /**
     * 出现保存异常时临时路径的数据转移位置
     */
    public static String server_errordata_folderpath;
    /**
     * 测试过程中，数据临时存储位置
     */
    public static String local_tempdata_folderpath;
    /**
     * 服务器 UI 信息路径
     */
    public static String server_UImessage_path;

    /**
     * UI模式
     */
    public static String UImode;
    /**
     * mes固定值
     */
    public static final String MES = "MESFILE";

    /**
     * recipe固定值
     */
    public static final String RECIPE = "Recipe";


    /**
     * 测试异常数据转移文件夹
     */
    public static String ErrorData = "errordata";
    /**
     * 测试过程中，测试机数据临时存储文件夹
     */
    public static String TempData = "tempdata";

    /**
     * UI 操作记录路径
     */
    public static String UI_message = "UI_message";

    /**
     * FileLocker
     *
     * @throws Exception
     */
    public static void CreateFileLocker() throws Exception {
        fileLocker = FileLocker.GetOrCreate(uiIconPath);
    }

    /**
     * MachineContext
     *
     * @throws Exception
     */
    public static void CreateMachineContext() throws Exception {
        machineConfig = MachineConfig.GetOrCreate();
    }

    /**
     * envconfig
     *
     * @throws Exception
     */
    public static void CreatEnvConFigConfig() throws Exception {
        if (envConFigConfig != null) {
            return;
        }
        INIConfigObject envconfigObject = new INIConfigObject(ConfigFilePath.ENVCONFIG_PATH);
        envConFigConfig = envconfigObject.toJavaObject(EnvConFigConfig.class);
    }

    /**
     * FTPMODE
     *
     * @throws Exception
     */
    public static void CreatFtpMode() throws Exception {
        if (ftpmodeConfig != null) {
            return;
        }
        INIConfigObject envconfigObject = new INIConfigObject(ConfigFilePath.FTPMODE_PATH);
        ftpmodeConfig = envconfigObject.toJavaObject(FtpmodeConfig.class);
    }


    /**
     * lastconfig
     *
     * @throws Exception
     */
    public static void CreatLastConfig() throws Exception {
//        if (lastConfig != null) {
//            return;
//        }
        INIConfigObject lastObject = new INIConfigObject(ConfigFilePath.LAST_PATH);
        lastConfig = lastObject.toJavaObject(LastConfig.class);
    }

    /**
     * mesfileConfig
     */
    public static void CreatMesFileConfig() throws Exception {
//        if (mesFileConfig != null) {
//            return;
//        }
        INIConfigObject mesFileObject = new INIConfigObject(ConfigFilePath.MESFILE_PATH);
        mesFileConfig = mesFileObject.toJavaObject(MesFileConfig.class);
    }

    /**
     * passwordConfig
     */
    public static void CreatPassWordConfig() throws Exception {
//        if (passwordConfig != null) {
//            return;
//        }
        INIConfigObject passwordObject = new INIConfigObject(ConfigFilePath.PASSWORD_PATH);
        passwordConfig = passwordObject.toJavaObject(PasswordConfig.class);
    }

    /**
     * recipeConfig
     */
    public static void CreatRecipeConfig() throws Exception {
//        if (recipeConfig != null) {
//            return;
//        }
        INIConfigObject recipeObject = new INIConfigObject(ConfigFilePath.RECIPE_PATH);
        recipeConfig = recipeObject.toJavaObject(RecipeConfig.class);
    }

    /**
     * socketport
     *
     * @throws Exception
     */
    public static void CreatSocketPort() throws Exception {
        if (socketPort!= null) {
            return;
        }
        INIConfigObject envconfigObject = new INIConfigObject(ConfigFilePath.SOCKETPORTPATH);
        socketPort = envconfigObject.toJavaObject(SocketPort.class);
    }

    /**
     * command
     *
     * @throws Exception
     */
    public static void CreatCommand() throws Exception {
        if (commandConfig!= null) {
            return;
        }
        INIConfigObject envconfigObject = new INIConfigObject(ConfigFilePath.COMMAND);
        commandConfig = envconfigObject.toJavaObject(CommandConfig.class);
    }


    /**
     * get set
     *
     * @return
     */
    public String getUiIconPath() {
        return uiIconPath;
    }

    public static void setUiIconPath(String uiIconPath) {
        GlobalContext.uiIconPath = uiIconPath;
    }

    public static FileLocker getFileLocker() {
        return fileLocker;
    }

    public void setFileLocker(FileLocker fileLocker) {
        GlobalContext.fileLocker = fileLocker;
    }

    public static MachineConfig getMachineConfig() {
        return machineConfig;
    }

    public static void setMachineConfig(MachineConfig machineConfig) {
        GlobalContext.machineConfig = machineConfig;
    }

    public static EnvConFigConfig getEnvConFigConfig() {
        if (envConFigConfig == null) {
            throw new RuntimeException("Invoke CreatEnvConFigConfig");
        }
        return envConFigConfig;
    }

    public static void setEnvConFigConfig(EnvConFigConfig envConFigConfig) {
        GlobalContext.envConFigConfig = envConFigConfig;
    }

    public static LastConfig getLastConfig() {
        return lastConfig;
    }

    public static void setLastConfig(LastConfig lastConfig) {
        GlobalContext.lastConfig = lastConfig;
    }

    public static LocalConfig getLocalConfig() {
        return localConfig;
    }

    public static void setLocalConfig(LocalConfig localConfig) {
        GlobalContext.localConfig = localConfig;
    }

    public static PasswordConfig getPasswordConfig() {
        return passwordConfig;
    }

    public static void setPasswordConfig(PasswordConfig passwordConfig) {
        GlobalContext.passwordConfig = passwordConfig;
    }

    public static RecipeConfig getRecipeConfig() {
        return recipeConfig;
    }

    public static void setRecipeConfig(RecipeConfig recipeConfig) {
        GlobalContext.recipeConfig = recipeConfig;
    }

    public static FtpmodeConfig getFtpmodeConfig() {
        return ftpmodeConfig;
    }

    public static void setFtpmodeConfig(FtpmodeConfig ftpmodeConfig) {
        GlobalContext.ftpmodeConfig = ftpmodeConfig;
    }

    public static MesFileConfig getMesFileConfig() {
        return mesFileConfig;
    }

    public static void setMesFileConfig(MesFileConfig mesFileConfig) {
        GlobalContext.mesFileConfig = mesFileConfig;
    }
    public static SocketPort getSocketPort() {
        return socketPort;
    }

    public static void setSocketPort(SocketPort socketPort) {
        GlobalContext.socketPort = socketPort;
    }
    public static CommandConfig getCommandConfig() {
        return commandConfig;
    }

    public static void setCommandConfig(CommandConfig commandConfig) {
        GlobalContext.commandConfig = commandConfig;
    }
}
