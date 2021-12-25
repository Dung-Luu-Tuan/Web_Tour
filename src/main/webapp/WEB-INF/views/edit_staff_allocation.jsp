<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
    <div align="center">
        <h2>Chỉnh sửa phân bổ nhân viên</h2>
        <form:form action="${pageContext.request.contextPath}/updateStaffAllocation" method="post" modelAttribute="staffAllocationEdit">
            <table border="0" cellpadding="5">
                <tr>
                     <td>Mã đoàn: ${idTourGroup}</td>
                     <td><form:hidden path="madoan" value="${idTourGroup}" /></td>
                </tr>
                <tr>
                    <td>Mã nhân viên: ${staffAllocationEdit.manhanvien}</td>
                    <td><form:hidden path="manhanvien" /></td>
                </tr>
                <tr>
                    <td>Nhiệm vụ: </td>
                    <td><form:input path="nhiemvu" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Cập nhật"></td>
                </tr>
            </table>
        </form:form>
    </div>

    <div align="center">
             <h1>Danh sách nhân viên</h1>
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
             			</tr>
             		</c:forEach>
             	</tbody>
             </table>
         </div>
</body>