<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Logout</title>
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
            place-items: center;
            display: flex;
            flex-direction: column;
        }

        .content {
            flex: 2;
            display: flex;
            height: max-content;
            flex-direction: column;
            justify-content: space-evenly;
            align-items: center;
            color: darkslategrey;
        }

        .card {
            background-color: rgba(255, 255, 255, 0.7);
            padding: 2rem;
            margin: 2rem 4rem 0 4rem;
            border-radius: 10px;
            box-shadow: 0 15px 30px -10px grey;
            width: min-content;
        }

        .container {
            width: 25vw;
            text-align: center;
        }

        .container * {
            padding: 1rem;
            display: grid;
            place-items: center;
        }

        .submit-btn {
            font-size: large;
            padding: 0.5rem 1rem;
            background-color: dodgerblue;
            border: none;
            outline: none;
            color: white;
            border-radius: 4px;
        }

        a {
            text-decoration: none;
        }


        footer {
            margin-bottom: 2rem;
        }
    </style>
</head>
<body>
<div class="content">
    <div class="card">
        <div class="container">
            <h2>You have been logged out</h2>
            <a href="<c:url value="/"/>">
                <button class="submit-btn">Login</button>
            </a>
        </div>
    </div>
</div>
<footer></footer>
</body>
</html>
