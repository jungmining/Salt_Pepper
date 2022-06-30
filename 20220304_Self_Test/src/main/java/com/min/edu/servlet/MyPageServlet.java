package com.min.edu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.model.IMemberDao;
import com.min.edu.model.MemberDaoImpl;
import com.min.edu.vo.MemberVo;

public class MyPageServlet extends HttpServlet {
	
	private static final long serialVersionUID = -5114206428413845744L;
	
	// 마이페이지로 화면전환하기 위한 forward
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/mypage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw1");
		String phone[] = req.getParameterValues("num");
		String address[] = req.getParameterValues("add");
		String brith[] = req.getParameterValues("brith");
		
		ServletContext app = req.getServletContext();
		app.setAttribute("name", name);
		app.setAttribute("id", id);
		app.setAttribute("pw", pw);
		app.setAttribute("phone", phone);
		app.setAttribute("address", address);
		app.setAttribute("brith", brith);
		
	}
}
