package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cca implements Serializable{
	private int cnum;
	private int bnum;
	private int anum;
	private String cname;
	public Cca() {}
	public Cca(int cnum, int bnum, int anum, String cname) {
		this.cnum = cnum;
		this.bnum = bnum;
		this.anum = anum;
		this.cname = cname;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
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
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
}
