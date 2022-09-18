<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="bookingService" class="tw.edu.ntut.sce.java18.common.service.BookingService" />
<c:set var="subTitle" value="預約表單(booking form)" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%-- <link rel='stylesheet' href='${pageContext.request.contextPath}/css/bookinglist.css'  type="text/css" /> --%>
<meta charset="UTF-8">
<title>${subTitle}</title>
</head>
<body>
<Form action="UpdateBookServlet" method="post">
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
            <td class="class${booker.bookerId}">${booker.bookDate}</td>
            <td class="class${booker.bookerId}">
            
            <input type="hidden" name="preferTime" id="preferTime">
           <select class="preferTime" size="1">
          <option value="" selected="selected">${booker.preferTime}</option>
          <option value="13:00-13:30">13:00-13:30</option>
          <option value="13:30-14:00">13:30-14:00</option>
          <option value="14:00-14:30">14:00-14:30</option>
          <option value="14:30-15:00">14:30-15:00</option>
          <option value="15:00-15:30">15:00-15:30</option>
          <option value="15:30-16:00">15:30-16:00</option>
          <option value="16:00-16:30">16:00-16:30</option>
          <option value="16:30-17:00">16:30-17:00</option>
                  </select> 
            </td>
            <td class="class${booker.bookerId}">${booker.bookerId}
            <input type="hidden" name="bookerId" id="bookerId">
            
            </td>
            <td class="class${booker.bookerId}">${booker.bookerName}</td>
            <td class="class${booker.bookerId}">${booker.bookerPhone}</td>
            <td class="class${booker.bookerId}">${booker.roomtype}</td>
            <td class="class${booker.bookerId}">${booker.preferFloor}</td>
            <td class="class${booker.bookerId}">${booker.leadPerson}</td>
            <td>
            
             <input type="submit" id="submit" value="修改">
             
             <a type="submit" href="DeleteBookServlet?bookerId=<c:out value='${booker.bookerId}' />">刪除</a> </td>                    
          </tr>
        </c:forEach>
      </table>

    </c:otherwise>
  </c:choose>
       <br>
       <a  href="../index.jsp">回首頁</a>
  </div>
</Form>
</body>
<script type="text/javascript">
const xx =  document.querySelectorAll('.preferTime');
for (let i = 0; i < xx.length; i++) {
    console.log(i);
  xx[i].addEventListener('change', function(e) {
    console.log(e.target);
    var t = e.target.parentElement.className; 
//     console.log(parseInt(x));
    document.getElementById("bookerId").value = t.replace(/[^\d]/g, " ");
    document.getElementById("preferTime").value = e.target.value; 
    });
}
// .addEventListener(
//  'change',function(e){console.log(e)}
//  );
function modify(){
    document.getElementById("modifyForm").submit();
}
</script>
</html>