<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/bookinglist.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>預約表單送出結果</title>
</head>
<body>
<div id="booklist">
親愛的 ${booker.name} 同學, 您好<P/>
恭喜您成功預約<P/>
${booker.roomType}，  
<c:choose>
   <c:when test="${empty booker.floor}" >
       您未挑選樓層
   </c:when>
   <c:otherwise >
       <c:forEach var="fruit" items="${booker.floor}"> 
          <c:out value="${floor}" />
       </c:forEach>的房型
   </c:otherwise>
</c:choose><P/>
您預約的時間為${booker.date}，
<c:choose>
   <c:when test="${empty booker.time}" ><!-- for:each -->
       您未挑選時段
   </c:when>
   <c:otherwise >
       <c:forEach var="fruit" items="${booker.time}"> 
          <c:out value="${time}" />
       </c:forEach>
   </c:otherwise>
</c:choose><P/>
稍後將寄送通知信至信箱，再麻煩同學查收。<P/>
溫馨提醒：<P/>
<div id="memo">
1.需當天簽約，請攜帶身分證件前往。<P/>
2.如未能準時前往，請提前致電02-2626177或致聊聊系統取消預約。<P/>
期待您的到訪～
</div>
</div>
</body>
</html>