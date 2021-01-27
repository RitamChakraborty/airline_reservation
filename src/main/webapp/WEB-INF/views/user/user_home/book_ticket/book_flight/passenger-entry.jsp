<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Passenger Entry</title>
</head>
<body>
<header>
    <h1>Enter passenger details</h1>
</header>
<nav>
    <a href="/user/user-home">Home</a>
    <a href="/user/user-home/book-ticket">Cancel</a>
</nav>
<div class="content">
    <c:forEach var="i" begin="1" end="${ totalPassenger }">
        <div class="card">
            <div class="container">
                <form id="passenger-${ i }">
                    <label for="passenger-${ i }.name">Name</label>
                    <input type="text" id="passenger-${ i }.name" name="passenger-${ i }.name"
                           placeholder="Enter passenger name" required>
                    <span id="error.passenger-${ i }.name" class="error-text"></span>
                    <br>
                    <label for="passenger-${ i }.age">Age</label>
                    <input type="number" name="passenger-${ i }.age" id="passenger-${ i }.age" placeholder="Enter age"
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
    <button id="next-btn">Next</button>
</div>
<script>
    const next_btn = document.getElementById("next-btn");

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
                age_error.innerText = "Age has to be greater than 1";
            } else {
                age_error.innerText = "";
            }

            const passenger = new Passenger(name, age, gender);
            passengers.push(passenger);
        }

        if (validForm) {
            const body = JSON.stringify(passengers);
            console.log(body);
        }
    }
</script>
</body>
</html>
