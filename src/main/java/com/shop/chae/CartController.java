package com.shop.chae;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shop.service.CartService;
import com.shop.vo.CartVO;
import com.shop.vo.UserSignUpVO;

@Controller
@RequestMapping("/cart/*")
public class CartController {
	@Inject
	private CartService cartService;
	
	// Cart List
	@RequestMapping(value = "shoppingCart" , method = RequestMethod.GET)
	public void cartList (Model model, HttpSession session) throws Exception{
		
		// 로그인한 session 정보 가져오기(객체)
		UserSignUpVO userObj = (UserSignUpVO)session.getAttribute("login");
		// 세션 객체에 사용자id를  카트에 담는다.
		String custId = userObj.getSignUpUserId();
		
		List<Map<String, Object>> cartList = new ArrayList<Map<String, Object>>();
		if(custId != null) {
			cartList = cartService.cartList(custId);
		} 
		
		model.addAttribute("cartList", cartList);
		//return "/cart/shoppingCart";
	}
	
	// Cart 담기
	@ResponseBody
	@RequestMapping(value = "addCart" , method = RequestMethod.POST)
	public int addCart(CartVO cvo, HttpSession session) throws Exception{
		
		// 로그인한 session 정보 가져오기
		UserSignUpVO user = (UserSignUpVO)session.getAttribute("login");
		
		//return 값
		int rtnVal = 0;
		
		// 로그인한 사용자만 카트 담기
		if(user != null) {
			cvo.setCustId(user.getSignUpUserId());
			cartService.cartRegister(cvo);		
			rtnVal = 1;
		}
		return rtnVal;
	}
	
	
	//Cart 업데이트
	//@ResponseBody
	@RequestMapping(value = "updateCart", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateCart(@RequestParam String stringObj, HttpSession session) throws Exception{
		System.out.println("stringData= "+stringObj);
		// 로그인한 session 정보 가져오기(객체)
		UserSignUpVO userObj = (UserSignUpVO) session.getAttribute("login");
		
		//사용자 객체에서 사용자id 변수 저장
		String custId = userObj.getSignUpUserId();
		
		Map<String, Object> rtnMap = cartService.cartUpdate(stringObj, custId);
		return rtnMap;
	}
	
	//Cart 삭제
	@ResponseBody
	@RequestMapping(value = "deleteCart", method = RequestMethod.POST)
	public Map<String, Object> deleteCart(@RequestParam(value = "cartNoArr[]") List<String>cartNoArr, HttpSession session) throws Exception{
		
		UserSignUpVO userObj = (UserSignUpVO)session.getAttribute("login");
		// 세션 로그인아이디
		String userId = userObj.getSignUpUserId();
		
		Map<String, Object> rtnResult = new HashMap<String, Object>();
		int rtnCnt = 0; // 리턴값
		
		if(userId.length() > 0) {
			rtnCnt = cartService.cartDelete(cartNoArr);
			if(rtnCnt > 0) {	
				rtnResult.put("result", "success");
			}else {
				rtnResult.put("result", "fail");
			}
		}else {
			rtnResult.put("result", "notLogin");
		}
		return rtnResult;
	}
	
	
/*	rttr.addAttribute로 전달한 값은 url뒤에  붙으며, 
	리프레시해도 데이터가 유지된다.
	반면, rttr.addFlashAttribute로 전달한 값은 url뒤에 붙지 않는다. 
	일회성이라 리프레시할 경우 데이터가 소멸한다.
	또한 2개이상 쓸 경우, 데이터는 소멸되어 null값이 반환된다.
	그래서 맵을 이용하여 값을 전달해야 한다*/
	
}
