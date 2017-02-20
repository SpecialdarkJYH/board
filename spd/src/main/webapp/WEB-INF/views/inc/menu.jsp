<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="_ctx" value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }"
	scope="application" />
<script type="text/javascript" src="${_ctx}/res/js/jquery-3.1.1.min.js"></script>

<div id="header">
	<ul>
		<li><a href="${_ctx}/main/index">메인</a></li>
		<li><a href="${_ctx}/mywrite">내가 등록한 글</a></li>
		<li><a href="${_ctx}/board/doc/allview">전체글보기</a></li>
		<li><a href="${_ctx}/board/doc/hitlist">주간 인기글 보기</a></li>
		<li><a href="${_ctx}/myinfocheck">나의 정보</a></li>
		<li><a href="${_ctx}/admin">관리자</a></li>
	</ul>
</div>