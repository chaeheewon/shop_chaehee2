package com.shop.vo;

public class PageCriteria {

	private int page;				// 페이지 번호
	private int numPerPage;      // 페이지 사이즈(한 페이지당 출력 갯수)
	
	public PageCriteria() {
		this.page = 1;
		this.numPerPage = 6;
	}
	
	public void setPage(int page) {
		if(page<= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	public void setNumPerPage(int numPerPage) {
		if(numPerPage <= 0 || numPerPage >100) {
			this.numPerPage = numPerPage;
		}
	}
	public int getPage() {
		return page;
	}
	
	//현재 '(페이지 번호 - 1) x 페이지 사이즈' 
	public int getStartPage() {
		//시작페이지 
		int startPage = (this.page-1)*numPerPage;
		return startPage;
	}
	public int getNumPerPage() {
		return this.numPerPage;
	}
	@Override
	public String toString() {
		return "PageCriteria [page="+page+","+"numPerPage="+numPerPage+"]";
	}
}
