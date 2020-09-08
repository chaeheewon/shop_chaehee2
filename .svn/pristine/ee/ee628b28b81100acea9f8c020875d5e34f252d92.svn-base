package com.shop.dao;
import java.util.Date;

import com.shop.vo.UserSignInVO;
import com.shop.vo.UserSignUpVO;

public interface UserAccountDAO {
	
	// 유저 회원가입
	public void UserSignUp(UserSignUpVO accountVo);
	
	// 아이디 중복 체크
	public String CheckDupChkId(String inputId);
	
	// E-mail 중복 체크
	public String CheckDupChkEmail(String inputEmail);
	
	//유저 로그인
	public UserSignUpVO login(UserSignInVO signIn);
	
	//로그인 유지 처리
	public void keepLogin(String userId , String sessionId , Date sessionLimit ) throws Exception;
	
	//세션키 검증
	public UserSignUpVO checkUserWithSessionKey(String value) throws Exception;
	
	//네이버 로그인 회원여부 체크
	public String checkNaverUserExists(String navId);
	
	//네이버계정 DB 등록
	public void insertNaverUser(UserSignUpVO accountVo);
	
	public int checkUserId(String signUpUserId);
	
	// 권한승인
	public void updateAuthstatus(String id);
}
