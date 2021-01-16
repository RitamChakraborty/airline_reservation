<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
    <title>Select Role</title>
    <style>

    </style>
</head>
<body>
<%--@elvariable id="roleSelection" type="com.cognizant.airline_ticket_reservation_system.model.RoleSelection"--%>
<form:form action="/login" method="get" modelAttribute="roleSelection">
    <form:label path="role">
        <spring:message code="label.selectRole"/>
    </form:label>
    <br>
    <form:select path="role" items="${ roles }" id="role"/>
    <br>
    <input type="submit" value="Select Role">
</form:form>
</body>
</html>