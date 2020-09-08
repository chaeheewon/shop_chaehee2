package com.shop.service;

import java.util.Date;
import com.shop.vo.UserSignInVO;
import com.shop.vo.UserSignUpVO;
public interface UserAccountService {

	// 회원가입 
	public void UserSignUp(com.shop.vo.UserSignUpVO accountVo) throws Exception;
	
	// 회원로그인
	public UserSignUpVO login(UserSignInVO signInUserId);
	
	//로그인 유지
	public void keepLogin(String userId, String sessionId, Date next) throws Exception;
	
	public com.shop.vo.UserSignUpVO checkLoginBefore(String value) throws Exception;
	
	//네이버계정 존재 여부 체크
	public String selectNaverUser(String navId);
	
	//네이버계정 DB등록
	public void insertNaverUser(UserSignUpVO accountVo);
	
	public int CheckUserId(String signUpUserId);
	
	public void updateAuthstatus(String signUpUserId);
}