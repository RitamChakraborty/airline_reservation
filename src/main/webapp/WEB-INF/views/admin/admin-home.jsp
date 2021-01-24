<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Admin Home</title>
    <style>
        header {
            border: none;
            background-image: linear-gradient(to right, rgba(46, 46, 224, 0.7),
            rgba(0, 255, 255, 0.18));
            background-color: rgb(139, 69, 19);
            box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.18);
            padding: 1rem;
        }

        h1 {
            font-family: Raleway, serif;
            text-align: center;
            font-size: xx-large;
            color: white;
        }

        * {
            margin: 0.25rem;
            padding: 0.25rem;
            border-collapse: collapse;
            font-size: large;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }

        li {
            float: left;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover:not(.active) {
            background-color: #737373;
        }

        .active {
            background-color: #404040;
        }
    </style>
<body>
<%
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

    if (session.getAttribute("admin") == null) {
        response.sendRedirect("/logout");
    }
%>
<header>
    <h1>Welcome Admin (${ sessionScope.admin.username })</h1>
</header>
<nav>
    <ul>
        <li>
            <a href="<c:url value="/admin/admin-home/manage-flight"/>">Manage Flight</a>
        </li>
        <li>
            <a href="<c:url value="/admin/admin-home/schedule-flight"/>">Schedule Flight</a>
        </li>
        <li>
            <a href="<c:url value="/booking-details"/>">Booking Details</a>
        </li>
        <li>
            <a href="<c:url value="/user-details"/>">User Details</a>
        </li>
        <li>
            <a href="<c:url value="/add-news"/>">Add News</a>
        </li>
        <li>
        <li style="float:right"><a href="<c:url value="/logout"/>">Logout</a>
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
