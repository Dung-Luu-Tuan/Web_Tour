<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <body>
     <div align="center">
         <h1>Danh sách tour</h1>
         <h3><a href="${pageContext.request.contextPath}/newTour">Thêm tour mới</a></h3>
         <table border="1"
         	style="width: 90%; border: 1px solid black">
         	<thead>
         		<tr style="background-color: skyblue">
         			<th style="text-align: center;">Mã tour</th>
                    <th style="text-align: center;">Tên tour</th>
                    <th style="text-align: center;">Mã loại hình</th>
                    <th style="text-align: center;">Đặc điểm</th>
                    <th style="text-align: center;"></th>
                    <th></th>
         			<th></th>
         		</tr>
         	</thead>
         	<tbody align="center">
         		<c:forEach var="tour" items="${tours}" varStatus="status">
         			<tr>
         				<td>${tour.matour}</td>
                        <td>${tour.tengoi}</td>
                        <td>${tour.maloaihinh}</td>
                        <td>${tour.dacdiem}</td>
                        <td><a href="${pageContext.request.contextPath}/getTourDetail/${tour.matour}"/>Chi tiết</a></td>
         				<td><a href="${pageContext.request.contextPath}/editTour?id=${tour.matour}">Sửa</a></td>
         				<td><a href="${pageContext.request.contextPath}/deleteTour/${tour.matour}">Xóa</a></td>
         			</tr>
         		</c:forEach>
         	</tbody>
         </table>
     </div>
 </body>