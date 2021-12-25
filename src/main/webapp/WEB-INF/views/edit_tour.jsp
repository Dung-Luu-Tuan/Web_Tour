<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
    <div align="center">
        <h2>Chỉnh sửa tour du lịch</h2>
        <form:form action="updateTour" method="post" modelAttribute="tourEdit">
            <table border="0" cellpadding="5">
                <tr>
                    <td>Mã tour: </td>
                        <td>${tourEdit.matour}
                            <form:hidden path="matour"/>
                        </td>
                </tr>
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
                    <td colspan="2"><input type="submit" value="Cập nhật"></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>