package com.fhec.context;

/**
 * @author Archer.W
 * @date 2021/04/16 14:23
 **/
public class RecipeConfig  {
    private DatalogPath datalogPath;
    @Override
	public String toString() {
		return "RecipeConfig [datalogPath=" + datalogPath + ", hardBinAlarm=" + hardBinAlarm + ", hardBinDefine="
				+ hardBinDefine + ", hardBinPass=" + hardBinPass + ", packTestResult=" + packTestResult
				+ ", softBinAlarm=" + softBinAlarm + ", softBinDefine=" + softBinDefine + ", testCodeConfig="
				+ testCodeConfig + ", testerCaldataCheck=" + testerCaldataCheck + ", testConfig=" + testConfig
				+ ", inputOITesterId=" + inputOITesterId + ", inputOIOperatorId=" + inputOIOperatorId
				+ ", inputOICustomerId=" + inputOICustomerId + ", inputOIDeviceName=" + inputOIDeviceName
				+ ", inputOILotNo=" + inputOILotNo + ", inputOISublot=" + inputOISublot + ", inputOIProgramName="
				+ inputOIProgramName + ", inputOIModeCode=" + inputOIModeCode + ", inputOITestCode=" + inputOITestCode
				+ ", inputOITestBinNo=" + inputOITestBinNo + ", softBinPass=" + softBinPass + ", getSoftBinPass()="
				+ getSoftBinPass() + ", getInputOITesterId()=" + getInputOITesterId() + ", getInputOIOperatorId()="
				+ getInputOIOperatorId() + ", getInputOICustomerId()=" + getInputOICustomerId()
				+ ", getInputOIDeviceName()=" + getInputOIDeviceName() + ", getInputOILotNo()=" + getInputOILotNo()
				+ ", getInputOISublot()=" + getInputOISublot() + ", getInputOIProgramName()=" + getInputOIProgramName()
				+ ", getInputOIModeCode()=" + getInputOIModeCode() + ", getInputOITestCode()=" + getInputOITestCode()
				+ ", getInputOITestBinNo()=" + getInputOITestBinNo() + ", getDatalogPath()=" + getDatalogPath()
				+ ", getHardBinAlarm()=" + getHardBinAlarm() + ", getHardBinDefine()=" + getHardBinDefine()
				+ ", getHardBinPass()=" + getHardBinPass() + ", getPackTestResult()=" + getPackTestResult()
				+ ", getSoftBinAlarm()=" + getSoftBinAlarm() + ", getSoftBinDefine()=" + getSoftBinDefine()
				+ ", getTestCodeConfig()=" + getTestCodeConfig() + ", getTesterCaldataCheck()="
				+ getTesterCaldataCheck() + ", getTestConfig()=" + getTestConfig() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	private HardBinAlarm hardBinAlarm;
    private HardBinDefine hardBinDefine;
    private HardBinPass hardBinPass;
    private PackTestResult packTestResult;
    private SoftBinAlarm softBinAlarm;
    private SoftBinDefine softBinDefine;
    private TestCodeConfig testCodeConfig;
    private TesterCaldataCheck testerCaldataCheck;
    private TestConfig testConfig;

    private InputOiEntry inputOITesterId;

    private InputOiEntry inputOIOperatorId;

    private InputOiEntry inputOICustomerId;

    private InputOiEntry inputOIDeviceName;

    private InputOiEntry inputOILotNo;

    private InputOiEntry inputOISublot;

    private InputOiEntry inputOIProgramName;

    private InputOiEntry inputOIModeCode;

    private InputOiEntry inputOITestCode;

    private InputOiEntry inputOITestBinNo;
    private SoftBinPass softBinPass;

    
    
    public SoftBinPass getSoftBinPass() {
        return softBinPass;
    }

    public void setSoftBinPass(SoftBinPass softBinPass) {
        this.softBinPass = softBinPass;
    }

    public static class SoftBinPass {
        private String passBin;

        public String getPassBin() {
            return passBin;
        }

        public void setPassBin(String passBin) {
            this.passBin = passBin;
        }
    }

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

    public DatalogPath getDatalogPath() {
        return datalogPath;
    }

    public void setDatalogPath(DatalogPath datalogPath) {
        this.datalogPath = datalogPath;
    }

    public HardBinAlarm getHardBinAlarm() {
        return hardBinAlarm;
    }

    public void setHardBinAlarm(HardBinAlarm hardBinAlarm) {
        this.hardBinAlarm = hardBinAlarm;
    }

    public HardBinDefine getHardBinDefine() {
        return hardBinDefine;
    }

    public void setHardBinDefine(HardBinDefine hardBinDefine) {
        this.hardBinDefine = hardBinDefine;
    }

    public HardBinPass getHardBinPass() {
        return hardBinPass;
    }

    public void setHardBinPass(HardBinPass hardBinPass) {
        this.hardBinPass = hardBinPass;
    }

    public PackTestResult getPackTestResult() {
        return packTestResult;
    }

    public void setPackTestResult(PackTestResult packTestResult) {
        this.packTestResult = packTestResult;
    }

    public SoftBinAlarm getSoftBinAlarm() {
        return softBinAlarm;
    }

    public void setSoftBinAlarm(SoftBinAlarm softBinAlarm) {
        this.softBinAlarm = softBinAlarm;
    }

    public SoftBinDefine getSoftBinDefine() {
        return softBinDefine;
    }

    public void setSoftBinDefine(SoftBinDefine softBinDefine) {
        this.softBinDefine = softBinDefine;
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

    public TestConfig getTestConfig() {
        return testConfig;
    }

    public void setTestConfig(TestConfig testConfig) {
        this.testConfig = testConfig;
    }

    public static class TestConfig {
    }

    public static class DatalogPath {
        private String datalog_name_rule_1;
        private String datalog_name_rule_2;
        private String datalog_name_rule_3;
        private String datalog_name_rule_4;
        private String datalog_name_rule_5;
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

    public static class HardBinAlarm {
        /**
         * hard1 : (<95%)
         * hard3 : (>0.5%)
         */

        private String hard1;
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

    public static class HardBinDefine {
        /**
         * hardBin1 : PASS
         * hardBin2 : OS_failed
         * hardBin3 : Function_failed
         */

        private String hardBin1;
        private String hardBin2;
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

    public static class HardBinPass {
        /**
         * passBin : Bin1,Bin2
         */

        private String passBin;

        public String getPassBin() {
            return passBin;
        }

        public void setPassBin(String passBin) {
            this.passBin = passBin;
        }
    }

    public static class InputOiEntry {
        /**
         * index : 2
         * name : Customer_ID
         * pattern : ^[A-Z]+\S*$
         */

        private String index;
        private String name;
        private String pattern;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }
    }

    public static class InputOIDeviceName {
        /**
         * index : 3
         * name : Device_Name
         * pattern : ^.+$
         */

        private String index;
        private String name;
        private String pattern;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }
    }

    public static class InputOILotNo {
        /**
         * index : 4
         * name : Customer_LotNo
         * pattern : ^.+$
         */

        private String index;
        private String name;
        private String pattern;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }
    }

    public static class InputOIModeCode {
        /**
         * index : 7
         * name : Mode_Code
         * pattern : ^FT1$
         */

        private String index;
        private String name;
        private String pattern;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }
    }

    public static class InputOIOperatorId {
        /**
         * index : 1
         * name : Operator_ID
         * pattern : ^[A-Z]|[0-9]+\S*$
         */

        private String index;
        private String name;
        private String pattern;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }
    }

    public static class InputOIProgramName {
        /**
         * index : 6
         * name : Program_Name
         * pattern : ^.+$
         */

        private String index;
        private String name;
        private String pattern;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }
    }

    public static class InputOISublot {
        /**
         * index : 5
         * name : Sub_LotNo
         * pattern : ^.+$
         */

        private String index;
        private String name;
        private String pattern;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }
    }

    public static class InputOITestBinNo {
        /**
         * index : 9
         * name : Test_BinNo
         * pattern : ^.+$
         */

        private String index;
        private String name;
        private String pattern;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }
    }

    public static class InputOITestCode {
        /**
         * index : 8
         * name : Test_Code
         * pattern : ^.+$
         */

        private String index;
        private String name;
        private String pattern;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }
    }

    public static class InputOITesterId {
        /**
         * index : 0
         * name : Tester_ID
         * pattern : ^[A-Z]|[0-9]+\S*$
         */

        private String index;
        private String name;
        private String pattern;

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }
    }

    public static class PackTestResult {
        /**
         * packFileSet : S
         * packFileType : zip
         * packTestResult : true
         */

        private String packFileSet;
        private String packFileType;
        private String packTestResult;

        public String getPackFileSet() {
            return packFileSet;
        }

        public void setPackFileSet(String packFileSet) {
            this.packFileSet = packFileSet;
        }

        public String getPackFileType() {
            return packFileType;
        }

        public void setPackFileType(String packFileType) {
            this.packFileType = packFileType;
        }

        public String getPackTestResult() {
            return packTestResult;
        }

        public void setPackTestResult(String packTestResult) {
            this.packTestResult = packTestResult;
        }
    }

    public static class SoftBinAlarm {
        /**
         * soft101 : (<95%)
         */

        private String soft101;

        public String getSoft101() {
            return soft101;
        }

        public void setSoft101(String soft101) {
            this.soft101 = soft101;
        }
    }

    public static class SoftBinDefine {
        /**
         * softBin_1 : Pass
         * softBin_10 : Thermal_IDD_comp
         * softBin_11 : Chip_ID
         * softBin_12 : IFD_FT01
         * softBin_13 : IFD_FT02
         * softBin_14 : IFD_FT03
         * softBin_15 : IFD_FT04
         * softBin_16 : BB_FT01
         * softBin_17 : BB_FT02
         * softBin_18 : BB_FT03
         * softBin_19 : BB_FT04
         * softBin_2 : os
         * softBin_20 : BB_FT05
         * softBin_21 : BB_FT06
         * softBin_22 : SIF_FT01
         * softBin_2222 : HDMI_594MHz_LDOEA_voltage
         * softBin_23 : HDMI_Z0_P
         * softBin_24 : HDMI_Z0_N
         * softBin_25 : MHL_3G_port0
         * softBin_26 : CEC_FT01
         * softBin_27 : MHL10_CBUS
         * softBin_28 : VD_FT03_ramp
         * softBin_29 : VD_FT04_ramp
         * softBin_3 : os_2mA
         * softBin_30 : YPP01_FT
         * softBin_31 : YPP02_FT
         * softBin_32 : VDC01_FT_SNR
         * softBin_33 : VD02_FT_SNR_crosstalk
         * softBin_34 : EQ_T1R2_U3_dongle
         * softBin_35 : EQ_T2R1_U3_USB
         * softBin_36 : VBy1_K3L
         * softBin_38 : wafer_info
         * softBin_39 : FW
         * softBin_4 : os_share_pins
         * softBin_40 : Efuse_RTK_security_boot_write
         * softBin_41 : Efuse_RTK_security_boot_read
         * softBin_42 : Efuse_func_config
         * softBin_43 : efuse_IDD_test
         * softBin_44 : ETN_done_bit_read
         * softBin_45 : ETN_RC_cal
         * softBin_46 : ETN_RC_cal_efuse
         * softBin_47 : ETN_R_cal
         * softBin_48 : ETN_R_cal_efuse
         * softBin_49 : ETN_Amp_cal
         * softBin_5 : os_2mA_share_pins
         * softBin_50 : ETN_Amp_cal_efuse
         * softBin_5000 : HDMI_13p5MHz_port0
         * softBin_5001 : HDMI_13p5MHz_port1
         * softBin_5002 : HDMI_13p5MHz_port2
         * softBin_5003 : HDMI_13p5MHz_port3
         * softBin_51 : ETN_done_bit_efuse
         * softBin_5100 : HDMI_148p5MHz_port0
         * softBin_5101 : HDMI_148p5MHz_port1
         * softBin_5102 : HDMI_148p5MHz_port2
         * softBin_5103 : HDMI_148p5MHz_port3
         * softBin_52 : ETN_MLT3
         * softBin_5200 : HDMI_297MHz_port0
         * softBin_5201 : HDMI_297MHz_port1
         * softBin_5202 : HDMI_297MHz_port2
         * softBin_5203 : HDMI_297MHz_port3
         * softBin_53 : K3L_DDR1066_DC1_FRC_LV
         * softBin_5300 : HDMI_594MHz_port0
         * softBin_5301 : HDMI_594MHz_port1
         * softBin_5302 : HDMI_594MHz_port2
         * softBin_5303 : HDMI_594MHz_port3
         * softBin_5310 : HDMI_594MHz_port0_HVS
         * softBin_5311 : HDMI_594MHz_port1_HVS
         * softBin_5312 : HDMI_594MHz_port2_HVS
         * softBin_5313 : HDMI_594MHz_port3_HVS
         * softBin_5320 : HDMI_594MHz_port0_HVS_write
         * softBin_5321 : HDMI_594MHz_port1_HVS_write
         * softBin_5322 : HDMI_594MHz_port2_HVS_write
         * softBin_5323 : HDMI_594MHz_port3_HVS_write
         * softBin_5330 : HDMI_594MHz_port0_HVS_read
         * softBin_5331 : HDMI_594MHz_port1_HVS_read
         * softBin_5332 : HDMI_594MHz_port2_HVS_read
         * softBin_5333 : HDMI_594MHz_port3_HVS_read
         * softBin_5399 : HDMI_594MHz_LDOEA_pat
         * softBin_54 : GPI_H_K3L
         * softBin_5400 : HDMI_74p25MHz_port0
         * softBin_5401 : HDMI_74p25MHz_port1
         * softBin_5402 : HDMI_74p25MHz_port2
         * softBin_5403 : HDMI_74p25MHz_port3
         * softBin_55 : GPI_L_K3L
         * softBin_56 : GPO_H_K3L
         * softBin_57 : GPO_L_K3L
         * softBin_58 : PLLDDR1_CP_MIN_200MHz
         * softBin_59 : PLLDDR2_CP_MIN_200MHz
         * softBin_6 : os_ext
         * softBin_60 : PLLDDR1_CP_MIN_200MHz_4
         * softBin_6000 : FW(scpu/gpu)
         * softBin_6001 : FW(scpu)
         * softBin_6002 : FW(gpu)
         * softBin_61 : PLLDDR2_CP_MIN_200MHz_4
         * softBin_62 : IDDQ_DDR_vb
         * softBin_63 : IFD_FT07
         * softBin_64 : IFD_FT09_IQ
         * softBin_65 : YPP_FT03
         * softBin_66 : Efuse_RTK_Chip_ID
         * softBin_67 : K3L_DDR1066_DC1_FRC_HV
         * softBin_68 : K3L_DDR1066_DC2_FRC_LV
         * softBin_69 : K3L_DDR1066_DC2_FRC_HV
         * softBin_7 : power_short
         * softBin_70 : IDD_classB
         * softBin_7001 : FW(ETN)
         * softBin_7002 : FW(BISR)
         * softBin_7003 : FW(ACPU)
         * softBin_7004 : FW(GPU)
         * softBin_7005 : FW(Multi_core_test)
         * softBin_7006 : FW(VE)
         * softBin_7007 : FW(8051)
         * softBin_7008 : FW(SE)
         * softBin_7009 : FW(MD)
         * softBin_7010 : FW(CP)
         * softBin_7011 : FW(HDMI)
         * softBin_7012 : FW(IFD)
         * softBin_7013 : FW(VDE)
         * softBin_7014 : FW(VDC)
         * softBin_7015 : FW(USB)
         * softBin_7016 : FW(EMMC)
         * softBin_7017 : FW(MD_Domain)
         * softBin_7018 : FW(MEMC)
         * softBin_7019 : FW(YPP OTP)
         * softBin_75 : USB2_HS_FT_4Port_SE0
         * softBin_8 : por
         * softBin_86 : USB2_HS_CP_Squelch_level_efuse
         * softBin_87 : USB2_HS_FT_Disconnectlevel_efuse
         * softBin_89 : efuse_readAll_test
         * softBin_9 : IDDQ
         * softBin_90 : CP_CRC_check
         * softBin_91 : VCPU_SCAN_levelB
         * softBin_93 : os_ppmu
         * softBin_94 : OTP_CP_TSMC_STRESS_CRC_READ_LV
         * softBin_95 : OTP_CP_TSMC_STRESS_CRC_READ_HV
         * softBin_96 : IO_leakage
         * softBin_9999 : Error
         */

        private String softBin_1;
        private String softBin_10;
        private String softBin_11;
        private String softBin_12;
        private String softBin_13;
        private String softBin_14;
        private String softBin_15;
        private String softBin_16;
        private String softBin_17;
        private String softBin_18;
        private String softBin_19;
        private String softBin_2;
        private String softBin_20;
        private String softBin_21;
        private String softBin_22;
        private String softBin_2222;
        private String softBin_23;
        private String softBin_24;
        private String softBin_25;
        private String softBin_26;
        private String softBin_27;
        private String softBin_28;
        private String softBin_29;
        private String softBin_3;
        private String softBin_30;
        private String softBin_31;
        private String softBin_32;
        private String softBin_33;
        private String softBin_34;
        private String softBin_35;
        private String softBin_36;
        private String softBin_38;
        private String softBin_39;
        private String softBin_4;
        private String softBin_40;
        private String softBin_41;
        private String softBin_42;
        private String softBin_43;
        private String softBin_44;
        private String softBin_45;
        private String softBin_46;
        private String softBin_47;
        private String softBin_48;
        private String softBin_49;
        private String softBin_5;
        private String softBin_50;
        private String softBin_5000;
        private String softBin_5001;
        private String softBin_5002;
        private String softBin_5003;
        private String softBin_51;
        private String softBin_5100;
        private String softBin_5101;
        private String softBin_5102;
        private String softBin_5103;
        private String softBin_52;
        private String softBin_5200;
        private String softBin_5201;
        private String softBin_5202;
        private String softBin_5203;
        private String softBin_53;
        private String softBin_5300;
        private String softBin_5301;
        private String softBin_5302;
        private String softBin_5303;
        private String softBin_5310;
        private String softBin_5311;
        private String softBin_5312;
        private String softBin_5313;
        private String softBin_5320;
        private String softBin_5321;
        private String softBin_5322;
        private String softBin_5323;
        private String softBin_5330;
        private String softBin_5331;
        private String softBin_5332;
        private String softBin_5333;
        private String softBin_5399;
        private String softBin_54;
        private String softBin_5400;
        private String softBin_5401;
        private String softBin_5402;
        private String softBin_5403;
        private String softBin_55;
        private String softBin_56;
        private String softBin_57;
        private String softBin_58;
        private String softBin_59;
        private String softBin_6;
        private String softBin_60;
        private String softBin_6000;
        private String softBin_6001;
        private String softBin_6002;
        private String softBin_61;
        private String softBin_62;
        private String softBin_63;
        private String softBin_64;
        private String softBin_65;
        private String softBin_66;
        private String softBin_67;
        private String softBin_68;
        private String softBin_69;
        private String softBin_7;
        private String softBin_70;
        private String softBin_7001;
        private String softBin_7002;
        private String softBin_7003;
        private String softBin_7004;
        private String softBin_7005;
        private String softBin_7006;
        private String softBin_7007;
        private String softBin_7008;
        private String softBin_7009;
        private String softBin_7010;
        private String softBin_7011;
        private String softBin_7012;
        private String softBin_7013;
        private String softBin_7014;
        private String softBin_7015;
        private String softBin_7016;
        private String softBin_7017;
        private String softBin_7018;
        private String softBin_7019;
        private String softBin_75;
        private String softBin_8;
        private String softBin_86;
        private String softBin_87;
        private String softBin_89;
        private String softBin_9;
        private String softBin_90;
        private String softBin_91;
        private String softBin_93;
        private String softBin_94;
        private String softBin_95;
        private String softBin_96;
        private String softBin_9999;

        public String getSoftBin_1() {
            return softBin_1;
        }

        public void setSoftBin_1(String softBin_1) {
            this.softBin_1 = softBin_1;
        }

        public String getSoftBin_10() {
            return softBin_10;
        }

        public void setSoftBin_10(String softBin_10) {
            this.softBin_10 = softBin_10;
        }

        public String getSoftBin_11() {
            return softBin_11;
        }

        public void setSoftBin_11(String softBin_11) {
            this.softBin_11 = softBin_11;
        }

        public String getSoftBin_12() {
            return softBin_12;
        }

        public void setSoftBin_12(String softBin_12) {
            this.softBin_12 = softBin_12;
        }

        public String getSoftBin_13() {
            return softBin_13;
        }

        public void setSoftBin_13(String softBin_13) {
            this.softBin_13 = softBin_13;
        }

        public String getSoftBin_14() {
            return softBin_14;
        }

        public void setSoftBin_14(String softBin_14) {
            this.softBin_14 = softBin_14;
        }

        public String getSoftBin_15() {
            return softBin_15;
        }

        public void setSoftBin_15(String softBin_15) {
            this.softBin_15 = softBin_15;
        }

        public String getSoftBin_16() {
            return softBin_16;
        }

        public void setSoftBin_16(String softBin_16) {
            this.softBin_16 = softBin_16;
        }

        public String getSoftBin_17() {
            return softBin_17;
        }

        public void setSoftBin_17(String softBin_17) {
            this.softBin_17 = softBin_17;
        }

        public String getSoftBin_18() {
            return softBin_18;
        }

        public void setSoftBin_18(String softBin_18) {
            this.softBin_18 = softBin_18;
        }

        public String getSoftBin_19() {
            return softBin_19;
        }

        public void setSoftBin_19(String softBin_19) {
            this.softBin_19 = softBin_19;
        }

        public String getSoftBin_2() {
            return softBin_2;
        }

        public void setSoftBin_2(String softBin_2) {
            this.softBin_2 = softBin_2;
        }

        public String getSoftBin_20() {
            return softBin_20;
        }

        public void setSoftBin_20(String softBin_20) {
            this.softBin_20 = softBin_20;
        }

        public String getSoftBin_21() {
            return softBin_21;
        }

        public void setSoftBin_21(String softBin_21) {
            this.softBin_21 = softBin_21;
        }

        public String getSoftBin_22() {
            return softBin_22;
        }

        public void setSoftBin_22(String softBin_22) {
            this.softBin_22 = softBin_22;
        }

        public String getSoftBin_2222() {
            return softBin_2222;
        }

        public void setSoftBin_2222(String softBin_2222) {
            this.softBin_2222 = softBin_2222;
        }

        public String getSoftBin_23() {
            return softBin_23;
        }

        public void setSoftBin_23(String softBin_23) {
            this.softBin_23 = softBin_23;
        }

        public String getSoftBin_24() {
            return softBin_24;
        }

        public void setSoftBin_24(String softBin_24) {
            this.softBin_24 = softBin_24;
        }

        public String getSoftBin_25() {
            return softBin_25;
        }

        public void setSoftBin_25(String softBin_25) {
            this.softBin_25 = softBin_25;
        }

        public String getSoftBin_26() {
            return softBin_26;
        }

        public void setSoftBin_26(String softBin_26) {
            this.softBin_26 = softBin_26;
        }

        public String getSoftBin_27() {
            return softBin_27;
        }

        public void setSoftBin_27(String softBin_27) {
            this.softBin_27 = softBin_27;
        }

        public String getSoftBin_28() {
            return softBin_28;
        }

        public void setSoftBin_28(String softBin_28) {
            this.softBin_28 = softBin_28;
        }

        public String getSoftBin_29() {
            return softBin_29;
        }

        public void setSoftBin_29(String softBin_29) {
            this.softBin_29 = softBin_29;
        }

        public String getSoftBin_3() {
            return softBin_3;
        }

        public void setSoftBin_3(String softBin_3) {
            this.softBin_3 = softBin_3;
        }

        public String getSoftBin_30() {
            return softBin_30;
        }

        public void setSoftBin_30(String softBin_30) {
            this.softBin_30 = softBin_30;
        }

        public String getSoftBin_31() {
            return softBin_31;
        }

        public void setSoftBin_31(String softBin_31) {
            this.softBin_31 = softBin_31;
        }

        public String getSoftBin_32() {
            return softBin_32;
        }

        public void setSoftBin_32(String softBin_32) {
            this.softBin_32 = softBin_32;
        }

        public String getSoftBin_33() {
            return softBin_33;
        }

        public void setSoftBin_33(String softBin_33) {
            this.softBin_33 = softBin_33;
        }

        public String getSoftBin_34() {
            return softBin_34;
        }

        public void setSoftBin_34(String softBin_34) {
            this.softBin_34 = softBin_34;
        }

        public String getSoftBin_35() {
            return softBin_35;
        }

        public void setSoftBin_35(String softBin_35) {
            this.softBin_35 = softBin_35;
        }

        public String getSoftBin_36() {
            return softBin_36;
        }

        public void setSoftBin_36(String softBin_36) {
            this.softBin_36 = softBin_36;
        }

        public String getSoftBin_38() {
            return softBin_38;
        }

        public void setSoftBin_38(String softBin_38) {
            this.softBin_38 = softBin_38;
        }

        public String getSoftBin_39() {
            return softBin_39;
        }

        public void setSoftBin_39(String softBin_39) {
            this.softBin_39 = softBin_39;
        }

        public String getSoftBin_4() {
            return softBin_4;
        }

        public void setSoftBin_4(String softBin_4) {
            this.softBin_4 = softBin_4;
        }

        public String getSoftBin_40() {
            return softBin_40;
        }

        public void setSoftBin_40(String softBin_40) {
            this.softBin_40 = softBin_40;
        }

        public String getSoftBin_41() {
            return softBin_41;
        }

        public void setSoftBin_41(String softBin_41) {
            this.softBin_41 = softBin_41;
        }

        public String getSoftBin_42() {
            return softBin_42;
        }

        public void setSoftBin_42(String softBin_42) {
            this.softBin_42 = softBin_42;
        }

        public String getSoftBin_43() {
            return softBin_43;
        }

        public void setSoftBin_43(String softBin_43) {
            this.softBin_43 = softBin_43;
        }

        public String getSoftBin_44() {
            return softBin_44;
        }

        public void setSoftBin_44(String softBin_44) {
            this.softBin_44 = softBin_44;
        }

        public String getSoftBin_45() {
            return softBin_45;
        }

        public void setSoftBin_45(String softBin_45) {
            this.softBin_45 = softBin_45;
        }

        public String getSoftBin_46() {
            return softBin_46;
        }

        public void setSoftBin_46(String softBin_46) {
            this.softBin_46 = softBin_46;
        }

        public String getSoftBin_47() {
            return softBin_47;
        }

        public void setSoftBin_47(String softBin_47) {
            this.softBin_47 = softBin_47;
        }

        public String getSoftBin_48() {
            return softBin_48;
        }

        public void setSoftBin_48(String softBin_48) {
            this.softBin_48 = softBin_48;
        }

        public String getSoftBin_49() {
            return softBin_49;
        }

        public void setSoftBin_49(String softBin_49) {
            this.softBin_49 = softBin_49;
        }

        public String getSoftBin_5() {
            return softBin_5;
        }

        public void setSoftBin_5(String softBin_5) {
            this.softBin_5 = softBin_5;
        }

        public String getSoftBin_50() {
            return softBin_50;
        }

        public void setSoftBin_50(String softBin_50) {
            this.softBin_50 = softBin_50;
        }

        public String getSoftBin_5000() {
            return softBin_5000;
        }

        public void setSoftBin_5000(String softBin_5000) {
            this.softBin_5000 = softBin_5000;
        }

        public String getSoftBin_5001() {
            return softBin_5001;
        }

        public void setSoftBin_5001(String softBin_5001) {
            this.softBin_5001 = softBin_5001;
        }

        public String getSoftBin_5002() {
            return softBin_5002;
        }

        public void setSoftBin_5002(String softBin_5002) {
            this.softBin_5002 = softBin_5002;
        }

        public String getSoftBin_5003() {
            return softBin_5003;
        }

        public void setSoftBin_5003(String softBin_5003) {
            this.softBin_5003 = softBin_5003;
        }

        public String getSoftBin_51() {
            return softBin_51;
        }

        public void setSoftBin_51(String softBin_51) {
            this.softBin_51 = softBin_51;
        }

        public String getSoftBin_5100() {
            return softBin_5100;
        }

        public void setSoftBin_5100(String softBin_5100) {
            this.softBin_5100 = softBin_5100;
        }

        public String getSoftBin_5101() {
            return softBin_5101;
        }

        public void setSoftBin_5101(String softBin_5101) {
            this.softBin_5101 = softBin_5101;
        }

        public String getSoftBin_5102() {
            return softBin_5102;
        }

        public void setSoftBin_5102(String softBin_5102) {
            this.softBin_5102 = softBin_5102;
        }

        public String getSoftBin_5103() {
            return softBin_5103;
        }

        public void setSoftBin_5103(String softBin_5103) {
            this.softBin_5103 = softBin_5103;
        }

        public String getSoftBin_52() {
            return softBin_52;
        }

        public void setSoftBin_52(String softBin_52) {
            this.softBin_52 = softBin_52;
        }

        public String getSoftBin_5200() {
            return softBin_5200;
        }

        public void setSoftBin_5200(String softBin_5200) {
            this.softBin_5200 = softBin_5200;
        }

        public String getSoftBin_5201() {
            return softBin_5201;
        }

        public void setSoftBin_5201(String softBin_5201) {
            this.softBin_5201 = softBin_5201;
        }

        public String getSoftBin_5202() {
            return softBin_5202;
        }

        public void setSoftBin_5202(String softBin_5202) {
            this.softBin_5202 = softBin_5202;
        }

        public String getSoftBin_5203() {
            return softBin_5203;
        }

        public void setSoftBin_5203(String softBin_5203) {
            this.softBin_5203 = softBin_5203;
        }

        public String getSoftBin_53() {
            return softBin_53;
        }

        public void setSoftBin_53(String softBin_53) {
            this.softBin_53 = softBin_53;
        }

        public String getSoftBin_5300() {
            return softBin_5300;
        }

        public void setSoftBin_5300(String softBin_5300) {
            this.softBin_5300 = softBin_5300;
        }

        public String getSoftBin_5301() {
            return softBin_5301;
        }

        public void setSoftBin_5301(String softBin_5301) {
            this.softBin_5301 = softBin_5301;
        }

        public String getSoftBin_5302() {
            return softBin_5302;
        }

        public void setSoftBin_5302(String softBin_5302) {
            this.softBin_5302 = softBin_5302;
        }

        public String getSoftBin_5303() {
            return softBin_5303;
        }

        public void setSoftBin_5303(String softBin_5303) {
            this.softBin_5303 = softBin_5303;
        }

        public String getSoftBin_5310() {
            return softBin_5310;
        }

        public void setSoftBin_5310(String softBin_5310) {
            this.softBin_5310 = softBin_5310;
        }

        public String getSoftBin_5311() {
            return softBin_5311;
        }

        public void setSoftBin_5311(String softBin_5311) {
            this.softBin_5311 = softBin_5311;
        }

        public String getSoftBin_5312() {
            return softBin_5312;
        }

        public void setSoftBin_5312(String softBin_5312) {
            this.softBin_5312 = softBin_5312;
        }

        public String getSoftBin_5313() {
            return softBin_5313;
        }

        public void setSoftBin_5313(String softBin_5313) {
            this.softBin_5313 = softBin_5313;
        }

        public String getSoftBin_5320() {
            return softBin_5320;
        }

        public void setSoftBin_5320(String softBin_5320) {
            this.softBin_5320 = softBin_5320;
        }

        public String getSoftBin_5321() {
            return softBin_5321;
        }

        public void setSoftBin_5321(String softBin_5321) {
            this.softBin_5321 = softBin_5321;
        }

        public String getSoftBin_5322() {
            return softBin_5322;
        }

        public void setSoftBin_5322(String softBin_5322) {
            this.softBin_5322 = softBin_5322;
        }

        public String getSoftBin_5323() {
            return softBin_5323;
        }

        public void setSoftBin_5323(String softBin_5323) {
            this.softBin_5323 = softBin_5323;
        }

        public String getSoftBin_5330() {
            return softBin_5330;
        }

        public void setSoftBin_5330(String softBin_5330) {
            this.softBin_5330 = softBin_5330;
        }

        public String getSoftBin_5331() {
            return softBin_5331;
        }

        public void setSoftBin_5331(String softBin_5331) {
            this.softBin_5331 = softBin_5331;
        }

        public String getSoftBin_5332() {
            return softBin_5332;
        }

        public void setSoftBin_5332(String softBin_5332) {
            this.softBin_5332 = softBin_5332;
        }

        public String getSoftBin_5333() {
            return softBin_5333;
        }

        public void setSoftBin_5333(String softBin_5333) {
            this.softBin_5333 = softBin_5333;
        }

        public String getSoftBin_5399() {
            return softBin_5399;
        }

        public void setSoftBin_5399(String softBin_5399) {
            this.softBin_5399 = softBin_5399;
        }

        public String getSoftBin_54() {
            return softBin_54;
        }

        public void setSoftBin_54(String softBin_54) {
            this.softBin_54 = softBin_54;
        }

        public String getSoftBin_5400() {
            return softBin_5400;
        }

        public void setSoftBin_5400(String softBin_5400) {
            this.softBin_5400 = softBin_5400;
        }

        public String getSoftBin_5401() {
            return softBin_5401;
        }

        public void setSoftBin_5401(String softBin_5401) {
            this.softBin_5401 = softBin_5401;
        }

        public String getSoftBin_5402() {
            return softBin_5402;
        }

        public void setSoftBin_5402(String softBin_5402) {
            this.softBin_5402 = softBin_5402;
        }

        public String getSoftBin_5403() {
            return softBin_5403;
        }

        public void setSoftBin_5403(String softBin_5403) {
            this.softBin_5403 = softBin_5403;
        }

        public String getSoftBin_55() {
            return softBin_55;
        }

        public void setSoftBin_55(String softBin_55) {
            this.softBin_55 = softBin_55;
        }

        public String getSoftBin_56() {
            return softBin_56;
        }

        public void setSoftBin_56(String softBin_56) {
            this.softBin_56 = softBin_56;
        }

        public String getSoftBin_57() {
            return softBin_57;
        }

        public void setSoftBin_57(String softBin_57) {
            this.softBin_57 = softBin_57;
        }

        public String getSoftBin_58() {
            return softBin_58;
        }

        public void setSoftBin_58(String softBin_58) {
            this.softBin_58 = softBin_58;
        }

        public String getSoftBin_59() {
            return softBin_59;
        }

        public void setSoftBin_59(String softBin_59) {
            this.softBin_59 = softBin_59;
        }

        public String getSoftBin_6() {
            return softBin_6;
        }

        public void setSoftBin_6(String softBin_6) {
            this.softBin_6 = softBin_6;
        }

        public String getSoftBin_60() {
            return softBin_60;
        }

        public void setSoftBin_60(String softBin_60) {
            this.softBin_60 = softBin_60;
        }

        public String getSoftBin_6000() {
            return softBin_6000;
        }

        public void setSoftBin_6000(String softBin_6000) {
            this.softBin_6000 = softBin_6000;
        }

        public String getSoftBin_6001() {
            return softBin_6001;
        }

        public void setSoftBin_6001(String softBin_6001) {
            this.softBin_6001 = softBin_6001;
        }

        public String getSoftBin_6002() {
            return softBin_6002;
        }

        public void setSoftBin_6002(String softBin_6002) {
            this.softBin_6002 = softBin_6002;
        }

        public String getSoftBin_61() {
            return softBin_61;
        }

        public void setSoftBin_61(String softBin_61) {
            this.softBin_61 = softBin_61;
        }

        public String getSoftBin_62() {
            return softBin_62;
        }

        public void setSoftBin_62(String softBin_62) {
            this.softBin_62 = softBin_62;
        }

        public String getSoftBin_63() {
            return softBin_63;
        }

        public void setSoftBin_63(String softBin_63) {
            this.softBin_63 = softBin_63;
        }

        public String getSoftBin_64() {
            return softBin_64;
        }

        public void setSoftBin_64(String softBin_64) {
            this.softBin_64 = softBin_64;
        }

        public String getSoftBin_65() {
            return softBin_65;
        }

        public void setSoftBin_65(String softBin_65) {
            this.softBin_65 = softBin_65;
        }

        public String getSoftBin_66() {
            return softBin_66;
        }

        public void setSoftBin_66(String softBin_66) {
            this.softBin_66 = softBin_66;
        }

        public String getSoftBin_67() {
            return softBin_67;
        }

        public void setSoftBin_67(String softBin_67) {
            this.softBin_67 = softBin_67;
        }

        public String getSoftBin_68() {
            return softBin_68;
        }

        public void setSoftBin_68(String softBin_68) {
            this.softBin_68 = softBin_68;
        }

        public String getSoftBin_69() {
            return softBin_69;
        }

        public void setSoftBin_69(String softBin_69) {
            this.softBin_69 = softBin_69;
        }

        public String getSoftBin_7() {
            return softBin_7;
        }

        public void setSoftBin_7(String softBin_7) {
            this.softBin_7 = softBin_7;
        }

        public String getSoftBin_70() {
            return softBin_70;
        }

        public void setSoftBin_70(String softBin_70) {
            this.softBin_70 = softBin_70;
        }

        public String getSoftBin_7001() {
            return softBin_7001;
        }

        public void setSoftBin_7001(String softBin_7001) {
            this.softBin_7001 = softBin_7001;
        }

        public String getSoftBin_7002() {
            return softBin_7002;
        }

        public void setSoftBin_7002(String softBin_7002) {
            this.softBin_7002 = softBin_7002;
        }

        public String getSoftBin_7003() {
            return softBin_7003;
        }

        public void setSoftBin_7003(String softBin_7003) {
            this.softBin_7003 = softBin_7003;
        }

        public String getSoftBin_7004() {
            return softBin_7004;
        }

        public void setSoftBin_7004(String softBin_7004) {
            this.softBin_7004 = softBin_7004;
        }

        public String getSoftBin_7005() {
            return softBin_7005;
        }

        public void setSoftBin_7005(String softBin_7005) {
            this.softBin_7005 = softBin_7005;
        }

        public String getSoftBin_7006() {
            return softBin_7006;
        }

        public void setSoftBin_7006(String softBin_7006) {
            this.softBin_7006 = softBin_7006;
        }

        public String getSoftBin_7007() {
            return softBin_7007;
        }

        public void setSoftBin_7007(String softBin_7007) {
            this.softBin_7007 = softBin_7007;
        }

        public String getSoftBin_7008() {
            return softBin_7008;
        }

        public void setSoftBin_7008(String softBin_7008) {
            this.softBin_7008 = softBin_7008;
        }

        public String getSoftBin_7009() {
            return softBin_7009;
        }

        public void setSoftBin_7009(String softBin_7009) {
            this.softBin_7009 = softBin_7009;
        }

        public String getSoftBin_7010() {
            return softBin_7010;
        }

        public void setSoftBin_7010(String softBin_7010) {
            this.softBin_7010 = softBin_7010;
        }

        public String getSoftBin_7011() {
            return softBin_7011;
        }

        public void setSoftBin_7011(String softBin_7011) {
            this.softBin_7011 = softBin_7011;
        }

        public String getSoftBin_7012() {
            return softBin_7012;
        }

        public void setSoftBin_7012(String softBin_7012) {
            this.softBin_7012 = softBin_7012;
        }

        public String getSoftBin_7013() {
            return softBin_7013;
        }

        public void setSoftBin_7013(String softBin_7013) {
            this.softBin_7013 = softBin_7013;
        }

        public String getSoftBin_7014() {
            return softBin_7014;
        }

        public void setSoftBin_7014(String softBin_7014) {
            this.softBin_7014 = softBin_7014;
        }

        public String getSoftBin_7015() {
            return softBin_7015;
        }

        public void setSoftBin_7015(String softBin_7015) {
            this.softBin_7015 = softBin_7015;
        }

        public String getSoftBin_7016() {
            return softBin_7016;
        }

        public void setSoftBin_7016(String softBin_7016) {
            this.softBin_7016 = softBin_7016;
        }

        public String getSoftBin_7017() {
            return softBin_7017;
        }

        public void setSoftBin_7017(String softBin_7017) {
            this.softBin_7017 = softBin_7017;
        }

        public String getSoftBin_7018() {
            return softBin_7018;
        }

        public void setSoftBin_7018(String softBin_7018) {
            this.softBin_7018 = softBin_7018;
        }

        public String getSoftBin_7019() {
            return softBin_7019;
        }

        public void setSoftBin_7019(String softBin_7019) {
            this.softBin_7019 = softBin_7019;
        }

        public String getSoftBin_75() {
            return softBin_75;
        }

        public void setSoftBin_75(String softBin_75) {
            this.softBin_75 = softBin_75;
        }

        public String getSoftBin_8() {
            return softBin_8;
        }

        public void setSoftBin_8(String softBin_8) {
            this.softBin_8 = softBin_8;
        }

        public String getSoftBin_86() {
            return softBin_86;
        }

        public void setSoftBin_86(String softBin_86) {
            this.softBin_86 = softBin_86;
        }

        public String getSoftBin_87() {
            return softBin_87;
        }

        public void setSoftBin_87(String softBin_87) {
            this.softBin_87 = softBin_87;
        }

        public String getSoftBin_89() {
            return softBin_89;
        }

        public void setSoftBin_89(String softBin_89) {
            this.softBin_89 = softBin_89;
        }

        public String getSoftBin_9() {
            return softBin_9;
        }

        public void setSoftBin_9(String softBin_9) {
            this.softBin_9 = softBin_9;
        }

        public String getSoftBin_90() {
            return softBin_90;
        }

        public void setSoftBin_90(String softBin_90) {
            this.softBin_90 = softBin_90;
        }

        public String getSoftBin_91() {
            return softBin_91;
        }

        public void setSoftBin_91(String softBin_91) {
            this.softBin_91 = softBin_91;
        }

        public String getSoftBin_93() {
            return softBin_93;
        }

        public void setSoftBin_93(String softBin_93) {
            this.softBin_93 = softBin_93;
        }

        public String getSoftBin_94() {
            return softBin_94;
        }

        public void setSoftBin_94(String softBin_94) {
            this.softBin_94 = softBin_94;
        }

        public String getSoftBin_95() {
            return softBin_95;
        }

        public void setSoftBin_95(String softBin_95) {
            this.softBin_95 = softBin_95;
        }

        public String getSoftBin_96() {
            return softBin_96;
        }

        public void setSoftBin_96(String softBin_96) {
            this.softBin_96 = softBin_96;
        }

        public String getSoftBin_9999() {
            return softBin_9999;
        }

        public void setSoftBin_9999(String softBin_9999) {
            this.softBin_9999 = softBin_9999;
        }
    }
    public static class TestCodeConfig {
        /**
         * q0 : Q0
         * q0_1 : Q0.1
         * q0_2 : Q0.2
         * q0_3 : Q0.3
         * q0_4 : Q0.4
         * q0_5 : Q0.5
         * q1 : Q1
         * q10 : Q10
         * q10_1 : Q10.1
         * q10_2 : Q10.2
         * q1_1 : Q1.1
         * q1_2 : Q1.2
         * q2 : Q2
         * q2_1 : Q2.1
         * q2_2 : Q2.2
         * q3 : Q3
         * q3_1 : Q3.1
         * q3_2 : Q3.2
         * q4 : Q4
         * q4_1 : Q4.1
         * q4_2 : Q4.2
         * q5 : Q5
         * q5_1 : Q5.1
         * q5_2 : Q5.2
         * q6 : Q6
         * q6_1 : Q6.1
         * q6_2 : Q6.2
         * q7 : Q7
         * q7_1 : Q7.1
         * q7_2 : Q7.2
         * q8 : Q8
         * q8_1 : Q8.1
         * q8_2 : Q8.2
         * q9 : Q9
         * q9_1 : Q9.1
         * q9_2 : Q9.2
         * r0 : R0
         * r0_1 : R0.1
         * r0_10 : R0.10
         * r0_2 : R0.2
         * r0_3 : R0.3
         * r0_4 : R0.4
         * r0_5 : R0.5
         * r0_6 : R0.6
         * r0_7 : R0.7
         * r0_8 : R0.8
         * r0_9 : R0.9
         * r1 : R1
         * r10 : R10
         * r10_1 : R10.1
         * r10_2 : R10.2
         * r10_3 : R10.3
         * r10_4 : R10.4
         * r10_5 : R10.5
         * r1_1 : R1.1
         * r1_2 : R1.2
         * r1_3 : R1.3
         * r1_4 : R1.4
         * r1_5 : R1.5
         * r2 : R2
         * r2_1 : R2.1
         * r2_2 : R2.2
         * r2_3 : R2.3
         * r2_4 : R2.4
         * r2_5 : R2.5
         * r3 : R3
         * r3_1 : R3.1
         * r3_2 : R3.2
         * r3_3 : R3.3
         * r3_4 : R3.4
         * r3_5 : R3.5
         * r4 : R4
         * r4_1 : R4.1
         * r4_2 : R4.2
         * r4_3 : R4.3
         * r4_4 : R4.4
         * r4_5 : R4.5
         * r5 : R5
         * r5_1 : R5.1
         * r5_2 : R5.2
         * r5_3 : R5.3
         * r5_4 : R5.4
         * r5_5 : R5.5
         * r6 : R6
         * r6_1 : R6.1
         * r6_2 : R6.2
         * r6_3 : R6.3
         * r6_4 : R6.4
         * r6_5 : R6.5
         * r7 : R7
         * r7_1 : R7.1
         * r7_2 : R7.2
         * r7_3 : R7.3
         * r7_4 : R7.4
         * r7_5 : R7.5
         * r8 : R8
         * r8_1 : R8.1
         * r8_2 : R8.2
         * r8_3 : R8.3
         * r8_4 : R8.4
         * r8_5 : R8.5
         * r9 : R9
         * r9_1 : R9.1
         * r9_2 : R9.2
         * r9_3 : R9.3
         * r9_4 : R9.4
         * r9_5 : R9.5
         */

        private String q0;
        private String q0_1;
        private String q0_2;
        private String q0_3;
        private String q0_4;
        private String q0_5;
        private String q1;
        private String q10;
        private String q10_1;
        private String q10_2;
        private String q1_1;
        private String q1_2;
        private String q2;
        private String q2_1;
        private String q2_2;
        private String q3;
        private String q3_1;
        private String q3_2;
        private String q4;
        private String q4_1;
        private String q4_2;
        private String q5;
        private String q5_1;
        private String q5_2;
        private String q6;
        private String q6_1;
        private String q6_2;
        private String q7;
        private String q7_1;
        private String q7_2;
        private String q8;
        private String q8_1;
        private String q8_2;
        private String q9;
        private String q9_1;
        private String q9_2;
        private String r0;
        private String r0_1;
        private String r0_10;
        private String r0_2;
        private String r0_3;
        private String r0_4;
        private String r0_5;
        private String r0_6;
        private String r0_7;
        private String r0_8;
        private String r0_9;
        private String r1;
        private String r10;
        private String r10_1;
        private String r10_2;
        private String r10_3;
        private String r10_4;
        private String r10_5;
        private String r1_1;
        private String r1_2;
        private String r1_3;
        private String r1_4;
        private String r1_5;
        private String r2;
        private String r2_1;
        private String r2_2;
        private String r2_3;
        private String r2_4;
        private String r2_5;
        private String r3;
        private String r3_1;
        private String r3_2;
        private String r3_3;
        private String r3_4;
        private String r3_5;
        private String r4;
        private String r4_1;
        private String r4_2;
        private String r4_3;
        private String r4_4;
        private String r4_5;
        private String r5;
        private String r5_1;
        private String r5_2;
        private String r5_3;
        private String r5_4;
        private String r5_5;
        private String r6;
        private String r6_1;
        private String r6_2;
        private String r6_3;
        private String r6_4;
        private String r6_5;
        private String r7;
        private String r7_1;
        private String r7_2;
        private String r7_3;
        private String r7_4;
        private String r7_5;
        private String r8;
        private String r8_1;
        private String r8_2;
        private String r8_3;
        private String r8_4;
        private String r8_5;
        private String r9;
        private String r9_1;
        private String r9_2;
        private String r9_3;
        private String r9_4;
        private String r9_5;

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

        public String getR0_10() {
            return r0_10;
        }

        public void setR0_10(String r0_10) {
            this.r0_10 = r0_10;
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

        public String getR1() {
            return r1;
        }

        public void setR1(String r1) {
            this.r1 = r1;
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
    }

    public static class TesterCaldataCheck {
        /**
         * caldata : 30D
         */

        private String caldata;

        public String getCaldata() {
            return caldata;
        }

        public void setCaldata(String caldata) {
            this.caldata = caldata;
        }
    }
}
