package com.cos.blog.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.util.Script;

public class UsersLogoutAction implements Action {

	
      	//컨트롤러가 해야될 일들이 있는데 Action을 만들어서 수행 = 위임
		//자기가 해야할일을 위임해서 다른 Class가 하게하는게 팩토리 패턴의 핵심임
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		//컨트롤러가 해야될 일들이 있는데 Action을 만들어서 수행 = 위임
		//자기가 해야할일을 위임해서 다른 Class가 하게하는게 팩토리 패턴의 핵심임
		
							HttpSession session = request.getSession();
							//세션 무효화 되는 명령어
							session.invalidate();
							
							//세션을 날리기 싫으면 principal을 날린다. - 위의 명령어(invalidate)를 많이 사용함
							//session.removeAttribute("principal");
							
							
							//index.jsp 참고
							Script.href("로그아웃 성공", "index.jsp", response);
						}
					}
	
			
