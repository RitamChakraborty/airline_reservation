<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h1>User Profile</h1>
<p>User ID : ${ user.id }
</p>
<p>Name : ${ user.name }
</p>
<p>Email : ${ user.email }
</p>
<p>Address : ${ user.address }
</p>
<p>Phone No: ${ user.phone }
</p>
<a href="<c:url value="/update-details?id=${ user.id }"/>">
    <button>Update Details</button>
</a>
<a href="<c:url value="/change-password?id=${ user.id }"/>">
    <button>Change Password</button>
</a>
</body>
</html>
