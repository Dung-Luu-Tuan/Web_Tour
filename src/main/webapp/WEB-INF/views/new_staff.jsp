<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
    <div align="center">
        <h2>Nhân viên mới</h2>
        <form:form action="saveNewStaff" method="post" modelAttribute="staffAdd">
            <table border="0" cellpadding="5">
                <tr>
                    <td>Tên nhân viên: </td>
                    <td><form:input path="tennhanvien" /></td>
                </tr>
                <tr>
                    <td>Số điện thoại:  </td>
                    <td><form:input path="sodienthoai" /></td>
                </tr>
                <tr>
                    <td>Địa chỉ: </td>
                    <td><form:input path="diachi" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Lưu"></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>