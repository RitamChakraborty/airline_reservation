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
    <h1>Welcome Admin</h1>
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