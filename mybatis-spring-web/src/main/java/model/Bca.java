package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Bca implements Serializable{
	private int bnum;
	private int anum;
	private String bname;
	public Bca() {}
	public Bca(int bnum, int anum, String bname) {
		this.bnum = bnum;
		this.anum = anum;
		this.bname = bname;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public int getAnum() {
		return anum;
	}
	public void setAnum(int anum) {
		this.anum = anum;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
}
