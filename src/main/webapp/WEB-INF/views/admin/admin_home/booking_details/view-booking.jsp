<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Booking Information</title>
</head>
<body>
<header>
    <h1>Booking Information</h1>
</header>
<nav>
    <a href="<c:url value="/admin/admin-home"/>">Home</a>
    <a href="<c:url value="/admin/admin-home/booking-details"/>">Back</a>
</nav>
<div class="content">
    <div class="card">
        <div class="container">
            <table>
                <caption>Flight Information</caption>
                <tbody>
                <tr>
                    <td>Flight No</td>
                    <td>${ flight.no }</td>
                </tr>
                <tr>
                    <td>Airline</td>
                    <td>${ flight.airline }</td>
                </tr>
                <tr>
                    <td>Model</td>
                    <td>${ flight.model }</td>
                </tr>
                <tr>
                    <td>Type</td>
                    <td>${ flight.type }</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card">
        <div class="container">
            <table>
                <caption>Flight Schedule Information</caption>
                <tbody>
                <tr>
                    <td>Date</td>
                    <td>${ flightBooking.date }</td>
                </tr>
                <tr>
                    <td>Source</td>
                    <td>${ flightSchedule.source }</td>
                </tr>
                <tr>
                    <td>Destination</td>
                    <td>${ flightSchedule.destination }</td>
                </tr>
                <tr>
                    <td>Arrival Time</td>
                    <td>${ flightSchedule.arrivalTime }</td>
                </tr>
                <tr>
                    <td>Departure Time</td>
                    <td>${ flightSchedule.departureTime }</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card">
        <div class="container">
            <table>
                <caption>All Bookings</caption>
                <thead>
                <tr>
                    <th>User Id</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="booking" items="${ bookings }">
                    <tr>
                        <td>${ booking.id }</td>
                        <td><a href="/admin/admin-home/booking-details/booking-information/${ booking.id }">View</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
