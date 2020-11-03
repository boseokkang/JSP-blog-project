package com.cos.blog.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {

	public static void getMessage(String msg, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8"); 
			response.setContentType("text/html;charset=UTF-8");  
			PrintWriter out = response.getWriter();
			
			System.out.println("<h1>" +msg + "</h1>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void back(String msg, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.println("<script>");
			out.println("alert(' " + msg + " ');");
			out.println("histroy.back();");
			out.println("</script>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 페이지 이동시 메시지 O
	public static void href(String msg, String uri, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert(' " + msg + " ');");
			out.println("location.href='" + uri + "';");
			out.println("</script>");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		// 페이지 이동시 메시지 X
		public static void href(String uri, HttpServletResponse response) {
			try {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				out.println("<script>");
				out.println("location.href='" + uri + "';");
				out.println("</script>");	
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
