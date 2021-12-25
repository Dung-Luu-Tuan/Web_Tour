<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
    <div align="center">
        <h2>Thêm tour du lịch mới</h2>
        <form:form action="saveNewTour" method="post" modelAttribute="tourAdd">
            <table border="0" cellpadding="5">
                <tr>
                    <td>Tên tour: </td>
                    <td><form:input path="tengoi" /></td>
                </tr>
                <tr>
                    <td>Đặc điểm: </td>
                    <td><form:input path="dacdiem" /></td>
                </tr>
                <tr>
                    <td>Mã loại hình: </td>
                    <td><form:input path="maloaihinh" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Lưu"></td>
                </tr>
            </table>
        </form:form>
    </div>

    <div align="center">
                  <h1>Danh sách loại hình</h1>
                  <table border="1"
                  	style="width: 90%; border: 1px solid black">
                  	<thead>
                  		<tr style="background-color: skyblue">
                  			<th style="text-align: center;">Mã loại hình</th>
                             <th style="text-align: center;">Tên loại hình</th>
                  		</tr>
                  	</thead>
                  	<tbody align="center">
                  		<c:forEach var="typeTour" items="${typeTours}" varStatus="status">
                  			<tr>
                  				<td>${typeTour.maloaihinh}</td>
                                 <td>${typeTour.tenloaihinh}</td>
                  			</tr>
                  		</c:forEach>
                  	</tbody>
                  </table>
              </div>
</body>