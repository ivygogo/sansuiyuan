<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% int n = (int) (Math.random() * 10) + 1; 
request.setAttribute("page", n);
%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>${SYSTEM.systemName}</title>
<meta charset="utf-8">
<meta name="viewport"
  content="width=device-width, initial-scale=1, shrink-to-fit=no">

<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="author" content="Free-Template.co" />

<link rel="shortcut icon" href="ftco-32x32.png">

<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,900|Oswald:300,400,700"
  rel="stylesheet">
<link rel="stylesheet" href="fonts/icomoon/style.css">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">

<link rel="stylesheet" href="css/jquery.fancybox.min.css">

<link rel="stylesheet" href="css/bootstrap-datepicker.css">

<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="<c:url value='css/style.css'/>">

</head>

<header class="site-navbar py-4 js-sticky-header site-navbar-target"
  role="banner">

  <div class="container">
    <div class="row align-items-center">

      <div class="col-6 col-xl-2">
        <h1 class="mb-0 site-logo m-0 p-0">
          <a href="index.jsp" class="mb-0">山水苑</a>
        </h1>
      </div>

      <div class="col-12 col-md-10 d-none d-xl-block">
        <nav class="site-navigation position-relative text-right"
          role="navigation">

          <ul
            class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
            <li><a href="#home-section" class="nav-link">關於我們</a></li>
            <li><a href="#home-section" class="nav-link">推廣商家</a></li>
            <li class="nav-item dropdown has-children dropdown arrow-top">
              <a class="nav-link " href="#" role="button"
              data-bs-toggle="dropdown" aria-expanded="false"> 房型瀏覽 </a>
              <ul class="dropdown ">
                <li><a class="dropdown-item" href="property-room1.html"
                  id="">房型１:單人Ａ</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#">房型2</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#">房型3</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#" id="">房型4:單人Ａ</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#">房型5</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#">房型6</a></li>
                <li><hr class="dropdown-divider"></li>
              </ul>

            </li>
            <li><a href="roommate.jsp" class="nav-link ">找室友</a></li>
            <li><a href="#about-section" class="nav-link">討論區</a></li>
            <c:if test="${empty LoginOK}">
              <li><a href="<c:url value="/MemberInfo.do?v=${page}"/>" class="nav-link">登入/註冊</a></li>
            </c:if>
            <c:if test="${! empty LoginOK }">
              <li class="nav-item dropdown has-children dropdown arrow-top">
              <a class="nav-link " href="#" role="button"
              data-bs-toggle="dropdown" aria-expanded="false">會員專區</a>
              <ul class="dropdown ">
                <li><a class="dropdown-item" href="<c:url value="/MemberInfo.do?v=${page}"/>"
                  id="">會員資料</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="<c:url value="repair.jsp?v=${page}"/>">報修管理</a></li>
                <li><hr class="dropdown-divider"></li>
                <li ><a class="dropdown-item" href="#">聊天室</a></li>
              </ul>
              </li>
            </c:if>
          </ul>
        </nav>
      </div>
      


      <div class="col-6 d-inline-block d-xl-none ml-md-0 py-3">
        <a href="#"
          class="site-menu-toggle js-menu-toggle text-white float-right"><span
          class="icon-menu h3"></span></a>
      </div>

    </div>
  </div>

</header>

  <a href="#top" class="gototop"><span class="icon-angle-double-up"></span></a>

  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.countdown.min.js"></script>
  <script src="js/bootstrap-datepicker.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.fancybox.min.js"></script>
  <script src="js/jquery.sticky.js"></script>


  <script src="js/main.js"></script>

</body>
</html>


