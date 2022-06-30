/**
 * 
 */

//중복확인 먼저 하게 하는 알림창 띄우기 
function idCheckBox(){
	alert("먼저 중복확인을 진행해주세요")
}

//아이디 중복확인 창 띄우기 
function idChk(){
	window.open('idCheck.jsp',"","width=400px,height=600px");
}

//비밀번호 일치여부 체크하기
function pwChk(){
	var pw1 = document.getElementById("pw1").value;
	var pw2 = document.getElementById("pw2").value;
	

	if(pw1.length <4 || pw1.length>16 ){
		alert('비밀번호는 4글자 이상,16글자 이하로 사용하셔야 합니다.')
	}
	if(pw1!='' && pw2!= ''){
		if(pw1==pw2){
			document.getElementById("pwChk").innerHTML = '비밀번호가 일치합니다.';
			document.getElementById("pwChk").style.color = 'red';
		}else{
			document.getElementById("pwChk").innerHTML = '비밀번호가 일치하지않습니다.';
			document.getElementById("pwChk").style.color = 'red';
		}
	}
}

//전화번호 (숫자만 입력했는지)유효성 검사
addEventListener("keyup",function numChk(){
		var div = document.getElementsByTagName("div")[1];
		var divChild = div.childNodes;
		var regExp = /^[0-9]*$/;
		
		if(!regExp.test(divChild[1].value)|| divChild[1].value.length>=4){
			alert("형식에 맞게 입력하세요")
			divChild[1].value = '';
		}else if(!regExp.test(divChild[3].value)||divChild[3].value.length>=5){
			alert("형식에 맞게 입력하세요")
			divChild[3].value = '';
		}else if(!regExp.test(divChild[5].value)||divChild[5].value.length>=5){
			alert("형식에 맞게 입력하세요")
			divChild[5].value = '';
		}
	
})


//카카오 주소찾기 사용하기 
function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("sample6_postcode").value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }

//생년월일 (숫자만 입력했는지)유효성 검사

function birthChk1(){
	var birth = document.getElementsByTagName("div")[3];
	var div = birth.childNodes;
		var regYY = /19\d{2}|20\d{2}/;
/*		var regMM = /0[1-9]|1[0-2]/;
		var regDD = /0[1-9]|[1-2][0-9]|[3][0-1]/;*/

			if(!regYY.test(div[0].value)){
			alert("형식에 맞게 입력하세요\n예)19__/20__으로 입력하세요!")
			div[0].value = '';
			div[0].focus();
		}/*else if(!regMM.test(div[2].value)){
			alert("형식에 맞게 입력하세요")
			div[2].value = '';
			div[2].focus();
		}else if(!regDD.test(div[4].value)){
			alert("형식에 맞게 입력하세요")
			div[4].value = '';
			div[4].focus();
		}*/
}
function birthChk2(){
	var birth = document.getElementsByTagName("div")[3];
	var div = birth.childNodes;
		var regMM = /0[1-9]|1[0-2]/;
	if(!regMM.test(div[2].value)){
			alert('형식에 맞게 입력하세요.');
			div[2].value = '';
			div[2].focus();
		}
}
function birthChk3(){
	var birth = document.getElementsByTagName("div")[3];
	var div = birth.childNodes;
		var regDD = /0[1-9]|[1-2][0-9]|[3][0-1]/;

		 if(!regDD.test(div[4].value)){
			alert("형식에 맞게 입력하세요")
			div[4].value = '';
			div[4].focus();
		}
}


function allChk(){
/*	var sign = document.signUp;
	
	sign.action = */
	
	if(document.signUp.name.value.length==0){
		alert("이름을 입력해주세요");
		document.signUp.name.focus();
	}else if(document.signUp.id.value.length==0){
		alert("아이디를 입력해주세요");
		document.signUp.id.focus();
	}else if(document.signUp.pw1.value.length==0){
		alert("비밀번호를 입력해주세요");
		document.signUp.pw1.focus();
	}else if(document.signUp.pw1.value != document.signUp.pw2.value){
		alert("비밀번호가 일치하지 않습니다");

	}else{
		document.signUp.submit();
		alert("가입이 완료되었습니다");
	}
}

