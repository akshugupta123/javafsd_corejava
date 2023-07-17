<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f5f5f5;
        }
        
        .container {
            max-width: 400px;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            text-align: center;
        }
        
        h1 {
            color: #333;
        }
        
        label {
            display: block;
            margin-bottom: 5px;
            text-align: left;
        }
        
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: green;
            border: none;
            color: #fff;
            font-size: 16px;
            border-radius: 10px;
            cursor: pointer;
        }
        
        p {
            margin-top: 10px;
        }
        
        a {
            color: blue;
        }
    </style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
        <h1>Railway Crossing</h1>
        <h4>User Register</h4>

<form method="post" action="login">
<label for="email">Enter Email:</label>
<input type="email" id="email" name="email" required><br><br>
<label for="password">Enter Password:</label>
<input type="password" id="password" name="password"
required><br><br>
<input type="submit" value="Login">
</form>
<br>
<p>Don't have an account? <a href="register.jsp">Create NewAccount</a></p>
 </div>
</body>
</html>
