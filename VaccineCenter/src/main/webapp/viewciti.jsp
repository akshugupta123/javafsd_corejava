<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.vaccine.Citizens"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> View Citizen</title>
</head>
<body>
<% 
   Citizens citi =(Citizens)request.getAttribute("citiinfo");

   
%>
<div style="border: 1px solid #ccc; padding: 10px; margin-bottom: 10px;">
  <h1 style="border-bottom: 1px solid #ccc;">Citizen Details</h1>
  <h2 style="border-bottom: 1px solid #ccc;"><%=citi.getName() %></h2>
  <p style="border-bottom: 1px solid #ccc; margin-bottom: 10px;">
    Id: <%= citi.getId() %>
  </p>
  <p style="border-bottom: 1px solid #ccc; margin-bottom: 10px;">
    City: <%= citi.getCity() %>
  </p>
  <p style="border-bottom: 1px solid #ccc; margin-bottom: 10px;">
    Number of Vaccines: <%= citi.getNoofdose() %>
  </p>
  <p style="border-bottom: 1px solid #ccc; margin-bottom: 10px;">
    Status: <%= citi.getStatus() %>
  </p>
  <p style="border-bottom: 1px solid #ccc; margin-bottom: 10px;">
    Allocation Vaccination Center: <%= citi.getClinicname() %>
  </p>
</div>
<a href="citidash">Return to Citizen List</a>

</body>
</html>