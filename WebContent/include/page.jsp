<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<ul class="pagination justify-content-center">
		
		<c:choose>
			<c:when test="${empty param.keyword}">
				<c:set var="pagePrev" value="/blog/board?cmd=home&page=${param.page-1}" />
				<c:set var="pageNext" value="/blog/board?cmd=home&page=${param.page+1}" />
			</c:when>
			<c:otherwise>
				<c:set var="pagePrev" value="/blog/board?cmd=search&page=${param.page-1}&keyword=${param.keyword}" />
				<c:set var="pageNext" value="/blog/board?cmd=search&page=${param.page+1}&keyword=${param.keyword}" />
			</c:otherwise>
		</c:choose>

		<li class="page-item <c:if test="${param.page==0}">disabled</c:if>">
		<a class="page-link" href="${pageScope.pagePrev}">Previous </a></li>

		<li class="page-item <c:if test="${param.page==total}">disabled</c:if>">
		<a class="page-link" href="${pageScope.pageNext}">Next </a></li>
	</ul>