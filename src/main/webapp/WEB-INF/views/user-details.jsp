<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>User Details</title>
    <style>
        * {
            margin: 0.25rem;
            padding: 0.25rem;
            border-collapse: collapse;
        }

        table, tr, th, td {
            border: 1px solid lightgrey;
        }
    </style>
</head>
<body>
<h1>User Details</h1>
<c:choose>
    <c:when test="${ not empty userList}">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Phone No</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${ userList }">
                <tr>
                    <td>${ user.id }</td>
                    <td>${ user.name }</td>
                    <td>${ user.email }</td>
                    <td>${ user.address }</td>
                    <td>${ user.phone }</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        User List is empty!
    </c:otherwise>
</c:choose>
</body>
</html>