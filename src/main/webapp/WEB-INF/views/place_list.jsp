<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <body>
     <div align="center">
         <h1>Danh sách địa điểm</h1>
         <h3><a href="${pageContext.request.contextPath}/newPlace">Thêm địa điểm mới</a></h3>
         <table border="1"
         	style="width: 90%; border: 1px solid black">
         	<thead>
         		<tr style="background-color: skyblue">
         			<th style="text-align: center;">Mã địa điểm</th>
                    <th style="text-align: center;">Tên địa điểm</th>
         			<th></th>
         			<th></th>
         		</tr>
         	</thead>
         	<tbody align="center">
         		<c:forEach var="place" items="${places}" varStatus="status">
         			<tr>
         				<td>${place.madiadiem}</td>
                        <td>${place.tendiadiem}</td>
         				<td><a href="${pageContext.request.contextPath}/editPlace?id=${place.madiadiem}">Sửa</a></td>
         				<td><a href="${pageContext.request.contextPath}/deletePlace/${place.madiadiem}">Xóa</a></td>
         			</tr>
         		</c:forEach>
         	</tbody>
         </table>
     </div>
 </body>