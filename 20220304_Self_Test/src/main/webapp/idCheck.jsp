<%@page import="com.min.edu.model.MemberDaoImpl"%>
<%@page import="com.min.edu.model.IMemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.min.edu.vo.MemberVo"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js" ></script>
</head>
<body>
<form action="" method="post">
<table>
<tr>
	<td>아이디</td>
	<td>
		<input type="text" name="id"  id="id">
		<div></div>
	</td>
</tr>
<tr>
<td colspan="2"> 
	<input type="button" id="chkId" value="중복확인" >
	<input type="button" value="취소" onclick="self.close()">
</td>
</tr>
</table>
</form>
</body>
<script type="text/javascript">
$(function(){
	$("#chkId").click(function(){
		$.ajax({
			url : "./idcheck.do",
			type : "post",
			data : {"id":$("#id").val()},
			dataType : "text",
			success : function(data){
				var div = document.getElementsByTagName("div")[0];
				if($("#id").val().length<4||$("#id").val().length>16){
					div.innerHTML='<b style="color:red;">4글자 이상 16글자 이하로 작성해주세요.';
				}else{
					if(data!= ""){
						div.innerHTML = '<b style = "color : red;">사용 할 수 없는 아이디입니다.';
					}else{
						var useId = "사용할 수 있는 아이디입니다"+
						"<input type='button' value='사용' onclick='insertId(\""+$("#id").val()+"\")'>" ;
						div.innerHTML = useId;
					}
				}
			},
			error : function(){
				alert("오류");
			}
		});
	});
});

function insertId(val){
	opener.document.getElementsByName("id")[0].value = val;
	self.close();
}
</script>
</html>