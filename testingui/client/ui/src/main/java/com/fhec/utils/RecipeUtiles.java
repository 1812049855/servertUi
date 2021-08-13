package com.fhec.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author hua
 */
public class RecipeUtiles {


    public List<String> Headerlist = new ArrayList<>();
    public List<String> harlist = new ArrayList<>();
    public List<String> solist = new ArrayList<>();
    public List<String> TesterOS_Versionlist = new ArrayList<>();
    public List<String> Start_Timelist = new ArrayList<>();
    public List<String> End_Timelist = new ArrayList<>();
    public List<String> Tested_Qtylist = new ArrayList<>();
    public List<String> Customer_LotNolist = new ArrayList<>();
    public List<String> Mode_Codelist = new ArrayList<>();
    public List<String> Tester_IDlist = new ArrayList<>();
    public List<String> Device_Namelist = new ArrayList<>();
    public List<String> Customer_IDlist = new ArrayList<>();
    public List<String> Sub_LotNolist = new ArrayList<>();
    public List<String> Program_Namelist = new ArrayList<>();
    public List<String> Test_BinNolist = new ArrayList<>();
    public List<String> Operator_IDlist = new ArrayList<>();
    public List<String> Test_Codelist = new ArrayList<>();
    public List<String> Good_Qtylist = new ArrayList<>();
    public List<String> Fail_Qtylist = new ArrayList<>();
    public List<String> CSV_Filelist = new ArrayList<>();
    public List<String> CSV_STDF_Filelist = new ArrayList<>();
    public List<String> goodlist = new ArrayList<>();
    public List<String> os_faillist = new ArrayList<>();
    public List<String> idd_leakagelist = new ArrayList<>();
    public List<String> bist_mbistlist = new ArrayList<>();
    public List<String> scanlist = new ArrayList<>();
    public List<String> t589_plllist = new ArrayList<>();
    public List<String> t575_hdmilist = new ArrayList<>();
    public List<String> ethernetlist = new ArrayList<>();
    public List<String> efuse_writelist = new ArrayList<>();
    public List<String> saradc_vdaclist = new ArrayList<>();
    public List<String> funclist = new ArrayList<>();
    public List<String> goodlists = new ArrayList<>();
    public List<String> cont_gndlist = new ArrayList<>();
    public List<String> cont_gnd_caplist = new ArrayList<>();
    public List<String> cont_vddlist = new ArrayList<>();
    public List<String> cont_vdd_caplist = new ArrayList<>();
    public List<String> power_short_gndlist = new ArrayList<>();
    public List<String> idd_alllist = new ArrayList<>();
    public List<String> t550_input_onlylist = new ArrayList<>();
    public List<String> t550_output_onlylist = new ArrayList<>();
    public List<String> t550_hiz_only_Hlist = new ArrayList<>();
    public List<String> bist_alllist = new ArrayList<>();
    public List<String> bist_rom1list = new ArrayList<>();
    public List<String> t1323_400Mlist = new ArrayList<>();
    public List<String> t1323_500Mlist = new ArrayList<>();
    public List<String> a9_atspeed_scan_faillist = new ArrayList<>();
    public List<String> a9_stuckat_scan_faillist = new ArrayList<>();
    public List<String> mali_clklist = new ArrayList<>();
    public List<String> fullchiplist = new ArrayList<>();
    public List<String> pll_m1_locklist = new ArrayList<>();
    public List<String> pll_m1_caplist = new ArrayList<>();
    public List<String> pll_m2_caplist = new ArrayList<>();
    public List<String> t575_ch0list = new ArrayList<>();
    public List<String> t575_ch1list = new ArrayList<>();
    public List<String> t575_cklist = new ArrayList<>();
    public List<String> t575_dclist_H = new ArrayList<>();
    public List<String> t575_dc_llist = new ArrayList<>();
    public List<String> t1216_enet_bistlist = new ArrayList<>();
    public List<String> t1217_enet_bistlist = new ArrayList<>();
    public List<String> enetdc_42_faillist = new ArrayList<>();
    public List<String> t580_efuse_faillist = new ArrayList<>();
    public List<String> t580_usbbist_faillist = new ArrayList<>();
    public List<String> t580_clk_tst_rst_faillist = new ArrayList<>();
    public List<String> t580_ddr_faillist = new ArrayList<>();
    public List<String> t580_smp_faillist = new ArrayList<>();
    public List<String> write_index2_faillist = new ArrayList<>();
    public List<String> write_index7_faillist = new ArrayList<>();
    public List<String> write_index0_faillist = new ArrayList<>();
    public List<String> t543_cvbs_linear_faillist = new ArrayList<>();
    public List<String> audio_faillist = new ArrayList<>();


    public List<Integer> totalList = new ArrayList<>();
    public List<Integer> totalLists = new ArrayList<>();

    public void readTxt(String filePath) {


        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                String lineTxt;
                while ((lineTxt = br.readLine()) != null) {
                    if (lineTxt.contains("[")) {
                        Headerlist.add(lineTxt);
                    }
                    if (lineTxt.contains("TesterOS_Version")) {
                        TesterOS_Versionlist.add(lineTxt);
                    }
                    if (lineTxt.contains("Start_Time")) {
                        Start_Timelist.add(lineTxt);
                    }
                    if (lineTxt.contains("End_Time")) {
                        End_Timelist.add(lineTxt);
                    }
                    if (lineTxt.contains("Tested_Qty")) {
                        Tested_Qtylist.add(lineTxt);
                    }
                    if (lineTxt.contains("Customer_LotNo")) {
                        Customer_LotNolist.add(lineTxt);
                    }
                    if (lineTxt.contains("Mode_Code")) {
                        Mode_Codelist.add(lineTxt);
                    }
                    if (lineTxt.contains("Tester_ID")) {
                        Tester_IDlist.add(lineTxt);
                    }
                    if (lineTxt.contains("Device_Name")) {
                        Device_Namelist.add(lineTxt);
                    }
                    if (lineTxt.contains("Customer_ID")) {
                        Customer_IDlist.add(lineTxt);
                    }
                    if (lineTxt.contains("Sub_LotNo")) {
                        Sub_LotNolist.add(lineTxt);
                    }
                    if (lineTxt.contains("Program_Name")) {
                        Program_Namelist.add(lineTxt);
                    }
                    if (lineTxt.contains("Test_BinNo")) {
                        Test_BinNolist.add(lineTxt);
                    }
                    if (lineTxt.contains("Operator_ID")) {
                        Operator_IDlist.add(lineTxt);
                    }
                    if (lineTxt.contains("Test_Code")) {
                        Test_Codelist.add(lineTxt);
                    }
                    if (lineTxt.contains("Good_Qty")) {
                        Good_Qtylist.add(lineTxt);
                    }
                    if (lineTxt.contains("Fail_Qty")) {
                        Fail_Qtylist.add(lineTxt);
                    }
                    if (lineTxt.contains("CSV File")) {
                        CSV_Filelist.add(lineTxt);
                    }
                    if (lineTxt.contains("CSV STDF File")) {
                        CSV_STDF_Filelist.add(lineTxt);
                    }


                    //list.add(lineTxt);
                }
                br.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
        }
    }


    /**
     * 提取中括号中内容，忽略中括号中的中括号
     *
     * @param msg
     * @return
     */
    public List<String> extractMessage(String msg) {

        List<String> list = new ArrayList<String>();
        int start = 0;
        int startFlag = 0;
        int endFlag = 0;
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) == '[') {
                startFlag++;
                if (startFlag == endFlag + 1) {
                    start = i;
                }
            } else if (msg.charAt(i) == ']') {
                endFlag++;
                if (endFlag == startFlag) {
                    list.add(msg.substring(start + 1, i));
                }
            }
        }
        return list;
    }

    /**
     * 2
     *
     * @param filePath
     */



    public void readHardBins(String filePath) {
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                String lineTxt;
                while ((lineTxt = br.readLine()) != null) {
                    if (lineTxt.contains("[")) {
                        harlist.add(lineTxt);
                    }
                    if (lineTxt.contains("good")) {
                        goodlist.add(lineTxt);
                    }
                    if (lineTxt.contains("os fail")) {
                        os_faillist.add(lineTxt);
                    }
                    if (lineTxt.contains("idd/leakage")) {
                        idd_leakagelist.add(lineTxt);
                    }
                    if (lineTxt.contains("bist/mbist")) {
                        bist_mbistlist.add(lineTxt);
                    }
                    if (lineTxt.contains("scan")) {
                        scanlist.add(lineTxt);
                    }
                    if (lineTxt.contains("t589 pll")) {
                        t589_plllist.add(lineTxt);
                    }
                    if (lineTxt.contains("t575 hdmi")) {
                        t575_hdmilist.add(lineTxt);
                    }
                    if (lineTxt.contains("ethernet")) {
                        ethernetlist.add(lineTxt);
                    }
                    if (lineTxt.contains("t580 efuse write fail")) {
                        efuse_writelist.add(lineTxt);
                    }
                    if (lineTxt.contains("audio/saradc/vdac")) {
                        saradc_vdaclist.add(lineTxt);
                    }
                    if (lineTxt.contains("t580 func")) {
                        funclist.add(lineTxt);
                    }
                }

                for (int i = 0; i < goodlist.size(); i++) {
                    int good = Integer.parseInt(goodlist.get(i).split(":")[1]);
                    int os = Integer.parseInt(os_faillist.get(i).split(":")[1]);
                    int idd = Integer.parseInt(idd_leakagelist.get(i).split(":")[1]);
                    int bist = Integer.parseInt(bist_mbistlist.get(i).split(":")[1]);
                    int scan = Integer.parseInt(scanlist.get(i).split(":")[1]);
                    int t589 = Integer.parseInt(t589_plllist.get(i).split(":")[1]);
                    int t575 = Integer.parseInt(t575_hdmilist.get(i).split(":")[1]);
                    int ethernet = Integer.parseInt(ethernetlist.get(i).split(":")[1]);
                    int efuse = Integer.parseInt(efuse_writelist.get(i).split(":")[1]);
                    int saradc = Integer.parseInt(saradc_vdaclist.get(i).split(":")[1]);
                    int func = Integer.parseInt(funclist.get(i).split(":")[1]);
                    int total = good + os + idd + bist + scan + t589 + t575 + ethernet + efuse + saradc + func;
                    totalList.add(total);
                }
                br.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
        }
    }

    /**
     * 3
     *
     * @param filePath
     */


    public void readsoftBins(String filePath) {
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                String lineTxt;
                while ((lineTxt = br.readLine()) != null) {
                    if (lineTxt.contains("[")) {
                        solist.add(lineTxt);
                    }
                    if (lineTxt.contains("good:")) {
                        goodlists.add(lineTxt);
                    }
                    if (lineTxt.contains("cont_gnd:")) {
                        cont_gndlist.add(lineTxt);
                    }
                    if (lineTxt.contains("cont_gnd_cap:")) {
                        cont_gnd_caplist.add(lineTxt);
                    }
                    if (lineTxt.contains("cont_vdd:")) {
                        cont_vddlist.add(lineTxt);
                    }
                    if (lineTxt.contains("cont_vdd_cap:")) {
                        cont_vdd_caplist.add(lineTxt);
                    }
                    if (lineTxt.contains("power_short_gnd:")) {
                        power_short_gndlist.add(lineTxt);
                    }
                    if (lineTxt.contains("idd_all:")) {
                        idd_alllist.add(lineTxt);
                    }
                    if (lineTxt.contains("t550_input_only:")) {
                        t550_input_onlylist.add(lineTxt);
                    }
                    if (lineTxt.contains("t550_output_only:")) {
                        t550_output_onlylist.add(lineTxt);
                    }
                    if (lineTxt.contains("t550_hiz_only_H:")) {
                        t550_hiz_only_Hlist.add(lineTxt);
                    }
                    if (lineTxt.contains("bist_all:")) {
                        bist_alllist.add(lineTxt);
                    }
                    if (lineTxt.contains("bist_rom1:")) {
                        bist_rom1list.add(lineTxt);
                    }
                    if (lineTxt.contains("t1323_400M:")) {
                        t1323_400Mlist.add(lineTxt);
                    }
                    if (lineTxt.contains("t1323_500M:")) {
                        t1323_500Mlist.add(lineTxt);
                    }
                    if (lineTxt.contains("a9_atspeed_scan fail:")) {
                        a9_atspeed_scan_faillist.add(lineTxt);
                    }
                    if (lineTxt.contains("a9_stuckat_scan fail:")) {
                        a9_stuckat_scan_faillist.add(lineTxt);
                    }
                    if (lineTxt.contains("mali_clk:")) {
                        mali_clklist.add(lineTxt);
                    }
                    if (lineTxt.contains("fullchip:")) {
                        fullchiplist.add(lineTxt);
                    }

                    if (lineTxt.contains("pll m1 lock:")) {
                        pll_m1_locklist.add(lineTxt);
                    }
                    if (lineTxt.contains("pll m1 cap:")) {
                        pll_m1_caplist.add(lineTxt);
                    }
                    if (lineTxt.contains("pll m2 cap:")) {
                        pll_m2_caplist.add(lineTxt);
                    }
                    if (lineTxt.contains("t575_ch0:")) {
                        t575_ch0list.add(lineTxt);
                    }
                    if (lineTxt.contains("t575_ch1:")) {
                        t575_ch1list.add(lineTxt);
                    }
                    if (lineTxt.contains("t575_ck:")) {
                        t575_cklist.add(lineTxt);
                    }
                    if (lineTxt.contains("t575_dc H:")) {
                        t575_dclist_H.add(lineTxt);
                    }
                    if (lineTxt.contains("t575_dc L:")) {
                        t575_dc_llist.add(lineTxt);
                    }
                    if (lineTxt.contains("t1216_enet_bist:")) {
                        t1216_enet_bistlist.add(lineTxt);
                    }
                    if (lineTxt.contains("t1217_enet_bist:")) {
                        t1217_enet_bistlist.add(lineTxt);
                    }
                    if (lineTxt.contains("enetdc_42 fail:")) {
                        enetdc_42_faillist.add(lineTxt);
                    }
                    if (lineTxt.contains("t580_efuse fail:")) {
                        t580_efuse_faillist.add(lineTxt);
                    }
                    if (lineTxt.contains("t580_usbbist fail:")) {
                        t580_usbbist_faillist.add(lineTxt);
                    }
                    if (lineTxt.contains("t580_clk_tst_rst fail:")) {
                        t580_clk_tst_rst_faillist.add(lineTxt);
                    }
                    if (lineTxt.contains("t580_ddr fail:")) {
                        t580_ddr_faillist.add(lineTxt);
                    }
                    if (lineTxt.contains("t580_smp fail:")) {
                        t580_smp_faillist.add(lineTxt);
                    }
                    if (lineTxt.contains("write_index2 fail:")) {
                        write_index2_faillist.add(lineTxt);
                    }
                    if (lineTxt.contains("write_index7 fail:")) {
                        write_index7_faillist.add(lineTxt);
                    }
                    if (lineTxt.contains("write_index0 2nd fail:")) {
                        write_index0_faillist.add(lineTxt);
                    }
                    if (lineTxt.contains("t543_cvbs_linear fail:")) {
                        t543_cvbs_linear_faillist.add(lineTxt);
                    }
                    if (lineTxt.contains("audio fail:")) {
                        audio_faillist.add(lineTxt);
                    }


                }
                for (int i = 0; i < goodlists.size(); i++) {
                    int goods = Integer.parseInt(goodlists.get(i).split(":")[1]);
                    int cont_gnd = Integer.parseInt(cont_gndlist.get(i).split(":")[1]);
                    int cont_gnd_cap = Integer.parseInt(cont_gnd_caplist.get(i).split(":")[1]);
                    int cont_vdd = Integer.parseInt(cont_vddlist.get(i).split(":")[1]);
                    int cont_vdd_cap = Integer.parseInt(cont_vdd_caplist.get(i).split(":")[1]);
                    int power_short_gnd = Integer.parseInt(power_short_gndlist.get(i).split(":")[1]);
                    int idd_all = Integer.parseInt(idd_alllist.get(i).split(":")[1]);
                    int t550_input_only = Integer.parseInt(t550_input_onlylist.get(i).split(":")[1]);
                    int t550_output_only = Integer.parseInt(t550_output_onlylist.get(i).split(":")[1]);
                    int t550_hiz_only_H = Integer.parseInt(t550_hiz_only_Hlist.get(i).split(":")[1]);
                    int bist_all = Integer.parseInt(bist_alllist.get(i).split(":")[1]);
                    int bist_rom1 = Integer.parseInt(bist_rom1list.get(i).split(":")[1]);
                    int t1323_400M = Integer.parseInt(t1323_400Mlist.get(i).split(":")[1]);
                    int t1323_500M = Integer.parseInt(t1323_500Mlist.get(i).split(":")[1]);
                    int a9_atspeed_scan = Integer.parseInt(a9_atspeed_scan_faillist.get(i).split(":")[1]);
                    int a9_stuckat_scan = Integer.parseInt(a9_stuckat_scan_faillist.get(i).split(":")[1]);
                    int mali_clk = Integer.parseInt(mali_clklist.get(i).split(":")[1]);
                    int fullchip = Integer.parseInt(fullchiplist.get(i).split(":")[1]);
                    int pll_m1lock = Integer.parseInt(pll_m1_locklist.get(i).split(":")[1]);
                    int pll_m1_cap = Integer.parseInt(pll_m1_caplist.get(i).split(":")[1]);
                    int pll_m2_cap = Integer.parseInt(pll_m2_caplist.get(i).split(":")[1]);
                    int t575_ch0 = Integer.parseInt(t575_ch0list.get(i).split(":")[1]);
                    int t575_ch1 = Integer.parseInt(t575_ch1list.get(i).split(":")[1]);
                    int t575_ck = Integer.parseInt(t575_cklist.get(i).split(":")[1]);
                    int t575_dch = Integer.parseInt(t575_dclist_H.get(i).split(":")[1]);
                    int t575_dcl = Integer.parseInt(t575_dc_llist.get(i).split(":")[1]);
                    int t1216_enet_bist = Integer.parseInt(t1216_enet_bistlist.get(i).split(":")[1]);
                    int t1217_enet_bist = Integer.parseInt(t1217_enet_bistlist.get(i).split(":")[1]);
                    int enetdc_42 = Integer.parseInt(enetdc_42_faillist.get(i).split(":")[1]);
                    int t580_efuse = Integer.parseInt(t580_efuse_faillist.get(i).split(":")[1]);
                    int t580_usbbist = Integer.parseInt(t580_usbbist_faillist.get(i).split(":")[1]);
                    int t580_clk_tst_rst = Integer.parseInt(t580_clk_tst_rst_faillist.get(i).split(":")[1]);
                    int t580_ddr = Integer.parseInt(t580_ddr_faillist.get(i).split(":")[1]);
                    int t580_smp = Integer.parseInt(t580_smp_faillist.get(i).split(":")[1]);
                    int write_index2 = Integer.parseInt(write_index2_faillist.get(i).split(":")[1]);
                    int write_index7 = Integer.parseInt(write_index7_faillist.get(i).split(":")[1]);
                    int write_index0 = Integer.parseInt(write_index0_faillist.get(i).split(":")[1]);
                    int t543_cvbs_linear = Integer.parseInt(t543_cvbs_linear_faillist.get(i).split(":")[1]);
                    int audio = Integer.parseInt(audio_faillist.get(i).split(":")[1]);

                    int total = goods + cont_gnd + cont_gnd_cap + cont_vdd + cont_vdd_cap + power_short_gnd + idd_all +
                            t550_input_only + t550_output_only + t550_hiz_only_H + bist_all + bist_rom1 + t1323_400M +
                            t1323_500M + a9_atspeed_scan + a9_stuckat_scan + mali_clk + fullchip +
                            pll_m1lock + pll_m1_cap + pll_m2_cap + t575_ch0 + t575_ch1 + t575_ck + t575_dch + t575_dcl +
                            t1216_enet_bist + t1217_enet_bist + enetdc_42 + t580_efuse + t580_usbbist + t580_clk_tst_rst +
                            t580_ddr + t580_smp + write_index2 + write_index7 + write_index0 + t543_cvbs_linear + audio;
                    totalLists.add(total);
                }
                br.close();
            } else {
                System.out.println("文件不存在!");
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
        }
    }


}
