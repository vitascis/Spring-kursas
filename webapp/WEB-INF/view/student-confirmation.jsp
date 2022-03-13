<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>
Student is confirmed: ${student.firstName} ${student.lastName}
<br><br>
Country: ${student.country}
<br><br>
Favorite language: ${student.favoriteLanguage}
<br><br>
Operating systems:
<ul>
    <c:forEach var="operationSystem" items="${student.operatingSystems}">
    <li>
        ${operationSystem}
    </li>
        </c:forEach>
</ul>
</body>
</html>