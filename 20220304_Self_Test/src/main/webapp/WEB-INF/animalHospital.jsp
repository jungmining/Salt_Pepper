<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서울시 동물병원 찾기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/animal.js"></script>
<style type="text/css">
.container{
	width: 60%;
	margin-top : 8%; 

}
</style>
</head>
<%@ include file="./header.jsp" %>
<body>
<fieldset>
	<legend>검색하기</legend>
	<select id="guoffice" name="guoffice">
		<option selected value="null">===선택===</option>
		<option value="강남구">강남구</option>
		<option value="강동구">강동구</option>
		<option value="강북구">강북구</option>
		<option value="강서구">강서구</option>
		<option value="관악구">관악구</option>
		<option value="광진구">광진구</option>
		<option value="구로구">구로구</option>
		<option value="금천구">금천구</option>
		<option value="노원구">노원구</option>
		<option value="도봉구">도봉구</option>
		<option value="동대문구">동대문구</option>
		<option value="동작구">동작구</option>
		<option value="마포구">마포구</option>
		<option value="서대문구">서대문구</option>
		<option value="서초구">서초구</option>
		<option value="성동구">성동구</option>
		<option value="성북구">성북구</option>
		<option value="송파구">송파구</option>
		<option value="양천구">양천구</option>
		<option value="영등포구">영등포구</option>
		<option value="용산구">용산구</option>
		<option value="은평구">은평구</option>
		<option value="종로구">종로구</option>
		<option value="중구">중구</option>
		<option value="중랑구">중랑구</option>
	</select>
	<button onclick="guofficClick()">클릭</button>
</fieldset>
	<div>
		<table class="table table-bordered" style="width: 600px;">
			<thead></thead>
			<tbody></tbody>
		</table>
	</div>

<script type="text/javascript">
function guofficClick(){
var guoffice = document.getElementById("guoffice");
var guofficeVal = guoffice.options[guoffice.selectedIndex].value;
console.log(guofficeVal);

  $.getJSON("./json/Seoul_AnimalHospital.json",function(data){
	  console.log(data);
	  $.each(data,function(key,value){
	//		$("table").attr("border","1px");
			if(key == "DESCRIPTION"){
				$("thead").append("<tr><td>"+"번호"+"</td><td>"+value.DTLSTATENM+"</td><td>"+value.GUOFFICE+"</td><td>"+value.BPLCNM+"</td><td>"+value.TRDSTATENM+"</td><td>"+value.SITETEL+"</td><td>"+value.DCBYMD+"</td><td>"+value.SITEWHLADDR+"</td><td>"+value.RDNWHLADDR+"</td></tr>");
			}else if(key == "DATA"){
				var dList = value; //여러개의 DATA 묶음이 value에 들어있다 => JSONArray 
				for(let i=0;i<dList.length; i++){
					var oneData = dList[i];
					if(oneData.guoffice.trim() == guofficeVal){
				//		console.log(oneData.guoffice);
				//		console.log(oneData.guoffice.trim() == guofficeVal);
				//		console.log("같은지");
					$("tbody").append("<tr><td>"+(i+1)+"</td><td>"+oneData.dtlstatenm+"</td><td>"+oneData.guoffice+"</td><td>"+oneData.bplcnm+"</td><td>"+oneData.trdstatenm+"</td><td>"+oneData.sitetel+"</td><td>"+oneData.dcbymd+"</td><td>"+oneData.sitewhladdr+"</td><td>"+oneData.rdnwhladdr+"</td></tr>");
					}
				}
					
			}
			});
  });
/* 	$.ajax({
		url : "../json/Seoul_AnimalHospital.json",
		data : ""
		type : "get",
	});
 */	
}
</script>
</body>
<%@ include file="./footer.jsp" %>
</html>