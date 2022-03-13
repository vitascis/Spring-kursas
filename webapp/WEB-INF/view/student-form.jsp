<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

</head>
<title>Student Registration Form</title>
<body>
<form:form action = "processForm" modelAttribute="student">
    First name: <form:input path="firstName"/>
    <br>
    <br>
    Last name: <form:input path="lastName" />
    <br>
    <br>
    Country:
         <form:select path="country">
             <form:options items="${student.countryOptions}" />
<!--        <form:option value="Latvija" label="Latvia"/>        -->
<!--        <form:option value="Lietuva" label="Lithuania"/>     -->
<!--        <form:option value="Lenkija" label="Poland"/>        -->
<!--        <form:option value="Estija" label="Estonia"/>        -->
</form:select>
<br>
<br>
Favorite language
    Java <form:radiobutton path="favoriteLanguage" value="Java"/>
    C# <form:radiobutton path="favoriteLanguage" value="C#"/>
    PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
    <br>
    <br>
    Operating systems:
    Linux <form:checkbox path="operatingSystems" value="Linux"/>
    Windows <form:checkbox path="operatingSystems" value="Windows"/>
    MAC <form:checkbox path="operatingSystems" value="MAC"/>


  <input type="submit"/>
</form:form>

</body>
</html>