package com.shop.service;

import java.util.List;
import java.util.Map;

import com.shop.vo.CartVO;

public interface CartService {
	
	//카트 리스트
	public List<Map<String, Object>> cartList(String custId) throws Exception;
	
	//카트 등록
	public void cartRegister(CartVO cvo) throws Exception;
	
	//카트 업데이트
	public Map<String,Object> cartUpdate(String stringData, String userId) throws Exception;
	
	//카트 삭제
	public int cartDelete(List<String> cartNoArr) throws Exception;
	
}
