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
            margin: 2rem 4rem 1rem 4rem;
            border-radius: 10px;
            box-shadow: 0 15px 30px -10px grey;
            width: min-content;
        }

        .submit-btn {
            font-size: large;
            margin: 1rem 0;
            padding: 0.5rem 1rem;
            background-color: dodgerblue;
            border: none;
            outline: none;
            color: white;
            border-radius: 4px;
            width: 100%;
        }

        .reset-btn {
            font-size: large;
            padding: 0.5rem 1rem;
            background-color: forestgreen;
            border: none;
            outline: none;
            color: white;
            border-radius: 4px;
        }

        a {
            text-decoration: none;
        }

        .container {
            width: 80vw;
            display: grid;
            place-items: center;
        }

        table * {
            margin: 0.25rem;
            padding: 0.25rem;
            color: darkslategrey;
        }

        table caption {
            font-size: x-large;
            font-weight: bold;
            padding-bottom: 1rem;
        }

        table tr, th, td {
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

        form * {
            display: block;
            padding: 0.25rem;
            margin: 0.25rem;
        }

        form label, .label {
            font-weight: bold;
        }

        form input, select {
            border: none;
            outline: none;
            background-color: #dddddd;
            width: 100%;
            padding: 0.5rem;
            border-radius: 4px;
        }

        form input:focus, select:focus {
            outline: none;
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
            <form:form action="${ actionUrl }" method="post" modelAttribute="flightSchedule">
                <form:label path="flightNo" class="one">
                    <spring:message code="label.flightSchedule.flightNo"/>
                </form:label>
                <span>${ param.no }</span>
                <p class="label">
                    <spring:message code="label.flightSchedule.flight"/>
                </p>
                <span>${ flight }</span>
                <form:label path="source" class="one">
                    <spring:message code="label.flightSchedule.source"/>
                </form:label>
                <form:select path="source" items="${ sources }"/>
                <form:label path="destination" class="one">
                    <spring:message code="label.flightSchedule.destination"/>
                </form:label>
                <form:select path="destination" items="${ destinations }"/>
                <form:label path="cost" class="one">
                    <spring:message code="label.flightSchedule.cost"/>
                </form:label>
                <form:input path="cost" type="number" placeholder="Enter cost for the flight"/>
                <form:errors path="cost"/>
                <form:label path="arrivalTime" class="one">
                    <spring:message code="label.flightSchedule.arrivalTime"/>
                </form:label>
                <form:input path="arrivalTime" type="time"/>
                <form:errors path="arrivalTime"/>
                <form:label path="departureTime" class="one">
                    <spring:message code="label.flightSchedule.departureTime"/>
                </form:label>
                <form:input path="departureTime" type="time"/>
                <from:errors path="departureTime"/>
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
                <input type="submit" value="Schedule" class="submit-btn">
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
