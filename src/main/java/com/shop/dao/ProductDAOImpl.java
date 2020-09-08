package com.shop.dao;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.shop.vo.CartVO;
import com.shop.vo.CtgVO;
import com.shop.vo.ProductVO;
import com.shop.vo.SearchCriteria;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Inject
	private SqlSession session;
	
	//상품 list
	@Override
	public List<CtgVO> category() throws Exception {
		return session.selectList("Ebiz.CtgList");
	}

	//상품등록
	@Override
	public void register(ProductVO pvo) throws Exception {
		session.insert("Ebiz.register",pvo);
	}

	//상품목록
	@Override
	public List<ProductVO> product(SearchCriteria sCria) throws Exception {
		return session.selectList("Ebiz.productList" ,sCria);
	}

	@Override
	public int countSearch(SearchCriteria sCria) throws Exception {
		return session.selectOne("Ebiz.countSearch", sCria);
	}
	
	//상품상세
	@Override
	public Map<String, Object> prdDtl(String prdCd) throws Exception {
		return session.selectOne("Ebiz.productDetail", prdCd);
	}
	
	//상품삭제
	@Override
	public void delete(String prdCd) {
		session.delete("Ebiz.delete",prdCd);
	}

	//품목정보 업데이트
	@Override
	public void update(ProductVO pvo) {
		session.update("Ebiz.update",pvo);
	}

	//품목정보 중복 체크
	@Override
	public int checkDupProd(String prodCd) {
		int rtnVal = session.selectOne("Ebiz.prodDupCheck", prodCd);
		return rtnVal;
	}
	
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
}
