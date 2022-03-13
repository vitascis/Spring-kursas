
<%--failas kuriamas home page'o vaizdui (be 404 klaidos)--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring rest demo</title>
</head>
<body>
<h3>
    Spring rest demo
</h3>
<hr>
<a href="${pageContext.request.contextPath}/test/hello">Hello</a>
<br><br>
<a href="${pageContext.request.contextPath}/api/students">Get all students </a>
</body>
</html>
