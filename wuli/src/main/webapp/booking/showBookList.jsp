<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="bookingService" class="tw.edu.ntut.sce.java18.common.service.BookingService" />
<c:set var="subTitle" value="預約表單(booking form)" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript">
function delBooking(bookerId) {
    //alert();
    var isDel = confirm("確定要刪除?")
    if(isDel){
        //要刪除
        location.href = "${pageContext.request.contextPath}/booking/booking.do?bookerId="+bookerId;
    }
}
</script>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/bookinglist.css'  type="text/css" />
<meta charset="UTF-8">
<title>${subTitle}</title>
</head>
<body>
<div id="showbooklist">
  <c:choose>
    <c:when test="${empty bookingService.allBookers}">
        目前尚未有任何預約<br>
    </c:when>
    <c:otherwise>
                               預約表單：<br>
      <table border='1'>
        <tr>
          <th width='300'>預約日期</th>
          <th width='240'>時間</th>
          <th width='140'>帳號</th>
          <th width='140'>姓名</th>
          <th width='300'>電話</th>
          <th width='150'>房型</th>
          <th width='180'>樓層偏好</th>
          <th width='140'>負責人</th>
          <th width='180'>編輯</th>
        </tr>
        <c:forEach var="booker" items="${bookingService.allBookers}">
          <tr align="center">
            <td>${booker.bookDate}</td>
            <td>${booker.preferTime}</td>
            <td>${booker.bookerId}</td>
            <td>${booker.bookerName}</td>
            <td>${booker.bookerPhone}</td>
            <td>${booker.roomtype}</td>
            <td>${booker.preferFloor}</td>
            <td>${booker.leadPerson}</td>
            <td><a href="/edit?id=<c:out value='${booker.bookerId}' />">修改</a>
             <a href="DeleteBookServlet?bookerId=<c:out value='${booker.bookerId}' />">刪除</a> </td>                    
          </tr>
        </c:forEach>
      </table>

    </c:otherwise>
  </c:choose>
       <br>
       <a  href="../index.jsp">回首頁</a>
  </div>

</body>
</html>