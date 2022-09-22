<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% 

String editState = request.getParameter("edit");
//System.out.println("editState:::::"+editState);
//System.out.print("editState"+editState);
if (editState!=null&&editState.equals("drop")){
request.setAttribute("guarantorIsInvalid", false);
request.setAttribute("isInvalid", false);
request.setAttribute("RefundIsInvalid", false);
}else if (editState!=null&&editState.equals("member")){
  session.setAttribute("myPage", "myinfo");
}else if (editState!=null&&editState.equals("dropIt")){
  session.setAttribute("myPage", "profile");
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
<title>${SYSTEM.systemName}-會員資料</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="author" content="Free-Template.co" />

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

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/file/jquery.twzipcode.min.js"></script>


<script type="text/javascript">
 var editPage ;
 var showPage ;
 var checkPass;
 var tabId;
 var innerPage ="";
      
      function doFirst(){
    	  checkPage = '${myPage}';
    	  //alert('checkPage!!!'+checkPage);
    	  
    	  //checkPage ='myinfo'
    	  checkTab ="#"+checkPage;
    	  checkTabT ="\'#"+checkPage+"\'";
    	  checkContentTab=checkTab+"-tab"
    	  checkAllTab= "#myTabs a[href=\" "+ checkTab + "\"]"
    	  checkPass ='${checkErr}';
    	  //alert('checkPage!!!'+checkPage);
    	  
    	  
    	  if (checkPage ==="myinfo"||checkPage.length==0){
    		  $("#home-tab").attr("class", 'nav-link active')
              $("#home-tab").attr("aria-selected", 'true')
              $('#home').attr('class', "tab-pane fade active show")
              $("#profile-tab").attr("class", 'nav-link')
              $('#profile').attr('class', "tab-pane fade")
              $("#profile-tab").attr("aria-selected", 'false')
            }
    	  
    	  if (checkPage ==="profile"){
             // $('#contact').show()
              $('#profile').attr('class', "tab-pane fade active show")
              $('#myTabs a[href="#profile"]').tab('show')
              $("#contact-tab").attr('class', "nav-link")
              $("#home-tab").attr("class", 'nav-link')
              $("#profile-tab").attr("class", 'nav-link active')
              //$("#contact-tab").attr('class', "nav-link active")
            }
    	  
    	  
          function updateMemberinfo(){
                  innerPage = "editMemberinfo";
                  //alert("editMemberinfo")
                  if(innerPage =="editMemberinfo"){
                     $('#myinfo').html("");
                     $('#myinfo').load('memberPage/editMemberInfo.jsp');
                  }
          }
          
          function updateContractinfo(){
            innerPage = "editContractinfo";
            if(innerPage =="editContractinfo"){
                  $('#profile').html("");
                  $('#profile').load('memberPage/editContractInfo.jsp');
                  }
      }
      }
      window.addEventListener('load', doFirst);
      
      $(function(){$('#profile-tab').click(function(){
    	  
    	   var qs = document.querySelector("form");
    	   //alert(qs)
    	   if(qs!=null){
    		   //alert(qs)
    		   var con;
           con=confirm("你確認要放棄未填寫完成的表單嗎?");
           if(con==true){
        	   checkPage = "profile"
                   $("#profile-tab").attr("class", 'nav-link active')
                     $("#profile-tab").attr("aria-selected", 'true')
                     $('#profile').attr('class', "tab-pane fade active show")
                     $("#home-tab").attr("class", 'nav-link')
                     $('#home').attr('class', "tab-pane fade")
                     $("#home-tab").attr("aria-selected", 'false')
                     $('#home').html("")
                    $('#home').load('memberPage/showMemberInfo.jsp?edit=drop')
               }
    	   }else{
    		   checkPage = "profile"
    	            $("#profile-tab").attr("class", 'nav-link active')
    	              $("#profile-tab").attr("aria-selected", 'true')
    	              $('#profile').attr('class', "tab-pane fade active show")
    	              $("#home-tab").attr("class", 'nav-link')
    	              $('#home').attr('class', "tab-pane fade")
    	              $("#home-tab").attr("aria-selected", 'false')
    	              
    	        }
    	   })
      })
      
      $(function(){$('#home-tab').click(function(){
    	  var qs = document.querySelector("form");
          //alert(qs)
          if(qs!=null){
            //alert(qs)
            var con;
            con=confirm("你確認要放棄未填寫完成的表單嗎?");
            if(con==true){
              checkPage = "myinfo"
            	  $("#home-tab").attr("class", 'nav-link active')
                  $("#home-tab").attr("aria-selected", 'true')
                  $('#home').attr('class', "tab-pane fade active show")
                  $("#profile-tab").attr("class", 'nav-link')
                  $('#profile').attr('class', "tab-pane fade")
                  $("#profile-tab").attr("aria-selected", 'false')
                      $('#profile').html("")
                     $('#profile').load('memberPage/showContractInfo.jsp?edit=drop')
                }
          }else{
          checkPage = "myinfo"
          //alert(checkPage)
            $("#home-tab").attr("class", 'nav-link active')
              $("#home-tab").attr("aria-selected", 'true')
              $('#home').attr('class', "tab-pane fade active show")
              $("#profile-tab").attr("class", 'nav-link')
              $('#profile').attr('class', "tab-pane fade")
              $("#profile-tab").attr("aria-selected", 'false')
              }
          
        })
      })
      
      innerPage ="";
      function updateMemberinfo(){
              innerPage = "editMemberinfo";
              //alert("editMemberinfo")
              if(innerPage =="editMemberinfo"){
                 $('#home').html("");
                 $('#home').load('memberPage/editMemberInfo.jsp');
                 $("#myName").focus()
              }
              $("html,body").animate(
                      {
                        scrollTop: 0,
                      },
                      600
                    );
      }
      
      function updateContractinfo(){
    	  innerPage = "editContractinfo";
    	  if(innerPage =="editContractinfo"){
              $('#profile').html("");
              $('#profile').load('memberPage/editContractInfo.jsp');
              }
    	  $("html,body").animate(
                  {
                    scrollTop: 0,
                  },
                  600
                );
  }
      
      
     function updateRefundinfo(){
          innerPage = "updateRefundinfo";
          if(innerPage =="updateRefundinfo"){
                $('#profile').html("");
                $('#profile').load('memberPage/editRefundInfo.jsp');
                }
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
    		  document.location.href="/home/MemberInfo.do?edit=dropIt"
    	  }
    	  
    	 //$('#home').html("")
       //$('#home').load('memberPage/showMemberInfo.jsp?edit=drop');
    	  //$('#profile').html("")
        //$('#profile').load('memberPage/showContractInfo.jsp?edit=drop');
    	  //document.location.href="/home/MemberInfo.do"
    		<%--$("html,body").animate(
        		    {
        		      scrollTop: 0,
        		    },
        		    600
        		  );
         //location.reload();--%>
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


		<%--內容開始--%>
		<section class="login-block">
			<div class="container mt-5 mb-5">
				<%--標題--%>
				<div class="row mb-1 mt-5">
					<div class="col-md-7 text-left">
						<h2 class="section-title mb-3" id="myTitle">會員專區 ${myPage}</h2>
						<p class="lead">親愛的會員您好，為確保您的權益，請定期更新及維護您的資料</p>
					</div>
				</div>

				<%--tabs--%>
				<ul class="nav nav-tabs" id="myTabs" role="tablist">
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="home-tab" data-bs-toggle="tab"
							data-bs-target="#home" type="button" role="tab"
							aria-controls="home" aria-selected="true" data-toggle=""
							data-target="">基本資訊</button>
					</li>
					<li class="nav-item mx-2" role="presentation"><button
							class="nav-link" id="profile-tab" data-bs-toggle="tab"
							data-bs-target="#profile" type="button" role="tab"
							aria-controls="profile" aria-selected="false" data-toggle=""
							data-target="">契約簽訂資訊</button></li>

				</ul>
				<div class="tab-content" id="myTabContent">
					<%--分頁1--%>
					<div class="tab-pane fade  " id="home" role="tabpanel"
						aria-labelledby="home-tab">

						<c:choose>
							<c:when test="${isInvalid==true}">
								<jsp:include page="memberPage/validMemberInfo.jsp" flush="true" />
							</c:when>
							<c:otherwise>
								<jsp:include page="memberPage/showMemberInfo.jsp" flush="true" />
							</c:otherwise>
						</c:choose>

					</div>
					<!--分頁2-->
					<div class="tab-pane fade" id="profile" role="tabpanel"
						aria-labelledby="profile-tab">
						<c:choose>
							<c:when test="${guarantorIsInvalid==true}">
								<jsp:include page="memberPage/validContractInfo.jsp"
									flush="true" />
								<%-- include file="memberPage/validMemberInfo.jsp" --%>
							</c:when>
							<c:when test="${RefundIsInvalid==true}">
								<jsp:include page="memberPage/validRefundInfo.jsp" flush="true" />
								<%-- include file="memberPage/validMemberInfo.jsp" --%>
							</c:when>
							<c:otherwise>
								<jsp:include page="memberPage/showContractInfo.jsp" flush="true" />
             ${checkErr}
             </c:otherwise>
						</c:choose>

					</div>

					<%--分頁3--%>
					<div class="tab-pane fade" id="contact" role="tabpanel"
						aria-labelledby="contact-tab"></div>

				</div>

			</div>
	</div>
	</section>


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
