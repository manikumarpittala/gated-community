<%@page import="com.gatedcommunity.dao.AdminDAO"%>
<%@ page language="java" import="java.util.*, com.gatedcommunity.model.Complaint" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>All Complaints — Gated Community</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <div class="card card-wide">
    <div class="brand-logo">
      <div class="logo-icon">📂</div>
    </div>
    <div class="page-title">
      <h1>All Complaints</h1>
      <span>Admin View — Gowrayapally Gated Community</span>
    </div>

    <div class="table-wrapper">
      <table>
        <thead>
          <tr>
            <th>Complaint ID</th>
            <th>User ID</th>
            <th>Category</th>
            <th>Subject</th>
            <th>Description</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          <% List<Complaint> complaintsList = (List<Complaint>) request.getAttribute("allcomplaints");
             for (Complaint comp : complaintsList) { %>
          <tr>
            <td><%= comp.getComplaintId() %></td>
            <td><%= comp.getUserId() %></td>
            <td><%= comp.getCategory() %></td>
            <td><%= comp.getSubject() %></td>
            <td><%= comp.getDescription() %></td>
            <td>
              <% String st = comp.getStatus(); %>
              <span class="badge
                <% if("Pending".equals(st))    { %>badge-pending<%
                   } else if("InProgress".equals(st)) { %>badge-inprogress<%
                   } else { %>badge-resolved<% } %>">
                <%= st %>
              </span>
            </td>
          </tr>
          <% } %>
        </tbody>
      </table>
    </div>

    <p class="link-line" style="margin-top:24px;"><a href="admin.jsp">← Back to Admin Dashboard</a></p>
  </div>
</body>
</html>
