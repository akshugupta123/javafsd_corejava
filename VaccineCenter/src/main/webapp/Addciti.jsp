<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.vaccine.City"%>
<%@page import="com.vaccine.Vaccenter"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Citizen</title>
	<style>
  /* Add your CSS styles here */
  body {
    font-family: Arial, sans-serif;
    background-color: #f2f2f2;
    margin: 0;
    padding: 20px;
  }

  form {
    background-color: #fff;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  }

  label {
    display: block;
    margin-bottom: 10px;
    font-weight: bold;
  }

  input[type="text"],
  select {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-bottom: 15px;
  }

  input[type="submit"] {
    background-color: #4caf50;
    color: #fff;
    border: none;
    padding: 10px 20px;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
  }

  input[type="submit"]:hover {
    background-color: #45a049;
  }
</style>
</head>
<body>
	<% 
   List<City>city =(List<City>)request.getAttribute("citi");
   List<Vaccenter>vcent =(List<Vaccenter>)request.getAttribute("centerlist");
%>
<h1> Add citizen</h1>


<form action="addcitizen">
  <label for="cname">Name:</label>
  <input type="text" id="cname" name="cname">

  <label for="selectedCenter">Clinic Name:</label>
  <select name="selectedCenter" id="selectedCenter">
    <% for (Vaccenter cent: vcent) {
      String clinicname = cent.getName();
    %>
    <option value="<%= clinicname %>"><%= clinicname %></option>
    <% } %>
  </select>

  <label for="selectedCity">City:</label>
  <select name="selectedCity" id="selectedCity">
    <% for (City ci: city) {
      String cityname = ci.getCityname();
    %>
    <option value="<%= cityname %>"><%= cityname %></option>
    <% } %>
  </select>

  <input type="hidden" name="noofdose" value="0">
  <input type="submit" value="Submit">
</form>
</body>
</html>