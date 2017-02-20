<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>MAIN</title>

<c:import url="/WEB-INF/views/inc/head.jsp"></c:import>

<style>
.main-box {
		width: auto;
		height: auto;
}

.floating-box {
    display: inline-block;
    width: 550px;
    height: 333px;
    margin: 5px;
}

p.title-main {
		font-weight: bold;
		font-size: 20px;
}
</style>

<script type="text/javascript">

	$(function() {
		
		getNoticeList();
		
		getHitList();
		
		getNewList();
		
	});

// 최신글 목록 가져와 추가(AJAX)
function getNewDoc() {
	var url = "${_ctx}/main/new.json";
	
	$.post(url,function(html) {
		console.log(html);
		$("#newDoc").html(html);
	});
}	

// 최신댓글 목록 가져와 추가(AJAX)
function getNewMemo() {
	var url = "${_ctx}/main/hit.json";
	
	$.post(url, function(html) {
		console.log(html);
		$("#newMemo").html(html);
	});
}


</script>

</head>
<body>

	<div id="wrap">

		<!-- 헤더, 메뉴 정보 -->
		<c:import url="/WEB-INF/views/inc/menu.jsp" />

		<!-- 왼쪽 트리, 사용자 정보 -->
		<c:import url="/WEB-INF/views/inc/left.jsp" />

		<div id="rightWrap">

			<div class="rightBlock">
				<div class="page_top">
					<h1>여기는 Main입니다.</h1>
				</div><br>
				
				<div class="main-box">
					
					<!-- 메인 이미지 -->
					<div class="floating-box">
						<table>
						
						<thead>
							<tr>
								<th>
								<th rowspan="2"><p class="title-main">	<iframe src="http://www.kma.go.kr/weather/main-now-weather.jsp"
										width="524px" height="625px" frameborder="0" marginwidth="0"
										marginheight="0" scrolling="no" title="현재날씨"></iframe></p><hr></th>
								
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
								<th colspan="4"><p class="title-main">최신글</p><hr></th>
							</tr>
						</thead>

						<tbody id="newDoc"></tbody>
						
						</table>
					</div>
					
					<br>
					
					<!--  -->
					<div class="floating-box">
						<table class="base_tbl">
						
						<thead>
							<tr>
								
							</tr>
						</thead>

						<tbody></tbody>
						
						</table>
					</div>
					
					<!--  최신순 -->
					<div class="floating-box">
						<table class="base_tbl">
						
						<thead>
							<tr>
								<th colspan="4"><p class="title-main">최신댓글</p><hr></th>
							</tr>
						</thead>

						<tbody id="newMemo"></tbody>
						
						</table>
					</div>
					
				</div>
				
			</div>

		</div>

	</div>

</body>
</html>
