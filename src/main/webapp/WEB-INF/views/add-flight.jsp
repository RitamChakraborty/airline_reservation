<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Add Flight</title>
</head>
<body>
<h1>
    Add Flight
</h1>
<%--@elvariable id="flight" type="com.cognizant.airline_ticket_reservation_system.model.Flight"--%>
<form:form action="/add-flight" method="post" modelAttribute="flight">
    <form:label path="airline">
        <spring:message code="label.flight.airline"/>
    </form:label>
    <form:select path="airline" items="${ airlines }"/>
    <br>
    <form:label path="model">
        <spring:message code="label.flight.model"/>
    </form:label>
    <form:select path="model" items="${ models }"/>
    <br>
    <form:label path="type">
        <spring:message code="label.flight.type"/>
    </form:label>
    <form:select path="type" items="${ types }"/>
    <br>
    <form:label path="seatsEconomy">
        <spring:message code="label.flight.seatsEconomy"/>
    </form:label>
    <form:input path="seatsEconomy"/>
    <form:errors path="seatsEconomy"/>
    <br>
    <form:label path="seatsBusiness">
        <spring:message code="label.flight.seatsBusiness"/>
    </form:label>
    <form:input path="seatsBusiness"/>
    <form:errors path="seatsBusiness"/>
    <br>
    <input type="submit" value="Add Flight">
    <input type="reset" value="Reset">
</form:form>
</body>
</html>
