package com.shop.vo;

public class SearchCriteria extends PageCriteria{
	private String searchType;
	private String keyword;
	
	public String getSearchType() {
		return searchType;
	}
	
	public void setSearchType(String findType) {
		this.searchType = findType;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return keyword;
	}
	
	@Override
	public String toString() {
		return super.toString() + "   findCriteria"+"[findType="+searchType+", keyword="+keyword+"]";
	}
}
