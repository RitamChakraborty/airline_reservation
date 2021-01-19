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
            <a href="<c:url value="/view-profile?id=${ user.id }"/>">View
                Profile</a>
        </li>
        <li>
            <button class="logout">Logout</button>
        </li>
    </ul>
</nav>
<article>
    <div class="news-feed">
        News feed will be displayed here
    </div>
</article>
</body>
</html>