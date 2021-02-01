<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Booking Information</title>
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
            width: 25vw;
            display: grid;
            place-items: center;
        }

        table {
            width: 100%;
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

        .container-1 {
            display: flex;
            justify-content: space-evenly;
            align-items: center;
        }


        footer {
            margin-bottom: 2rem;
        }
    </style>
</head>
<body>
<header>
    <h1>Booking Information</h1>
</header>
<nav>
    <a href="<c:url value="/user/user-home"/>">Home</a>
    <a href="<c:url value="/user/user-home/history"/>">Back</a>
</nav>
<div class="content">
    <div class="container-1">
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
    </div>
    <div class="card">
        <div class="container">
            <table>
                <caption>Passengers Information</caption>
                <thread>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Gender</th>
                    </tr>
                </thread>
                <tbody>
                <c:forEach var="passenger" items="${ passengers }">
                    <tr>
                        <td>${ passenger.id }</td>
                        <td>${ passenger.name }</td>
                        <td>${ passenger.age }</td>
                        <td>${ passenger.gender }</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<footer></footer>
</body>
</html>
