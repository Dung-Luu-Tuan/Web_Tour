<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <body>
     <div align="center">
         <h1>Danh sách đoàn du lịch</h1>
         <h3><a href="${pageContext.request.contextPath}/newTouristGroup">Thêm đoàn du lịch</a></h3>
         <table border="1"
         	style="width: 90%; border: 1px solid black">
         	<thead>
         		<tr style="background-color: skyblue">
         			<th style="text-align: center;">Mã đoàn</th>
                    <th style="text-align: center;">Tên tour</th>
                    <th style="text-align: center;">Ngày khởi hành</th>
                    <th style="text-align: center;">Ngày kết thúc</th>
                    <th style="text-align: center;"></th>
                    <th></th>
         			<th></th>
         			<th></th>
         			<th></th>
         			<th></th>
         		</tr>
         	</thead>
         	<tbody align="center">
         		<c:forEach var="touristGroup" items="${touristGroups}" varStatus="status">
         			<tr>
         				<td>${touristGroup.madoan}</td>
                        <td>${touristGroup.getTour().getTengoi()}</td>
                        <td><fmt:formatDate pattern = "dd-MM-yyyy"
                              value = "${touristGroup.ngaykhoihanh}" /></td>
                        <td><fmt:formatDate pattern = "dd-MM-yyyy"
                              value = "${touristGroup.ngayketthuc}" /></td>
                        <td><a href="${pageContext.request.contextPath}/getDetailTouristGroup/${touristGroup.madoan}"/>Chi tiết</a></td>
         				<td><a href="${pageContext.request.contextPath}/editTouristGroup?id=${touristGroup.madoan}">Chỉnh sửa</a></td>
         				<td><a href="${pageContext.request.contextPath}/deleteTouristGroup/${touristGroup.madoan}">Xóa</a></td>
         				<td><a href="${pageContext.request.contextPath}/touristGroupCustomer/${touristGroup.madoan}">Khách hàng</a></td>
         				<td><a href="${pageContext.request.contextPath}/staffAllocationList/${touristGroup.madoan}">Phân bổ nhiệm vụ</a></td>
         				<td><a href="${pageContext.request.contextPath}/costList/${touristGroup.madoan}">Các loại chi phí</a></td>
         			</tr>
         		</c:forEach>
         	</tbody>
         </table>
     </div>
 </body>