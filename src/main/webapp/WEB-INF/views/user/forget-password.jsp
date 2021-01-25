<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Forget Password</title>
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

        .buttons-container {
            width: 100%;
            display: flex;
            justify-content: space-evenly;
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

        .reset-btn {
            font-size: large;
            margin: 1rem 0;
            padding: 0.5rem 1rem;
            background-color: forestgreen;
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

        table * {
            margin: 0.25rem;
            padding: 0.25rem;
            color: darkslategrey;
            text-align: center;
        }

        table caption {
            font-size: x-large;
            font-weight: bold;
            padding-bottom: 1rem;
        }

        table tr, th, td {
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

        form * {
            display: block;
            padding: 0.25rem;
            margin: 0.25rem;
        }

        form label, .label {
            font-weight: bold;
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
    </style>
</head>
<body>
<header>
    <h1>Forget Password</h1>
</header>
<nav>
    <a href="<c:url value="/user/user-login"/>">Back</a>
</nav>
<div class="content">
    <div class="card">
        <div class="container">
            <%--@elvariable id="userForgetPassword" type="com.cognizant.airline_ticket_reservation_system.model.UserForgetPassword"--%>
            <form:form action="/user/forget-password" method="post" modelAttribute="userForgetPassword">
                <form:label path="id">
                    <spring:message code="label.user.id"/>
                </form:label>
                <form:input path="id" placeholder="Enter User Id"/>
                <form:errors path="id"/>
                <br>
                <form:label path="secretQuestion">
                    <spring:message code="label.user.secretQuestion"/>
                </form:label>
                <form:select path="secretQuestion" items="${ secretQuestions }"/>
                <form:errors path="secretQuestion"/>
                <br>
                <form:label path="answer">
                    <spring:message code="label.user.answer"/>
                </form:label>
                <form:input path="answer" placeholder="Answer of the secret quetion"/>
                <form:errors path="answer"/>
                <br>
                <from:label path="email">
                    <spring:message code="label.user.email"/>
                </from:label>
                <form:input path="email" placeholder="Enter Email"/>
                <form:errors path="email"/>
                <br>
                <form:label path="phone">
                    <spring:message code="label.user.phone"/>
                </form:label>
                <form:input path="phone" placeholder="Enter Phone Number"/>
                <form:errors path="phone"/>
                <br>
                <form:label path="newPassword">
                    <spring:message code="label.userChangePassword.newPassword"/>
                </form:label>
                <form:password path="newPassword" placeholder="Enter New Password"/>
                <form:errors path="newPassword"/>
                <br>
                <form:label path="confirmPassword">
                    <spring:message code="label.userChangePassword.confirmPassword"/>
                </form:label>
                <form:password path="confirmPassword" placeholder="Re-enter Password"/>
                <form:errors path="confirmPassword"/>
                <br>
                <input type="submit" value="Submit" class="submit-btn">
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
