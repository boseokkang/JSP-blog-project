/**
 * <script> </script>가 생략되어있음
 */

var isCheckedUsername = false;

		// 6.4
		// 최근에는 함수를 변수화 시켜서 사용함
		/*
		 * const goPopup = function(){ window.open("/blog/juso/jusoPopup.jsp", "pop",
		 * "width=570,height=420, scrollbars=yes, resizable=yes"); }
		 */
		
		// 람다식
		/*
		 * const goPopup = () =>{ window.open("/blog/juso/jusoPopup.jsp", "pop",
		 * "width=570,height=420, scrollbars=yes, resizable=yes"); }
		 */
		
		// jsuo.go.kr 라이브러리 함수 (시작) -----------------------------------
		function goPopup() {
				window.open("/blog/juso/jusoPopup.jsp", "pop",
						"width=570,height=420, scrollbars=yes, resizable=yes");
		}
		
		function jusoCallBack(address) {
				// document.form.address.value = address; - 구방식
				// document.getElementById("address").value = address; - 내가한거
		
				// 요즘 방식
				var tfAddress = document.querySelector("#address");
				tfAddress.value = address;
		}
		

	
		// 중복체크 함수
		function validate() {
			if (!isCheckedUsername) {
				alert('username 중복체크를 해주세요');
			}
			// pageScope
			return isCheckedUsername;
		}
		
		// 데이터베이스에 ajax 요청을 해서 중복 유저네임이 있는지 확인
		// 있으면 1을 리턴, 없으면 0을 리턴, 오류가 나면 -1을 리턴
		function usernmaeCheck() {
				// 성공
				var tfUsername = $('#username').val();
				// 디버깅 1.alert, 2.console.log
				// alert(tfUsername);
				console.log(tfUsername);
		
			// ajax
			$.ajax({
				type : 'get',
				url : `/blog/user?cmd=usernameCheck&username=${tfUsername}`
			}).done(function(result) {
				console.log(result);
				// 자바스크립트 2개는 값만비교, 3개는 타입,값까지 비교함 if(result!==)
				if (result == 1) {
					alert('아이디가 중복되었습니다');
				} else if (result == 0) {
					alert('사용하실 수 있는 아이디입니다.');
					isCheckedUsername = true;
				} else {
					// 개발중에만 console로 찍어보고 배포할때 다 지워버림
					console.log('develop : 서버 오류');
				}
			}).fail(function(error) {
				console.log(error);
			});
		}
	