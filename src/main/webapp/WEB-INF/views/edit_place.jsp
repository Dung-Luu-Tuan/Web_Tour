<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
    <div align="center">
        <h2>Chỉnh sửa địa điểm</h2>
        <form:form action="updatePlace" method="post" modelAttribute="placeEdit">
            <table border="0" cellpadding="5">
                <tr>
                    <td>Mã địa điểm: </td>
                        <td>${placeEdit.madiadiem}
                            <form:hidden path="madiadiem"/>
                        </td>
                </tr>
                <tr>
                    <td>Tên địa điểm: </td>
                    <td><form:input path="tendiadiem" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Cập nhật"></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>