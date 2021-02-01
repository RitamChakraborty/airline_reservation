<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Booking Details</title>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Raleway');
        @import url('https://fonts.googleapis.com/css2?family=Montserrat&display=swap');

        * {
            margin: 0;
            padding: 0;
            border-collapse: collapse;
            font-family: 'Montserrat', sans-serif;
        }

        html, body {
            height: 100%;
            width: 100%;
            background-image: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            background-size: cover;
            background-repeat: no-repeat;
            vertical-align: middle;
            background-attachment: fixed;
            display: flex;
            flex-direction: column;
        }

        header {
            background-image: linear-gradient(to right, rgba(46, 46, 224, 0.7), rgba(0, 255, 255, 0.18));
            background-color: rgb(139, 69, 19);
            box-shadow: 0 15px 30px -10px grey;
            border-bottom-left-radius: 50px;
            border-bottom-right-radius: 50px;
            padding: 2rem;
            font-family: Raleway, serif;
            text-align: center;
            color: white;
            height: 7%;
            display: grid;
            place-items: center;
        }

        .content {
            flex: 2;
            display: flex;
            flex-direction: column;
            justify-content: space-evenly;
            align-items: center;
            color: darkslategrey;
        }

        .card {
            background-color: rgba(255, 255, 255, 0.7);
            padding: 2rem;
            margin: 1rem 4rem 0.5rem 4rem;
            border-radius: 10px;
            box-shadow: 0 15px 30px -10px grey;
            width: min-content;
        }

        nav {
            padding: 1rem;
            display: flex;
            flex-direction: row;
            justify-content: space-evenly;
            align-items: center;
            font-size: large;
        }

        nav a {
            display: inline;
            text-decoration: none;
            color: darkslategrey;
            font-weight: bold;
            padding: 1.5rem 1.5rem;
            border-radius: 10px;
        }

        nav a:hover {
            padding: 1.5rem 1.5rem;
            background-color: rgba(255, 255, 255, 0.7);
            box-shadow: 0 15px 30px -10px grey;
        }

        .submit-btn {
            font-size: large;
            padding: 0.5rem 1rem;
            background-color: dodgerblue;
            border: none;
            outline: none;
            color: white;
            border-radius: 4px;
        }

        .reset-btn {
            font-size: large;
            padding: 0.5rem 1rem;
            background-color: mediumseagreen;
            border: none;
            outline: none;
            color: white;
            border-radius: 4px;
        }

        .news-feed {
            width: 50vw;
        }

        .news-feed table {
            width: 100%;
        }

        .news-feed table caption {
            font-size: x-large;
            font-weight: bold;
            padding-bottom: 1rem;
        }

        .news-feed td:nth-child(even) {
            padding: 1rem;
            background-color: #eeeeee;
        }

        .container {
            display: grid;
            width: 75vw;
            display: grid;
            place-items: center;
        }

        form {
            display: grid;
            place-items: center;
            font-size: medium;
        }

        form * {
            width: 100%;
            text-align: center;
        }

        label {
            margin: 0.25rem 1rem 0.5rem 1rem;
            font-size: x-large;
            color: darkslategrey;
            font-weight: bold;
        }

        input, select, option {
            margin: 0.5rem 1rem;
            font-size: medium;
            border: none;
            outline: none;
            background-color: #dddddd;
            color: darkslategrey;
            padding: 0.5rem;
            text-align-last: center;
            border-radius: 4px;
        }

        .error-text {
            font-family: monospace;
            color: tomato;
        }

        a {
            text-decoration: none;
        }

        table {
            width: 100%;
        }

        table * {
            margin: 0.25rem;
            padding: 0.25rem;
        }

        table caption {
            width: 100%;
            font-size: x-large;
            font-weight: bold;
            padding-bottom: 1rem;
            white-space: nowrap;
        }

        table tr, th, td {
            text-align: center;
            border: 1px solid lightgrey;
        }

        table th {
            background-color: grey;
            color: white;
        }

        table th, td {
            padding: 1rem 0.25rem;
        }

        .grid {
            display: grid;
            grid-template-columns: 1fr 1fr 1fr 1fr;
            place-items: center;
        }

        .box {
            margin: 1rem;
            padding: 1rem;
            display: grid;
            place-items: center;
        }

        .box input, select {
            width: 90%;
        }

        .container-1 {
            width: 50%;
            display: flex;
            flex-direction: row;
            justify-content: space-evenly;
            align-items: center;
        }

        .container-1 button {
            margin: 0 2rem;
        }

        .container-1 a {
            color: white;
        }

        footer {
            margin-bottom: 2rem;
        }
    </style>
</head>
<body>
<header>
    <h1>Booking Details</h1>
</header>
<nav>
    <a href="<c:url value="/admin/admin-home"/>">Home</a>
</nav>
<div class="content">
    <div class="card">
        <div class="container">
            <%--@elvariable id="flightBookingFilter" type="com.cognizant.airline_ticket_reservation_system.model.FlightBookingFilter"--%>
            <form:form action="/admin/admin-home/booking-details" method="post"
                       modelAttribute="flightBookingFilter">
                <div class="grid">
                    <div class="box">
                        <form:label path="date">Date</form:label>
                        <form:input path="date" type="date"/>
                    </div>
                    <div class="box">
                        <form:label path="flightNo">Flight No</form:label>
                        <form:select path="flightNo" items="${ flights }"/>
                    </div>
                    <div class="box">
                        <form:label path="source">Source</form:label>
                        <form:select path="source" items="${ sources }"/>
                    </div>
                    <div class="box">
                        <form:label path="destination">Destination</form:label>
                        <form:select path="destination" items="${ destinations }"/>
                    </div>
                </div>
                <div class="container-1">
                    <button type="submit" class="submit-btn">Filter</button>
                    <button type="reset" class="reset-btn">
                        <a href="<c:url value="/admin/admin-home/booking-details?msg=reset"/>">Reset</a>
                    </button>
                </div>
            </form:form>
        </div>
    </div>
    <div class="card">
        <div class="container">
            <table>
                <c:choose>
                    <c:when test="${ not empty flightBookings }">
                        <caption>All Bookings</caption>
                        <thead>
                        <tr>
                            <th>Flight Booking ID</th>
                            <th>Flight No</th>
                            <th>Source</th>
                            <th>Destination</th>
                            <th>Date</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="flightBooking" items="${ flightBookings }">
                            <tr>
                                <td>${ flightBooking.id }</td>
                                <td>${ flightBooking.flightSchedule.flightNo }</td>
                                <td>${ flightBooking.flightSchedule.source }</td>
                                <td>${ flightBooking.flightSchedule.destination }</td>
                                <td>${ flightBooking.date }</td>
                                <td>
                                    <a href="/admin/admin/home/booking-details/view-booking/${ flightBooking.id }"
                                       class="submit-btn">View</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </c:when>
                    <c:otherwise>
                        <caption>No bookings available</caption>
                    </c:otherwise>
                </c:choose>
            </table>
        </div>
    </div>
</div>
<footer></footer>
</body>
</html>