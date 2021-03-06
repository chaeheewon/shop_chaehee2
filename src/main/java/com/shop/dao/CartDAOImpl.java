package com.shop.dao;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.shop.vo.CartVO;

@Repository
public class CartDAOImpl implements CartDAO{
	
	@Inject
	private SqlSession session;
	
	// 카트 담기
	@Override
	public void addCart(CartVO cvo) throws Exception {
		session.insert("shoppingCart.insert", cvo);
	}
	
	//카트 리스트
	@Override
	public List<Map<String, Object>> cartMap(String custId) throws Exception {
		List<Map<String, Object>> cartList = session.selectList("shoppingCart.select", custId);
		return cartList;
	}
	
	// 카트 업데이트 전 삭제
	@Override
	public void deleteCartBeforeInsert(String custId) throws Exception {
		session.delete("shoppingCart.deleteCartBeforeInsert", custId);
	}
	
	//카트 일괄 업데이트
	@Override
	public int updateCart(Map<String, Object> updCartMap) throws Exception {
		int rtnVal = session.update("shoppingCart.insertAfterDel",updCartMap);
		return rtnVal;
	}

	//카트 삭제
	@Override
	public int deleteCart(String cartNo) throws Exception {
		int rtnVal = session.delete("shoppingCart.deleteCart", cartNo);
		return rtnVal;
	}
}
