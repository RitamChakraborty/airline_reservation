<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Add Flight</title>
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

        * {
            box-sizing: border-box;
        }

        input[type=text], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
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

        .container {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
            margin: auto;
        }

        .col-25 {
            float: left;
            width: 25%;
            margin-top: 6px;
        }

        .col-75 {
            float: left;
            width: 75%;
            margin-top: 6px;
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
            margin: 0 2rem;
        }


    </style>
</head>
<body>
<header>
    <h1>
        Add Flight
    </h1>
</header>
<%--@elvariable id="flight" type="com.cognizant.airline_ticket_reservation_system.model.Flight"--%>
<br>
<br>
<br>
<br>
<div class="container">
    <form:form action="/admin/add-flight" method="post" modelAttribute="flight">
        <div class="row">
            <div class="col-25">
                <form:label path="airline" class="one">
                <spring:message code="label.flight.airline"/>
            </div>
            <div class="col-75">
                </form:label>
                <form:select path="airline" items="${ airlines }"/>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <form:label path="model" class="one">
                <spring:message code="label.flight.model"/>
            </div>
            <div class="col-75">
                </form:label>
                <form:select path="model" items="${ models }"/>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <form:label path="type" class="one">
                <spring:message code="label.flight.type"/>
            </div>
            <div class="col-75">
                </form:label>
                <form:select path="type" items="${ types }"/>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <form:label path="economySeats">
                <spring:message code="label.flight.economySeats"/>
            </div>
            <div class="col-75">
                </form:label>
                <form:input path="economySeats" type="number" pattern="^\d+$"/>
                <form:errors path="economySeats"/>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <form:label path="businessSeats">
                <spring:message code="label.flight.businessSeats"/>
            </div>
            <div class="col-75">
                </form:label>
                <form:input path="businessSeats" type="number" pattern="^\d+$"/>
                <form:errors path="businessSeats"/>
            </div>
        </div>
        <br>
        <div class="submit-buttons-container">
            <input type="submit" value="Add Flight">
            <input type="reset" value="Reset">
        </div>
    </form:form>
</div>
</body>
</html>
