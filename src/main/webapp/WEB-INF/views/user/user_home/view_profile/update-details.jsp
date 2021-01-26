<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Update Details</title>
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
            width: 50vw;
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
    <h1>Update Details</h1>
</header>
<nav>
    <a href="<c:url value="/user/user-home"/>">Home</a>
</nav>
<div class="content">
    <div class="card">
        <div class="container">
            <%--@elvariable id="userDetailsUpdate" type="com.cognizant.airline_ticket_reservation_system.model.User"--%>
            <form:form action="/user/user-home/view-profile/update-details" method="post" modelAttribute="user">
                <form:label path="name">
                    <spring:message code="label.user.name"/>
                </form:label>
                <form:input path="name" value="${ sessionScope.user.name }"/>
                <form:errors path="name"/>
                <br>
                <form:label path="age">
                    <spring:message code="label.user.age"/>
                </form:label>
                <form:input path="age" type="number" value="${ sessionScope.user.age }"/>
                <form:errors path="age"/>
                <br>
                <form:label path="gender">
                    <spring:message code="label.user.gender"/>
                </form:label>
                <form:select path="gender">
                    <c:forEach var="gender" items="${ genders }">
                        <c:choose>
                            <c:when test="${ gender eq sessionScope.user.gender }">
                                <form:option value="${ gender }" selected="true"/>
                            </c:when>
                            <c:otherwise>
                                <form:option value="${ gender }"/>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
                <br>
                <form:label path="email">
                    <spring:message code="label.user.email"/>
                </form:label>
                <form:input path="email" value="${ sessionScope.user.email }"/>
                <form:errors path="email"/>
                <br>
                <form:label path="address">
                    <spring:message code="label.user.address"/>
                </form:label>
                <form:input path="address" value="${ sessionScope.user.address }"/>
                <form:errors path="address"/>
                <br>
                <form:label path="phone">
                    <spring:message code="label.user.phone"/>
                </form:label>
                <form:input path="phone" value="${ sessionScope.user.phone }"/>
                <form:errors path="phone"/>
                <br>
                <p>${ message }</p>
                <input type="submit" value="Update" class="submit-btn">
            </form:form>
        </div>
    </div>
</div>
</body>
</html>