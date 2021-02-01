<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Flight</title>
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


        footer {
            margin-bottom: 2rem;
        }
    </style>
</head>
<body>
<header>
    <h1>Update Flight</h1>
</header>
<nav>
    <a href="<c:url value="/admin/admin-home"/>">Home</a>
    <a href="<c:url value="/admin/admin-home/manage-flight"/>">Back</a>
</nav>
<div class="content">
    <div class="card">
        <div class="container">
            <%--@elvariable id="flight" type="com.cognizant.airline_ticket_reservation_system.model.Flight"--%>
            <form:form action="/admin/admin-home/manage-flight/update-flight?no=${ param.no }" method="post"
                       modelAttribute="flight">
                <div class="box">
                    <form:label path="airline" class="one">
                        <spring:message code="label.flight.airline"/>
                    </form:label>
                    <form:select path="airline" items="${ airlines }" value="${ flight.airline }"/>
                </div>
                <div class="grid">
                    <div class="box">
                        <form:label path="model" class="one">
                            <spring:message code="label.flight.model"/>
                        </form:label>
                        <form:select path="model" items="${ models }" value="${ flight.model }"/>
                    </div>
                    <div class="box">
                        <form:label path="type" class="one">
                            <spring:message code="label.flight.type"/>
                        </form:label>
                        <form:select path="type" items="${ types }" value="${ flight.type }"/>
                    </div>
                    <div class="box">
                        <form:label path="economySeats">
                            <spring:message code="label.flight.economySeats"/>
                        </form:label>
                        <form:input path="economySeats" value="${ flight.economySeats }"/>
                        <form:errors path="economySeats"/>
                    </div>
                    <div class="box">
                        <form:label path="businessSeats">
                            <spring:message code="label.flight.businessSeats"/>
                        </form:label>
                        <form:input path="businessSeats" value="${ flight.businessSeats }"/>
                        <form:errors path="businessSeats"/>
                    </div>
                </div>
                <input type="submit" value="Update" class="submit-btn">
            </form:form>
        </div>
    </div>
</div>
<footer></footer>
</body>
</html>
