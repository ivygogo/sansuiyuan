<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--
////////////////////////////////////////////////////////////////

Author: Free-Template.co
Author URL: http://free-template.co.
License: https://creativecommons.org/licenses/by/3.0/
License URL: https://creativecommons.org/licenses/by/3.0/
Site License URL: https://free-template.co/template-license/
  
Website:  https://free-template.co
Facebook: https://www.facebook.com/FreeDashTemplate.co
Twitter:  https://twitter.com/Free_Templateco
RSS Feed: https://feeds.feedburner.com/Free-templateco

////////////////////////////////////////////////////////////////
-->
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

<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">

	<div class="site-wrap">

		<div class="site-mobile-menu site-navbar-target">
			<div class="site-mobile-menu-header">
				<div class="site-mobile-menu-close mt-3">
					<span class="icon-close2 js-menu-toggle"></span>
				</div>
			</div>
			<div class="site-mobile-menu-body"></div>
		</div>

		<!-- 選單 -->
		<jsp:include page="fragment/menu_index.jsp" />

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
									<a href="https://free-template.co" target="_blank"
										class="btn btn-primary px-5 py-3">瞭解更多</a>
								</p>

							</div>
						</div>
					</div>


				</div>
				<!--
      <div class="site-blocks-cover overlay overlay-2" style="background-image: url(images/55199.jpg);" data-aos="fade" id="home-section">
  
  
        <div class="container">
          <div class="row align-items-center justify-content-center">
            <div class="col-md-6 mt-lg-5 text-center">
              <h1 class="text-shadow">Find Your Perfect Property For Your Home</h1>
              <p class="mb-5 text-shadow">Free website template for Real Estate websites by the fine folks at <a href="https://free-template.co/" target="_blank">Free-Template.co</a>  </p>
              <p><a href="https://free-template.co" target="_blank" class="btn btn-primary px-5 py-3">Get Started</a></p>
              
            </div>
          </div>
        </div>
  -->

			</div>
		</div>

	</div>

	<!-- 瀏覽房型 -->
	<div class="site-section" id="properties-section">
		<div class="container">
			<!-- Title -->
			<div class="row mb-5 mt-5">
				<div class="col-md-7 text-left">
					<h2 class="section-title mb-3">瀏覽房型</h2>
					<p class="lead">Lorem ipsum dolor sit amet consectetur
						adipisicing elit. Minus minima neque tempora reiciendis.</p>
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
							<div class="meta mb-4">
								Allison Holmes <span class="mx-2">&bullet;</span> Jan 18, 2019<span
									class="mx-2">&bullet;</span> <a href="single.html">News</a>
							</div>
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


	<section class="site-section" id="agents-section">
		<div class="container">
			<div class="row mb-5">
				<div class="col-md-7 text-left">
					<h2 class="section-title mb-3">Real Estate Agents</h2>
					<p class="lead">Lorem ipsum dolor sit amet consectetur
						adipisicing elit. Minus minima neque tempora reiciendis.</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 col-lg-4 mb-4">
					<div class="team-member">
						<figure>
							<ul class="social">
								<li><a href="#"><span class="icon-facebook"></span></a></li>
								<li><a href="#"><span class="icon-twitter"></span></a></li>
								<li><a href="#"><span class="icon-linkedin"></span></a></li>
								<li><a href="#"><span class="icon-instagram"></span></a></li>
							</ul>
							<img src="images/person_1.jpg"
								alt="Free website template by Free-Template.co"
								class="img-fluid">
						</figure>
						<div class="p-3 bg-primary">
							<h3 class="mb-2">Allison Holmes</h3>
							<span class="position">Real Estate Agent</span>
						</div>
					</div>
				</div>

				<div class="col-md-6 col-lg-4 mb-4">
					<div class="team-member">
						<figure>
							<ul class="social">
								<li><a href="#"><span class="icon-facebook"></span></a></li>
								<li><a href="#"><span class="icon-twitter"></span></a></li>
								<li><a href="#"><span class="icon-linkedin"></span></a></li>
								<li><a href="#"><span class="icon-instagram"></span></a></li>
							</ul>
							<img src="images/person_2.jpg"
								alt="Free website template by Free-Template.co"
								class="img-fluid">
						</figure>
						<div class="p-3 bg-primary">
							<h3 class="mb-2">Dave Simpson</h3>
							<span class="position">Real Estate Agent</span>
						</div>
					</div>
				</div>

				<div class="col-md-6 col-lg-4 mb-4">
					<div class="team-member">
						<figure>
							<ul class="social">
								<li><a href="#"><span class="icon-facebook"></span></a></li>
								<li><a href="#"><span class="icon-twitter"></span></a></li>
								<li><a href="#"><span class="icon-linkedin"></span></a></li>
								<li><a href="#"><span class="icon-instagram"></span></a></li>
							</ul>
							<img src="images/person_3.jpg"
								alt="Free website template by Free-Template.co"
								class="img-fluid">
						</figure>
						<div class="p-3 bg-primary">
							<h3 class="mb-2">Ben Thompson</h3>
							<span class="position">Real Estate Agent</span>
						</div>
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



	<section class="site-section" id="about-section">
		<div class="container">

			<div class="row large-gutters">
				<div class="col-lg-6 mb-5">

					<div class="owl-carousel slide-one-item with-dots">
						<div>
							<img src="images/img_1.jpg"
								alt="Free website template by Free-Template.co"
								class="img-fluid">
						</div>
						<div>
							<img src="images/img_2.jpg"
								alt="Free website template by Free-Template.co"
								class="img-fluid">
						</div>
						<div>
							<img src="images/img_3.jpg"
								alt="Free website template by Free-Template.co"
								class="img-fluid">
						</div>
					</div>

				</div>
				<div class="col-lg-6 ml-auto">

					<h2 class="section-title mb-3">Warehouse Real Estate Template</h2>
					<p class="lead">Lorem ipsum dolor sit amet consectetur
						adipisicing elit.</p>
					<p>Est qui eos quasi ratione nostrum excepturi id recusandae
						fugit omnis ullam pariatur itaque nisi voluptas impedit Quo
						suscipit omnis iste velit maxime.</p>

					<ul class="list-unstyled ul-check success">
						<li>Placeat maxime animi minus</li>
						<li>Dolore qui placeat maxime</li>
						<li>Consectetur adipisicing</li>
						<li>Lorem ipsum dolor</li>
						<li>Placeat molestias animi</li>
					</ul>

					<p>
						<a href="#" class="btn btn-primary mr-2 mb-2">Learn More</a>
					</p>

				</div>
			</div>
		</div>
	</section>


	<jsp:include page="fragment/footer.jsp" />



	<!-- .site-wrap -->

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