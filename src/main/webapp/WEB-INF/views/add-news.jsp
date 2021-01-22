<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Add News</title>
</head>
<body>
<header>
    <h1>Add News</h1>
</header>
<%--@elvariable id="newsFeed" type="com.cognizant.airline_ticket_reservation_system.model.NewsFeed"--%>
<form:form action="/add-news" method="post" modelAttribute="newsFeed">
    <form:label path="date">
        <spring:message code="label.newsFeed.date"/>
    </form:label>
    <form:input type="date" path="date"/>
    <form:errors path="date"/>
    <br>
    <form:label path="news">
        <spring:message code="label.newsFeed.news"/>
    </form:label>
    <form:input path="news"/>
    <form:errors path="news"/>
    <br>
    <input type="submit" value="Add">
    <input type="reset" value="Reset">
</form:form>
</body>
</html>
