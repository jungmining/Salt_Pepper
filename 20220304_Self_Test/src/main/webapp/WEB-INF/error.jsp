<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러페이지</title>
<style type="text/css">
img{
width: 320px;
}
#error{
	border: 2px dotted #ccc;
	width: 400px;
	margin: 50px auto;
	text-align: center;
}
</style>
</head>
<body oncontextmenu="return false">
<div id="error">
<a href="./login.jsp">
<img alt="에러" src="./images/error.png">
</a>
</div>
<script type="text/javascript">
function click(){
	if(event.button==2){
		alert("오른쪽 마우스 금지입니다.");
	}
	document.onmousedown = click;
}
</script>
</body>
</html>