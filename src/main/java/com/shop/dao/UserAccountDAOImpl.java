package com.shop.dao;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.shop.dao.UserAccountDAO;
import com.shop.vo.UserSignInVO;
import com.shop.vo.UserSignUpVO;

@Repository
public class UserAccountDAOImpl implements UserAccountDAO {
	
	@Inject
	private SqlSession session;
	
	// 유저 회원가입
	public void UserSignUp(UserSignUpVO accountVo) {
		session.insert("UserSignUp.insertUserAccount", accountVo);
	}
	
	// 아이디 중복 체크
	public String  CheckDupChkId(String inputId) {
		String  chkId = session.selectOne("UserSignUp.checkDuplicationId", inputId.replace("=", ""));
		return chkId;
	}
	
	// 이메일 중복 체크
	public String  CheckDupChkEmail(String inputEmail) {
		String  chkEmail = session.selectOne("UserSignUp.checkDuplicationMail", inputEmail.replace("=", ""));
		return chkEmail;
	}

	// 로그인 처리
	@Override
	public UserSignUpVO login(UserSignInVO signIn) {
		return session.selectOne("UserSignIn.login", signIn);
	}

	@Override
	public void keepLogin(String userId, String sessionId, Date sessionLimit) throws Exception {
		// 세션정보 Map에 저장
		Map<String ,Object> paramMap = new HashMap<String ,Object>();
		paramMap.put("signUpUserId", userId); // 사용자 id
		paramMap.put("sessionKey", sessionId); // 세션 id
		paramMap.put("sessionLimit", sessionLimit); // 세션 유지 기간
		
		session.update("UserSignIn.keepLogin",paramMap);
	}

	// 세션키 검증
	@Override
	public UserSignUpVO checkUserWithSessionKey(String value) throws Exception {
	    return session.selectOne("UserSignIn.checkUserWithSessionKey", value);
	}
	
	// 네이버계정 존재여부 체크
	@Override
	public String checkNaverUserExists(String navId) {
		return session.selectOne("UserSignIn.checkNaverUserExists",navId);
	}
    
	//네이버계정 DB 등록
	@Override
	public void insertNaverUser(UserSignUpVO accountVo) {
		session.insert("UserSignUp.insertNaverUser",accountVo);
	}

	// 아이디 중복
	@Override
	public int checkUserId(String signUpUserId) {
		int  chkId = session.selectOne("UserSignUp.checkUserId", signUpUserId);
		return chkId;
	}
	
	// 이메일 인증
	@Override
	public void updateAuthstatus(String id) {
		session.update("UserSignUp.updateAuthstatus", id);
	}
}
