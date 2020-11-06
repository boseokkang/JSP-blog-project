<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>
<!-- 자바스크립트의 백틱을 못쓴다 $랑 겹쳐서? -->
<div class="container">
	
				<!-- href 이동 이런것을 버튼으로 만들고 싶으면 class="btn btn-secondary" -->
				<!-- href에서도 자바스크립트 사용할려면  href="javascript:history.back();"-->
				<!--<a class="btn btn-secondary" href="/blog/board?cmd=detail&id=1">이동</a>
				<a class="btn btn-secondary" href="javascript:history.back();">뒤로가기</a>  -->

				<!-- warning, danger -> 색깔만 바뀐것 -->
				<%@ include file="../include/goBack.jsp"%> <!-- 뒤로가기 -->					
				<c:if test="${sessionScope.principal.id == detailDto.boardDto.board.userId }">
					<!-- dto를 들고가도 되지만 자바코드를 안쓰기 위해서 -->
					<!-- 동기화를 위해서 항상 SELECT를 사용 -->
					<!-- 상세보기->수정페이지 title과 content를 들고 가야한다.(모델에 들렀다가 데이터를 들고 가야함) -->
					<!-- Board가 들고있는 id를 들고 와야함-->
				
					<a href="/blog/board?cmd=update&id=${detailDto.boardDto.board.id}" class="btn btn-warning">수정</a>			
	
					<!-- 삭제하기 -->
					<!-- 삭제는 get이 아니라 post로 넘긴다. -->
					<button class="btn btn-danger" onclick="deleteById(${detailDto.boardDto.board.id})">삭제</button>
				</c:if>
			
				<br />
				<br />
				<h6 class="m-2">
								작성자 : <i>${detailDto.boardDto.username}</i>
				</h6>
				<h5>조회수 : ${detailDto.boardDto.board.readCount}</h5>
				<br />
			
				<h3 class="m-2">
								<b>${detailDto.boardDto.board.title}</b>
				</h3>
			
				<div class="form-group">
								<div class="m-2">${detailDto.boardDto.board.content}</div>
				</div>
			
				<hr />
				<!-- 댓글 박스 -->
				<div class="row bootstrap snippets">
							<div class="col-md-12">
										<div class="comment-wrapper">
													<div class="panel panel-info">
														<div class="panel-heading m-2">
																	<b>Comment</b>
														</div>
														<div class="panel-body">
															<textarea id="reply__write__form" class="form-control" placeholder="write a comment..." rows="3"></textarea>
															
															<br>												
															<button onclick="replyWrite(${detailDto.boardDto.board.id}, ${sessionScope.principal.id})" class="btn btn-primary pull-right">댓글쓰기</button>
															<div class="clearfix"></div>
															<hr />
															
															<!-- 댓글 리스트 시작-->														
															<ul id="reply__list" class="media-list">	
																			<c:forEach var="replyDto" items="${detailDto.replyDtos}">
																							<!-- 댓글 아이템 -->
																							<li id="reply-${replyDto.reply.id }"  class="media">
																										<img onerror="this.src='/blog/image/userProfile.png'" src="${replyDto.userProfile}" alt="" class="img-circle">
																										<div class="media-body">															
																													<strong class="text-primary">${replyDto.username}</strong>
																													<p>${replyDto.reply.content}</p>
																										</div>	
																										<div class="m-2">																											
																													<c:if test="${replyDto.reply.userId eq sessionScope.principal.id}">
																																	<i onclick="replyDelete(${replyDto.reply.id})" class="material-icons i__btn">delete</i>
																													</c:if>
																										</div>		
																							</li>
																			</c:forEach>
															</ul>
													<!-- 댓글 리스트 끝-->
															</div>
													</div>
										</div>
					
							</div>
				</div>
				<!-- 댓글 박스 끝 -->
			</div>


<script src="/blog/js/delete.js"></script>
<script src="/blog/js/reply.js"></script>
<%@ include file="../include/footer.jsp"%>