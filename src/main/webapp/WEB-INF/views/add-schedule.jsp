<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Schedule</title>
    <style>
        * {
            margin: 0.25rem;
            padding: 0.25rem;
            border-collapse: collapse;
        }
        body {
            display: flex;
            flex-direction: column;
            /*background-image: url("/images/background.jpg");*/
            background-image: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            background-size: cover;
            background-repeat: no-repeat;
            vertical-align: middle;
            background-attachment: fixed;
        }
        header {
            border: none;
            background-image: linear-gradient(to right, rgba(46, 46, 224, 0.7), rgba(0, 255, 255, 0.18));
            background-color: rgb(139, 69, 19);
            box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.18);
            padding: 1rem;
        }

        h1 {
            font-family: Raleway, serif;
            text-align: center;
            font-size: xx-large;
            color: white;
        }
        div.card {
            background-color: rgba(255, 255, 255, 0.9);
            box-shadow: 0 15px 30px -10px grey;
            place-items: center;
            font-size: medium;
            margin: 2rem;
            text-align: center;
        }

    </style>
</head>
<body>
<header class="heading">
    <h1>Add Schedule</h1>
</header>
<%--@elvariable id="flightSchedule" type="com.cognizant.airline_ticket_reservation_system.model.FlightSchedule"--%>
<div class=card>
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
    <form:errors path="arrivalTime"/>
    <br>
    <form:label path="departureTime">
        <spring:message code="label.flightSchedule.departureTime"/>
    </form:label>
    <form:input path="departureTime" type="time"/>
    <from:errors path="departureTime"/>
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
</div>
</body>
</html>
