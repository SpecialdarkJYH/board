<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="_ctx" value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }"
	scope="application" />
<c:set var="user"
value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.user}"
scope="application" />
<%-- <%@ page import="kr.co.spd.common.security.SecuritySession" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		
		<c:import url="/WEB-INF/views/inc/head.jsp" />
		
		<title>회원정보</title>
		
		<script type="text/javascript">
			$(function(){
				$("#frmLogin").validate();
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
			
				<h1>${user.name}님 회원정보</h1>
					
				<h1>로그인 ID : ${user.lgnId}</h1>
				
				<h1>이름 : ${user.name}<h1>
				
				<h1>Email : ${user.email}<h1>
				
				<h1>핸드폰번호 : ${user.phone}<h1>
				<h1>가입일 : <fmt:formatDate value="${user.regDt}" pattern="yyyy-MM-dd" /><h1>

				<a href="${_ctx}/myinfo" class="loginBtn" >회원수정</a>
				<a href="${_ctx}/relgnpw" class="loginBtn" >비밀번호 수정</a>
				<a href="${_ctx}/main/index" class="joinBtn">취소</a>
			    
			</div>
			
		</div>
	</div>
	</body>
	
</html>
