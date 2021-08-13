package com.fhec.bin;

import java.util.ArrayList;
import java.util.List;

public class Site {
	private int siteno;
	private List<Bin> bin;
	protected int result;
	protected int fail;
	protected int pass;
	protected int total = 1;
	

	public int getSiteno() {
		return siteno;
	}

	public void setSiteno(int siteno) {
		this.siteno = siteno;
	}

	public List<Bin> getBin() {
		return bin;
	}

	

	

	public void setBin(Bin bin) {
		boolean binsts = false;
		if (null == this.bin) {
			this.bin = new ArrayList<>();
		}
		if (bin.getResult()!=-1) {
			for (int i = 0; i < this.bin.size(); i++) {
				if(this.bin.get(i)!=null) {
					if (this.bin.get(i).getHardbinno().equals(bin.getHardbinno())) {
						this.bin.get(i).setResult(bin.getResult());
						int total2 = this.bin.get(i).getTotal();
						total2++;
						this.bin.get(i).setTotal(total2);
						binsts = true;
						break;
					}
				}
				
			}
			if (!binsts)
				this.bin.add(bin);
		}

	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		if(result==-1)
			return ;
		if (result == 1) {
			pass++;
		} else if (result == 2) {
			fail++;
		}
		this.result = result;
	}

	public int getFail() {
		return fail;
	}

	public int getPass() {
		return pass;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
