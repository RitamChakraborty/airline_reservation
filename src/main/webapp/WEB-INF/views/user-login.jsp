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
<h1>User Login</h1>
<%--@elvariable id="userLogin" type="com.cognizant.airline_ticket_reservation_system.model.UserLogin"--%>
<form:form action="/user-validation" method="post" modelAttribute="userLogin">
    <form:label path="id">
        <spring:message code="label.user.id"/>
    </form:label>
    <form:input path="id" id="user-id"/>
    <form:errors path="id" cssClass="ui-state-error-text"/>
    <br>
    <form:label path="password">
        <spring:message code="label.password"/>
    </form:label>
    <form:password path="password" id="password"/>
    <form:errors path="password" cssClass="ui-state-error-text"/>
    <br>
    <c:if test="${ not empty errorMessage }">
        <p>
            <%= request.getAttribute("errorMessage") %>
        </p>
    </c:if>
    <input type="submit" value="Login">
    <input type="reset" value="Reset">
</form:form>
<a href="<c:url value="/user-registration"/>">Sign Up</a>
<a href="<c:url value="/forget-password"/>">Forget Password</a>
<div class="news-feed">
    News feed will be displayed here
</div>
</body>
</html>