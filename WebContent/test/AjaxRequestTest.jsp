<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style>
div {
	border: 1px solid black;
	margin: 5px;
	padding: 5px;
}
</style>

</head>
<body>

	<div id="reply-box">
		<div id="reply-1">첫번째 댓글입니다.</div>
	</div>


	<input type="text" value="" id="tf-reply" />
	<br />
	<button onclick="start()">댓글쓰기</button>

	<script>
		var num = 1;
		function start() {
			num++;
			var a = $('#tf-reply').val();
			//밑에 주석된 data에 JSON으로 넣기 힘드니 이렇게 사용함
			//data : '{"username" : "ssar", "password" : "1234"}'
			
			var data = {
				username : "ssar",
				content : a
			};
			// 통신이 성공하면 아래 로직 실행
			$.ajax({
				type : 'POST',
				url : 'AjaxResponseTest.jsp', //필수값
				//data : '{"username" : "ssar", "password" : "1234"}',
				data : JSON.stringify(data), //보내는 데이터
				contentType : 'application/json; charset=utf-8',
				dataType : 'json' //받을 데이터를 어떻게 파싱할까를 정의 text, json 
			}).done(function(result){
				console.log(result);
				$('#reply-box').append("<div id='reply-"+num+"'>"+a+"</div>");
				//console.log(JSON.parse(result)); --dataType 안받아도 된다.
				//dataType : 'json'으로 받기 때문에 JSON 으로 날라오면 자바스크립트 오브젝트로 변환되어서 들어온다.
			}).fail(function(error){
				console.log("에러났어");
				console.log(error);
			});
			//done, fail에는 function이 들어간다.
			//통신이 성공하면 done에 콜백, 실패하면 fail에 콜백
		}
	</script>

</body>
</html> 