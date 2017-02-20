<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="user"
	value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.user}"
	scope="application" />
<script type="text/javascript">
	
	//변수선언
	var d;
	
	$(function(){
		getTreeList();
	});
	
	// 트리 목록
	function getTreeList() {
		var _url = "${_ctx}/board/map/list.json";
		
		$.post(_url, function(json){
			//객체생성
			d = new dTree('d');
			
			if($.isArray(json)) {
					
				$(json).each(function() {
					console.log(this);
					
					//root를 찾아서 pid => -1로 바꾼다.
					if(this.parMapId == null) {
						d.add(this.mapId, -1, this.mapNm);
					
					//폴더일 경우 url 파라미터는 없다.	
					} else if(this.parMapId == 0) {
						d.add(this.mapId, this.parMapId, this.mapNm);
					
					//일반 메뉴	
					} else {
						d.add(this.mapId, this.parMapId, this.mapNm, "javascript:getList("+this.mapId+")");
					}
				});
				
				$("#dtree").html(d.toString());
				
				d.openAll();
				
			} else {
				
				alert("잘못된 데이터 입니다. \r\n 관리자에게 문의하세요.")
			}
			
		});
	}
	
	//dtree mapId 주소 숨기기
	function getList(mapId){
		
		$("#mapIdInTheLeft").val(mapId);
		$("#frmBoardMap").submit();
	}
	
</script>

<!-- dtree mapId 주소 숨기기 -->

<form id="frmBoardMap" action="${_ctx}/board/doc/list" method="post">
	<input type="hidden" name="mapId" id="mapIdInTheLeft" />
</form>

<div id="leftWrap">

	<div id="infoWrap">

		<div class="info_txt">
			<p class="info_name">${user.name}</p>
			<p class="info_date">${user.lgnId}</p>
			<p class="info_pic">
				<img src="/spd/res/img/thum_img.gif" alt="thum">
			</p>
		</div>

		<span><a href="/spd/logout">Logout</a></span>

	</div>

	<div id="category">
		
		<!-- 시계 -->
		<c:import url="/WEB-INF/views/inc/clock.jsp" />
		
		<!-- dtree 시작 -->
		<div class="dtree" id="dtree" ></div>
		<!-- dtree 끝 -->
		
		<div><br/>
			<script src='//uchat.co.kr/uchat.php' charset='UTF-8'></script>
			<script type='text/javascript'>
				u_chat({
				room:'specialdark'
				, chat_record:true
				, width:'300'
				, height:'300'
				, nick:'${user.name}'
				, mb_id:'${user.lgnId}'
				, level:""
				, icon:""
				, nickcon:""
				, no_inout:true	, chat_record:true	, skin:1
			});
			</script>
		</div>

	</div>

</div>