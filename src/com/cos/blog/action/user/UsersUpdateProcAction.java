package com.cos.blog.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.model.Board;
import com.cos.blog.model.Users;
import com.cos.blog.reposiotry.BoardRepository;
import com.cos.blog.reposiotry.UsersRepository;
import com.cos.blog.util.Script;

public class UsersUpdateProcAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						// 0번 - 인증확인
						HttpSession session = request.getSession();
						if(session.getAttribute("principal") == null) {
										Script.getMessage("잘못된 접근입니다.", response);
										return;
						}
						
						
						// 1번 - request에 id, password, email address 값이 null인지 공백인지 확인
						if
						(
								request.getParameter("id") == null ||
								request.getParameter("id").equals("") ||
								request.getParameter("password") == null || 
								request.getParameter("password").equals("") || 
								request.getParameter("email") == null ||
								request.getParameter("email").equals("") ||
								request.getParameter("address") == null ||
								request.getParameter("address").equals("")
						) {
							Script.back("입력되지 않은 필드가 있습니다.", response);
							return;
						}
						
						// 2번 - request에 title값과 content값 받기
						int id = Integer.parseInt(request.getParameter("id"));
						String password= request.getParameter("password");
						String email= request.getParameter("email");
						String address= request.getParameter("address");

						// 3번 - title값과 content, principal.getId():세션연결 값을 Board 오브젝트에 담기
						Users user = Users.builder()
								.id(id)
								.password(password)
								.email(email)
								.address(address)
								.build();
						
						// 4번 - BoardRepository 연결해서 save(board) 함수 호출
						UsersRepository usersRepository =	
														UsersRepository.getInstance();
						int result = usersRepository.update(user);
						System.out.println("result : " + result);
						 
						// 5번 - result == 1 이면 성공로직(index.jsp로 이동)
						// update가 성공적일 때 세션이 재등록 된다.
						if(result == 1) {
							System.out.println("result ::: " + result);
							Users principal = usersRepository.findById(id);
							System.out.println("UsersUpdateProc : username : " + principal.getUsername());
							session.setAttribute("principal", principal);

							Script.href("회원정보 수정 성공", "/blog/index.jsp", response);
						} else {
							Script.back("회원정보 수정에 실패하였습니다.", response);
						}
								
				}					
	}

