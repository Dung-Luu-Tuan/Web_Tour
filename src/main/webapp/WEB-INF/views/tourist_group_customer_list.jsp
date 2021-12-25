<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <body>
     <div align="center">
         <h1>Danh sách khách hàng của đoàn</h1>
         <h3><a href="${pageContext.request.contextPath}/customerListAdd/${idTourGroup}">Thêm khách hàng mới vào đoàn</a></h3>
         <table border="1"
         	style="width: 90%; border: 1px solid black">
         	<thead>
         		<tr style="background-color: skyblue">
         			<th style="text-align: center;">Mã KH</th>
                    <th style="text-align: center;">Họ tên</th>
                    <th style="text-align: center;">cmnd</th>
                    <th style="text-align: center;">Địa chỉ</th>
                    <th style="text-align: center;">Giới tính</th>
                    <th style="text-align: center;">Sđt</th>
                    <th style="text-align: center;">Quốc tịch</th>
                    <th></th>
         		</tr>
         	</thead>
         	<tbody align="center">
         		<c:forEach var="customer" items="${touristGroupCustomer}" varStatus="status">
         			<tr>
         				<td>${customer.makhachhang}</td>
                        <td>${customer.hoten}</td>
                        <td>${customer.cmnd}</td>
                        <td>${customer.diachi}</td>
                        <td>${customer.gioitinh}</td>
                        <td>${customer.sdt}</td>
                        <td>${customer.quoctich}</td>
         				<td><a href="${pageContext.request.contextPath}/deleteCustomerTouristGroup/${idTourGroup}/${customer.makhachhang}">Xóa</a></td>
         			</tr>
         		</c:forEach>
         	</tbody>
         </table>
     </div>
 </body>