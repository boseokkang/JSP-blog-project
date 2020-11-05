package com.cos.blog.action.board;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.dto.DetailResponseDto;
import com.cos.blog.model.ReadCount;
import com.cos.blog.reposiotry.BoardRepository;
import com.cos.blog.util.HtmlParser;
import com.cos.blog.util.Script;

public class BoardDetailAction implements Action {

			@Override
			public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
							if (request.getParameter("id") == null || request.getParameter("id").equals("")) {
										Script.back("잘못된 접근입니다.", response);
										return;
							}
							int id = Integer.parseInt(request.getParameter("id"));
							BoardRepository boardRepository = BoardRepository.getInstance();
							// SELECT 로 id, 쿠키값 검사
							Cookie[] cookies = request.getCookies();
							ReadCount rc = null;
							if (cookies != null) {
								for (Cookie cookie : cookies) {
											if (cookie.getName().equals("JSESSIONID")) {
														rc = boardRepository.checkCookie(id, cookie.getValue());
														// request.setAttribute("JSESSIONID", cookie.getValue());
									
														// 쿠키값 INSERT
												if (rc == null) {
															boardRepository.saveCookie(id, cookie.getValue());
															// 조회수 증가
															boardRepository.updateReadCount(id);
												} else {
															// 시간을 비교해서 하루가 지났으면 조회수 증가
															Timestamp abc = Timestamp.valueOf(LocalDateTime.now());
															System.out.println(abc.getTime() - rc.getTimestamp().getTime());
															// 하루가 지났으면
													if ((abc.getTime() - rc.getTimestamp().getTime()) >= 1000 * 60 * 60 * 24) {
																	// 문제점 : 쿠키가 계속 저장되나 SELECT가 여러건이 될 경우 문제가 생기거나 하루 이상 켜두면 문제가 생김
																	boardRepository.updateReadCount(id);
															}
												}
											}
									}
							}
							DetailResponseDto dto = boardRepository.findById(id);
							if (dto != null) {
										String content = dto.getBoard().getContent();
										content = HtmlParser.youtube(content);
										// 데이터를 담고 갈때도 사용 RequestDispatcher
										// SendRedirect랑 똑같은데 request와 response를 유지하는 기법
										request.setAttribute("dto", dto);
										RequestDispatcher dis = request.getRequestDispatcher("board/detail.jsp");
										dis.forward(request, response);
							} else {
								Script.back("잘못된 접근입니다.", response);
							}
			}
}
