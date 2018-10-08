<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 액션 태그</title>
</head>
<body>
<h1>jsp:useBean - scope의 기본값은 page이다.</h1>
<pre>
- page ==> request ==> session ==> application 보관소 순서로 찾는다.
</pre>

<%
// 기존에 세션에 보관된 데이터를 제거한다.
session.invalidate();
session = request.getSession();

// 보관소에 값을 넣는다.
application.setAttribute("name","홍길동");//ServletContext 보관소
session.setAttribute("name", "임꺽정");//HttpSession 보관소
request.setAttribute("name", "유관순");//ServletRequest 보관소
pageContext.setAttribute("name","안중근");//PageContext 보관소
%>

<jsp:useBean 
             id="name"
             class="java.lang.String"/>

<p>이름: <%=name %></p>

</body>
</html>























