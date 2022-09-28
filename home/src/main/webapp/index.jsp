<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>${SYSTEM.systemName}首頁</title>
<meta charset="utf-8">
<meta name="viewport"
  content="width=device-width, initial-scale=1, shrink-to-fit=no">

<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="author" content="Free-Template.co" />
<meta http-equiv="expires" content="0">
<link rel="shortcut icon" href="ftco-32x32.png">

<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,900|Oswald:300,400,700"
  rel="stylesheet">
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/fonts/icomoon/style.css">

<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/jquery-ui.css">
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/owl.carousel.min.css">
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/owl.theme.default.min.css">
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/owl.theme.default.min.css">

<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/jquery.fancybox.min.css">

<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/bootstrap-datepicker.css">

<link rel="stylesheet"
  href="${pageContext.request.contextPath}/fonts/flaticon/font/flaticon.css">

<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/aos.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.min.css">

</head>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script
  src="${pageContext.request.contextPath}/file/jquery.twzipcode.min.js"></script>
<script
  src="${pageContext.request.contextPath}/js/repairForm.js"></script>
</head>

    <%--選單--%>
    <jsp:include page="/fragment/menu_content.jsp" />

    <!-- banner -->
    <div class="site-block-wrap">
      <div class="owl-carousel with-dots">
        <div class="site-blocks-cover overlay overlay-2"
          style="background-image: url(images/55199.jpg);" data-aos="fade"
          id="home-section">
          <div class="container">
            <div class="row align-items-center justify-content-center">
              <div class="col-md-6 mt-lg-5 text-center">
                <h1 class="text-shadow">山水苑-租房首選</h1>
                <p class="mb-5 text-shadow">
                  淡江大學推薦之住宿之親善業者，提供學子優質租屋環境。<br> 座落地靈人傑的淡江大學周邊，步行5分鐘即可到達
                </p>
                <p>
                  <a href="aboutus.jsp" target="_blank"
                    class="btn btn-primary px-5 py-3">瞭解更多</a>
                </p>
              </div>
            </div>
          </div>
        </div>
    
      </div>
    </div>
  </div>
  <!-- 瀏覽房型 -->
  <section class="login-block">
  <div class="site-section" id="properties-section">
    <div class="container">
      <!-- Title -->
      <div class="row mb-5">
        <div class="col-md-12 text-center">
          <h2 class="section-title mb-3">瀏覽房型</h2>
        </div>
      </div>
      <div class="row large-gutters">
        <div class="col-md-6 col-lg-4 mb-5 mb-lg-5 ">
          <div class="ftco-media-1">
            <div class="ftco-media-1-inner">
              <a href="property-room1.html" class="d-inline-block mb-4"><img
                src="images/pp1.webp"
                alt="Free website template by Free-Template.co"
                class="img-fluid"></a>
              <div class="ftco-media-details">
                <h3>單人Ａ</h3>
                <p>無陽台｜單衣櫃</p>
                <strong>7800元／月</strong>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-6 col-lg-4 mb-5 mb-lg-5 ">
          <div class="ftco-media-1">
            <div class="ftco-media-1-inner">
              <a href="property-single.html" class="d-inline-block mb-4"><img
                src="images/pp1.webp"
                alt="Free website template by Free-Template.co"
                class="img-fluid"></a>
              <div class="ftco-media-details">
                <h3>單人B</h3>
                <p>無陽台｜單衣櫃</p>
                <strong>7800元／月</strong>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-6 col-lg-4 mb-5 mb-lg-5 ">
          <div class="ftco-media-1">
            <div class="ftco-media-1-inner">
              <a href="property-single.html" class="d-inline-block mb-4"><img
                src="images/pp1.webp"
                alt="Free website template by Free-Template.co"
                class="img-fluid"></a>
              <div class="ftco-media-details">
                <h3>單人Ｃ</h3>
                <p>無陽台｜單衣櫃</p>
                <strong>7800元／月</strong>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-6 col-lg-4 mb-5 mb-lg-5 ">
          <div class="ftco-media-1">
            <div class="ftco-media-1-inner">
              <a href="property-single.html" class="d-inline-block mb-4"><img
                src="images/pp1.webp"
                alt="Free website template by Free-Template.co"
                class="img-fluid"></a>
              <div class="ftco-media-details">
                <h3>雙人A</h3>
                <p>無陽台｜單衣櫃</p>
                <strong>7800元／月</strong>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-6 col-lg-4 mb-5 mb-lg-5 ">
          <div class="ftco-media-1">
            <div class="ftco-media-1-inner">
              <a href="property-single.html" class="d-inline-block mb-4"><img
                src="images/pp1.webp"
                alt="Free website template by Free-Template.co"
                class="img-fluid"></a>
              <div class="ftco-media-details">
                <h3>雙人B</h3>
                <p>無陽台｜單衣櫃</p>
                <strong>7800元／月</strong>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-6 col-lg-4 mb-5 mb-lg-5 ">
          <div class="ftco-media-1">
            <div class="ftco-media-1-inner">
              <a href="property-single.html" class="d-inline-block mb-4"><img
                src="images/pp1.webp"
                alt="Free website template by Free-Template.co"
                class="img-fluid"></a>
              <div class="ftco-media-details">
                <h3>HD17 19 Utica Ave.</h3>
                <p>New York - USA</p>
                <strong>$20,000,000</strong>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- 找室友 -->
  <section class="site-section" id="news-section">
    <div class="container">
      <div class="row mb-5">
        <div class="col-12 text-center">
          <h2 class="section-title mb-3">找室友</h2>
        </div>
      </div>
      <div class="row">
        <!-- 第一個 -->
        <div class="col-md-6 col-lg-3 mb-4 mb-lg-3">
          <div class="h-entry">
            <center>
              <a href="single.html"><img src="images/mother.webp"
                alt="Free website template by Free-Template.co"
                class="img-fluid"></a>
              <h2 class="font-size-regular">
                <a href="single.html" class="text-dark">鸚鵡/淡大</a>
              </h2>
            </center>
            <div class="meta mb-4">
              <center>
                <a href="single.html"> 晨型人 <span class="mx-0">｜</span> 不喜歡寵物<span
                  class="mx-0">｜</span> 愛聊天
                </a>
              </center>
              <font style="color: black"> 希望室友條件： </font>
              <ul style="list-style-type: decimal;">
                <li>限女性</li>
                <li>公費均分</li>
                <li>無寵物</li>
                <li>同校或同系</li>
              </ul>
            </div>
            <center>
              <p>
                <a href="https://free-template.co" target="_blank"
                  class="btn btn-primary px-2 py-2 ">看 看</a> <a
                  href="https://free-template.co" target="_blank"
                  class="btn btn-primary px-2 py-2 mx-3">聊 聊</a>
              </p>
            </center>
          </div>
        </div>
        <!-- 第２個 -->
        <div class="col-md-6 col-lg-3 mb-4 mb-lg-3">
          <div class="h-entry">
            <center>
              <a href="single.html"><img src="images/girl-2.webp"
                alt="Free website template by Free-Template.co"
                class="img-fluid"></a>
              <h2 class="font-size-regular">
                <a href="single.html" class="text-dark">鸚鵡/淡大</a>
              </h2>
            </center>
            <div class="meta mb-4">
              <center>
                <a href="single.html"> 晨型人 <span class="mx-0">｜</span> 不喜歡寵物<span
                  class="mx-0">｜</span> 愛聊天
                </a>
              </center>
              <font style="color: black"> 希望室友條件： </font>
              <ul style="list-style-type: decimal;">
                <li>限女性</li>
                <li>公費均分</li>
                <li>無寵物</li>
                <li>同校或同系</li>
              </ul>
            </div>
            <center>
              <p>
                <a href="https://free-template.co" target="_blank"
                  class="btn btn-primary px-2 py-2 ">看 看</a> <a
                  href="https://free-template.co" target="_blank"
                  class="btn btn-primary px-2 py-2 mx-3">聊 聊</a>
              </p>
            </center>
          </div>
        </div>
        <!-- 第3個 -->
        <div class="col-md-6 col-lg-3 mb-4 mb-lg-3">
          <div class="h-entry">
            <center>
              <a href="single.html"><img src="images/mother.webp"
                alt="Free website template by Free-Template.co"
                class="img-fluid"></a>
              <h2 class="font-size-regular">
                <a href="single.html" class="text-dark">鸚鵡/淡大</a>
              </h2>
            </center>
            <div class="meta mb-4">
              <center>
                <a href="single.html"> 晨型人 <span class="mx-0">｜</span> 不喜歡寵物<span
                  class="mx-0">｜</span> 愛聊天
                </a>
              </center>
              <font style="color: black"> 希望室友條件： </font>
              <ul style="list-style-type: decimal;">
                <li>限女性</li>
                <li>公費均分</li>
                <li>無寵物</li>
                <li>同校或同系</li>
              </ul>
            </div>
            <center>
              <p>
                <a href="https://free-template.co" target="_blank"
                  class="btn btn-primary px-2 py-2 ">看 看</a> <a
                  href="https://free-template.co" target="_blank"
                  class="btn btn-primary px-2 py-2 mx-3">聊 聊</a>
              </p>
            </center>
          </div>
        </div>
        <!-- 第4個 -->
        <div class="col-md-6 col-lg-3 mb-4 mb-lg-3">
          <div class="h-entry">
            <center>
              <a href="single.html"><img src="images/girl-2.webp"
                alt="Free website template by Free-Template.co"
                class="img-fluid"></a>
              <h2 class="font-size-regular">
                <a href="single.html" class="text-dark">心心/聖約翰</a>
              </h2>
            </center>
            <div class="meta mb-4">
              <center>
                <a href="single.html"> 晨型人 <span class="mx-0">｜</span> 不喜歡寵物<span
                  class="mx-0">｜</span> 愛聊天
                </a>
              </center>
              <font style="color: black"> 希望室友條件： </font>
              <ul style="list-style-type: decimal;">
                <li>限女性</li>
                <li>公費均分</li>
                <li>無寵物</li>
                <li>同校或同系</li>
              </ul>
            </div>
            <center>
              <p>
                <a href="https://free-template.co" target="_blank"
                  class="btn btn-primary px-2 py-2 ">看 看</a> <a
                  href="https://free-template.co" target="_blank"
                  class="btn btn-primary px-2 py-2 mx-3">聊 聊</a>
              </p>
            </center>
          </div>
        </div>
        <!-- 第5個 -->
        <div class="col-md-6 col-lg-3 mb-4 mb-lg-3">
          <div class="h-entry">
            <center>
              <a href="single.html"><img src="images/girl-2.webp"
                alt="Free website template by Free-Template.co"
                class="img-fluid"></a>
              <h2 class="font-size-regular">
                <a href="single.html" class="text-dark">鸚鵡/淡大</a>
              </h2>
            </center>
            <div class="meta mb-4">
              <center>
                <font style="color: black"> 晨型人 <span class="mx-0">｜</span>
                  不喜歡寵物<span class="mx-0">｜</span> 愛聊天 </a>
                </font>
              </center>
              <a href="single.html"> 希望室友條件： </a><br>限女性、公費均分、無寵物
            </div>
            <center>
              <p>
                <a href="https://free-template.co" target="_blank"
                  class="btn btn-primary px-2 py-2 ">看 看</a> <a
                  href="https://free-template.co" target="_blank"
                  class="btn btn-primary px-2 py-2 mx-3">聊 聊</a>
              </p>
            </center>
          </div>
        </div>
        <!-- 第6個 -->
        <div class="col-md-6 col-lg-3 mb-4 mb-lg-3">
          <div class="h-entry">
            <center>
              <a href="single.html"><img src="images/girl.webp"
                alt="Free website template by Free-Template.co"
                class="img-fluid"></a>
              <h2 class="font-size-regular">
                <a href="single.html" class="text-dark">鸚鵡/淡大</a>
              </h2>
            </center>
            <div class="meta mb-4">
              <center>
                <font style="color: black"> 晨型人 <span class="mx-0">｜</span>
                  不喜歡寵物<span class="mx-0">｜</span> 愛聊天 </a>
                </font>
              </center>
              <a href="single.html"> 希望室友條件： </a><br>限女性、公費均分、無寵物
            </div>
            <center>
              <p>
                <a href="https://free-template.co" target="_blank"
                  class="btn btn-primary px-2 py-2 ">看 看</a> <a
                  href="https://free-template.co" target="_blank"
                  class="btn btn-primary px-2 py-2 mx-3">聊 聊</a>
              </p>
            </center>
          </div>
        </div>
        <!-- 第7個 -->
        <div class="col-md-6 col-lg-3 mb-4 mb-lg-3">
          <div class="h-entry">
            <center>
              <a href="single.html"><img src="images/girl-2.webp"
                alt="Free website template by Free-Template.co"
                class="img-fluid"></a>
              <h2 class="font-size-regular">
                <a href="single.html" class="text-dark">鸚鵡/淡大</a>
              </h2>
            </center>
            <div class="meta mb-4">
              <center>
                <font style="color: black"> 晨型人 <span class="mx-0">｜</span>
                  不喜歡寵物<span class="mx-0">｜</span> 愛聊天 </a>
                </font>
              </center>
              <a href="single.html"> 希望室友條件： </a><br>限女性、公費均分、無寵物
            </div>
            <center>
              <p>
                <a href="https://free-template.co" target="_blank"
                  class="btn btn-primary px-2 py-2 ">看 看</a> <a
                  href="https://free-template.co" target="_blank"
                  class="btn btn-primary px-2 py-2 mx-3">聊 聊</a>
              </p>
            </center>
          </div>
        </div>
        <!-- 第8個 -->
        <div class="col-md-6 col-lg-3 mb-4 mb-lg-3">
          <div class="h-entry">
            <center>
              <a href="single.html"><img src="images/girl.webp"
                alt="Free website template by Free-Template.co"
                class="img-fluid"></a>
              <h2 class="font-size-regular">
                <a href="single.html" class="text-dark">鸚鵡/淡大</a>
              </h2>
            </center>
            <div class="meta mb-4">
              <center>
                <font style="color: black"> 晨型人 <span class="mx-0">｜</span>
                  不喜歡寵物<span class="mx-0">｜</span> 愛聊天 </a>
                </font>
              </center>
              <a href="single.html"> 希望室友條件： </a><br>限女性、公費均分、無寵物
            </div>
            <center>
              <p>
                <a href="https://free-template.co" target="_blank"
                  class="btn btn-primary px-2 py-2 ">看 看</a> <a
                  href="https://free-template.co" target="_blank"
                  class="btn btn-primary px-2 py-2 mx-3">聊 聊</a>
              </p>
            </center>
          </div>
        </div>
      </div>
    </div>
  </section>
 
  <section class="py-5 bg-primary site-section how-it-works"
    id="howitworks-section">
    <div class="container">
      <div class="row mb-1 justify-content-center">
        <div class="col-md-7 text-center">
          <h3 class="section-title mb-1 text-black">
            如需預約看房，請先登入會員。 <a href="https://free-template.co" target="_blank"
              class="btn btn-second px-2 py-2 ">立即登入</a>
          </h3>
        </div>
      </div>
      
    </div>
  </section>

   <%--footer --%>
  <jsp:include page="fragment/footer.jsp" />

  <%--.site-wrap --%>
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