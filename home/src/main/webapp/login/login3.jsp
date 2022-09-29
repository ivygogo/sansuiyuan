<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>${SYSTEM.systemName}-登入</title>
<meta charset="utf-8">
<meta name="viewport"
  content="width=device-width, initial-scale=1, shrink-to-fit=no">

<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="author" content="Free-Template.co" />
<meta http-equiv="expires" content="0">
<link rel="shortcut icon" href="ftco-32x32.png">

<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,900|Oswald:300,400,700"
  rel="stylesheet">
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/fonts/icomoon/style.css">

<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/jquery-ui.css">
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/owl.carousel.min.css">
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/owl.theme.default.min.css">
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/owl.theme.default.min.css">

<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/jquery.fancybox.min.css">

<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/bootstrap-datepicker.css">

<link rel="stylesheet"
  href="${pageContext.request.contextPath}/fonts/flaticon/font/flaticon.css">

<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/aos.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<%@include file="/fragment/menu_content.jsp" %>
<body>
<%--<!-- 下列敘述設定變數funcName的值為LOG，top.jsp 會用到此變數 -->--%>
<%--<c:set var="funcName" value="LOG" scope="session"/>--%>
<%--<c:set var="msg" value="登入" />--%>
<%--<c:if test="${ ! empty sessionScope.timeOut }" > <!-- 表示使用逾時，重新登入 -->--%>
<%--  <c:set var="msg" value="<font color='red'>${sessionScope.timeOut}</font>" />--%>
<%--</c:if>--%>
<%--<!-- 引入共同的頁首 -->--%>

    <section class="site-section bg-light bg-image" id="contact-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col-12 text-center">
            <h2 class="section-title mb-3">登入/註冊</h2>
          </div>
        </div>
        <div class="row">

          <div class="col-md-7 mb-5">

            <form action="#" class="p-5 bg-white">
              
              <h2 class="h4 text-black mb-5  text-center">會員登入</h2> 

              <div class="row form-group">
                
                <div class="col-md-12">
                  <label class="text-black" for="account number">帳號</label> 
                  <input type="email" id="email" class="form-control">
                </div>
              </div>

              <div class="row form-group">
                
                <div class="col-md-12">
                  <label class="text-black" for="password">密碼</label> 
                  <input type="subject" id="subject" class="form-control">
                </div>
              </div>

              <div class="col-md-12">
              
                
                <h6 class="text-black">
                <input type="checkbox" name="rememberMe" value="true">
                記住密碼</h6>
                
              </div>

              <div class="row form-group">
                <div class="col-md-12  text-center">
                  <input type="submit" value="登入" class="btn btn-primary btn-md text-white">
                </div>
              </div>

  
            </form>
          </div>
          <div class="col-md-5">
            
          </div>
        </div>
      </div>
    </section>

<Form action="/home/login/login.do" method="POST" name="loginForm">
  <div id='content'>
    <Table  style="border-width:2px; background:#E0E0E0; width: 500px;
                        border-style:inset; border-color:#EF02A4;">
      <TR>
        <TH width="180">&nbsp;</TH>
        <TH width="180">&nbsp;</TH>
      </TR>
      <TR>
        <TD colspan='2' align="CENTER" style="font-size:0.6cm;font-weight: 300;">
          <Font color="#006600" face="標楷體">
            ${AppName}
          </Font>
        </TD>
      </TR>
      <TR>
        <TD height='50' colspan='2' align="CENTER" style="font-size:0.5cm;font-weight: 300;">
          <Font color="#006600"  face="標楷體">
            ${msg}
          </Font>
        </TD>
      </TR>
      <TR height='10'>
        <TD align="CENTER" colspan='2'>&nbsp;</TD>
      </TR>
      <TR>
        <TD width="180" align="right">帳號：　</TD>
        <TD width="180" colspan='2' align="LEFT">
          <input  type="text" name="mail" size="10"
                  value="${requestScope.user}${param.userId}">

          &nbsp;<small><Font color='red' size="-3">${ErrorMsgKey.AccountEmptyError}
        </Font></small></TD>
      </TR>
      <TR>
        <TD width="180" align="right">密碼：　</TD>
        <TD width="180" colspan='2' align="LEFT" >
          <input  type="password" name="pswd"  size="10"
                  value="${requestScope.password}${param.pswd}">

          &nbsp;<small><Font color='red'  size="-3">${ErrorMsgKey.PasswordEmptyError}
        </Font></small></TD>

      </TR>
      <tr>
        <TD width="180" align="right" >
          <input type="checkbox" name="rememberMe"
          <c:if test='${requestScope.rememberMe==true}'>

                 checked='checked'
          </c:if>
                 value="true">
        </TD>
        <TD width="180"  colspan='2' align="left"><small>記住密碼</small></TD>
      </tr>
      <TR height='10'>
        <TD align="CENTER" colspan='2'>&nbsp;<Font color='red' size="-1">
          ${ErrorMsgKey.LoginError}&nbsp;</Font></TD>
      </TR>
      <TR>
        <TD colspan="2" align="center"><input type="submit" value="登入"> </TD>
      </TR>
      <TR height='10'>
        <TD align="CENTER" colspan='2'>&nbsp;</TD>
      </TR>
    </Table>
  </div>
</Form>

<script type="text/javascript">
  //由<body>的onLoad事件處理函數觸發此函數
  function setFocusToUserId(){
    document.forms[0].userId.focus();   // 將游標放在userId欄位內
  }
</script>

<%@include file="/fragment/footer.jsp" %>

 <%--.site-wrap --%>
  <a href="#top" class="gototop"><span class="icon-angle-double-up"></span></a>


  <script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
  <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
  <script
    src="${pageContext.request.contextPath}/js/jquery.countdown.min.js"></script>
  <script
    src="${pageContext.request.contextPath}/js/bootstrap-datepicker.min.js"></script>
  <script
    src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
  <script src="${pageContext.request.contextPath}/js/aos.js"></script>
  <script
    src="${pageContext.request.contextPath}/js/jquery.fancybox.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/jquery.sticky.js"></script>
  <script src="${pageContext.request.contextPath}/js/main.js"></script>
  
</body>
</html>
