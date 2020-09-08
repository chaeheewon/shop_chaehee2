package com.shop.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.inject.Inject;
import javax.mail.MessagingException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.shop.dao.UserAccountDAO;
import com.shop.exception.AlreadyExistingEmailException;
import com.shop.exception.AlreadyExistingIdException;
import com.shop.service.UserAccountService;
import com.shop.util.CommonUtils;
import com.shop.util.SignUpConfirmMailUtils;
import com.shop.vo.UserSignInVO;
import com.shop.vo.UserSignUpVO;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Inject
	private UserAccountDAO accountDao;
	
	@Inject
	private JavaMailSender mailSender;
	
	// 회원가입
	public void UserSignUp(UserSignUpVO accountVo){
		
		// System.out.println("accountVo.getSignUpUserId()="+accountVo.getSignUpUserId());
		// 아이디 중복 체크
		String chkId = accountDao.CheckDupChkId(accountVo.getSignUpUserId());
		
		if(chkId != null) {
			throw new AlreadyExistingIdException(accountVo.getSignUpUserId()+" is duplicated id.");
		}
		
		// E-mail 중복 체크
		String chkEmail = accountDao.CheckDupChkEmail(accountVo.getSignUpUserEmail());
		
		if(chkEmail != null) {
			throw new AlreadyExistingEmailException(accountVo.getSignUpUserEmail()+" is duplicated email.");
		}
		
		//입력된 비번
		String orgPassword = accountVo.getSignUpUserPwd();
		//PasswordEncoder 객체 생성
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//비번 암호화(encode) & VO에 setting
		String encPassword = passwordEncoder.encode(orgPassword);
		accountVo.setSignUpUserPwd(encPassword);
		
		//System.out.println("암호화된 비번= "+ encPassword);
		accountDao.UserSignUp(accountVo);
		
		// 임의의 authkey 생성
		String authkey = new CommonUtils().createAuthKey(50, false);
		accountVo.setAuthKey(authkey);
		
		//mail 작성
		SignUpConfirmMailUtils sendMail;
		
		try {
			sendMail = new SignUpConfirmMailUtils(mailSender);
			sendMail.setSubject("[Chae hee*] 회원가입 이메일 인증해 주세요.");
			sendMail.setText(new StringBuffer().append("<h1>회원가입해 주셔서 감사합니다!!</h1>")
					.append("<p>서비스 이용을 위해 고객님의 이메일을 인증해주시기 바랍니다.</p>")
					.append("<p>이메일 인증이 완료되면 정상적인 서비스 이용이 가능합니다.</p>")
					//.append("<a href='http://13.124.189.17:8080/user/signUpConfirm?id=" //서버
					.append("<a href='http://localhost:8080/user/signUpConfirm?id=") //로컬
					.append(accountVo.getSignUpUserId())
					.append("&email=")
					.append(accountVo.getSignUpUserEmail())
					.append("&authkey=")
					.append(authkey)
					.append("' target='_blenk'>이메일 인증 하기</a>")
					.toString());
			try {
				sendMail.setFrom("chwgigs2 ", "Chae hee*");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			sendMail.setTo(accountVo.getSignUpUserEmail());
			sendMail.send();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	//로그인 처리
	@Override
	public UserSignUpVO login(UserSignInVO signIn) {
		return accountDao.login(signIn);
	}
	
	//로그인 유지
	@Override
	public void keepLogin(String userId, String sessionId, Date sessionLimit) throws Exception {
		accountDao.keepLogin(userId, sessionId, sessionLimit);
	}

	// 세션키 검증
	@Override
	public UserSignUpVO checkLoginBefore(String value) throws Exception {
		 return accountDao.checkUserWithSessionKey(value);
	}
	
	// NAVER계정 여부 체크
	@Override
	public String selectNaverUser(String navId) {
		return accountDao.checkNaverUserExists(navId);
	}

	//네이버계정 DB 등록
	@Override
	public void insertNaverUser(UserSignUpVO accountVo) {
		accountDao.insertNaverUser(accountVo);
	}
	
	// 아이디 중복 검사
	@Override
	public int CheckUserId(String signUpUserId) {
		return accountDao.checkUserId(signUpUserId);
	}

	// 이메일 인증
	@Override
	public void updateAuthstatus(String signUpUserId) {
		accountDao.updateAuthstatus(signUpUserId);
	}
}
