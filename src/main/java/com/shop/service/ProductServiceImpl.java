package com.shop.service;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.shop.dao.ProductDAO;
import com.shop.vo.CartVO;
import com.shop.vo.CtgVO;
import com.shop.vo.ProductVO;
import com.shop.vo.SearchCriteria;

@Service
public class ProductServiceImpl implements ProductService{

	@Inject
	private ProductDAO dao;

	@Override
	public List<CtgVO> category() throws Exception {
		return dao.category();
	}

	@Override
	public void register(ProductVO pvo) throws Exception {
		dao.register(pvo);
	}
	
	// 품목 리스트 조회(페이징 + 검색)
	@Override
	public List<ProductVO> product(SearchCriteria sCria) throws Exception {
		return dao.product(sCria);
	}

	@Override
	public int countSearch(SearchCriteria sCria) throws Exception {
		return dao.countSearch(sCria);
	}
	
	@Override
	public Map<String, Object> productDtl(String prodCd) throws Exception {
		return dao.prdDtl(prodCd);
	}

	@Override
	public void delete(String prdCd) throws Exception {
		dao.delete(prdCd);
	}

	@Override
	public void productUpd(ProductVO pvo) {
		dao.update(pvo);
	}

	@Override
	public int checkDupProd(String prodCd) {
		int rtnVal = dao.checkDupProd(prodCd);
		return rtnVal; 
	}
	
	//카트 담기
	@Override
	public void cartRegister(CartVO cvo) throws Exception {
		dao.addCart(cvo);
	}
	
	//카트 리스트
	@Override
	public List<Map<String, Object>> cartList(String custId) throws Exception {
		List<Map<String, Object>> cartList = dao.cartMap(custId);
		return cartList;
	}
	
	//카트 업데이트
	@Override
	public Map<String, Object> cartUpdate(String stringData) throws Exception {
		
		return null;
	}
}
