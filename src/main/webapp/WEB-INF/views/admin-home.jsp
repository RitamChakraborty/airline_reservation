<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Admin Home</title>
</head>
<body>
<header>
    <h1>Welcome Admin (${ param.username })</h1>
</header>
<nav>
    <ul>
        <li>
            <a href="<c:url value="/"/>">Home</a>
        </li>
        <li>
            <a href="<c:url value="/manage-flight"/>">Manage Flight</a>
        </li>
        <li>
            <a href="<c:url value="/schedule-flight"/>">Schedule Flight</a>
        </li>
        <li>
            <a href="<c:url value="/booking-details"/>">Booking Details</a>
        </li>
        <li>
            <a href="<c:url value="/user-details"/>">User Details</a>
        </li>
        <li>
            <a href="<c:url value="/add-news?username=${ param.username }"/>">Add News</a>
        </li>
        <li>
            <a href="<c:url value="/"/>">Logout</a>
        </li>
    </ul>
</nav>
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