<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.min.edu.vo.MemberVo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>
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
<script type="text/javascript">
$(function(){
	$("#findID").click(function(){
		$.ajax({
			url : "./idfind.do",
			type : "post",
			data : {"name":$("#name").val(),"phone":$("#phone").val(),"birth":$("#birth").val()},
			dataType : "text",
			success : function(data){
				if(data != null){
					alert("회원님의 아이디는 \""+data+"\"입니다!!");
				}
			},
			error : function(){
				alert("없는 정보입니다!!");
			}
		});
	});
	
});
</script>
</head>
<body>
	<form action="" method="post">
		<table>
			<thead>
			<tr>
			<th colspan="2">>>아이디 찾기<<</th>
			</tr>
			</thead>
			<tbody>
				<tr>
				<td >이름</td>
				<td><input type="text" name="name" id="name" placeholder="성함을 입력해주세요"></td>
				</tr>
				<tr>
				<td>전화번호/휴대폰</td>
				<td><input type="text" name="phone" id="phone" placeholder="전화번호를 입력해주세요('-'을 포함하여 입력해주세요)"></td>
				</tr>
				<tr>
				<td>생년월일</td>
				<td><input type="text" name="birth" id="birth" placeholder="생년월일을 입력해주세요('-'을 포함하여 입력해주세요)"></td>
				</tr>
				<tr>
				<td><input type="button" id="findID" value="아이디 찾기"><input type="button" value="닫기" onclick="self.close()"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>