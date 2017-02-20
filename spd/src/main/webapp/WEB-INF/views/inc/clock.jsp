<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<c:import url="/WEB-INF/views/inc/head.jsp" />

<script type="text/javascript">
	$(document).ready(function() {

		setInterval(function() {
			var seconds = new Date().getSeconds();
			var sdegree = seconds * 6;
			var srotate = "rotate(" + sdegree + "deg)";

			$("#sec").css({
				"-moz-transform" : srotate,
				"-webkit-transform" : srotate
			});

		}, 1000);

		setInterval(function() {
			var hours = new Date().getHours();
			var mins = new Date().getMinutes();
			var hdegree = hours * 30 + (mins / 2);
			var hrotate = "rotate(" + hdegree + "deg)";

			$("#hour").css({
				"-moz-transform" : hrotate,
				"-webkit-transform" : hrotate
			});

		}, 1000);

		setInterval(function() {
			var mins = new Date().getMinutes();
			var mdegree = mins * 6;
			var mrotate = "rotate(" + mdegree + "deg)";

			$("#min").css({
				"-moz-transform" : mrotate,
				"-webkit-transform" : mrotate
			});

		}, 1000);

	});
</script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

#clock {
	position: relative;
	width: 150px;
	height: 150px;
	margin: 0 auto 5px auto;
	background: url(${_ctx}/res/js/plugins/CSS3Clock/images/clockface.png);
	list-style: none;
}

#sec, #min, #hour {
	position: absolute;
	width: 8px;
	height: 150px;
	top: 0px;
	left: 71.25px;
}

#sec {
	background: url(${_ctx}/res/js/plugins/CSS3Clock/images/sechand.png);
	z-index: 3;
}

#min {
	background: url(${_ctx}/res/js/plugins/CSS3Clock/images/minhand.png);
	z-index: 2;
}

#hour {
	background: url(${_ctx}/res/js/plugins/CSS3Clock/images/hourhand.png);
	z-index: 1;
}

</style>
<div>
	<ul id="clock">
		<li id="sec"></li>
		<li id="hour"></li>
		<li id="min"></li>
	</ul>
</div>