<%@page import="com.cos.blog.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="include/nav.jsp"%>
<!--  로그인 했다는걸 알려줄려면 -->
<%
			Users principal = (Users) session.getAttribute("principal");
%>
<!-- request, session은 내장객체로 바로 접근 가능-->

<!-- 매 jsp마다 설정하는게 아니라 nav에다가 설정하면 끝임 -->
<h1>
	<%if  (principal != null) { %>
	<%=principal.getUsername() %>
	<%} %>
</h1>

<div class="container">
	<div class="card m-2" style="width: 100%">
		<div class="card-body">
			<h4 class="card-title">제목이 들어가는 자리</h4>
			<p class="card-text">본문 미리 보기...</p>
			<a href="#" class="btn btn-primary">상세보기</a>
		</div>
	</div>

	<div class="card m-2" style="width: 100%">
		<div class="card-body">
			<h4 class="card-title">제목이 들어가는 자리</h4>
			<p class="card-text">본문 미리 보기...</p>
			<a href="#" class="btn btn-primary">상세보기</a>
		</div>
	</div>

	<div class="card m-2" style="width: 100%">
		<div class="card-body">
			<h4 class="card-title">제목이 들어가는 자리</h4>
			<p class="card-text">본문 미리 보기...</p>
			<a href="#" class="btn btn-primary">상세보기</a>
		</div>
	</div>

</div>

<%@ include file="include/footer.jsp"%>