<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Forget Password</title>

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

        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        .submit {
            background-color: blue;
            color: white;
            padding: 16px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.9;
        }

        .submit :hover {
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
<h1>Forget Password</h1>
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
    <input type="submit" value="Submit" class="submit">
    <input type="reset" value="Reset" class="reset">
</form:form>
</body>
</html>
