<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
    <div align="center">
        <h2>Chỉnh sửa các loại chi phí</h2>
        <form:form action="updateTypeCost" method="post" modelAttribute="typeCostEdit">
            <table border="0" cellpadding="5">
                <tr>
                    <td>Mã loại chi phí: </td>
                        <td>${typeCostEdit.maloaichiphi}
                            <form:hidden path="maloaichiphi"/>
                        </td>
                </tr>
                <tr>
                    <td>Tên loại chi phí: </td>
                    <td><form:input path="tenchiphi" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Cập nhật"></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>