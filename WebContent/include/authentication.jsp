<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- 인증이 필요한 곳마다 이것을 import함 또는 web.xml에서 막음 -->
<c:if test="${empty sessionScope.principal}">
	<c:redirect url="/index.jsp"></c:redirect>
</c:if> 