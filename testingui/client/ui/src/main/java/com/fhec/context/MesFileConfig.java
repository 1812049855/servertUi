package com.fhec.context;

import com.fhec.config.ini.INISectionNode;

public class MesFileConfig {
    public final static String NAME_SUB_LOTNO = "Sub_LotNo";
    public final static String NAME_CUSTOMER_LOTNO = "Customer_LotNo";
    public final static String NAME_CUSTOMER_ID = "Customer_ID";
    public final static String NAME_DEVICE_NAME = "Device_Name";
    public final static String NAME_PID_NAME = "PID_Name";
    public final static String NAME_MODE_CODE = "Mode_Code";
    public final static String NAME_QUANTITY = "Quantity";
    public final static String NAME_OPERATOR_ID = "Operator_ID";
    public final static String NAME_DATE_CODE = "Date_Code";
    public final static String NAME_LOT_TYPE = "Lot_Type";
    public final static String NAME_PROGRAM_NAME = "Program_Name";
    public final static String NAME_TEST_TEMP = "Test_Temp";
    public final static String NAME_SOAK_TIME = "Soak_Time";
    public final static String NAME_TESTEROS_VERSION = "TesterOS_Version";
    public final static String NAME_ZIPFILE_NAME = "Zipfile_Name";
    public final static String NAME_PROGRAM_FOLDER = "Program_Folder";
    public final static String NAME_TEST_FLOW = "Test_Flow";
    public final static String NAME_PASS_BIN = "PASS_BIN";
    public final static String NAME_FAIL_BIN = "FAIL_BIN";
    public final static String NAME_PACKAGE_TYPE = "Package_Type";
    public final static String NAME_PIN_COUNT = "PIN_Count";
    public final static String NAME_WAFER_VERSION = "Wafer_Version";
    public final static String NAME_WAFER_NO = "Wafer_No";
    public final static String NAME_CHECK_SUM = "Check_Sum";
    public final static String NAME_CODE_NAME = "Code_Name";
    public final static String NAME_MOTHER_FAB = "Mother_Fab";
    public final static String NAME_PO_NUMBER = "PO_Number";
    public final static String NAME_TESTER_ID = "Tester_ID";
    public final static String NAME_HANDLER_ID = "Handler_ID";
    public final static String NAME_LOADBOARD_ID = "Loadboard_ID";
    public final static String NAME_SOCKET_ID = "Socket_ID";
    public final static String NAME_EFUSE_CONDITION = "Efuse_Condition";
    public final static String NAME_EFUSE_CHECK_FLAG = "efuse_check_flag";
    public final static String NAME_SITE_ALARM_NUMBER = "Site_Alarm_Number";
    public final static String NAME_SITE_ALARM_CONDITION = "Site_Alarm_Condition";
    public final static String NAME_SITE_ALARM_FLAG = "Site_Alarm_flag";
    public final static String NAME_ITEM = "Item";
    public final static String NAME_RUNTYPE = "runtype";
    public final static String NAME_LONG_DEVICE = "Long_Device";
    public final static String NAME_MCG_Substrate_No = "MCG_Substrate_No";
    public final static String NAME_MCG_ES_No = "MCG_ES_No";
    public final static String NAME_MCG_DDR_No = "MCG_DDR_No";
    public final static String NAME_TPN = "TPN";
    public final static String NAME_Handler_type = "Handler_type";

    @INISectionNode(name = NAME_MCG_Substrate_No, isRequired = false)
    private String substrateNo;

    public String getSubstrateNo() {
        return substrateNo;
    }

    public void setSubstrateNo(String substrateNo) {
        this.substrateNo = substrateNo;
    }

    @INISectionNode(name = NAME_TPN, isRequired = false)
    private String tpn;

    @INISectionNode(name = NAME_Handler_type, isRequired = false)
    private String hansler_type;

    public String getHansler_type() {
        return hansler_type;
    }

    public void setHansler_type(String hansler_type) {
        this.hansler_type = hansler_type;
    }

    public String getTpn() {
        return tpn;
    }

    public void setTpn(String tpn) {
        this.tpn = tpn;
    }

    @INISectionNode(name = NAME_MCG_ES_No, isRequired = false)
    private String mcgESNo;
    @INISectionNode(name = NAME_MCG_DDR_No, isRequired = false)
    private String mcgDDRNo;

    public String getMcgESNo() {
        return mcgESNo;
    }

    public void setMcgESNo(String mcgESNo) {
        this.mcgESNo = mcgESNo;
    }

    public String getMcgDDRNo() {
        return mcgDDRNo;
    }

    public void setMcgDDRNo(String mcgDDRNo) {
        this.mcgDDRNo = mcgDDRNo;
    }

    @INISectionNode(name = NAME_SUB_LOTNO,isRequired = false)
    private String sub_LotNo;
    @INISectionNode(name = NAME_CUSTOMER_LOTNO,isRequired = false)
    private String customer_LotNo;
    @INISectionNode(name = NAME_CUSTOMER_ID,isRequired = false)
    private String customer_ID;
    @INISectionNode(name = NAME_DEVICE_NAME,isRequired = false)
    private String device_Name;
    @INISectionNode(name = NAME_PID_NAME,isRequired = false)
    private String pid_Name;
    @INISectionNode(name = NAME_MODE_CODE,isRequired = false)
    private String mode_Code;
    @INISectionNode(name = NAME_QUANTITY,isRequired = false)
    private String quantity;
    @INISectionNode(name = NAME_OPERATOR_ID,isRequired = false)
    private String operator_ID;
    @INISectionNode(name = NAME_DATE_CODE,isRequired = false)
    private String date_Code;
    @INISectionNode(name = NAME_LOT_TYPE,isRequired = false)
    private String lot_Type;
    @INISectionNode(name = NAME_PROGRAM_NAME,isRequired = false)
    private String program_Name;
    @INISectionNode(name = NAME_TEST_TEMP,isRequired = false)
    private String test_Temp;
    @INISectionNode(name = NAME_SOAK_TIME,isRequired = false)
    private String soak_Time;
    @INISectionNode(name = NAME_TESTEROS_VERSION,isRequired = false)
    private String testerOS_Version;
    @INISectionNode(name = NAME_ZIPFILE_NAME,isRequired = false)
    private String zipfile_Name;
    @INISectionNode(name = NAME_PROGRAM_FOLDER,isRequired = false)
    private String program_Folder;
    @INISectionNode(name = NAME_TEST_FLOW,isRequired = false)
    private String test_Flow;
    @INISectionNode(name = NAME_PASS_BIN,isRequired = false)
    private String pass_Bin;
    @INISectionNode(name = NAME_FAIL_BIN,isRequired = false)
    private String fall_Bin;
    @INISectionNode(name = NAME_PACKAGE_TYPE,isRequired = false)
    private String package_Type;
    @INISectionNode(name = NAME_PIN_COUNT,isRequired = false)
    private String pin_Count;
    @INISectionNode(name = NAME_WAFER_VERSION, isRequired = false)
    private String wafer_Version;
    @INISectionNode(name = NAME_WAFER_NO, isRequired = false)
    private String wafer_No;
    @INISectionNode(name = NAME_CHECK_SUM, isRequired = false)
    private String check_Sum;
    @INISectionNode(name = NAME_CODE_NAME, isRequired = false)
    private String code_Name;
    @INISectionNode(name = NAME_MOTHER_FAB, isRequired = false)
    private String mother_Fab;
    @INISectionNode(name = NAME_PO_NUMBER,isRequired = false)
    private String po_Number;
    @INISectionNode(name = NAME_TESTER_ID,isRequired = false)
    private String tester_ID;
    @INISectionNode(name = NAME_HANDLER_ID,isRequired = false)
    private String handler_ID;
    @INISectionNode(name = NAME_LOADBOARD_ID,isRequired = false)
    private String loadboard_ID;
    @INISectionNode(name = NAME_SOCKET_ID,isRequired = false)
    private String socket_ID;
    @INISectionNode(name = NAME_EFUSE_CONDITION,isRequired = false)
    private String efuse_Condition;

    public String getSub_LotNo() {
        return sub_LotNo;
    }

    public void setSub_LotNo(String sub_LotNo) {
        this.sub_LotNo = sub_LotNo;
    }

    public String getCustomer_LotNo() {
        return customer_LotNo;
    }

    public void setCustomer_LotNo(String customer_LotNo) {
        this.customer_LotNo = customer_LotNo;
    }

    public String getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(String customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getDevice_Name() {
        return device_Name;
    }

    public void setDevice_Name(String device_Name) {
        this.device_Name = device_Name;
    }

    public String getPid_Name() {
        return pid_Name;
    }

    public void setPid_Name(String pid_Name) {
        this.pid_Name = pid_Name;
    }

    public String getMode_Code() {
        return mode_Code;
    }

    public void setMode_Code(String mode_Code) {
        this.mode_Code = mode_Code;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getOperator_ID() {
        return operator_ID;
    }

    public void setOperator_ID(String operator_ID) {
        this.operator_ID = operator_ID;
    }

    public String getDate_Code() {
        return date_Code;
    }

    public void setDate_Code(String date_Code) {
        this.date_Code = date_Code;
    }

    public String getLot_Type() {
        return lot_Type;
    }

    public void setLot_Type(String lot_Type) {
        this.lot_Type = lot_Type;
    }

    public String getProgram_Name() {
        return program_Name;
    }

    public void setProgram_Name(String program_Name) {
        this.program_Name = program_Name;
    }

    public String getTest_Temp() {
        return test_Temp;
    }

    public void setTest_Temp(String test_Temp) {
        this.test_Temp = test_Temp;
    }

    public String getSoak_Time() {
        return soak_Time;
    }

    public void setSoak_Time(String soak_Time) {
        this.soak_Time = soak_Time;
    }

    public String getTesterOS_Version() {
        return testerOS_Version;
    }

    public void setTesterOS_Version(String testerOS_Version) {
        this.testerOS_Version = testerOS_Version;
    }

    public String getZipfile_Name() {
        return zipfile_Name;
    }

    public void setZipfile_Name(String zipfile_Name) {
        this.zipfile_Name = zipfile_Name;
    }

    public String getProgram_Folder() {
        return program_Folder;
    }

    public void setProgram_Folder(String program_Folder) {
        this.program_Folder = program_Folder;
    }

    public String getTest_Flow() {
        return test_Flow;
    }

    public void setTest_Flow(String test_Flow) {
        this.test_Flow = test_Flow;
    }

    public String getPass_Bin() {
        return pass_Bin;
    }

    public void setPass_Bin(String pass_Bin) {
        this.pass_Bin = pass_Bin;
    }

    public String getFall_Bin() {
        return fall_Bin;
    }

    public void setFall_Bin(String fall_Bin) {
        this.fall_Bin = fall_Bin;
    }

    public String getPackage_Type() {
        return package_Type;
    }

    public void setPackage_Type(String package_Type) {
        this.package_Type = package_Type;
    }

    public String getPin_Count() {
        return pin_Count;
    }

    public void setPin_Count(String pin_Count) {
        this.pin_Count = pin_Count;
    }

    public String getWafer_Version() {
        return wafer_Version;
    }

    public void setWafer_Version(String wafer_Version) {
        this.wafer_Version = wafer_Version;
    }

    public String getWafer_No() {
        return wafer_No;
    }

    public void setWafer_No(String wafer_No) {
        this.wafer_No = wafer_No;
    }

    public String getCheck_Sum() {
        return check_Sum;
    }

    public void setCheck_Sum(String check_Sum) {
        this.check_Sum = check_Sum;
    }

    public String getCode_Name() {
        return code_Name;
    }

    public void setCode_Name(String code_Name) {
        this.code_Name = code_Name;
    }

    public String getMother_Fab() {
        return mother_Fab;
    }

    public void setMother_Fab(String mother_Fab) {
        this.mother_Fab = mother_Fab;
    }

    public String getPo_Number() {
        return po_Number;
    }

    public void setPo_Number(String po_Number) {
        this.po_Number = po_Number;
    }

    public String getTester_ID() {
        return tester_ID;
    }

    public void setTester_ID(String tester_ID) {
        this.tester_ID = tester_ID;
    }

    public String getHandler_ID() {
        return handler_ID;
    }

    public void setHandler_ID(String handler_ID) {
        this.handler_ID = handler_ID;
    }
    public String getLoadboard_ID() {
        return loadboard_ID;
    }

    public void setLoadboard_ID(String loadboard_ID) {
        this.loadboard_ID = loadboard_ID;
    }

    public String getSocket_ID() {
        return socket_ID;
    }

    public void setSocket_ID(String socket_ID) {
        this.socket_ID = socket_ID;
    }

    public String getEfuse_Condition() {
        return efuse_Condition;
    }

    public void setEfuse_Condition(String efuse_Condition) {
        this.efuse_Condition = efuse_Condition;
    }

    public String getEfuse_check_flag() {
        return efuse_check_flag;
    }

    public void setEfuse_check_flag(String efuse_check_flag) {
        this.efuse_check_flag = efuse_check_flag;
    }

    public String getSite_Alarm_Number() {
        return site_Alarm_Number;
    }

    public void setSite_Alarm_Number(String site_Alarm_Number) {
        this.site_Alarm_Number = site_Alarm_Number;
    }

    public String getSite_Alarm_Condition() {
        return site_Alarm_Condition;
    }

    public void setSite_Alarm_Condition(String site_Alarm_Condition) {
        this.site_Alarm_Condition = site_Alarm_Condition;
    }

    public String getSite_Alarm_flag() {
        return site_Alarm_flag;
    }

    public void setSite_Alarm_flag(String site_Alarm_flag) {
        this.site_Alarm_flag = site_Alarm_flag;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getRuntype() {
        return runtype;
    }

    public void setRuntype(String runtype) {
        this.runtype = runtype;
    }

    public String getLong_Device() {
        return long_Device;
    }

    public void setLong_Device(String long_Device) {
        this.long_Device = long_Device;
    }

    @INISectionNode(name = NAME_EFUSE_CHECK_FLAG,isRequired = false)
    private String efuse_check_flag;
    @INISectionNode(name = NAME_SITE_ALARM_NUMBER,isRequired = false)
    private String site_Alarm_Number;
    @INISectionNode(name = NAME_SITE_ALARM_CONDITION,isRequired = false)
    private String site_Alarm_Condition;
    @INISectionNode(name = NAME_SITE_ALARM_FLAG,isRequired = false)
    private String site_Alarm_flag;
    @INISectionNode(name = NAME_ITEM,isRequired = false)
    private String item;
    @INISectionNode(name = NAME_RUNTYPE,isRequired = false)
    private String runtype;
    @INISectionNode(name = NAME_LONG_DEVICE,isRequired = false)
    private String long_Device;
}
