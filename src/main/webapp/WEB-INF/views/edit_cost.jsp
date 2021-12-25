<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
    <div align="center">
        <h2>Sửa chi phí</h2>
        <form:form action="${pageContext.request.contextPath}/updateCost" method="post" modelAttribute="costEdit">
            <table border="0" cellpadding="5">
                <tr>
                     <td>Mã chi phí : ${costEdit.machiphi}</td>
                     <td><form:hidden path="machiphi" value="${costEdit.machiphi}"/></td>
                </tr>
                <tr>
                    <td>Mã đoàn: ${costEdit.madoan}</td>
                    <td><form:hidden path="madoan" value="${costEdit.madoan}"/></td>
                </tr>
                <tr>
                    <td>Số tiền: </td>
                    <td><form:input path="sotien" /></td>
                </tr>
                <tr>
                    <td>Mã loại chi phí: </td>
                    <td><form:input path="maloaichiphi" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Cập nhật"></td>
                </tr>
            </table>
        </form:form>
    </div>

    <div align="center">
             <h1>Danh sách loại chi phí</h1>
             <table border="1"
             	style="width: 90%; border: 1px solid black">
             	<thead>
             		<tr style="background-color: skyblue">
             			<th style="text-align: center;">Mã loại chi phí</th>
                        <th style="text-align: center;">Tên loại chi phí</th>
             		</tr>
             	</thead>
             	<tbody align="center">
             		<c:forEach var="typeCost" items="${typeCosts}" varStatus="status">
             			<tr>
             				<td>${typeCost.maloaichiphi}</td>
                            <td>${typeCost.tenchiphi}</td>
             			</tr>
             		</c:forEach>
             	</tbody>
             </table>
         </div>
</body>