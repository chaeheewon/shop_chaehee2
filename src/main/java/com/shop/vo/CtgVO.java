package com.shop.vo;

import java.sql.Date;

public class CtgVO {
	private String ctgNm;
	private String ctgCd;
	private String ctgCdRef;
	private String insUser;
	private Date insDt;
	private String updUser;
	private Date updDt;
	private int level;
	
	public String getCtgNm() {
		return ctgNm;
	}
	public void setCtgNm(String ctgNm) {
		this.ctgNm = ctgNm;
	}
	public String getCtgCd() {
		return ctgCd;
	}
	public void setCtgCd(String ctgCd) {
		this.ctgCd = ctgCd;
	}
	public String getCtgCdRef() {
		return ctgCdRef;
	}
	public void setCtgCdRef(String ctgCdRef) {
		this.ctgCdRef = ctgCdRef;
	}
	public String getInsUser() {
		return insUser;
	}
	public void setInsUser(String insUser) {
		this.insUser = insUser;
	}
	public Date getInsDt() {
		return insDt;
	}
	public void setInsDt(Date insDt) {
		this.insDt = insDt;
	}
	public String getUpdUser() {
		return updUser;
	}
	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}
	public Date getUpdDt() {
		return updDt;
	}
	public void setUpdDt(Date updDt) {
		this.updDt = updDt;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
