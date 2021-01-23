<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Flight Search</title>
</head>
<body>
<form:form action="/flight-search" method="post" modelAttribute="flightSearch">
    <form:label path="date">
        <spring:message code="label.flightSearch.date"/>
    </form:label>
    <form:input path="date" type="date"/>
    <form:errors path="date"/>
    <br>
    <form:label path="source">
        <spring:message code="label.flightSearch.source"/>
    </form:label>
    <form:select path="source" items="${ sources }"/>
    <br>
    <form:label path="destination">
        <spring:message code="label.flightSearch.destination"/>
    </form:label>
    <form:select path="destination" items="${ destinations }"/>
    <br>
    <input type="submit" value="Search">
    <input type="reset" value="Reset">
</form:form>
<c:if test="${ showFlight }">
    <div class="flights">
        <c:choose>
            <c:when test="${ not empty flightsFound }">
                <h3>Available Flights</h3>
                <c:forEach var="flightSchedule" items="${ flightSchedules }">
                    <table>
                        <thead>
                        <tr>
                            <th>Flight No</th>
                            <th>Airline</th>
                            <th>Model</th>
                            <th>Type</th>
                            <th>Business Seats</th>
                            <th>Economy Seats</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${ flightSchedule.flight.no }</td>
                            <td>${ flightSchedule.flight.airline }</td>
                            <td>${ flightSchedule.flight.model }</td>
                            <td>${ flightSchedule.flight.type }</td>
                            <td>${ flightSchedule.flight.seatsEconomy }</td>
                            <td>${ flightSchedule.flight.seatsBusiness }</td>
                            <td><a href="/book-flight?${ flightSchedule.id }">Select</a></td>
                        </tr>
                        </tbody>
                    </table>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <h2>No flights found for journey from ${ param.source } to ${ param.destination }
                    on ${ param.date }</h2>
            </c:otherwise>
        </c:choose>
    </div>
</c:if>
</body>
</html>
