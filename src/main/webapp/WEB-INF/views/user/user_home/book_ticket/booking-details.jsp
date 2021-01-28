<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Booking Details</title>
</head>
<body>
<header>
    <h1>Booking Details</h1>
</header>
<nav>
    <a href="<c:url value="/user/user-home/book-ticket"/>">Cancel</a>
</nav>
<div class="content">
    <div class="card">
        <div class="container">

        </div>
    </div>
    <a href="<c:url value="/user/user-home/book-ticket/payment"/>">
        <button>Pay</button>
    </a>
</div>
</body>
</html>
