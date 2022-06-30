<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.min.edu.vo.MemberVo"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경하기</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js" ></script>
<style type="text/css">
table{
	width: 450px;
	border: 1px solid #ccc;
}
table>th{
	text-align: center;
}
table>td>input{
	width: 300px;
}
</style>
</head>
<body>
<form action="" method="post">
<table>
<thead>
<tr>
<th colspan="3">>>비밀번호 찾기<<</th>
</tr>
</thead>
<tbody>
<tr>
<td>아이디</td>
<td><input type="text" name="id"id="id" placeholder="아이디를 입력해주세요."></td>
</tr>
<tr>
<td>이름</td>
<td><input type="text" name="name" id="name" placeholder="성함을 입력해주세요"></td>
</tr>
<tr>
<td>전화번호/휴대폰</td>
<td><input type="text" name="phone" id="phone" placeholder="전화번호를 입력해주세요."></td>
</tr>
<tr>
<td><input type="button" id="findPw" value="비밀번호 찾기">
<input type="button" value="닫기" onclick="self.close()">
</td>
</tr>
</tbody>
</table>
</form>
</body>
<script type="text/javascript">
$(function(){
	$("#findPw").click(function(){
		$.ajax({
			url : "./pwfind.do",
			type : "post",
			data : {"id":$("#id").val(),"name":$("#name").val(),"phone":$("#phone").val()},
			dataType : "text",
			success : function(data){
				console.log(data);
				if(data != null){
					alert("회원정보가 확인되었습니다.");
					$("tbody tr").hide();
				//	$tbody = $("<tbody>");
				//	$("tbody").next().append("<tr>")
					
				}
			},
			error :function(){
				alert("없는 정보입니다!!");
			}
		})
	});
});
/* function (){
	
} */
</script>
</html>