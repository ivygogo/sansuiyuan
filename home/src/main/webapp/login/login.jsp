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

<style>
p {
	margin-top: 6px;
	margin-bottom: 1px;
}
</style>

</head>
<%@include file="/fragment/menu_content.jsp"%>
<body>
	<%--<!-- 下列敘述設定變數funcName的值為LOG，top.jsp 會用到此變數 -->--%>
	<%--<c:set var="funcName" value="LOG" scope="session"/>--%>
	<%--<c:set var="msg" value="登入" />--%>
	<%--<c:if test="${ ! empty sessionScope.timeOut }" > <!-- 表示使用逾時，重新登入 -->--%>
	<%--  <c:set var="msg" value="<font color='red'>${sessionScope.timeOut}</font>" />--%>
	<%--</c:if>--%>
	<%--<!-- 引入共同的頁首 -->--%>
	<%-- <%@include file="/fragment/menu_content.jsp" %> --%>

	<section class="vh-100" style="background-color: #37cfa2;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-6 col-xl-5">
					<div class="card shadow-2-strong" style="border-radius: 1rem;">
						<div class="card-body p-5 text-center">

							<h3 class="mb-5">山水苑</h3>

							<form action="/home/login/login.do" method="POST"
								name="loginForm">
								<div class="form-outline mb-4">
									<label class="form-label h4">帳號：</label> <input type="email"
										name="mail" class="form-control form-control-lg" size="10"
										value="${requestScope.user}${param.userId}"> <small><Font
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

							<div>
								<p class="mb-0 h5">
									還沒有加入會員嗎？ <a href='<c:url value="/register/register.jsp"/>'
										class="text-blue-50 fw-bold">點此註冊</a>
								</p>
							</div>

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
