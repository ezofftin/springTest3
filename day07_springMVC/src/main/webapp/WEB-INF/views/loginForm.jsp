<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>   

<%@ include file="/inc/header.jsp" %>
<%@ page import="java.net.URLDecoder"%>
<style>
	.msg{
		text-align:center;
		font-size:14px;
		color:red;
	}
</style>

<!-- c:url 기능
	i) context root 경로 자동 추가
	ii) sessionid를 자동을 추가
-->

<div class="container w-50 mt-5 p-5 shadow">
	<form action="<c:url value="/login/login"/>" method="post" onsubmit="return inputChk(this)"> 
		<h4>로그인</h4>				
			
		<div id="msg" class="msg my-4">${URLDecoder.decode(param.msg, "utf-8")}</div>
					
		<input class="form-control mb-2" type="text" id="id" name="id" value="${cookie.id.value}" placeholder="아이디" autofocus>		
		<input class="form-control mb-2" type="text" name="pw" placeholder="비밀번호">
		<input class="form-control mb-2" type="hidden" name="moveURL" value="${param.moveURL}">
		<!-- checkbox의 기본 value값은 on -->
		<label><input type="checkbox" name="rememberId" value="on" ${empty cookie.id.value ? "":"checked"}/>아이디 기억하기</label>
		
		<div class="text-center mt-3">
			<button class="btn btn-primary">로그인</button>	
			<!-- <input class="btn btn-primary" value="가입"> -->
		</div>
	</form>
</div>
<script>
	function inputChk(obj){
		var msg ="";
		
		if(obj.id.value.length<3){
			setMsg("id를 입력하세요!!", obj.id);
			return false;
		}
		
		if(obj.pw.value.length<3){
			setMsg("비밀번호를 입력하세요!!", obj.pw);
			return false;
		}
		
		return true;
	}

	
	// 메세지, 태그를 받아서 처리하는 함수
	function setMsg(msg, element){ 
		document.getElementById("msg").innerHTML = `<i class="fa fa-info-circle">${'${msg}'}</i>`;
		
		if(element){
			element.select(); // 잘못된 입력값을 바로 선택해서 수정가능하도록 하는 메소드
		}
	}
</script>
<%@ include file="/inc/footer.jsp" %>