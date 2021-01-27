<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Book Flight</title>
</head>
<body>
<header>
    <h1>Book Flight</h1>
</header>
<nav>
    <a href="<c:url value="/user/user-home/book-ticket"/>">Back</a>
</nav>
<div class="content">
    <div class="card">
        <div class="container">
            ${ sessionScope.flightSchedule }
            <a href="<c:url value="/user/user-home/book-ticket/payment"/>">
                <button class="submit-btn">Pay</button>
            </a>
        </div>
    </div>
    <div class="card">
        <div class="container">
            <%--@elvariable id="passengerSeats" type="com.cognizant.airline_ticket_reservation_system.model.PassengerSeats"--%>
            <form:form action="/user/user-home/book-ticket/passenger-entry" method="post"
                       modelAttribute="passengerSeats">
                <form:label path="economySeats">
                    <spring:message code="label.flight.economySeats"/>
                </form:label>
                <form:input path="economySeats" type="number"/>
                <form:errors path="economySeats" cssClass="error-text"/>
                <br>
                <form:label path="businessSeats">
                    <spring:message code="label.flight.businessSeats"/>
                </form:label>
                <form:input path="businessSeats" type="number"/>
                <form:errors path="businessSeats" cssClass="error-text"/>
                <br>
                <input type="submit" value="Next">
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
