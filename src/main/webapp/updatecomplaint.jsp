<%@page import="com.gatedcommunity.dao.ComplaintDAO"%>
<%@ page language="java" import="java.util.*, com.gatedcommunity.model.Complaint" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Update Complaint — Gated Community</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <% Complaint comp = (Complaint) request.getAttribute("complaint"); %>
  <div class="card">
    <div class="brand-logo">
      <div class="logo-icon">✏️</div>
    </div>
    <div class="page-title">
      <h1>Update Complaint</h1>
      <span>Edit and resubmit your complaint details</span>
    </div>

    <form action="updatecomplaint" method="post">
      <input type="hidden" name="complaintId" value="<%= comp.getComplaintId() %>">
      <input type="hidden" name="userId"      value="<%= comp.getUserId() %>">

      <!-- Read-only complaint ID -->
      <div class="form-group">
        <div class="info-strip">
          <span class="info-label">Complaint ID</span>
          <span class="info-value">#<%= comp.getComplaintId() %></span>
        </div>
      </div>

      <div class="divider"></div>

      <!-- Editable fields -->
      <div class="form-group">
        <label for="category">Complaint Category</label>
        <input type="text" id="category" name="category" value="<%= comp.getCategory() %>" placeholder="e.g. Maintenance, Security...">
      </div>

      <div class="form-group">
        <label for="subject">Subject</label>
        <input type="text" id="subject" name="subject" value="<%= comp.getSubject() %>" placeholder="Brief subject">
      </div>

      <div class="form-group">
        <label for="description">Description</label>
        <textarea id="description" name="description" placeholder="Describe the complaint in detail..."><%= comp.getDescription() %></textarea>
      </div>

      <input type="submit" value="Save Changes">
    </form>

    <p class="link-line"><a href="viewcomplaints">← Back to My Complaints</a></p>
  </div>
</body>
</html>
