package com.fhec.utils;

import com.fhec.entity.EntityVo;
import com.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class SummaryHtml {
 
	
	public static String appendBinInfo(String str,List<String> alltestcode,List<List<String>> va2) {
		 str += "    <tr><td>BinName</td>	<td>BinID</td> ";
	
		 for (String testcode : alltestcode) {
			 str+="<td>"+testcode+"</td>";
		}
		 str+="<td>Final</td>	<td>Percent</td></tr>";
		 for (int i = 0; i < va2.size(); i++) {
			 List<String> list = va2.get(i);
			 str+="<tr>";
			 for (int j = 0; j < list.size(); j++) {
				 str += "<td>"+list.get(j)+"</td>";
			}
			str+="</tr>";
			
		}
		return str;
	}
	public static String appendHeaderInfoBody(String str,List<List<String>>list) {
		for (int i = 0; i < list.size(); i++) {
			str+="<tr>";
			List<String> list2 = list.get(i);
			for (int j = 0; j < list2.size(); j++) {
				str+="<td>"+list2.get(j)+"</td>";
			}
			str+="</tr>";
		}
	 return str;
	}
	public static void Html(List<List<String>> hardbin,List<String> alltestcode,List<List<String>>handbinbody,List<List<String>>softbinbody,String testtotal,EntityVo entityVo) throws FileNotFoundException {
		String str = "";
		str += "<html><head>";
		str += "	<style type=\"text/css\">	.bin_alarm_style";
		str += "	{";
		str += "	 background-color:yellow;";
		str += "	 color:rgb(255,0,0);";
		str += "	}";
		str += "	</style>";
		str += "</head>";
		str += "	<body>";
		str += "	<p>[Header Info]</p>";
		str += "	<table border=\"1\">";
		str += "<tbody>";
		str=appendHeaderInfoBody(str,hardbin);
		str += "	</tbody></table><p>HardBins</p><table>	";
		str += "	</table><table border=\"1\">";
		str += "	<tbody>";
		str  = appendBinInfo(str,alltestcode,handbinbody);
		str += "	</tbody></table>";
		str += "<p>Total Tested:"+testtotal+"</p>";
		str += "";
		str += "	<p>SoftBins</p>";
		str += "	<table border=\"1\">";
		str += "	<tbody>";
		str = appendBinInfo(str,alltestcode,softbinbody);
		str += "</tbody></table>";
		str += "<p>Total Tested:"+testtotal+" </p>";
		str += "";
		str += "	";
		str += "";
		str += "</body></html>";
		String html = entityVo.getLocal_fulllotfile_folderpath()+ File.separator + entityVo.getDatalog_name_rules()
				+ ".html";
//		String htmltest="C:\\Users\\jacob\\Desktop\\a.html";
	    PrintStream pring=new PrintStream(new FileOutputStream(new File(html)));
		pring.print(str);
		pring.close();
	 

	}
	public static List<String> getTestCodeValue(Set<String> allSectionKey,String key,SectionReader se) {
		List<String> HeaderInfobody=new ArrayList<>();
		HeaderInfobody.add(key);
		for (String string : allSectionKey) {
			String keyvalue = se.getValue(string, key);
			HeaderInfobody.add(keyvalue);
		}
		return HeaderInfobody;
	}
	
	/**
	 * 
	 * @param keySet 所有bin key 
	 * @param testcodebininfo testcode 每个bin信息
	 * @param binresult bin结果
	 * @param totalsum  测试总数
	 * @param binBody  表体
	 * @param lasthardbininfo hardbin最后一行 汇总
	 */
	public static void setBinBody(Set<String> keySet,List<Map<String, String>>testcodebininfo,
			Map<String, String>binresult,String totalsum,List<List<String>>binBody,List<String> lasthardbininfo) {
		 int finalsum=0;
		 for (String string : keySet) {
			 List<String> bininfo=new ArrayList<>();
			 String result = binresult.get(string);
			 bininfo.add("");
			 bininfo.add(string);
			 int failtotal=0;
			 for (int i = 0; i < testcodebininfo.size(); i++) {
				 Map<String, String> map = testcodebininfo.get(i);
				 String binnumber = map.get(string)==null?"":map.get(string);
				 String parse=binnumber.equals("")?"0":binnumber;
				 int parseInt = Integer.parseInt(parse);
				 if("PASS".equals(result)) {
					 failtotal+=parseInt;
				 }
				 if("FAIL".equals(result)) {
					 if(i==testcodebininfo.size()-1) {
						 failtotal=parseInt;
					 }
				 }
				 finalsum+=failtotal;
				 bininfo.add(binnumber);
				
			}
			 
			
			 String failtotalsum = String.valueOf(failtotal).equals("0")?"":String.valueOf(failtotal);
			 bininfo.add(failtotalsum);
			 
			 double Tested_Qty = Double.parseDouble(totalsum);
			 if(failtotal==0) {
				 bininfo.add("0%");
			 }else {
				 double Percentnum=failtotal/Tested_Qty*100;
				 DecimalFormat df = new DecimalFormat("#0.###");
				 String Percent = df.format(Percentnum)+"%";
				 bininfo.add(Percent);
			 }
			 
			 binBody.add(bininfo);
		}
		 
		 
	
		if(lasthardbininfo!=null&&lasthardbininfo.size()>0) {
			 String fintatal = String.valueOf(finalsum);
			 lasthardbininfo.add(fintatal);
			 lasthardbininfo.add("");
			 binBody.add(lasthardbininfo);
		}
		 
		
	}
	
	
	public static void getBinBody(Map<String, String>csvfiles,List<String>alltestcode,Map<String, String>hardbinnomap
			,Map<String, String>softinnomap,List<Map<String, String>>testcodehandbininfo
			,List<Map<String, String>>testcodesoftbininfo) throws IOException {
		for (int i = 0; i < alltestcode.size(); i++) {
			String testcode = alltestcode.get(i);
			String csvfile = csvfiles.get(testcode);
			 //获取config文件中csv数据
			 CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(csvfile),"gbk"));

			 Map<String, String>hardbinnototal=new HashMap<>();
			 
			 Map<String, String>softbinnototal=new HashMap<>();
			 
			 String key="";
		      /*
		       * 逐行读取
		       */
		      String[] strArr = null;
		      while((strArr = reader.readNext())!=null){
		    	  if(strArr==null||strArr.length==0) {
		    		  
		    		  continue;
		    	  }
		    	  if(strArr.length>=2) {
			    		  if("HardBins".equals(strArr[1])) {
				    		  key=strArr[1];
				    		  continue;
				    	  }
				    	  if("SoftBins".equals(strArr[1])) {
				    		  key=strArr[1];
				    		  continue;
				    	  }
			    	   
		    	  }
			      if(strArr.length>=8) {
			    	  if("HardBins".equals(key)) {
			    		  if(StringUtils.isNumeric(strArr[3])) {
			    			  hardbinnomap.put(strArr[3], strArr[5]);
			    			  hardbinnototal.put(strArr[3], strArr[6]);
			    		  }
			    	  }
			    	  if("SoftBins".equals(key)) {
			    		  if(StringUtils.isNumeric(strArr[3])) {
			    			  softinnomap.put(strArr[3], strArr[6]);
			    			  softbinnototal.put(strArr[3], strArr[7]);
			    		  }
			    	  }
	    	   
			      }
			    		
		    	 
		    	  if("End_Of_Bin".equals(strArr[0])) 
		    		   break;
		    	   
		      }

		      reader.close();
		      testcodehandbininfo.add(hardbinnototal);
		      testcodesoftbininfo.add(softbinnototal);
			
		}
	}
	public static void setHeaderInfoBody(List<List<String>> HeaderInfoBody,Map<String, String>csvfiles
			,Set<String> allSectionKey,Map<String, String>common,List<String> alltestcode,SectionReader se) {
		String [] headertableinfo= {
				"ConfigurationOptions","Start_Time","End_Time","TesterOS_Version"
				,"Tester_ID","Operator_ID","Customer_ID","Program_Name"
				,"Device_Name","Customer_LotNo","Sub_LotNo","Mode_Code"
				,"Test_Code","Test_BinNo"
					
			};
		 
			for (String string : allSectionKey) {
				int lastR = string.lastIndexOf(" ")+1;
				String testcode = string.substring(lastR,string.length());
				alltestcode.add(testcode);
				
				String csvfile = se.getValue(string, "CSV File");
				String Tested_Qty = se.getValue(string, "Tested_Qty");
				csvfiles.put(testcode, csvfile);
				common.put(testcode+"Tested_Qty", Tested_Qty);
			}
			Collections.sort(alltestcode);
			for (int i = 0; i < headertableinfo.length; i++) {
				String harder=headertableinfo[i];
				List<String> HeaderInfobody  =new ArrayList<>();
				switch (harder) {
				case "ConfigurationOptions":
					HeaderInfobody.add(harder);
					for (int j = 0; j < alltestcode.size(); j++) {
						HeaderInfobody.add(alltestcode.get(j));
					}
					break;
				case "Start_Time":
					HeaderInfobody = getTestCodeValue(allSectionKey,harder,se);
				break;
				case "End_Time":
					HeaderInfobody = getTestCodeValue(allSectionKey,harder,se);
				break; 
				case "TesterOS_Version":
					HeaderInfobody = getTestCodeValue(allSectionKey,harder,se);
				break; 
				case "Tester_ID":
					HeaderInfobody = getTestCodeValue(allSectionKey,harder,se);
				break; 
				case "Operator_ID":
					HeaderInfobody = getTestCodeValue(allSectionKey,harder,se);
				break; 
				case "Customer_ID":
					HeaderInfobody = getTestCodeValue(allSectionKey,harder,se);
				break; 
				case "Program_Name":
					HeaderInfobody = getTestCodeValue(allSectionKey,harder,se);
				break; 
				case "Device_Name":
					HeaderInfobody = getTestCodeValue(allSectionKey,harder,se);
				break; 
				case "Customer_LotNo":
					HeaderInfobody = getTestCodeValue(allSectionKey,harder,se);
				break; 
				case "Sub_LotNo":
					HeaderInfobody = getTestCodeValue(allSectionKey,harder,se);
				break; 
				case "Mode_Code":
					HeaderInfobody = getTestCodeValue(allSectionKey,harder,se);
				break; 
				case "Test_Code":
					HeaderInfobody = getTestCodeValue(allSectionKey,harder,se);
				break; 
				case "Test_BinNo":
					HeaderInfobody = getTestCodeValue(allSectionKey,harder,se);
				break; 
			  

				default:
					break;
				}
				HeaderInfoBody.add(HeaderInfobody);
			}
	}
	
	/**
	 * 汇总summary 文件生成
	 * @param entityVo shitil
	 * @throws IOException
	 */
	public static void summaryHtmlOutPut(EntityVo entityVo) throws IOException {
		SectionReader se=new SectionReader(EntityVo.configTxt);
		Set<String> allSectionKey = se.getAllSectionKey();
		List<String> alltestcode=new ArrayList<>();
		List<List<String>> HeaderInfoBody=new ArrayList<>();
		Map<String, String>csvfiles=new HashMap<>();
		Map<String, String>common=new HashMap<>();
	
		
		setHeaderInfoBody(HeaderInfoBody, csvfiles, allSectionKey, common, alltestcode, se);
		
		Map<String, String>hardbinnomap=new HashMap<>();
		Map<String, String>softinnomap=new HashMap<>();
		
		List<Map<String, String>>testcodehandbininfo=new ArrayList<>();
		List<Map<String, String>>testcodesoftbininfo=new ArrayList<>();
		
		//获取BIN数据 
		getBinBody(csvfiles, alltestcode, hardbinnomap,softinnomap,testcodehandbininfo,testcodesoftbininfo);
		
		 List<List<String>>hardbinBody=new ArrayList<>();
		 
		 List<List<String>>softbinBody=new ArrayList<>();
		 
		 int totalcount=0;
		 
		 List<String> lasthardbininfo=new ArrayList<>();
		 lasthardbininfo.add("");
		 lasthardbininfo.add("Total");
		
		 for (int i = 0; i < alltestcode.size(); i++) {
			 String testcode = alltestcode.get(i);
			 String gettestcodenum = common.get(testcode+"Tested_Qty");
			 
			 String substring = testcode.substring(1,2);
			 if("0".equals(substring)) {
				 int parseInt = Integer.parseInt(gettestcodenum);
				 totalcount+=parseInt;
			 }
			 
			 lasthardbininfo.add(gettestcodenum);
		}
		
		 String totalsum = String.valueOf(totalcount);
		 
		 Set<String> hardbinkeySet = hardbinnomap.keySet();
		 //设置hardbin数据
		 setBinBody(hardbinkeySet, testcodehandbininfo, hardbinnomap, totalsum, hardbinBody, lasthardbininfo);
		 
		 Set<String> softbinkeySet = softinnomap.keySet();
		 //设置softbin数据
		 setBinBody(softbinkeySet, testcodesoftbininfo, softinnomap, totalsum, softbinBody, null);
		 
		 
		
		 Html(HeaderInfoBody,alltestcode,hardbinBody,softbinBody,totalsum,entityVo);
 
	 
	}
}
