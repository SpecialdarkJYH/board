<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:if test="${fn:length(list) == 0}">
	<tr>
		<td colspan="5">목록이 없습니다.</td>
	</tr>
</c:if>

<c:forEach items="${list}" var="item">
	<tr>
		<td class="txtCut alignLeft">
			<a href="${_ctx}/board/doc/view2?docId=${item.docId}">${item.title} 
				<c:if test="${item.count != 0}">
					[${item.count}]
				</c:if>
			 	<c:forEach items="${item.fList}" var="file">
				<a href="${_ctx}/file/download?fileId=${file.fileId}">
					&nbsp;<img src="${_ctx}/res/img/dtree_img/base.gif" title="${file.orgFileNm}" />
				</a>
			 </c:forEach>
			</a>
		</td>
		<td><fmt:formatDate value="${item.regDt}"
				pattern="yyyy-MM-dd" /></td>
		<td>${item.name}</td>
		<td>${item.hit}</td>
	</tr>
</c:forEach>