<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Submit Complaint — Gated Community</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <div class="card">
    <div class="brand-logo">
      <div class="logo-icon">📩</div>
    </div>
    <div class="page-title">
      <h1>Submit a Complaint</h1>
      <span>We'll address your concern promptly</span>
    </div>

    <form action="complaint" method="post">
      <div class="form-group">
        <label>Username</label>
        <input name="username" value="<%= session.getAttribute("username") %>" readonly>
      </div>
      <div class="form-group">
        <label>Full Name</label>
        <input value="<%= session.getAttribute("fullName") %>" readonly>
      </div>
      <div class="form-group">
        <label>Email Address</label>
        <input value="<%= session.getAttribute("email") %>" readonly>
      </div>
      <div class="form-group">
        <label for="phoneNumber">Phone Number</label>
        <input type="text" id="phoneNumber" name="phoneNumber" placeholder="+91 XXXXX XXXXX">
      </div>
      <div class="form-group">
        <label for="category">Complaint Category</label>
        <input type="text" id="category" name="category" placeholder="e.g. Maintenance, Security...">
      </div>
      <div class="form-group">
        <label for="subject">Subject</label>
        <input type="text" id="subject" name="subject" placeholder="Brief subject of complaint">
      </div>
      <div class="form-group">
        <label for="complaintDetails">Complaint Details</label>
        <textarea id="complaintDetails" name="complaintDetails" placeholder="Describe your complaint in detail..."></textarea>
      </div>
      <input type="submit" value="Submit Complaint">
    </form>
  </div>
</body>
</html>
