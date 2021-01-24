<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Update Details</title>
</head>
<body>
<h1>Update Details</h1>
<nav>
    <a href="<c:url value="/user/user-home"/>">Home</a>
</nav>
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
    <input type="submit" value="Update">
    <input type="reset" value="Reset">
</form:form>
</body>
</html>
