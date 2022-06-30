package com.min.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.model.IMemberDao;
import com.min.edu.model.MemberDaoImpl;
import com.min.edu.vo.MemberVo;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private Logger logger = Logger.getLogger(this.getClass());
	
	//마이페이지 확인을 위한 테스트 로그인객체 생성
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
//		req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
//		
//		req.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html; charset=UTF-8;");
//		
//		String login = req.getParameter("userId");
//		
//		if(login.equals("admin")) {
//			
//		}
//		
//		
//		String id = req.getParameter("userId");
//		String pw = req.getParameter("userPw");
//	
//		HttpSession session = req.getSession();
////		session.setAttribute("loginTest",new MemberVo("김테스트", "admin", "admin","01011112222", "구로","20220202"));
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String id = req.getParameter("userId");
		String pw = req.getParameter("userPw");
		HttpSession session = req.getSession();
//		String command = req.getParameter("command");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("password", pw);
		
//		logger.info(map);
		IMemberDao dao = new MemberDaoImpl();
		MemberVo vo = dao.loginSelect(map);
		
//		logger.info(vo);
		
		PrintWriter out = resp.getWriter();
		
		if(vo != null) {
			session.setAttribute("login", vo);
			out.println("<script>");
			out.println("alert('로그인에 성공하였습니다.'); location.href='./';");
			out.println("</script>");
		}
		else {
			out.println("<script>");
			out.println("alert('일치하지 않는 회원 정보 입니다.'); location.href='./login.do';");
			out.println("</script>");
		}
		
		
		
	}
		
	
}
