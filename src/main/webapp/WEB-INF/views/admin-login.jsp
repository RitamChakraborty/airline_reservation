<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Admin Home</title>
</head>
<body>
<h1>Admin Login</h1>
<%--@elvariable id="admin" type="com.cognizant.airline_ticket_reservation_system.model.Admin"--%>
<form:form action="/admin-home" method="post" modelAttribute="admin">
    <form:label path="username">
        <spring:message code="label.username"/>
    </form:label>
    <form:input path="username" id="username"/>
    <form:errors path="username" cssClass="ui-state-error-text"/>
    <br>
    <form:label path="password">
        <spring:message code="label.password"/>
    </form:label>
    <form:password path="password" id="password"/>
    <form:errors path="password" cssClass="ui-state-error-text"/>
    <br>
    <c:if test="${ not empty errorMessage}">
        <p>
            <%= request.getAttribute("errorMessage") %>
        </p>
    </c:if>
    <input type="submit" value="Login">
    <input type="reset" value="Reset">
</form:form>
<div class="news-feed">
    News feed will be displayed here
</div>
</body>
</html>