package com.shop.chae;

import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shop.exception.AlreadyExistingEmailException;
import com.shop.exception.AlreadyExistingIdException;
import com.shop.service.UserAccountService;
import com.shop.vo.UserSignUpVO;

@Controller
@RequestMapping("/user/*")
public class UserAccountController {
	
	@Inject
	private UserAccountService accountSvc;
	
	// 회원가입 페이지로 이동
	@RequestMapping("/signup")
	public String GoSignUpPage(Model model )  throws Exception{
		//System.out.println(("GET Model"));
		// 회원가입 jsp 페이지에 UserSignUpVO param 설정
		model.addAttribute("UserSignUpVO", new UserSignUpVO());
		return "user/accounts/signup";
	}
	
	// 회원가입(jsp에서 submit 했을시)
	@RequestMapping("/userSignUp")
	public String SubmitSignUp(@ModelAttribute("UserSignUpVO") @Valid UserSignUpVO userSignUpVO ,BindingResult bindingResult , Model model)  throws Exception{
		
		//@Validation
		if(bindingResult.hasErrors()) {
			//System.out.println(bindingResult.getFieldError());
			return "user/accounts/signup";
		}
		
		//비밀번호 확인
		boolean check = userSignUpVO.isPwEqualToCheckPw();
		if(!check) {
			bindingResult.rejectValue("checkPw", "noMatch","비밀번호를 확인해 주세요");
			return "user/accounts/signup";
		}
		try {
			//DB저장
			accountSvc.UserSignUp(userSignUpVO);
		} catch (AlreadyExistingEmailException  e) {
			bindingResult.rejectValue("signUpUserEmail", "duplicate", "이미 가입된 이메일입니다.");
			return "user/accounts/signup";
		}catch (AlreadyExistingIdException e) {
			bindingResult.rejectValue("signUpUserId", "duplicate", "이미 가입된 아이디입니다.");
			return "user/accounts/signup";
		}
		
		return "user/accounts/signupPost";
	}
	
	// 아이디 중복 체크
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	@ResponseBody
	public int idCheck(@RequestParam("signUpUserId") String signUpUserId) {
		return accountSvc.CheckUserId(signUpUserId);
	}

	// 가입 승인
	@RequestMapping(value="signUpConfirm", method=RequestMethod.GET)
	public String emailConfirm(@RequestParam("id") String id, Model model) throws Exception {
		accountSvc.updateAuthstatus(id);
		
		model.addAttribute("auth_check", 1);
		
		return "user/accounts/signUpConfirm";
	}
	
/*	@RequestMapping("duplicationCheck")
	@ResponseBody
	public String CheckDuplication(@RequestBody String inputId) {
		
		String checkRst;
		int idCnt = accountSvc.CheckDuplication(inputId);
		if(idCnt > 0) 
			checkRst = "F";
		else 
			checkRst = "S";
		
		return checkRst;
	}*/
}
