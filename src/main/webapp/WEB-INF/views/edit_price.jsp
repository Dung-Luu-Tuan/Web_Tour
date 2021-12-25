<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      <body>
          <div align="center">
              <h2>Giá tour mới</h2>
              <form:form action="${pageContext.request.contextPath}/updatePrice" method="post" modelAttribute="priceEdit">
                  <table border="0" cellpadding="5" >
                      <tr>
                         <td>Mã giá: </td>
                           <td>${priceEdit.magia}
                              <form:hidden path="magia"/>
                           </td>
                      </tr>
                      <tr>
                         <td>Mã tour: </td>
                           <td>${idTour}
                               <form:hidden path="matour" value="${idTour}"/>
                           </td>
                      </tr>
                      <tr>
                          <td>Thành tiền: </td>
                          <td><form:input path="thanhtien" /></td>
                      </tr>
                      <tr>
                           <td>Thời gian bắt đầu: </td>
                           <td><form:input type="date" path="dateStart" /></td>
                      </tr>
                      <tr>
                           <td>Thời gian kết thúc: </td>
                           <td><form:input type="date" path="dateEnd" /></td>
                      </tr>
                      <tr>
                          <td colspan="2"><input type="submit" value="Cập nhật"></td>
                      </tr>
                  </table>
              </form:form>
          </div>
      </body>