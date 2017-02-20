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
		
		//메모 작성
		$("#btnMemoWrite").click(function(){
			
			var docId = ${list.docId};
			var memoContents = $("#memoContents").val();
			
			if(memoContents == "") {
				
				alert("댓글을 입력해 주세요.")
				
			} else {
				
				$.post("${_ctx}/board/memo/write.json"
					, {memoContents : memoContents, docId : docId /* "${list.docId}" 로 바로 받아도 된다. */}
					, function(data){
						
						if(data == 1) {

							location.reload();
							
						}
				});
			}
			
		});
	});
	</script>
	
	<title>게시글 보기</title>

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
					<h1>[${title2.mapNm}] </h1>
				</div>

				<div class="boardWrap">

					<table class="base_tbl">
						<thead>
							<tr>
								<th colspan="6" class="t_color">${list.title}</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td width="8%">첨부파일</td>
								<td class="txtCut alignLeft"><a href="#">user file.zip</a></td>
								<td width="10%">작성일</td>
								<td width="20%" class="t_color"><fmt:formatDate value="${list.regDt}" pattern="yyyy-MM-dd HH:mm" /></td>
								<td width="10%">조회수</td>
								<td width="20%" class="t_color">${list.hit}</td>
							</tr>
							<tr>
								<td colspan="6" class="alignLeft">${list.docContents}</td>
							</tr>
           </tbody>
					</table>
					<div class="btnSet">
						<a href="javascript:getList(${title2.mapId})" class="disPB btnBase" id="list" class="disPB btnBase">목록</a> 
						<a href="${_ctx}/board/doc/chkdelete?docId=${list.docId}" class="disPB btnBase" id="delete" class="disPB btnBase">삭제</a> 
						<a href="${_ctx}/board/doc/edit?docId=${list.docId}" class="disPB btnBase" id="write">수정</a>
					</div>
					
					<div class="replyWrap">
							
							<dl>
								<dt>작성자</dt>
								<dd>
									<tr>
										<th class="name">${user.name}</th>
										<%-- <input type="text" name="name" id="name" value="${user.name}" readonly /> --%>
									</tr>
								</dd>
								<dt>내용</dt>
								<dd>
									<textarea name="memoContents" id="memoContents" ></textarea>
								</dd>
							</dl>

							<div class="btnSet alignCenter">
								<a href="#" class="disPB btnBase" id="btnMemoWrite">댓글등록</a>
							</div>
						
						<table class="replyList">
							<tbody>
								<c:forEach items="${mlist}" var="mlist">
									<tr>
										<th class="name">${mlist.name}</th>
										<td class="cont">${mlist.memoContents}
										<a href="#" class="disPB btnS">삭제</a></td>
										<td class="date"><fmt:formatDate value="${mlist.regDt}" pattern="yyyy-MM-dd HH:mm" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>


				</div>
			</div>

		</div>
	</div>
</body>
</html>
