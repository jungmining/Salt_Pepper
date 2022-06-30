package com.min.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.model.IMemberDao;
import com.min.edu.model.MemberDaoImpl;
import com.min.edu.vo.MemberVo;

public class IdCheckServlet extends HttpServlet {

	private static final long serialVersionUID = 1231290702728196868L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("id");
		IMemberDao dao = new MemberDaoImpl();
		int cnt = dao.idChk(id);
		System.out.println(cnt);
		if(cnt == 1) {
			out.println(id);
		}
	}

}
