package com.cos.blog.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.model.Users;
import com.cos.blog.reposiotry.UsersRepository;
import com.cos.blog.util.Script;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UsersProfileUploadProcAction implements Action {
				@Override
				public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					// TODO Auto-generated method stub
					// 현재는 프로젝트가 하나밖에 없어서 request.getServletContext() 가 필요없지만
					// 나중에 여러개를 다루게 되면 꼭 필요하다.
					String realPath =request.getServletContext().getRealPath("image");
					int id;
					String fileName = null;
					String contextPath = request.getServletContext().getContextPath(); //blog
					String userProfile =null;
					
					System.out.println("realPath : "+ realPath);
					System.out.println("contextPath : "+contextPath);
					try {
						MultipartRequest multi = new MultipartRequest
																				(
																						request, 
																						realPath,
																						1024*1024*2,
																						"UTF-8",
																						new DefaultFileRenamePolicy()
																				);
							fileName = multi.getFilesystemName("userProfile");
							System.out.println("fileName : "+fileName );
							id = Integer.parseInt(multi.getParameter("id"));
							
							userProfile = contextPath+"/image/"+fileName;
							
							//DB연결 
							UsersRepository usersRepository = 
									                UsersRepository.getInstance();
							int result = usersRepository.update(id, userProfile);
							
							if(result ==1) {
											HttpSession session = request.getSession();
											Users principal = usersRepository.findById(id);
											session.setAttribute("principal", principal);
								
											Script.href("사진 변경 완료", "/blog/index.jsp", response);	
							} else {
											Script.back("사진 변경 실패", response);
							}
					} catch (Exception e) {
							e.printStackTrace();
							Script.getMessage("오류 : "+e.getMessage(), response);
					}
					
					/* 원래는 이렇게 들고 와서 파싱하는것이나 우리는 파일은 multi. 라이브러리있는거로쓴다
					 * InputStream in = request.getInputStream(); BufferedReader br = new
					 * BufferedReader(new InputStreamReader(in,"utf-8")); StringBuilder sb = new
					 * StringBuilder(); String input = null; while((input = br.readLine())!=null) {
					 * sb.append(input); } System.out.println("사진받음");
					 * System.out.println(sb.toString()); Script.outText("테스트 중", response);
					 */
					
				}

}
