package com.shop.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class UserSignUpVO {

	// 회원 아이디
    @Column
    @NotEmpty(message="아이디를 입력해주세요.")
    @Pattern(regexp="\\w{4,12}", message="아이디를 4~12자로 입력해주세요.")
	private String signUpUserId;
	
	// 회원 비밀번호
    @Column
    @NotEmpty(message="비밀번호를 입력해주세요.")
    @Size(min=4, max=12, message="비밀번호를 4~12자로 입력해주세요.")
	private String signUpUserPwd;

    @Column
    //@NotEmpty(message="비밀번호를 입력해주세요.")
    @Size(min=4, max=12, message="비밀번호를 4~12자로 입력해주세요.")
    private String checkPw;
    
    //비밀번호 확인
    public boolean isPwEqualToCheckPw() {
        return signUpUserPwd.equals(checkPw);
    }
    
	// 회원명
    @Column
    @NotEmpty(message="이름을 입력해주세요.")
    @Pattern(regexp="^[가-힣]{2,6}$", message="이름을 공백없이 2~6자로 입력해주세요.")
    private String userNm;
    
	// 회원 이메일
	@Column
    @NotEmpty(message="이메일을 입력해주세요.")
    @Email(message="이메일 형식에 맞춰 올바르게 입력해주세요.")
	private String signUpUserEmail;
	
	// 회원 회사명
	private String signUpUserCompanyName;
	
	// 휴대폰번호
	@Pattern(regexp = "^((01[1|6|7|8|9])[1-9]+[0-9]{6,7})|(010[1-9][0-9]{7})$" , message="휴대폰번호를 올바른 형식에 맞쳐 입력 해주세요.")
	private String signUpUserTelNo;
	
	// 세션 키
	private String sessionKey;
	
	// 세션 제한
	private Timestamp sessionLimit;
	
	// 회원 회사 사업자번호
	private String signUpUserCompanyNo;
	
	// 회원 회사주소 - 우편번호
	private String signUpUserPostNo;

	// 회원 회사주소 - 도로명 주소
	private String signUpUserCompanyAddress;
	
	// 회원 회사주소 - 상세주소
	private String signUpUserCompanyAddressDetail;
	
	private String authKey;
	
	private String homeAddr;
	
	private String zipNo;
	
	public String getZipNo() {
		return zipNo;
	}

	public void setZipNo(String zipNo) {
		this.zipNo = zipNo;
	}

	public String getSignUpUserId() {
		return signUpUserId;
	}

	public void setSignUpUserId(String signUpUserId) {
		this.signUpUserId = signUpUserId;
	}

	public String getSignUpUserPwd() {
		return signUpUserPwd;
	}

	public void setSignUpUserPwd(String signUpUserPwd) {
		this.signUpUserPwd = signUpUserPwd;
	}
	
	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getSignUpUserCompanyName() {
		return signUpUserCompanyName;
	}

	public void setSignUpUserCompanyName(String signUpUserCompanyName) {
		this.signUpUserCompanyName = signUpUserCompanyName;
	}

	public String getSignUpUserTelNo() {
		return signUpUserTelNo;
	}

	public void setSignUpUserTelNo(String signUpUserTelNo) {
		this.signUpUserTelNo = signUpUserTelNo;
	}

	public String getSignUpUserEmail() {
		return signUpUserEmail;
	}

	public void setSignUpUserEmail(String signUpUserEmail) {
		this.signUpUserEmail = signUpUserEmail;
	}

	public String getSignUpUserCompanyNo() {
		return signUpUserCompanyNo;
	}

	public void setSignUpUserCompanyNo(String signUpUserCompanyNo) {
		this.signUpUserCompanyNo = signUpUserCompanyNo;
	}

	public String getSignUpUserPostNo() {
		return signUpUserPostNo;
	}

	public void setSignUpUserPostNo(String signUpUserPostNo) {
		this.signUpUserPostNo = signUpUserPostNo;
	}

	public String getSignUpUserCompanyAddress() {
		return signUpUserCompanyAddress;
	}

	public void setSignUpUserCompanyAddress(String signUpUserCompanyAddress) {
		this.signUpUserCompanyAddress = signUpUserCompanyAddress;
	}

	public String getSignUpUserCompanyAddressDetail() {
		return signUpUserCompanyAddressDetail;
	}

	public void setSignUpUserCompanyAddressDetail(String signUpUserCompanyAddressDetail) {
		this.signUpUserCompanyAddressDetail = signUpUserCompanyAddressDetail;
	}
	
    public String getCheckPw() {
		return checkPw;
	}

	public void setCheckPw(String checkPw) {
		this.checkPw = checkPw;
	}
	
	public Timestamp getSessionLimit() {
		return sessionLimit;
	}

	public void setSessionLimit(Timestamp sessionLimit) {
		this.sessionLimit = sessionLimit;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	
	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}
	
	public String getHomeAddr() {
		return homeAddr;
	}

	public void setHomeAddr(String homeAddr) {
		this.homeAddr = homeAddr;
	}
	
	@Override
	public String toString() {
		return "UserSignUpVO [signUpUserId=" + signUpUserId + ", signUpUserPwd=" + signUpUserPwd + ", checkPw="
				+ checkPw + ", userNm=" + userNm + ", signUpUserEmail=" + signUpUserEmail + ", signUpUserCompanyName="
				+ signUpUserCompanyName + ", signUpUserTelNo=" + signUpUserTelNo + ", sessionKey=" + sessionKey
				+ ", sessionLimit=" + sessionLimit + ", signUpUserCompanyNo=" + signUpUserCompanyNo
				+ ", signUpUserPostNo=" + signUpUserPostNo + ", signUpUserCompanyAddress=" + signUpUserCompanyAddress
				+ ", signUpUserCompanyAddressDetail=" + signUpUserCompanyAddressDetail + "]";
	}
}
