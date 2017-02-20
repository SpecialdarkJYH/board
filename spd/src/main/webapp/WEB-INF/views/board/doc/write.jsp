<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="_ctx" value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }"
	scope="application" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	
		<c:import url="/WEB-INF/views/inc/head.jsp" />
		
		<script type="text/javascript">
			
			$(function(){
				
				//CK editior
				CKEDITOR.replace("docContents");
				
				//validate 폼검증
				$("#frmWrite").validate();
				
				//Captcha 클릭시 변환
			  $("#img").click(function(){
        	$(this).attr("src", "${_ctx}/captcha/index");
		    });
				
				//Captcha 와 저장버튼클릭시 내용입력
			    $("#btnSave").click(function() {
			    	
			    	/* 첨부파일 null 체크 */            
			       $(".fileForm").find("input").each(function() {
			           if ( $(this).val() == "" | $(this).val() == " ") {
			               $(this).remove();
			           }
			       });
			    	
			    	//contents 내용 null값 방지
			    	var contents = CKEDITOR.instances.docContents.getData();
			    	
			    	if(contents == "") {
			    		
			    		alert("내용을 입력해주세요");
			    		
			    	} else {
			    		
			    		//Captcha
			    		if($("#frmWrite").valid()) {
				    		
			    			$.post("${_ctx}/captcha/check/", {captcha : $("#captcha").val()}, function(json) {
								
			    				if(json == "Y") {
			    					
			    					$("#isCaptchaCheck").val("Y");
			    					$("#frmWrite").submit();
			    					
			    				} else {
			    					
										alert("이미지에 문자를 잘못 입력하셨습니다. ");
									}
								});
			    		}
			    	}
			    	
			    });
				
				 
				
			});
			
			//파일 첨부
			function addFile(obj) {
				
				var fileHtml = "<input type='file' accept='image/jpeg,png,gif' name='files' />";
				/*방법이 여러가지 있다. $(obj).parent().next().append(fileHtml); */
				
				$("#addFiles").append(fileHtml);
				
			}
			
		</script>
		
		
		<title>게시글 작성</title>
	
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
	        	<h1>[${title2.mapNm}] 등록</h1>
	        </div>
            
	       	<div class="boardWrap">
		        <form action="${_ctx}/board/doc/write" method="post" id="frmWrite" enctype="multipart/form-data">
	          	<table class="base_tbl tbl_write">
		           	<tbody>
		           		<tr>
		           			<input type="hidden" name="mapId" value="${title2.mapId}" />
	       	       		<th width="20%" class="t_color">제목입력</th>
	                 	<td><input type="text" name="title" required /></td>
		              </tr>
	               	<tr>
	         			 		<th class="t_color"><span class="disPB btnBase hand" onclick="addFile(this);">파일추가</span></th>
	                 	<td id="addFiles" class="fileForm"></td>
	               	</tr>
	               	<tr>
	         			 		<th class="t_color">내용입력</th>
	                 	<td><textarea name="docContents" id="docContents" required ></textarea></td>
	               	</tr>
	               	<tr>
	               		<th width="20%" class="t_color">스팸방지문자</th>
	                 	<td><img id="img" src="${_ctx}/captcha/index" />
										<input type="text" id="captcha" name="captcha" placeholder="이미지 문자 작성" style="width:238px;" required /></td>
	               	</tr>
	               	
		           </tbody>
	           	</table>
		        </form>   
		        
	           <div class="btnSet alignCenter">
               <a href="#" class="disPB btnBase" id=btnSave >저장</a>
               <a href="javascript:getList(${title2.mapId})" id="disPBbtnBase" class="disPB btnBase"  >취소</a>
               <%-- onclick="getList(${title2.mapId})" href에 쓰던지 onclick 으로 추가해서 되는지 상관없다.
               			이게 되는 이유는 left.jsp에 있어서
               --%>
	           </div>
	           
	       	</div>
    		</div>
       	      
			</div>
		</div>
	</body>
</html>
