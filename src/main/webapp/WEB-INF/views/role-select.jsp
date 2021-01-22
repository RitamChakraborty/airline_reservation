<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width = device-width, initial-scale = 1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Airline Ticket Reservation system</title>
    <link rel="stylesheet" href="/styles/styles.css">
    <style>
        @import url('https://fonts.googleapis.com/css?family=Raleway');

        * {
            margin: 0;
            padding: 0;
            font-size: large;
        }

        html, body {
            width: 100%;
        }

        body {
            display: flex;
            flex-direction: column;
            background-image: url("/images/background.jpg");
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

        #form-container {
            padding: 8rem;
            flex: 1 1 auto;
            display: grid;
            place-items: center;
        }

        .form-card {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 0 2rem;
            border-radius: 10px;
        }

        form {
            display: grid;
            place-items: center;
            font-size: medium;
        }

        form * {
            margin: 2rem;
            width: 100%;
            text-align: center;
        }

        select, option {
            padding: 0.25rem;
            margin: 0;
            font-size: medium;
        }

        select:after {
            padding: 0.25rem;
        }

        #role-message {
            font-size: xx-large;
            color: darkslategrey;
            font-weight: bold;
        }

        #role {
            border: none;
            outline: none;
            background-color: lightgrey;
            color: darkslategrey;
            padding: 0.5rem;
            text-align-last: center;
            border-radius: 4px;
        }

        #submit-btn {
            font-size: large;
            padding: 0.5rem 1rem;
            background-color: dodgerblue;
            border: none;
            outline: none;
            color: white;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<%--@elvariable id="roleSelection" type="com.cognizant.airline_ticket_reservation_system.model.RoleSelection"--%>
<header class="heading">
    <h1>Airline Ticket Reservation System</h1>
</header>
<div id="form-container">
    <div class="form-card">
        <form:form action="/login" method="get" modelAttribute="roleSelection">
            <form:label path="role" id="role-message">
                <spring:message code="label.selectRole"/>
            </form:label>
            <form:select path="role" items="${ roles }" id="role" class="box">
            </form:select>
            <button type="submit" id="submit-btn">Choose</button>
        </form:form>
    </div>
</div>
<div class="news-feed">
    News feed will be displayed here
</div>
</body>
</html>