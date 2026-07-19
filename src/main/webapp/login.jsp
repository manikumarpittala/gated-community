<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard — Gated Community</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <div class="card card-wide">
    <div class="brand-logo">
      <div class="logo-icon">🏘️</div>
    </div>
    <div class="page-title">
      <h1>Welcome, <span class="welcome-name"><%= session.getAttribute("username") %></span></h1>
      <span>Resident Dashboard — Gowrayapally Gated Community</span>
    </div>

    <div class="divider"></div>

    <div class="dashboard-grid">
      <a href="complaint.jsp" class="nav-card">
        <span class="nav-icon">📩</span>
        <span class="nav-label">Submit a Complaint</span>
      </a>
      <a href="viewcomplaints" class="nav-card">
        <span class="nav-icon">📋</span>
        <span class="nav-label">View My Complaints</span>
      </a>
    </div>
  </div>
</body>
</html>
