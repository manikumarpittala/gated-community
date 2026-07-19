<%@page import="com.gatedcommunity.dao.AdminDAO"%>
<%@ page language="java" import="java.util.*, com.gatedcommunity.model.Complaint" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Update Complaint Status — Gated Community</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <div class="card card-wide">
    <div class="brand-logo">
      <div class="logo-icon">🔄</div>
    </div>
    <div class="page-title">
      <h1>Update Complaint Statuses</h1>
      <span>Admin — Select a complaint to update its status</span>
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
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          <% List<Complaint> complaintsList = (List<Complaint>) request.getAttribute("complaints");
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
              <% if ("Pending".equals(st) || "InProgress".equals(st)) { %>
                <a href="updatestatus?id=<%= comp.getComplaintId() %>" class="btn-success">🔄 Update Status</a>
              <% } else { %>
                <span style="color:#555e6b; font-size:0.8rem; font-style:italic;">Resolved</span>
              <% } %>
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
