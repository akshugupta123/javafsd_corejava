<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.vaccine.Citizens"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Citizen Dashboard</title>
</head>
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
<body>
	<%@ include file="header.jsp"%>
	<div style="float:right">
	<form action="getciticenter">
		<input type="submit" value="Add Citizens">
	</form>
	</div>
	<% 
   List<Citizens>citi =(List<Citizens>)request.getAttribute("listctzn");
	int count =0;
%>
<table>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>City</th>
    <th>Center Name</th>
    <th>No of Dose</th>
    <th>Status</th>
    <th>Action</th>
  </tr>
  <% for (Citizens ctzn : citi) { %>
    <tr>
      <td><%= ctzn.getId() %></td>
      <td><%= ctzn.getName() %></td>
      <td><%= ctzn.getCity() %></td>
      <td><%= ctzn.getClinicname() %></td>
      <td><%= ctzn.getNoofdose() %></td>
      <td><%= ctzn.getStatus() %></td>
      <td class="action-links">
        <a href="viewciti?id=<%= ctzn.getId() %>">View</a>
        <a href="editcit?id=<%= ctzn.getId() %>">Edit</a>
        <a href="deleteciti?id=<%= ctzn.getId() %>">Delete</a>
      </td>
    </tr>
  <%count++;
 } %>
</table>
<div style="text-align: center;">Total <%= count %> Citzens Found</div>
</body>
</html>