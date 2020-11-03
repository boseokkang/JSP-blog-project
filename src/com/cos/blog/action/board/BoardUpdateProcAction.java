package com.cos.blog.action.board;

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
import com.cos.blog.util.Script;

public class BoardUpdateProcAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						// 0번 - 인증확인
						HttpSession session = request.getSession();
						if(session.getAttribute("principal") == null) {
										Script.getMessage("잘못된 접근입니다.", response);
										return;
						}
						
						
						// 1번 - request에 titile값과 content값 null인지 공백인지 확인
						if
						(
								request.getParameter("id").equals("") || 
								request.getParameter("id") == null || 								
								request.getParameter("title").equals("") || 
								request.getParameter("title") == null || 
								request.getParameter("content").equals("") || 
								request.getParameter("content") == null	
						) {
							return;
						}
						
						// 2번 - request에 title값과 content값 받기
						int id = Integer.parseInt(request.getParameter("id"));
						String title = request.getParameter("title");
						String content = request.getParameter("content");

						// 3번 - title값과 content, principal.getId():세션연결 값을 Board 오브젝트에 담기
						Board board = Board.builder()
								.id(id)
								.title(title)
								.content(content)								
								.build();
						
						// 4번 - BoardRepository 연결해서 save(board) 함수 호출
						BoardRepository boardRepository =	
														BoardRepository.getInstance();
						int result = boardRepository.update(board);
						
						// 5번 - result == 1 이면 성공로직(index.jsp로 이동)
						// 6번 - result != 1 이면 실패로직(history.back())
						if(result == 1) {
							Script.href("게시물 수정 완료", "/blog/board?cmd=detail&id="+id, response);
						} else {
							Script.back("게시물 수정 실패", response);
						}
					
				}					
	}

