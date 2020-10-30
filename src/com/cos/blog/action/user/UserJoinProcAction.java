package com.cos.blog.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.Users;
import com.cos.blog.reposiotry.UsersRepository;
import com.cos.blog.util.Script;

public class UserJoinProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						// 0. 유효성 검사
		 if 
		 (
										// require를 걸었을건데 이게 날라오면 정상적인 접근이 아님
										// 정상적인 접근이 아닌게 확실하니 걸러야함
										request.getParameter("username").equals(" ") ||
										request.getParameter("username") == null|| 
										request.getParameter("password").equals(" ") || 
										request.getParameter("password") == null|| 
										request.getParameter("email").equals(" ") || 
										request.getParameter("email") == null|| 
										request.getParameter("address").equals(" ") || 
										request.getParameter("address") == null
			) {
					
							// 밑에 실행 안하고 바로 빠져나감
							// 여기다가 return 하기전에 request.remote~를 Log를 남겨야함
							return;
		 }
					// 1. 파라메터 받기 (x-www-form-urlencoded 라는 MIME타입 key=value)
					// frontend에서 아무리 막아도 Postman 등으로 공격하면 뚫림
					// 그래서 서버에서 검사를 한다.
					String username = request.getParameter("username");
					String password = request.getParameter("password");
	
					// email에 대한 유효성 검사를 또 해야함
					// postman으로 공격하면 프론트에서 아무리 막아도 힘듬
					String email = request.getParameter("email");
					String address = request.getParameter("address");
					String userRole = RoleType.USER.toString(); // 강제성 부여
					//String userRole = RoleType.USER.name(); 위와 같음
					
					// 2. User - 오브젝트 변환
					
					Users user = Users.builder()
									.username(username)
									.password(password)
									.email(email)
									.address(address)
									.userRole(userRole)
									.build();

				// 3. DB연결 - UserRepositroy의 save() 호출
						UsersRepository usersRepository = UsersRepository.getInstance();
						int result = usersRepository.save(user);
				// 4. index.jsp 페이지로 이동
						if (result == 1) {
			 	// 여기서도 Script로 이동하는게 좋음

						RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
						dis.forward(request, response);
						} else {
				Script.back("회원가입에 실패하였습니다.", response);
		}
	}

}
