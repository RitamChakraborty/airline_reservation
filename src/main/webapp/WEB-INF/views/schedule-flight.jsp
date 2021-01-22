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
        }

        table, tr, th, td {
            border: 1px solid lightgrey;
        }

    </style>
</head>
<body>
<h1>Schedule Flight</h1>
<a href="<c:url value="/add-schedule"/>">Add Schedule</a>
<c:choose>
    <c:when test="${ not empty flightSchedules }">
        <table>
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