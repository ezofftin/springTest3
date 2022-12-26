 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/> 

<c:set var="link" value="${sessionScope.id == null ? '/login/login':'/login/logout'}"/>
<c:set var="loginOut" value="${sessionScope.id == null ? '로그인':'로그아웃'}"/>

    
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

<!-- custom CSS -->
<link rel="stylesheet" href="${ctx}/css/main.css">

</head>
<body>

	<div class="container">
		<br/>
		<h3><a href="">Web Study</a></h3>
	</div>
	<nav class="navbar navbar-expand-sm sticky-top">
	<div class="container">
	  <div class="collapse navbar-collapse" id="mynavbar">
	      <ul class="navbar-nav w-100">
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value='/'/>">HOME</a>
	        </li>
	        
	        <li class="nav-item me-auto">
	          <a class="nav-link" href="<c:url value='/board/list'/>">게시판</a>
	        </li>
	        
	        <li class="nav-item d-flex p-1">	        
<%-- 	          <a class="nav-link" href="<c:url value='/login/login'/>">로그인</a> --%>
	          <a class="nav-link" href="<c:url value='${link}'/>">${loginOut}</a>
	        </li>
	        
	        <li class="nav-item d-flex p-1">	        
	          <a class="nav-link" href="<c:url value='/member/form'/>">회원가입</a>
	        </li>
	        
	      </ul>
	  </div>
	</div>  
	</nav>



