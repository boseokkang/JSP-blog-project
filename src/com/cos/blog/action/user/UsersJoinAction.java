package com.cos.blog.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;

public class UsersJoinAction implements Action {

		//컨트롤러가 해야될 일들이 있는데 Action을 만들어서 수행 = 위임
		//자기가 해야할일을 위임해서 다른 Class가 하게하는게 팩토리 패턴의 핵심임
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 페이지로 이동하는 action 
		RequestDispatcher dis = request.getRequestDispatcher("/user/join.jsp");
		dis.forward(request, response);
		System.out.println("아 망함");
	}

}
