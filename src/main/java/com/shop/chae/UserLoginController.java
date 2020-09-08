package com.shop.chae;
import java.io.IOException;
import java.util.Date;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.codehaus.jackson.JsonNode;
import org.json.simple.JSONObject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.shop.service.UserAccountService;
import com.shop.util.JsonStringParseForNaverLogin;
import com.shop.util.KakaoLoginBO;
import com.shop.util.NaverLoginBO;
import com.shop.util.StringUtil;
import com.shop.vo.UserSignInVO;
import com.shop.vo.UserSignUpVO;

//로그인 처리 @Controller
@Controller
@RequestMapping("/user/*")
public class UserLoginController {
	
	@Inject
	private UserAccountService accountSvc;
	
	// 로그인 페이지 이동
	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public String loginGET(@ModelAttribute UserSignInVO  signIn) {
		return "user/accounts/login";
	}
	
	// 로그인 처리
	@RequestMapping(value = "/loginPost" , method = RequestMethod.POST)
	public String loginPOST(UserSignInVO signIn, HttpSession httpSession, Model model) throws Exception{
		//System.out.println("signIn= "+signIn);
		//JSP페이지에서 받은 UserSignInVO 객체(input type name과 동일)를 파라미터로 로그인 처리 시작
		

			UserSignUpVO signUp = accountSvc.login(signIn);
	
			//System.out.println(" signUp ="+ signUp);
			//System.out.println(" signIn ="+ signIn.getSignInUserPwd());
			
			//<암호 체크> 
			//1. signIn.getSignInUserPwd() : 사용자가 입력한 비번 , signUp.getSignUpUserPwd() : DB에서 조회한 암호화된 비번
			//2.위 두개를 비교하는 메소드 : passwordEncoder.matches()
			//3.PasswordEncoder의 BCryptPasswordEncoder 객체 생성
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			
			/*스프링시큐리티의 bcrypt 인코딩 비밀번호와 인코딩 되지 않은 비밀번호를 비교하는 메서드를 통해 로그인 기능을 구현할 수 있다. 
			 BCryptPasswordEncoder 빈의 matches(rawData , encodedData) 메서드를 활용하면 로우 데이터와 인코딩 데이터를 비교할 수 있게 된다.
			 rawData = signIn.getSignInUserPwd() ,encodedData = signUp.getSignUpUserPwd()
			 */
			if (signUp == null || !passwordEncoder.matches(signIn.getSignInUserPwd(), signUp.getSignUpUserPwd() )){
				return "user/accounts/loginPost";
			}
			
	           /* 참조사이트 => https://shj7242.github.io/2017/12/10/Spring31/
				<개발자가 패스워드 암호화에서 알아야 할점>
				1.복호화(디코딩)가 불가능한 단방향 암호코드로 만들어져야 한다.
				2.암호는 개발자나 관리자도 알 수 없어야 하며 이용자 이외에는 누구도 접근할 수 없는 형태여야 한다.
				3.공격자가 예측할 수 없도록 솔트 처리를 해주어야 한다.
				4.데이터베이스에서 제공하는 (mysql , oracle 등) 암호화에 의존해서는 안된다.
				
				<스프링 시큐리티로 비밀번호 암호화하기>
				1 . 스프링 시큐리티 라이브러리 추가하기(pom.xml) : 이 라이브러리를 추가할 때 조심해야하는 것은 스프링 버전과 잘 맞는지 확인해야하는 것이다. 
				만일 잘 물리지 않는 버전을 사용했을 때 라이브러리를 날리고 다시설치해야한다.
				2. spring-security.xml 생성 : 해당 xml 문서에는 비밀번호 암호화인코딩을 위한 bean을 추가해준다. 
				스프링 시큐리티 라이브러리에서 제공하는 BcryptPasswordEncoder 는 비밀번호 암호화 메서드, 인코딩된 비밀번호와 Raw 형태의 
				비밀번호를 비교해주는 메서드를 제공한다. 하지만 비밀번호를 디코딩하는 메서드는 지원하지 않는다.*/
			
			// 로그인 유지를 선택할 경우
			if (signIn.isUseCookie()) {
				int amount = 60 * 60 * 24 * 7;  // 7일
			    Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount)); // 로그인 유지기간 설정
			    accountSvc.keepLogin(signUp.getSignUpUserId(), httpSession.getId(), sessionLimit);
			}
			
			model.addAttribute("signUp",signUp);

		//model.addAttribute("signUp",signUp);
		return "home";
	}
	
	// 로그아웃 처리
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) throws Exception {
	    Object object = httpSession.getAttribute("login");
	    if (object != null) {
	    	UserSignUpVO userVO = (UserSignUpVO) object;
	        httpSession.removeAttribute("login");
	        httpSession.invalidate();
	        Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
	        if (loginCookie != null) {
	            loginCookie.setPath("/");
	            loginCookie.setMaxAge(0);
	            response.addCookie(loginCookie);
	            accountSvc.keepLogin(userVO.getSignUpUserId(), "none", new Date());
	        }
	    }
	    return "user/accounts/logout";
	}
	
	//NAVER 로그인
	private NaverLoginBO naverLoginBO; //naver 로그인 api 유틸
	private String apiResult = null; // api연동 결과값 담을 변수
	private JsonStringParseForNaverLogin JsonStringParse = new JsonStringParseForNaverLogin(); // json을 string parsing 처리할 객체 생성
	
	/* NaverLoginBO */
	@Inject
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	@RequestMapping(value="/naverLogin", method = RequestMethod.GET)
	public ModelAndView login(HttpSession session) {
		/* 네아로 인증 URL을 생성하기 위하여 getAuthorizationUrl을 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		System.out.println("naverAuthUrl="+naverAuthUrl);
		return new ModelAndView("user/accounts/naverLogin", "url", naverAuthUrl);
	}

	@RequestMapping(value="/naverPostlogin",method = RequestMethod.GET)
	public ModelAndView callback(@RequestParam String code, @RequestParam String state, HttpSession session) throws IOException {
		/* 네아로 인증이 성공적으로 완료되면 code 파라미터가 전달되며 이를 통해 access token을 발급 */

		OAuth2AccessToken oauthToken = naverLoginBO.getAccessToken(session, code, state);
		System.out.println("oauthToken= "+oauthToken);
		apiResult = naverLoginBO.getUserProfile(oauthToken);
		
		//System.out.println("apiResult!!!!!= "+apiResult);
		
		/*
		 * 스트링 타입의 json 데이터 키의 값중 json 형태인 값을 JSON 타입으로 변환하여 반환하는 메서드와 
		 * json 타입의 키 값을 스트링으로 반환하는 메서드를 정의한다.
		 */
		// String 타입인 apiResult를 json객체로 parsing함
		JSONObject jsonobj = JsonStringParse.stringToJson(apiResult, "response");
		// json객체안에 각 값들을 string 타입으로 parsing 후 변수 저장
		String navId = JsonStringParse.JsonToString(jsonobj, "id");
				navId = "naver"+navId; // 네이버 계정 구분을 위해 앞에 구분자 추가
		String navEmail = JsonStringParse.JsonToString(jsonobj, "email");
		String navName = JsonStringParse.JsonToString(jsonobj, "name");
		
		// user VO객체에 각각의 string값들을 저장
		UserSignUpVO  signUp = new UserSignUpVO();
		signUp.setSignUpUserId(navId);
		signUp.setSignUpUserEmail(navEmail);
		signUp.setUserNm(navName);
		/*
		 * signIn.set(name);
		 * 
		 * System.out.println(name); try { vo = service.naverLogin(vo); } catch
		 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		String rtnValue = accountSvc.selectNaverUser(navId); 
		if (rtnValue != null) { // 세션만들기
			session.setAttribute("login", signUp);
		} else {
			accountSvc.insertNaverUser(signUp);
			session.setAttribute("login", signUp);
		}
		return new ModelAndView("user/accounts/naverPostlogin", "result", signUp);
	}
	
	// kakaoLogin
	@RequestMapping(value="/kakaoLogin", method = RequestMethod.GET)
	public ModelAndView kakaoLogin(HttpSession session) {
		/* 네아로 인증 URL을 생성하기 위하여 getAuthorizationUrl을 호출 */
		String kakaoAuthUrl = KakaoLoginBO.getAuthorizationUrl(session);
		System.out.println("kakaoAuthUrl= "+kakaoAuthUrl);
		return new ModelAndView("user/accounts/kakaoLogin", "url", kakaoAuthUrl);
	}
	
	@RequestMapping(value = "/kakaoPostLogin", produces = "application/json", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView kakaoLogin(@RequestParam("code") String code, HttpServletRequest request ,HttpServletResponse response, HttpSession session) throws Exception {

		// 결과값을 node에 담아줌
		System.out.println("code= "+code);
		JsonNode node = KakaoLoginBO.getAccessToken(code);
		// accessToken에 사용자의 로그인한 모든 정보가 들어있음
		JsonNode accessToken = node.get("access_token");
		System.out.println("accessToken= "+accessToken);
		// 사용자의 정보
		JsonNode userInfo = KakaoLoginBO.getKakaoUserInfo(accessToken);
		
		String kakaoId = null;
		String kemail = null;
		String kname = null;
		String kgender = null;
		String kbirthday = null;
		String kage = null;
		String kimage = null;
		// 유저정보 카카오에서 가져오기 Get properties
		JsonNode properties = userInfo.path("properties");
		JsonNode kakao_account = userInfo.path("kakao_account");
		
		System.out.println("properties= "+properties);
		System.out.println("kakao_account= "+kakao_account);
		
		kakaoId = "kakao_"+kakao_account.path("email").asText();
		kemail = kakao_account.path("email").asText();
		kname = properties.path("nickname").asText();
		kimage = properties.path("profile_image").asText();
		kgender = kakao_account.path("gender").asText();
		kbirthday = kakao_account.path("birthday").asText();
		kage = kakao_account.path("age_range").asText();
		
		session.setAttribute("kemail", kemail);
		session.setAttribute("kname", kname);
		session.setAttribute("kimage", kimage);
		session.setAttribute("kgender", kgender);
		session.setAttribute("kbirthday", kbirthday);
		session.setAttribute("kage", kage);
		
		// user VO객체에 각각의 string값들을 저장
		UserSignUpVO  signUp = new UserSignUpVO();
		signUp.setSignUpUserId(kakaoId);
		signUp.setSignUpUserEmail(kemail);
		signUp.setUserNm(kname);

		String rtnValue = accountSvc.selectNaverUser(kakaoId);
		if (rtnValue != null) { // 세션만들기
			session.setAttribute("login", signUp);
		} else {
			accountSvc.insertNaverUser(signUp);
			session.setAttribute("login", signUp);
		}
		
		return new ModelAndView("user/accounts/kakaoPostlogin", "result", signUp);
	}
}



