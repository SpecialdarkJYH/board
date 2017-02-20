<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="_ctx" value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }"
	scope="application" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<c:import url="/WEB-INF/views/inc/head.jsp" />
		
		<c:if test = "${error.code == -1}">
			<script>
				alert("${error.msg}");
				location.href="${_ctx}/board/doc/view2?docId=${list.docId}"
			</script>
		</c:if>
		
		<script type="text/javascript">
			
			$(function(){
				
				//CK editior
				CKEDITOR.replace("docContents");
				
				//validate 폼검증
				$("#frmEdit").validate();
				
				$("#btnSave").click(function(){
					
					/* 첨부파일 null 체크 */            
	       $(".fileForm").find("input").each(function() {
	           if ( $(this).val() == "" | $(this).val() == " ") {
	               $(this).remove();
	           }
	       });
					
					var contents = CKEDITOR.instances.docContents.getData();
			    	
		    	if(contents == "") {
			    		
		    		alert("내용을 입력해주세요");
			    		
		    	} else {
					
						$("#frmEdit").submit();
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
		
		
		<title>게시글 수정</title>
	
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
	        	<h1>[${title2.mapNm}] 수정</h1>
	        </div>
            
	       	<div class="boardWrap">
		        <form action="${_ctx}/board/doc/edit" method="post" id="frmEdit" enctype="multipart/form-data">
	          	<input type="hidden" name="mapId" value="${title2.mapId}" />
         			<input type="hidden" name="docId" value="${list.docId}" />
	          	
	          	<table class="base_tbl tbl_write">
		           	<tbody>
		           		<tr>
		           			
	       	       		<th width="20%" class="t_color">제목 수정</th>
	                 	<td><input type="text" name="title" value="${list.title}" required /></td>
		              </tr>
		              <tr>
	         			 		<th class="t_color"><span class="disPB btnBase hand" onclick="addFile(this);">파일추가</span></th>
	                 	<td id="addFiles" class="fileForm" style="text-align: left ">
	                 		<c:forEach items="${list.fList}" var="file">
												<input style="width: 9%;" name="delFileList" type="checkbox" value="${file.fileId}" />
												<a href="${_ctx}/file/download?fileId=${file.fileId}">${file.orgFileNm}</a>
												<br/><br/>
											</c:forEach>
	                 	</td>
	                 	
	               	</tr>
	               	<tr>
	         			 		<th class="t_color">내용 수정</th>
	                 	<td><textarea name="docContents" id="docContents" required >${list.docContents}</textarea></td>
	               	</tr>
		           </tbody>
	           	</table>
		        </form>   
		        
	           <div class="btnSet alignCenter">
	               <a href="#" class="disPB btnBase" id=btnSave >수정</a>
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
