<%--
  Created by IntelliJ IDEA.
  User: pan
  Date: 2022/9/28
  Time: 上午 03:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>登出</title>
</head>
<body>
<!-- 先將使用者名稱取出 -->
<c:set var="memberName" value="${ LoginOK.name }" />
<!-- 移除放在session物件內的屬性物件 -->
<c:remove var="LoginOK" scope="session" />
<!-- 下列敘述設定變數funcName的值為OUT，top.jsp 會用到此變數 -->
<%--<c:set var="funcName" value="OUT" scope="session"/>--%>
<!-- 引入共同的頁首 -->
<jsp:include page="" />
<!-- 下列六行敘述設定登出後要顯示的感謝訊息 -->
<c:set var="logoutMessage" scope="request"/>
<font color='blue' ><BR>
  訪客${ memberName }，感謝您使用本系統。<BR>
  您已經登出<BR>
</font>

<jsp:useBean id='logoutBean' class='tw.edu.ntut.sce.java18.tenant.model.LogoutBean' scope='page' />

<c:set target='${logoutBean}'
       property='session'    value='${pageContext.session}'/>

${ logoutBean.logout }

<c:redirect url="/index.jsp"/>
</body>
</html>

