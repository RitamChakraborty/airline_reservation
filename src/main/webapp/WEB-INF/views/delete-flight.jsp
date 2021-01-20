<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Flight</title>
</head>
<body>
<h1>Delete Flight</h1>
<form:form action="/delete-flight?no=${ no }">
    <p>
        <spring:message code="label.flight.no"/>
        <span>: ${ flight.no }</span>
    </p>
    <p>
        <spring:message code="label.flight.airline"/>
        <span>: ${ flight.airline }</span>
    </p>
    <p>
        <spring:message code="label.flight.model"/>
        <span>: ${ flight.model }</span>
    </p>
    <p>
        <spring:message code="label.flight.type"/>
        <span>: ${ flight.type }</span>
    </p>
    <p>
        <spring:message code="label.flight.seatsEconomy"/>
        <span>: ${ flight.seatsEconomy }</span>
    </p>
    <p>
        <spring:message code="label.flight.seatsBusiness"/>
        <span>: ${ flight.seatsBusiness }</span>
    </p>
    <input type="submit" value="Delete">
</form:form>
</body>
</html>
