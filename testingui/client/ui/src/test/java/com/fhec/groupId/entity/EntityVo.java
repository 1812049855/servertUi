package com.fhec.groupId.entity;


/**
 * 传输配置文件赋值过的类
 *
 * @author Archer.W
 * @date 2021/04/16 09:34
 **/
public class EntityVo {
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
    private String TempData;
    private String datalog_name_rules;
    private String command;
    private int status;
    public static  int status1;

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

    public EntityVo(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EntityVo{" +
                "status=" + status +
                '}';
    }

    public EntityVo() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
