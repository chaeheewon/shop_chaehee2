package com.shop.service;

import java.util.List;
import java.util.Map;

import com.shop.vo.CartVO;
import com.shop.vo.CtgVO;
import com.shop.vo.ProductVO;
import com.shop.vo.SearchCriteria;

public interface ProductService {
	public List<CtgVO> category() throws Exception;
	
	public void register(ProductVO pvo) throws Exception;
	
	public List<ProductVO> product(SearchCriteria sCria) throws Exception;
	
	public int countSearch(SearchCriteria sCria) throws Exception;
	
	public Map<String,Object> productDtl(String prdCd) throws Exception;
	
	public void delete(String prdCd) throws Exception;

	public void  productUpd(ProductVO pvo);

	public int checkDupProd(String prodCd);
	
	//카트 등록
	public void cartRegister(CartVO cvo) throws Exception;
	
	//카트 업데이트
	public Map<String,Object> cartUpdate(String stringData) throws Exception;
	
	//카트 리스트
	public List<Map<String, Object>> cartList(String custId) throws Exception;
	
}
