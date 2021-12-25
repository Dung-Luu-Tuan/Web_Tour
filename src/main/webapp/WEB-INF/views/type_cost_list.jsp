<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <body>
     <div align="center">
         <h1>Danh sách loại chi phí</h1>
         <h3><a href="${pageContext.request.contextPath}/newTypeCost">Thêm loại chi phí mới</a></h3>
         <table border="1"
         	style="width: 90%; border: 1px solid black">
         	<thead>
         		<tr style="background-color: skyblue">
         			<th style="text-align: center;">Mã loại chi phí</th>
                    <th style="text-align: center;">Tên loại chi phí</th>
         			<th></th>
         			<th></th>
         		</tr>
         	</thead>
         	<tbody align="center">
         		<c:forEach var="typeCost" items="${typeCosts}" varStatus="status">
         			<tr>
         				<td>${typeCost.maloaichiphi}</td>
                        <td>${typeCost.tenchiphi}</td>
         				<td><a href="${pageContext.request.contextPath}/editTypeCost?id=${typeCost.maloaichiphi}">Sửa</a></td>
         				<td><a href="${pageContext.request.contextPath}/deleteTypeCost/${typeCost.maloaichiphi}">Xóa</a></td>
         			</tr>
         		</c:forEach>
         	</tbody>
         </table>
     </div>
 </body>