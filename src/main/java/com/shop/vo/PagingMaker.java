package com.shop.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PagingMaker {
	private int totalData; 	                 // 전체 페이지갯수
	private int startPage;		             // 페이지목록의 시작번호
	private int endPage; 	                 // 페이지목록의 끝번호
	private boolean prev;                   //이전 버튼을 나타내는 불린 값
	private boolean next;                   //다음버튼을 나타내는 불린 값
	private int displayPageNum = 5; 	 //페이지 목록에 나타낼 페이지 번호의 수
	private PageCriteria cri;
	
	public void setCri(PageCriteria cri) {
		this.cri = cri;
	}

	public PageCriteria getCri() {
		return cri;
	}
	
	public void setTotalData(int totalData) {
		this.totalData = totalData;
		getPagingData();
	}
	
	private void getPagingData() {
		endPage = (int)(Math.ceil (cri.getPage() / (double)displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) +1;
		int finalEndPage = (int)(Math.ceil (totalData/(double)cri.getNumPerPage()));
		
		if(endPage > finalEndPage) {
			endPage = finalEndPage;
		}
		prev = startPage == 1? false:true;
		
		next = endPage*cri.getNumPerPage() >= totalData ? false : true;
	}//getPagingData()
	
	// 페이징
	public String makeURI(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				             .queryParam("page", page)
				             .queryParam("numPerPage", cri.getNumPerPage())
				             .build();
		
		return uriComponents.toUriString();
	}

	// 페이징+검색
	public String makeSearch (int page) {
		
		//UriComponents클래스는 Path나 query에 해당하는 문자열들을 추가해서 원하는 URI를 생성할 때 사용
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("numPerPage", cri.getNumPerPage())
				.queryParam("searchType", ((SearchCriteria)cri).getSearchType())
				.queryParam("keyword", encodeURIComponent(((SearchCriteria)cri).getKeyword()))
				.build();
		
		//System.out.println(uriComponents.toUriString());
		return uriComponents.toUriString();
	}

	private String encodeURIComponent(String keyword) {
		if(keyword == null || keyword.trim().length() == 0) {
			return "";
		}
		try {
			return URLEncoder.encode(keyword, "UTF-8");
		}catch(UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalData() {
		return totalData;
	}
}
