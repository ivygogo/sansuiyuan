<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/bookinglist.css'  type="text/css" />
<link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
  <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
  <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
  <link rel="stylesheet" href="jqueryui/style.css">
  <script>
  $(function() {
    $( "#datepicker" ).datepicker({ minDate: +0, maxDate: "+14D" });
  });
  </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>預約表單</title>
</head>
<body>
<div id="booklist">預約表單 
<Form Action="booking.do" method="POST">
      <p/>姓名: <input type="text" name="userName" value="系統帶入(會員登錄)">
      <p/>電話: <input type="text" name="tel" value="系統帶入(會員登錄)">
      <p/>信箱: <input type="text" name="eMail"   value="系統帶入(會員登錄)">
      <p/>房型: <input type="text" name="roomType"   value="系統帶入(房型瀏覽)">
      <P/>樓層: <select name="floor" size="1" id="floor" onChange="change()"> 
          <option value="0" selected> </option> 
          <option value="低樓層">低樓層</option> 
          <option value="中樓層">中樓層</option> 
          <option value="高樓層">高樓層</option> 
          <option value="無意見">無意見</option> 
                  </select> <P/>
      <p/>日期: <input id="datepicker" type="text" name="date">
      <P/>時段: <select id="time" name="time" size="1" id="time" onChange="change()"> 
          <option value="0" selected> </option> 
          <option value="13:00-13:30">13:00-13:30</option> 
          <option value="13:30-14:00">13:30-14:00</option> 
          <option value="14:00-14:30">14:00-14:30</option> 
          <option value="14:30-15:00">14:30-15:00</option> 
          <option value="15:00-15:30">15:00-15:30</option> 
          <option value="15:30-16:00">15:30-16:00</option> 
          <option value="16:00-16:30">16:00-16:30</option> 
          <option value="16:30-17:00">16:30-17:00</option> 
          
                  </select> <P/>
 
     
      <P/><input id="submit" type="submit" value="提交">
</Form>
<small>&lt;&lt;<a href="index.jsp">上一頁</a>&gt;&gt;</small>
</div>                   
</body>
</html>
