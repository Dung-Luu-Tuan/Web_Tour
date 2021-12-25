<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<header>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Web Tour</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="${pageContext.request.contextPath}/tourList">Tour du lịch</a></li>
      <li><a href="${pageContext.request.contextPath}/customerList">Khách hàng</a></li>
      <li><a href="${pageContext.request.contextPath}/touristGroupList">Đoàn du lịch</a></li>
      <li><a href="${pageContext.request.contextPath}/placeList">Địa điểm</a></li>
      <li><a href="${pageContext.request.contextPath}/typeCostList">Loại chi phí</a></li>
      <li><a href="${pageContext.request.contextPath}/staffList">Nhân viên</a></li>
      <li><a href="${pageContext.request.contextPath}/typeTourList">Loại hình tour</a></li>
    </ul>
  </div>
</nav>
</header>