<%@page import="com.gatedcommunity.dao.AdminDAO"%>
<%@ page language="java" import="java.util.*, com.gatedcommunity.model.Complaint" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Update Status — Gated Community</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <% Complaint comp = (Complaint) request.getAttribute("complaint"); %>
  <div class="card">
    <div class="brand-logo">
      <div class="logo-icon">🔄</div>
    </div>
    <div class="page-title">
      <h1>Update Complaint Status</h1>
      <span>Admin — Change the resolution status</span>
    </div>

    <form action="updatestatus" method="post">
      <input type="hidden" name="complaintId" value="<%= comp.getComplaintId() %>">
      <input type="hidden" name="userId"       value="<%= comp.getUserId() %>">
      <input type="hidden" name="category"     value="<%= comp.getCategory() %>">
      <input type="hidden" name="subject"      value="<%= comp.getSubject() %>">
      <input type="hidden" name="description"  value="<%= comp.getDescription() %>">

      <!-- Read-only info strip -->
      <div class="form-group">
        <div class="info-strip">
          <span class="info-label">Complaint ID</span>
          <span class="info-value">#<%= comp.getComplaintId() %></span>
        </div>
      </div>

      <div style="display:grid; grid-template-columns:1fr 1fr; gap:14px;">
        <div class="form-group">
          <div class="info-strip">
            <span class="info-label">User ID</span>
            <span class="info-value"><%= comp.getUserId() %></span>
          </div>
        </div>
        <div class="form-group">
          <div class="info-strip">
            <span class="info-label">Category</span>
            <span class="info-value"><%= comp.getCategory() %></span>
          </div>
        </div>
      </div>

      <div class="form-group">
        <div class="info-strip">
          <span class="info-label">Subject</span>
          <span class="info-value"><%= comp.getSubject() %></span>
        </div>
      </div>

      <div class="form-group">
        <div class="info-strip">
          <span class="info-label">Description</span>
          <span class="info-value"><%= comp.getDescription() %></span>
        </div>
      </div>

      <div class="divider"></div>

      <!-- Only editable field -->
      <div class="form-group">
        <label for="status">Update Status To</label>
        <select id="status" name="status" class="status-select">
          <option value="Pending"    <%= "Pending".equals(comp.getStatus())    ? "selected" : "" %>>⏳ Pending</option>
          <option value="InProgress" <%= "InProgress".equals(comp.getStatus()) ? "selected" : "" %>>🔧 In Progress</option>
          <option value="Resolved"   <%= "Resolved".equals(comp.getStatus())   ? "selected" : "" %>>✅ Resolved</option>
        </select>
      </div>

      <input type="submit" value="Update Status">
    </form>

    <p class="link-line"><a href="updatecomplaintstatus">← Back to Complaints List</a></p>
  </div>
</body>
</html>
