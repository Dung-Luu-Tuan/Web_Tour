<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
    <div align="center">
        <h2>Khách hàng mới</h2>
        <form:form action="saveNewCustomer" method="post" modelAttribute="customerAdd">
            <table border="0" cellpadding="5">
                <tr>
                    <td>Họ tên: </td>
                    <td><form:input path="hoten" /></td>
                </tr>
                <tr>
                    <td>Cmnd </td>
                    <td><form:input path="cmnd" /></td>
                </tr>
                <tr>
                    <td>Địa chỉ: </td>
                    <td><form:input path="diachi" /></td>
                </tr>
                <tr>
                    <td>Giới tính: </td>
                    <td><form:input path="gioitinh" /></td>
                </tr>
                <tr>
                     <td>Sđt: </td>
                     <td><form:input path="sdt" /></td>
                </tr>
                <tr>
                      <td>Quốc tịch: </td>
                      <td><form:input path="quoctich" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Lưu"></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>