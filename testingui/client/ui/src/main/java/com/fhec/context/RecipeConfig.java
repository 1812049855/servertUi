package com.fhec.context;

import com.fhec.config.ini.INISection;
import com.fhec.config.ini.INISectionNode;

public class RecipeConfig {
    public final static String GROUPNAME_DATALOG_PETH = "Datalog_Path";
    public final static String GROUPNAME_PACKTESTRESULT = "PackTestResult";
    //public final static String GROUPNAME_INPUT_OI = "INPUT_OI";
    public final static String RCS_TestNo_Config = "RCS_TestNo_Config";
    public final static String TESTCODE_CONFIG = "TestCode_Config";
    public final static String NAME_Stdf_MIR_Special_Config = "Stdf_MIR_Special_Config";
    public final static String NAME_Tester_caldata_check = "Tester_caldata_check";
    public final static String NAME_HARDBIN_PASS = "HardBin_Pass";
    public final static String NAME_SOFTBIN_PASS = "SoftBin_Pass";
    public final static String NAME_HARDBIN_ALARM = "HardBin_alarm";
    public final static String NAME_SOFTBIN_ALARM = "SoftBin_alarm";
    public final static String NAME_HARDBIN_DEFINE = "HardBin_Define";
    public final static String NAME_SOFTBIN_DEFINE = "SoftBin_Define";
    public final static String NAME_INPUT_OI_TESTER_ID = "INPUT_OI_tester_id";
    public final static String NAME_INPUT_OI_OPERATOR_ID = "INPUT_OI_operator_id";
    public final static String NAME_INPUT_OI_CUSTOMER_ID = "INPUT_OI_customer_id";
    public final static String NAME_INPUT_OI_DEVICE_NAME = "INPUT_OI_device_name";
    public final static String NAME_INPUT_OI_LOT_NO = "INPUT_OI_lot_no";
    public final static String NAME_INPUT_OI_SUBLOT = "INPUT_OI_sublot";
    public final static String NAME_INPUT_OI_PROGRAM_NAME = "INPUT_OI_program_name";
    public final static String NAME_INPUT_OI_MODE_CODE = "INPUT_OI_mode_code";
    public final static String NAME_INPUT_OI_TEST_CODE = "INPUT_OI_test_code";
    public final static String NAME_INPUT_OI_TEST_BIN_NO = "INPUT_OI_test_bin_no";

    @INISection(name = GROUPNAME_DATALOG_PETH,isRequired = false)
    private DatalogPath datalogPath;

    @INISection(name = GROUPNAME_PACKTESTRESULT,isRequired = false)
    private PackTestResult packTestResult;

   /* @INISection(name = GROUPNAME_INPUT_OI)
    private InputOi inputOI;*/
     @INISection(name = RCS_TestNo_Config,isRequired = false)
    private TestConfig testConfig;

    public TestConfig getTestConfig() {
        return testConfig;
    }

    public void setTestConfig(TestConfig testConfig) {
        this.testConfig = testConfig;
    }

    @INISection(name = NAME_INPUT_OI_TESTER_ID,isRequired = false)
    private InputOiEntry inputOITesterId;

    @INISection(name = NAME_INPUT_OI_OPERATOR_ID,isRequired = false)
    private InputOiEntry inputOIOperatorId;

    @INISection(name = NAME_INPUT_OI_CUSTOMER_ID,isRequired = false)
    private InputOiEntry inputOICustomerId;

    @INISection(name = NAME_INPUT_OI_DEVICE_NAME,isRequired = false)
    private InputOiEntry inputOIDeviceName;

    @INISection(name = NAME_INPUT_OI_LOT_NO,isRequired = false)
    private InputOiEntry inputOILotNo;

    @INISection(name = NAME_INPUT_OI_SUBLOT,isRequired = false)
    private InputOiEntry inputOISublot;

    @INISection(name = NAME_INPUT_OI_PROGRAM_NAME,isRequired = false)
    private InputOiEntry inputOIProgramName;

    @INISection(name = NAME_INPUT_OI_MODE_CODE,isRequired = false)
    private InputOiEntry inputOIModeCode;

    @INISection(name = NAME_INPUT_OI_TEST_CODE,isRequired = false)
    private InputOiEntry inputOITestCode;

    @INISection(name = NAME_INPUT_OI_TEST_BIN_NO,isRequired = false)
    private InputOiEntry inputOITestBinNo;

    @INISection(name = TESTCODE_CONFIG,isRequired = false)
    private TestCodeConfig testCodeConfig;

    @INISection(name = NAME_Tester_caldata_check,isRequired = false)
    private TesterCaldataCheck testerCaldataCheck;

    @INISection(name = NAME_HARDBIN_PASS,isRequired = false)
    private HardBinPass hardBinPass;

    @INISection(name = NAME_SOFTBIN_PASS,isRequired = false)
    private SoftBinPass softBinPass;

    @INISection(name = NAME_HARDBIN_ALARM,isRequired = false)
    private HardBinAlarm hardBinAlarm;

    @INISection(name = NAME_SOFTBIN_ALARM,isRequired = false)
    private SoftBinAlarm softBinAlarm;

    @INISection(name = NAME_HARDBIN_DEFINE,isRequired = false)
    private HardBinDefine hardBinDefine;

    @INISection(name = NAME_SOFTBIN_DEFINE,isRequired = false)
    private SoftBinDefine softBinDefine;

    public static class DatalogPath {
        public final static String NAME_DATALOG_NAME_RULE_1 = "datalog_name_rule_1";
        public final static String NAME_DATALOG_NAME_RULE_2 = "datalog_name_rule_2";
        public final static String NAME_DATALOG_NAME_RULE_3 = "datalog_name_rule_3";
        public final static String NAME_DATALOG_NAME_RULE_4 = "datalog_name_rule_4";
        public final static String NAME_DATALOG_NAME_RULE_5 = "datalog_name_rule_5";
        public final static String NAME_DATALOG_NAME_RULE_6 = "datalog_name_rule_6";

        @INISectionNode(name = NAME_DATALOG_NAME_RULE_1,isRequired = false)
        private String datalog_name_rule_1;
        @INISectionNode(name = NAME_DATALOG_NAME_RULE_2,isRequired = false)
        private String datalog_name_rule_2;
        @INISectionNode(name = NAME_DATALOG_NAME_RULE_3,isRequired = false)
        private String datalog_name_rule_3;
        @INISectionNode(name = NAME_DATALOG_NAME_RULE_4,isRequired = false)
        private String datalog_name_rule_4;
        @INISectionNode(name = NAME_DATALOG_NAME_RULE_5,isRequired = false)
        private String datalog_name_rule_5;
        @INISectionNode(name = NAME_DATALOG_NAME_RULE_6,isRequired = false)
        private String datalog_name_rule_6;

        public String getDatalog_name_rule_1() {
            return datalog_name_rule_1;
        }

        public void setDatalog_name_rule_1(String datalog_name_rule_1) {
            this.datalog_name_rule_1 = datalog_name_rule_1;
        }

        public String getDatalog_name_rule_2() {
            return datalog_name_rule_2;
        }

        public void setDatalog_name_rule_2(String datalog_name_rule_2) {
            this.datalog_name_rule_2 = datalog_name_rule_2;
        }

        public String getDatalog_name_rule_3() {
            return datalog_name_rule_3;
        }

        public void setDatalog_name_rule_3(String datalog_name_rule_3) {
            this.datalog_name_rule_3 = datalog_name_rule_3;
        }

        public String getDatalog_name_rule_4() {
            return datalog_name_rule_4;
        }

        public void setDatalog_name_rule_4(String datalog_name_rule_4) {
            this.datalog_name_rule_4 = datalog_name_rule_4;
        }

        public String getDatalog_name_rule_5() {
            return datalog_name_rule_5;
        }

        public void setDatalog_name_rule_5(String datalog_name_rule_5) {
            this.datalog_name_rule_5 = datalog_name_rule_5;
        }

        public String getDatalog_name_rule_6() {
            return datalog_name_rule_6;
        }

        public void setDatalog_name_rule_6(String datalog_name_rule_6) {
            this.datalog_name_rule_6 = datalog_name_rule_6;
        }
    }

    public static class PackTestResult {
        public final static String NAME_PACKTESTRESULT = "PackTestResult";
        public final static String NAME_PACKFILETYPE = "PackFileType";
        public final static String NAME_PACKFILESET = "PackFileSet";

        @INISectionNode(name = NAME_PACKTESTRESULT,isRequired = false)
        private String PackTestResult;
        @INISectionNode(name = NAME_PACKFILETYPE,isRequired = false)
        private String PackFileType;
        @INISectionNode(name = NAME_PACKFILESET,isRequired = false)
        private String PackFileSet;

        public String getPackTestResult() {
            return PackTestResult;
        }

        public void setPackTestResult(String packTestResult) {
            PackTestResult = packTestResult;
        }

        public String getPackFileType() {
            return PackFileType;
        }

        public void setPackFileType(String packFileType) {
            PackFileType = packFileType;
        }

        public String getPackFileSet() {
            return PackFileSet;
        }

        public void setPackFileSet(String packFileSet) {
            PackFileSet = packFileSet;
        }
    }
/*
    public static class InputOi {
    }*/
    public static class TestConfig {
    }

    public static class InputOiEntry {
        public final static String NAME_NAME = "Name";
        public final static String NAME_PATTERN = "Pattern";
        public final static String NAME_INDEX = "Index";

        @INISectionNode(name = NAME_NAME,isRequired = false)
        private String Name;
        @INISectionNode(name = NAME_PATTERN,isRequired = false)
        private String Pattern;
        @INISectionNode(name = NAME_INDEX,isRequired = false)
        private String Index;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getPattern() {
            return Pattern;
        }

        public void setPattern(String pattern) {
            Pattern = pattern;
        }

        public String getIndex() {
            return Index;
        }

        public void setIndex(String index) {
            Index = index;
        }
    }

    public static class TestCodeConfig {
        public final static String R0 = "R0";
        public final static String R0_1 = "R0.1";
        public final static String R0_2 = "R0.2";
        public final static String R0_3 = "R0.3";
        public final static String R0_4 = "R0.4";
        public final static String R0_5 = "R0.5";
        public final static String R0_6 = "R0.6";
        public final static String R0_7 = "R0.7";
        public final static String R0_8 = "R0.8";
        public final static String R0_9 = "R0.9";
        public final static String R0_10 = "R0.10";
        public final static String R1 = "R1";
        public final static String R1_1 = "R1.1";
        public final static String R1_2 = "R1.2";
        public final static String R1_3 = "R1.3";
        public final static String R1_4 = "R1.4";
        public final static String R1_5 = "R1.5";
        public final static String R2 = "R2";
        public final static String R2_1 = "R2.1";
        public final static String R2_2 = "R2.2";
        public final static String R2_3 = "R2.3";
        public final static String R2_4 = "R2.4";
        public final static String R2_5 = "R2.5";
        public final static String R3 = "R3";
        public final static String R3_1 = "R3.1";
        public final static String R3_2 = "R3.2";
        public final static String R3_3 = "R3.3";
        public final static String R3_4 = "R3.4";
        public final static String R3_5 = "R3.5";
        public final static String R4 = "R4";
        public final static String R4_1 = "R4.1";
        public final static String R4_2 = "R4.2";
        public final static String R4_3 = "R4.3";
        public final static String R4_4 = "R4.4";
        public final static String R4_5 = "R4.5";
        public final static String R5 = "R5";
        public final static String R5_1 = "R5.1";
        public final static String R5_2 = "R5.2";
        public final static String R5_3 = "R5.3";
        public final static String R5_4 = "R5.4";
        public final static String R5_5 = "R5.5";
        public final static String R6 = "R6";
        public final static String R6_1 = "R6.1";
        public final static String R6_2 = "R6.2";
        public final static String R6_3 = "R6.3";
        public final static String R6_4 = "R6.4";
        public final static String R6_5 = "R6.5";
        public final static String R7 = "R7";
        public final static String R7_1 = "R7.1";
        public final static String R7_2 = "R7.2";
        public final static String R7_3 = "R7.3";
        public final static String R7_4 = "R7.4";
        public final static String R7_5 = "R7.5";
        public final static String R8 = "R8";
        public final static String R8_1 = "R8.1";
        public final static String R8_2 = "R8.2";
        public final static String R8_3 = "R8.3";
        public final static String R8_4 = "R8.4";
        public final static String R8_5 = "R8.5";
        public final static String R9 = "R9";
        public final static String R9_1 = "R9.1";
        public final static String R9_2 = "R9.2";
        public final static String R9_3 = "R9.3";
        public final static String R9_4 = "R9.4";
        public final static String R9_5 = "R9.5";
        public final static String R10 = "R10";
        public final static String R10_1 = "R10.1";
        public final static String R10_2 = "R10.2";
        public final static String R10_3 = "R10.3";
        public final static String R10_4 = "R10.4";
        public final static String R10_5 = "R10.5";
        public final static String Q0 = "Q0";
        public final static String Q0_1 = "Q0.1";
        public final static String Q0_2 = "Q0.2";
        public final static String Q0_3 = "Q0.3";
        public final static String Q0_4 = "Q0.4";
        public final static String Q0_5 = "Q0.5";
        public final static String Q1 = "Q1";
        public final static String Q1_1 = "Q1.1";
        public final static String Q1_2 = "Q1.2";
        public final static String Q2 = "Q2";
        public final static String Q2_1 = "Q2.1";
        public final static String Q2_2 = "Q2.2";
        public final static String Q3 = "Q3";
        public final static String Q3_1 = "Q3.1";
        public final static String Q3_2 = "Q3.2";
        public final static String Q4 = "Q4";
        public final static String Q4_1 = "Q4.1";
        public final static String Q4_2 = "Q4.2";
        public final static String Q5 = "Q5";
        public final static String Q5_1 = "Q5.1";
        public final static String Q5_2 = "Q5.2";
        public final static String Q6 = "Q6";
        public final static String Q6_1 = "Q6.1";
        public final static String Q6_2 = "Q6.2";
        public final static String Q7 = "Q7";
        public final static String Q7_1 = "Q7.1";
        public final static String Q7_2 = "Q7.2";
        public final static String Q8 = "Q8";
        public final static String Q8_1 = "Q8.1";
        public final static String Q8_2 = "Q8.2";
        public final static String Q9 = "Q9";
        public final static String Q9_1 = "Q9.1";
        public final static String Q9_2 = "Q9.2";
        public final static String Q10 = "Q10";
        public final static String Q10_1 = "Q10.1";
        public final static String Q10_2 = "Q10.2";
        @INISectionNode(name = R0,isRequired = false)
        private String r0;
        @INISectionNode(name = R0_1,isRequired = false)
        private String r0_1;
        @INISectionNode(name = R0_2,isRequired = false)
        private String r0_2;
        @INISectionNode(name = R0_3,isRequired = false)
        private String r0_3;
        @INISectionNode(name = R0_4,isRequired = false)
        private String r0_4;
        @INISectionNode(name = R0_5,isRequired = false)
        private String r0_5;
        @INISectionNode(name = R0_6,isRequired = false)
        private String r0_6;
        @INISectionNode(name = R0_7,isRequired = false)
        private String r0_7;
        @INISectionNode(name = R0_8,isRequired = false)
        private String r0_8;
        @INISectionNode(name = R0_9,isRequired = false)
        private String r0_9;
        @INISectionNode(name = R0_10,isRequired = false)
        private String r0_10;
        @INISectionNode(name = R1,isRequired = false)
        private String r1;
        @INISectionNode(name = R1_1,isRequired = false)
        private String r1_1;
        @INISectionNode(name = R1_2,isRequired = false)
        private String r1_2;
        @INISectionNode(name = R1_3,isRequired = false)
        private String r1_3;
        @INISectionNode(name = R1_4,isRequired = false)
        private String r1_4;
        @INISectionNode(name = R1_5,isRequired = false)
        private String r1_5;
        @INISectionNode(name = R2,isRequired = false)
        private String r2;
        @INISectionNode(name = R2_1,isRequired = false)
        private String r2_1;
        @INISectionNode(name = R2_2,isRequired = false)
        private String r2_2;
        @INISectionNode(name = R2_3,isRequired = false)
        private String r2_3;
        @INISectionNode(name = R2_4,isRequired = false)
        private String r2_4;
        @INISectionNode(name = R2_5,isRequired = false)
        private String r2_5;
        @INISectionNode(name = R3,isRequired = false)
        private String r3;
        @INISectionNode(name = R3_1,isRequired = false)
        private String r3_1;
        @INISectionNode(name = R3_2,isRequired = false)
        private String r3_2;
        @INISectionNode(name = R3_3,isRequired = false)
        private String r3_3;
        @INISectionNode(name = R3_4,isRequired = false)
        private String r3_4;
        @INISectionNode(name = R3_5,isRequired = false)
        private String r3_5;
        @INISectionNode(name = R4,isRequired = false)
        private String r4;
        @INISectionNode(name = R4_1,isRequired = false)
        private String r4_1;
        @INISectionNode(name = R4_2,isRequired = false)
        private String r4_2;
        @INISectionNode(name = R4_3,isRequired = false)
        private String r4_3;
        @INISectionNode(name = R4_4,isRequired = false)
        private String r4_4;
        @INISectionNode(name = R4_5,isRequired = false)
        private String r4_5;
        @INISectionNode(name = R5,isRequired = false)
        private String r5;
        @INISectionNode(name = R5_1,isRequired = false)
        private String r5_1;
        @INISectionNode(name = R5_2,isRequired = false)
        private String r5_2;
        @INISectionNode(name = R5_3,isRequired = false)
        private String r5_3;
        @INISectionNode(name = R5_4,isRequired = false)
        private String r5_4;
        @INISectionNode(name = R5_5,isRequired = false)
        private String r5_5;
        @INISectionNode(name = R6,isRequired = false)
        private String r6;
        @INISectionNode(name = R6_1,isRequired = false)
        private String r6_1;
        @INISectionNode(name = R6_2,isRequired = false)
        private String r6_2;
        @INISectionNode(name = R6_3,isRequired = false)
        private String r6_3;
        @INISectionNode(name = R6_4,isRequired = false)
        private String r6_4;
        @INISectionNode(name = R6_5,isRequired = false)
        private String r6_5;
        @INISectionNode(name = R7,isRequired = false)
        private String r7;
        @INISectionNode(name = R7_1,isRequired = false)
        private String r7_1;
        @INISectionNode(name = R7_2,isRequired = false)
        private String r7_2;
        @INISectionNode(name = R7_3,isRequired = false)
        private String r7_3;
        @INISectionNode(name = R7_4,isRequired = false)
        private String r7_4;
        @INISectionNode(name = R7_5,isRequired = false)
        private String r7_5;
        @INISectionNode(name = R8,isRequired = false)
        private String r8;
        @INISectionNode(name = R8_1,isRequired = false)
        private String r8_1;
        @INISectionNode(name = R8_2,isRequired = false)
        private String r8_2;
        @INISectionNode(name = R8_3,isRequired = false)
        private String r8_3;
        @INISectionNode(name = R8_4,isRequired = false)
        private String r8_4;
        @INISectionNode(name = R8_5,isRequired = false)
        private String r8_5;
        @INISectionNode(name = R9,isRequired = false)
        private String r9;
        @INISectionNode(name = R9_1,isRequired = false)
        private String r9_1;
        @INISectionNode(name = R9_2,isRequired = false)
        private String r9_2;
        @INISectionNode(name = R9_3,isRequired = false)
        private String r9_3;
        @INISectionNode(name = R9_4,isRequired = false)
        private String r9_4;
        @INISectionNode(name = R9_5,isRequired = false)
        private String r9_5;
        @INISectionNode(name = R10,isRequired = false)
        private String r10;
        @INISectionNode(name = R10_1,isRequired = false)

        private String r10_1;
        @INISectionNode(name = R10_2,isRequired = false)
        private String r10_2;
        @INISectionNode(name = R10_3,isRequired = false)
        private String r10_3;
        @INISectionNode(name = R10_4,isRequired = false)
        private String r10_4;
        @INISectionNode(name = R10_5,isRequired = false)
        private String r10_5;
        @INISectionNode(name = Q0,isRequired = false)
        private String q0;
        @INISectionNode(name = Q0_1,isRequired = false)
        private String q0_1;
        @INISectionNode(name = Q0_2,isRequired = false)
        private String q0_2;
        @INISectionNode(name = Q0_3,isRequired = false)
        private String q0_3;
        @INISectionNode(name = Q0_4,isRequired = false)
        private String q0_4;
        @INISectionNode(name = Q0_5,isRequired = false)
        private String q0_5;
        @INISectionNode(name = Q1,isRequired = false)
        private String q1;
        @INISectionNode(name = Q1_1,isRequired = false)
        private String q1_1;
        @INISectionNode(name = Q1_2,isRequired = false)
        private String q1_2;
        @INISectionNode(name = Q2,isRequired = false)
        private String q2;
        @INISectionNode(name = Q2_1,isRequired = false)
        private String q2_1;
        @INISectionNode(name = Q2_2,isRequired = false)
        private String q2_2;
        @INISectionNode(name = Q3,isRequired = false)
        private String q3;
        @INISectionNode(name = Q3_1,isRequired = false)
        private String q3_1;
        @INISectionNode(name = Q3_2,isRequired = false)
        private String q3_2;
        @INISectionNode(name = Q4,isRequired = false)
        private String q4;
        @INISectionNode(name = Q4_1,isRequired = false)
        private String q4_1;
        @INISectionNode(name = Q4_2,isRequired = false)
        private String q4_2;
        @INISectionNode(name = Q5,isRequired = false)
        private String q5;
        @INISectionNode(name = Q5_1,isRequired = false)
        private String q5_1;
        @INISectionNode(name = Q5_2,isRequired = false)
        private String q5_2;
        @INISectionNode(name = Q6,isRequired = false)
        private String q6;
        @INISectionNode(name = Q6_1,isRequired = false)
        private String q6_1;
        @INISectionNode(name = Q6_2,isRequired = false)
        private String q6_2;
        @INISectionNode(name = Q7,isRequired = false)
        private String q7;
        @INISectionNode(name = Q7_1,isRequired = false)
        private String q7_1;
        @INISectionNode(name = Q7_2,isRequired = false)
        private String q7_2;
        @INISectionNode(name = Q8,isRequired = false)
        private String q8;
        @INISectionNode(name = Q8_1,isRequired = false)
        private String q8_1;
        @INISectionNode(name = Q8_2,isRequired = false)
        private String q8_2;
        @INISectionNode(name = Q9,isRequired = false)
        private String q9;
        @INISectionNode(name = Q9_1,isRequired = false)
        private String q9_1;
        @INISectionNode(name = Q9_2,isRequired = false)
        private String q9_2;
        @INISectionNode(name = Q10,isRequired = false)
        private String q10;
        @INISectionNode(name = Q10_1,isRequired = false)
        private String q10_1;
        @INISectionNode(name = Q10_2,isRequired = false)
        private String q10_2;

        public String getR0() {
            return r0;
        }

        public void setR0(String r0) {
            this.r0 = r0;
        }

        public String getR0_1() {
            return r0_1;
        }

        public void setR0_1(String r0_1) {
            this.r0_1 = r0_1;
        }

        public String getR0_2() {
            return r0_2;
        }

        public void setR0_2(String r0_2) {
            this.r0_2 = r0_2;
        }

        public String getR0_3() {
            return r0_3;
        }

        public void setR0_3(String r0_3) {
            this.r0_3 = r0_3;
        }

        public String getR0_4() {
            return r0_4;
        }

        public void setR0_4(String r0_4) {
            this.r0_4 = r0_4;
        }

        public String getR0_5() {
            return r0_5;
        }

        public void setR0_5(String r0_5) {
            this.r0_5 = r0_5;
        }

        public String getR0_6() {
            return r0_6;
        }

        public void setR0_6(String r0_6) {
            this.r0_6 = r0_6;
        }

        public String getR0_7() {
            return r0_7;
        }

        public void setR0_7(String r0_7) {
            this.r0_7 = r0_7;
        }

        public String getR0_8() {
            return r0_8;
        }

        public void setR0_8(String r0_8) {
            this.r0_8 = r0_8;
        }

        public String getR0_9() {
            return r0_9;
        }

        public void setR0_9(String r0_9) {
            this.r0_9 = r0_9;
        }

        public String getR0_10() {
            return r0_10;
        }

        public void setR0_10(String r0_10) {
            this.r0_10 = r0_10;
        }

        public String getR1() {
            return r1;
        }

        public void setR1(String r1) {
            this.r1 = r1;
        }

        public String getR1_1() {
            return r1_1;
        }

        public void setR1_1(String r1_1) {
            this.r1_1 = r1_1;
        }

        public String getR1_2() {
            return r1_2;
        }

        public void setR1_2(String r1_2) {
            this.r1_2 = r1_2;
        }

        public String getR1_3() {
            return r1_3;
        }

        public void setR1_3(String r1_3) {
            this.r1_3 = r1_3;
        }

        public String getR1_4() {
            return r1_4;
        }

        public void setR1_4(String r1_4) {
            this.r1_4 = r1_4;
        }

        public String getR1_5() {
            return r1_5;
        }

        public void setR1_5(String r1_5) {
            this.r1_5 = r1_5;
        }

        public String getR2() {
            return r2;
        }

        public void setR2(String r2) {
            this.r2 = r2;
        }

        public String getR2_1() {
            return r2_1;
        }

        public void setR2_1(String r2_1) {
            this.r2_1 = r2_1;
        }

        public String getR2_2() {
            return r2_2;
        }

        public void setR2_2(String r2_2) {
            this.r2_2 = r2_2;
        }

        public String getR2_3() {
            return r2_3;
        }

        public void setR2_3(String r2_3) {
            this.r2_3 = r2_3;
        }

        public String getR2_4() {
            return r2_4;
        }

        public void setR2_4(String r2_4) {
            this.r2_4 = r2_4;
        }

        public String getR2_5() {
            return r2_5;
        }

        public void setR2_5(String r2_5) {
            this.r2_5 = r2_5;
        }

        public String getR3() {
            return r3;
        }

        public void setR3(String r3) {
            this.r3 = r3;
        }

        public String getR3_1() {
            return r3_1;
        }

        public void setR3_1(String r3_1) {
            this.r3_1 = r3_1;
        }

        public String getR3_2() {
            return r3_2;
        }

        public void setR3_2(String r3_2) {
            this.r3_2 = r3_2;
        }

        public String getR3_3() {
            return r3_3;
        }

        public void setR3_3(String r3_3) {
            this.r3_3 = r3_3;
        }

        public String getR3_4() {
            return r3_4;
        }

        public void setR3_4(String r3_4) {
            this.r3_4 = r3_4;
        }

        public String getR3_5() {
            return r3_5;
        }

        public void setR3_5(String r3_5) {
            this.r3_5 = r3_5;
        }

        public String getR4() {
            return r4;
        }

        public void setR4(String r4) {
            this.r4 = r4;
        }

        public String getR4_1() {
            return r4_1;
        }

        public void setR4_1(String r4_1) {
            this.r4_1 = r4_1;
        }

        public String getR4_2() {
            return r4_2;
        }

        public void setR4_2(String r4_2) {
            this.r4_2 = r4_2;
        }

        public String getR4_3() {
            return r4_3;
        }

        public void setR4_3(String r4_3) {
            this.r4_3 = r4_3;
        }

        public String getR4_4() {
            return r4_4;
        }

        public void setR4_4(String r4_4) {
            this.r4_4 = r4_4;
        }

        public String getR4_5() {
            return r4_5;
        }

        public void setR4_5(String r4_5) {
            this.r4_5 = r4_5;
        }

        public String getR5() {
            return r5;
        }

        public void setR5(String r5) {
            this.r5 = r5;
        }

        public String getR5_1() {
            return r5_1;
        }

        public void setR5_1(String r5_1) {
            this.r5_1 = r5_1;
        }

        public String getR5_2() {
            return r5_2;
        }

        public void setR5_2(String r5_2) {
            this.r5_2 = r5_2;
        }

        public String getR5_3() {
            return r5_3;
        }

        public void setR5_3(String r5_3) {
            this.r5_3 = r5_3;
        }

        public String getR5_4() {
            return r5_4;
        }

        public void setR5_4(String r5_4) {
            this.r5_4 = r5_4;
        }

        public String getR5_5() {
            return r5_5;
        }

        public void setR5_5(String r5_5) {
            this.r5_5 = r5_5;
        }

        public String getR6() {
            return r6;
        }

        public void setR6(String r6) {
            this.r6 = r6;
        }

        public String getR6_1() {
            return r6_1;
        }

        public void setR6_1(String r6_1) {
            this.r6_1 = r6_1;
        }

        public String getR6_2() {
            return r6_2;
        }

        public void setR6_2(String r6_2) {
            this.r6_2 = r6_2;
        }

        public String getR6_3() {
            return r6_3;
        }

        public void setR6_3(String r6_3) {
            this.r6_3 = r6_3;
        }

        public String getR6_4() {
            return r6_4;
        }

        public void setR6_4(String r6_4) {
            this.r6_4 = r6_4;
        }

        public String getR6_5() {
            return r6_5;
        }

        public void setR6_5(String r6_5) {
            this.r6_5 = r6_5;
        }

        public String getR7() {
            return r7;
        }

        public void setR7(String r7) {
            this.r7 = r7;
        }

        public String getR7_1() {
            return r7_1;
        }

        public void setR7_1(String r7_1) {
            this.r7_1 = r7_1;
        }

        public String getR7_2() {
            return r7_2;
        }

        public void setR7_2(String r7_2) {
            this.r7_2 = r7_2;
        }

        public String getR7_3() {
            return r7_3;
        }

        public void setR7_3(String r7_3) {
            this.r7_3 = r7_3;
        }

        public String getR7_4() {
            return r7_4;
        }

        public void setR7_4(String r7_4) {
            this.r7_4 = r7_4;
        }

        public String getR7_5() {
            return r7_5;
        }

        public void setR7_5(String r7_5) {
            this.r7_5 = r7_5;
        }

        public String getR8() {
            return r8;
        }

        public void setR8(String r8) {
            this.r8 = r8;
        }

        public String getR8_1() {
            return r8_1;
        }

        public void setR8_1(String r8_1) {
            this.r8_1 = r8_1;
        }

        public String getR8_2() {
            return r8_2;
        }

        public void setR8_2(String r8_2) {
            this.r8_2 = r8_2;
        }

        public String getR8_3() {
            return r8_3;
        }

        public void setR8_3(String r8_3) {
            this.r8_3 = r8_3;
        }

        public String getR8_4() {
            return r8_4;
        }

        public void setR8_4(String r8_4) {
            this.r8_4 = r8_4;
        }

        public String getR8_5() {
            return r8_5;
        }

        public void setR8_5(String r8_5) {
            this.r8_5 = r8_5;
        }

        public String getR9() {
            return r9;
        }

        public void setR9(String r9) {
            this.r9 = r9;
        }

        public String getR9_1() {
            return r9_1;
        }

        public void setR9_1(String r9_1) {
            this.r9_1 = r9_1;
        }

        public String getR9_2() {
            return r9_2;
        }

        public void setR9_2(String r9_2) {
            this.r9_2 = r9_2;
        }

        public String getR9_3() {
            return r9_3;
        }

        public void setR9_3(String r9_3) {
            this.r9_3 = r9_3;
        }

        public String getR9_4() {
            return r9_4;
        }

        public void setR9_4(String r9_4) {
            this.r9_4 = r9_4;
        }

        public String getR9_5() {
            return r9_5;
        }

        public void setR9_5(String r9_5) {
            this.r9_5 = r9_5;
        }

        public String getR10() {
            return r10;
        }

        public void setR10(String r10) {
            this.r10 = r10;
        }

        public String getR10_1() {
            return r10_1;
        }

        public void setR10_1(String r10_1) {
            this.r10_1 = r10_1;
        }

        public String getR10_2() {
            return r10_2;
        }

        public void setR10_2(String r10_2) {
            this.r10_2 = r10_2;
        }

        public String getR10_3() {
            return r10_3;
        }

        public void setR10_3(String r10_3) {
            this.r10_3 = r10_3;
        }

        public String getR10_4() {
            return r10_4;
        }

        public void setR10_4(String r10_4) {
            this.r10_4 = r10_4;
        }

        public String getR10_5() {
            return r10_5;
        }

        public void setR10_5(String r10_5) {
            this.r10_5 = r10_5;
        }

        public String getQ0() {
            return q0;
        }

        public void setQ0(String q0) {
            this.q0 = q0;
        }

        public String getQ0_1() {
            return q0_1;
        }

        public void setQ0_1(String q0_1) {
            this.q0_1 = q0_1;
        }

        public String getQ0_2() {
            return q0_2;
        }

        public void setQ0_2(String q0_2) {
            this.q0_2 = q0_2;
        }

        public String getQ0_3() {
            return q0_3;
        }

        public void setQ0_3(String q0_3) {
            this.q0_3 = q0_3;
        }

        public String getQ0_4() {
            return q0_4;
        }

        public void setQ0_4(String q0_4) {
            this.q0_4 = q0_4;
        }

        public String getQ0_5() {
            return q0_5;
        }

        public void setQ0_5(String q0_5) {
            this.q0_5 = q0_5;
        }

        public String getQ1() {
            return q1;
        }

        public void setQ1(String q1) {
            this.q1 = q1;
        }

        public String getQ1_1() {
            return q1_1;
        }

        public void setQ1_1(String q1_1) {
            this.q1_1 = q1_1;
        }

        public String getQ1_2() {
            return q1_2;
        }

        public void setQ1_2(String q1_2) {
            this.q1_2 = q1_2;
        }

        public String getQ2() {
            return q2;
        }

        public void setQ2(String q2) {
            this.q2 = q2;
        }

        public String getQ2_1() {
            return q2_1;
        }

        public void setQ2_1(String q2_1) {
            this.q2_1 = q2_1;
        }

        public String getQ2_2() {
            return q2_2;
        }

        public void setQ2_2(String q2_2) {
            this.q2_2 = q2_2;
        }

        public String getQ3() {
            return q3;
        }

        public void setQ3(String q3) {
            this.q3 = q3;
        }

        public String getQ3_1() {
            return q3_1;
        }

        public void setQ3_1(String q3_1) {
            this.q3_1 = q3_1;
        }

        public String getQ3_2() {
            return q3_2;
        }

        public void setQ3_2(String q3_2) {
            this.q3_2 = q3_2;
        }

        public String getQ4() {
            return q4;
        }

        public void setQ4(String q4) {
            this.q4 = q4;
        }

        public String getQ4_1() {
            return q4_1;
        }

        public void setQ4_1(String q4_1) {
            this.q4_1 = q4_1;
        }

        public String getQ4_2() {
            return q4_2;
        }

        public void setQ4_2(String q4_2) {
            this.q4_2 = q4_2;
        }

        public String getQ5() {
            return q5;
        }

        public void setQ5(String q5) {
            this.q5 = q5;
        }

        public String getQ5_1() {
            return q5_1;
        }

        public void setQ5_1(String q5_1) {
            this.q5_1 = q5_1;
        }

        public String getQ5_2() {
            return q5_2;
        }

        public void setQ5_2(String q5_2) {
            this.q5_2 = q5_2;
        }

        public String getQ6() {
            return q6;
        }

        public void setQ6(String q6) {
            this.q6 = q6;
        }

        public String getQ6_1() {
            return q6_1;
        }

        public void setQ6_1(String q6_1) {
            this.q6_1 = q6_1;
        }

        public String getQ6_2() {
            return q6_2;
        }

        public void setQ6_2(String q6_2) {
            this.q6_2 = q6_2;
        }

        public String getQ7() {
            return q7;
        }

        public void setQ7(String q7) {
            this.q7 = q7;
        }

        public String getQ7_1() {
            return q7_1;
        }

        public void setQ7_1(String q7_1) {
            this.q7_1 = q7_1;
        }

        public String getQ7_2() {
            return q7_2;
        }

        public void setQ7_2(String q7_2) {
            this.q7_2 = q7_2;
        }

        public String getQ8() {
            return q8;
        }

        public void setQ8(String q8) {
            this.q8 = q8;
        }

        public String getQ8_1() {
            return q8_1;
        }

        public void setQ8_1(String q8_1) {
            this.q8_1 = q8_1;
        }

        public String getQ8_2() {
            return q8_2;
        }

        public void setQ8_2(String q8_2) {
            this.q8_2 = q8_2;
        }

        public String getQ9() {
            return q9;
        }

        public void setQ9(String q9) {
            this.q9 = q9;
        }

        public String getQ9_1() {
            return q9_1;
        }

        public void setQ9_1(String q9_1) {
            this.q9_1 = q9_1;
        }

        public String getQ9_2() {
            return q9_2;
        }

        public void setQ9_2(String q9_2) {
            this.q9_2 = q9_2;
        }

        public String getQ10() {
            return q10;
        }

        public void setQ10(String q10) {
            this.q10 = q10;
        }

        public String getQ10_1() {
            return q10_1;
        }

        public void setQ10_1(String q10_1) {
            this.q10_1 = q10_1;
        }

        public String getQ10_2() {
            return q10_2;
        }

        public void setQ10_2(String q10_2) {
            this.q10_2 = q10_2;
        }
    }

    public static class TesterCaldataCheck {
        public final static String CALDATA = "caldata";
        @INISectionNode(name = CALDATA,isRequired = false)
        private String caldata;

        public String getCaldata() {
            return caldata;
        }

        public void setCaldata(String caldata) {
            this.caldata = caldata;
        }
    }

    public static class HardBinPass {
        public final static String PASS_BIN = "PASS_BIN";
        @INISectionNode(name = PASS_BIN,isRequired = false)
        private String passBin;

        public String getPassBin() {
            return passBin;
        }

        public void setPassBin(String passBin) {
            this.passBin = passBin;
        }
    }

    public static class SoftBinPass {
        public final static String PASS_BIN = "PASS_BIN";
        @INISectionNode(name = PASS_BIN,isRequired = false)
        private String passBin;

        public String getPassBin() {
            return passBin;
        }

        public void setPassBin(String passBin) {
            this.passBin = passBin;
        }
    }

    public static class HardBinAlarm {
        public final static String HardBin1 = "1";
        public final static String HardBin3 = "3";
        @INISectionNode(name = HardBin1,isRequired = false)
        private String hard1;
        @INISectionNode(name = HardBin3,isRequired = false)
        private String hard3;

        public String getHard1() {
            return hard1;
        }

        public void setHard1(String hard1) {
            this.hard1 = hard1;
        }

        public String getHard3() {
            return hard3;
        }

        public void setHard3(String hard3) {
            this.hard3 = hard3;
        }
    }

    public static class SoftBinAlarm {
        public final static String SoftBin101 = "101";
        @INISectionNode(name = SoftBin101,isRequired = false)
        private String soft101;

        public String getSoft101() {
            return soft101;
        }

        public void setSoft101(String soft101) {
            this.soft101 = soft101;
        }
    }

    public static class HardBinDefine {
        public final static String HardBin_1 = "1";
        public final static String HardBin_2 = "2";
        public final static String HardBin_3 = "3";
        @INISectionNode(name = HardBin_1,isRequired = false)
        private String hardBin1;
        @INISectionNode(name = HardBin_2,isRequired = false)
        private String hardBin2;
        @INISectionNode(name = HardBin_3,isRequired = false)
        private String hardBin3;

        public String getHardBin1() {
            return hardBin1;
        }

        public void setHardBin1(String hardBin1) {
            this.hardBin1 = hardBin1;
        }

        public String getHardBin2() {
            return hardBin2;
        }

        public void setHardBin2(String hardBin2) {
            this.hardBin2 = hardBin2;
        }

        public String getHardBin3() {
            return hardBin3;
        }

        public void setHardBin3(String hardBin3) {
            this.hardBin3 = hardBin3;
        }
    }

    public static class SoftBinDefine {
        public final static String SOFTBIN_1 = "1";
        public final static String SOFTBIN_2 = "2";
        public final static String SOFTBIN_3 = "3";
        public final static String SOFTBIN_4 = "4";
        public final static String SOFTBIN_5 = "5";
        public final static String SOFTBIN_6 = "6";
        public final static String SOFTBIN_7 = "7";
        public final static String SOFTBIN_8 = "8";
        public final static String SOFTBIN_9 = "9";
        public final static String SOFTBIN_10 = "10";
        public final static String SOFTBIN_11 = "11";
        public final static String SOFTBIN_12 = "12";
        public final static String SOFTBIN_13 = "13";
        public final static String SOFTBIN_14 = "14";
        public final static String SOFTBIN_15 = "15";
        public final static String SOFTBIN_16 = "16";
        public final static String SOFTBIN_17 = "17";
        public final static String SOFTBIN_18 = "18";
        public final static String SOFTBIN_19 = "19";
        public final static String SOFTBIN_20 = "20";
        public final static String SOFTBIN_21 = "21";
        public final static String SOFTBIN_22 = "22";
        public final static String SOFTBIN_23 = "23";
        public final static String SOFTBIN_24 = "24";
        public final static String SOFTBIN_25 = "25";
        public final static String SOFTBIN_26 = "26";
        public final static String SOFTBIN_27 = "27";
        public final static String SOFTBIN_28 = "28";
        public final static String SOFTBIN_29 = "29";
        public final static String SOFTBIN_30 = "30";
        public final static String SOFTBIN_31 = "31";
        public final static String SOFTBIN_32 = "32";
        public final static String SOFTBIN_33 = "33";
        public final static String SOFTBIN_34 = "34";
        public final static String SOFTBIN_35 = "35";
        public final static String SOFTBIN_36 = "36";
        public final static String SOFTBIN_38 = "38";
        public final static String SOFTBIN_39 = "39";
        public final static String SOFTBIN_40 = "40";
        public final static String SOFTBIN_41 = "41";
        public final static String SOFTBIN_42 = "42";
        public final static String SOFTBIN_43 = "43";
        public final static String SOFTBIN_44 = "44";
        public final static String SOFTBIN_45 = "45";
        public final static String SOFTBIN_46 = "46";
        public final static String SOFTBIN_47 = "47";
        public final static String SOFTBIN_48 = "48";
        public final static String SOFTBIN_49 = "49";
        public final static String SOFTBIN_50 = "50";
        public final static String SOFTBIN_51 = "51";
        public final static String SOFTBIN_52 = "52";
        public final static String SOFTBIN_53 = "53";
        public final static String SOFTBIN_54 = "54";
        public final static String SOFTBIN_55 = "55";
        public final static String SOFTBIN_56 = "56";
        public final static String SOFTBIN_57 = "57";
        public final static String SOFTBIN_58 = "58";
        public final static String SOFTBIN_59 = "59";
        public final static String SOFTBIN_60 = "60";
        public final static String SOFTBIN_61 = "61";
        public final static String SOFTBIN_62 = "62";
        public final static String SOFTBIN_63 = "63";
        public final static String SOFTBIN_64 = "64";
        public final static String SOFTBIN_65 = "65";
        public final static String SOFTBIN_66 = "66";
        public final static String SOFTBIN_67 = "67";
        public final static String SOFTBIN_68 = "68";
        public final static String SOFTBIN_69 = "69";
        public final static String SOFTBIN_70 = "70";
        public final static String SOFTBIN_75 = "75";
        public final static String SOFTBIN_86 = "86";
        public final static String SOFTBIN_87 = "87";
        public final static String SOFTBIN_89 = "89";
        public final static String SOFTBIN_90 = "90";
        public final static String SOFTBIN_91 = "91";
        public final static String SOFTBIN_93 = "93";
        public final static String SOFTBIN_94 = "94";
        public final static String SOFTBIN_95 = "95";
        public final static String SOFTBIN_96 = "96";
        public final static String SOFTBIN_2222 = "2222";
        public final static String SOFTBIN_5000 = "5000";
        public final static String SOFTBIN_5001 = "5001";
        public final static String SOFTBIN_5002 = "5002";
        public final static String SOFTBIN_5003 = "5003";
        public final static String SOFTBIN_5100 = "5100";
        public final static String SOFTBIN_5101 = "5101";
        public final static String SOFTBIN_5102 = "5102";
        public final static String SOFTBIN_5103 = "5103";
        public final static String SOFTBIN_5200 = "5200";
        public final static String SOFTBIN_5201 = "5201";
        public final static String SOFTBIN_5202 = "5202";
        public final static String SOFTBIN_5203 = "5203";
        public final static String SOFTBIN_5300 = "5300";
        public final static String SOFTBIN_5301 = "5301";
        public final static String SOFTBIN_5302 = "5302";
        public final static String SOFTBIN_5303 = "5303";
        public final static String SOFTBIN_5310 = "5310";
        public final static String SOFTBIN_5311 = "5311";
        public final static String SOFTBIN_5312 = "5312";
        public final static String SOFTBIN_5313 = "5313";
        public final static String SOFTBIN_5320 = "5320";
        public final static String SOFTBIN_5321 = "5321";
        public final static String SOFTBIN_5322 = "5322";
        public final static String SOFTBIN_5323 = "5323";
        public final static String SOFTBIN_5330 = "5330";
        public final static String SOFTBIN_5331 = "5331";
        public final static String SOFTBIN_5332 = "5332";
        public final static String SOFTBIN_5333 = "5333";
        public final static String SOFTBIN_5399 = "5399";
        public final static String SOFTBIN_5400 = "5400";
        public final static String SOFTBIN_5401 = "5401";
        public final static String SOFTBIN_5402 = "5402";
        public final static String SOFTBIN_5403 = "5403";
        public final static String SOFTBIN_6000 = "6000";
        public final static String SOFTBIN_6001 = "6001";
        public final static String SOFTBIN_6002 = "6002";
        public final static String SOFTBIN_7001 = "7001";
        public final static String SOFTBIN_7002 = "7002";
        public final static String SOFTBIN_7003 = "7003";
        public final static String SOFTBIN_7004 = "7004";
        public final static String SOFTBIN_7005 = "7005";
        public final static String SOFTBIN_7006 = "7006";
        public final static String SOFTBIN_7007 = "7007";
        public final static String SOFTBIN_7008 = "7008";
        public final static String SOFTBIN_7009 = "7009";
        public final static String SOFTBIN_7010 = "7010";
        public final static String SOFTBIN_7011 = "7011";
        public final static String SOFTBIN_7012 = "7012";
        public final static String SOFTBIN_7013 = "7013";
        public final static String SOFTBIN_7014 = "7014";
        public final static String SOFTBIN_7015 = "7015";
        public final static String SOFTBIN_7016 = "7016";
        public final static String SOFTBIN_7017 = "7017";
        public final static String SOFTBIN_7018 = "7018";
        public final static String SOFTBIN_7019 = "7019";
        public final static String SOFTBIN_9999 = "9999";
        @INISectionNode(name = SOFTBIN_1,isRequired = false)
        private String SoftBin_1;
        @INISectionNode(name = SOFTBIN_2,isRequired = false)
        private String SoftBin_2;
        @INISectionNode(name = SOFTBIN_3,isRequired = false)
        private String SoftBin_3;
        @INISectionNode(name = SOFTBIN_4,isRequired = false)
        private String SoftBin_4;
        @INISectionNode(name = SOFTBIN_5,isRequired = false)
        private String SoftBin_5;
        @INISectionNode(name = SOFTBIN_6,isRequired = false)
        private String SoftBin_6;
        @INISectionNode(name = SOFTBIN_7,isRequired = false)
        private String SoftBin_7;
        @INISectionNode(name = SOFTBIN_8,isRequired = false)
        private String SoftBin_8;
        @INISectionNode(name = SOFTBIN_9,isRequired = false)
        private String SoftBin_9;
        @INISectionNode(name = SOFTBIN_10,isRequired = false)
        private String SoftBin_10;
        @INISectionNode(name = SOFTBIN_11,isRequired = false)
        private String SoftBin_11;
        @INISectionNode(name = SOFTBIN_12,isRequired = false)
        private String SoftBin_12;
        @INISectionNode(name = SOFTBIN_13,isRequired = false)
        private String SoftBin_13;
        @INISectionNode(name = SOFTBIN_14,isRequired = false)
        private String SoftBin_14;
        @INISectionNode(name = SOFTBIN_15,isRequired = false)
        private String SoftBin_15;
        @INISectionNode(name = SOFTBIN_16,isRequired = false)
        private String SoftBin_16;
        @INISectionNode(name = SOFTBIN_17,isRequired = false)
        private String SoftBin_17;
        @INISectionNode(name = SOFTBIN_18,isRequired = false)
        private String SoftBin_18;
        @INISectionNode(name = SOFTBIN_19,isRequired = false)
        private String SoftBin_19;
        @INISectionNode(name = SOFTBIN_20,isRequired = false)
        private String SoftBin_20;
        @INISectionNode(name = SOFTBIN_21,isRequired = false)
        private String SoftBin_21;
        @INISectionNode(name = SOFTBIN_22,isRequired = false)
        private String SoftBin_22;
        @INISectionNode(name = SOFTBIN_23,isRequired = false)
        private String SoftBin_23;
        @INISectionNode(name = SOFTBIN_24,isRequired = false)
        private String SoftBin_24;
        @INISectionNode(name = SOFTBIN_25,isRequired = false)
        private String SoftBin_25;
        @INISectionNode(name = SOFTBIN_26,isRequired = false)
        private String SoftBin_26;
        @INISectionNode(name = SOFTBIN_27,isRequired = false)
        private String SoftBin_27;
        @INISectionNode(name = SOFTBIN_28,isRequired = false)
        private String SoftBin_28;
        @INISectionNode(name = SOFTBIN_29,isRequired = false)
        private String SoftBin_29;
        @INISectionNode(name = SOFTBIN_30,isRequired = false)
        private String SoftBin_30;
        @INISectionNode(name = SOFTBIN_31,isRequired = false)
        private String SoftBin_31;
        @INISectionNode(name = SOFTBIN_32,isRequired = false)
        private String SoftBin_32;
        @INISectionNode(name = SOFTBIN_33,isRequired = false)
        private String SoftBin_33;
        @INISectionNode(name = SOFTBIN_34,isRequired = false)
        private String SoftBin_34;
        @INISectionNode(name = SOFTBIN_35,isRequired = false)
        private String SoftBin_35;
        @INISectionNode(name = SOFTBIN_36,isRequired = false)
        private String SoftBin_36;
        @INISectionNode(name = SOFTBIN_38,isRequired = false)
        private String SoftBin_38;
        @INISectionNode(name = SOFTBIN_39,isRequired = false)
        private String SoftBin_39;
        @INISectionNode(name = SOFTBIN_40,isRequired = false)
        private String SoftBin_40;
        @INISectionNode(name = SOFTBIN_41,isRequired = false)
        private String SoftBin_41;
        @INISectionNode(name = SOFTBIN_42,isRequired = false)
        private String SoftBin_42;
        @INISectionNode(name = SOFTBIN_43,isRequired = false)
        private String SoftBin_43;
        @INISectionNode(name = SOFTBIN_44,isRequired = false)
        private String SoftBin_44;
        @INISectionNode(name = SOFTBIN_45,isRequired = false)
        private String SoftBin_45;
        @INISectionNode(name = SOFTBIN_46,isRequired = false)
        private String SoftBin_46;
        @INISectionNode(name = SOFTBIN_47,isRequired = false)
        private String SoftBin_47;
        @INISectionNode(name = SOFTBIN_48,isRequired = false)
        private String SoftBin_48;
        @INISectionNode(name = SOFTBIN_49,isRequired = false)
        private String SoftBin_49;
        @INISectionNode(name = SOFTBIN_50,isRequired = false)
        private String SoftBin_50;
        @INISectionNode(name = SOFTBIN_51,isRequired = false)
        private String SoftBin_51;
        @INISectionNode(name = SOFTBIN_52,isRequired = false)
        private String SoftBin_52;
        @INISectionNode(name = SOFTBIN_53,isRequired = false)
        private String SoftBin_53;
        @INISectionNode(name = SOFTBIN_54,isRequired = false)
        private String SoftBin_54;
        @INISectionNode(name = SOFTBIN_55,isRequired = false)
        private String SoftBin_55;
        @INISectionNode(name = SOFTBIN_56,isRequired = false)
        private String SoftBin_56;
        @INISectionNode(name = SOFTBIN_57,isRequired = false)
        private String SoftBin_57;
        @INISectionNode(name = SOFTBIN_58,isRequired = false)
        private String SoftBin_58;
        @INISectionNode(name = SOFTBIN_59,isRequired = false)
        private String SoftBin_59;
        @INISectionNode(name = SOFTBIN_60,isRequired = false)
        private String SoftBin_60;
        @INISectionNode(name = SOFTBIN_61,isRequired = false)
        private String SoftBin_61;
        @INISectionNode(name = SOFTBIN_62,isRequired = false)
        private String SoftBin_62;
        @INISectionNode(name = SOFTBIN_63,isRequired = false)
        private String SoftBin_63;
        @INISectionNode(name = SOFTBIN_64,isRequired = false)
        private String SoftBin_64;
        @INISectionNode(name = SOFTBIN_65,isRequired = false)
        private String SoftBin_65;
        @INISectionNode(name = SOFTBIN_66,isRequired = false)
        private String SoftBin_66;
        @INISectionNode(name = SOFTBIN_67,isRequired = false)
        private String SoftBin_67;
        @INISectionNode(name = SOFTBIN_68,isRequired = false)
        private String SoftBin_68;
        @INISectionNode(name = SOFTBIN_69,isRequired = false)
        private String SoftBin_69;
        @INISectionNode(name = SOFTBIN_70,isRequired = false)
        private String SoftBin_70;
        @INISectionNode(name = SOFTBIN_75,isRequired = false)
        private String SoftBin_75;
        @INISectionNode(name = SOFTBIN_86,isRequired = false)
        private String SoftBin_86;
        @INISectionNode(name = SOFTBIN_87,isRequired = false)
        private String SoftBin_87;
        @INISectionNode(name = SOFTBIN_89,isRequired = false)
        private String SoftBin_89;
        @INISectionNode(name = SOFTBIN_90,isRequired = false)
        private String SoftBin_90;
        @INISectionNode(name = SOFTBIN_91,isRequired = false)
        private String SoftBin_91;
        @INISectionNode(name = SOFTBIN_93,isRequired = false)
        private String SoftBin_93;
        @INISectionNode(name = SOFTBIN_94,isRequired = false)
        private String SoftBin_94;
        @INISectionNode(name = SOFTBIN_95,isRequired = false)
        private String SoftBin_95;
        @INISectionNode(name = SOFTBIN_96,isRequired = false)
        private String SoftBin_96;
        @INISectionNode(name = SOFTBIN_2222,isRequired = false)
        private String SoftBin_2222;
        @INISectionNode(name = SOFTBIN_5000,isRequired = false)
        private String SoftBin_5000;
        @INISectionNode(name = SOFTBIN_5001,isRequired = false)
        private String SoftBin_5001;
        @INISectionNode(name = SOFTBIN_5002,isRequired = false)
        private String SoftBin_5002;
        @INISectionNode(name = SOFTBIN_5003,isRequired = false)
        private String SoftBin_5003;
        @INISectionNode(name = SOFTBIN_5100,isRequired = false)
        private String SoftBin_5100;
        @INISectionNode(name = SOFTBIN_5101,isRequired = false)
        private String SoftBin_5101;
        @INISectionNode(name = SOFTBIN_5102,isRequired = false)
        private String SoftBin_5102;
        @INISectionNode(name = SOFTBIN_5103,isRequired = false)
        private String SoftBin_5103;
        @INISectionNode(name = SOFTBIN_5200,isRequired = false)
        private String SoftBin_5200;
        @INISectionNode(name = SOFTBIN_5201,isRequired = false)
        private String SoftBin_5201;
        @INISectionNode(name = SOFTBIN_5202,isRequired = false)
        private String SoftBin_5202;
        @INISectionNode(name = SOFTBIN_5203,isRequired = false)
        private String SoftBin_5203;
        @INISectionNode(name = SOFTBIN_5300,isRequired = false)
        private String SoftBin_5300;
        @INISectionNode(name = SOFTBIN_5301,isRequired = false)
        private String SoftBin_5301;
        @INISectionNode(name = SOFTBIN_5302,isRequired = false)
        private String SoftBin_5302;
        @INISectionNode(name = SOFTBIN_5303,isRequired = false)
        private String SoftBin_5303;
        @INISectionNode(name = SOFTBIN_5310,isRequired = false)
        private String SoftBin_5310;
        @INISectionNode(name = SOFTBIN_5311,isRequired = false)
        private String SoftBin_5311;
        @INISectionNode(name = SOFTBIN_5312,isRequired = false)
        private String SoftBin_5312;
        @INISectionNode(name = SOFTBIN_5313,isRequired = false)
        private String SoftBin_5313;
        @INISectionNode(name = SOFTBIN_5320,isRequired = false)
        private String SoftBin_5320;
        @INISectionNode(name = SOFTBIN_5321,isRequired = false)
        private String SoftBin_5321;
        @INISectionNode(name = SOFTBIN_5322,isRequired = false)
        private String SoftBin_5322;
        @INISectionNode(name = SOFTBIN_5323,isRequired = false)
        private String SoftBin_5323;
        @INISectionNode(name = SOFTBIN_5330,isRequired = false)
        private String SoftBin_5330;
        @INISectionNode(name = SOFTBIN_5331,isRequired = false)
        private String SoftBin_5331;
        @INISectionNode(name = SOFTBIN_5332,isRequired = false)
        private String SoftBin_5332;
        @INISectionNode(name = SOFTBIN_5333,isRequired = false)
        private String SoftBin_5333;
        @INISectionNode(name = SOFTBIN_5399,isRequired = false)
        private String SoftBin_5399;
        @INISectionNode(name = SOFTBIN_5400,isRequired = false)
        private String SoftBin_5400;
        @INISectionNode(name = SOFTBIN_5401,isRequired = false)
        private String SoftBin_5401;
        @INISectionNode(name = SOFTBIN_5402,isRequired = false)
        private String SoftBin_5402;
        @INISectionNode(name = SOFTBIN_5403,isRequired = false)
        private String SoftBin_5403;
        @INISectionNode(name = SOFTBIN_6000,isRequired = false)
        private String SoftBin_6000;
        @INISectionNode(name = SOFTBIN_6001,isRequired = false)
        private String SoftBin_6001;
        @INISectionNode(name = SOFTBIN_6002,isRequired = false)
        private String SoftBin_6002;
        @INISectionNode(name = SOFTBIN_7001,isRequired = false)
        private String SoftBin_7001;
        @INISectionNode(name = SOFTBIN_7002,isRequired = false)
        private String SoftBin_7002;
        @INISectionNode(name = SOFTBIN_7003,isRequired = false)
        private String SoftBin_7003;
        @INISectionNode(name = SOFTBIN_7004,isRequired = false)
        private String SoftBin_7004;
        @INISectionNode(name = SOFTBIN_7005,isRequired = false)
        private String SoftBin_7005;
        @INISectionNode(name = SOFTBIN_7006,isRequired = false)
        private String SoftBin_7006;
        @INISectionNode(name = SOFTBIN_7007,isRequired = false)
        private String SoftBin_7007;
        @INISectionNode(name = SOFTBIN_7008,isRequired = false)
        private String SoftBin_7008;
        @INISectionNode(name = SOFTBIN_7009,isRequired = false)
        private String SoftBin_7009;
        @INISectionNode(name = SOFTBIN_7010,isRequired = false)
        private String SoftBin_7010;
        @INISectionNode(name = SOFTBIN_7011,isRequired = false)
        private String SoftBin_7011;
        @INISectionNode(name = SOFTBIN_7012,isRequired = false)
        private String SoftBin_7012;
        @INISectionNode(name = SOFTBIN_7013,isRequired = false)
        private String SoftBin_7013;
        @INISectionNode(name = SOFTBIN_7014,isRequired = false)
        private String SoftBin_7014;
        @INISectionNode(name = SOFTBIN_7015,isRequired = false)
        private String SoftBin_7015;
        @INISectionNode(name = SOFTBIN_7016,isRequired = false)
        private String SoftBin_7016;
        @INISectionNode(name = SOFTBIN_7017,isRequired = false)
        private String SoftBin_7017;
        @INISectionNode(name = SOFTBIN_7018,isRequired = false)
        private String SoftBin_7018;
        @INISectionNode(name = SOFTBIN_7019,isRequired = false)
        private String SoftBin_7019;
        @INISectionNode(name = SOFTBIN_9999,isRequired = false)
        private String SoftBin_9999;

        public String getSoftBin_1() {
            return SoftBin_1;
        }

        public void setSoftBin_1(String softBin_1) {
            SoftBin_1 = softBin_1;
        }

        public String getSoftBin_2() {
            return SoftBin_2;
        }

        public void setSoftBin_2(String softBin_2) {
            SoftBin_2 = softBin_2;
        }

        public String getSoftBin_3() {
            return SoftBin_3;
        }

        public void setSoftBin_3(String softBin_3) {
            SoftBin_3 = softBin_3;
        }

        public String getSoftBin_4() {
            return SoftBin_4;
        }

        public void setSoftBin_4(String softBin_4) {
            SoftBin_4 = softBin_4;
        }

        public String getSoftBin_5() {
            return SoftBin_5;
        }

        public void setSoftBin_5(String softBin_5) {
            SoftBin_5 = softBin_5;
        }

        public String getSoftBin_6() {
            return SoftBin_6;
        }

        public void setSoftBin_6(String softBin_6) {
            SoftBin_6 = softBin_6;
        }

        public String getSoftBin_7() {
            return SoftBin_7;
        }

        public void setSoftBin_7(String softBin_7) {
            SoftBin_7 = softBin_7;
        }

        public String getSoftBin_8() {
            return SoftBin_8;
        }

        public void setSoftBin_8(String softBin_8) {
            SoftBin_8 = softBin_8;
        }

        public String getSoftBin_9() {
            return SoftBin_9;
        }

        public void setSoftBin_9(String softBin_9) {
            SoftBin_9 = softBin_9;
        }

        public String getSoftBin_10() {
            return SoftBin_10;
        }

        public void setSoftBin_10(String softBin_10) {
            SoftBin_10 = softBin_10;
        }

        public String getSoftBin_11() {
            return SoftBin_11;
        }

        public void setSoftBin_11(String softBin_11) {
            SoftBin_11 = softBin_11;
        }

        public String getSoftBin_12() {
            return SoftBin_12;
        }

        public void setSoftBin_12(String softBin_12) {
            SoftBin_12 = softBin_12;
        }

        public String getSoftBin_13() {
            return SoftBin_13;
        }

        public void setSoftBin_13(String softBin_13) {
            SoftBin_13 = softBin_13;
        }

        public String getSoftBin_14() {
            return SoftBin_14;
        }

        public void setSoftBin_14(String softBin_14) {
            SoftBin_14 = softBin_14;
        }

        public String getSoftBin_15() {
            return SoftBin_15;
        }

        public void setSoftBin_15(String softBin_15) {
            SoftBin_15 = softBin_15;
        }

        public String getSoftBin_16() {
            return SoftBin_16;
        }

        public void setSoftBin_16(String softBin_16) {
            SoftBin_16 = softBin_16;
        }

        public String getSoftBin_17() {
            return SoftBin_17;
        }

        public void setSoftBin_17(String softBin_17) {
            SoftBin_17 = softBin_17;
        }

        public String getSoftBin_18() {
            return SoftBin_18;
        }

        public void setSoftBin_18(String softBin_18) {
            SoftBin_18 = softBin_18;
        }

        public String getSoftBin_19() {
            return SoftBin_19;
        }

        public void setSoftBin_19(String softBin_19) {
            SoftBin_19 = softBin_19;
        }

        public String getSoftBin_20() {
            return SoftBin_20;
        }

        public void setSoftBin_20(String softBin_20) {
            SoftBin_20 = softBin_20;
        }

        public String getSoftBin_21() {
            return SoftBin_21;
        }

        public void setSoftBin_21(String softBin_21) {
            SoftBin_21 = softBin_21;
        }

        public String getSoftBin_22() {
            return SoftBin_22;
        }

        public void setSoftBin_22(String softBin_22) {
            SoftBin_22 = softBin_22;
        }

        public String getSoftBin_23() {
            return SoftBin_23;
        }

        public void setSoftBin_23(String softBin_23) {
            SoftBin_23 = softBin_23;
        }

        public String getSoftBin_24() {
            return SoftBin_24;
        }

        public void setSoftBin_24(String softBin_24) {
            SoftBin_24 = softBin_24;
        }

        public String getSoftBin_25() {
            return SoftBin_25;
        }

        public void setSoftBin_25(String softBin_25) {
            SoftBin_25 = softBin_25;
        }

        public String getSoftBin_26() {
            return SoftBin_26;
        }

        public void setSoftBin_26(String softBin_26) {
            SoftBin_26 = softBin_26;
        }

        public String getSoftBin_27() {
            return SoftBin_27;
        }

        public void setSoftBin_27(String softBin_27) {
            SoftBin_27 = softBin_27;
        }

        public String getSoftBin_28() {
            return SoftBin_28;
        }

        public void setSoftBin_28(String softBin_28) {
            SoftBin_28 = softBin_28;
        }

        public String getSoftBin_29() {
            return SoftBin_29;
        }

        public void setSoftBin_29(String softBin_29) {
            SoftBin_29 = softBin_29;
        }

        public String getSoftBin_30() {
            return SoftBin_30;
        }

        public void setSoftBin_30(String softBin_30) {
            SoftBin_30 = softBin_30;
        }

        public String getSoftBin_31() {
            return SoftBin_31;
        }

        public void setSoftBin_31(String softBin_31) {
            SoftBin_31 = softBin_31;
        }

        public String getSoftBin_32() {
            return SoftBin_32;
        }

        public void setSoftBin_32(String softBin_32) {
            SoftBin_32 = softBin_32;
        }

        public String getSoftBin_33() {
            return SoftBin_33;
        }

        public void setSoftBin_33(String softBin_33) {
            SoftBin_33 = softBin_33;
        }

        public String getSoftBin_34() {
            return SoftBin_34;
        }

        public void setSoftBin_34(String softBin_34) {
            SoftBin_34 = softBin_34;
        }

        public String getSoftBin_35() {
            return SoftBin_35;
        }

        public void setSoftBin_35(String softBin_35) {
            SoftBin_35 = softBin_35;
        }

        public String getSoftBin_36() {
            return SoftBin_36;
        }

        public void setSoftBin_36(String softBin_36) {
            SoftBin_36 = softBin_36;
        }

        public String getSoftBin_38() {
            return SoftBin_38;
        }

        public void setSoftBin_38(String softBin_38) {
            SoftBin_38 = softBin_38;
        }

        public String getSoftBin_39() {
            return SoftBin_39;
        }

        public void setSoftBin_39(String softBin_39) {
            SoftBin_39 = softBin_39;
        }

        public String getSoftBin_40() {
            return SoftBin_40;
        }

        public void setSoftBin_40(String softBin_40) {
            SoftBin_40 = softBin_40;
        }

        public String getSoftBin_41() {
            return SoftBin_41;
        }

        public void setSoftBin_41(String softBin_41) {
            SoftBin_41 = softBin_41;
        }

        public String getSoftBin_42() {
            return SoftBin_42;
        }

        public void setSoftBin_42(String softBin_42) {
            SoftBin_42 = softBin_42;
        }

        public String getSoftBin_43() {
            return SoftBin_43;
        }

        public void setSoftBin_43(String softBin_43) {
            SoftBin_43 = softBin_43;
        }

        public String getSoftBin_44() {
            return SoftBin_44;
        }

        public void setSoftBin_44(String softBin_44) {
            SoftBin_44 = softBin_44;
        }

        public String getSoftBin_45() {
            return SoftBin_45;
        }

        public void setSoftBin_45(String softBin_45) {
            SoftBin_45 = softBin_45;
        }

        public String getSoftBin_46() {
            return SoftBin_46;
        }

        public void setSoftBin_46(String softBin_46) {
            SoftBin_46 = softBin_46;
        }

        public String getSoftBin_47() {
            return SoftBin_47;
        }

        public void setSoftBin_47(String softBin_47) {
            SoftBin_47 = softBin_47;
        }

        public String getSoftBin_48() {
            return SoftBin_48;
        }

        public void setSoftBin_48(String softBin_48) {
            SoftBin_48 = softBin_48;
        }

        public String getSoftBin_49() {
            return SoftBin_49;
        }

        public void setSoftBin_49(String softBin_49) {
            SoftBin_49 = softBin_49;
        }

        public String getSoftBin_50() {
            return SoftBin_50;
        }

        public void setSoftBin_50(String softBin_50) {
            SoftBin_50 = softBin_50;
        }

        public String getSoftBin_51() {
            return SoftBin_51;
        }

        public void setSoftBin_51(String softBin_51) {
            SoftBin_51 = softBin_51;
        }

        public String getSoftBin_52() {
            return SoftBin_52;
        }

        public void setSoftBin_52(String softBin_52) {
            SoftBin_52 = softBin_52;
        }

        public String getSoftBin_53() {
            return SoftBin_53;
        }

        public void setSoftBin_53(String softBin_53) {
            SoftBin_53 = softBin_53;
        }

        public String getSoftBin_54() {
            return SoftBin_54;
        }

        public void setSoftBin_54(String softBin_54) {
            SoftBin_54 = softBin_54;
        }

        public String getSoftBin_55() {
            return SoftBin_55;
        }

        public void setSoftBin_55(String softBin_55) {
            SoftBin_55 = softBin_55;
        }

        public String getSoftBin_56() {
            return SoftBin_56;
        }

        public void setSoftBin_56(String softBin_56) {
            SoftBin_56 = softBin_56;
        }

        public String getSoftBin_57() {
            return SoftBin_57;
        }

        public void setSoftBin_57(String softBin_57) {
            SoftBin_57 = softBin_57;
        }

        public String getSoftBin_58() {
            return SoftBin_58;
        }

        public void setSoftBin_58(String softBin_58) {
            SoftBin_58 = softBin_58;
        }

        public String getSoftBin_59() {
            return SoftBin_59;
        }

        public void setSoftBin_59(String softBin_59) {
            SoftBin_59 = softBin_59;
        }

        public String getSoftBin_60() {
            return SoftBin_60;
        }

        public void setSoftBin_60(String softBin_60) {
            SoftBin_60 = softBin_60;
        }

        public String getSoftBin_61() {
            return SoftBin_61;
        }

        public void setSoftBin_61(String softBin_61) {
            SoftBin_61 = softBin_61;
        }

        public String getSoftBin_62() {
            return SoftBin_62;
        }

        public void setSoftBin_62(String softBin_62) {
            SoftBin_62 = softBin_62;
        }

        public String getSoftBin_63() {
            return SoftBin_63;
        }

        public void setSoftBin_63(String softBin_63) {
            SoftBin_63 = softBin_63;
        }

        public String getSoftBin_64() {
            return SoftBin_64;
        }

        public void setSoftBin_64(String softBin_64) {
            SoftBin_64 = softBin_64;
        }

        public String getSoftBin_65() {
            return SoftBin_65;
        }

        public void setSoftBin_65(String softBin_65) {
            SoftBin_65 = softBin_65;
        }

        public String getSoftBin_66() {
            return SoftBin_66;
        }

        public void setSoftBin_66(String softBin_66) {
            SoftBin_66 = softBin_66;
        }

        public String getSoftBin_67() {
            return SoftBin_67;
        }

        public void setSoftBin_67(String softBin_67) {
            SoftBin_67 = softBin_67;
        }

        public String getSoftBin_68() {
            return SoftBin_68;
        }

        public void setSoftBin_68(String softBin_68) {
            SoftBin_68 = softBin_68;
        }

        public String getSoftBin_69() {
            return SoftBin_69;
        }

        public void setSoftBin_69(String softBin_69) {
            SoftBin_69 = softBin_69;
        }

        public String getSoftBin_70() {
            return SoftBin_70;
        }

        public void setSoftBin_70(String softBin_70) {
            SoftBin_70 = softBin_70;
        }

        public String getSoftBin_75() {
            return SoftBin_75;
        }

        public void setSoftBin_75(String softBin_75) {
            SoftBin_75 = softBin_75;
        }

        public String getSoftBin_86() {
            return SoftBin_86;
        }

        public void setSoftBin_86(String softBin_86) {
            SoftBin_86 = softBin_86;
        }

        public String getSoftBin_87() {
            return SoftBin_87;
        }

        public void setSoftBin_87(String softBin_87) {
            SoftBin_87 = softBin_87;
        }

        public String getSoftBin_89() {
            return SoftBin_89;
        }

        public void setSoftBin_89(String softBin_89) {
            SoftBin_89 = softBin_89;
        }

        public String getSoftBin_90() {
            return SoftBin_90;
        }

        public void setSoftBin_90(String softBin_90) {
            SoftBin_90 = softBin_90;
        }

        public String getSoftBin_91() {
            return SoftBin_91;
        }

        public void setSoftBin_91(String softBin_91) {
            SoftBin_91 = softBin_91;
        }

        public String getSoftBin_93() {
            return SoftBin_93;
        }

        public void setSoftBin_93(String softBin_93) {
            SoftBin_93 = softBin_93;
        }

        public String getSoftBin_94() {
            return SoftBin_94;
        }

        public void setSoftBin_94(String softBin_94) {
            SoftBin_94 = softBin_94;
        }

        public String getSoftBin_95() {
            return SoftBin_95;
        }

        public void setSoftBin_95(String softBin_95) {
            SoftBin_95 = softBin_95;
        }

        public String getSoftBin_96() {
            return SoftBin_96;
        }

        public void setSoftBin_96(String softBin_96) {
            SoftBin_96 = softBin_96;
        }

        public String getSoftBin_2222() {
            return SoftBin_2222;
        }

        public void setSoftBin_2222(String softBin_2222) {
            SoftBin_2222 = softBin_2222;
        }

        public String getSoftBin_5000() {
            return SoftBin_5000;
        }

        public void setSoftBin_5000(String softBin_5000) {
            SoftBin_5000 = softBin_5000;
        }

        public String getSoftBin_5001() {
            return SoftBin_5001;
        }

        public void setSoftBin_5001(String softBin_5001) {
            SoftBin_5001 = softBin_5001;
        }

        public String getSoftBin_5002() {
            return SoftBin_5002;
        }

        public void setSoftBin_5002(String softBin_5002) {
            SoftBin_5002 = softBin_5002;
        }

        public String getSoftBin_5003() {
            return SoftBin_5003;
        }

        public void setSoftBin_5003(String softBin_5003) {
            SoftBin_5003 = softBin_5003;
        }

        public String getSoftBin_5100() {
            return SoftBin_5100;
        }

        public void setSoftBin_5100(String softBin_5100) {
            SoftBin_5100 = softBin_5100;
        }

        public String getSoftBin_5101() {
            return SoftBin_5101;
        }

        public void setSoftBin_5101(String softBin_5101) {
            SoftBin_5101 = softBin_5101;
        }

        public String getSoftBin_5102() {
            return SoftBin_5102;
        }

        public void setSoftBin_5102(String softBin_5102) {
            SoftBin_5102 = softBin_5102;
        }

        public String getSoftBin_5103() {
            return SoftBin_5103;
        }

        public void setSoftBin_5103(String softBin_5103) {
            SoftBin_5103 = softBin_5103;
        }

        public String getSoftBin_5200() {
            return SoftBin_5200;
        }

        public void setSoftBin_5200(String softBin_5200) {
            SoftBin_5200 = softBin_5200;
        }

        public String getSoftBin_5201() {
            return SoftBin_5201;
        }

        public void setSoftBin_5201(String softBin_5201) {
            SoftBin_5201 = softBin_5201;
        }

        public String getSoftBin_5202() {
            return SoftBin_5202;
        }

        public void setSoftBin_5202(String softBin_5202) {
            SoftBin_5202 = softBin_5202;
        }

        public String getSoftBin_5203() {
            return SoftBin_5203;
        }

        public void setSoftBin_5203(String softBin_5203) {
            SoftBin_5203 = softBin_5203;
        }

        public String getSoftBin_5300() {
            return SoftBin_5300;
        }

        public void setSoftBin_5300(String softBin_5300) {
            SoftBin_5300 = softBin_5300;
        }

        public String getSoftBin_5301() {
            return SoftBin_5301;
        }

        public void setSoftBin_5301(String softBin_5301) {
            SoftBin_5301 = softBin_5301;
        }

        public String getSoftBin_5302() {
            return SoftBin_5302;
        }

        public void setSoftBin_5302(String softBin_5302) {
            SoftBin_5302 = softBin_5302;
        }

        public String getSoftBin_5303() {
            return SoftBin_5303;
        }

        public void setSoftBin_5303(String softBin_5303) {
            SoftBin_5303 = softBin_5303;
        }

        public String getSoftBin_5310() {
            return SoftBin_5310;
        }

        public void setSoftBin_5310(String softBin_5310) {
            SoftBin_5310 = softBin_5310;
        }

        public String getSoftBin_5311() {
            return SoftBin_5311;
        }

        public void setSoftBin_5311(String softBin_5311) {
            SoftBin_5311 = softBin_5311;
        }

        public String getSoftBin_5312() {
            return SoftBin_5312;
        }

        public void setSoftBin_5312(String softBin_5312) {
            SoftBin_5312 = softBin_5312;
        }

        public String getSoftBin_5313() {
            return SoftBin_5313;
        }

        public void setSoftBin_5313(String softBin_5313) {
            SoftBin_5313 = softBin_5313;
        }

        public String getSoftBin_5320() {
            return SoftBin_5320;
        }

        public void setSoftBin_5320(String softBin_5320) {
            SoftBin_5320 = softBin_5320;
        }

        public String getSoftBin_5321() {
            return SoftBin_5321;
        }

        public void setSoftBin_5321(String softBin_5321) {
            SoftBin_5321 = softBin_5321;
        }

        public String getSoftBin_5322() {
            return SoftBin_5322;
        }

        public void setSoftBin_5322(String softBin_5322) {
            SoftBin_5322 = softBin_5322;
        }

        public String getSoftBin_5323() {
            return SoftBin_5323;
        }

        public void setSoftBin_5323(String softBin_5323) {
            SoftBin_5323 = softBin_5323;
        }

        public String getSoftBin_5330() {
            return SoftBin_5330;
        }

        public void setSoftBin_5330(String softBin_5330) {
            SoftBin_5330 = softBin_5330;
        }

        public String getSoftBin_5331() {
            return SoftBin_5331;
        }

        public void setSoftBin_5331(String softBin_5331) {
            SoftBin_5331 = softBin_5331;
        }

        public String getSoftBin_5332() {
            return SoftBin_5332;
        }

        public void setSoftBin_5332(String softBin_5332) {
            SoftBin_5332 = softBin_5332;
        }

        public String getSoftBin_5333() {
            return SoftBin_5333;
        }

        public void setSoftBin_5333(String softBin_5333) {
            SoftBin_5333 = softBin_5333;
        }

        public String getSoftBin_5399() {
            return SoftBin_5399;
        }

        public void setSoftBin_5399(String softBin_5399) {
            SoftBin_5399 = softBin_5399;
        }

        public String getSoftBin_5400() {
            return SoftBin_5400;
        }

        public void setSoftBin_5400(String softBin_5400) {
            SoftBin_5400 = softBin_5400;
        }

        public String getSoftBin_5401() {
            return SoftBin_5401;
        }

        public void setSoftBin_5401(String softBin_5401) {
            SoftBin_5401 = softBin_5401;
        }

        public String getSoftBin_5402() {
            return SoftBin_5402;
        }

        public void setSoftBin_5402(String softBin_5402) {
            SoftBin_5402 = softBin_5402;
        }

        public String getSoftBin_5403() {
            return SoftBin_5403;
        }

        public void setSoftBin_5403(String softBin_5403) {
            SoftBin_5403 = softBin_5403;
        }

        public String getSoftBin_6000() {
            return SoftBin_6000;
        }

        public void setSoftBin_6000(String softBin_6000) {
            SoftBin_6000 = softBin_6000;
        }

        public String getSoftBin_6001() {
            return SoftBin_6001;
        }

        public void setSoftBin_6001(String softBin_6001) {
            SoftBin_6001 = softBin_6001;
        }

        public String getSoftBin_6002() {
            return SoftBin_6002;
        }

        public void setSoftBin_6002(String softBin_6002) {
            SoftBin_6002 = softBin_6002;
        }

        public String getSoftBin_7001() {
            return SoftBin_7001;
        }

        public void setSoftBin_7001(String softBin_7001) {
            SoftBin_7001 = softBin_7001;
        }

        public String getSoftBin_7002() {
            return SoftBin_7002;
        }

        public void setSoftBin_7002(String softBin_7002) {
            SoftBin_7002 = softBin_7002;
        }

        public String getSoftBin_7003() {
            return SoftBin_7003;
        }

        public void setSoftBin_7003(String softBin_7003) {
            SoftBin_7003 = softBin_7003;
        }

        public String getSoftBin_7004() {
            return SoftBin_7004;
        }

        public void setSoftBin_7004(String softBin_7004) {
            SoftBin_7004 = softBin_7004;
        }

        public String getSoftBin_7005() {
            return SoftBin_7005;
        }

        public void setSoftBin_7005(String softBin_7005) {
            SoftBin_7005 = softBin_7005;
        }

        public String getSoftBin_7006() {
            return SoftBin_7006;
        }

        public void setSoftBin_7006(String softBin_7006) {
            SoftBin_7006 = softBin_7006;
        }

        public String getSoftBin_7007() {
            return SoftBin_7007;
        }

        public void setSoftBin_7007(String softBin_7007) {
            SoftBin_7007 = softBin_7007;
        }

        public String getSoftBin_7008() {
            return SoftBin_7008;
        }

        public void setSoftBin_7008(String softBin_7008) {
            SoftBin_7008 = softBin_7008;
        }

        public String getSoftBin_7009() {
            return SoftBin_7009;
        }

        public void setSoftBin_7009(String softBin_7009) {
            SoftBin_7009 = softBin_7009;
        }

        public String getSoftBin_7010() {
            return SoftBin_7010;
        }

        public void setSoftBin_7010(String softBin_7010) {
            SoftBin_7010 = softBin_7010;
        }

        public String getSoftBin_7011() {
            return SoftBin_7011;
        }

        public void setSoftBin_7011(String softBin_7011) {
            SoftBin_7011 = softBin_7011;
        }

        public String getSoftBin_7012() {
            return SoftBin_7012;
        }

        public void setSoftBin_7012(String softBin_7012) {
            SoftBin_7012 = softBin_7012;
        }

        public String getSoftBin_7013() {
            return SoftBin_7013;
        }

        public void setSoftBin_7013(String softBin_7013) {
            SoftBin_7013 = softBin_7013;
        }

        public String getSoftBin_7014() {
            return SoftBin_7014;
        }

        public void setSoftBin_7014(String softBin_7014) {
            SoftBin_7014 = softBin_7014;
        }

        public String getSoftBin_7015() {
            return SoftBin_7015;
        }

        public void setSoftBin_7015(String softBin_7015) {
            SoftBin_7015 = softBin_7015;
        }

        public String getSoftBin_7016() {
            return SoftBin_7016;
        }

        public void setSoftBin_7016(String softBin_7016) {
            SoftBin_7016 = softBin_7016;
        }

        public String getSoftBin_7017() {
            return SoftBin_7017;
        }

        public void setSoftBin_7017(String softBin_7017) {
            SoftBin_7017 = softBin_7017;
        }

        public String getSoftBin_7018() {
            return SoftBin_7018;
        }

        public void setSoftBin_7018(String softBin_7018) {
            SoftBin_7018 = softBin_7018;
        }

        public String getSoftBin_7019() {
            return SoftBin_7019;
        }

        public void setSoftBin_7019(String softBin_7019) {
            SoftBin_7019 = softBin_7019;
        }

        public String getSoftBin_9999() {
            return SoftBin_9999;
        }

        public void setSoftBin_9999(String softBin_9999) {
            SoftBin_9999 = softBin_9999;
        }
    }
    public DatalogPath getDatalogPath() {
        return datalogPath;
    }

    public void setDatalogPath(DatalogPath datalogPath) {
        this.datalogPath = datalogPath;
    }

    public PackTestResult getPackTestResult() {
        return packTestResult;
    }

    public void setPackTestResult(PackTestResult packTestResult) {
        this.packTestResult = packTestResult;
    }

    public TestCodeConfig getTestCodeConfig() {
        return testCodeConfig;
    }

    public void setTestCodeConfig(TestCodeConfig testCodeConfig) {
        this.testCodeConfig = testCodeConfig;
    }

    public TesterCaldataCheck getTesterCaldataCheck() {
        return testerCaldataCheck;
    }

    public void setTesterCaldataCheck(TesterCaldataCheck testerCaldataCheck) {
        this.testerCaldataCheck = testerCaldataCheck;
    }

    public HardBinPass getHardBinPass() {
        return hardBinPass;
    }

    public void setHardBinPass(HardBinPass hardBinPass) {
        this.hardBinPass = hardBinPass;
    }

    public SoftBinPass getSoftBinPass() {
        return softBinPass;
    }

    public void setSoftBinPass(SoftBinPass softBinPass) {
        this.softBinPass = softBinPass;
    }

    public HardBinAlarm getHardBinAlarm() {
        return hardBinAlarm;
    }

    public void setHardBinAlarm(HardBinAlarm hardBinAlarm) {
        this.hardBinAlarm = hardBinAlarm;
    }

    public SoftBinAlarm getSoftBinAlarm() {
        return softBinAlarm;
    }

    public void setSoftBinAlarm(SoftBinAlarm softBinAlarm) {
        this.softBinAlarm = softBinAlarm;
    }

    public HardBinDefine getHardBinDefine() {
        return hardBinDefine;
    }

    public void setHardBinDefine(HardBinDefine hardBinDefine) {
        this.hardBinDefine = hardBinDefine;
    }

    public SoftBinDefine getSoftBinDefine() {
        return softBinDefine;
    }

    public void setSoftBinDefine(SoftBinDefine softBinDefine) {
        this.softBinDefine = softBinDefine;
    }

   /* public InputOi getInputOI() {
        return inputOI;
    }

    public void setInputOI(InputOi inputOI) {
        this.inputOI = inputOI;
    }*/

    public InputOiEntry getInputOITesterId() {
        return inputOITesterId;
    }

    public void setInputOITesterId(InputOiEntry inputOITesterId) {
        this.inputOITesterId = inputOITesterId;
    }

    public InputOiEntry getInputOIOperatorId() {
        return inputOIOperatorId;
    }

    public void setInputOIOperatorId(InputOiEntry inputOIOperatorId) {
        this.inputOIOperatorId = inputOIOperatorId;
    }

    public InputOiEntry getInputOICustomerId() {
        return inputOICustomerId;
    }

    public void setInputOICustomerId(InputOiEntry inputOICustomerId) {
        this.inputOICustomerId = inputOICustomerId;
    }

    public InputOiEntry getInputOIDeviceName() {
        return inputOIDeviceName;
    }

    public void setInputOIDeviceName(InputOiEntry inputOIDeviceName) {
        this.inputOIDeviceName = inputOIDeviceName;
    }

    public InputOiEntry getInputOILotNo() {
        return inputOILotNo;
    }

    public void setInputOILotNo(InputOiEntry inputOILotNo) {
        this.inputOILotNo = inputOILotNo;
    }

    public InputOiEntry getInputOISublot() {
        return inputOISublot;
    }

    public void setInputOISublot(InputOiEntry inputOISublot) {
        this.inputOISublot = inputOISublot;
    }

    public InputOiEntry getInputOIProgramName() {
        return inputOIProgramName;
    }

    public void setInputOIProgramName(InputOiEntry inputOIProgramName) {
        this.inputOIProgramName = inputOIProgramName;
    }

    public InputOiEntry getInputOIModeCode() {
        return inputOIModeCode;
    }

    public void setInputOIModeCode(InputOiEntry inputOIModeCode) {
        this.inputOIModeCode = inputOIModeCode;
    }

    public InputOiEntry getInputOITestCode() {
        return inputOITestCode;
    }

    public void setInputOITestCode(InputOiEntry inputOITestCode) {
        this.inputOITestCode = inputOITestCode;
    }

    public InputOiEntry getInputOITestBinNo() {
        return inputOITestBinNo;
    }

    public void setInputOITestBinNo(InputOiEntry inputOITestBinNo) {
        this.inputOITestBinNo = inputOITestBinNo;
    }

}
