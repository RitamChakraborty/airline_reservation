<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Survey</title>
</head>
<header>
    <h1>Create Survey</h1>
</header>
<nav>
    <a href="<c:url value="/admin/admin-home"/>">Home</a>
    <a href="<c:url value="/admin/admin-home/survey"/>">Back</a>
</nav>
<body>
<%-- Create a input for date --%>
<%-- Add a "Add Question" button --%>
<%-- Clicking on the button will add input for questions in the form --%>
<%-- Label for the question will be like Question 1, Question 2 and so on --%>
<%-- Restrict the admin from adding more than 10 questions --%>
<%-- If he/she tries, then show a an alert dialog --%>
</body>
</html>
