<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<jsp:useBean id="bookingService"
	class="tw.edu.ntut.sce.java18.common.service.BookingService" />
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
</head>

<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #01c293">
			<div>
				<a href="bookinglist.jsp" class="navbar-brand">
					User 預約後台管理系統 </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="bookinglist.jsp"
					class="nav-link">預約表單</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<c:choose>
					<c:when test="${user != null}">
					<form action="book.do?action=update" method="post"  >    
   </c:when>
					<c:otherwise>  
					<form action="book.do?action=insert" method="post" >
   </c:otherwise>
				</c:choose>
				<caption>
					<h2>
						<c:if test="${user != null}">
                                    編輯預約
                                </c:if>
						<c:if test="${user == null}">
                                    新增預約
                                </c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" class="bookerId"
						value="<c:out value='${user.bookerId}'/>" />
				</c:if>

				<fieldset class="form-group">
					<label>帳號</label> <input type="text"
						value="<c:out value='${user.bookerId}'/> " class="form-control"
						name="bookerId" required="required" readonly="readonly">
				</fieldset>

				<fieldset class="form-group">
					<label>姓名</label> <input type="text"
						value="<c:out value='${user.bookerName}' />" class="form-control"
						name="bookerName">
				</fieldset>

				<fieldset class="form-group">
					<label>電話</label> <input type="text"
						value="<c:out value='${user.bookerPhone}' />" class="form-control"
						name="bookerPhone">
				</fieldset>

				<fieldset class="form-group">
					<label>預約日期</label> <input type="text" id="datepicker"
						value="<c:out value='${user.bookDate}' />" class="form-control"
						name="bookDate">
				</fieldset>

				<fieldset class="form-group">
					<label>預約時段</label> <select class="form-control" name="preferTime"
						size="1" onChange="change()">
						<option value="<c:out value='${user.preferTime}' />" selected><c:out
								value='${user.preferTime}' /></option>
						<option value="13:00-13:30">13:00-13:30</option>
						<option value="13:30-14:00">13:30-14:00</option>
						<option value="14:00-14:30">14:00-14:30</option>
						<option value="14:30-15:00">14:30-15:00</option>
						<option value="15:00-15:30">15:00-15:30</option>
						<option value="15:30-16:00">15:30-16:00</option>
						<option value="16:00-16:30">16:00-16:30</option>
						<option value="16:30-17:00">16:30-17:00</option>
					</select>
				</fieldset>

				<fieldset class="form-group">
					<label>房型</label>
					<!--           <input type="text" -->
					<%--             value="<c:out value='${user.roomtype}' />" class="form-control" --%>
					<!--             name="roomtype"> -->

					<select class="form-control" name="roomtype" size="1"
						onChange="change()">
						<option value="<c:out value='${user.roomtype}' />" selected><c:out
								value='${user.roomtype}' /></option>
						<option value="單人房A">單人房A</option>
						<option value="單人房B">單人房B</option>
						<option value="單人房C">單人房C</option>
						<option value="雙人房A">雙人房A</option>
						<option value="雙人房B">雙人房B</option>
						<option value="雙人房C">雙人房C</option>
					</select>
				</fieldset>

				<fieldset class="form-group">
					<label>偏好樓層</label> <select name="preferFloor" class="form-control"
						size="1" onChange="change()">
						<option value="<c:out value='${user.preferFloor}'/>" selected><c:out
								value='${user.preferFloor}' /></option>
						<option value="低樓層">低樓層</option>
						<option value="中樓層">中樓層</option>
						<option value="高樓層">高樓層</option>
						<option value="無意見">無意見</option>
					</select>
				</fieldset>

				<fieldset class="form-group">
					<label>負責人</label> <input type="text"
						value="<c:out value='${user.leadPerson}' />" class="form-control"
						name="leadPerson">
				</fieldset>


				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
		$("#datepicker").datepicker({
			minDate : +0,
			maxDate : "+14D",
			dateFormat : "yy-mm-dd"
		});
	});
</script>
</html>