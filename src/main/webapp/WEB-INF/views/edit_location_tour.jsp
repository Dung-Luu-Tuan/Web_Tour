<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
    <div align="center">
        <h2>Lộ trình mới</h2>
        <form:form action="${pageContext.request.contextPath}/updateTourLocation" method="post" modelAttribute="locationTourEdit">
            <table border="0" cellpadding="5">
                <tr>
                   <td>Mã tour: </td>
                     <td>${locationTourEdit.matour}
                         <form:hidden path="matour" />
                     </td>
                   </tr>
                <tr>
                    <td>Mã địa điểm: </td>
                    <td><form:input path="madiadiem" /></td>
                </tr>
                <tr>
                    <td>Thứ tự: ${locationTourEdit.thutu}</td>
                    <td><form:hidden path="thutu" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Cập nhật"></td>
                </tr>
            </table>
        </form:form>
    </div>

    <div align="center">
                 <h1>Địa điểm</h1>
                 <table border="1"
                 	style="width: 80%; height: 20%; border: 1px solid black; border-collapse: collapse;text-align: center;padding-bottom: 20px;">
                 	<thead>
                 		<tr style="background-color: skyblue">
                            <th style="text-align: center;">Mã địa điểm</th>
                            <th style="text-align: center;">Tên địa điểm</th>
                 		</tr>
                 	</thead>
                 	<tbody align="center">
                 		<c:forEach var="place" items="${places}" varStatus="status">
                 			<tr>
                                <td>${place.madiadiem}</td>
                                <td>${place.tendiadiem}</td>
                 			</tr>
                 		</c:forEach>
                 	</tbody>
                 </table>
             </div>
</body>