<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Update Flight</title>
</head>
<body>
<h1>Update Flight</h1>
<form:form action="/update-flight?no=${ no }" method="post" modelAttribute="flight">
    <form:label path="airline">
        <spring:message code="label.flight.airline"/>
    </form:label>
    <form:select path="airline" items="${ airlines }" value="${ flight.airline }"/>
    <br>
    <form:label path="model">
        <spring:message code="label.flight.model"/>
    </form:label>
    <form:select path="model" items="${ models }" value="${ flight.model }"/>
    <br>
    <form:label path="type">
        <spring:message code="label.flight.type"/>
    </form:label>
    <form:select path="type" items="${ types }" value="${ flight.type }"/>
    <br>
    <form:label path="seatsEconomy">
        <spring:message code="label.flight.seatsEconomy"/>
    </form:label>
    <form:input path="seatsEconomy" value="${ flight.seatsEconomy }"/>
    <form:errors path="seatsEconomy"/>
    <br>
    <form:label path="seatsBusiness">
        <spring:message code="label.flight.seatsBusiness"/>
    </form:label>
    <form:input path="seatsBusiness" value="${ flight.seatsBusiness }"/>
    <form:errors path="seatsBusiness"/>
    <br>
    <input type="submit" value="Update">
    <input type="reset" value="Reset">
</form:form>
</body>
</html>
