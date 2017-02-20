<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="_ctx"
	value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }"
	scope="application" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<c:import url="/WEB-INF/views/inc/head.jsp" />

<style>
.main-box {
	width: auto;
	height: auto;
}

.floating-box {
	display: inline-block;
	width: 600px;
	height: 333px;
	margin: 5px;
}

p.title-main {
	font-weight: bold;
	font-size: 20px;
}
</style>

<title>ADMIN</title>

</head>

<body>

	<!-- 상단 메뉴 -->
	<c:import url="/WEB-INF/views/inc/menu.jsp" />

	<!-- 왼쪽 트리, 사용자 정보 -->
	<c:import url="/WEB-INF/views/inc/left.jsp" />

	<div id="rightWrap">
		<div class="rightBlock">
			<div class="page_top">
				<h1>관리자만 들어올 수 있습니다.</h1>
			</div>
			<br>
			<div class="main-box">

				<!-- 메인 이미지 -->
				<div class="floating-box">
					<table>

						<thead>
							<tr>
								<th rowspan="2">
									<!-- 다음지도 --> <!-- 이미지 지도를 표시할 div 입니다 -->

									<div id="staticMap" style="width: 600px; height: 350px;"></div>
									<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=9b0ec9bbfae58a4858676c180f8ae97c"></script>
									<script>
										// 이미지 지도에 표시할 마커입니다
										// 이미지 지도에 표시할 마커를 아래와 같이 배열로 넣어주면 여러개의 마커를 표시할 수 있습니다 
										var markers = [ {
											position : new daum.maps.LatLng(
													35.16007, 126.9099859),
											text : '개발위치 : 한국경영원' // text 옵션을 설정하면 마커 위에 텍스트를 함께 표시할 수 있습니다     
										} ];

										var staticMapContainer = document
												.getElementById('staticMap'), // 이미지 지도를 표시할 div  
										staticMapOption = {
											center : new daum.maps.LatLng(
													35.16007, 126.9099859), // 이미지 지도의 중심좌표
											level : 3, // 이미지 지도의 확대 레벨
											marker : markers
										// 이미지 지도에 표시할 마커 
										};

										// 이미지 지도를 생성합니다
										var staticMap = new daum.maps.StaticMap(
												staticMapContainer,
												staticMapOption);
									</script>
									</p>
								</th>

							</tr>
						</thead>

					</table>
				</div>

				<!-- 최신글 -->
				<div class="floating-box">
					<table class="base_tbl">

						<thead>
							<tr>
									<div>
										<p style="font-size: 22px; font-weight: bold">
											<br />개발환경 <br />
											<br />OS : Windows 7 (64bit) <br />
											<br />DB : Oracle Database 11g <br />
											<br />툴 : STS(3.8.1.) <br />
											<br />언어 : JAVA,HTML,CSS,SQL(Oracle),JavaScript <br />
											<br />Java version : 1.8 <br />
											<br />Spring version : 3.2.16. <br />
											<br />형상관리 : SVN <br />
											<br />테스트 : JUnit <br />
											<br />프레임워크 : Spring, Spring-Security, jQuery, MyBatis
										</p>
									</div>
							</tr>
						</thead>

						<tbody></tbody>

					</table>
				</div>

				<br> 
				
				<!-- 빈공간  -->
					<div class="floating-box">
						<table class="base_tbl">

							<thead>
								<tr>
								</tr>
							</thead>

							<tbody></tbody>

						</table>
					</div> 
					
					<!--  빈공간 -->
					<div class="floating-box">
						<table class="base_tbl">

							<thead>
								<tr>
								</tr>
							</thead>

							<tbody></tbody>

						</table>
					</div>
			</div>
		</div>


	</div>
</body>
</html>
