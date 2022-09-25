<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="bookingService"
  class="tw.edu.ntut.sce.java18.common.service.BookingService" />
<c:set var="subTitle" value="預約表單(booking form)" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
  href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet"
  href="http://jqueryui.com/resources/demos/style.css">
<script>
  $(function() {
    $(".datepicker").datepicker({
      minDate : +0,
      maxDate : "+14D",
      dateFormat : "yy-mm-dd"
    });
  });
</script>
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
                
                <td class="class${booker.bookerId}">
                <input type="hidden"name="bookDate" id="bookDate" value="${booker.bookDate}">
                  <input class="datepicker" type="text"
                   value=<c:out value='${booker.bookDate}'/>></td>
                  
                <td class="class${booker.bookerId}">
                <input type="hidden" name="preferTime" id="preferTime" value="${booker.preferTime}">
                  <select class="preferTime" size="1" name="preferTime">
                    <option selected="selected">${booker.preferTime}</option>
                    <option value="13:00-13:30">13:00-13:30</option>
                    <option value="13:30-14:00">13:30-14:00</option>
                    <option value="14:00-14:30">14:00-14:30</option>
                    <option value="14:30-15:00">14:30-15:00</option>
                    <option value="15:00-15:30">15:00-15:30</option>
                    <option value="15:30-16:00">15:30-16:00</option>
                    <option value="16:00-16:30">16:00-16:30</option>
                    <option value="16:30-17:00">16:30-17:00</option>
                </select></td>
                <td class="class${booker.bookerId}">${booker.bookerId}<input
                  type="hidden" name="bookerId" id="bookerId"
                  value="${booker.bookerId}">
                </td>
                <td class="class${booker.bookerId}">${booker.bookerName}</td>
                <td class="class${booker.bookerId}">${booker.bookerPhone}</td>
                <td class="class${booker.bookerId}">${booker.roomtype}</td>
                <td class="class${booker.bookerId}">${booker.preferFloor}</td>
                <td class="class${booker.bookerId}"><input type="hidden"
                  name="leadPerson" id="leadPerson" value="${booker.leadPerson}">
                  <input type="text" class="class${booker.bookerId}"
                  value=<c:out value='${booker.leadPerson}'/>></td>
                <td>
                <div class="submit class${booker.bookerId}">修改</div>
<!--                <input type="submit" -->
<%--                  class="submit class${booker.bookerId}" id="submit" value="修改"> --%>
<%--              <a type="submit"  href="DeleteBookServlet?bookerId=<c:out value='${booker.bookerId}' />">刪除</a> --%>
                </td>
              </tr>
            </c:forEach>
          </table>
        </c:otherwise>
      </c:choose>
      <br> <a href="../index.jsp">回首頁</a>
    </div>
  </Form>
</body>
<script type="text/javascript">
  const xx = document.querySelectorAll('.submit');
  for (let i = 0; i < xx.length; i++) {
//    console.log(xx[i].value);
    xx[i].addEventListener('click',function(e) {
              console.log(e.target);
              var t = e.target.className;
              console.log(e.target.parentNode.parentNode)
//              console.log(e.target.previousElementSibling
//                  + '-----------------------------');
              document.getElementById("bookerId").value = t.replace(/[^\d]/g, "");

              document.getElementById("preferTime").value = e.parentNode.parentNode.childNodes[1].childNodes[0];
//            document.getElementById("leadPerson").value = e.parentNode().parentNode().childNodes[0].childNodes[0].value;
              document.getElementById("leadPerson").value = e.previousElementSibling.value
              document.getElementById("bookDate").value = e.target.value;
                  

            });
  }
</script>
</html>