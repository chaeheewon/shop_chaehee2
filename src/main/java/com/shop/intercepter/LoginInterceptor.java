package com.shop.intercepter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*  3.5 로그인 Interceptor 클래스 작성 및 설정
 *  UserLoginController에서 HttpSession과 관련된 작업이 처리되지 않았기 때문에 HttpSession과 관련된 모든 설정은 인터셉터에서 처리한다.
 *  기본패키지/commons/interceptor 패키지에 LoginInterceptor를 생성하고, 아래와 같이 코드를 작성한다.
*/
public class LoginInterceptor extends HandlerInterceptorAdapter {
    
	private static final String LOGIN = "login";
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    /*   httpSession에 컨트롤러에서 저장한 user를 저장하고,  /로 리다이렉트를 한다. */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        HttpSession httpSession = request.getSession();
        ModelMap modelMap = modelAndView.getModelMap();
        
        //user :  UserSignUpVO 객체 값이 담겨있는 key (UserLoginController에서 담음)
        Object userVO =  modelMap.get("signUp");
        logger.info("userVO= "+userVO);
        
        if (userVO != null) {
            logger.info("new login success");
            
            // *****매우 중요******
            //로그인한 회원 객체(UserSignUpVO)를 세션에 담음
            httpSession.setAttribute(LOGIN, userVO);
            logger.info("LOGIN = "+LOGIN);
            //response.sendRedirect("/");
            
            //'로그인 유지'를 선택후 로그인한 경우
            //System.out.println("useCookie= "+request.getParameter("useCookie"));
            if (request.getParameter("useCookie") != null) {
            	logger.info("remember me");
            	
            	//쿠키를 생성하고 생성한 세션 id를 쿠키에 저장한다.
            	Cookie logCookie = new Cookie("loginCookie", httpSession.getId());
            	//쿠키를 찾을 경로를 컨텍스트 경로로 변경한다.
            	logCookie.setPath("/");
            	//7일로 유효기간을 설정
            	logCookie.setMaxAge(60*60*24*7);
            	
            	//System.out.println("logCookie="+ logCookie);
            	//쿠키를 reponse 객체에 담는다.
            	response.addCookie(logCookie);
            }
            
            Object destination = httpSession.getAttribute("destination");
            
            logger.info("LoginInterceptor =>  postHandle=> destination 정보:  "+destination);
            response.sendRedirect(destination != null ? (String)destination : "/");
        }
    }
    /*  Controller전에 기존 로그인 정보가 있을 경우 초기화하는 역할을 수행 */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession httpSession = request.getSession();
        // 기존의 로그인 정보 제거
        if (httpSession.getAttribute(LOGIN) != null) {
            logger.info("clear login data before");
            httpSession.removeAttribute(LOGIN);
        }
        return true;
    }
}