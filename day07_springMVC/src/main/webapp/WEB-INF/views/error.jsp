<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>예외 발생!!</h1>
	
	발생 예외 : ${e}<br/>
	예외 메세지: ${e.message}
	<ol>
	<c:forEach var="msg" items="${e.stackTrace}">
		<li>${msg.toString()}</li>
	</c:forEach>		
	</ol>
</body>
</html>

<!-- isErrorPage="true" 옵션을 사용하면 현재 페이지에서 직접 exception 객체를 사용
할 수 있음. model 객체로 전달 받지 않고 직접 exception객체를 사용할 수 있음 -->
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>예외 발생!!</h1>
	
	발생 예외 : ${pageContext.exception} <br/>
	예외 메세지: ${pageContext.exception.message}
</body>
</html> --%>