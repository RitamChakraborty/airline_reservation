<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Details</title>
</head>
<body>
<h1>Update Details</h1>
<form action="<c:url value="/update-details?id=${ user.id }"/>" method="post">
    <label for="name">Name</label>
    <input type="text" id="name" name="name" value="${ user.name }" required>
    <br>
    <label for="email">Email</label>
    <input type="email" id="email" name="email" value="${ user.email }" required>
    <br>
    <label for="address">Address</label>
    <input type="text" name="address" id="address" cols="15" rows="5" value="${ user.address }" required>
    <br>
    <label for="phone">Phone No</label>
    <input type="tel" name="phone" id="phone" value="${ user.phone }" required>
    <br>
    <input type="submit" value="Update">
    <input type="reset" value="Reset">
</form>
</body>
</html>
