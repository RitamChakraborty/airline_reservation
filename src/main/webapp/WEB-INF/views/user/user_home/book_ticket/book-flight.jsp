<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book Flight</title>
</head>
<body>
<header>
    <h1>Book Flight</h1>
</header>
<nav>
    <a href="<c:url value="/user/user-home/book-ticket"/>">Back</a>
</nav>
<div class="content">
    <div class="card">
        <div class="container">
            ${ sessionScope.flightSchedule }
            <a href="<c:url value="/user/user-home/book-ticket/payment"/>">
                <button class="submit-btn">Pay</button>
            </a>
        </div>
    </div>
</div>
</body>
</html>
