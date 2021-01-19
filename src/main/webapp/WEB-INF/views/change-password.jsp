<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Change Password</title>
</head>
<body>
<h1>Change Password</h1>
<%--@elvariable id="userChangePassword" type="com.cognizant.airline_ticket_reservation_system.model.UserChangePassword"--%>
<form:form action="/change-password?id=${ id }" method="post" modelAttribute="userChangePassword">
    <form:label path="previousPassword">
        <spring:message code="label.userChangePassword.previousPassword"/>
    </form:label>
    <form:password path="previousPassword"/>
    <form:errors path="previousPassword"/>
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
    <input type="submit" value="Change">
    <input type="reset" value="Reset">
</form:form>
</body>
</html>
