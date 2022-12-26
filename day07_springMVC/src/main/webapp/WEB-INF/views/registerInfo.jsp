<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>id : ${member.id}</p>
<p>pw : ${member.pw}</p>
<p>name : ${member.name}</p>
<p>birth : ${member.birth}</p>
<p>email : ${member.email}</p>
<p>sports : ${member.sports}</p>
<p>sports : ${member.sports[0]}</p>
<p>sports : ${member.sports[1]}</p>
<p>sports : ${member.sports[2]}</p>
<p>hobby : ${member.hobby[0]}</p>
<p>hobby : ${member.hobby[1]}</p>
<p>hobby : ${member.hobby[2]}</p>

<%-- <p>hobby : ${paramValues.hobby[0]}</p>
<p>hobby : ${paramValues.hobby[1]}</p>
<p>hobby : ${paramValues.hobby[2]}</p> --%>

</body>
</html>