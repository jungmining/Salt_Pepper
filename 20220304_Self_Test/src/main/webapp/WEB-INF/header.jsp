<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.min.edu.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더꾸미기</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/01_main.css">
<script type="text/javascript" src="./js/login.js"></script>
<style type="text/css">
header{
	background: #bde1d4;
	height: 100px;
	color: #bde1d4;
	
}
	.head-title{
	background: #bde1d4;
	text-align: center;
	height: 20px;
	color: #bde1d4;
	}
</style>
</head>
<%
 MemberVo login = (MemberVo)session.getAttribute("login");  
%>
<body>
	<header>
	<h2 class="head-title"><a href="./">♡울집댕댕이들을 소개합니다♡</a></h2>
		<img class="img-main" alt="main" title="main이미지"
						src="./images/image01.png">
					<ul class="nav navbar-nav navbar-right">
						<li class="active"><a href="./">HOME</a></li>
	
						<%

						if(session.getAttribute("login")==null){%>
						<li><a href="./login.do">LOGIN</a></li>
						<li><a href="./signin.do">회원가입</a></li>
					
						<%
						}else{%>
						
						<li><a href="./mypage.do">MY PAGE</a></li>
						<li><a href="./logout.do">LOGOUT</a></li>
					
							
						<%
						}
						%> 
						<li><a href="./animal.do">동물병원찾기</a></li>
						<li><a href="#">HELP</a></li>
					</ul>
	</header>
</body>
</html>