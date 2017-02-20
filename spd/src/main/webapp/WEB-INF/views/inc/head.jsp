<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="_ctx" value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }"
	scope="application" />
<c:set var="user"
value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.user}"
scope="application" />
	
<title>통합게시판{홍재영}</title>

<!-- css -->
<link href="${_ctx}/res/css/base.css" rel="stylesheet" type="text/css" />
<link href="${_ctx}/res/css/layout.css" rel="stylesheet" type="text/css" />

<!-- js -->
<script type="text/javascript" src="${_ctx}/res/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/plugins/recaptcha/recaptcha_ajax.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/plugins/validate/jquery.validate.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/plugins/validate/additional-methods.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/plugins/validate/messages_ko.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/plugins/mask/meioMask.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/plugins/dtree/dtree.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${_ctx}/res/js/jquery.form.js"></script>
