<%@page import="com.gatedcommunity.dao.ComplaintDAO"%>
<%@ page language="java" import="java.util.*, com.gatedcommunity.model.Complaint" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>My Complaints — Gated Community</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <div class="card card-wide">
    <div class="brand-logo">
      <div class="logo-icon">📋</div>
    </div>
    <div class="page-title">
      <h1>My Complaints</h1>
      <span>Logged in as: <strong class="welcome-name"><%= session.getAttribute("username") %></strong></span>
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
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <% List<Complaint> complaintsList = (List<Complaint>) request.getAttribute("compList");
             for (Complaint comp : complaintsList) {
               String st = comp.getStatus();
          %>
          <tr>
            <td><%= comp.getComplaintId() %></td>
            <td><%= comp.getUserId() %></td>
            <td><%= comp.getCategory() %></td>
            <td><%= comp.getSubject() %></td>
            <td><%= comp.getDescription() %></td>
            <td>
              <span class="badge <%= "Pending".equals(st) ? "badge-pending" : "InProgress".equals(st) ? "badge-inprogress" : "badge-resolved" %>">
                <%= "Pending".equals(st) ? "⏳ Pending" : "InProgress".equals(st) ? "🔧 In Progress" : "✅ Resolved" %>
              </span>
            </td>
            <td>
              <% if ("Pending".equals(st)) { %>
                <a href="withdrawcomplaint?id=<%= comp.getComplaintId() %>" class="btn-danger"
                   onclick="return confirm('Are you sure you want to withdraw this complaint?')">
                  🗑️ Withdraw
                </a>
                <a href="updatecomplaint?id=<%= comp.getComplaintId() %>" class="btn-warning">
                  ✏️ Update
                </a>
              <% } else { %>
                <span style="color:#555e6b; font-size:0.8rem; font-style:italic;">No actions</span>
              <% } %>
            </td>
          </tr>
          <% } %>
        </tbody>
      </table>
    </div>

    <p class="link-line" style="margin-top:24px;"><a href="login.jsp">← Back to Dashboard</a></p>
  </div>
</body>
</html>
