package com.cos.blog.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.model.Board;
import com.cos.blog.reposiotry.BoardRepository;
import com.cos.blog.util.HtmlParser;
import com.cos.blog.util.Script;



public class BoardSearchAction implements Action{

		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
					if(
										request.getParameter("keyword")==null ||
										request.getParameter("keyword").equals(" ")	
						) {
							Script.back("검색 키워드가 없습니다.", response);
							return;
					}
						
					int page = Integer.parseInt(request.getParameter("page"));
					String keyword = request.getParameter("keyword");
					
					//1. DB연결해서 Board목록 다 불러오기
					BoardRepository boardRepository =
										BoardRepository.getInstance();
					// 다 가져오기
					List<Board> count = boardRepository.findAll(keyword);
					int total = (count.size()/3);
					System.out.println(total);					
					List<Board> boards = boardRepository.findAll(page, keyword);
					
					for (Board board : boards) {	
								String preview = HtmlParser.getContentPreview(board.getContent());
								board.setContent(preview);
					}

					//2. request에 담고
					request.setAttribute("boards", boards);

					request.setAttribute("total", total);
					
					HttpSession session = request.getSession();
					session.setAttribute("backPage", page);
					session.setAttribute("backKeyword", keyword);
					//3. 이동 home.jsp
					RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
					dis.forward(request, response);	
		
		}
	

}
