package com.fhec.bin;

public class EQPresult {
	private String binno;
	private int siteno;
	private int result;
	private int softno;

	public EQPresult(String binno, int siteno, int result,int softno) {
		if(result==-1)return;
		this.binno = binno;
		this.siteno = siteno;
		this.result = result;
		this.softno=softno;
	}

	public String getBinno() {
		return binno;
	}

	public void setBinno(String binno) {
		this.binno = binno;
	}

	public int getSiteno() {
		return siteno;
	}

	public void setSiteno(int siteno) {
		this.siteno = siteno;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getSoftno() {
		return softno;
	}

	public void setSoftno(int softno) {
		this.softno = softno;
	}
	
}
