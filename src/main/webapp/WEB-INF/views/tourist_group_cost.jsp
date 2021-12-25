<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
 <body>
     <div align="center">
         <h1>Danh sách chi phí của đoàn</h1>
         <h3><a href="${pageContext.request.contextPath}/newCostTouristGroup/${idTourGroup}">Thêm chi phí mới</a></h3>
         <table border="1"
         	style="width: 90%; border: 1px solid black">
         	<thead>
         		<tr style="background-color: skyblue">
         			<th style="text-align: center;">Mã chi phí</th>
                    <th style="text-align: center;">Tên loại chi phí</th>
                    <th style="text-align: center;">Số tiền</th>
                    <th></th>
         			<th></th>
         		</tr>
         	</thead>
         	<tbody align="center">
         		<c:forEach var="cost" items="${costs}" varStatus="status">
         			<tr>
         				<td>${cost.machiphi}</td>
                        <td>${cost.getTypeCost().getTenchiphi()}</td>
                        <td><fmt:formatNumber type = "number"
                                maxFractionDigits = "3" value = "${cost.getSotien()}"/>đ</td>
         				<td><a href="${pageContext.request.contextPath}/editCost/${cost.machiphi}/">Sửa</a></td>
         				<td><a href="${pageContext.request.contextPath}/deleteCost/${cost.machiphi}">Xóa</a></td>
         			</tr>
         		</c:forEach>
         	</tbody>
         </table>
     </div>
 </body>