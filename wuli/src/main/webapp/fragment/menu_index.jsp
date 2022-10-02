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
					<li><a href='<c:url value="/login/login.jsp"/>'><i
							class="notika-icon notika-app"></i>登入</a></li>
				</ul>
			</div>
		</div>
	</div>
</header>