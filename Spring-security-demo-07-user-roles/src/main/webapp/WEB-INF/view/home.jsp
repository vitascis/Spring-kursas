<%--
  Created by IntelliJ IDEA.
  User: Kompiuteris
  Date: 2/11/2022
  Time: 10:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<h2>Company home page</h2>
<hr>
Welcome to company home page!
<p></p>
<%--    display user name and roles --%>
User name: <security:authentication property="principal.username"/>
User role: <security:authentication property="principal.authorities"/>

<security:authorize access="hasAnyRole('VADYBININKAS(E)')">
<%-- add link to point to/leaders. This is for managers  --%>
<p><a href="${pageContext.request.contextPath}/leaders">Leadership meeting</a>
(For managers only!)
</p>
</security:authorize>

<security:authorize access="hasAnyRole('ADMINISTRATORIUS(E)')">
<%-- add link to point to /systems--%>
<p><a href="${pageContext.request.contextPath}/systems">Annual cruise</a>
(For admins only!)
</p>
</security:authorize>

<%--add logout button --%>
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="logout">
</form:form>
</body>
</html>
