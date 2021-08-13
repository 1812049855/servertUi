package com.fhec.bin;

public class Bin extends Site{
	
	private String hardbinno;
	private int softbinno;
	
	public String getHardbinno() {
		return hardbinno;
	}
	public void setHardbinno(String hardbinno) {
		this.hardbinno = hardbinno;
	}
	
	public int getSoftbinno() {
		return softbinno;
	}
	public void setSoftbinno(int softbinno) {
		this.softbinno = softbinno;
	}
	@Override
	public int getTotal() {
		return this.total;
	}
	@Override
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public int getFail() {
		return this.fail;
	}
	 
	@Override
	public int getPass() {
		return this.pass;
	}
	 
	@Override
	public void setResult(int result) {
		if(result==1) {
			this.pass++;
		}else if(result==2) {
			this.fail++;
		}
		this.result = result;
	}
	
	
}
