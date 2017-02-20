<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="_ctx"
	value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }"
	scope="application" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<c:import url="/WEB-INF/views/inc/head.jsp" />

	<script type="text/javascript">
	$(function(){
		
		//메모 가져오기
		getMemoList();
		
		//메모 작성
		$("#btnMemoWrite").click(function(){
			
			var docId = "${list.docId}";
			var memoContents = $("#memoContents").val();
			console.log(memoContents +"메모확인")
			if(memoContents == "") {
				
				alert("댓글을 입력해 주세요.")
				
			} else {
				
				$.post("${_ctx}/board/memo/write.json"
					, {memoContents : memoContents, docId : docId /* "${list.docId}" 로 바로 받아도 된다. */}
					, function(data){
						
						if(data == 1) {
							
							getMemoList();
							
						}
				});
			}
		});
		
		/* 댓글 삭제2 뷰를 봤을때는 없기때문에(불러온거) live 개념
		 그래서 클릭이 먹지 않는다.	 
		*/
		$("#replyTbody").on("click", "a.btnRemove", function(){
			
			var memoId = $(this).attr("data");
			
			deleteMemo(memoId);
			getMemoList();
			
		});
		
		//글삭제
		$("#deleteDoc").click(function(){
			
			var deleteUser = "${user.userId}";
			var writeUser = "${list.userId}";
			
			if(deleteUser == writeUser)	{
				
				$.post("${_ctx}/board/doc/remove.json", { docId : "${list.docId}" } , function(json) {
					
					if(json == 1) {
						
						getList("${title2.mapId}");
						
					} else {
						
						alert("관리자에게 문의하세요.");
					}
					
				});
				
			} else {
				alert("당신은 수정 할 권한이 없습니다. 확인바랍니다.");
				document.location.href="${_ctx}/board/doc/view2?docId=${list.docId}";
			}
			
		});
		
		
	});
	
	//댓글 삭제1
	function deleteMemo(memoId) {
		
		var url = "${_ctx}/board/memo/delete.json"
		var param = {memoId : memoId}
		
		$.post(url, param, function(data){
			
			if(data == 1) {
				
				getMemoList();
				
			} else {
				
				alert("댓글 삭제에 실패하였습니다");
			}
		});	
	}	
			
	//댓글 목록 가져오기
	function getMemoList() {
		
		var url = "${_ctx}/board/memo/list";
		
		$.post (url, {docId : "${list.docId}"}, function(html){
			
			/* console.log(html); */
			$("#replyTbody").html(html);
			
		});
		
	}
	
	//게시물 수정하러 가기
	function goEdit() {
		$("#frmEdit").submit();
	}
	
	</script>
	
	<title>게시글 보기</title>

</head>

<body>
	<!-- 수정페이지용 form  -->
	<form id="frmEdit" action="${_ctx}/board/doc/edit" method="get">
		<input type="hidden" name="docId" value="${list.docId}"/>
	</form>
	<div id="wrap">

		<!-- 상단 메뉴 -->
		<c:import url="/WEB-INF/views/inc/menu.jsp" />

		<!-- 왼쪽 트리, 사용자 정보 -->
		<c:import url="/WEB-INF/views/inc/left.jsp" />

		<div id="rightWrap">

			<div class="rightBlock">
				<div class="page_top">
					<h1>[${title2.mapNm}] </h1>
				</div>

				<div class="boardWrap">

					<table class="base_tbl">
						<thead>
							<tr>
								<th colspan="8" class="t_color">${list.title}</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td width="8%">첨부파일</td>
								
								<td class="txtCut alignLeft">
									<c:forEach items="${list.fList}" var="file">
										<a href="${_ctx}/file/download?fileId=${file.fileId}">${file.orgFileNm}</a><br/><br/>
									</c:forEach>
								</td>
								<td width="10%">작성자</td>
								<td width="10%">${list.name}</td>
								<td width="10%">작성일</td>
								<td width="20%" class="t_color"><fmt:formatDate value="${list.regDt}" pattern="yyyy-MM-dd HH:mm" /></td>
								<td width="10%">조회수</td>
								<td width="10%" class="t_color">${list.hit}</td>
							</tr>
							<tr>
								<td colspan="8" class="alignLeft" >${list.docContents} <br/>
								
								</td>
							</tr>
           </tbody>
					</table>
					<div class="btnSet">
						<!-- 광고  -->					
						<script type="text/javascript" >
						if (/android|webos|iphone|ipad|ipod|blackberry|windows phone/i.test(navigator.userAgent))
						{(function(){document.writeln('<iframe width="320" height="50" allowtransparency="true" src="http://mtab.clickmon.co.kr/pop/wp_m_320.php?PopAd=CM_M_1003067%7C%5E%7CCM_A_1024422%7C%5E%7CAdver_M_1003115" frameborder="0" scrolling="no"></iframe>');})();}
						else{(function(){document.writeln('<iframe width="728" height="90" allowtransparency="true" src="http://tab2.clickmon.co.kr/pop/wp_ad_728.php?PopAd=CM_M_1003067%7C%5E%7CCM_A_1024422%7C%5E%7CAdver_M_1003115" frameborder="0" scrolling="no"></iframe>');})();}
						</script>
						<a href="javascript:getList(${title2.mapId})" class="disPB btnBase" id="list" class="disPB btnBase">목록</a> 
					<%-- 	<c:if test="${user.userId == list.userId}">  --%>
							<a href="${_ctx}/board/doc/chkdelete?docId=${list.docId}" class="disPB btnBase" id="delete" class="disPB btnBase">삭제</a>
							<a href="#" class="disPB btnBase" id="deleteDoc" class="disPB btnBase">삭제22</a> <!-- onclick="???" 로 해도된다-->
							<a href="${_ctx}/board/doc/edit?docId=${list.docId}" class="disPB btnBase" id="write" >수정</a>
							<a href="#" class="disPB btnBase" id="write" onclick="goEdit();">수정2</a>
					<%-- 	</c:if> --%>
					</div>
					
					<div class="replyWrap">
						
						<table class="replyList">
							<tbody id="replyTbody">
							</tbody>
						</table>
							
						<dl>
							<dt>내용</dt>
							<dd>
								<textarea name="memoContents" id="memoContents" ></textarea>
							</dd>
							<dt>댓글 등록 버튼</dt>
							<dd>
								<a href="#" class="btnBase joinBtn" id="btnMemoWrite">댓글등록</a>
							</dd>
						</dl>
						
						

					</div>


				</div>
			</div>

		</div>
	</div>
</body>
</html>
