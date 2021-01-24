<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>User Registration</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: white;
        }

        * {
            box-sizing: border-box;
        }

        .container {
            padding: 16px;
            background-color: white;
        }

        input, select {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        .sign {
            background-color: blue;
            color: white;
            padding: 16px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.9;
        }

        .sign :hover {
            opacity: 1;
        }

        .reset {
            background-color: blue;
            color: white;
            padding: 16px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.9;
        }

        .reset :hover {
            opacity: 1;
        }
    </style>
</head>
<body>
<h1>User Registration</h1>
<%--@elvariable id="userRegistration" type="com.cognizant.airline_ticket_reservation_system.model.UserRegistration"--%>
<form:form action="/user/user-registration" method="post" modelAttribute="userRegistration">
    <form:label path="name">
        <spring:message code="label.user.name"/>
    </form:label>
    <form:input path="name" placeholder="Enter Name"/>
    <form:errors path="name"/>
    <br>
    <form:label path="age">
        <spring:message code="label.user.age"/>
    </form:label>
    <form:input path="age" type="number" placeholder="Enter your age (>18)"/>
    <form:errors path="age"/>
    <br>
    <form:label path="gender">
        <spring:message code="label.user.gender"/>
    </form:label>
    <form:select path="gender" items="${ genders }"/>
    <br>
    <form:label path="email">
        <spring:message code="label.user.email"/>
    </form:label>
    <form:input path="email" placeholder="Enter Email"/>
    <form:errors path="email"/>
    <br>
    <form:label path="address">
        <spring:message code="label.user.address"/>
    </form:label>
    <form:input path="address" placeholder="Enter Address"/>
    <form:errors path="address"/>
    <br>
    <form:label path="phone">
        <spring:message code="label.user.phone"/>
    </form:label>
    <form:input path="phone" placeholder="Enter Phone Number"/>
    <form:errors path="phone"/>
    <br>
    <form:label path="password">
        <spring:message code="label.password"/>
    </form:label>
    <form:password path="password" placeholder="Enter Password"/>
    <form:errors path="password"/>
    <br>
    <form:label path="confirmPassword">
        <spring:message code="label.user.confirmPassword"/>
    </form:label>
    <form:password path="confirmPassword" placeholder="Re-enter Password"/>
    <form:errors path="confirmPassword"/>
    <c:if test="${ not empty errorMessage}">
        <span>${ errorMessage }</span>
    </c:if>
    <br>
    <form:label path="secretQuestion">
        <spring:message code="label.user.secretQuestion"/>
    </form:label>
    <form:select path="secretQuestion" items="${ secretQuestions }"/>
    <br>
    <form:label path="answer">
        <spring:message code="label.user.answer"/>
    </form:label>
    <form:input path="answer" placeholder="Answer of the secret question"/>
    <input:errors path="answer"/>
    <br>
    <input type="submit" value="Sign Up" class="sign">
    <input type="reset" value="Reset" class="reset">
</form:form>
</body>
</html>
