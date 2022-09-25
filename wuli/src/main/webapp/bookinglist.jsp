<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="bookingService"
	class="tw.edu.ntut.sce.java18.common.service.BookingService" />
<html>

<head>
<title>預約後台管理</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>
	<!--         <form action="testServlet"> -->
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: green">
			<div>
				<a href="<%=request.getContextPath()%>/list" class="navbar-brand">
					預約後台管理 </a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Booking</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<div class="container">
			<h4 class="text-center">預約表單</h4>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">新增預約
				</a>
				<hr>
				<jsp:include page="searchBooking.jsp"></jsp:include>
			</div>

			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>預約日期</th>
						<th>時段</th>
						<th>帳號</th>
						<th>姓名</th>
						<th>電話</th>
						<th>房型</th>
						<th>樓層</th>
						<th>負責人</th>
						<th align="center">編輯/刪除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${bookingService.allBookers}">
						<tr>
							<td><c:out value="${user.bookDate}" /></td>
							<td><c:out value="${user.preferTime}" /></td>
							<td><c:out value="${user.bookerId}" /></td>
							<td><c:out value="${user.bookerName}" /></td>
							<td><c:out value="${user.bookerPhone}" /></td>
							<td><c:out value="${user.roomtype}" /></td>
							<td><c:out value="${user.preferFloor}" /></td>
							<td><c:out value="${user.leadPerson}" /></td>
							<td><a href="edit?id=<c:out value='${user.bookerId}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?bookerId=<c:out value='${user.bookerId}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
	<!--         </form> -->
	
	
<!-- 	-------------------------------搜尋ＢＡＲ----------------------------------------------- -->
	<h6 class="text-center">搜尋結果</h6>
	<div class="row">
	<div class="container">
	<table  class="table table-bordered">
<thead>
		<tr>
			<th>預約日期</th>
			<th>時段</th>
			<th>帳號</th>
			<th>姓名</th>
			<th>電話</th>
			<th>房型</th>
			<th>樓層</th>
			<th>負責人</th>
			<th align="center">編輯/刪除</th>

		</tr>
		<%

		  if (request.getAttribute("booklist") != null) {
		    ArrayList al = (ArrayList) request.getAttribute("booklist");
		    Iterator itr = al.iterator();

		    while (itr.hasNext()) {

		      ArrayList booklist = (ArrayList) itr.next();
		%>
		<tr >
			<td><%=booklist.get(1)%></td>
			<td><%=booklist.get(2)%></td>
			<td><%=booklist.get(0)%></td>
			<td><%=booklist.get(3)%></td>
			<td><%=booklist.get(4)%></td>
			<td><%=booklist.get(5)%></td>
			<td><%=booklist.get(6)%></td>
			<td><%=booklist.get(7)%></td>
			<td><a href="edit?id=<c:out value='<%=booklist.get(0)%>' />">Edit</a>
				&nbsp;&nbsp;&nbsp;&nbsp; <a
				href="delete?bookerId=<c:out value='<%=booklist.get(0)%>' />">Delete</a></td>
		</tr>
		<%
		}
		  }
		%>
</thead>
	</table>
	</div>
	</div>
</body>
</html>