<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Manage Flight</title>
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
<c:if test="${ not empty param.msg }">
    <script>
        alert('${ param.msg }');
    </script>
</c:if>
<h1>
    Manage Flight
</h1>
<nav>
    <a href="<c:url value="/add-flight"/>">Add Flight</a>
</nav>
<c:choose>
    <c:when test="${ not empty flights }">
        <table>
            <thead>
            <tr>
                <th>NO</th>
                <th>Airline</th>
                <th>Model</th>
                <th>Type</th>
                <th>Economy Seats</th>
                <th>Business Seats</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="flight" items="${ flights }">
                <tr>
                    <td>${ flight.no }</td>
                    <td>${ flight.airline }</td>
                    <td>${ flight.model }</td>
                    <td>${ flight.type }</td>
                    <td>${ flight.seatsEconomy }</td>
                    <td>${ flight.seatsBusiness }</td>
                    <td>
                        <a href="<c:url value="/update-flight?no=${ flight.no }"/>">Update</a>
                        <a href="<c:url value="/delete-flight?no=${ flight.no }"/>">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <p>Not flights available</p>
    </c:otherwise>
</c:choose>
</body>
</html>