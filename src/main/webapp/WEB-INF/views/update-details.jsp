<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Update Details</title>
</head>
<body>
<c:if test="${ not empty noUpdateError}">
    <script>
        alert('${ noUpdateError }');
    </script>
</c:if>
<h1>Update Details</h1>
<%--@elvariable id="userDetailsUpdate" type="com.cognizant.airline_ticket_reservation_system.model.UserDetailsUpdate"--%>
<form:form action="/update-details?id=${ id }" method="post" modelAttribute="userDetailsUpdate">
    <form:label path="name">
        <spring:message code="label.user.name"/>
    </form:label>
    <form:input path="name" value="${ user.name }"/>
    <form:errors path="name"/>
    <br>
    <form:label path="email">
        <spring:message code="label.user.email"/>
    </form:label>
    <form:input path="email" value="${ user.email }"/>
    <form:errors path="email"/>
    <br>
    <form:label path="address">
        <spring:message code="label.user.address"/>
    </form:label>
    <form:input path="address" value="${ user.address }"/>
    <form:errors path="address"/>
    <br>
    <form:label path="phone">
        <spring:message code="label.user.phone"/>
    </form:label>
    <form:input path="phone" value="${ user.phone }"/>
    <form:errors path="phone"/>
    <br>
    <input type="submit" value="Update">
    <input type="reset" value="Reset">
</form:form>
</body>
</html>
