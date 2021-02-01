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
    <title>User Details</title>
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

        .submit-btn {
            font-size: large;
            margin: 1rem 0;
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

        a {
            text-decoration: none;
        }

        .container {
            width: 80vw;
            display: grid;
            place-items: center;
        }

        table * {
            margin: 0.25rem;
            padding: 0.25rem;
            color: darkslategrey;
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


        footer {
            margin-bottom: 2rem;
        }
    </style>
</head>
<body>
<header>
    <h1>User Details</h1>
</header>
<nav>
    <a href="<c:url value="/admin/admin-home"/>">Home</a>
</nav>
<div class="content">
    <div class="card">
        <div class="container">
            <table>
                <c:choose>
                    <c:when test="${ not empty userList}">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Gender</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>Phone No</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${ userList }">
                            <tr>
                                <td>${ user.id }</td>
                                <td>${ user.name }</td>
                                <td>${ user.age }</td>
                                <td>${ user.gender }</td>
                                <td>${ user.email }</td>
                                <td>${ user.address }</td>
                                <td>${ user.phone }</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </c:when>
                    <c:otherwise>
                        <caption>User List is empty!</caption>
                    </c:otherwise>
                </c:choose>
            </table>
        </div>
    </div>
</div>
<footer></footer>
</body>
</html>