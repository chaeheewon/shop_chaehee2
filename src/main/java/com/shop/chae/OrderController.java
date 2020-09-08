package com.shop.chae;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order/*")
public class OrderController {
	
	// Cart List
	@RequestMapping(value = "orderList" , method = RequestMethod.GET)
	public void orderList (Model model, HttpSession session) throws Exception{
		
		//model.addAttribute("cartList", cartList);
		//return "/cart/shoppingCart";
	}
	
	
/*	rttr.addAttribute로 전달한 값은 url뒤에  붙으며, 
	리프레시해도 데이터가 유지된다.
	반면, rttr.addFlashAttribute로 전달한 값은 url뒤에 붙지 않는다. 
	일회성이라 리프레시할 경우 데이터가 소멸한다.
	또한 2개이상 쓸 경우, 데이터는 소멸되어 null값이 반환된다.
	그래서 맵을 이용하여 값을 전달해야 한다*/
	
}
