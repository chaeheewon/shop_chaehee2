package com.shop.intercepter;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;
import com.shop.service.UserAccountService;
import com.shop.vo.UserSignUpVO;

public class RememberMeInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(RememberMeInterceptor.class);

    @Inject
    private UserAccountService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	
        HttpSession httpSession = request.getSession();
        // 쿠키에서 세션ID값을 꺼낸다.
        Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
        
        String uri = request.getRequestURI();
        String query = request.getQueryString();
        
        logger.info("로그인 유지 RememberMeInterceptor destination : uri= " + (uri));
        logger.info("로그인 유지 RememberMeInterceptor destination : query= " + (query));
        logger.info("loginCookie= "+loginCookie);
        
        //저장된 세션 조회
        if (loginCookie != null) {
        	System.out.println("loginCookie.getValue()= "+loginCookie.getValue());
        	//쿠키에서 꺼낸 세션ID값을 DB에서 검색하여 로그인 정보를 가져온다.
            UserSignUpVO userVO = userService.checkLoginBefore(loginCookie.getValue());
            // 로그인정보가 존재하는경우 
            if (userVO != null) {
            	//세션에 로그인정보를 저장한다.
            	httpSession.setAttribute("login", userVO);
            }
        }
        return true;
    }
}
