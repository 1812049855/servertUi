package com.fhec.driver;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import com.fhec.bin.Bin;
import com.fhec.bin.EQPresult;
import com.fhec.bin.Site;
import com.fhec.eqp.TeradyneEquipment;
import com.fhec.views.GridControl;
import com.fhec.views.SummaryView;

/**
 * 
 * @author jacob
 * @Date 2020-11-02
 */
public class TeradyneDriverInit {
	public static boolean DriverModel=false;
	private static TeradyneEquipment teradynedriver;
	private static List<Site> hardbinsites;
	private static List<Site> last100;
	private static List<String> allhardbinno;
	private static List<Integer> allsoftbinno;
	private static EQPresult [] list100device=new EQPresult[100];
	private static List<List<Site>> siteshis = new ArrayList<>();
	public static GridControl[] gridcontrol = new GridControl[6];

	public static void CleanAllList() {
		hardbinsites = new ArrayList<>();
		last100 =  new ArrayList<>();
		list100device = new EQPresult[100];
		allhardbinno =  new ArrayList<>();
		siteshis =  new ArrayList<>();
		allsoftbinno= new ArrayList<>();
	}

	
	public static void setHardbinsites(List<Site> hardbinsites) {
		TeradyneDriverInit.hardbinsites = hardbinsites;
	}


	public static int getHardBinPassTotal() {
		int total = 0;
		if (hardbinsites != null) {
			for (Site s : hardbinsites) {
				int total2 = s.getPass();
				total += total2;
			}
			return total;
		}
		return 0;
	}

	public static int getHardBinFailTotal() {
		int total = 0;
		if (hardbinsites != null) {
			for (Site s : hardbinsites) {
				int total2 = s.getFail();
				total += total2;
			}
			return total;
		}
		return 0;
	}

	public static int getHardBinSitesTotal() {
		int total = 0;
		if (hardbinsites != null) {
			for (Site s : hardbinsites) {
				int total2 = s.getTotal();
				total += total2;
			}
			return total;
		}
		return 0;
	}

	public static List<Site> getLast100() {
		if(null==last100)last100=new ArrayList<>();
		return last100;
	}

	public static List<String> getAllHardBinno() {
		if (null == allhardbinno)
			allhardbinno = new ArrayList<>();

		return allhardbinno;
	}

	public static void cleanAllHardBinno() {
		allhardbinno = null;
		allsoftbinno=null;
	}

	public static void setAllHardBinno(String binno,int result) {
		if(result==-1) 
			return;
		boolean binsts = false;
		if (null == allhardbinno) {
			allhardbinno = new ArrayList<>();
		}
		for (String string : allhardbinno) {
			if (string.equals(binno)) {
				binsts = true;
				break;
			}
		}
		if (!binsts)
			allhardbinno.add(binno);
	}
	

	public static List<Integer> getAllsoftbinno() {
		if (null == allsoftbinno)
			allsoftbinno = new ArrayList<>();

		return allsoftbinno;
	}

	public static void setAllsoftbinno(int binno,int result) {
		if(result==-1)
			return;
		boolean binsts = false;
		if (null == allsoftbinno) {
			allsoftbinno = new ArrayList<>();
		}
		for (Integer ints : allsoftbinno) {
			if (ints==binno) {
				binsts = true;
				break;
			}
		}
		if (!binsts)
			allsoftbinno.add(binno);
		 
	}
	public static void setList100device(EQPresult eqpresult, int maxsize) {
		EQPresult eqPresult2 = list100device[99];
		if(eqPresult2!=null) {
			EQPresult [] site=new EQPresult[100];
			for (int i = 0; i <site.length-1; i++) {
				if(list100device[i+1]!=null) {
					site[i]=list100device[i+1];
				}
			}
			site[site.length-1]=eqpresult;
			list100device=site;
		}else {
			for (int i = 0; i < list100device.length; i++) {
				if(list100device[i]==null) {
					list100device[i]=eqpresult;
					break;
				}
				
				
			}
		}

	}
	
    public static void reFreshLast100() { 
    	if(list100device!=null) {
    		for (int i = 0; i < TeradyneEvent.MaxSite; i++) {
    			for (EQPresult item : list100device) {
    				if(null!=item) {
    					if (i == item.getSiteno()) {
    						Site site = new Site();
    						site.setSiteno(item.getSiteno());
    						site.setResult(item.getResult()); 
    						Bin bin = new Bin();
    						bin.setHardbinno(item.getBinno());
    						bin.setResult(item.getResult());
    						bin.setSoftbinno(item.getSoftno());
    						setlast100Sites(site, bin);
    					}
    				}

    			}

    		}
        	SummaryView.Latest100Devices(gridcontrol, TeradyneEvent.MaxSite, last100);
    		last100 = null;
    	}
    	
    }
	public static void cleanList100Device() {
		list100device = null;
	}

	public static List<List<Site>> getSiteshis() {
		return siteshis;
	}

	public static void setSiteshis(List<Site> siteshise) {
		siteshis.add(siteshise);
	}

	public static List<Site> getHardBinSites() {
		if(hardbinsites==null)hardbinsites= new ArrayList<>();
		return hardbinsites;
	}

	public static void cleanHardBinSites() {
		hardbinsites = null;
	}

	static JComponent createTextPanel;

	public static void setlast100Sites(Site site, Bin bin) {
		boolean sitests = false;
		if (last100 == null) {
			last100 = new ArrayList<>();

		}

		for (int i = 0; i < last100.size(); i++) {
			if(last100.get(i)!=null) {
				if (last100.get(i).getSiteno() == site.getSiteno()) {
					last100.get(i).setBin(bin);
					sitests = true;
					last100.get(i).setResult(site.getResult());
					int total = last100.get(i).getTotal();
					total++;
					last100.get(i).setTotal(total);
					break;
				}
			}
			
		}

		if (!sitests) {
			site.setBin(bin);
			last100.add(site);
		}

	}

	public static void setHardBinSites(Site site, Bin bin) {
		if(bin.getResult()==-1)
			return;
		boolean sitests = false;
		if (hardbinsites == null) {
			hardbinsites = new ArrayList<>();

		}
		for (int i = 0; i < hardbinsites.size(); i++) {
			if (hardbinsites.get(i)!=null) {
				if (hardbinsites.get(i).getSiteno() == site.getSiteno()) {
					hardbinsites.get(i).setBin(bin);
					sitests = true;
					hardbinsites.get(i).setResult(site.getResult());
					int total = hardbinsites.get(i).getTotal();
					total++;
					hardbinsites.get(i).setTotal(total);
					break;
				}
			}
			
		}

		if (!sitests) {
			site.setBin(bin);
			hardbinsites.add(site);
		}
		

	}

	public static void refreshHardBin() {
		if (hardbinsites!=null) {
			SummaryView.allDevices(gridcontrol, TeradyneEvent.MaxSite, hardbinsites);

		}
	}
	public static void createTextPane(int maxsites) {

	}

	private TeradyneDriverInit() {

	}

	public static TeradyneEquipment TeradyneInstantia() {

		if (null == teradynedriver) {
			teradynedriver = new TeradyneEquipment("EquipmentInterfaceApi.EQPcls");
			System.out.println("new");
		}
		return teradynedriver;
	}
}
