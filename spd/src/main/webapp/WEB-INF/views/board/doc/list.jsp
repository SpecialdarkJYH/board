<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tlds/pagetag.tld" prefix="page"%>
<c:set var="_ctx" value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }"
	scope="application" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	
		<c:import url="/WEB-INF/views/inc/head.jsp" />
		
		<script type="text/javascript">
			$(function(){
		
			});
		
			function goPageDoc(page) {
				$("#page").val(page);
				$("#frmSearch").submit();
			}
		</script>
		
		<!-- 사진들 크기 제한 -->
		<style>
		img {
			width: auto; 
			height: auto;
	    max-width: 858px;
	    max-height: 480px;
		}
		
		</style>
	
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
					  
		    	<h1>${title2.mapNm}</h1><%--  ${title} --%>
				  
				</div>
				
				<!-- 검색 시작 onsubmit="return false;" 이건 ajax할때 오류방지 들어가버릴수도있어서 -->
		    <form id="frmSearch" name="frmSearch" class="search_area" action="${_ctx}/board/doc/list" method="post">
		     <input type="hidden" name="mapId" value="${title2.mapId}" />
		     <input type="hidden" name="page" id="page" value="${search.page}" />
		     <dl>
		      <dd>
		       <select name="searchType" id="searchType" style="height: 30px;">
		        <option value="">:: 선택 ::</option>
		        <option value="T">제목</option>
		        <option value="C">내용</option>
		        <option value="TC">제목+내용</option>
		        <option value="R">작성자</option>
		       </select>
		      </dd>
		      <dd>
		       <input type="text" name="searchText" id="searchText" value="${search.searchText}" style="width:200px; height: 30px;">
		      </dd>
		      <dd>
		       <button id="btnSearch" class="hand" style="width:50px; height:30px;" onclick="goSearch();">검색</button>
		      </dd>
		     </dl>
		    </form>
		    <!-- 검색 끝 -->
				
				       
			 <div class="boardWrap">
               
         <table class="base_tbl">
          
           <tbody>
           	 <c:if test="${fn:length(list) == 0}">
           	   <tr>
           	   	 <td colspan="5">목록이 없습니다.</td>
           	   </tr>
           	 </c:if>
           	 
         	 	 <c:choose>
           	 
       				<c:when test= "${title2.mapId == 59}">
       				
	           		<c:forEach items="${list}" var="item" >
		           		<table class="base_tbl">
										<thead>
											<tr>
												<th colspan="6" class="t_color">${item.title}</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td width="10%">작성일</td>
												<td width="20%" class="t_color"><fmt:formatDate value="${item.regDt}" pattern="yyyy-MM-dd HH:mm" /></td>
												<td width="10%">작성자</td>
												<td width="20%" class="t_color">${item.name}</td>
												<td><a href="${_ctx}/board/doc/chkdelete?docId=${item.docId}" class="disPB btnBase" id="delete" class="disPB btnBase">삭제</a> 
												<a href="${_ctx}/board/doc/edit?docId=${item.docId}" class="disPB btnBase" id="write">수정</a></td>
												
											</tr>
											<tr>
												<td colspan="6" class="alignLeft">
												
												<c:forEach items="${item.fList}" var="file">
													<img src="${_ctx}/file/download?fileId=${file.fileId}" /><br/><br/>
													<!-- style="width:1024px; height:600px;" -->
												</c:forEach>
												<br/><br/>	
												${item.docContents}
											</td>
											</tr>
				           </tbody>
									</table>
	         	   	</c:forEach>
       				</c:when>
       				
		       			<c:otherwise>
		       			 <thead>
				           <tr>
				             <th width="8%">번호</th>
				             <th>제목</th>
				             <th width="25%">작성일</th>
				             <th width="10%">작성자</th>
				             <th width="10%">조회수</th>
				           </tr>
           			 </thead>
           			 
		           	 <c:forEach items="${list}" var="item" >
				           <tr>
				             <td>${item.docId}</td>
				             <td class="txtCut alignLeft">
				             <a href="${_ctx}/board/doc/view2?docId=${item.docId}">${item.title} 
					             <c:if test="${item.count > 0}">
					             [${item.count}]
					             </c:if>
				             <c:forEach items="${item.fList}" var="file">
											<a href="${_ctx}/file/download?fileId=${file.fileId}">
												&nbsp;<img src="${_ctx}/res/img/dtree_img/base.gif" title="${file.orgFileNm}" />
											</a>
											
										 </c:forEach>
				             </a></td>
				             <td><fmt:formatDate value="${item.regDt}" pattern="yyyy-MM-dd HH:mm" /></td>
				             <td>${item.name}</td>
				             <td>${item.hit}</td>
				           </tr>
		             </c:forEach>
			            
		            </c:otherwise>
            	</c:choose>
	            
           </tbody>
         </table>
         
         <div class="btnSet alignRight">
           <a href="${_ctx}/board/doc/write?mapId=${title2.mapId}" class="disPB btnBase" id="btnWrite">등록</a>
         </div>
         
         <!-- 페이징 -->
         <page:paging page="${search}" script="goPageDoc"/>
         
       	</div>
       	      
			</div>
		</div>
		</div>
</body>
</html>
