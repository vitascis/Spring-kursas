<%--
  Created by IntelliJ IDEA.
  User: Kompiuteris
  Date: 2/11/2022
  Time: 10:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<h2>Company home page</h2>
<hr>
Welcome to company home page!
<p></p>
<%--add logout button --%>
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="logout">
</form:form>
</body>
</html>
