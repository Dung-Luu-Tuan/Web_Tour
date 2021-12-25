<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <body>
     <div align="center">
         <h1>Danh sách nhân viên</h1>
         <h3><a href="${pageContext.request.contextPath}/newStaff/${idTourGroup}">Thêm nhân viên mới</a></h3>
         <table border="1"
         	style="width: 90%; border: 1px solid black">
         	<thead>
         		<tr style="background-color: skyblue">
         			<th style="text-align: center;">Mã nhân viên</th>
                    <th style="text-align: center;">Tên nhân viên</th>
                    <th style="text-align: center;">Số điện thoại</th>
                    <th style="text-align: center;">Địa chỉ</th>
                    <th></th>
         			<th></th>
         		</tr>
         	</thead>
         	<tbody align="center">
         		<c:forEach var="staff" items="${staffs}" varStatus="status">
         			<tr>
         				<td>${staff.manhanvien}</td>
                        <td>${staff.tennhanvien}</td>
                        <td>${staff.sodienthoai}</td>
                        <td>${staff.diachi}</td>
         				<td><a href="${pageContext.request.contextPath}/editStaff?id=${staff.manhanvien}">Sửa</a></td>
         				<td><a href="${pageContext.request.contextPath}/deleteStaff/${staff.manhanvien}">Xóa</a></td>
         			</tr>
         		</c:forEach>
         	</tbody>
         </table>
     </div>
 </body>