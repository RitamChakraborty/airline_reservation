<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>User Home</title>
</head>
<body>
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
        *{
    margin: 0.25rem;
    padding: 0.25rem;
    border-collapse: collapse;
    font-size: large;
}  
h2 {
            font-family: Raleway, serif;
            text-align: center;
            font-size: xx-large;
            color: white;
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
<c:if test="${ not empty param.msg}">
    <script>
        alert('${ param.msg }');
    </script>
</c:if>
<header>
    <h2>Welcome ${ user.name }</h2>
</header>
<nav>
    <ul>
        <li>
            <a href="<c:url value="/"/>">Home</a>
        </li>
        <li>
            <a href="<c:url value="/book-ticket"/>">Book Ticket</a>
        </li>
        <li>
            <a href="<c:url value="/history"/>">History</a>
        </li>
        <li>
            <a href="<c:url value="/view-profile?id=${ user.id }"/>">View Profile</a>
        </li>
        <li>
            <li style="float:right"><a href="<c:url value="/"/>">Logout</a>
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
