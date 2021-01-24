<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h1>User Profile</h1>
<table>
    <tbody>
    <tr>
        <td>ID</td>
        <td>${ sessionScope.user.id }</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${ sessionScope.user.name }</td>
    </tr>
    <tr>
        <td>Age</td>
        <td>${ sessionScope.user.age }</td>
    </tr>
    <tr>
        <td>Gender</td>
        <td>${ sessionScope.user.gender }</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${ sessionScope.user.email }</td>
    </tr>
    <tr>
        <td>Address</td>
        <td>${ sessionScope.user.address }</td>
    </tr>
    <tr>
        <td>Phone No</td>
        <td>${ sessionScope.user.phone }</td>
    </tr>
    </tbody>
</table>
<a href="<c:url value="/update-details"/>">
    <button>Update Details</button>
</a>
<a href="<c:url value="/change-password"/>">
    <button>Change Password</button>
</a>
</body>
</html>
