<%@page import="com.cos.blog.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="include/nav.jsp"%>

<!-- 매 jsp마다 설정하는게 아니라 nav에다가 설정하면 끝임 -->

<div class="container">
	
			<div class="col-md-12 m-2">
				<form class="form-inline justify-content-end" action="/blog/board">
					<input type="hidden" name="cmd" value="search"/>
					<input type="hidden" name="page" value="0"/>
					<input name="keyword" class="form-control mr-sm-2" type="text" placeholder="Search">
					<button class="btn btn-primary">검색</button>
				</form>
			</div>


<c:forEach var="board" items="${boards}">

			<div class="card m-2" style="width: 100%">
				<div class="card-body">
						<h4 class="card-title">${board.title}</h4>
						<p class="card-text">${board.content}</p>
						<a href="/blog/board?cmd=detail&id=${board.id}" class="btn btn-primary">상세보기</a>
				</div>
			</div>
</c:forEach>

<%-- 	http://localhost:8000/blog/board?cmd=home&page=0
	<c:set var="pageAddr" value = "/blog/board?cmd=home&page="${param.page}/>
	http://localhost:8000/blog/board?cmd=search&page=0&keyword=7
	<c:set var="pageAddr" value = "/blog/board?cmd=home&page='${param.page}'&keyword=${param.keyword}"/> --%>
		
 		${param.page}
 		
 		${total}
 		<!-- disabled -->
		<ul class="pagination justify-content-center">
			<c:choose>
				<c:when test="${not empty param.keyword}">
				
				<li class="page-item <c:if test="${param.page==0}">disabled</c:if>">
								<a class="page-link" href="/blog/board?cmd=search&page=${param.page-1}&keyword=${param.keyword}">Previous
								</a>
				</li>
			
				<li class="page-item <c:if test="${param.page==total}">disabled</c:if>">
								<a class="page-link" href="/blog/board?cmd=search&page=${param.page+1}&keyword=${param.keyword}">Next
								</a>
				</li>
				</c:when>
				
				<c:otherwise>
				
				<li class="page-item <c:if test="${param.page==0}">disabled</c:if>">
								<a class="page-link" href="/blog/board?cmd=home&page=${param.page-1}">Previous
								</a>
				</li>
						<li class="page-item <c:if test="${param.page==total}">disabled</c:if>">
								<a class="page-link" href="/blog/board?cmd=home&page=${param.page+1}">Next
								</a>
				</li>
				</c:otherwise>
			</c:choose>
	
		</ul>
</div>

<%@ include file="include/footer.jsp"%>