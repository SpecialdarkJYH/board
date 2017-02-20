<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="_ctx"
	value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }"
	scope="application" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<title>Index</title>
	
	<c:import url="/WEB-INF/views/inc/head.jsp" />
	
	<style>
		body {
			background-image: url("/spd/res/img/img1.jpg");
		}
	</style>
	
</head>

<body>
	<div id="loginWrap">

		<div id="login">
			<h1>Index</h1>

			<a href="${_ctx}/login" class="loginBtn">LOGIN</a> <a
				href="${_ctx}/join" class="joinBtn">JOIN</a>

		</div>

	</div>

</body>

</html>