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

public class IdFindServlet extends HttpServlet {

	private static final long serialVersionUID = -7918237624710339228L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String birth = req.getParameter("birth");
		
		phone = phone.replaceAll("-", ",");
		
		PrintWriter out = resp.getWriter();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("phone", phone);
		map.put("birth", birth);
		IMemberDao dao = new MemberDaoImpl();
		MemberVo vo = dao.findId(map);
		String id = vo.getId();
		if(vo != null) {
	//		out.print(name);
	//		out.print(phone);
	//		out.print(birth);
			out.print(id);
		}
		
		
	}
}
