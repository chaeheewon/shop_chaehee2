package com.shop.vo;

import java.util.Date;

/*CART VO*/
public class CartVO {
	private int cartNo;
	private String custId;
	private String prodCd;
	private String cartStock;
	private String insUser;
	private Date insDt;
	private String updUser;
	private Date updDt;
	
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getProdCd() {
		return prodCd;
	}
	public void setProdCd(String prodCd) {
		this.prodCd = prodCd;
	}
	public String getCartStock() {
		return cartStock;
	}
	public void setCartStock(String cartStock) {
		this.cartStock = cartStock;
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
	@Override
	public String toString() {
		return "CartVO [cartNo=" + cartNo + ", custId=" + custId + ", prodCd=" + prodCd + ", cartStock=" + cartStock
				+ ", insUser=" + insUser + ", insDt=" + insDt + ", updUser=" + updUser + ", updDt=" + updDt
				+ ", getCartNo()=" + getCartNo() + ", getCustId()=" + getCustId() + ", getProdCd()=" + getProdCd()
				+ ", getCartStock()=" + getCartStock() + ", getInsUser()=" + getInsUser() + ", getInsDt()=" + getInsDt()
				+ ", getUpdUser()=" + getUpdUser() + ", getUpdDt()=" + getUpdDt() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
