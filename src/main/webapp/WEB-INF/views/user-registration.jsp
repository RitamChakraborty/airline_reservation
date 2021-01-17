<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>User Registration</title>
</head>
<body>
<h1>User Registration</h1>
<%--@elvariable id="userRegistration" type="com.cognizant.airline_ticket_reservation_system.model.UserRegistration"--%>
<form:form action="/user-singup" method="post" modelAttribute="userRegistration">
    <spring:message code="label.user.name"/>
    <form:input path="name"/>
    <form:errors path="name"/>
    <br>
    <spring:message code="label.password"/>
    <form:password path="password"/>
    <form:errors path="password"/>
    <br>
    <spring:message code="label.user.confirmPassword"/>
    <form:password path="confirmPassword"/>
    <form:errors path="confirmPassword"/>
    <c:if test="${ not empty errorMessage}">
        <span>${ errorMessage }</span>
    </c:if>
    <br>
    <spring:message code="label.user.email"/>
    <form:input path="email"/>
    <form:errors path="email"/>
    <br>
    <spring:message code="label.user.address"/>
    <form:input path="address"/>
    <form:errors path="address"/>
    <br>
    <spring:message code="label.user.phone"/>
    <form:input path="phone"/>
    <form:errors path="phone"/>
    <br>
    <input type="submit" value="Sign Up">
    <input type="reset" value="Reset">
</form:form>
</body>
</html>