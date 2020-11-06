function deleteById(boardId) {
	$.ajax({
		type : "POST",
		url : `/blog/board?cmd=delete&id=${boardId}`,
		//json으로 바꾸고 싶을때만 json, default = text
		dataType : "text"
	}).done(function(result) {
		if (result === '1') {
			alert("삭제 성공");
			location.href = "/blog/index.jsp";
		} else {
			// 실패하면 result가 0이 떨어짐
			alert("삭제 실패");
		}
	}).fail(function(error) {
		alert("서버 오류");
	});
}