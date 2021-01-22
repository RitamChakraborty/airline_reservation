<%@ page import="com.cognizant.airline_ticket_reservation_system.model.FlightSchedule" %>
<%@ page import="java.util.StringJoiner" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Schedule Flight</title>
    <style>
        * {
            margin: 0.25rem;
            padding: 0.25rem;
            border-collapse: collapse;
            font-size: large;
        }
        body {
            display: flex;
            flex-direction: column;
            background-image: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            background-size: cover;
            background-repeat: no-repeat;
            vertical-align: middle;
            background-attachment: fixed;
        }
        header {
            border: none;
            background-image: linear-gradient(to right, rgba(46, 46, 224, 0.7),
            rgba(0, 255, 255, 0.48));
            background-color: rgb(0, 89, 19);
            box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.18);
            padding: 1rem;
        }

        h1 {
            font-family: Raleway, serif;
            text-align: center;
            font-size: xx-large;
            color: white;
        }
        #flight {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #flight td, #flight th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #flight tr:nth-child(even){
            background-color: #f2f2f2;
        }

        #flight tr:hover {
            background-color: #ddd;
        }

        #flight th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: midnightblue;
            color: white;
        }


        a.one:link, a.one:visited {
            background-color: white;
            color: black;
            border: 2px solid green;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }

        a.one:hover, a.one:active {
            background-color: green;
            color: white;
        }

    </style>
</head>
<body>
<header>
    <h1>Schedule Flight</h1>
</header>

<nav>
    <a href="<c:url value="/add-schedule"/>" class="one">Add Flight</a>
</nav>

<c:choose>
    <c:when test="${ not empty flightSchedules }">
        <%!
            int index = 0;
        %>
        <table id="flight">
            <thead>
            <tr>
                <th>Flight ID</th>
                <th>Flight No</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Arrival Time</th>
                <th>Departure Time</th>
                <th>Dates</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="flightSchedule" items="${ flightSchedules }">
                <tr>
                    <td>${ flightSchedule.id }</td>
                    <td>${ flightSchedule.flightNo }</td>
                    <td>${ flightSchedule.source }</td>
                    <td>${ flightSchedule.destination }</td>
                    <td>${ flightSchedule.arrivalTime }</td>
                    <td>${ flightSchedule.departureTime }</td>
                    <td>
                        <%
                            FlightSchedule flightSchedule = (FlightSchedule) pageContext.getAttribute("flightSchedule");
                            StringJoiner stringJoiner = new StringJoiner(", ");

                            if (flightSchedule.isSun()) {
                                stringJoiner.add("Sun");
                            }
                            if (flightSchedule.isMon()) {
                                stringJoiner.add("Mon");
                            }
                            if (flightSchedule.isThu()) {
                                stringJoiner.add("Tue");
                            }
                            if (flightSchedule.isWed()) {
                                stringJoiner.add("Wed");
                            }
                            if (flightSchedule.isThu()) {
                                stringJoiner.add("Thu");
                            }
                            if (flightSchedule.isFri()) {
                                stringJoiner.add("Fri");
                            }
                            if (flightSchedule.isSat()) {
                                stringJoiner.add("Sat");
                            }

                            out.print(stringJoiner.toString());
                        %>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <p>There is no flight being schedule</p>
    </c:otherwise>
</c:choose>
</body>
</html>