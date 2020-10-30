package com.cos.blog.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {

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
}
