<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
 <%--head.jsp--%>
 <%@ include file="../../include/head.jsp" %>
 
<body onload="document.LoginForm.signInUserId.focus();" class="animsition"> 

<%-- Main Header --%>
<%@ include file="../../include/header.jsp" %>

	<div class="container" style= "margin-top: 0.75em; margin-bottom: 0.75em">
    	<div class="card bg-light">
	    	<article class="card-body mx-auto" style="max-width: 400px;">
	                    <h5 class="h5 mb-3 font-weight-normal text-center" >LOGIN or CREATE AN ACCOUNT</h5>
					<!-- 로그인form (로그인 클릭시, Controller loginPost 진행)-->
					<!-- 반드시 input type name과 UserSignInVO 객체의 name과 동일해야. 
						  controller에서 vo객체 타입으로 데이터 받을수 있다. -->
			        <form action="loginPost" method="post" name="LoginForm"  >
			            <div class="form-group has-feedback">
			            	<input type="text" name="signInUserId" id="signInUserId" class="form-control" placeholder="ID">
			            </div>
			            <div class="form-group has-feedback">
			            	<input type="password" name="signInUserPwd" id="signInUserPwd" class="form-control" placeholder="Password">
			            </div>
			            <div class="form-group has-feedback">
			            	<button type="submit" class="btn btn-primary btn-block btn-flat"  onclick="LoginValidChk()" style="background-color:black">
			            		<i class="fa fa-sign-in"></i> Log In
			                 </button>
			            </div>
			            <span></span>
			            <div class="form-group has-feedback">
			                <div class="col-xs-8">
			                    <div class="checkbox icheck" >
			                        <label>
			                        	<!-- 로그인 유지 -->
			                            <input type="checkbox" name="useCookie" > Remember me
			                        </label>
			                    </div>
			                </div>
			            </div>
			        </form>
					<!-- 네이버 ,카카오 소셜 로그인 -->
			        <div class="form-group text-center">
			        <p>- or -</p>
			             <div class="form-group has-feedback text-center" >	
			             	<a href="/user/naverLogin" >
			              		<i class="fa fa-naver"><img src="/images/naverLogin.jpg"  height=43  width = "200"></i>
			             	</a>
			             </div>
			             <div class="form-group has-feedback text-center">
			             	<a href="/user/kakaoLogin" >
			              		<i class="fa fa-naver"><img src="/images/kakaoLogin.png"  height=43 width = "200" ></i>
			             	</a>
			             </div>     
			        </div>
			        <!-- 회원가입 진행 -->
			        <div class="form-group">
							<div>
								<p class="text-primary">
									<font color= "black">Not a member yet? </font> <a href="/user/signup" ><font color= "red">CREATE AN ACCOUNT</font> </a><br>
								</p>
							</div>
					</div>
	  	 </article>
	</div>
</div>
<%--plugin_js  include --%>
<%@ include file="../../include/plugin_js.jsp" %>
</body>
<script type="text/javascript">
/*  function LoginValidChk(){
	 
	 var idChk = $("#signInUserId").val();
	 var pwChk = $("#signInUserPwd").val();
	 
	 if(idChk.length == 0){
		 alert("아이디를 입력해주세요.");
		 $("#signInUserId").focus(); 
		 return false;
	 }	 
	 if(pwChk.length == 0){
		 alert("비밀번호를 입력해주세요.");
		 $("#signInUserPwd").focus(); 
		 return false;
	 }
 } */
 </script>
<%--Footer  include --%>
 <%@ include file="../../include/footer.jsp" %>
</html>

