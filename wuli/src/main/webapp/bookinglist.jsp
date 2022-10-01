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
<style>
.bkground {
	background-color: #01c293;
	width: 100%;
	margin: auto;
}

.bluebutton {
	padding: 2px;
	background-color: #01c293;
	color: white;
}

.bluebutton:hover {
	color: blue;
	border: 2px solid blue;
	background-color: white;
}
</style>
<body>
	<%--<%@include file="header.jsp" %>--%>

	<!--  -------------------------------放header-------------------------------------------------->

	<form action="book.do" method="post">
		<header>
		<div style="position: relative;">
    <img src='<c:url value="/images/contractQueryImg/icon.jpg" ></c:url>'
      width="100" height="50">
    <div style="position: absolute; display: inline-block; right: 150px;">

    </div>
    <div style="position: absolute; right: 0; top: 0;">
      <img src='<c:url value="/images/contractQueryImg/user.png" ></c:url>'
        width="40" height="40">
      <p style="display: inline-block; letter-spacing: 1px;">山水苑 aaa111
        登出</p>
    </div>
  </div>

  <div style="position: relative;">
    <table class="bkground" >
      <tr>
        <td class="font">房契管理</td>
        <td><a href="Contract.do"
            class="nav-link">合約查詢</a></td>
        <td class="font"><a href="bookinglist.jsp"
            class="nav-link">看房預約</a></td>
        <td class="font">報修管理</td>
        <td class="font">討論區</td>
        <td class="font">聊天室</td>
        <td class="font">廣告管理</td>
        <td class="font">行事曆</td>

      </tr>

    </table>
  </div>
		</header>
		<br>
		<div class="row">
			<div class="container">
				<h4 class="text-center">預約表單</h4>
				<hr>
				<div class="container text-left">

					<a href="book.do?action=new" class="btn btn-success" style="background-color:#01c293;">新增預約 </a>
					<hr>

				</div>

				<br>
				<div style="border:1px solid #01c293; border-radius:20px; border-width:2px; overflow: hidden;">
				<table class="table table-bordered">
					<tbody >
						<tr>
							<th style="width:11%">預約日期</th>
							<th style="width:11%">時段</th>
							<th style="width:8%">帳號</th>
							<th style="width:7%">姓名</th>
							<th style="width:10%">電話</th>
							<th style="width:8%">房型</th>
							<th style="width:7%">樓層</th>
							<th style="width:8%">負責人</th>
							<th align="center" style="width:14%">編輯/刪除</th>
						</tr>
					</tbody>
					</table>
					<div style="height:300px;overflow-y: auto;">
					 <table class="table table-bordered" style="">
					<tbody>
						<c:forEach var="user" items="${bookingService.allBookers}">
							<tr>
								<td style="width:12%"><c:out value="${user.bookDate}" /></td>
								<td style="width:12%"><c:out value="${user.preferTime}" /></td>
								<td style="width:8%"><c:out value="${user.bookerId}" /></td>
								<td style="width:7%"><c:out value="${user.bookerName}" /></td>
								<td style="width:11%"><c:out value="${user.bookerPhone}" /></td>
								<td style="width:10%"><c:out value="${user.roomtype}" /></td>
								<td style="width:8%"><c:out value="${user.preferFloor}" /></td>
								<td style="width:8%"><c:out value="${user.leadPerson}" /></td>
								<td style="width:15%">
								<a href="book.do?action=edit&id=<c:out value='${user.bookerId}'/>" class="btn btn-primary btn-sm" style="background-color:#01c293;">編輯</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="book.do?action=delete&id=<c:out value='${user.bookerId}' />" onClick="return confirm('確定刪除?');" class="btn btn-secondary btn-sm">刪除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>
				</div>
			</div>
		</div>
	</form>


	<!-- 	-------------------------------搜尋ＢＡＲ----------------------------------------------- -->
	<div class="container">
		<hr>
		<jsp:include page="/booking/searchBooking.jsp"></jsp:include>
	</div>
	
<!--   -----------------------------------顯示搜尋結果------------------------------------------- -->
	<h5 class="text-center">搜尋結果</h5>
	<div class="row">
		<div class="container">
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
					<%
					if (request.getAttribute("booklist") != null) {
					    ArrayList al = (ArrayList) request.getAttribute("booklist");
					    Iterator itr = al.iterator();
					    while (itr.hasNext()) {
					      ArrayList booklist = (ArrayList) itr.next();
					%>
					<tr>
						<td><%=booklist.get(1)%></td>
						<td><%=booklist.get(2)%></td>
						<td><%=booklist.get(0)%></td>
						<td><%=booklist.get(3)%></td>
						<td><%=booklist.get(4)%></td>
						<td><%=booklist.get(5)%></td>
						<td><%=booklist.get(6)%></td>
						<td><%=booklist.get(7)%></td>
						<td><a class="btn btn-primary btn-sm" style="background-color:#01c293;"
							href="book.do?action=edit&id=<c:out value='<%=booklist.get(0)%>'/>" >編輯</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a 
							href="book.do?action=delete&id=<c:out value='<%=booklist.get(0)%>'/>" onClick="return confirm('確定刪除?');" class="btn btn-secondary btn-sm">刪除</a></td>
					</tr>
					<%
					}
					  }
					%>
				</thead>
			</table>
		</div>
	</div>
<!-- 	<footer class="fixed-bottom"> -->
<!-- 		<div class="container" align="center"> -->
<!-- 			<a href="index.jsp">回首頁</a> -->
<!-- 		</div> -->
<!-- 	</footer> -->

	<!--  -------------------------------放footer-------------------------------------------------->

	<%--<%@include file="footer.jsp" %>--%>

</body>

</html>