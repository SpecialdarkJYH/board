<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:forEach items="${mlist}" var="mlist">
	<tr>
		<th class="name">${mlist.name}</th>
		<td class="cont">${mlist.memoContents}
		<a href="#" class="disPB btnS" onclick="deleteMemo(${mlist.memoId})">삭제1</a>
		<!-- 여기선 아이디가 아닌 클래스로 해야 맞다.
		표준은 아닌데 data를 넘겨주면 된다. -->
		<a href="#" class="disPB btnS btnRemove" data="${mlist.memoId}" >삭제2</a></td>
		<td class="date"><fmt:formatDate value="${mlist.regDt}"
				pattern="yyyy-MM-dd HH:mm" /></td>
	</tr>
</c:forEach>
