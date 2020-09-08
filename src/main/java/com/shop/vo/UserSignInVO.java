package com.shop.vo;

public class UserSignInVO {
	// 회원 아이디
	private String signInUserId;
	
	// 회원 비밀번호
	private String signInUserPwd;
	
	// 회원 세션 쿠키
	private boolean useCookie;
	
	public boolean isUseCookie() {
		return useCookie;
	}

	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}

	public String getSignInUserId() {
		return signInUserId;
	}

	public void setSignInUserId(String signInUserId) {
		this.signInUserId = signInUserId;
	}

	public String getSignInUserPwd() {
		return signInUserPwd;
	}

	public void setSignInUserPwd(String signInUserPwd) {
		this.signInUserPwd = signInUserPwd;
	}
	
	@Override
	public String toString() {
		return "UserSignInVO [signInUserId=" + signInUserId + ", signInUserPwd=" + signInUserPwd + ", useCookie="
				+ useCookie + ", isUseCookie()=" + isUseCookie() + ", getSignInUserId()=" + getSignInUserId()
				+ ", getSignInUserPwd()=" + getSignInUserPwd() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
