<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>登入</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
  <style type="text/css">
    #main {
      position:relative;
      top: 50px;
      width:100%;
      text-align:center;
    }
    #content {
      width: 500px ;
      margin-left: auto ;
      margin-right: auto ;
    }
  </style>

</head>
<body onLoad="setFocusToUserId()" style="background:#EBFFEB;">
<%--<!-- 下列敘述設定變數funcName的值為LOG，top.jsp 會用到此變數 -->--%>
<%--<c:set var="funcName" value="LOG" scope="session"/>--%>
<%--<c:set var="msg" value="登入" />--%>
<%--<c:if test="${ ! empty sessionScope.timeOut }" > <!-- 表示使用逾時，重新登入 -->--%>
<%--  <c:set var="msg" value="<font color='red'>${sessionScope.timeOut}</font>" />--%>
<%--</c:if>--%>
<%--<!-- 引入共同的頁首 -->--%>
<%-- <%@include file="/fragment/menu_content.jsp" %> --%>

<section class="vh-100" style="background-color: #37cfa2;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card shadow-2-strong" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <h3 class="mb-5">山水苑</h3>

            <form action="/home/login/login.do" method="POST" name="loginForm">
              <div class="form-outline mb-4">
                <label class="form-label">帳號:</label>
                <input type="email" name="mail" class="form-control form-control-lg" size="10" value="${requestScope.user}${param.userId}">
                <small><Font color='red' size="-3">${ErrorMsgKey.AccountEmptyError}</Font></small>
              </div>

              <div class="form-outline mb-4">
                <label class="form-label">密碼:</label>
                <input  type="password" name="pswd" class="form-control form-control-lg" size="10" value="${requestScope.password}${param.pswd}">
                <small><Font color='red'  size="-3">${ErrorMsgKey.PasswordEmptyError}</Font></small>
              </div>

              <div class="form-check d-flex justify-content-start mb-4">
                <input type="checkbox" class="form-check-input" name="rememberMe"
                <c:if test='${requestScope.rememberMe==true}'>
                       checked='checked'
                </c:if>
                       value="true">
                <label class="form-check-label"> <small>記住密碼</small> </label>
              </div>

              <div><Font color='red' size="-1">
                ${ErrorMsgKey.LoginError}&nbsp;</Font></div>

              <input type="submit" value="登入" class="btn btn-primary btn-lg btn-block">
            </form>


            <hr class="my-4">

            <div>
              <p class="mb-0">還沒有會員嗎? <a href="../register/register.jsp" class="text-blue-50 fw-bold">點此加入</a>
              </p>
            </div>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
<script type="text/javascript">
  //由<body>的onLoad事件處理函數觸發此函數
  function setFocusToUserId(){
    document.forms[0].userId.focus();   // 將游標放在userId欄位內
  }
</script>
</html>
