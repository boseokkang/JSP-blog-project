package com.cos.blog.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.action.board.BoardDeleteAction;
import com.cos.blog.action.board.BoardDetailAction;
import com.cos.blog.action.board.BoardHomeAction;
import com.cos.blog.action.board.BoardUpdateAction;
import com.cos.blog.action.board.BoardUpdateProcAction;
import com.cos.blog.action.board.BoardWriteAction;
import com.cos.blog.action.board.BoardWriteProcAction;
import com.cos.blog.action.user.UsersJoinAction;

		/**
		 * Servlet implementation class UsersController
		 */
		
		// http://localhost:8000/blog/user
		// 뒤에 주소를 붙여서 분기를 시킴
		@WebServlet("/board")
public class BoardController extends HttpServlet {
		
			private final static String TAG = "BoardController : ";
		
			private static final long serialVersionUID = 1L;
		
			public BoardController() {
		        super();
			    
		}
		
			// 종류가 4가지인데 두개만 쓴다. Get, Post
			protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				// SELECT 는 doGet
				doProcess(request, response);
			}
		
			protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				// DML 은 doPost
				doProcess(request, response);
			}
		
			protected void doProcess(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				// Get과 Post에서 어떤 요청이 오든 이쪽으로 온다.
				// doProcess(request, response);
		System.out.println("도착함1");
				// http://localhost:/8000/blog/user?cmd=join
				// 쿼리스트림(?)으로 분기를 나눈다
				String cmd = request.getParameter("cmd");
				System.out.println(TAG + "router() : " + cmd);
				// http://localhost:8000/blog/user?cmd=join
				System.out.println("도착함2");
				// !!
				// 팩토리 패턴
				Action action = router(cmd);
				action.execute(request, response);
		
			}
		
			public Action router(String cmd) {
				if (cmd.equals("home")) {
					// 회원 가입 페이지로 이동
					return new BoardHomeAction();
				}else if (cmd.equals("write")){
					return new BoardWriteAction(); // 글쓰기 화면
				}else if (cmd.equals("writeProc")){
					return new BoardWriteProcAction(); //글쓰기
				}else if(cmd.equals("detail")) {
					return new BoardDetailAction(); // 상세보기
				} else if(cmd.equals("update")) {
					return new BoardUpdateAction(); // 수정 페이지
				} else if(cmd.equals("updateProc")) {
					return new BoardUpdateProcAction(); // 수정 페이지
				} else if(cmd.equals("delete")) {
					return new BoardDeleteAction(); // 수정 페이지
				}
				return null;
			}

   	}
