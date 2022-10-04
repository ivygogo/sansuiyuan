<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>登出</title>
</head>
<body>
	<c:set var="memberName" value="${LoginOK.name}" />

	<c:remove var="LoginOK" scope="session" />

	<c:set var="funcName" value="OUT" scope="session" />

	<c:set var="logoutMessage" scope="request" />

	<font color='blue'><br> 訪客${ landlordInfoName }，感謝您使用本系統。<br>
		您已經登出<br> </font>

	<jsp:useBean id="logoutBean"
		class="tw.edu.ntut.sce.java18.landlord.model.LogoutBean" scope="page" />

	<c:set target="${logoutBean}" property="session"
		value="${pageContext.session}" />

	${logoutBean.logout}

	<c:redirect url="/index.jsp" />
</body>
</html>
