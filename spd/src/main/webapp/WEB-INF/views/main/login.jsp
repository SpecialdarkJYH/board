<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="_ctx" value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }"
	scope="application" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	
	<head>
		
		<style>
			body {
				background-image: url("/spd/res/img/img1.jpg");
			}
		</style>
		
		<c:import url="/WEB-INF/views/inc/head.jsp" />
	
		<title>로그인</title>
		
		<script type="text/javascript">
			
			$(function(){
				
				//validate 폼검증
				$("#frmLogin").validate();
				
				/* $("#frmLogin input").focus(function(){
	        $(this).css("background-color", "#FFFF00");
		    }).blur(function(){
	        $(this).css("background-color", "#FFFFFF");
		    }); */
				
		    $("#frmLogin input").focusin(function(){
		    	$(this).css("background-color", "yellow");
		    }).focusout(function(){
		    	$(this).css("background-color", "white");
		    });
		    
		    //Captcha
		    $("#btnLogin").click(function() {
					
		    	if($("#frmLogin").valid()) {
		    		
	    			$.post("${_ctx}/captcha/check/", {captcha : $("#captcha").val()}, function(json) {
						
	    				if(json == "Y") {
	    					
	    					$("#isCaptchaCheck").val("Y");
	    					$("#frmLogin").submit();
	    					
	    				} else {
	    					
								alert("이미지에 문자를 잘못 입력하셨습니다. ");
							}
						});
	    		}
		    });
		    
				//중복되는 작업오류를 줄이기 위해 fuction을 하던지, 클릭기능으로 구현
				$("#captcha").keyup(function(e){
					if(e.keyCode == 13) {
						$("#btnLogin").click();
					}
				});
				
		    $("#img").click(function(){
		        $(this).attr("src", "${_ctx}/captcha/index");
		    });
		  
			});
			
			
			
			
		</script>
	</head>
	
	<body>
	
		<div id="loginWrap">

			<div id="login">
				
				<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
					<font color="red">
						Your login attempt was not successful due to <br/><br/>
						<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
					</font>
					<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session" />
				</c:if>
				<h1>로그인</h1>
				
				<form id="frmLogin" action="${_ctx}/security/login" method="post" class="login_area">
				<dl>
					<dt>아이디</dt>
					<dd><input type="text" id="lgnId" name="lgnId" placeholder="User ID" title="ID를 입력해주세요" required /></dd>
					<dt>비밀번호</dt>
					<dd><input type="password" id="lgnPw" name="lgnPw" placeholder="Password" title="PW를 입력해주세요" required /></dd>
				
					<dt>Captcha</dt>
					<dd><img id="img" src="${_ctx}/captcha/index" />
					<input type="text" id="captcha" name="captcha" placeholder="이미지 문자 작성" style="width:238px;" required />
					</dd>
					
				</dl>
				
				<a href="#" class="loginBtn" id="btnLogin">로그인</a>
				<a href="${_ctx}/join" class="joinBtn">회원가입</a>
				
				</form>
			   
			</div>

		</div>
	
	</body>
</html>
