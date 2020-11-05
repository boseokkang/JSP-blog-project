<%@page import="com.cos.blog.model.Users" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- request, session은 내장객체로 바로 접근 가능-->

<!DOCTYPE html>
<html lang="en">
<head>
<title>zzz blog</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script 
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script 
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script 
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
		
		<!-- 섬머노트 -->
<link  rel="stylesheet" 
 		href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css">
<script 
		src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	<!-- CSS -->
		<link href="/blog/css/styles.css" rel="stylesheet">
</head>
<body>

		<nav class="navbar navbar-expand-md bg-dark navbar-dark">
					<a class="navbar-brand" href="/blog/index.jsp">boseok blog</a>
					<button class="navbar-toggler" type="button" 
									data-toggle="collapse" data-target="#collapsibleNavbar">
									<span class="navbar-toggler-icon"></span>
					</button>
					<div class="justify-content-between collapse navbar-collapse" id="collapsibleNavbar">
								<ul class="navbar-nav">
									
										  <c:choose>
											    	<c:when test="${empty sessionScope.principal}">
																<li class="nav-item"><a class="nav-link" href="/blog/user?cmd=login">로그인</a></li>
													    		<li class="nav-item"><a class="nav-link" href="/blog/user?cmd=join">회원가입</a></li>
											   		</c:when>
											   		<c:otherwise>
													  			  <li class="nav-item"> <a class="nav-link" href="/blog/board?cmd=write">글쓰기</a></li>
																   <li class="nav-item"><a class="nav-link" href="/blog/user?cmd=update">회원정보</a></li>
																   <li class="nav-item"><a class="nav-link" href="/blog/user?cmd=logout">로그아웃</a></li>
											    	</c:otherwise>
											  </c:choose>
								</ul>
								
													
								<!-- 프로필 아무개 -->
								<ul class="navbar-nav"> <!-- navbar의 ~라는 뜻 꼭 줘야함 -->
									<!-- 로그인시 담겨있는 principal에 접근함 sessionScope에 접근함 -->
									<!-- onerror = src에서 못찾았을때를 대비-->
									<!-- style="border-radius: 둥글게 만들고 싶으면 자신의 사이즈의 반으로 설정하면 된다. -->
									<c:if test="${not empty sessionScope.principal}">
										<a href="/blog/user?cmd=profileUpload">
											<li class="nav-item">
											<img style="border-radius:20px" onerror="this.src='/blog/image/userProfile.png'" 
											src="${sessionScope.principal.userProfile}" width="40px" height="40px"/>
											</li>
										</a>
									</c:if>	
								</ul>
				</div>
			</nav>
			<br>