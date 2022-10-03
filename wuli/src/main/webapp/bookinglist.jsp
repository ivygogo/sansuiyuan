<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="bookingService"
  class="tw.edu.ntut.sce.java18.common.service.BookingService" />
<!DOCTYPE html>
<html lang="en">
<head>
<title>${SYSTEM.systemName}-聊天室</title>
<meta charset="utf-8">
<meta name="viewport"
  content="width=device-width, initial-scale=1, shrink-to-fit=no">

<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="author" content="Free-Template.co" />
<meta http-equiv="expires" content="0">
<!-- favicon
    ============================================ -->
<link rel="shortcut icon"
  type="${pageContext.request.contextPath}/image/x-icon"
  href="img/favicon.ico">
<!-- Google Fonts
            ============================================ -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900"
  rel="stylesheet">
<!-- Bootstrap CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/bootstrap.min.css">

<!-- owl.carousel CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/owl.carousel.css">
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/owl.theme.css">
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/owl.transitions.css">
<!-- meanmenu CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/meanmenu/meanmenu.min.css">
<!-- animate CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/animate.css">
<!-- summernote CSS
    ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/summernote/summernote.css">
<!-- Range Slider CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/themesaller-forms.css">

<!-- normalize CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/normalize.css">
<!-- mCustomScrollbar CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/scrollbar/jquery.mCustomScrollbar.min.css">
<!-- bootstrap select CSS
    ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/bootstrap-select/bootstrap-select.css">
<!-- datapicker CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/datapicker/datepicker3.css">
<!-- Color Picker CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/color-picker/farbtastic.css">
<!-- main CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/chosen/chosen.css">

<!-- notification CSS
    ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/notification/notification.css">
<!-- dropzone CSS
    ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/dropzone/dropzone.css">
<!-- jvectormap CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/jvectormap/jquery-jvectormap-2.0.3.css">
<!-- notika icon CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/notika-custom-icon.css">
<!-- wave CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/wave/waves.min.css">
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/wave/button.css">
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<!-- main CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/main.css">
<!-- style CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/style.css">
<!-- responsive CSS 
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/responsive.css">
<!-- modernizr JS
            ============================================ -->
<script
  src="${pageContext.request.contextPath}/js/vendor/modernizr-2.8.3.min.js"></script>
<!-- cropper CSS
    ============================================-->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/cropper/cropper.min.css">
<script type="text/javascript"
  src="${pageContext.request.contextPath}/file/jquery-2.1.1.min.js"></script>

<script type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment-with-locales.min.js"></script>
<script type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<script
  src="${pageContext.request.contextPath}/landlordRepairForm/landlordRepairForm.js"></script>
</head>
<style>
.bkground {
  background-color: #01c293;
  width: 100%;
  margin: auto;
}

.bluebutton:hover {
  color: blue;
  border: 2px solid blue;
  background-color: blue;
}

.btn-success {
  color: blue;
  background-color: #37cfa2;
  border-color: #37cfa2;
}
.bkground {
  background-color: #01c293;
  width: 100%;
  margin: auto;
}

.bluebutton {
  padding: 2px;
  background-color: #01c293;
  color: white;
}

.bluebutton:hover {
  color: blue;
  border: 2px solid blue;
  background-color: white;
}
</style>
<body>
<header>
<%@include file="fragment/menu_index.jsp" %>
</header>
  <!--  -------------------------------放header-------------------------------------------------->

  <form action="book.do" method="post">

    <div class="row">
      <div class="container">
        <h4 class="text-center">預約表單</h4>
        <hr>
        <div class="container text-left">

          <a href="book.do?action=new" class="btn btn-success" style="background-color:#01c293;">新增預約 </a>
          <hr>

        </div>

        <br>
        <div style="border:1px solid #01c293; border-radius:20px; border-width:2px; overflow: hidden;">
        <table class="table table-bordered">
          <tbody >
            <tr>
              <th style="width:11%">預約日期</th>
              <th style="width:11%">時段</th>
              <th style="width:8%">帳號</th>
              <th style="width:7%">姓名</th>
              <th style="width:10%">電話</th>
              <th style="width:8%">房型</th>
              <th style="width:7%">樓層</th>
              <th style="width:8%">負責人</th>
              <th align="center" style="width:14%">編輯/刪除</th>
            </tr>
          </tbody>
          </table>
          <div style="height:300px;overflow-y: auto;">
           <table class="table table-bordered" >
          <tbody>
            <c:forEach var="user" items="${bookingService.allBookers}">
              <tr>
                <td style="width:12%"><c:out value="${user.bookDate}" /></td>
                <td style="width:12%"><c:out value="${user.preferTime}" /></td>
<%--                 <td style="width:8%"><c:out value="${user.bookerId}" /></td> --%>
                <td style="width:7%"><c:out value="${user.bookerName}" /></td>
                <td style="width:11%"><c:out value="${user.bookerPhone}" /></td>
                <td style="width:10%"><c:out value="${user.roomtype}" /></td>
                <td style="width:8%"><c:out value="${user.preferFloor}" /></td>
                <td style="width:8%"><c:out value="${user.leadPerson}" /></td>
                <td style="width:15%">
                <a href="book.do?action=edit&id=<c:out value='${user.bookerId}'/>" class="btn btn-primary btn-sm" style="background-color:#01c293;">編輯</a>
                  &nbsp;&nbsp;&nbsp;&nbsp; <a
                  href="book.do?action=delete&id=<c:out value='${user.bookerId}' />" onClick="return confirm('確定刪除?');" class="btn btn-secondary btn-sm">刪除</a></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
        </div>
        </div>
      </div>
    </div>
  </form>


  <!--  -------------------------------搜尋ＢＡＲ----------------------------------------------- -->
  <div class="container">
    <hr>
    <jsp:include page="/booking/searchBooking.jsp"></jsp:include>
  </div>
  
<!--   -----------------------------------顯示搜尋結果------------------------------------------- -->
  <hr>
  <h5 class="text-center">搜尋結果</h5>
  <div class="row">
    <div class="container">
      <table class="table table-bordered">
        <thead>
          <tr>
            <th>預約日期</th>
            <th>時段</th>
<!--             <th>帳號</th> -->
            <th>姓名</th>
            <th>電話</th>
            <th>房型</th>
            <th>樓層</th>
            <th>負責人</th>
            <th align="center">編輯/刪除</th>
          </tr>
          <%
          if (request.getAttribute("booklist") != null) {
              ArrayList al = (ArrayList) request.getAttribute("booklist");
              Iterator itr = al.iterator();
              while (itr.hasNext()) {
                ArrayList booklist = (ArrayList) itr.next();
          %>
          <tr>
            <td><%=booklist.get(1)%></td>
            <td><%=booklist.get(2)%></td>
<%--             <td><%=booklist.get(0)%></td> --%>
            <td><%=booklist.get(3)%></td>
            <td><%=booklist.get(4)%></td>
            <td><%=booklist.get(5)%></td>
            <td><%=booklist.get(6)%></td>
            <td><%=booklist.get(7)%></td>
            <td><a class="btn btn-primary btn-sm" style="background-color:#01c293;"
              href="book.do?action=edit&id=<c:out value='<%=booklist.get(0)%>'/>" >編輯</a>
              &nbsp;&nbsp;&nbsp;&nbsp; <a 
              href="book.do?action=delete&id=<c:out value='<%=booklist.get(0)%>'/>" onClick="return confirm('確定刪除?');" class="btn btn-secondary btn-sm">刪除</a></td>
          </tr>
          <%
          }
            }
          %>
        </thead>
      </table>
    </div>
  </div>
<!--  <footer class="fixed-bottom"> -->
<!--    <div class="container" align="center"> -->
<!--      <a href="index.jsp">回首頁</a> -->
<!--    </div> -->
<!--  </footer> -->

  <!--  -------------------------------放footer-------------------------------------------------->

<%@include file="fragment/footer.jsp" %>

</body>

</html>