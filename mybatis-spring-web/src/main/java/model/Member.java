package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Member implements Serializable{
	private Long IID;
	private String email;
	private String PASSWD;
	private String name;
	private Date regDate;
	public Member() {}
	public Member(Long iID, String email, String pASSWD, String name, Date regDate) {
		IID = iID;
		this.email = email;
		PASSWD = pASSWD;
		this.name = name;
		this.regDate = regDate;
	}
	public Long getIID() {
		return IID;
	}
	public void setIID(Long iID) {
		IID = iID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPASSWD() {
		return PASSWD;
	}
	public void setPASSWD(String pASSWD) {
		PASSWD = pASSWD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}