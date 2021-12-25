<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
    <div align="center">
        <h2>Thêm đoàn du lịch mới</h2>
        <form:form action="${pageContext.request.contextPath}/saveNewTouristGroup" method="post" modelAttribute="touristGroupAdd">
            <table border="0" cellpadding="5">
                <tr>
                    <td>Mã tour: </td>
                    <td><form:input path="matour" /></td>
                </tr>
                <tr>
                    <td>Ngày khởi hành: </td>
                    <td><form:input type="date" path="ngaykhoihanh" /></td>
                </tr>
                <tr>
                    <td>Ngày kết thúc: </td>
                    <td><form:input type="date" path="ngayketthuc" /></td>
                </tr>
                <form:hidden value="0" path="doanhthu" />
                <tr>
                    <td colspan="2"><input type="submit" value="Lưu"></td>
                </tr>
            </table>
        </form:form>
    </div>

    <div align="center">
             <h1>Danh sách tour du lịch</h1>
             <table border="1"
             	style="width: 90%; border: 1px solid black">
             	<thead>
             		<tr style="background-color: skyblue">
             			<th style="text-align: center;">Mã tour</th>
                        <th style="text-align: center;">Tên tour</th>
                        <th style="text-align: center;">Mã loại hình</th>
                        <th style="text-align: center;">Đặc điểm</th>
                        <th style="text-align: center;"></th>
             		</tr>
             	</thead>
             	<tbody align="center">
             		<c:forEach var="tour" items="${tours}" varStatus="status">
             			<tr>
             				<td>${tour.matour}</td>
                            <td>${tour.tengoi}</td>
                            <td>${tour.maloaihinh}</td>
                            <td>${tour.dacdiem}</td>
                            <td><a href="${pageContext.request.contextPath}/getDetailTour/${tour.matour}"/>Detail</a></td>
             			</tr>
             		</c:forEach>
             	</tbody>
             </table>
         </div>

       <c:if test="${tourLocations.size() > 0}">
        <div align="center">
                 <h1>Lộ trình tour:  ${tourLocations.get(0).matour}</h1>
                 <table border="1"
                    style="width: 97%; height: 20%; border: 1px solid black; border-collapse: collapse;text-align: center;padding-bottom: 20px;">
                    <thead>
                        <tr style="background-color: skyblue">
                            <th style="text-align: center;">STT</th>
                            <th style="text-align: center;">Mã địa điểm</th>
                            <th style="text-align: center;">Tên địa điểm</th>
                        </tr>
                    </thead>
                    <tbody align="center">
                        <c:forEach var="location" items="${tourLocations}" varStatus="status">
                            <tr>
                                <td>${location.thutu}</td>
                                <td>${location.madiadiem}</td>
                                <td>${location.getPlace().getTendiadiem()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                 </table>
        </div>
     </c:if>

    <c:if test="${tourPrices.size() > 0}">
     <div align="center">
                   <h1>Bảng giá tour: ${tourPrices.get(0).matour}</h1>
                   <table border="1"
                   	style="width: 97%; height: 20%; border: 1px solid black; border-collapse: collapse;text-align: center;padding-bottom: 20px;">
                   	<thead>
                   		<tr style="background-color: skyblue">
                   			 <th style="text-align: center;">Mã giá</th>
                              <th style="text-align: center;">Thành tiền</th>
                              <th style="text-align: center;">Thời gian bắt đầu</th>
                              <th style="text-align: center;">Thời gian kết thúc</th>
                   		</tr>
                   	</thead>
                   	<tbody align="center">
                   		<c:forEach var="price" items="${tourPrices}" varStatus="status">
                   			<tr>
                   				 <td>${price.magia}</td>
                                  <td><fmt:formatNumber type = "number"
                                        maxFractionDigits = "3" value = "${price.thanhtien}" /></td>
                                  <td><fmt:formatDate pattern = "dd-MM-yyyy"
                                            value = "${price.dateStart}" /></td>
                                  <td><fmt:formatDate pattern = "dd-MM-yyyy"
                                            value = "${price.dateEnd}" /></td>
                   			</tr>
                   		</c:forEach>
                   	</tbody>
                   </table>
               </div>
     </c:if>
</body>