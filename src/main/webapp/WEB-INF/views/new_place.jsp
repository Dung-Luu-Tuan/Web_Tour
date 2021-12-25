<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
    <div align="center">
        <h2>Thêm địa điểm mới</h2>
        <form:form action="saveNewPlace" method="post" modelAttribute="placeAdd">
            <table border="0" cellpadding="5">
                <tr>
                    <td>Tên địa điểm: </td>
                    <td><form:input path="tendiadiem" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Lưu"></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>