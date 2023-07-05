<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
  .navbar {
    display: flex;
    flex-direction: row;
    gap: 20px;
    justify-content: flex-start;
    align-items: center;
    background-color: #f2f2f2;
    padding: 10px;
    border-bottom: 1px solid #ccc;
    margin-bottom:10px;
  }

  .navbar a {
    text-decoration: none;
    color: #333;
    padding: 10px;
    border-radius: 3px;
  }

  .navbar a:hover {
    background-color: #ddd;
  }

  .navbar .logout {
    margin-left: auto;
  }
</style>
</head>
<body>


<div class="navbar">
  <a href="citidash">citizen</a>
  <a href="dashboard">vaccine</a>

  <a href="logout" class="logout">Logout</a>

  <% String name = (String) session.getAttribute("UserName"); %>
  <span>Welcome, <%= name %></span>
</div>
</body>
</html>