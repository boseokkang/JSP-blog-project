<%@page import="com.cos.blog.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="include/nav.jsp"%>

<!-- 매 jsp마다 설정하는게 아니라 nav에다가 설정하면 끝임 -->

<div class="container">

<c:forEach var="board" items="${boards}">

			<div class="card m-2" style="width: 100%">
				<div class="card-body">
					<h4 class="card-title">${board.title}</h4>
					<p class="card-text">${board.content}</p>
					<a href="#" class="btn btn-primary">상세보기</a>
				</div>
			</div>

</c:forEach>
</div>

<%@ include file="include/footer.jsp"%>