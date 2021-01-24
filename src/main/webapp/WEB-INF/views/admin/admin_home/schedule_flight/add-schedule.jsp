<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Schedule</title>
    <style>
        * {
            box-sizing: border-box;
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

        input[type=text], select {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }

        input[type=time], input {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;

        }

        input[type=checkbox] {
            width: auto
        }

        label.one {
            padding: 12px 12px 12px 0;
            display: inline-block;
        }

        input[type=submit] {
            background-color: dodgerblue;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;

        }

        input[type=submit]:hover {
            background-color: dodgerblue;
        }


        input[type=reset] {
            background-color: green;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=reset]:hover {
            background-color: green;
        }

        div.card {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
            margin: auto;
        }

        .col-1 {
            float: left;
            width: 25%;
            margin-top: 6px;
        }

        .col-2 {
            float: left;
            width: 75%;
            margin-top: 6px;
        }

        .col-3 {
            float: left;
            margin: 5px 0px;
            width: 75%;

        }

        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        .submit-buttons-container {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
        }

        .submit-buttons-container input {
            margin: 0 3.5rem;
        }


    </style>
</head>
<body>
<header class="heading">
    <h1>Add Schedule</h1>
</header>
<br>
<br>
<br>
<br>
<%--@elvariable id="flightSchedule" type="com.cognizant.airline_ticket_reservation_system.model.FlightSchedule"--%>
<div class="card">
    <c:url var="actionUrl" value="/admin/admin-home/schedule-flight/add-schedule">
        <c:param name="no" value="${ param.no }"/>
    </c:url>
    <form:form action="${ actionUrl }" method="post" modelAttribute="flightSchedule">
        <div class="row">
            <div class="col-1">
                <form:label path="flightNo" class="one">
                    <spring:message code="label.flightSchedule.flightNo"/>
                </form:label>
            </div>
            <div class="col-2">
                <p>${ param.no }</p>
            </div>
        </div>
        <div class="row">
            <div class="col-1">
                <spring:message code="label.flightSchedule.flight"/>
            </div>
            <div class="col-2">
                <span>${ flight }</span>
            </div>
        </div>
        <div class="row">
            <div class="col-1">
                <form:label path="source" class="one">
                    <spring:message code="label.flightSchedule.source"/>
                </form:label>
            </div>
            <div class="col-2">
                <form:select path="source" items="${ sources }"/>
            </div>
        </div>
        <div class="row">
            <div class="col-1">
                <form:label path="destination" class="one">
                    <spring:message code="label.flightSchedule.destination"/>
                </form:label>
            </div>
            <div class="col-2">
                <form:select path="destination" items="${ destinations }"/>
            </div>
        </div>
        <div class="row">
            <div class="col-1">
                <form:label path="cost" class="one">
                    <spring:message code="label.flightSchedule.cost"/>
                </form:label>
            </div>
            <div class="col-2">
                <form:input path="cost" type="number"/>
                <form:errors path="cost"/>
            </div>
        </div>
        <div class="row">
            <div class="col-1">
                <form:label path="arrivalTime" class="one">
                    <spring:message code="label.flightSchedule.arrivalTime"/>
                </form:label>
            </div>
            <div class="col-2">
                <form:input path="arrivalTime" type="time"/>
                <form:errors path="arrivalTime"/>
            </div>
        </div>
        <div class="row">
            <div class="col-1">
                <form:label path="departureTime" class="one">
                    <spring:message code="label.flightSchedule.departureTime"/>
                </form:label>
            </div>
            <div class="col-2">
                <form:input path="departureTime" type="time"/>
                <from:errors path="departureTime"/>
            </div>
        </div>
        <div class="row">
            <div class="col-1">
                <form:label path="sun">
                    <spring:message code="label.flightSchedule.sun"/>
                </form:label>
            </div>
            <div class="col-3">
                <form:checkbox path="sun"/>
            </div>
        </div>
        <div class="row">
            <div class="col-1">
                <form:label path="mon">
                    <spring:message code="label.flightSchedule.mon"/>
                </form:label>
            </div>
            <div class="col-3">
                <form:checkbox path="mon"/>
            </div>
        </div>
        <div class="row">
            <div class="col-1">
                <form:label path="tue">
                    <spring:message code="label.flightSchedule.tue"/>
                </form:label>
            </div>
            <div class="col-3">
                <form:checkbox path="tue"/>
            </div>
        </div>
        <div class="row">
            <div class="col-1">
                <form:label path="wed">
                    <spring:message code="label.flightSchedule.wed"/>
                </form:label>
            </div>
            <div class="col-3">
                <form:checkbox path="wed"/>
            </div>
        </div>
        <div class="row">
            <div class="col-1">
                <form:label path="thu">
                    <spring:message code="label.flightSchedule.thu"/>
                </form:label>
            </div>
            <div class="col-3">
                <form:checkbox path="thu"/>
            </div>
        </div>
        <div class="row">
            <div class="col-1">
                <form:label path="fri">
                    <spring:message code="label.flightSchedule.fri"/>
                </form:label>
            </div>
            <div class="col-3">
                <form:checkbox path="fri"/>
            </div>
        </div>
        <div class="row">
            <div class="col-1">
                <form:label path="sat">
                    <spring:message code="label.flightSchedule.sat"/>
                </form:label>
            </div>
            <div class="col-3">
                <form:checkbox path="sat"/>
            </div>
        </div>
        <br>
        <div class="submit-buttons-container">
            <input type="submit" value="Schedule">
            <input type="reset" value="Reset">
        </div>
    </form:form>
</div>
</body>
</html>
