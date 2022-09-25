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
			style="background-color: tomato">
			<div>
				<a href="<%=request.getContextPath()%>/list" class="navbar-brand"> User
					預約後台管理系統 </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">預約表單</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

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

				<fieldset class="form-group" >
					<label>預約日期</label> <input type="text" id="datepicker"
						value="<c:out value='${user.bookDate}' />" class="form-control"
						name="bookDate">
				</fieldset>
				
				<fieldset class="form-group" >
          <label>預約時段</label> <input type="text" id="datepicker"
            value="<c:out value='${user.preferTime}' />" class="form-control"
            name="preferTime">
        </fieldset>
        
        <fieldset class="form-group" >
          <label>房型</label> <input type="text" id="datepicker"
            value="<c:out value='${user.roomtype}' />" class="form-control"
            name="roomtype">
        </fieldset>
        
				<fieldset class="form-group">
					<label>偏好樓層</label> <input type="text"
						value="<c:out value='${user.preferFloor}' />" class="form-control"
						name="preferFloor">
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
    $( "#datepicker" ).datepicker({ minDate: +0, maxDate: "+14D", dateFormat: "yy-mm-dd" });
  });
  </script>
</html>