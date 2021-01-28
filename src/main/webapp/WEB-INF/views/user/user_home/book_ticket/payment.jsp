<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Payment</title>
</head>
<body>
<header>
    <h1>Payment</h1>
</header>
<nav>
    <a href="<c:url value="/user/user-home/book-ticket"/>">Cancel</a>
</nav>
<div class="content">
    <div class="card">
        <div class="container">
            <%--@elvariable id="bankAccount" type="com.cognizant.airline_ticket_reservation_system.model.BankAccount"--%>
            <form:form action="/user/user-home/book-ticket/payment" method="post" modelAttribute="bankAccount">
                <form:select path="bankName" items="${ banks }"/>
                <br>
                <form:input path="accountNo" type="number"/>
                <form:errors path="accountNo" cssClass="error-text"/>
                <br>
                <input type="submit" value="Proceed">
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
