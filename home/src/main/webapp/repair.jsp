<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% 
String ridState = request.getParameter("doJob");
System.out.println("ridState:::::"+ridState);
if(ridState == null || ridState.trim().length() == 0){
  request.setAttribute("doJob", "others");
}else{
  request.setAttribute("doJob", "getchat");
  //request.setAttribute("ridId", ridState);
}

%>


<!-- 
////////////////////////////////////////////////////////////////

Author: Free-Template.co
Author URL: http://free-template.co.
License: https://creativecommons.org/licenses/by/3.0/
License URL: https://creativecommons.org/licenses/by/3.0/
Site License URL: https://free-template.co/template-license/
  
Website:  https://free-template.co
Facebook: https://www.facebook.com/FreeDashTemplate.co
Twitter:  https://twitter.com/Free_Templateco
RSS Feed: https://feeds.feedburner.com/Free-templateco

////////////////////////////////////////////////////////////////
-->
<!DOCTYPE html>
<html lang="en">
<head>
<title>${SYSTEM.systemName}-我要報修</title>
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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.min.css">

</head>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script
  src="${pageContext.request.contextPath}/file/jquery.twzipcode.min.js"></script>
<script
  src="${pageContext.request.contextPath}/memberPage/repairForm.js"></script>

<script  type="text/javascript">


      innerPage ="";
      
      function updateRepairPage(i){
        //alert(i)
        if(i==0){
          $('#repairFormPage').html("");
          $('#repairFormPage').load('memberPage/insertRepairForm.jsp',function(){
            $('#newRepairBtn').hide();
          });
          
        }
        innerPage = "editRepairForminfo";
        $("html,body").animate(
                  {
                    scrollTop: 0,
                  },
                  600
                );
  }
     
      
      function dropForm(item){
        if((item.getAttribute('id'))==="memberInfo_dropIt"){
        
         document.location.href="/home/MemberInfo.do?edit=member"
         //alert("memberInfo_dropIt")
        }else if((item.getAttribute('id'))==="dropIt"){
          //alert("dropIt")
          document.location.href="/home/repair.jsp"
        }
       
      }
     </script>
</head>

<body data-spy="scroll" data-target=".site-navbar-target"
  data-offset="300" data-editpage="" data-isPass="${checkErr}">
  <div class="site-wrap">

    <div class="site-mobile-menu site-navbar-target">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>

    <%--選單--%>
    <jsp:include page="/fragment/menu_content.jsp" />


    <%--內容開始--%>
    <section class="login-block">
      <div class="container mt-5 mb-5">
        <%--標題--%>
        <div class="row mb-1 mt-5">
          <div class="col-md-7 text-left">
            <h2 class="section-title" id="myTitle">報修管理</h2>
          </div>


        </div>
        <div class="row mb-1 border-bottom ">
          <div class="col-md-10 text-left ">
            <p class="lead align-baseline">*溫馨提醒：維修時間為週一到五10:00-20:00</p>
          </div>
          
          
          <div class="col-md-2 text-left ">
            <button class="btn btn-repair" id="newRepairBtn"
              onclick="updateRepairPage(0)">新增維修單資訊</button>
          </div>
          
        </div>
        
        
  <div>
  
  <div class="row mt-4 border-bottom">
  <div class="col" id="repairFormPage">
    <c:choose>
    <c:when test='${FormInvalid=="insertRepairForm"}'>
    <jsp:include page="memberPage/validInsertRepairForm.jsp" />
    </c:when>
    <c:when test='${FormInvalid=="editRepairForm"}'>
    <jsp:include page="memberPage/validEditRepairForm.jsp" />
    </c:when>
    <c:when test='${doJob=="getchat"}'>
    <jsp:include page="memberPage/showRepairFormContent.jsp" />
    </c:when>
    
    <c:when test='${doJob=="other"}'>
    <jsp:include page="memberPage/listRepairForm.jsp" />
    </c:when>
    <%-- 
     <c:otherwise>
     <jsp:include page="memberPage/listRepairForm.jsp" />
     </c:otherwise>
    --%>
    </c:choose>
  
            <%-- table 開始 --%>
            
           

  </div>
  </div>
  </div>

      </div>
  </div>
  <%--"site-wrap" --%>
  </section>

  <%--footer --%>
  <jsp:include page="fragment/footer.jsp" />

  <%--.site-wrap --%>
  <a href="#top" class="gototop"><span class="icon-angle-double-up"></span></a>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.js"></script>
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
  <script>

  let ridState = `${doJob}`;
  //let ridId =`${ridId}`;
  
  

  if (ridState ==="getchat"){
    //alert("ridState" + ridState);
    $('#repairFormPage').html("");
      $('#repairFormPage').load('memberPage/showRepairFormContent.jsp', function() {
        showNewRepairForm(ridState);});
    
  }else{
	  
	  $('#repairFormPage').html("");
	  $('#repairFormPage').load('memberPage/listRepairForm.jsp', function() {
          showFirst();});
	  //var clock = setInterval( , 200);
      
	  //clearInterval(clock);
  }
  </script>
</body>
</html>
