<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>${SYSTEM.systemName}-註冊</title>
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

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
</head>
<%@include file="/fragment/menu_content.jsp"%>
<body>
	<!-- 引入共同的頁首 -->
	<%--<jsp:include page="" />--%>
	<section class="vh-150" style="background-color: #37cfa2;">
		<div class="container py-5 h-100">
			<div class="row justify-content-center align-items-center h-100">
				<div class="col-12 col-lg-9 col-xl-7">
					<div class="card shadow-2-strong card-registration"
						style="border-radius: 15px;">
						<div class="card-body p-4 p-md-5">
							<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">會員註冊</h3>

							<form method="POST"
								action="<c:url value='/register/register.do' />">

								<div class="row">
									<div class="col-md-6 mb-4">

										<div class="form-outline">
											<label class="form-label">帳號(信箱)：</label> <input type="email"
												name='mail' value="${param.mail}"
												class="form-control form-control-lg" /> <font color="red"
												size="-1">${MsgMap.errorIdEmpty}${MsgMap.errorMailDup}</font>
										</div>

									</div>
									<div class="col-md-6 mb-4">

										<div class="form-outline">
											<h6 class="mb-2 pb-1">性別：</h6>

											<div class="form-check form-check-inline">
												<input class="form-check-input" type="radio" name='gender'
													value="0" checked /> <label class="form-check-label">男</label>
											</div>

											<div class="form-check form-check-inline">
												<input class="form-check-input" type="radio" name='gender'
													value="0" /> <label class="form-check-label">女</label>
											</div>

											<font color="red" size="-1">${MsgMap.errorGender}</font>
										</div>

									</div>
								</div>

								<div class="row">
									<div class="col-md-6 mb-4 d-flex align-items-center">

										<div class="form-outline datepicker w-100">
											<label class="form-label">密碼：</label> <input type="password"
												name='password' class="form-control form-control-lg" /> <font
												color="red" size="-1">${MsgMap.errorPasswordEmpty}${MsgMap.passwordError}</font>
											<div class="" style="display: flex; justify-content: center;">
												<small class="text mb-4" style="color: red;">請注意：<br>*密碼須由大寫字母、小寫字母、數字與
													!@#$%!^'" 組合，且長度不能小於八個字元
												</small>
											</div>
										</div>

									</div>
									<div class="col-md-6 mb-4">
										<div class="form-outline datepicker w-100">
											<label class="form-label">密碼確認：</label> <input
												type="password" name='password1'
												class="form-control form-control-lg" /> <font color="red"
												size="-1">${MsgMap.errorPassword1Empty}</font>
										</div>


									</div>
								</div>

								<div class="row">
									<div class="col-md-6 mb-4 pb-2">

										<div class="form-outline">
											<label class="form-label">姓名：</label> <input type="text"
												name='name' value="${param.name}"
												class="form-control form-control-lg" /> <font color="red"
												size="-1">${MsgMap.errorName}</font>
										</div>



									</div>
									<div class="col-md-6 mb-4 pb-2">

										<div class="form-outline">
											<label class="form-label">暱稱：</label> <input type="text"
												name='nickname' value="${param.nickName}"
												class="form-control form-control-lg" /> <font color="red"
												size="-1">${MsgMap.errorNickName}</font>
										</div>



									</div>
								</div>
								<div class="row">
									<div class="col-md-6 mb-4 pb-2">

										<div class="form-outline">
											<label class="form-label">電話：</label> <input type="text"
												name='phone' value="${param.tel}"
												class="form-control form-control-lg" /> <font color="red"
												size="-1">${MsgMap.errorTel}</font>
										</div>


									</div>
									<div class="col-md-6 mb-4 pb-2">

										<div class="form-outline">
											<label class="form-label">身分證字號：</label> <input type="text"
												name='Id_Number' value="${param.Id_Number}"
												class="form-control form-control-lg" /> <font color="red"
												size="-1">${MsgMap.errorId_Number}</font>
										</div>

									</div>
								</div>
								<div class="row">
									<div class="col-12">
										<label class="form-label">學校：</label> <input type="text"
											name='school' value="${param.school}"
											class="form-control form-control-lg" /> <font color="red"
											size="-1">${MsgMap.errorSchool}</font>

									</div>
								</div>
								<br>
								<div class="row">
									<div class="col-6">
										<label class="form-label">(縣/市)：</label> <input type="text"
											name='county' value="${param.county}"
											class="form-control form-control-lg" /> <font color="red"
											size="-1">${MsgMap.errorCounty}</font>

									</div>
									<div class="col-6">
										<label class="form-label">(鄉/鎮/區)：</label> <input type="text"
											name='district' value="${param.district}"
											class="form-control form-control-lg" /> <font color="red"
											size="-1">${MsgMap.errorDistrict}</font>

									</div>
								</div>
								<br>
								<div class="row">
									<div class="col-12">
										<label class="form-label">地址：</label> <input type="text"
											name='address' value="${param.address}"
											class="form-control form-control-lg" /> <font color="red"
											size="-1">${MsgMap.errorAddr}</font>

									</div>
								</div>

								<div class="mt-4 pt-2" align="center">
									<input type="reset" name="cancel" id="cancel" value="重填"
										class="btn btn-primary btn-lg" /> <input type="submit"
										name="submit" id="submit" value="註冊"
										class="btn btn-primary btn-lg" />
								</div>

							</form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		//由<body>的onLoad事件處理函數觸發此函數
		function setFocusToUserId() {
			document.forms[0].mid.focus(); // 將游標放在mid欄位內
		}
	<%--$(document).ready(function(){--%>
		
	<%--  <c:if test="${not empty registerSuccess}">--%>
		
	<%--    alert("${registerSuccess.registerSuccess}");--%>
		
	<%--  </c:if>--%>
		
	<%--});--%>
		
	</script>
	<%@include file="/fragment/footer.jsp"%>

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
	<script
		src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
	<script src="${pageContext.request.contextPath}/js/aos.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.fancybox.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.sticky.js"></script>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>

</body>
</html>