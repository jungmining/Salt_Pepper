<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="./css/02_login.css">
<style type="text/css">
.container{
	width: 60%;
	margin-top : 8%; 
	text-align: center;
}
</style>
</head>
<%
	MemberVo vo = (MemberVo)session.getAttribute("login");
	String[] add = vo.getAddress().split(","); 
	String add1 = add[0];
	String add2 = add[1];
	String add3 = add[2]+add[3];
	
	String birth1 = vo.getBirth().substring(0, 4);
	String birth2 = vo.getBirth().substring(5, 7);
	String birth3 = vo.getBirth().substring(8, 10);
	
%>

<%@ include file="./header.jsp" %>
<body>
<div class="container">
<table class="table table-hover">
<tbody>
<tr>
<td>이름</td>
<td>
<%=vo.getName() %>
</td>
</tr>
<tr>
<td>아이디</td>
<td><%=vo.getId() %></td>
</tr>
<tr>
<td>주소</td>
<td>우편번호 : <%=add1%><br>
	주소 : <%=add2 %><br>
	상세주소 : <%=add3 %>
</td>
</tr>
<tr>
<td>전화번호</td>
<td><%=vo.getPhone().replace(",", "-") %></td>
</tr>
<tr>
<td>생년월일</td>
<td><%=birth1 %>년&nbsp;<%=birth2 %>월&nbsp;<%=birth3 %>일
</td>
</tr>


</tbody>
</table>
<button onclick="()" type="submit">정보수정</button>
<button onclick="()" type="submit">회원탈퇴</button>
</div>


</body>
<%@ include file="./footer.jsp" %>
</html>