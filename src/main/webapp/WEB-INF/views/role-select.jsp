<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width = device-width, initial-scale = 1">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<title>Airline Ticket Reservation system</title>


<style>
@import url('https://fonts.googleapis.com/css?family=Raleway');

$
color: #284cff ; html, body {
	height: 100%;
	width: 100;
}

h1 {
	font-family: Raleway;
	
	color: LightYellow;
	text-align: center;
}

.box {
	width: 120px;
	height: 30px;
	border: 1px solid #999;
	font-size: 18px;
	color: #1c87c9;
	background-color: #eee;
	border-radius: 5px;
	box-shadow: 3px 3px rgba(0, 0, 0, .15);
}

body {
	background-image: url("/images/6975522-supersonic-plane-wallpaper.jpg");
	background-size: cover;
	background-repeat: no-repeat;
	vertical-align: middle;
	background-attachment: fixed;
}

div.transbox1 {
	margin-left: 0px;
	margin-right: 0px;
	margin-top: 2px;
	margin-bottom: 0px;
	border: 1px solid rgba(255, 255, 255, 0.8);
	border-bottom-right-radius: 80px;
	border-left: 18px solid rgba(5, 0, 0, 0.8);
	background-image: linear-gradient(to right, rgba(25, 25, 112, 0.7),
		rgba(0, 255, 255, 0.18));
	background-color: rgb(rgb(139, 69, 19, 0.3));
	box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.18);
	border-collapse: separate;
	padding-top: 15px;
	padding-right: 45px;
	padding-bottom: 18px;
	padding-left: 45px;
}

#transbox2 {
	overflow: hidden;
	width: 18%;
	height: 25%;
	border-radius: 100px;
	box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.27);
	border-collapse: separate;
	padding-top: 45px;
	padding-right: 15px;
	padding-bottom: 65px;
	padding-left: 15px;
	background: inherit;
	position: absolute;
	margin: auto;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	text-align: center;
	margin-top: 300px;
}

#transbox2:before {
  width: 400px;
  height: 550px;
  content: "";
  position: absolute;
  top: -25px;
  left: -25px;
  bottom: 0;
  right: 0;
  background: inherit;
  box-shadow: inset 0 0 0 200px rgba(255,255,255,0.2);
  filter: blur(3px);
}

a:link {
	color: yellow;
	display: block;
}

.btn {
	display: inline-block;
	padding: 5px 10px;
	margin: 20px 0;
	border-radius: 15px;
	position: relative;
	color: #ecf0f1;
	position: relative;
}

#button-7 {
	-webkit-perspective: 50px;
	-moz-perspective: 50px;
	-ms-perspective: 50px;
	perspective: 50px;
	background-color: rgba(60, 100, 255);
	-webkit-transition: all 0.6s ease-in-out;
	-o-transition: all 0.6s ease-in-out;
	transition: all 0.6s ease-in-out;
}

form{
  text-align: center;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%,-50%);
}

#button-7:hover {
	-webkit-transform: rotateX(360deg);
	-ms-transform: rotateX(360deg);
	-o-transform: rotateX(360deg);
	transform: rotateX(360deg);
}
}
</style>
</head>
<body>
	<%--@elvariable id="roleSelection" type="com.cognizant.airline_ticket_reservation_system.model.RoleSelection"--%>
	<div class="transbox1">
		<h1>Airline Ticket Reservation System</h1>
	</div>

	<div id="transbox2">
		<form:form action="/login" method="get" modelAttribute="roleSelection">
			<form:label path="role">
				<br>
				<spring:message code="label.selectRole" />
			</form:label>
			<br>
			<br>
			<br>
			<form:select path="role" items="${ roles }" id="role" class="box">
			</form:select>
			<br>
			<br>
			<br>
			<button type="submit" class="btn" id="button-7">Select Role
				&amp; Submit</button>
		</form:form>
	</div>
</body>
</html>