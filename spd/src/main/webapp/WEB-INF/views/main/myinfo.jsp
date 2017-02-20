<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="_ctx" value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }"
	scope="application" />
<c:set var="user"
value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.user}"
scope="application" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		
		<c:import url="/WEB-INF/views/inc/head.jsp" />
		
		<title>회원정보 수정</title>
		
		<script type="text/javascript">
			
			$(function(){
				
				//mask(폰)
				$("#phone").setMask();
				$("#email").setMask();
				
				//validate 폼검증
				$("#frmWrite").validate();
				
				//수정 (회원정보)
				$("#btnSave").click(function(){
					
					var isCheckedEmail = $("#isCheckEmail").val();
					
					if (isCheckedEmail == "N") {
						alert("Email 체크를 먼저 실행해 주세요. ");
					} else {
						$("#frmWrite").submit();
					}
				});
				
				
				
				//이메일 중복검사
				$("#btnCheckEmail").click(function() {
						var email = $("#email").val();
						if(email == "" || email == " ") {
							alert("이메일을 입력해주세요");
						} else {
							$.post("${_ctx}/join/email/available", {email : email}, function(json) {
								if(json=="Y") {
									alert("사용할 수 있는 이메일입니다.");
									$("#isCheckEmail").val("Y");
								} else {
									alert("사용할 수 없는 이메일입니다. \n 다른 이메일를 적어주세요 ");
								}
							});
						}
					});
				
				//색칠 포커스
				$("#frmWrite input").focusin(function(){
			    	$(this).css("background-color", "yellow");
			    }).focusout(function(){
			    	$(this).css("background-color", "white");
			    });
				
			});
			
		</script>
		
	</head>

	<body>
	
		<div id="wrap">
		<!-- 상단 메뉴 -->
		<c:import url="/WEB-INF/views/inc/menu.jsp" />

		<!-- 왼쪽 트리, 사용자 정보 -->
		<c:import url="/WEB-INF/views/inc/left.jsp" />
				
		
		<div id="rightWrap">
				
				<div id="join">
					<h1>회원정보 수정</h1>
					
					<form action="${_ctx}/myinfo" method="post" id="frmWrite" >
						<input type="hidden" id="isCheckEmail" value="N" />
						<dl>
							<h1>로그인 ID<dd><input type="text" name="lgnId" value="${user.lgnId}" readOnly/></dd></h1>
							
							<dt>로그인 PW 재확인</dt>
							<dd><input type="password" id="lgnPw" name="lgnPw" placeholder="로그인 PW 재확인" maxlength="14" minlength="6" required/></dd>
							
							<dt>이름</dt>
							<dd><input type="text" name="name" placeholder="이름" maxlength="14" minlength="2" required/></dd>
							
							<dt>이메일</dt>
							<dd><input type="email" id="email" name="email" placeholder="이메일" maxlength="30" minlength="6" style="width:75%" required/>
									<button id="btnCheckEmail" style= "width:75px; height:35px; background-color:#299ae1; border:1px solid #1375b3; color:#fff; cursor: pointer;">Email체크</button>
							</dd>
							
							<dt>전화번호</dt>
							<dd><input type="text" id="phone" alt="mobile" name="phone" placeholder="전화번호" maxlength="13" minlength="12" required/></dd>
						      
						</dl>
					   
						<a href="#" id="btnSave" class="loginBtn" >수정</a>
						<a href="${_ctx}/info" class="joinBtn">취소</a>
				
					</form>
				    
				</div>
				
			</div>
		</div>
	</body>
	
</html>
