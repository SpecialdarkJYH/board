<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	
	<head>
		
		<c:import url="/WEB-INF/views/inc/head.jsp" />
	
		<title>로그인</title>
		
		<script type="text/javascript">
			
		$(function(){
				
			//validate 폼검증
			$("#frmLogin").validate();
			
			// focus
	    $("#frmLogin input").focusin(function(){
	    	$(this).css("background-color", "yellow");
	    }).focusout(function(){
	    	$(this).css("background-color", "white");
	    });
		    
			// 비밀번호 재확인
			$("#check").click(function() {
			
				var lgnId = $("#lgnId").val();
				var lgnPw = $("#lgnPw").val();
				
				if (lgnPw == "" || lgnPw == " ") {
				
					alert("비밀번호를 입력해주세요");
				
				} else {
					
					$.post("${_ctx}/login/myinfocheck", {lgnId : lgnId, lgnPw : lgnPw}, function(json) {
					
						if (json == "Y") {
						
							$("#frmLogin").submit();
						
						} else {
						
							alert("비밀번호가 틀렸습니다");
						}
						
					});
				}
			});
			
		});
			
		</script>
	</head>
	
	<body>
	
		<div id="loginWrap">

			<div id="login">
				
				<h1>삭제 로그인 재확인</h1>
				
				<form id="frmLogin" action="${_ctx}/board/doc/chkdelete" method="post" class="login_area">

				<dl>
					<input type="hidden" id="docId" name="docId" value="${list.docId}"/>
					
					<dt>로그인 ID</dt>
					<dd><input type="text" id="lgnId" name="lgnId" value="${user.lgnId}"  readonly/></dd>
						
					<dt>로그인 PW</dt>
					<dd><input type="password" id="lgnPw" name="lgnPw" placeholder="로그인 PW" maxlength="14" minlength="6" required/></dd>
					
				</dl>
				
				<a href="#" class="loginBtn" id="check">게시글 삭제</a>
				<a href="${_ctx}/board/doc/view?docId=${list.docId}" class="joinBtn">뒤로가기</a>
				
				</form>
			   
			</div>

		</div>
	
	</body>
</html>
