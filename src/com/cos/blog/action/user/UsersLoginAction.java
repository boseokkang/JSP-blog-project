package com.cos.blog.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;

public class UsersLoginAction implements Action {

		//컨트롤러가 해야될 일들이 있는데 Action을 만들어서 수행 = 위임
		//자기가 해야할일을 위임해서 다른 Class가 하게하는게 팩토리 패턴의 핵심임
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       RequestDispatcher dis = request.getRequestDispatcher("user/login.jsp");
	       dis.forward(request, response);
		
	}
}
