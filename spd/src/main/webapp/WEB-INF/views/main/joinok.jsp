<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="_ctx" value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }"
	scope="application" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<title>회원가입 완료</title>
	
	<c:import url="/WEB-INF/views/inc/head.jsp" />
	
	<style>
		body {
			background-image: url("/spd/res/img/img2.jpg");
		}
	</style>
	
</head>

<body>
	<div id="loginWrap">

		<div id="login">
		
			<h1>${name}님! <br/>회원가입을 축하드립니다.</h1>
			<br/>
			<a href="${_ctx}/?" class="loginBtn">로그인 하러가기</a>

		</div>

	</div>

</body>

</html>




