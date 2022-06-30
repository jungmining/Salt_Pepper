package com.min.edu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = -6631786077756904872L;
	
	//로그아웃하면 열린 세션을 종료하고 메인화면으로 돌아가기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		session.invalidate();
		session.removeAttribute("login");
		resp.sendRedirect("./index.jsp");
	}

}
