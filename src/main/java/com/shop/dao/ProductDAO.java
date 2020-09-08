package com.shop.dao;

import java.util.List;
import java.util.Map;

import com.shop.vo.CartVO;
import com.shop.vo.CtgVO;
import com.shop.vo.ProductVO;
import com.shop.vo.SearchCriteria;

public interface ProductDAO {
	//카테고리
	public List<CtgVO> category() throws Exception;
	
	//등록
	public void register(ProductVO pvo) throws Exception;
	
	//목록조회
	public List<ProductVO> product(SearchCriteria sCria) throws Exception;
	
	public int countSearch(SearchCriteria sCria) throws Exception;
	
	public Map<String,Object> prdDtl(String prdCd) throws Exception;

	public void delete(String prdCd) throws Exception;

	public void update(ProductVO pvo);

	public int checkDupProd(String prodCd);
	
	//카트담기
	public void addCart(CartVO cvo) throws Exception;
	
	//카트 리스트
	public List<Map<String, Object>> cartMap(String custId) throws Exception;
	
}
