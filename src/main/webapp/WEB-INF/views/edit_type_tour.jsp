<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
    <div align="center">
        <h2>Chỉnh sửa loại hình du lịch</h2>
        <form:form action="updateTypeTour" method="post" modelAttribute="typeTourEdit">
            <table border="0" cellpadding="5">
                <tr>
                    <td>Mã loại hình: </td>
                        <td>${typeTourEdit.maloaihinh}
                            <form:hidden path="maloaihinh"/>
                        </td>
                </tr>
                <tr>
                    <td>Tên loại hình: </td>
                    <td><form:input path="tenloaihinh" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Cập nhật"></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>