<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Forget Password</title>
</head>
<body>
<h1>Forget Password</h1>
<%--@elvariable id="userForgetPassword" type="com.cognizant.airline_ticket_reservation_system.model.UserForgetPassword"--%>
<form:form action="/forget-password" method="post" modelAttribute="userForgetPassword">
    <form:label path="id">
        <spring:message code="label.user.id"/>
    </form:label>
    <form:input path="id"/>
    <form:errors path="id"/>
    <br>
    <from:label path="email">
        <spring:message code="label.user.email"/>
    </from:label>
    <form:input path="email"/>
    <form:errors path="email"/>
    <br>
    <form:label path="phone">
        <spring:message code="label.user.phone"/>
    </form:label>
    <form:input path="phone"/>
    <form:errors path="phone"/>
    <br>
    <form:label path="newPassword">
        <spring:message code="label.userChangePassword.newPassword"/>
    </form:label>
    <form:password path="newPassword"/>
    <form:errors path="newPassword"/>
    <br>
    <form:label path="confirmPassword">
        <spring:message code="label.userChangePassword.confirmPassword"/>
    </form:label>
    <form:password path="confirmPassword"/>
    <form:errors path="confirmPassword"/>
    <br>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form:form>
</body>
</html>
