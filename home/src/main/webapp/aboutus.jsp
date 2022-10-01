<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>${SYSTEM.systemName}-關於我們</title>
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

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">

</head>
<%--Header --%>
<jsp:include page="fragment/menu_content.jsp" />

<!-- 內容開始  -->
<section class="site-section" id="agents-section">
	<div class="container  text-center">
		<h2 class="section-title mb-3">提供服務</h2>
		<p class="lead">
			山水苑致力於提供租客更完善與優化的線上租屋服務，<br>預約、入住、退租流程輕量無紙化，環保愛地球。
		</p>
		<p class="lead">
			首個找室友『聊聊』功能，提供相互對話瞭解的場域，<br>跨越時間、空間的物理限制，讓合租輕鬆簡單無負擔。
		</p>
	</div>


	<div class="row">

		<div class="col-md-6 col-lg-4 mb-4">
			<div class="team-member">
				<figure>
					<img src="images/computer_1.jpeg"
						alt="Free website template by Free-Template.co" class="img-fluid">
				</figure>
				<div class="p-3 bg-primary">
					<h3 class="mb-2">電子化個人通知</h3>
				</div>
			</div>
		</div>

		<div class="col-md-6 col-lg-4 mb-4">
			<div class="team-member">
				<figure>
					<img src="images/repairorder_1.jpeg"
						alt="Free website template by Free-Template.co" class="img-fluid">
				</figure>
				<div class="p-3 bg-primary">
					<h3 class="mb-2">線上管理報修流程</h3>
				</div>
			</div>
		</div>

		<div class="col-md-6 col-lg-4 mb-4">
			<div class="team-member">
				<figure>
					<img src="images/room_2.jpeg"
						alt="Free website template by Free-Template.co" class="img-fluid">
				</figure>
				<div class="p-3 bg-primary">
					<h3 class="mb-2">個性簽名找室友</h3>
				</div>
			</div>
		</div>

	</div>
</section>

<section class="py-5 bg-primary site-section how-it-works"
	id="howitworks-section">
	<div class="container">
		<div class="row mb-5 justify-content-center">
			<div class="col-md-7 text-center">
				<h2 class="section-title mb-3 text-black">租屋流程</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 text-center">
				<div class="pr-5 first-step">
					<span class="text-black">01.</span> <span
						class="custom-icon flaticon-house text-black"></span>
					<h3 class="text-black">找室友/預約看房</h3>
				</div>
			</div>

			<div class="col-md-4 text-center">
				<div class="pr-5 second-step">
					<span class="text-black">02.</span> <span
						class="custom-icon flaticon-coin text-black"></span>
					<h3 class="text-dark">線下簽約</h3>
				</div>
			</div>

			<div class="col-md-4 text-center">
				<div class="pr-5">
					<span class="text-black">03.</span> <span
						class="custom-icon flaticon-home text-black"></span>
					<h3 class="text-dark">成為租客</h3>
				</div>
			</div>
		</div>
	</div>
</section>

<section class="site-section bg-light" id="services-section">
	<div class="container">
		<div class="row mb-5">
			<div class="col-12 text-center">
				<h2 class="section-title mb-3">FAQ</h2>
			</div>
		</div>
		<div class="row align-items-stretch">
			<div class="col-md-6 col-lg-4 mb-4 mb-lg-4" data-aos="fade-up">
				<div class="unit-4 d-flex">
					<div class="unit-4-icon mr-4">
						<span class="text-primary flaticon-house"></span>
					</div>
					<div>
						<h3>1.環境公設</h3>
						<p>本社區提供專用垃圾間、投幣式洗烘衣機、地下停車場。</p>
						<p>月租式車位，機車位 $100 /月，汽車位 $2000 /月。</p>
					</div>
				</div>
			</div>

			<div class="col-md-6 col-lg-4 mb-4 mb-lg-4" data-aos="fade-up"
				data-aos-delay="200">
				<div class="unit-4 d-flex">
					<div class="unit-4-icon mr-4">
						<span class="text-primary flaticon-home"></span>
					</div>
					<div>
						<h3>2.推薦室友</h3>
						<p>系統將依照您選擇『公開』的學校資訊、個性標籤、室友條件進行配對。</p>
						<p>雙方皆同意才能開啟聊聊對話框，若一方『婉拒』或『關閉』尋找室友，即解除聊聊關係。</p>
					</div>
				</div>
			</div>


			<div class="col-md-6 col-lg-4 mb-4 mb-lg-4" data-aos="fade-up"
				data-aos-delay="300">
				<div class="unit-4 d-flex">
					<div class="unit-4-icon mr-4">
						<span class="text-primary flaticon-flat"></span>
					</div>
					<div>
						<h3>3.租屋守則</h3>
						<p>本社區僅提供一年簽約制，退租時間固定於每年6/30。可入住日期分別為每月1、15日。</p>
						<p>退租之押金將於確認屋況並扣除相應之清潔費用後，轉帳至初始合約設定之退款帳戶。若未填寫，亦可於退租時領取現金。</p>
					</div>
				</div>
			</div>

		</div>
	</div>
</section>

<section class="site-section testimonial-wrap" id="testimonials-section">
	<div class="container">
		<div class="row mb-5">
			<div class="col-12 text-center">
				<h2 class="section-title mb-3">租客評價</h2>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6 mb-4">
				<div class="ftco-testimonial-1">
					<div class="ftco-testimonial-vcard d-flex align-items-center mb-4">
						<img src="images/avataricon/boy01.png"
							alt="Free website template by Free-Template.co"
							class="img-fluid mr-3">
						<div>
							<h3>流風</h3>
							<span>Customer</span>
						</div>
					</div>
					<div>
						<p>可以跟大家聊天成為朋友超棒的！附近有什麼新開的店都可以馬上知道，報修也超級方便。（學弟妹快來呀～</p>
					</div>
				</div>
			</div>
			<div class="col-md-6 mb-4">
				<div class="ftco-testimonial-1">
					<div class="ftco-testimonial-vcard d-flex align-items-center mb-4">
						<img src="images/avataricon/boy02.png"
							alt="Free website template by Free-Template.co"
							class="img-fluid mr-3">
						<div>
							<h3>綿羊</h3>
							<span>Customer</span>
						</div>
					</div>
					<div>
						<p>房東維修的很迅速，可以隨時看到進度。不用一直去煩管理員我的包裹到了沒哈哈。推推山水苑～～有沒有人要當我室友？（明年約約</p>
					</div>
				</div>
			</div>

			<div class="col-md-6 mb-4">
				<div class="ftco-testimonial-1">
					<div class="ftco-testimonial-vcard d-flex align-items-center mb-4">
						<img src="images/avatarImg/girl01.png"
							alt="Free website template by Free-Template.co"
							class="img-fluid mr-3">
						<div>
							<h3>山山</h3>
							<span>Customer</span>
						</div>
					</div>
					<div>
						<p>找室友功能超級好用，可以不用摸瞎或去校版問。真的救大命了啊～也有興趣或習慣可以開話題，不怕找錯人嗚嗚嗚～（超棒的！！！</p>
					</div>
				</div>
			</div>
			<div class="col-md-6 mb-4">
				<div class="ftco-testimonial-1">
					<div class="ftco-testimonial-vcard d-flex align-items-center mb-4">
						<img src="images/avatarImg/girl02.png"
							alt="Free website template by Free-Template.co"
							class="img-fluid mr-3">
						<div>
							<h3>無花果</h3>
							<span>Customer</span>
						</div>
					</div>
					<div>
						<p>房間很乾淨，環境也很安靜，第一次外宿但整體評價都很不錯，可以很快適應。租友們非常熱情，可以隨時知道附近有哪些新地方可以吃喝玩樂～</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<%--footer --%>
<jsp:include page="fragment/footer.jsp" />

<%--.site-wrap --%>
<a href="#top" class="gototop"><span class="icon-angle-double-up"></span></a>


<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.countdown.min.js"></script>
<script
	src="${pageContext.request.contextPath}/js/bootstrap-datepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
<script src="${pageContext.request.contextPath}/js/aos.js"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.fancybox.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.sticky.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>

</body>
</html>
