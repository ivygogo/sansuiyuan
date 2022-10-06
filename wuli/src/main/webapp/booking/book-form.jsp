<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="bookingService"
  class="tw.edu.ntut.sce.java18.common.service.BookingService" />
<!DOCTYPE html>
<html lang="en">
<head>
<title>${SYSTEM.systemName}-預約表單</title>
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

<link rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
  crossorigin="anonymous">
<link rel="stylesheet"
  href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
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
body {
  font-family: Tahoma, Geneva, Verdana, sans-serif;
  background-color: #F6F8FA;
}

.btn-success {
  color: #fff;
  background-color: #37cfa2;
  border-color: #37cfa2;
}
</style>

<body>
  <%@include file="/fragment/menu_index.jsp"%>

  <section class="login-block">
    <div class="container mt-5 mb-5">
      <div
        class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5">

          <div class="card">
            <div class="card-body p-5">

              <c:choose>
                <c:when test="${user != null}">
                  <form action="book.do?action=update" method="post">
                </c:when>
                <c:otherwise>
                  <form action="book.do?action=insert" method="post">
                </c:otherwise>
              </c:choose>
              <caption>
                <h2>
                  <c:if test="${user != null}">
                                    編輯預約
                                </c:if>
                  <c:if test="${user == null}">
                                    新增預約
                                </c:if>
                </h2>
              </caption>

              <c:if test="${user != null}">
                <input type="hidden" class="bookerId"
                  value="<c:out value='${user.bookerId}'/>" />
              </c:if>

              <fieldset class="form-group">
                <label>帳號</label> <input type="text"
                  value="<c:out value='${user.bookerId}'/> " class="form-control"
                  name="bookerId" required="required" readonly="readonly">
              </fieldset>

              <fieldset class="form-group">
                <label>姓名</label> <input type="text"
                  value="<c:out value='${user.bookerName}' />"
                  class="form-control" name="bookerName">
              </fieldset>

              <fieldset class="form-group">
                <label>電話</label> <input type="text"
                  value="<c:out value='${user.bookerPhone}' />"
                  class="form-control" name="bookerPhone">
              </fieldset>

              <fieldset class="form-group">
                <label>預約日期</label> <input type="text" id="datepicker"
                  value="<c:out value='${user.bookDate}' />" class="form-control"
                  name="bookDate">
              </fieldset>

              <fieldset class="form-group">
                <label>預約時段</label> <select class="form-control"
                  name="preferTime" size="1" onChange="change()">
                  <option value="<c:out value='${user.preferTime}' />" selected><c:out
                      value='${user.preferTime}' /></option>
                  <option value="13:00-13:30">13:00-13:30</option>
                  <option value="13:30-14:00">13:30-14:00</option>
                  <option value="14:00-14:30">14:00-14:30</option>
                  <option value="14:30-15:00">14:30-15:00</option>
                  <option value="15:00-15:30">15:00-15:30</option>
                  <option value="15:30-16:00">15:30-16:00</option>
                  <option value="16:00-16:30">16:00-16:30</option>
                  <option value="16:30-17:00">16:30-17:00</option>
                </select>
              </fieldset>

              <fieldset class="form-group">
                <label>房型</label>
                <!--           <input type="text" -->
                <%--             value="<c:out value='${user.roomtype}' />" class="form-control" --%>
                <!--             name="roomtype"> -->

                <select class="form-control" name="roomtype" size="1"
                  onChange="change()">
                  <option value="<c:out value='${user.roomtype}' />" selected><c:out
                      value='${user.roomtype}' /></option>
                  <option value="單人房A">單人房A</option>
                  <option value="單人房B">單人房B</option>
                  <option value="單人房C">單人房C</option>
                  <option value="雙人房A">雙人房A</option>
                  <option value="雙人房B">雙人房B</option>
                  <option value="雙人房C">雙人房C</option>
                </select>
              </fieldset>

              <fieldset class="form-group">
                <label>偏好樓層</label> <select name="preferFloor"
                  class="form-control" size="1" onChange="change()">
                  <option value="<c:out value='${user.preferFloor}'/>" selected><c:out
                      value='${user.preferFloor}' /></option>
                  <option value="低樓層">低樓層</option>
                  <option value="中樓層">中樓層</option>
                  <option value="高樓層">高樓層</option>
                  <option value="無意見">無意見</option>
                </select>
              </fieldset>

              <fieldset class="form-group">
                <label>負責人</label> <input type="text"
                  value="<c:out value='${user.leadPerson}' />"
                  class="form-control" name="leadPerson">
              </fieldset>

              <br>
              <center>
                <button type="submit" class="btn btn-success btn-lg">Save</button>
              </center>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  <script type="text/javascript">
    $(function() {
      $("#datepicker").datepicker({
        minDate : +0,
        maxDate : "+14D",
        dateFormat : "yy-mm-dd"
      });
    });
  </script>

  <%@include file="/fragment/footer.jsp"%>

</body>
</html>