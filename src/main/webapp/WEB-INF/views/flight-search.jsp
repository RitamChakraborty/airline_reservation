<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Flight Search</title>
</head>
<body>
<form:form action="/flight-search" method="post" modelAttribute="flightSearch">
    <form:label path="date">
        <spring:message code="label.flightSearch.date"/>
    </form:label>
    <form:input path="date" type="date"/>
    <form:errors path="date"/>
    <br>
    <form:label path="source">
        <spring:message code="label.flightSearch.source"/>
    </form:label>
    <form:select path="source" items="${ sources }"/>
    <br>
    <form:label path="destination">
        <spring:message code="label.flightSearch.destination"/>
    </form:label>
    <form:select path="destination" items="${ destinations }"/>
    <br>
    <input type="submit" value="Search">
    <input type="reset" value="Reset">
</form:form>
</body>
</html>
