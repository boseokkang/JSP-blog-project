//자바스크립트에서 리스너 만드는 방법
//변화를 감지
/*  ${"#img__preview"}.on("change",function(e){
 console.log(e);
 }); */

/* 	${"#img__preview"}.on("change",(e)=>{
 }); */

	$("#img__preview").on("change", function(e) {
							console.log(e.target.files);
						
							// 이미지 2가지 방법
							console.log(e.target.files[0].type.match("image*"));
							console.log(e.target.files[0].type.includes("image"));
						
							// files에 사진이 여러개 돌아가면 배열로 돌려서 찾아야한다!
							var f = e.target.files[0];
						
							// 자바스크립트에 match는 정규식으로 형태가 맞는지 아닌지 찾음
							if (!f.type.match("image*")) {
										alert("이미지만 첨부할 수 있습니다.");
										$("#img__preview").val('');
										return;
							}
							//숙제
							//여기서 이 사이즈를 넘어가면 2MB 넘어가므로 취소시킴 
							//f.size= 1024*1024*2
							if(f.size > 1024*1024*2){
											alert("이미지는 2MB 이하만 가능합니다.");
											$("#img__preview").val('');
											return;
							}
						
							var reader = new FileReader();
						
							// 바인딩된 이벤트
							reader.onload = function(e) {
								$("#img__wrap").attr("src", e.target.result);
							};
						
							// 비동기 실행
							reader.readAsDataURL(f);
							// 비동기 실행 → reader에 file을 복사함. 저장장치에 맡겨놓고 cpu는 다른 일을 할 수 있음!
							// ↑ 만약 동기 실행이라면 $("#img__wrap").attr("src", e.target.result - 사진 위치);
					


	});