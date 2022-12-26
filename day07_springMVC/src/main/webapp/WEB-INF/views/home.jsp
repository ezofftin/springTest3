<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 페이지마다 session="true"가 기본값

     session="true" 는 세션이 없는 상태에서는 세션을 새로 만듦
					세션이 있는 상태에서는 아무 동작을 하지 않는다.
	 session="false"는 세션이 있는 상태에서는 아무 동작을 하지 않는다.(세션을 종료한다는 의미가 아니다)
	                세션이 없는 상태에서는 세션을 생성하지 않도록 한다.
-->    

<!-- 세션이 없는 상태에서 sessionID 쿠키를 발급하지 않음(서버에 세션 객체 생성이 안됨) -->
<%--***  <%@ page session="false"%> 사용할 때 주의 사항 
sessionScope와 pageContext.session 명령은 사용불가 --%> 
<%-- <%@ page session="false" %> 는 아래와 동일--%>
<% request.getSession(false); 
  // request.getSession(true); == request.getSession()
%>

<%@ include file="/inc/header.jsp" %>
<div class="container">
	<h2>Welcome To page!!</h2>
</div>

<%@ include file="/inc/footer.jsp" %>

