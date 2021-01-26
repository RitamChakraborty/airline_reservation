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
            place-items: center;
            display: flex;
            flex-direction: column;
        }

        .content {
            flex: 2;
            display: flex;
            height: max-content;
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
            width: 25vw;
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

        input, select, option {
            padding: 0.25rem;
            margin: 0;
            font-size: medium;
            border: none;
            outline: none;
            background-color: #dddddd;
            color: darkslategrey;
            padding: 0.5rem;
            text-align-last: center;
            border-radius: 4px;
        }

        label {
            font-size: x-large;
            color: darkslategrey;
            font-weight: bold;
        }
    </style>
</head>
<body>
<%--@elvariable id="roleSelection" type="com.cognizant.airline_ticket_reservation_system.model.RoleSelection"--%>
<header>
    <h1>Airline Ticket Reservation System</h1>
</header>
<div class="content">
    <div class="card">
        <div class="container">
            <form:form action="/login" method="get" modelAttribute="roleSelection">
                <form:label path="role">
                    <spring:message code="label.selectRole"/>
                </form:label>
                <form:select path="role" items="${ roles }" class="box"/>
                <button type="submit" class="submit-btn">Choose</button>
            </form:form>
        </div>
    </div>
    <div class="card">
        <div class="news-feed">
            <table>
                <c:choose>
                    <c:when test="${ not empty newsFeeds }">
                        <caption>News Feed</caption>
                        <c:forEach var="newsFeed" items="${ newsFeeds }">
                            <tr>
                                <td>${ newsFeed.news }</td>
                                <td>${ newsFeed.date }</td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <caption>No news available</caption>
                    </c:otherwise>
                </c:choose>
            </table>
        </div>
    </div>
</div>
</body>
</html>