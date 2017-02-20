<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	
	<head>
		
		<c:import url="/WEB-INF/views/inc/head.jsp" />
	
		<title></title>
		
		<script type="text/javascript">
			
			$(function(){
				
				$("#delete").click(function(){
					$("#frmDelete").submit();
				});
				
			});
			
		</script>
	</head>
	
	<body>
	
		<div id="loginWrap">

			<div id="login">
				
				<h1>삭제 재확인</h1>
				
				<form id="frmDelete" action="${_ctx}/board/doc/delete" method="post" class="login_area">
					<input type="hidden" name="mapId" value="${list.mapId}"/>
					<input type="hidden" name="docId" value="${list.docId}"/>
					<a href="#" class="loginBtn" id="delete">게시글 삭제</a>

				</form>
				
				<a href="${_ctx}/board/doc/view2?docId=${list.docId}" class="joinBtn">뒤로가기</a>
			   
			</div>

		</div>
	
	</body>
</html>
