<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container">
			<!-- d-flex를 주면 안에있는 div들이 block->inline으로 바뀜 -->
			<div class="d-flex justify-content-center">
			<!-- 애들이 inline으로 바뀌고 정렬이 힘들어서 div로 또 감싸서 함 -->
				<form action="/blog/user?cmd=profileUploadProc" method="post" enctype="multipart/form-data" >
						<div class="form-group">
								<img id="img__wrap" onerror="this.src='/blog/image/userProfile.png'" 
								src="${sessionScope.principal.userProfile}" width="350px" height="300px" />
						</div>
						<!-- form이 이 사이에 여백을 만들어줌 -->
						<div class="form-group bg-light">
									<!-- name 정확하게, id 미리보기에 쓸려고 + id는 -를 안쓰고 _를 쓴다 라이브러리는 _, 내가만든건 __ -->
									<input type="file" name="userProfile" id="img__preview" />
						</div>
		
						<input type="hidden" name ="id" value="${sessionScope.principal.id}"/>
		
						<div class="form-group">
									<button class="btn btn-primary w-100">사진전송</button>
					</div>
				</form>
			</div>
</div>

<script src="/blog/js/imgPreview.js"></script>
<%@ include file="../include/footer.jsp"%> 