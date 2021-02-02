<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Schedule</title>
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
            margin: 1rem 2rem;
            padding: 0.5rem 1rem;
            background-color: dodgerblue;
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
            width: 75vw;
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
            display: block;
        }

        a {
            text-decoration: none;
            color: forestgreen;
            text-align: center;
            padding: 0.25rem;
            display: inline;
        }

        .container-1 {
            display: flex;
            justify-content: space-evenly;
        }

        .grid {
            display: grid;
            grid-template-columns: 1fr 1fr;
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

        .box-1 {
            margin: 0;
        }

        .row {
            display: flex;
            justify-content: space-evenly;
        }

        .row * {
            font-size: medium;
        }


        table * {
            margin: 0.25rem;
            padding: 0.25rem;
        }

        table caption {
            font-size: x-large;
            font-weight: bold;
            padding-bottom: 1rem;
        }

        table tr, th, td {
            text-align: center;
            border: 1px solid lightgrey;
        }

        table th {
            background-color: grey;
            color: white;
        }

        table tr:nth-child(even) {
            background-color: #dddddd;
        }

        table th, td {
            padding: 1rem 0.25rem;
        }

        footer {
            margin-bottom: 2rem;
        }
    </style>
</head>
<body>
<header>
    <h1>Add Schedule</h1>
</header>
<nav>
    <a href="<c:url value="/admin/admin-home/schedule-flight"/>">Back</a>
</nav>
<%--@elvariable id="flightSchedule" type="com.cognizant.airline_ticket_reservation_system.model.FlightSchedule"--%>
<c:url var="actionUrl" value="/admin/admin-home/schedule-flight/add-schedule">
    <c:param name="no" value="${ param.no }"/>
</c:url>
<div class="content">
    <div class="card">
        <div class="container">
            <div class="box">
                <table>
                    <caption>Flight Information</caption>
                    <thead>
                    <tr>
                        <th>Flight No</th>
                        <th>Airline</th>
                        <th>Model</th>
                        <th>Type</th>
                        <th>Economy Seats</th>
                        <th>Business Seats</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${ flight.no }</td>
                        <td>${ flight.airline }</td>
                        <td>${ flight.model }</td>
                        <td>${ flight.type }</td>
                        <td>${ flight.economySeats }</td>
                        <td>${ flight.businessSeats }</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <form:form action="${ actionUrl }" method="post" modelAttribute="flightSchedule">
                <div class="grid">
                    <div class="box">
                        <form:label path="source">
                            <spring:message code="label.flightSchedule.source"/>
                        </form:label>
                        <form:select path="source" items="${ sources }"/>
                    </div>
                    <div class="box">
                        <form:label path="destination">
                            <spring:message code="label.flightSchedule.destination"/>
                        </form:label>
                        <form:select path="destination" items="${ destinations }"/>
                        <form:errors path="destination" cssClass="error-text"/>
                    </div>
                    <div class="box">
                        <form:label path="businessSeatCost">
                            <spring:message code="label.flightSchedule.businessSeatCost"/>
                        </form:label>
                        <form:input path="businessSeatCost" type="number" placeholder="Enter business seat cost"/>
                        <form:errors path="businessSeatCost" cssClass="error-text"/>
                    </div>
                    <div class="box">
                        <form:label path="economySeatCost">
                            <spring:message code="label.flightSchedule.economySeatCost"/>
                        </form:label>
                        <form:input path="economySeatCost" type="number" placeholder="Enter business seat cost"/>
                        <form:errors path="economySeatCost" cssClass="error-text"/>
                    </div>
                    <div class="box">
                        <form:label path="arrivalTime">
                            <spring:message code="label.flightSchedule.arrivalTime"/>
                        </form:label>
                        <form:input path="arrivalTime" type="time"/>
                        <form:errors path="arrivalTime" cssClass="error-text"/>
                    </div>
                    <div class="box">
                        <form:label path="departureTime">
                            <spring:message code="label.flightSchedule.departureTime"/>
                        </form:label>
                        <form:input path="departureTime" type="time"/>
                        <from:errors path="departureTime" cssClass="error-text"/>
                    </div>
                </div>
                <div class="row">
                    <form:label path="sun">
                        <spring:message code="label.flightSchedule.sun"/>
                    </form:label>
                    <form:checkbox path="sun"/>
                    <form:label path="mon">
                        <spring:message code="label.flightSchedule.mon"/>
                    </form:label>
                    <form:checkbox path="mon"/>
                    <form:label path="tue">
                        <spring:message code="label.flightSchedule.tue"/>
                    </form:label>
                    <form:checkbox path="tue"/>
                    <form:label path="wed">
                        <spring:message code="label.flightSchedule.wed"/>
                    </form:label>
                    <form:checkbox path="wed"/>
                    <form:label path="thu">
                        <spring:message code="label.flightSchedule.thu"/>
                    </form:label>
                    <form:checkbox path="thu"/>
                    <form:label path="fri">
                        <spring:message code="label.flightSchedule.fri"/>
                    </form:label>
                    <form:checkbox path="fri"/>
                    <form:label path="sat">
                        <spring:message code="label.flightSchedule.sat"/>
                    </form:label>
                    <form:checkbox path="sat"/>
                </div>
                <input type="submit" value="Schedule" class="submit-btn">
            </form:form>
        </div>
    </div>
</div>
<footer></footer>
</body>
</html>
