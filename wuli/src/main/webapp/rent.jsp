<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>${SYSTEM.systemName}-房契管理</title>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/file/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment-with-locales.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/landlordRepairForm/landlordRepairForm.js"></script>
</head>
<body>

<%@include file="fragment/menu_index.jsp" %>

<%@include file="/rent/rent.html" %>

<%@include file="fragment/footer.jsp" %>

</body>
</html>
