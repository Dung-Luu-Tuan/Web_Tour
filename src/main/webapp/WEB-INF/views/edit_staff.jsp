<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
    <div align="center">
        <h2>Chỉnh sửa nhân viên</h2>
        <form:form action="updateStaff" method="post" modelAttribute="staffEdit">
            <table border="0" cellpadding="5">
                <tr>
                    <td>Mã nhân viên: </td>
                        <td>${staffEdit.manhanvien}
                            <form:hidden path="manhanvien"/>
                        </td>
                </tr>
                <tr>
                    <td>Tên nhân viên: </td>
                    <td><form:input path="tennhanvien" /></td>
                </tr>
                <tr>
                    <td>Số điện thoại: </td>
                    <td><form:input path="sodienthoai" /></td>
                </tr>
                <tr>
                    <td>Địa chỉ: </td>
                    <td><form:input path="diachi" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Cập nhật"></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>