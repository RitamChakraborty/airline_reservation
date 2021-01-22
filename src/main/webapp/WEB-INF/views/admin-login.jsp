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
    <title>Admin Home</title>
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
            /*background-image: url("/images/background.jpg");*/
            background-image: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            background-size: cover;
            background-repeat: no-repeat;
            vertical-align: middle;
            background-attachment: fixed;
        }

        header {
            border: none;
            background-image: linear-gradient(to right, rgba(46, 46, 224, 0.7),
            rgba(0, 255, 255, 0.18));
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
            /*background-color: rgba(255, 255, 255, 0.9);*/
            padding: 2rem;
            border-radius: 10px;
            box-shadow: 0 15px 30px -10px grey;
            background-color: white;
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

        select, option {
            padding: 0.25rem;
            margin: 0;
            font-size: medium;
        }

        form label {
            padding-bottom: 0.5rem;
            color: darkslategrey;
            font-size: large;
        }

        input {
            border: none;
            outline: none;
            background-color: #dddddd;
            color: darkslategrey;
            padding: 0.5rem;
            text-align-last: center;
            border-radius: 4px;
        }

        .error-text {
            color: crimson;
            font-size: medium;
            font-family: monospace;
            padding: 0.25rem;
        }

        .global-error-text {
            padding: 0.5rem;
            font-family: monospace;
            color: red;
        }

        .submit-buttons-container {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
        }

        .submit-buttons-container input {
            margin: 0 0.25rem;
        }

        #submit-btn {
            background-color: dodgerblue;
            color: white;
        }

        #reset-btn {
            background-color: green;
            color: white;
        }
    </style>
</head>
<body>
<header>
    <h1>Admin Login</h1>
</header>
<%--@elvariable id="admin" type="com.cognizant.airline_ticket_reservation_system.model.Admin"--%>
<div id="form-container">
    <div class="form-card">
        <form:form action="/admin-login" method="post" modelAttribute="admin">
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
                    <p>
                        <%= request.getAttribute("errorMessage") %>
                    </p>
                </c:if>
            </div>
            <div class="submit-buttons-container">
                <input type="submit" value="Login" id="submit-btn">
                <input type="reset" value="Reset" id="reset-btn">
            </div>
        </form:form>
    </div>
</div>
</body>
</html>