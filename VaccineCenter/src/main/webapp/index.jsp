<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }

        .container {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .container h2 {
            text-align: center;
        }

        .container input[type="text"],
        .container input[type="password"] {
            width: 95%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 3px;
        }

        .container input[type="submit"],
        .container a {
            display: block;
            width: 95%;
            padding: 10px;
            text-align: center;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            text-decoration: none;
        }

        .container input[type="submit"]:hover,
        .container a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Login</h2>
        <form action="login">
            <div>
                <label for="uname">Username:</label>
                <input type="text" id="uname" name="uname">
            </div>
            <div>
                <label for="pass">Password:</label>
                <input type="password" id="pass" name="pass">
            </div>
            <input type="submit" value="Login">
        </form>
    </div>
    <div class="container">
        <a href="regpage.jsp">Register</a>
    </div>
</body>
</html>

</body>
</html>