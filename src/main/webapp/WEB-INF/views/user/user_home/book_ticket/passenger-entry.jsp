<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Passenger Entry</title>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Raleway');
        @import url('https://fonts.googleapis.com/css2?family=Montserrat&display=swap');

        * {
            margin: 0;
            padding: 0;
            border-collapse: collapse;
            font-family: 'Montserrat', sans-serif;
        }

        html, body {
            height: 100%;
            width: 100%;
            background-image: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            background-size: cover;
            background-repeat: no-repeat;
            vertical-align: middle;
            background-attachment: fixed;
            display: flex;
            flex-direction: column;
        }

        header {
            background-image: linear-gradient(to right, rgba(46, 46, 224, 0.7), rgba(0, 255, 255, 0.18));
            background-color: rgb(139, 69, 19);
            box-shadow: 0 15px 30px -10px grey;
            border-bottom-left-radius: 50px;
            border-bottom-right-radius: 50px;
            padding: 2rem;
            font-family: Raleway, serif;
            text-align: center;
            color: white;
            height: 7%;
            display: grid;
            place-items: center;
        }

        .content {
            flex: 2;
            display: flex;
            flex-direction: column;
            justify-content: space-evenly;
            align-items: center;
            color: darkslategrey;
        }

        .card {
            background-color: rgba(255, 255, 255, 0.7);
            padding: 2rem;
            margin: 1rem 4rem 0.5rem 4rem;
            border-radius: 10px;
            box-shadow: 0 15px 30px -10px grey;
            width: min-content;
        }

        nav {
            padding: 1rem;
            display: flex;
            flex-direction: row;
            justify-content: space-evenly;
            align-items: center;
            font-size: large;
        }

        nav a {
            display: inline;
            text-decoration: none;
            color: darkslategrey;
            font-weight: bold;
            padding: 1.5rem 1.5rem;
            border-radius: 10px;
        }

        nav a:hover {
            padding: 1.5rem 1.5rem;
            background-color: rgba(255, 255, 255, 0.7);
            box-shadow: 0 15px 30px -10px grey;
        }

        .submit-btn {
            font-size: large;
            margin: 1rem 2rem;
            padding: 0.5rem 1rem;
            background-color: dodgerblue;
            border: none;
            outline: none;
            color: white;
            border-radius: 4px;
        }

        .news-feed {
            width: 50vw;
        }

        .news-feed table {
            width: 100%;
        }

        .news-feed table caption {
            font-size: x-large;
            font-weight: bold;
            padding-bottom: 1rem;
        }

        .news-feed td:nth-child(even) {
            padding: 1rem;
            background-color: #eeeeee;
        }

        .container {
            width: 25vw;
        }

        form {
            display: grid;
            place-items: center;
            font-size: medium;
        }

        form * {
            width: 100%;
            text-align: center;
        }

        label {
            margin: 0.25rem 1rem 0.5rem 1rem;
            font-size: x-large;
            color: darkslategrey;
            font-weight: bold;
        }

        input, select, option {
            margin: 0.5rem 1rem;
            font-size: medium;
            border: none;
            outline: none;
            background-color: #dddddd;
            color: darkslategrey;
            padding: 0.5rem;
            text-align-last: center;
            border-radius: 4px;
        }

        .error-text {
            font-family: monospace;
            color: tomato;
        }


        footer {
            margin-bottom: 2rem;
        }
    </style>
</head>
<body>
<header>
    <h1>Enter passenger details</h1>
</header>
<nav>
    <a href="<c:url value="/user/user-home"/>">Home</a>
    <a href="<c:url value="/user/user-home/book-ticket"/>">Cancel</a>
</nav>
<div class="content">
    <c:forEach var="i" begin="1" end="${ totalPassenger }">
        <div class="card">
            <div class="container">
                <form id="passenger-${ i }">
                    <h2 style="color: steelblue; padding-bottom: 1rem;">Passenger ${ i }</h2>
                    <label for="passenger-${ i }.name">Name</label>
                    <input type="text" id="passenger-${ i }.name" name="passenger-${ i }.name"
                           placeholder="Enter passenger name" required>
                    <span id="error.passenger-${ i }.name" class="error-text"></span>
                    <br>
                    <label for="passenger-${ i }.age">Age</label>
                    <input type="number" name="passenger-${ i }.age" id="passenger-${ i }.age"
                           placeholder="Enter age"
                           value="1" min="0" max="120" required>
                    <span id="error.passenger-${ i }.age" class="error-text"></span>
                    <br>
                    <label for="passenger-${ i }.gender">Gender</label>
                    <select name="passenger-${ i }.gender" id="passenger-${ i }.gender">
                        <option value="Male" selected>Male</option>
                        <option value="Female">Female</option>
                    </select>
                </form>
            </div>
        </div>
    </c:forEach>
    <button id="next-btn" class="submit-btn">Next</button>
    <c:url var="url" value="/user/user-home/book-ticket/booking-details"/>
</div>
<script>
    const next_btn = document.getElementById("next-btn");
    const form = document.getElementById("form");

    next_btn.onclick = () => {
        const totalPassenger = ${ totalPassenger };
        const passengers = [];

        class Passenger {
            constructor(name, age, gender) {
                this.name = name;
                this.age = age;
                this.gender = gender;
            }
        }

        let validForm = true;

        for (let i = 1; i <= totalPassenger; ++i) {
            const name = document.getElementById("passenger-" + i + ".name").value;
            const name_error = document.getElementById("error.passenger-" + i + ".name");
            const age = document.getElementById("passenger-" + i + ".age").value;
            const age_error = document.getElementById("error.passenger-" + i + ".age");
            const gender = document.getElementById("passenger-" + i + ".gender").value;

            if (name == null || name.toString().trim().length === 0) {
                validForm = false;
                name_error.innerText = "Name can not empty";
            } else {
                name_error.innerText = "";
            }

            if (age == null || age.toString().trim().length === 0) {
                validForm = false;
                age_error.innerText = "Age can not empty"
            } else if (parseFloat(age) < 1) {
                validForm = false;
                age_error.innerText = "Age has to be greater than 0";
            } else {
                age_error.innerText = "";
            }

            const passenger = new Passenger(name, age, gender);
            passengers.push(passenger);
        }

        if (validForm) {
            const body = JSON.stringify(passengers);

            fetch("http://localhost:8080/user/user-home/book-ticket/passenger-entry", {
                method: 'POST',
                body: body,
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(response => response.json());

            window.location.href = "${ url }";
        }
    }
</script>
<footer></footer>
</body>
</html>
