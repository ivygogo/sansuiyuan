<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>${SYSTEM.systemName}-登入</title>
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

<style>
.row {
	margin: auto;
}

.btn-primary {
	color: #fff;
	background-color: #00c292;
	border-color: #00c292;
}

.p-5 {
	padding: 3rem !important;
}

.card-body {
	-webkit-box-flex: 1;
	flex: 1 1 auto;
	padding: 1.25rem;
}
</style>

</head>
<%@include file="/fragment/menu_index.jsp"%>
<body>
	<%--<!-- 下列敘述設定變數funcName的值為LOG，top.jsp 會用到此變數 -->--%>
	<%--<c:set var="funcName" value="LOG" scope="session"/>--%>
	<%--<c:set var="msg" value="登入" />--%>
	<%--<c:if test="${ ! empty sessionScope.timeOut }" > <!-- 表示使用逾時，重新登入 -->--%>
	<%--  <c:set var="msg" value="<font color='red'>${sessionScope.timeOut}</font>" />--%>
	<%--</c:if>--%>
	<%--<!-- 引入共同的頁首 -->--%>
	<%-- <%@include file="/fragment/menu_content.jsp" %> --%>

	<section class="vh-100" style="margin-left: 27%;"> 
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-6 col-xl-5">
					<div class="card shadow-2-strong" style="border-radius: 1rem;">

						<div class="card-body p-5 text-center">

							<h3 class="mb-5">山水苑</h3>

							<form action="/wuli/login/login.do" method="POST"
								name="loginForm">
								<div class="form-outline mb-4">
									<label class="form-label h4">帳號：</label> <input type="email"
										name="mail" class="form-control form-control-lg" size="10"
										value="${requestScope.user}${param.mail}"> <small><Font
										color='red' size="-3">${ErrorMsgKey.AccountEmptyError}</Font></small>
								</div>

								<div class="form-outline mb-4">
									<label class="form-label h4">密碼：</label> <input type="password"
										name="pswd" class="form-control form-control-lg" size="10"
										value="${requestScope.password}${param.pswd}"> <small><Font
										color='red' size="-3">${ErrorMsgKey.PasswordEmptyError}</Font></small>
								</div>

								<div class="form-check d-flex justify-content-start mb-4">
									<input type="checkbox" class="form-check-input"
										name="rememberMe"
										<c:if test='${requestScope.rememberMe==true}'>
                       checked='checked'
                    </c:if>
										value="true"> <label class="form-check-label h4">
										<p>&nbsp;&nbsp;&nbsp;記住密碼</p>
									</label>
								</div>

								<div>
									<Font color='red' size="-1">
										${ErrorMsgKey.LoginError}&nbsp;</Font>
								</div>

								<input type="submit" value="登入"
									class="btn btn-primary btn-lg btn-block">
							</form>

							<hr class="my-4">


						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>

<script type="text/javascript">
	//由<body>的onLoad事件處理函數觸發此函數
	function setFocusToUserId() {
		document.forms[0].userId.focus(); // 將游標放在userId欄位內
	}
</script>
<%@include file="/fragment/footer.jsp"%>

<%--.site-wrap --%>
<a href="#top" class="gototop"><span class="icon-angle-double-up"></span></a>

<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script> --%>
<script src="${pageContext.request.contextPath}/js/aos.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>

</html>
