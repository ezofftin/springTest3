<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%-- Spring form 태그라이브러리
 
<form:form modelAttribute="member"> member: 검증 객체, 아래와 같은 태그
action 별도 지정이 없으면 현재페이지의 주소가 된다.
<form id="member" action="/day07/member/form" method="post">


<form:errors path="id" cssClass="css에서 사용될클래스명"/> 에러 출력 path에 에러 발생 필드를 설정, 아래와 같은 태그
<span id="id.errors" class="css에서 사용될클래스명">아이디는 {0}~{1}자리 사이어야 합니다.</span>
--%> 

<%@ page import="java.net.URLDecoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css' rel='stylesheet'>
<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js'></script>
<style>
	.msg{
		/* text-align:center; */
		font-size:14px;
		color:red;
	}
</style>

</head>
<body>

<div class="container w-50 mt-5 p-5 shadow">
	<!-- c:url 
		i) context root 경로 자동 추가
	 -->
	 <!-- method가 없으면 기본값은 get, onsubmit: submit이 수행될때 발생하는 이벤트 
	 
	 onsubmit = function(){ return inputChk(this); } submit수행시 사용할 함수를 등록	
	 
	 onsubmit="return inputChk(this)"는 function(){ 와 } 생략된 형태
	  
	 onsubmit = true: submit 수행, onsubmit=false: submit 수행안됨
	 -->
	<%-- <form action="<c:url value="/member/save"/>" method="post" onsubmit="return inputChk(this)"> --%> 
	<form:form modelAttribute="member">
		<h4>회원가입</h4>				
			
<%-- 		<div id="msg" class="msg my-4">${URLDecoder.decode(param.msg, "utf-8")}</div> --%>			
		<input class="form-control" type="text" id="id" name="id" placeholder="아이디" autofocus>		
		<div id="msg" class="msg"><form:errors path="id"/></div>			
		
		<input class="form-control mt-2" type="text" name="pw" placeholder="비밀번호">
		<div id="msg" class="msg"><form:errors path="pw"/></div>			
		
		<input class="form-control mt-2" type="text" name="name" placeholder="이름">
		<div id="msg" class="msg"><form:errors path="name"/></div>
		
		<input class="form-control mt-2" type="text" name="birth" placeholder="1999-10-11">
		<input class="form-control mt-2" type="text" name="email" placeholder="이메일">
		<input class="form-control mt-2" type="text" name="sports" placeholder="축구/배구/야구">
		<label><input type="checkbox" name="hobby" value="music"/>음악감상</label>
		<label><input type="checkbox" name="hobby" value="sports"/>운동</label>
		<label><input type="checkbox" name="hobby" value="movie"/>영화</label>
		
		<div class="text-center mt-3">
			<button class="btn btn-primary">가입</button>	
			<!-- <input class="btn btn-primary" value="가입"> -->
		</div>
	</form:form>
</div>
<script>
	function inputChk(obj){
		var msg ="";
		
		if(obj.id.value.length<3){
			setMsg("id의 길이는 3자리 이상이어야 합니다.", obj.id);
			return false;
		}
		
/* 		if(obj.pw.value.length<3){
			setMsg("비밀번호의 길이는 3자리 이상이어야 합니다.", obj.pw);
			return false;
		} */
		
		return true;
	}
	<%-- 
		// ES6(자바스크립트) Template literal 문법 사용 `(백틱) ${}
		${msg}를 EL로 해석을 하게되면 ""값으로 변환되어 브라우저로 전송된다.
		${'${msg}'} 감싸서 문자열처리해서 넘겨주면 브라우저에서 정상적으로 ES문법으로 컴파일함.
	--%>
	
	// 메세지, 태그를 받아서 처리하는 함수
	function setMsg(msg, element){ 
		document.getElementById("msg").innerHTML = `<i class="fa fa-info-circle">${'${msg}'}</i>`;
		
		if(element){
			element.select(); // 잘못된 입력값을 바로 선택해서 수정가능하도록 하는 메소드
		}
	}
</script>
</body>
</html>