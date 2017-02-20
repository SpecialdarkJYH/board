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
				background-image: url("/spd/res/img/img2.jpg");
			}
		</style>
		
		<c:import url="/WEB-INF/views/inc/head.jsp" />
		
		<title>회원가입</title>
		
		<script type="text/javascript">
			
			$(function(){
				
				//mask(폰)
				$("#phone").setMask();
				$("#email").setMask();
				
				//validate 폼검증
				$("#frmWrite").validate();
				
			/* 	//아이디 실시간 체크
				$("#lgnId").keyup(function(e){
					var lgnId = $(this).val();
					
					if(lgnId.length > 6) {
						console.log(e);
						$("#btnCheckId").click();
					}
				}); */
				
				$("#lgnId").focusout(function(){
					$("#btnCheckId").click();
				});
				
				//저장 (회원가입)
				$("#btnSave").click(function(){
					
					var isCheckedId = $("#isCheckId").val();
					var isCheckedEmail = $("#isCheckEmail").val();
					var isRecaptchaCheck = $("#isRecaptchaCheck").val();
					
					if(isCheckedId == "N") {
						alert("ID 체크를 먼저 실행해 주세요. ");
					} else if (isCheckedEmail == "N") {
						alert("Email 체크를 먼저 실행해 주세요. ");
					} else if (isRecaptchaCheck == "N") {
						alert("이미지에 맞추어 글씨를 입력해주세요. ");
					} else {
						$("#frmWrite").submit();
					}
				});
				
				// 아이디 중복검사
				$("#btnCheckId").click(function() {
						var lgnId = $("#lgnId").val();
						// ID를 입력하지 않았을 경우 alert 표시
						if(lgnId == "" || lgnId == " ") {
							alert("로그인 ID를 입력해주세요");
						// ID를 입력받았을 경우 중복 검사 실행
						} else {
							$.post("${_ctx}/join/id/available", {lgnId : lgnId}, function(json) {
								if(json=="Y") {
									alert($("#lgnId").val() + " 는 사용할 수 있는 ID입니다.");
									/* alert("사용할 수 있는 ID입니다."); */
									$("#isCheckId").val("Y");
								} else {
									alert("사용할 수 없는 ID입니다. \n 다른 ID를 적어주세요 ");
								}
							});
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
									alert($("#email").val() + " 는 사용할 수 있는 Email 입니다.");
									/* alert("사용할 수 있는 이메일입니다."); */
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
				
				//reCaptcha
				$(function() {

					var siteKey = "6Le49xIUAAAAAMiD36VZTNq9yssm4S-0hJyzbJOi";//Site key
					var div = "recaptcha";
					Recaptcha.create(siteKey, div, {
						theme : "red"
					});

					$("#recaptchaCheck").click(
						function() {
							var challenge = Recaptcha.get_challenge();
							var response = Recaptcha.get_response();
							var host = $(location).attr('host');
	
							$.ajax({type : "POST",
								url : "${_ctx}/join/validateRecaptcha",
								async : false,
								data : {host : host, challenge : challenge, response : response},
								success : function(data) {
									
									if (data == "Y") {
										document.getElementById("message").innerHTML = "성공!";
										$("#isRecaptchaCheck").val("Y");
									} else {
										document.getElementById("message").innerHTML = "틀리셨습니다. 다시시도해주세요!";
										Recaptcha.reload();
									}
								}
							});
	
						});
			
				});
				
				
				
				
				
			});
			
		</script>
		
	</head>

	<body>
	
		<div id="loginWrap">
			
			<div id="join">
				<h1>회원가입</h1>
					<form action="${_ctx}/join" method="post" id="frmWrite" >
					<input type="hidden" id="isCheckId" value="N" />
					<input type="hidden" id="isCheckEmail" value="N" />
					<input type="hidden" id="isRecaptchaCheck" value="N" />
					<dl>
						
						<dt>로그인 ID</dt>
						<dd><input type="text" id="lgnId" name="lgnId" placeholder="로그인 ID" maxlength="14" minlength="6" style="width:77%"  required/>
								<button id="btnCheckId" style= "width:70px; height:35px; background-color:#87CEFA; border:1px solid #87CEFA; color:#fff; cursor: pointer;">ID체크</button>
						</dd>
						
						<dt>로그인 PW</dt>
						<dd><input type="password" id="lgnPw" name="lgnPw" placeholder="로그인 PW" maxlength="14" minlength="6" required/></dd>
						
						<dt>로그인 PW 재입력</dt>
						<dd><input type="password" name="relgnPw" placeholder="로그인 PW 재입력" maxlength="14" minlength="6" equalTo="#lgnPw" required/></dd>
						
						<dt>이름</dt>
						<dd><input type="text" name="name" placeholder="이름" maxlength="14" minlength="2" required/></dd>
						
						<dt>이메일</dt>
						<dd><input type="email" id="email" name="email" placeholder="이메일" maxlength="30" minlength="6" style="width:75%" required/>
								<button id="btnCheckEmail" style= "width:75px; height:35px; background-color:#87CEFA; border:1px solid #87CEFA; color:#fff; cursor: pointer;">Email체크</button>
						</dd>
						
						<dt>전화번호</dt>
						<dd><input type="text" id="phone" alt="mobile" name="phone" placeholder="전화번호" maxlength="13" minlength="12" required/></dd>
						
						<div id="message" style="color:#ff0000;" ></div>
						<div id="recaptcha" style="height:80%"></div>
						<button id="recaptchaCheck" type="button" style= "width:70px; height:35px; background-color:#87CEFA; border:1px solid #87CEFA; color:#fff; cursor: pointer;" >Check</button>
						
					</dl>
				   
					<a href="#" id="btnSave" class="loginBtn" >저장</a>
					<!-- <a href="#" class="loginBtn" onclick="doWrite()" >저장2</a> -->
					<a href="${_ctx}" class="joinBtn">취소</a>
			
			</form>
			    
			</div>
			
		</div>
	
	</body>
	
</html>
