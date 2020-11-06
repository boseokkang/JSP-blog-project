<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% 
	request.setCharacterEncoding("UTF-8");  //한글깨지면 주석제거
	String inputYn = request.getParameter("inputYn"); 
	String roadFullAddr = request.getParameter("roadFullAddr"); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소 입력 창</title>
</head>
<script>
function init(){
	var url = location.href;
	var confmKey = "devU01TX0FVVEgyMDIwMDYwMjA5NDkwMjEwOTgyMDE=";
	var resultType = "4"; // 도로명주소 검색결과 화면 출력내용, 1 : 도로명, 2 : 도로명+지번, 3 : 도로명+상세건물명, 4 : 도로명+지번+상세건물명
	var inputYn= "<%=inputYn%>";
	if(inputYn != "Y"){
		document.form.confmKey.value = confmKey;
		document.form.returnUrl.value = url; //현재 내 url (자기자신)
		document.form.resultType.value = resultType;
		document.form.action="http://www.juso.go.kr/addrlink/addrLinkUrl.do"; //인터넷망 
		document.form.submit();
	}else{
		opener.jusoCallBack("<%=roadFullAddr%>");
		window.close();
		}
}
</script>

<body onload="init();">
	<form id="form" name="form" method="post">
	<!-- <form id="form" action = "http://www.juso.go.kr/addrlink/addrLinkUrl.do" name="form" method="post"> -->>
		<input type="hidden" id="confmKey" name="confmKey" value=""/>
		<input type="hidden" id="returnUrl" name="returnUrl" value=""/>
		<input type="hidden" id="resultType" name="resultType" value=""/>
	</form>
</body>
</html> 