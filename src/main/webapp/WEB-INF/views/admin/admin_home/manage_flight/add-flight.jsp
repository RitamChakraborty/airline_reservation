<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Flight</title>
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

        .container {
            width: 50vw;
        }

        form * {
            display: block;
            padding: 0.25rem;
            margin: 0.25rem;
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
            background-color: forestgreen;
            border: none;
            outline: none;
            color: white;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<header>
    <h1>
        Add Flight
    </h1>
</header>
<nav>
    <a href="<c:url value="/admin/admin-home/manage-flight"/>">Manage Flight</a>
</nav>
<%--@elvariable id="flight" type="com.cognizant.airline_ticket_reservation_system.model.Flight"--%>
<div class="content">
    <div class="card">
        <div class="container">
            <form:form action="/admin/admin-home/manage-flight/add-flight" method="post" modelAttribute="flight">
                <form:label path="airline" class="one">
                    <spring:message code="label.flight.airline"/>
                </form:label>
                <form:select path="airline" items="${ airlines }"/>
                <br>
                <form:label path="model" class="one">
                    <spring:message code="label.flight.model"/>
                </form:label>
                <form:select path="model" items="${ models }"/>
                <br>
                <form:label path="type" class="one">
                    <spring:message code="label.flight.type"/>
                </form:label>
                <form:select path="type" items="${ types }"/>
                <br>
                <form:label path="economySeats">
                    <spring:message code="label.flight.economySeats"/>
                </form:label>
                <form:input path="economySeats" type="number" pattern="^\d+$"
                            placeholder="Enter business seats number"/>
                <form:errors path="economySeats"/>
                <br>
                <form:label path="businessSeats">
                    <spring:message code="label.flight.businessSeats"/>
                </form:label>
                <form:input path="businessSeats" type="number" pattern="^\d+$"
                            placeholder="Enter economyl seats number"/>
                <form:errors path="businessSeats"/>
                <br>
                <input type="submit" value="Add Flight" class="submit-btn">
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
