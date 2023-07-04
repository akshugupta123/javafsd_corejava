<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.vaccine.City" %>   
  <%@page import="java.util.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Vaccination Center</title>
</head>
<style>
    body {
      font-family: Arial, sans-serif;
    }

    h1 {
      text-align: center;
    }

    form {
      width: 300px;
      margin: 0 auto;
      text-align: left;
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 5px;
      background-color: #f2f2f2;
    }

    label {
      font-weight: bold;
    }

    input[type="text"],
    select {
      width: 100%;
      padding: 10px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 3px;
    }

    input[type="submit"] {
      width: 100%;
      padding: 10px;
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 3px;
      cursor: pointer;
    }
  </style>
<body>
<% 
   List<City>city =(List<City>)request.getAttribute("citi");
%>

 <h1>Add Center</h1>
  <form action="addvac">
    <label for="cname">Center Name:</label>
    <input type="text" name="cname" id="cname">

    <label for="selectedCity">Vaccine City:</label>
    <select name="selectedCity" id="selectedCity">
      <% for (City ci : city) {
        String cityname = ci.getCityname();
      %>
      <option value="<%=cityname%>"><%=cityname%></option>
      <% } %>
    </select>

    <input type="submit" value="Submit">
  </form>
</body>
</html>