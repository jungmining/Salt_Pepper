package com.min.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.model.IMemberDao;
import com.min.edu.model.MemberDaoImpl;
import com.min.edu.vo.MemberVo;

public class PwFindServlet extends HttpServlet {

	private static final long serialVersionUID = 8880877742951914446L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8;");
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		
		phone = phone.replaceAll("-", ",");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", name);
		map.put("phone", phone);
		
		PrintWriter out = resp.getWriter();
		IMemberDao dao = new MemberDaoImpl();
		MemberVo vo = dao.findPw(map);
		String pw = vo.getPassword();
		if(vo != null) {
			out.print(pw);
	//		req.getRequestDispatcher("/WEB-INF/updatePw.jsp").forward(req, resp);
		}
	}
}
