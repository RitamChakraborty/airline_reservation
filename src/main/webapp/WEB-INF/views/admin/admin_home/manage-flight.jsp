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
            margin: 2rem 4rem 0 4rem;
            border-radius: 10px;
            box-shadow: 0 15px 30px -10px grey;
            width: min-content;
        }

        .submit-btn {
            font-size: large;
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
            background-color: tomato;
            border: none;
            outline: none;
            color: white;
            border-radius: 4px;
        }

        a {
            text-decoration: none;
        }

        .container {
            width: 90vw;
            display: grid;
            place-items: center;
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
<c:if test="${ not empty param.msg }">
    <script>
        alert('${ param.msg }');
    </script>
</c:if>
<header>
    <h1>
        Manage Flight
    </h1>
</header>
<nav>
    <a href="<c:url value="/admin/admin-home"/>" class="one">Home</a>
    <a href="<c:url value="/admin/admin-home/manage-flight/add-flight"/>" class="one">Add Flight</a>
    <a href="<c:url value="/admin/admin-home/schedule-flight"/>">Schedule Flight</a>
</nav>
<div class="content">
    <div class="card">
        <div class="container">
            <table>
                <c:choose>
                    <c:when test="${ not empty flights }">
                        <caption>All Flights</caption>
                        <thead>
                        <tr>
                            <th>NO</th>
                            <th>Airline</th>
                            <th>Model</th>
                            <th>Type</th>
                            <th>Economy Seats</th>
                            <th>Business Seats</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="flight" items="${ flights }">
                            <tr>
                                <td>${ flight.no }</td>
                                <td>${ flight.airline }</td>
                                <td>${ flight.model }</td>
                                <td>${ flight.type }</td>
                                <td>${ flight.economySeats }</td>
                                <td>${ flight.businessSeats }</td>
                                <td>
                                    <a href="<c:url value="/admin/admin-home/manage-flight/update-flight?no=${ flight.no }"/>"
                                       class="submit-btn">Update</a>
                                    <a href="<c:url value="/admin/admin-home/manage-flight/delete-flight?no=${ flight.no }"/>"
                                       class="reset-btn">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </c:when>
                    <c:otherwise>
                        <caption>Not flights available</caption>
                    </c:otherwise>
                </c:choose>
            </table>
        </div>
    </div>
</div>
<footer></footer>
</body>
</html>
