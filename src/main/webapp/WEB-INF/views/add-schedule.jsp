<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Add Schedule</title>
</head>
<body>
<h1>Add Schedule</h1>
<%--@elvariable id="flightSchedule" type="com.cognizant.airline_ticket_reservation_system.model.FlightSchedule"--%>
<form:form action="/add-schedule" method="post" modelAttribute="flightSchedule">
    <form:label path="flightNo">
        <spring:message code="label.flightSchedule.flightNo"/>
    </form:label>
    <form:select path="flightNo" items="${ flights }"/>
    <br>
    <form:label path="source">
        <spring:message code="label.flightSchedule.source"/>
    </form:label>
    <form:select path="source" items="${ sources }"/>
    <br>
    <form:label path="destination">
        <spring:message code="label.flightSchedule.destination"/>
    </form:label>
    <form:select path="destination" items="${ destinations }"/>
    <br>
    <form:label path="arrivalTime">
        <spring:message code="label.flightSchedule.arrivalTime"/>
    </form:label>
    <form:input path="arrivalTime" type="time"/>
    <br>
    <form:label path="departureTime">
        <spring:message code="label.flightSchedule.departureTime"/>
    </form:label>
    <form:input path="departureTime" type="time"/>
    <br>
    <form:label path="sun">
        <spring:message code="label.flightSchedule.sun"/>
    </form:label>
    <form:checkbox path="sun"/>
    <br>
    <form:label path="mon">
        <spring:message code="label.flightSchedule.mon"/>
    </form:label>
    <form:checkbox path="mon"/>
    <br>
    <form:label path="tue">
        <spring:message code="label.flightSchedule.tue"/>
    </form:label>
    <form:checkbox path="tue"/>
    <br>
    <form:label path="wed">
        <spring:message code="label.flightSchedule.wed"/>
    </form:label>
    <form:checkbox path="wed"/>
    <br>
    <form:label path="thu">
        <spring:message code="label.flightSchedule.thu"/>
    </form:label>
    <form:checkbox path="thu"/>
    <br>
    <form:label path="fri">
        <spring:message code="label.flightSchedule.fri"/>
    </form:label>
    <form:checkbox path="fri"/>
    <br>
    <form:label path="sat">
        <spring:message code="label.flightSchedule.sat"/>
    </form:label>
    <form:checkbox path="sat"/>
    <br>
    <input type="submit" value="Schedule">
    <input type="reset" value="Reset">
</form:form>
</body>
</html>
