<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

		<header class="site-navbar py-4 js-sticky-header site-navbar-target"
			role="banner">

			<div class="container">
				<div class="row align-items-center">

					<div class="col-6 col-xl-2">
						<h1 class="mb-0 site-logo m-0 p-0">
							<a href='<c:url value="/index.jsp"/>' class="mb-0">${SYSTEM.systemName}</a>
						</h1>
					</div>

					<div class="col-12 col-md-10 d-none d-xl-block">
						<nav class="site-navigation position-relative text-right"
							role="navigation">

							<ul
								class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
								<li><a href='<c:url value="/aboutus.jsp"/>'
									class="nav-link">關於我們</a></li>

								<li class="nav-item dropdown has-children dropdown arrow-top">
									<a class="nav-link " href='<c:url value="/roomtype.jsp"/>'
									role="button" data-bs-toggle="dropdown" aria-expanded="false">房型瀏覽</a>
									<ul class="dropdown ">
										<li><a class="dropdown-item"
											href='<c:url value="/roomtype.jsp?type=A"/>'>單人A</a></li>
										<li><a class="dropdown-item"
											href='<c:url value="/roomtype.jsp?type=B"/>'>單人B</a></li>
										<li><a class="dropdown-item"
											href='<c:url value="/roomtype.jsp?type=C"/>'>單人C</a></li>
										<li><a class="dropdown-item"
											href='<c:url value="/roomtype.jsp?type=D"/>'>雙人A</a></li>
										<li><a class="dropdown-item"
											href='<c:url value="/roomtype.jsp?type=E"/>'>雙人B</a></li>
										<li><a class="dropdown-item"
											href='<c:url value="/roomtype.jsp?type=F"/>'>雙人C</a></li>
									</ul>
								</li>
								<li><a href='<c:url value="/findRoommate.jsp"/>'
									  class="nav-link">找室友</a></li>
								<c:if test="${! empty LoginOK }">
									<li><a href='<c:url value="/chatRoom.jsp"/>'
										class="nav-link">聊天室</a></li>
								</c:if>
								<c:if test="${ empty LoginOK }">
									<li><a href='<c:url value="/login/login.jsp"/>'
										class="nav-link">會員登入</a></li>
								</c:if>
								<c:if test="${! empty LoginOK }">
									<li><a href='<c:url value="/MemberInfo.do"/>'
										class="nav-link">會員專區</a></li>
								</c:if>
								<c:if test="${! empty LoginOK }">
									<li><a href='<c:url value="/repair.jsp"/>'
										class="nav-link">我要報修</a></li>
								</c:if>
								<c:if test="${! empty LoginOK }">
									<li><a href='<c:url value="/login/logout.jsp"/>'
										class="nav-link">會員登出</a></li>
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
	</div>
	<div class="site-blocks-cover inner-page-cover2 overlay2"
		style="background-image:url(${pageContext.request.contextPath}/images/white.png);"
		data-aos="fade"></div>