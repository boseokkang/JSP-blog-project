<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file = "../include/nav.jsp" %>

<div class = "container">

	<form action="/blog/user?cmd=updateProc" name="form" id="form" method="POST" class="was-validated" >

	  <input type="hidden" name="id" value="${sessionScope.principal.id}">
	  <div class="form-group">
	    <label for="username">Username:</label>
	    <input value="${principal.username}" type="text" class="form-control" id="username" placeholder="Enter username" name="username" readonly="readonly">
	    <div class="valid-feedback">Valid.</div>
	    <div class="invalid-feedback">Please fill out this field.</div>
	  </div>

	  <div class="form-group">
	    <label for="password">Password:</label>
	    <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required>
	    <div class="valid-feedba ck">Valid.</div>
	    <div class="invalid-feedback">Please fill out this field.</div>
	  </div>

	   <div class="form-group">
	    <label for="email">Email:</label>
	    <input value="${principal.email}" type="email" class="form-control" id="email" placeholder="Enter email" name="email" required>
	    <div class="valid-feedback">Valid.</div>
	    <div class="invalid-feedback">Please fill out this field.</div>
	  </div>

	  <div class="form-group">
	    <label for="address">Address:</label>
		<button type="button" class="btn btn-warning float-right" onClick="goPopup();">주소 검색</button>
	    <input value="${principal.address}" type="text" class="form-control" id="address" placeholder="Enter address" name="address" required readonly="readonly">
	    <div class="valid-feedback">Valid.</div>
	    <div class="invalid-feedback">Please fill out this field.</div>
	  </div>

	  <button type="submit" class="btn btn-primary">회원 정보 수정하기</button>

	</form>
</div>

<script src="/blog/js/join.js"></script>
<%@ include file = "../include/footer.jsp" %>