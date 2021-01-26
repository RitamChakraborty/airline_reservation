<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ritam
  Date: 1/26/21
  Time: 6:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment Successful</title>
</head>
<body>
<div class="content">
    <div class="card">
        <div class="container">
            <h2>Payment is successful</h2>
            <a href="<c:url value="/user/user-home"/>">
                <button class="submit-btn">Home</button>
            </a>
        </div>
    </div>
</div>
</body>
</html>
