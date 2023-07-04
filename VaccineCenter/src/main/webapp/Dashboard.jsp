<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.vaccine.Vaccenter" %>   
  <%@page import="java.util.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vaccination Center Dashboard</title>
<style>
  table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
  }

  th, td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ddd;
  }

  th {
    background-color: #f2f2f2;
    font-weight: bold;
  }

  tr:hover {
    background-color: #f5f5f5;
  }

  .action-links a {
    margin-right: 5px;
    color: #333;
    text-decoration: none;
  }

  .action-links a:hover {
    text-decoration: underline;
  }
 
</style>
</head>
<body>
<%@ include file="header.jsp" %>  
<div style="float:right;">
<form action="addvcent">
<input type="submit" value="Add New Center">
</form>
</div>


<% 
   List<Vaccenter>vcent =(List<Vaccenter>)request.getAttribute("listvc");
   int count =0;
%>

<table>
  <tr>
    <th>ID</th>
    <th>Center Name</th>
    <th>Center City</th>
    <th>Action</th>
  </tr>
  <% for (Vaccenter vc : vcent) { %>
    <tr>
      <td><%= vc.getId() %></td>
      <td><%= vc.getName() %></td>
      <td><%= vc.getCity() %></td>
      <td class="action-links">
        <a href="viewvac?id=<%= vc.getId() %>&name=<%= vc.getName() %>">View</a>
        <a href="editvac?id=<%= vc.getId() %>">Edit</a>
        <a href="deletevac?id=<%= vc.getId() %>&name=<%= vc.getName() %>">Delete</a>
      </td>
    </tr>
  <%
  count++;
   
  } %>
</table>
<div style="text-align: center;">Total <%= count %> Centers Found</div>

</body>
</html>