<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="./js/signup.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/03_singup.css">

</head>

<%@ include file="./header.jsp" %>
<body>
<form action="./signin.do" method="post" name="signUp">
<div class="container">
<table class="table table-hover">
<tbody>
<tr>
<td>이름(필수)</td>
<td><input type="text" id="name" name="name" placeholder="홍길동"></td>
</tr>
<tr>
<td>아이디(필수)</td>
<td><input type="text" id="id" name="id" placeholder="중복확인을 눌러주세요" onclick="idCheckBox()" readonly>
<input type="button" onclick="idChk()" value="중복확인">
</td>
</tr>
<tr>
<td>비밀번호(필수)</td>
<td><input id="pw1" name="pw1" type="password" placeholder="비밀번호를 입력해주세요" onchange="pwChk()"></td>
</tr>
<tr>
<td>비밀번호 확인(필수)</td>
<td><input style="width: 200px;" id="pw2" name="pw2" type="password" placeholder="비밀번호를 다시 입력해주세요" onchange="pwChk()">&nbsp;<span id="pwChk"></span></td>
</tr>
<tr>
<td>전화번호/휴대폰(필수)</td>
<td>
<div >
<input type="text" style="width: 60px; margin-right: 10px;" name="num" onchange="numChk()" placeholder="010" maxlength="3">-<input type="text" style="width: 80px; margin-left: 10px; margin-right: 10px;"name="num" onchange="numChk()"placeholder="1234" maxlength="4">-<input type="text"style="margin-left:10px; width: 80px;" name="num" onchange="numChk()"placeholder="1234" maxlength="4"></div></td>
</tr>
<tr>
<td rowspan="3">주소(선택)</td>
<td>
<div style="vertical-align:top">
<input type="text" id="sample6_postcode" name="add" placeholder="우편번호">
<input type="button" onclick="sample6_execDaumPostcode()" value="주소찾기">
</div>
</td>
</tr>
<tr>
<td>
<input type="text" id="sample6_address" name="add" placeholder="주소"></td>
</tr>
<tr>
<td>
<input type="text" id="sample6_detailAddress" name="add" placeholder="상세주소">
<input type="text" id="sample6_extraAddress" name="add" placeholder="참고항목">
</td>
</tr>
<tr>
<td>생년월일(선택)</td>
<td>
<div><input type="text" name="brith" style="width: 80px; margin-right: 10px;" onchange="birthChk1()" placeholder="ex)1996" maxlength="4">년<input type="text"onchange="birthChk2()" style="width: 80px; margin-left: 10px; margin-right: 10px;"name="brith" placeholder="ex)12"  maxlength="2">월<input type="text" style="margin-left:10px; width: 80px;" onchange="birthChk3()" name="brith" placeholder="ex)24"  maxlength="2">일
<input type="radio" name="claendar1">양력
<input type="radio" name="claendar2">음력
</div>
</td>
</tr>
</tbody>
</table>
<input class="finalSignup" onclick="allChk()" type="button" name="signup" value="회원가입">
</div>
</form>
</body>
<%@ include file="./footer.jsp" %>
</html>