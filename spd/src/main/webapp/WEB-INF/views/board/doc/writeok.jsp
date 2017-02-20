<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="_ctx" value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }"
	scope="application" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<c:import url="/WEB-INF/views/inc/head.jsp" />
		<script type="text/javascript">
			
			$(function(){
				
			});
			
		</script>
		
		
		<title>글 등록완료</title>
	
	</head>

<body>
	
		<div id="wrap">
		
		<!-- 상단 메뉴 -->
		<c:import url="/WEB-INF/views/inc/menu.jsp" />
		
		<!-- 왼쪽 트리, 사용자 정보 -->
		<c:import url="/WEB-INF/views/inc/left.jsp" />
		
			<div id="rightWrap">
    		<div class="rightBlock">
	        <div class="page_top">
	        	<h1>[${title2.mapNm}] 등록완료</h1>
		        <h1>글이 제대로 등록되었습니다.</h1>
						<h1><a href="javascript:getList(${title2.mapId})">글 보러가기</a></h1>
	        </div>
    		</div>
			</div>
			
		</div>
</body>

</html>