<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book Ticket</title>
</head>
<body>
<header>
    <h1>Book Ticket</h1>
</header>
<nav>
    <a href="<c:url value="/user/user-home"/>">Home</a>
</nav>
<%--@elvariable id="bookTicket" type="com.cognizant.airline_ticket_reservation_system.model.BookTicket"--%>
<form:form action="/user/user-home/book-ticket" method="post" modelAttribute="bookTicket">
    <form:label path="date">
        <spring:message code="label.bookTicket.date"/>
    </form:label>
    <form:input path="date" type="date"/>
    <form:errors path="date"/>
    <br>
    <form:label path="source">
        <spring:message code="label.bookTicket.source"/>
    </form:label>
    <form:select path="source" items="${ sources }"/>
    <br>
    <form:label path="destination">
        <spring:message code="label.bookTicket.destination"/>
    </form:label>
    <form:select path="destination" items="${ destinations }"/>
    <br>
    <input type="submit" value="Search">
    <input type="reset" value="Reset">
</form:form>
<c:if test="${ showFlight }">
    <div class="flights">
        <table>
            <c:choose>
                <c:when test="${ not empty flightsFound }">
                    <caption>Available Flights</caption>
                    <c:forEach var="flightSchedule" items="${ flightSchedules }">
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
                            <td>${ flightSchedule.flight.economySeats }</td>
                            <td>${ flightSchedule.flight.businessSeats }</td>
                            <td><a href="/user/user-home/book-flight/${ flightSchedule.id }">Book</a></td>
                        </tr>
                        </tbody>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <caption>No flights found for journey from ${ param.source } to ${ param.destination }
                        on ${ param.date }</caption>
                </c:otherwise>
            </c:choose>
        </table>
    </div>
</c:if>
</body>
</html>
