function replyDelete(replyId) {
	
			var data = {
					replyId : replyId
			}
			
			//data, contentType 참고
			//key=value로 보내는 방법 중 하나
			//JSON으로 통일하는게 좋다.
			//remove = 자체를 날림 , empty = 비움
			//li 자체를 날릴거라서 remove를 쓴다.
			$.ajax({
						type : "post",
						url : "/blog/reply?cmd=deleteProc",
						data : "replyId="+replyId,
						contentType : "application/x-www-form-urlencoded; charset=utf-8",
						dataType : "text"
			}).done(function(result) {
						if(result == "1"){
									alert("댓글 삭제 성공");
									var replyItem = $("#reply-"+replyId);
									replyItem.remove();
						}else{
									alert("댓글 삭제 실패")
						}
			}).fail(function(error) {
						alert("댓글 삭제 실패");
			});	
}


	function replyWrite(boardId, userId) {
					// key : value
					// value에 인수들이 들어감
				if(userId === undefined){
					alert("로그인이 필요합니다.");
					return;
				}
			
				var data = {
					boardId : boardId,
					userId : userId,
					content : $("#reply__write__form").val()
				};

				$.ajax({
									type : "post",
									url : "/blog/reply?cmd=writeProc",
									data : JSON.stringify(data),
									contentType : "application/json; charset=utf-8",
									dataType : "json"
			}).done(function(result) {
									// 정상 응답
									// 1.reply__list를 찾아서 내부를 비우기
						if (result == -1 || result ==0) {
									alert("댓글 작성 실패1");
						}else{
									alert("댓글 작성 성공");
									// element 내용 지움
									// remove는 element를 지움
									$("#reply__list").empty();
									console.log(result);
									renderReplyList(result);
									$("#reply__write__form").val("");
						}
									// 2.ajax 재호출 findAll() select해서 들고온다.
									// 3.reply__list를 찾아서 내부에 채워주기
			}).fail(function(error) {
									alert("댓글 작성 실패");
			});
}

		function renderReplyList(replyDtos){
					for(var replyDto of replyDtos){
								$("#reply__list").append(makeReplyItem(replyDto));
					}
		}

		function makeReplyItem(replyDto){
					//reply-id 추가 시작
					var replyItem = `<li id="reply-${replyDto.reply.id}"class="media">`;
					//reply-id 추가 끝
					if(replyDto.userProfile == null){
					replyItem += `<img src="/blog/image/userProfile.png" class="img-circle">`;	
					}else{
					replyItem += `<img src="${replyDto.userProfile}" class="img-circle">`;
					}
					replyItem += `<div class="media-body">`;
					replyItem += `<strong class="text-primary">${replyDto.username}</strong>`;
					replyItem += `<p>${replyDto.reply.content}</p>`;
					replyItem += `</div>`;
					//휴지통 추가 시작
					replyItem += `<div class="m-2">`;
					replyItem += `<i onclick="replyDelete(${replyDto.reply.id})" class="material-icons i__btn">delete</i>`;
					replyItem += `</div>`;
					//휴지통 추가 끝
					replyItem += `</li>`;
					return replyItem;
		}