<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Flight</title>
     <style>
         body {
            display: flex;
            flex-direction: column;
            background-image: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            background-size: cover;
            background-repeat: no-repeat;
            vertical-align: middle;
            background-attachment: fixed;
        }

        header {
            border: none;
            background-image: linear-gradient(to right, rgba(46, 46, 224, 0.7),rgba(0, 255, 255, 0.18));
            background-color: rgb(139, 69, 19);
            box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.18);
            padding: 1rem;
        }

        h1 {
            font-family: Raleway, serif;
            text-align: center;
            font-size: xx-large;
            color: white;
        }
  P { text-align: center }
         input[type=submit] {
          background-color: red;
          color: white;
          padding: 12px 20px;
          border: none;
          border-radius: 4px;
          cursor: pointer;
          
        }

        input[type=submit]:hover {
          background-color: red;
        }
         .container {
          border-radius: 5px;
          background-color: #f2f2f2;
          padding: 20px;
          margin: auto;
        }
         .submit-buttons-container {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
        }

        .submit-buttons-container input {
            margin: 0 3.5rem;
        }

    </style>
</head>
<body>
    <header>
<h1>Delete Flight</h1>
    </header>
    <br>
    <br>
    <br>
    <br>
    <div class="container">
<form:form action="/delete-flight?no=${ no }">
    <p>
        <spring:message code="label.flight.no"/>
        <span>: ${ flight.no }</span>
    </p>
    <p>
        <spring:message code="label.flight.airline"/>
        <span>: ${ flight.airline }</span>
    </p>
    <p>
        <spring:message code="label.flight.model"/>
        <span>: ${ flight.model }</span>
    </p>
    <p>
        <spring:message code="label.flight.type"/>
        <span>: ${ flight.type }</span>
    </p>
    <p>
        <spring:message code="label.flight.seatsEconomy"/>
        <span>: ${ flight.seatsEconomy }</span>
    </p>
    <p>
        <spring:message code="label.flight.seatsBusiness"/>
        <span>: ${ flight.seatsBusiness }</span>
    </p>
    <div class="submit-buttons-container">
    <input type="submit" value="Delete">
    </div>
</form:form>
    </div>
</body>
</html>
