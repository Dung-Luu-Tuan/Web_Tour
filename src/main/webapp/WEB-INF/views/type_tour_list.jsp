<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <body>
     <div align="center">
         <h1>Danh sách loại hình</h1>
         <h3><a href="${pageContext.request.contextPath}/newTypeTour">Thêm loại hình mới</a></h3>
         <table border="1"
         	style="width: 90%; border: 1px solid black">
         	<thead>
         		<tr style="background-color: skyblue">
         			<th style="text-align: center;">Mã loại hình</th>
                    <th style="text-align: center;">Tên loại hình</th>
         			<th></th>
         			<th></th>
         		</tr>
         	</thead>
         	<tbody align="center">
         		<c:forEach var="typeTour" items="${typeTours}" varStatus="status">
         			<tr>
         				<td>${typeTour.maloaihinh}</td>
                        <td>${typeTour.tenloaihinh}</td>
         				<td><a href="${pageContext.request.contextPath}/editTypeTour?id=${typeTour.maloaihinh}">Sửa</a></td>
         				<td><a href="${pageContext.request.contextPath}/deleteTypeTour/${typeTour.maloaihinh}">Xóa</a></td>
         			</tr>
         		</c:forEach>
         	</tbody>
         </table>
     </div>
 </body>