<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.vaccine.Vaccenter" %>   
  <%@page import="com.vaccine.City" %>  
  <%@page import="java.util.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Vaccination Center</title>
<style>
  form {
    width: 400px;
    margin: 0 auto;
    text-align: center;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #f2f2f2;
  }

  label {
    display: block;
    margin-bottom: 10px;
    font-weight: bold;
    text-align: left;
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
</head>
<body>
<% 
   Vaccenter vcent =(Vaccenter)request.getAttribute("optlist");
List<City>city =(List<City>)request.getAttribute("citi");
%>

<form action="update">
   <h2>Edit Vaccination Center</h2>
  <input type="hidden" value="<%= vcent.getId() %>" name="id">
  <input type="hidden" value="<%= vcent.getName() %>" name="prevname">

  <label for="cname">Center name:</label>
  <input type="text" value="<%= vcent.getName() %>" name="cname">

  <label for="cityname">Vaccine City:</label>
  <select name="cityname">
    <option value="<%= vcent.getCity() %>" selected><%= vcent.getCity() %></option>
    <% for (City ci : city) {
      String cityname = ci.getCityname();
      if (!cityname.equals(vcent.getCity())) { %>
        <option value="<%= cityname %>"><%= cityname %></option>
      <% }
    } %>
  </select>

  <input type="submit" value="Submit">
</form>
</body>
</html>