<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
    <div align="center">
        <h2>Thêm loại hình mớir</h2>
        <form:form action="${pageContext.request.contextPath}/saveNewTypeTour" method="post" modelAttribute="typeTourAdd">
            <table border="0" cellpadding="5">
                <tr>
                    <td>Tên loại hình: </td>
                    <td><form:input path="tenloaihinh" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Lưu"></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>