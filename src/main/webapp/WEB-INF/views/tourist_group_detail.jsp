<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
    <div align="center">
        <h2>Chi tiết đoàn ${touristGroupId}</h2>

        <c:if test="${touristDetail.hanhtrinh != null && touristDetail.khachsan != null && touristDetail.khachsan != null}">
        <form:form action="${pageContext.request.contextPath}/updateTouristGroupDetail" method="post" modelAttribute="touristDetail">
            <table border="0" cellpadding="5">
                <form:hidden path="madoan" value="${touristDetail.madoan}" />
                <tr>
                    <td>Hành trình: </td>
                    <td><form:input type="text" path="hanhtrinh" value="${touristDetail.hanhtrinh}"/></td>
                </tr>
                <tr>
                    <td>Khách sạn: </td>
                    <td><form:input path="khachsan" value="${touristDetail.khachsan}"/></td>
                </tr>
                <tr>
                    <td>Địa điểm tham quan: </td>
                    <td><form:input path="diadiemthamquan" value="${touristDetail.diadiemthamquan}"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Cập nhật"></td>
                </tr>
            </table>
        </form:form>
        </c:if>
        <c:if test="${touristDetail.hanhtrinh == null}">
        <form:form action="${pageContext.request.contextPath}/saveTouristGroupDetail" method="post" modelAttribute="touristDetail">
                    <table border="0" cellpadding="5">
                        <tr>
                             <td>Mã đoàn: ${touristGroupId}</td>
                             <td><form:input path="madoan" value="${touristGroupId}"/></td>
                        </tr>
                        <tr>
                            <td>Hành trình: </td>
                            <td><form:input type="text" path="hanhtrinh" /></td>
                        </tr>
                        <tr>
                            <td>Khách sạn: </td>
                            <td><form:input path="khachsan" /></td>
                        </tr>
                        <tr>
                            <td>Địa điểm tham quan: </td>
                            <td><form:input path="diadiemthamquan" /></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" value="Lưu"></td>
                        </tr>
                    </table>
        </form:form>
        </c:if>
        <h2>Số lượng khách trong đoàn: ${cus_quantity}<h2>
        <h2>Giá tour / người : <fmt:formatNumber type = "number"
                                            maxFractionDigits = "3" value = "${price}" /> đ<h2>
        <h1>Doanh thu: <fmt:formatNumber type = "number"
             maxFractionDigits = "3" value = "${revenue}" /> đ</h1>
    </div>
</body>