package com.min.edu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.model.IMemberDao;
import com.min.edu.model.MemberDaoImpl;
import com.min.edu.vo.MemberVo;

public class SigninServlet extends HttpServlet {

	private static final long serialVersionUID = 916546168366905689L;
//	private Logger logger = Logger.getLogger(this.getClass());
	
	//회원가입 화면으로 이동하기위한 forward
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
	} 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//한글이 깨지지않게 인코딩 변경
	req.setCharacterEncoding("UTF-8");
	resp.setCharacterEncoding("UTF-8");
	resp.setContentType("text/html; charset=UTF-8;");
	
	String name = req.getParameter("name");
	String id = req.getParameter("id");
	String pw = req.getParameter("pw1");
	String[] phone = req.getParameterValues("num");
	String[] address = req.getParameterValues("add");
	String[] brith = req.getParameterValues("brith");
	
	String voPhone = "";
	String voaddress = "";
	String vobrith = "";
	
	if(phone!=null||address!=null||brith!=null) {
		voPhone = String.join(",", phone);
		voaddress = String.join(",", address);
		vobrith = String.join(",", brith);
	}
	
	MemberVo vo = new MemberVo();
	vo.setName(name);
	vo.setId(id);
	vo.setPassword(pw);
	vo.setPhone(voPhone);
	vo.setAddress(voaddress);
	vo.setBirth(vobrith);
//	logger.info("vo값 담지는지 확인 :"+vo);
	
	IMemberDao dao = new MemberDaoImpl();
	boolean isc = dao.signin(vo);
//	logger.info("isc값 담지는지 확인 :"+isc);
	
	// true이면 회원가입 성공 
	if(isc) {
		resp.sendRedirect("./login.do");
	}else {
		resp.sendRedirect("./main.do");
	}
	
	
	}
	
}
