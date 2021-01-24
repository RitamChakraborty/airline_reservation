<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Admin Login</title>
    <%--    <link rel="stylesheet" href="/static/styles/styles.css">--%>
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
            background-color: forestgreen;
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

        .news-feed td {
            padding: 1rem;
            background-color: #dddddd;
        }

        form * {
            padding: 0.5rem;
            display: block;
            color: darkslategrey;
            text-align: center;
        }

        label {
            font-size: large;
            text-align: center;
            font-weight: bold;
        }

        .error-text {
            font-family: monospace;
            color: tomato;
        }

        input, select {
            border: none;
            outline: none;
            background-color: #dddddd;
            border-radius: 4px;
        }

        input:focus, select:focus {
            outline: none;
        }

        .buttons-container {
            display: flex;
            justify-content: space-evenly;
        }
    </style>
</head>
<body>
<header>
    <h1>Admin Login</h1>
</header>
<%--@elvariable id="admin" type="com.cognizant.airline_ticket_reservation_system.model.Admin"--%>
<div class="content">
    <div class="card">
        <form:form action="/admin/admin-login" method="post" modelAttribute="admin">
            <form:label path="username">
                <spring:message code="label.username"/>
            </form:label>
            <form:input path="username" id="username" placeholder="Enter username"/>
            <form:errors path="username" cssClass="error-text"/>
            <br>
            <form:label path="password">
                <spring:message code="label.password"/>
            </form:label>
            <form:password path="password" id="password" placeholder="Enter password"/>
            <form:errors path="password" cssClass="error-text"/>
            <div class="global-error-text">
                <c:if test="${ not empty errorMessage }">
                    <p class="error-text">
                        <%= request.getAttribute("errorMessage") %>
                    </p>
                </c:if>
            </div>
            <div class="buttons-container">
                <input type="submit" value="Login" class="submit-btn">
            </div>
        </form:form>
    </div>
</div>
</body>
</html>