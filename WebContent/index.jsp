<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



<%		
// 				//두개는 같음
// 				//response.sendRedirect("board?cmd=list");
// 				//<script> location.href="board?cmd=list";</script>
				
				
//				response.sendRedirect("/blog/board?cmd=home");
%>		
<c:redirect url="/board?cmd=home&page=0" />  
