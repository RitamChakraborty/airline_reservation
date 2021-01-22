<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add News</title>
</head>
<body>
<header>
    <h1>Add News</h1>
</header>
<%--@elvariable id="newsFeed" type="com.cognizant.airline_ticket_reservation_system.model.NewsFeed"--%>
<form:form action="/add-news?username=${ param.username }" method="post" modelAttribute="newsFeed">
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
<div>
    <h2>All News Feeds</h2>
    <c:choose>
        <c:when test="${ not empty newsFeeds }">
            <ol>
                <c:forEach var="newsFeed" items="${ newsFeeds }">
                    <li>
                        <p>News : ${ newsFeed.news }</p>
                        <p>Date : ${ newsFeed.date }</p>
                    </li>
                </c:forEach>
            </ol>
        </c:when>
        <c:otherwise>
            No news available
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
