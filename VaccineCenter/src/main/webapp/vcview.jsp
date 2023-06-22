<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.vaccine.Vaccenter" %>   
 <%@page import="com.vaccine.Citizens" %>   
  <%@page import="java.util.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vaccination Center View</title>
<style>
  table {
    border-collapse: collapse;
    width: 100%;
  }
  
  th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
  }
  
  th {
    background-color: #f2f2f2;
  }
  
  tr:hover {
    background-color: #f5f5f5;
  }
  
  a {
    text-decoration: none;
    color: blue;
  }
    .name-heading {
    font-size: 20px;
    border-bottom: 1px solid #ccc;
    padding-bottom: 10px;
    margin-bottom: 10px;
  }
</style>
</head>
<body>
<% 
   Vaccenter vc =(Vaccenter)request.getAttribute("vlist"); 
   List<Citizens> citi = (List<Citizens>)request.getAttribute("clist"); 
%>
<h2>Center Detail</h2>
  <table>
     <tr>
     
      <td colspan="3">
        <h2 class="name-heading"><%= vc.getName() %></h2>
      </td>
    </tr>
    <tr>
      <td>Id:</td>
     <td colspan="2"><%= vc.getId() %></td>
    </tr>
    <tr>
      <td>City:</td>
   <td colspan="2"><%= vc.getCity() %></td>
    </tr>
  </table>
  
   <h2>List of Citizens</h2>
<table>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Action</th>
  </tr>
  
  <% for (Citizens citz: citi) { %>
    <tr>
      <td><%= citz.getId() %></td>
      <td><%= citz.getName() %></td> 
      <td><a href="viewciti?id=<%= citz.getId() %>">View</a></td> 
    </tr>
  <% } %>
</table>
<a href="dashboard">Return to Dashboard</a>
</body>
</html>