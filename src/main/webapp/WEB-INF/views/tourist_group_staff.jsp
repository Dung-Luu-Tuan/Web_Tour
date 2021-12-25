<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <body>
     <div align="center">
         <h1>Danh sách phân bổ nhân viên</h1>
         <h3><a href="${pageContext.request.contextPath}/newStaffAllocation/${idTourGroup}">Thêm phân bố mới</a></h3>
         <table border="1"
         	style="width: 90%; border: 1px solid black">
         	<thead>
         		<tr style="background-color: skyblue">
         			<th style="text-align: center;">Mã nhân viên</th>
                    <th style="text-align: center;">Tên nhân viên</th>
                    <th style="text-align: center;">Nhiệm vụ</th>
                    <th></th>
         			<th></th>
         		</tr>
         	</thead>
         	<tbody align="center">
         		<c:forEach var="staff" items="${touristStaff}" varStatus="status">
         			<tr>
         				<td>${staff.manhanvien}</td>
                        <td>${staff.getStaff().getTennhanvien()}</td>
                        <td>${staff.nhiemvu}</td>
         				<td><a href="${pageContext.request.contextPath}/editStaffAllocation/${idTourGroup}/${staff.manhanvien}/${staff.nhiemvu}">Sửa</a></td>
         				<td><a href="${pageContext.request.contextPath}/deleteCustomerTouristGroup/${idTourGroup}/${staff.manhanvien}/${staff.nhiemvu}">Xóa</a></td>
         			</tr>
         		</c:forEach>
         	</tbody>
         </table>
     </div>
 </body>