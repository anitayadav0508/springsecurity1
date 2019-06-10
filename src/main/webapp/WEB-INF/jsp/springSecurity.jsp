<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Anita Yadav
  Date: 08-05-2019
  Time: 00:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Welcome <security:authentication property="principal.username"></security:authentication>
Your Role is <security:authentication property="principal.authorities"></security:authentication>
<security:authorize access="hasAnyRole('MANAGER','HR')">
    <h1>
        <a href="/mgr/add">Add</a><br>
        <a href="/mgr/edit">Edit</a>
        This is Manager Area
    </h1>
</security:authorize>
<security:authorize access="hasRole('EMPLOYEE')">
    <h2>
        This is Employee Area
    </h2>
</security:authorize>

<form:form action="/logout" method="post">
<input type="submit" value="Logout">
</form:form>
</body>
</html>
