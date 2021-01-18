<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h1>User Profile</h1>
<p>User ID : <%=request.getParameter("id")%>
</p>
<p>Name : <%=request.getParameter("name")%>
</p>
<p>Email : <%=request.getParameter("email")%>
</p>
<p>Address : <%=request.getParameter("address")%>
</p>
<p>Phone No: <%=request.getParameter("phone")%>
</p>
<a href="<c:url value="/update-details"/>">
    <button>Update Details</button>
</a>
<a href="<c:url value="/change-password"/>">
    <button>Change Password</button>
</a>
</body>
</html>
