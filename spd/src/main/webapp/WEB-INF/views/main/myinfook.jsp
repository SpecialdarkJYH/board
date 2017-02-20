<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="_ctx" value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }"
	scope="application" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<c:import url="/WEB-INF/views/inc/head.jsp" />
		<title>회원수정</title>
	</head>
	
	<body>
	
		<div id="wrap">
		<!-- 상단 메뉴 -->
		<c:import url="/WEB-INF/views/inc/menu.jsp" />

		<!-- 왼쪽 트리, 사용자 정보 -->
		<c:import url="/WEB-INF/views/inc/left.jsp" />
		
		<div id="rightWrap">
		
			<div id="join">
				<h1>${name}님! <br />
				회원정보가 수정되었습니다.</h1>
				
				<h1>	<a href="${_ctx}/login">재로그인 하기</a></h1>
			</div>
			
		</div>
		
		</div>
		
	</body>

</html>