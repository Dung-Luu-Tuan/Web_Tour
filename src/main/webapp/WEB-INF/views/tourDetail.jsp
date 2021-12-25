<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
<div align="center">
    <c:forEach var="tour" items="${tourDetail}" varStatus="status" begin="0"
			end="0">
			<h1>Chi tiết tour: ${tour.matour}</h1>
			<p>Tên tour: ${tour.tengoi}</p>
			<p>Đặc điểm: ${tour.dacdiem}</p>
			<p>Loại hình: ${tour.getLoaihinh().getTenloaihinh()}</p>
	</c:forEach>
<div>
<div align="center">
         <h1>Lộ trình</h1>
         <button style="background-color: #4CAF50; font-size: 14px; padding: 15px 32px; border: none; margin: 4px 2px;"><a href="${pageContext.request.contextPath}/newLocationTour?id=${idTour}">Thêm lộ trình</a></button>
         <table border="1"
         	style="width: 97%; height: 20%; border: 1px solid black; border-collapse: collapse;text-align: center;padding-bottom: 20px;">
         	<thead>
         		<tr style="background-color: skyblue">
         			<th style="text-align: center;">STT</th>
                    <th style="text-align: center;">Mã địa điểm</th>
                    <th style="text-align: center;">Tên địa điểm</th>
                    <th></th>
                    <th></th>
         		</tr>
         	</thead>
         	<tbody align="center">
         		<c:forEach var="location" items="${tourLocations}" varStatus="status">
         			<tr>
         			    <td>${location.thutu}</td>
                        <td>${location.madiadiem}</td>
                        <td>${location.getPlace().getTendiadiem()}</td>
         				<td><a href="${pageContext.request.contextPath}/editTourLocation/${location.matour}/${location.madiadiem}/${location.thutu}">Sửa</a></td>
         				<td><a href="${pageContext.request.contextPath}/deleteTourLocation/${tour.matour}/${location.matour}/${location.madiadiem}/${location.thutu}"
         				onclick="return confirm('Are you sure you want to delete this item?')">Xóa</a></td>
         			</tr>
         		</c:forEach>
         	</tbody>
         </table>
     </div>

     <div align="center">
              <h1>Bảng giá</h1>
              <button style="background-color: #4CAF50; font-size: 14px; padding: 15px 32px; border: none; margin: 4px 2px;"><a href="${pageContext.request.contextPath}/newPriceTour?id=${idTour}">Thêm giá</a></button>
              <table border="1"
              	style="width: 97%; height: 20%; border: 1px solid black; border-collapse: collapse;text-align: center;padding-bottom: 20px;">
              	<thead>
              		<tr style="background-color: skyblue">
              			 <th style="text-align: center;">Mã giá</th>
                         <th style="text-align: center;">Thành tiền</th>
                         <th style="text-align: center;">Thời gian bắt đầu</th>
                         <th style="text-align: center;">Thời gian kết thúc</th>
                         <th></th>
              			 <th></th>
              		</tr>
              	</thead>
              	<tbody align="center">
              		<c:forEach var="price" items="${tourPrices}" varStatus="status">
              			<tr>
              				 <td>${price.magia}</td>
                             <td><fmt:formatNumber type = "number"
                                   maxFractionDigits = "3" value = "${price.thanhtien}" /></td>
                             <td><fmt:formatDate pattern = "dd-MM-yyyy"
                                          value = "${price.dateStart}" /></td>
                             <td><fmt:formatDate pattern = "dd-MM-yyyy"
                                          value = "${price.dateEnd}" /></td>
              				 <td><a href="${pageContext.request.contextPath}/editPrice/${price.magia}/${price.matour}">Sửa</a></td>
              				 <td><a href="${pageContext.request.contextPath}/deleteTourPrice/${price.magia}/${price.matour}"
              				        onclick="return confirm('Are you sure you want to delete this item?')">Xóa</a></td>
              			</tr>
              		</c:forEach>
              	</tbody>
              </table>
          </div>
</body>