<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<div class="main-menu-area mg-tb-40">
		<div class="container">
			<div class="row">
				<ul class="nav nav-tabs notika-menu-wrap menu-it-icon-pro">
					<li><img
						src='<c:url value="/images/contractQueryImg/icon.png" ></c:url>'
						width="100" height="50"></li>
					<li><a href='<c:url value="/rent.jsp"/>'><i
							class="notika-icon notika-house"></i>房契管理</a></li>
					<li><a href='<c:url value="/Contract.do"/>'><i
							class="notika-icon notika-mail"></i>合約查詢</a></li>
					<li><a href="#Interface"><i
							class="notika-icon notika-edit"></i>行事曆</a></li>
					<li><a href='<c:url value="/bookinglist.jsp"/>'><i
							class="notika-icon notika-bar-chart"></i>預約管理</a></li>
					<li><a href='<c:url value="/lanlordRepairForm.jsp"/>'><i
							class="notika-icon notika-windows"></i>報修管理</a></li>
					<li><a href='<c:url value="/chatRoom.jsp"/>'><i
							class="notika-icon notika-form"></i>聊天室</a></li>
					<li><a href='<c:url value="/memberInfo.jsp"/>'><i
							class="notika-icon notika-support"></i>物業資訊</a></li>
					<c:if test="${ empty LoginOK }">
						<li><a href='<c:url value="/login/login.jsp"/>'><i
								class="notika-icon notika-app"></i>登入</a></li>
					</c:if>
					<c:if test="${! empty LoginOK }">
						<li><a href='<c:url value="/login/logout.jsp"/>'><i
								class="notika-icon notika-app"></i>登出</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</header>

<!-- Mobile Menu start -->

<div class="mobile-menu-area">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="mobile-menu">
					<nav id="dropdown">
						<ul class="mobile-menu-nav">
							<li><a data-toggle="collapse" data-target="#Charts"
								href='<c:url value="/rent.jsp"/>'>房契管理</a></li>
							<li><a data-toggle="collapse" data-target="#demoevent"
								href='<c:url value="/Contract.do"/>'>合約查詢</a></li>
							<li><a data-toggle="collapse" data-target="#democrou"
								href="#">行事曆</a></li>
							<li><a data-toggle="collapse" data-target="#demolibra"
								href='<c:url value="/bookinglist.jsp"/>'>預約管理</a></li>
							<li><a data-toggle="collapse" data-target="#demodepart"
								href='<c:url value="/lanlordRepairForm.jsp"/>'>報修管理</a></li>
							<li><a data-toggle="collapse" data-target="#demo"
								href='<c:url value="/chatRoom.jsp"/>'>聊天室</a></li>
							<li><a data-toggle="collapse"
								data-target="#Miscellaneousmob"
								href='<c:url value="/memberInfo.jsp"/>'>物業資訊</a></li>
							<c:if test="${ empty LoginOK }">
								<li><a data-toggle="collapse" data-target="#Pagemob"
									href='<c:url value="/login/login.jsp"/>'>登入</a></li>
							</c:if>
							<c:if test="${! empty LoginOK }">
								<li><a data-toggle="collapse" data-target="#Pagemob"
									href='<c:url value="/login/logout.jsp"/>'>登出</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Mobile Menu end -->