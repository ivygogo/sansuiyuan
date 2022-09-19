<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/bookinglist.css'  type="text/css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker" ).datepicker({ minDate: +0, maxDate: "+14D", dateFormat: "yy-mm-dd" });
//     $( "#datepicker" ).datepicker({ dateFormat: "yy-mm-dd" });
//     $( "#format" ).change(function() {
//       $( "#datepicker" ).datepicker( "option", "dateFormat", $( this ).val() );
//     });
  });
  </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>預約表單</title>
</head>
<body>
<div id="booklist">預約表單
<Form Action="booking.do" method="POST">
      <p/>姓名: <input type="text" name="bookerName" value="系統帶入(會員登錄)">
      <div style="color:#FF0000; font-size:x-small; display: inline">${ErrorMsg.bookerName}</div>
      <p/>帳號: <input type="text" name="bookerId" value="系統帶入(會員登錄)">
      <div style="color:#FF0000; font-size:x-small; display: inline">${ErrorMsg.bookerId}</div>
      <p/>電話: <input type="text" name="bookerPhone" value="系統帶入(會員登錄)">
      <div style="color:#FF0000; font-size:x-small; display: inline">${ErrorMsg.bookerPhone}</div>
      <p/>房型: <input type="text" name="roomtype"  id="booking-room-type" value="系統帶入(房型瀏覽)">
      <div style="color:#FF0000; font-size:x-small; display: inline">${ErrorMsg.roomtype}</div>
      <P/>樓層: <select name="preferFloor" size="1" id="preferFloor" onChange="change()">
          <option value="" selected> </option>
          <option value="低樓層">低樓層</option>
          <option value="中樓層">中樓層</option>
          <option value="高樓層">高樓層</option>
          <option value="無意見">無意見</option>
                  </select> <P/>
      <div style="color:#FF0000; font-size:x-small; display: inline">${ErrorMsg.preferFloor}</div>
      <p/>日期: <input id="datepicker" type="text" name="bookDate">
      <div style="color:#FF0000; font-size:x-small; display: inline">${ErrorMsg.bookDate}</div>
      <P/>時段: <select id="preferTime" name="preferTime" size="1"  onChange="change()">
          <option value="" selected> </option>
          <option value="13:00-13:30">13:00-13:30</option>
          <option value="13:30-14:00">13:30-14:00</option>
          <option value="14:00-14:30">14:00-14:30</option>
          <option value="14:30-15:00">14:30-15:00</option>
          <option value="15:00-15:30">15:00-15:30</option>
          <option value="15:30-16:00">15:30-16:00</option>
          <option value="16:00-16:30">16:00-16:30</option>
          <option value="16:30-17:00">16:30-17:00</option>
                  </select> 
      <div style="color:#FF0000; font-size:x-small; display: inline">${ErrorMsg.preferTime}</div>
                  <P/>
       <p>
<!--   <select id="format"> -->
<!--    <option value="mm/dd/yy">Default - mm/dd/yy</option> -->
<!--     <option value="yy-mm-dd">ISO 8601 - yy-mm-dd</option> -->
<!--   </select> -->
</p>

      <P/><input id="submit" type="submit" value="提交">
</Form>
<small>&lt;&lt;<a href="index.jsp">回首頁</a>&gt;&gt;</small>
</div>
</body>

<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<link rel="stylesheet" href="jqueryui/style.css">
<script>
  $(function () {
    $("#datepicker").datepicker({minDate: +0, maxDate: "+14D", dateFormat: 'yy-mm-dd'});
  });

  const userId = 5 // todo from登入資訊 $('')???

  $('#submit').click(function () {

    const selectTimePick = $('#preferTime').val()
    const selectFloor = $('#preferFloor').val()
    const selectDate = $('#datepicker').val()
    const selectUserName = $('#bookerName').val()
    const selectRoomType = $('#booking-room-type').val()

    $.ajax({
      type: 'POST',
      url: '/wuli/ChatroomServlet?callFrom=createChatroom',
      data: {
        'Id': userId,
        'chatTarget': 0,
        'chatType': 'B',
        'userName': selectUserName,
        'timePick': selectTimePick,
        'floor': selectFloor,
        'selectDate': selectDate,
        'roomType': selectRoomType
      },
      err: function () {
        console.log('createChatroom with error')
      }
    })
  })
</script>


</html>
