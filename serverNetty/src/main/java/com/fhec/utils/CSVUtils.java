package com.fhec.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fhec.bin.Bin;
import com.fhec.bin.Site;
import com.fhec.context.MesFileConfig;
import com.fhec.driver.TeradyneDriverInit;
import com.fhec.driver.TeradyneEvent;
import com.fhec.entity.EntityVo;
import com.google.common.collect.Lists;

/**
 * CSV文件输出
 *
 * @author jacob
 * @date 2020-12-12
 * @update 2021-03-24
 */
public class CSVUtils {
    /**
     * 创建批次信息表头
     *
     * @param dataRowList
     * @param dataRowListvalue
     * @throws IOException
     */
    public void creHead(List<String> dataRowList, Map<String, String> dataRowListvalue, OutputStreamWriter ow) throws IOException {

        List<List<String>> dataList = Lists.newArrayList();
        for (int i = 0; i < dataRowList.size(); i++) {
            dataList.add(dataRowList);
        }

        for (int i = 0; i < dataRowList.size(); i++) {
            ow.write(dataRowList.get(i));
            ow.write(",");
            String string = dataRowListvalue.get(dataRowList.get(i));
            if (string == null) string = "";
            ow.write(string);
            ow.write(",");
            ow.write("\r\n");
        }
        ow.write("\r\n");
        ow.write("BIN");
        ow.write("\r\n");
    }

    /**
     * bin 信息
     *
     * @param sites
     * @throws IOException
     */
    public Map<String, Integer> creBinResult(List<Site> sites, OutputStreamWriter ow) throws IOException {
        ow.write("\r\n");
        ow.write(",");
        ow.write("BinResult");
        int size = TeradyneEvent.MaxSite;
        ow.write("\r\n");
        ow.write(",,Site1-" + size + ",BinNo.,BinResult,TOTAL");
        // site pass 数量
        Map<String, Integer> sitepasstotal = new HashMap<>();
        // site fail 数量
        Map<String, Integer> sitefailtotal = new HashMap<>();

        Map<String, Integer> binresult = new HashMap<>();

        int passtotal = 0;
        int failtotal = 0;
        for (int j = 0; j < size; j++) {
            ow.write(",Site" + (j + 1));
            for (int i = 0; i < sites.size(); i++) {
                Site site = sites.get(i);
                if (site != null) {
                    int siteno = site.getSiteno();
                    if (j == siteno) {
                        int pass = site.getPass();
                        int fail = site.getFail();
                        passtotal += pass;
                        failtotal += fail;
                        sitepasstotal.put("site" + (siteno + 1), site.getPass());
                        sitefailtotal.put("site" + (siteno + 1), site.getFail());
                        break;
                    }
                }

            }
        }

        binresult.put("pass", passtotal);
        binresult.put("fail", failtotal);
        for (int i = 0; i < 2; i++) {
            ow.write("\r\n");
            if (i == 0) {
                ow.write(",,," + i + ",PASS," + passtotal);
            } else if (i == 1) {
                ow.write(",,," + i + ",FAIL," + failtotal);
            }
            for (int j = 1; j <= size; j++) {
                if (i == 0) {
                    Integer integer = sitepasstotal.get("site" + j);
                    if (integer == null) {
                        integer = 0;
                    }
                    ow.write("," + integer);
                } else if (i == 1) {
                    Integer integer = sitefailtotal.get("site" + j);
                    if (integer == null) {
                        integer = 0;
                    }
                    ow.write("," + integer);
                }

            }
        }

        ow.write("\r\n");
        return binresult;
    }

    /**
     * Hard bin
     *
     * @throws IOException
     */
    public void HardBin(List<Site> sites, OutputStreamWriter ow) throws IOException {
        int size = TeradyneEvent.MaxSite;
        ow.write(",HardBins");
        ow.write("\r\n");

        List<String> allHardBinno = TeradyneDriverInit.getAllHardBinno();
        List<List<Object>> hradbininfo = new ArrayList<>();
        List<String> title = new ArrayList<>();
        title.add("BinNO.");
        title.add("BinName");
        title.add("BinResult");
        title.add("TOTAL");
        ow.write(",,Site1-" + size);
        for (int i = 1; i <= size; i++) {
            title.add("Site" + i);
        }
        for (int i = 0; i < title.size(); i++) {
            ow.write("," + title.get(i));
        }
        for (String binno : allHardBinno) {
            // site pass 数量
            Map<String, Integer> sitepasstotal = new HashMap<>();
            // site fail 数量
            Map<String, Integer> sitefailtotal = new HashMap<>();
            List<Object> row = new ArrayList<>();
            int binpass = 0;
            int binfail = 0;
            for (Site site : sites) {
                List<Bin> bin = site.getBin();
                int siteno = site.getSiteno();
                int stpasstotal = 0;
                int stfailtotal = 0;
                for (Bin b : bin) {
                    if (b == null)
                        continue;
                    if (binno.equals(b.getHardbinno())) {
                        int result = b.getResult();
                        if (result == 1) {
                            binpass += b.getPass();
                            stpasstotal += b.getPass();
                        } else if (result == 2) {
                            binfail += b.getFail();
                            stfailtotal += b.getFail();
                        }
                        break;
                    }
                }
                sitepasstotal.put("site" + (siteno + 1), stpasstotal);
                sitefailtotal.put("site" + (siteno + 1), stfailtotal);
            }
            row.add(binno);
            row.add("BinName");
            if (binpass > 0) {
                row.add("PASS");
                row.add(String.valueOf(binpass));
                for (int i = 1; i <= size; i++) {
                    Integer integer = sitepasstotal.get("site" + i);
                    if (integer == null) {
                        row.add("0");
                    } else {
                        row.add(sitepasstotal.get("site" + i).toString());
                    }
                }
            } else if (binfail > 0) {
                row.add("FAIL");
                row.add(String.valueOf(binfail));
                for (int i = 1; i <= size; i++) {
                    Integer integer = sitefailtotal.get("site" + i);
                    if (integer == null) {
                        row.add("0");
                    } else {
                        row.add(integer.toString());
                    }

                }
            }
            hradbininfo.add(row);

        }

        for (int i = 0; i < hradbininfo.size(); i++) {
            ow.write("\r\n");
            List<Object> list = hradbininfo.get(i);
            ow.write(",,");
            for (int j = 0; j < list.size(); j++) {

                Object object = list.get(j);
                if (j == 0 || j > 2) {
                    int parseInt = 0;
                    if (object != null) {
                        parseInt = Integer.parseInt(object.toString());
                    }
                    ow.write("," + parseInt);
                } else
                    ow.write("," + list.get(j));
            }
        }
        ow.write("\r\n");
    }

    /**
     * soft bin
     *
     * @throws IOException
     */
    public void SoftBin(List<Site> sites, OutputStreamWriter ow) throws IOException {
        int size = TeradyneEvent.MaxSite;
        ow.write(",SoftBins");
        ow.write("\r\n");
        List<Integer> allsoftbinno = TeradyneDriverInit.getAllsoftbinno();
        List<List<Object>> hradbininfo = new ArrayList<>();
        List<String> title = new ArrayList<>();
        title.add("BinNo.");
        title.add("BinName");
        title.add("BinNO.");
        title.add("BinResult");
        title.add("TOTAL");
        ow.write(",,Site1-" + size);
        for (int i = 1; i <= size; i++) {
            title.add("Site" + i);
        }
        for (int i = 0; i < title.size(); i++) {
            ow.write("," + title.get(i));
        }

        for (Integer binno : allsoftbinno) {
            // site pass 数量
            Map<String, Integer> sitepasstotal = new HashMap<>();
            // site fail 数量
            Map<String, Integer> sitefailtotal = new HashMap<>();
            // hardbin no
            Map<Integer, String> hardbinnomap = new HashMap<>();
            List<Object> row = new ArrayList<>();
            int binpass = 0;
            int binfail = 0;
            for (Site site : sites) {
                List<Bin> bin = site.getBin();
                int siteno = site.getSiteno();
                int stpasstotal = 0;
                int stfailtotal = 0;
                for (Bin b : bin) {
                    if (b == null)
                        continue;
                    String hardbinno = b.getHardbinno();
                    if (b.getSoftbinno() == binno) {
                        int result = b.getResult();
                        if (result == 1) {
                            binpass += b.getPass();
                            stpasstotal += b.getPass();
                        } else if (result == 2) {
                            binfail += b.getFail();
                            stfailtotal += b.getFail();
                        }

                        hardbinnomap.put(binno, hardbinno);
                        break;
                    }
                }
                sitepasstotal.put("site" + (siteno + 1), stpasstotal);
                sitefailtotal.put("site" + (siteno + 1), stfailtotal);
            }
            row.add(binno);
            row.add("BinName");
            String hardbinno = hardbinnomap.get(binno);
            row.add(hardbinno);
            if (binpass > 0) {
                row.add("PASS");
                row.add(String.valueOf(binpass));
                for (int i = 1; i <= size; i++) {
                    Integer integer = sitepasstotal.get("site" + i);
                    if (integer == null) {
                        row.add("0");
                    } else {
                        row.add(integer.toString());
                    }
                }
            } else if (binfail > 0) {
                row.add("FAIL");
                row.add(String.valueOf(binfail));
                for (int i = 1; i <= size; i++) {
                    Integer integer = sitefailtotal.get("site" + i);
                    if (integer == null) {
                        row.add("0");
                    } else {
                        row.add(integer.toString());
                    }

                }
            }
            hradbininfo.add(row);

        }

        for (int i = 0; i < hradbininfo.size(); i++) {
            ow.write("\r\n");
            List<Object> list = hradbininfo.get(i);
            ow.write(",,");
            for (int j = 0; j < list.size(); j++) {
                Object object = list.get(j);
                if (j == 0 || j > 3 || j == 2) {
                    int parseInt = 0;
                    if (object != null) {
                        parseInt = Integer.parseInt(object.toString());
                    }
                    ow.write("," + parseInt);
                } else
                    ow.write("," + list.get(j));

            }
        }
    }


    /**
     * 文件尾
     *
     * @throws IOException
     */
    public void Endbin(OutputStreamWriter ow) throws IOException {
        ow.write("\r\n");
        ow.write("\r\n");
        ow.write("End_Of_Bin");
    }

    /**
     * 实例调用
     *
     * @throws IOException
     */
    public void CSVOutPut(EntityVo entityVo) throws IOException {
        if ("MES".equals(entityVo.getMode())) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String format = sdf.format(new Date());
            TeradyneEvent.proendtime = format;
            List<String> dataRowList = Lists.newArrayList();
            Map<String, String> dataRowListvalue = new HashMap<>();
            MesFileConfig mesFileConfig = entityVo.getMesFileConfig();
            mesFileConfig.getOperator_ID();
            dataRowList.add("FileName:");
            dataRowListvalue.put("FileName:", TeradyneEvent.stdffilepath);
            dataRowList.add("Device_Folder:");
            dataRowListvalue.put("Device_Folder:", TeradyneEvent.stdffilefolder);
            dataRowList.add("");
            dataRowList.add("Summary report");
            dataRowList.add("");
            dataRowList.add("Start_Time:");
            dataRowListvalue.put("Start_Time:", TeradyneEvent.prostattime);
            dataRowList.add("End_Time:");
            dataRowListvalue.put("End_Time:", TeradyneEvent.proendtime);
            dataRowList.add("TesterOS_Version:");
            dataRowListvalue.put("TesterOS_Version:", mesFileConfig.getTesterOS_Version());
            dataRowList.add("Tester_ID:");
            dataRowListvalue.put("Tester_ID:", mesFileConfig.getTester_ID());
            dataRowList.add("Operator_ID:");
            String Operator_ID = entityVo.getjLabelMap().get("Operator_ID") == null ? "" :
                    entityVo.getjLabelMap().get("Operator_ID").getText();
            dataRowListvalue.put("Operator_ID:", Operator_ID);
            dataRowList.add("Customer_ID:");
            dataRowListvalue.put("Customer_ID:", mesFileConfig.getCustomer_ID());
            dataRowList.add("Device_Name:");
            dataRowListvalue.put("Device_Name:", mesFileConfig.getDevice_Name());
            dataRowList.add("Customer_LotNo:");
            dataRowListvalue.put("Customer_LotNo:", mesFileConfig.getCustomer_LotNo());
            dataRowList.add("Sub_LotNo:");
            dataRowListvalue.put("Sub_LotNo:", mesFileConfig.getSub_LotNo());
            dataRowList.add("Program_Name:");
            dataRowListvalue.put("Program_Name:", mesFileConfig.getProgram_Name());
            dataRowList.add("Mode_Code:");
            dataRowListvalue.put("Mode_Code:", mesFileConfig.getMode_Code());
            dataRowList.add("Test_Code:");
            String Test_Code = entityVo.getjLabelMap().get("Test_Code") == null ? "" :
                    entityVo.getjLabelMap().get("Test_Code").getText();
            String Test_BinNo = entityVo.getjLabelMap().get("Test_BinNo") == null ? "" :
                    entityVo.getjLabelMap().get("Test_BinNo").getText();
            dataRowListvalue.put("Test_Code:", Test_Code);
            dataRowList.add("Test_BinNo:");
            dataRowListvalue.put("Test_BinNo:", Test_BinNo);
            dataRowList.add("Channel_Map:");
            String path = entityVo.getLocal_csvdir_folderpath() + File.separator + entityVo.getDatalog_name_rules() + ".csv";
//			String path = "C:\\Users\\jacob\\Desktop\\1" + ".csv";

            File file = new File(path);
            OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream(file), "gbk");
            creHead(dataRowList, dataRowListvalue, ow);
            Map<String, Integer> creBinResult = creBinResult(TeradyneDriverInit.getHardBinSites(), ow);
            Integer passtotal = creBinResult.get("pass");
            TeradyneEvent.goodqty = passtotal;

            Integer failtotal = creBinResult.get("fail");
            TeradyneEvent.failqty = failtotal;
            HardBin(TeradyneDriverInit.getHardBinSites(), ow);
            SoftBin(TeradyneDriverInit.getHardBinSites(), ow);

            System.out.println(path);
            Endbin(ow);
            ow.flush();
            ow.close();
        } else if ("OP".equals(entityVo.getMode())) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String format = sdf.format(new Date());
            TeradyneEvent.proendtime = format;
            List<String> dataRowList = Lists.newArrayList();
            Map<String, String> dataRowListvalue = new HashMap<>();
            dataRowList.add("FileName:");
            dataRowListvalue.put("FileName:", TeradyneEvent.stdffilepath);
            dataRowList.add("Device_Folder:");
            dataRowListvalue.put("Device_Folder:", TeradyneEvent.stdffilefolder);
            dataRowList.add("");
            dataRowList.add("Summary report");
            dataRowList.add("");
            dataRowList.add("Start_Time:");
            dataRowListvalue.put("Start_Time:", TeradyneEvent.prostattime);
            dataRowList.add("End_Time:");
            dataRowListvalue.put("End_Time:", TeradyneEvent.proendtime);
            dataRowList.add("TesterOS_Version:");
            dataRowListvalue.put("TesterOS_Version:",entityVo.getTesterOS_Version());
            dataRowList.add("Tester_ID:");
            dataRowListvalue.put("Tester_ID:", entityVo.getjLabelMap().get("Tester_ID") == null ? "" :
                    entityVo.getjLabelMap().get("Tester_ID").getText()
            );
            dataRowList.add("Operator_ID:");
            String Operator_ID = entityVo.getjLabelMap().get("Operator_ID") == null ? "" :
                    entityVo.getjLabelMap().get("Operator_ID").getText();
            dataRowListvalue.put("Operator_ID:", Operator_ID);
            dataRowList.add("Customer_ID:");
            dataRowListvalue.put("Customer_ID:", entityVo.getjLabelMap().get("Customer_ID") == null ? "" :
                    entityVo.getjLabelMap().get("Customer_ID").getText()
            );
            dataRowList.add("Device_Name:");
            dataRowListvalue.put("Device_Name:", entityVo.getjLabelMap().get("Device_Name") == null ? "" :
                    entityVo.getjLabelMap().get("Device_Name").getText()
            );
            dataRowList.add("Customer_LotNo:");
            dataRowListvalue.put("Customer_LotNo:", entityVo.getjLabelMap().get("Customer_LotNo") == null ? "" :
                    entityVo.getjLabelMap().get("Customer_LotNo").getText()
            );
            dataRowList.add("Sub_LotNo:");
            dataRowListvalue.put("Sub_LotNo:", entityVo.getjLabelMap().get("Sub_LotNo") == null ? "" :
                    entityVo.getjLabelMap().get("Sub_LotNo").getText()
            );
            dataRowList.add("Program_Name:");
            dataRowListvalue.put("Program_Name:", entityVo.getjLabelMap().get("Program_Name") == null ? "" :
                    entityVo.getjLabelMap().get("Program_Name").getText()
            );
            dataRowList.add("Mode_Code:");
            dataRowListvalue.put("Mode_Code:", entityVo.getjLabelMap().get("Mode_Code") == null ? "" :
                    entityVo.getjLabelMap().get("Mode_Code").getText()
            );
            dataRowList.add("Test_Code:");
            String Test_Code = entityVo.getjLabelMap().get("Test_Code") == null ? "" :
                    entityVo.getjLabelMap().get("Test_Code").getText();
            String Test_BinNo = entityVo.getjLabelMap().get("Test_BinNo") == null ? "" :
                    entityVo.getjLabelMap().get("Test_BinNo").getText();
            dataRowListvalue.put("Test_Code:", Test_Code);
            dataRowList.add("Test_BinNo:");
            dataRowListvalue.put("Test_BinNo:", Test_BinNo);
            dataRowList.add("Channel_Map:");
            String path =  entityVo.getLocal_csvdir_folderpath()+ File.separator + entityVo.getDatalog_name_rules() + ".csv";
//			String path = "C:\\Users\\jacob\\Desktop\\1" + ".csv";

            File file = new File(path);
            OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream(file), "gbk");
            creHead(dataRowList, dataRowListvalue, ow);
            Map<String, Integer> creBinResult = creBinResult(TeradyneDriverInit.getHardBinSites(), ow);
            Integer passtotal = creBinResult.get("pass");
            TeradyneEvent.goodqty = passtotal;

            Integer failtotal = creBinResult.get("fail");
            TeradyneEvent.failqty = failtotal;
            HardBin(TeradyneDriverInit.getHardBinSites(), ow);
            SoftBin(TeradyneDriverInit.getHardBinSites(), ow);

            System.out.println(path);
            Endbin(ow);
            ow.flush();
            ow.close();
        }


    }
}
