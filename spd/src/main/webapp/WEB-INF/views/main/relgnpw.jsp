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
		
		<title>비밀번호 수정</title>
		
		<script type="text/javascript">
			
			$(function(){
				
				$("#btnSave").click(function(){
					$("#frmWrite").submit();
				});
				//validate 폼검증
				$("#frmWrite").validate();
				
				//색칠 포커스
				$("#frmWrite input").focusin(function(){
			    	$(this).css("background-color", "yellow");
			    }).focusout(function(){
			    	$(this).css("background-color", "white");
			    });
				
			});
			
		</script>
		
		<style>
			#join {
				background-color : #ffffb3;
			}
		</style>
		
	</head>

	<body>
	
		<div id="wrap">
		<!-- 상단 메뉴 -->
		<c:import url="/WEB-INF/views/inc/menu.jsp" />

		<!-- 왼쪽 트리, 사용자 정보 -->
		<c:import url="/WEB-INF/views/inc/left.jsp" />
		
		<div id="rightWrap">
				
			<div id="join">
				<h1>비밀번호 수정</h1>
					
					<form action="${_ctx}/relgnpw" method="post" id="frmWrite" >
					<dl>
						<h1>로그인 ID<dd><input type="text" name="lgnId" value="${user.lgnId}" readOnly/></dd></h1>
						
						<h1>새로운 비밀번호
						<dd><input type="password" id="lgnPw" name="lgnPw" placeholder="새로운 비밀번호" maxlength="14" minlength="6" required/></dd></h1>
						
					</dl>
				   
					<a href="#" id="btnSave" class="loginBtn" >수정</a>
					<a href="${_ctx}/info" class="joinBtn">취소</a>
			
					</form>
			    
			</div>
				
			</div>
			
		</div>
	</body>
	
</html>
