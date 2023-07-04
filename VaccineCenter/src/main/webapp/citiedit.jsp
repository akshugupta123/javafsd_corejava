<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.vaccine.Vaccenter"%>
<%@page import="com.vaccine.Citizens"%>
<%@page import="com.vaccine.City" %>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Citizen</title>
  <style>
    body {
      font-family: Arial, sans-serif;
    }

    h1 {
      text-align: center;
    }

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
   Citizens citi =(Citizens)request.getAttribute("citiinfo");
List<City>city =(List<City>)request.getAttribute("citi");
List<Vaccenter>vcent =(List<Vaccenter>)request.getAttribute("centerlist");
%>
<h1>Edit Citizen</h1>
  <form action="updateciti">
    <input type="hidden" name="cid" value="<%= citi.getId() %>">

    <label for="cname">Name:</label>
    <input type="text" name="cname" value="<%= citi.getName() %>">

    <label for="cityname">Citizen City:</label>
    <select name="cityname">
      <option value="<%= citi.getCity() %>" selected><%= citi.getCity() %></option>
      <% for (City ci : city) {
        String cityname = ci.getCityname();
        if (!cityname.equals(citi.getCity())) { %>
          <option value="<%= cityname %>"><%= cityname %></option>
        <% }
      } %>
    </select>

    <label for="dose">No of Doses:</label>
    <select name="dose">
      <option value="<%= citi.getNoofdose() %>" selected><%= citi.getNoofdose() %></option>
      <option value="1">1</option>
      <option value="2">2</option>
    </select>

    <label for="centername">Vaccination Center:</label>
    <select name="centername">
      <option value="<%= citi.getClinicname() %>" selected><%= citi.getClinicname() %></option>
      <% for (Vaccenter cent : vcent) {
        String clinicname = cent.getName();
        if (!clinicname.equals(citi.getClinicname())) { %>
          <option value="<%= clinicname %>"><%= clinicname %></option>
        <% }
      } %>
    </select>

    <input type="submit" value="Submit">
  </form>
</body>
</html>