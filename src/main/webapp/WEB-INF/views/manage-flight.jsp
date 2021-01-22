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
            background-image: linear-gradient(to right, rgba(46, 46, 224, 0.7),rgba(0, 255, 255, 0.18));
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
        a.two:link, a.two:visited {
            background-color: white;
            color: black;
            border: 2px solid dodgerblue;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }

        a.two:hover, a.two:active {
            background-color: dodgerblue;
            color: white;
        }
        a.three:link, a.three:visited {
            background-color: white;
            color: black;
            border: 2px solid red;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }

        a.three:hover, a.three:active {
            background-color: red;
            color: white;
        }

        * {
            margin: 0.25rem;
            padding: 0.25rem;
            border-collapse: collapse;
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
    <a href="<c:url value="/add-flight"/>" class="one">Add Flight</a>
</nav>
<c:choose>
    <c:when test="${ not empty flights }">
        <table id="flight">
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
                        <a href="<c:url value="/update-flight?no=${ flight.no }"/>" class="two">Update</a>
                        <a href="<c:url value="/delete-flight?no=${ flight.no }"/>" class="three">Delete</a>
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