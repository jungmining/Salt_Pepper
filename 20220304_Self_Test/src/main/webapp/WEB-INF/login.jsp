<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript" src="./js/login.js"></script>
<link rel="stylesheet" href="./css/02_login.css">
</head>
<%@ include file="./header.jsp" %>

<body>
<form action="./login.do" name="loginForm" method="post"> 
<div class="login-form">
<%-- <input type="hidden" name="command" value="<%=request.getParameter("command") %>"> --%>
<input class="login" type="submit" value="로그인">
<p class="id">아이디<input type="text" id="userId" name="userId" placeholder="아이디를 입력해주세요" required></p>
<p class="pw" style="margin: 20px 0px 0px -15px;">비밀번호<input type="password" id="userPw" name="userPw" placeholder="비밀번호를 입력해주세요" required></p>
	
	<div class="idpw">
		<input type="button" onclick="idFind()" value="아이디 찾기">
		<input type="button" onclick="pwFind()" value="비밀번호 찾기">
	</div>
</div>
</form> 
</body>
<%@ include file="./footer.jsp" %>
</html>