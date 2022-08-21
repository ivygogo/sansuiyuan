<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.google.gson.Gson"
	import="tw.edu.ntut.sce.java18.common.model.MemberBean"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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


<script>
 var editPage ;
 var showPage ;
 var checkPass;
 var tabId;
 
//console.log(${str});
      /*var triggerTabList = [].slice.call(document.querySelectorAll('#myTab a'))
      triggerTabList.forEach(function (triggerEl) {
        var tabTrigger = new bootstrap.Tab(triggerEl)
        console.log(tabTrigger);
        triggerEl.addEventListener('click', function (event) {
          event.preventDefault()
          console.log("hi");
          tabTrigger.show()
        })
      }) */   
      
      
      function doFirst(){
    	  checkPage = '${myPage}';
    	  checkTab ="#"+checkPage;
    	  checkTabT ="\'#"+checkPage+"\'";
    	  checkContentTab=checkTab+"-tab"
    	  checkAllTab= "#myTabs a[href=\" "+ checkTab + "\"]"
    	  checkPass ='${checkErr}';
    	  alert(checkPage);
    	  
    	  
    	  if (checkPage ==="contact"){
    		  //$('#contact').show()
    		  $('#contact').attr('class', "tab-pane fade active show")
    		  $('#myTabs a[href="#contact"]').tab('show')
    		  
    		  $("#home-tab").attr("class", 'nav-link')
    		  $("#profile-tab").attr("class", 'nav-link')
          $("#contact-tab").attr('class', "nav-link active")
    	  }
    	  
    	  if (checkPage ==="myinfo"){
              //$('#contact').show()
              $("#home-tab").attr("class", 'nav-link active')
              $('#myTabs a[href="#myinfo"]').tab('show')
              $('#myinfo').attr('class', "tab-pane fade active show")
              $("#profile-tab").attr("class", 'nav-link')
              $("#contact-tab").attr('class', "nav-link")
              //$("#contact-tab").attr('class', "nav-link active")
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
    	  
    	  
      }
      window.addEventListener('load', doFirst);
      
      
      
      
      /*
      $(function () {
      var isChange = false;
      num = 0;

          $("input").change(function (event) {
        	  event.stopPropagation()
        	  event.preventDefault()
              isChange = true;
              $(this).addClass("editing");
          });
          
          $("a").click(function(event){
        	  event.stopPropagation()
        	  event.preventDefault()
        	  alert(event.target.id);
        	  var con;
        	  con=confirm("你確認要放棄未填寫完成的表單嗎?"); //在頁面上彈出對話框
        	  if(con==true){
        		 if(num>0){
        			 $("a").attr("disabled", false);
        			 location.reload()
        		 }
        		  
        	  }
        	  else {
        		  $("a").attr("disabled", true);
        		  num++;
        	  }
        		  
          })*/
/*
          $(window).bind('beforeunload', function (e) {
              if (isChange || $(".editing").get().length > 0) {
                  return '★資料尚未存檔，確定是否要離開？★';
              }
          })
      });*/
      
      
      
      
      $(function(){
    	  $('#home-tab').click(function(){
    		   checkPass ='${checkErr}'
    		   clickid = event.target.id
    		   alert(clickid)
    			if(checkPass==1){
    				$("#home-tab").attr("class", 'nav-link active')
    	      $('#myTabs a[href="#myinfo"]').tab('show')
    	      $('#myinfo').attr('class', "tab-pane fade active show")
    	      $("#profile-tab").attr("class", 'nav-link')
    	      $("#contact-tab").attr('class', "nav-link")
    			} 
    		  if(checkPass==0){
    			  con=confirm("你確認要放棄未填寫完成的表單嗎?"); //在頁面上彈出對話框
    	            if(con==true){
    	             if(num>0){
    	               //$("a").attr("disabled", false);
    	               //location.reload()
    	             }
    	              
    	            }
    	            else {
    	              //$("a").attr("disabled", true);
    	              num++;
    	            }
    		  }
    	  });
    	  
          
    	  $('#profile-tab').click(function(){
    		  
              $('#contact').hide();
              $('#profile').show();
              $('#myinfo').hide();
              //$('#myinfo').html("");
              //$('#myinfo').load('memberPage/showmember.jsp');
         });
    	  
    	  $('#contact-tab').click(function(){
              $('#contact').show();
              $('#profile').hide();
              $('#myinfo').hide();
              //$('#myinfo').html("");
              //$('#myinfo').load('memberPage/showmember.jsp');
        });
    	  
    	  
      });
      
      
      innerPage ="";
      function updateMemberinfo(){
              innerPage = "editMemerinfo";
              alert("editMemerinfo")
              if(innerPage =="editMemerinfo"){
                 $('#myinfo').html("");
                 $('#myinfo').load('memberPage/editmember.jsp');
              }
      }
      
      function updateTestinfo(){
          
    	  innerPage = "editTTT";
    	  if(innerPage =="editTTT"){
              $('#contact').html("");
              $('#contact').load('memberPage/ShowTest.jsp');
              }
  }
      
    	  
      
        
      /*      
      $(function () {
          $('#zipzip').twzipcode({
        	  countySel: '高雄市',
        	  zipcodeIntoDistrict: true,
        	  css: ["city form-control", "town form-control"],
        	  countyName: "city", // 自訂城市 select 標籤的 name 值
        	  districtName: "town", // 自訂區別 select 標籤的 name 值
        		
          });
          var el = document.querySelectorAll("select");
          console.log(el);
      });
      */
      /*
      function loadMember(){
    	  $(function () {
    		  $.ajax('${pageContext.request.contextPath}/MemberInfo.do')
    		  .done(stores => {const $stores = $('#resultJsonText')
    	  }
    		    return stores.result.forEach(store => {     
    		        const $store = $(document.createElement('li'))        
    		        .text(store.name)
    		        $store.append($name).append($Name).appendTo($stores)
    		    })
    	  })
      })
    }
      */
      /*
      function jsonAjaxPost(){     
          $.ajax({  
              type:"post", 
              url:"${pageContext.request.contextPath}/MemberInfo.do",   
              dataType:"json",//设置返回数据的格式 ，请求成功后的回调函数 data为json格式  
              success:
                  function(data){  
            	 
//                       $("#resultJsonText").text("name："+obj.name+"  age:"+data.age);  
                  },  
              error:
                  function(xhr, ajaxOptions, thrownError){
                      alert(xhr.status+"\n"+thrownError);
                  }
          });  
      }
      
      */
      
      /*
      $(document).ready(function(){
    	  $("#editMemerinfo").click(function(){
    		  console.log("ajax");
    		  $.ajax({
    			  url:"${pageContext.request.contextPath}/MemberInfo.do",
    			  dataType:"json",
    			  data:{},
    			  type:"get",
    			  success:function(str){
    				var parseJson = jQuery.parseJSON(str);  
    				$("#contact").html(parseJson.name)
    			  },
    			  error:function(){
    				  alert("失敗")
    			  }
    		  });
    	  });
      });
 
      */
      
    
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

		<!-- 下列敘述設定變數funcName的值為SHO，topMVC.jsp 會用到此變數 -->


		<!-- 選單 -->
		<jsp:include page="fragment/menu_content.jsp" />


		<!-- 內容開始  -->
		<section class="login-block">
			<div class="container mt-5 mb-5">
				<!--標題-->
				<div class="row mb-1 mt-5">
					<div class="col-md-7 text-left">
						<h2 class="section-title mb-3">${isInvalid}會員專區 ${myPage}</h2>
						<p class="lead">Lorem ipsum dolor sit amet consectetur
							adipisicing elit. Minus minima neque tempora reiciendis.</p>
					</div>
				</div>

				<!--tabs-->
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="home-tab" data-bs-toggle="tab"
							data-bs-target="#myinfo" type="button" role="tab"
							aria-controls="myinfo" aria-selected="false" data-toggle="" data-target="">基本資訊</button>
					</li>
					<li class="nav-item mx-2" role="presentation">
						<a class="nav-link" id="profile-tab" data-bs-toggle="tab"
							data-bs-target="#profile" type="button" role="tab"
							aria-controls="profile" aria-selected="false" data-toggle="" data-target="">契約簽訂資訊</a>
					</li>
					<li class="nav-item" role="presentation">
						<a class="nav-link" id="contact-tab" data-bs-toggle="tab"
							data-bs-target="#contact" type="button" role="tab"
							aria-controls="contact" aria-selected="true" data-toggle="" data-target="">Contact</a>
					</li>
				</ul>
				<div class="tab-content" id="myTabContent">
					<!--分頁1-->
					<div class="tab-pane fade " id="myinfo" role="tabpanel"
						aria-labelledby="home-tab">
						
						<c:choose>
              <c:when test="${isInvalid==true}">
              <%--<jsp:include page="memberPage/valid.jsp" flush="true"/> --%>
               <%@ include file="memberPage/valid.jsp"%>
              </c:when>
              <c:otherwise>
                <jsp:include page="memberPage/showmember.jsp" flush="true"/>
             ${checkErr}
             </c:otherwise>
            </c:choose>

					</div>
					<!--分頁2-->
					<div class="tab-pane fade" id="profile" role="tabpanel"
						aria-labelledby="profile-tab">
						<!--標題2-->
						<div class="row mb-1 mt-5 ml-3">
							<div class="col-md-12 text-left">
								<div class="" style="display: flex; justify-content: center;">
									<h2 class="text-black mb-4">契約簽訂資訊</h2>
								</div>
							</div>
						</div>
						<section class="site-section" id="about-section">
							<div class="container px-5">

								<div class="row lg-mx-5">
									<div class="col lg-mx-5 border ">
										<div class="" style="display: flex; justify-content: center;">
											<h4 class="text-black mt-5">監護人／緊急聯絡人</h4>
											<br>
										</div>
										<div class="" style="display: flex; justify-content: center;">
											<font class="text-black mb-4 lg-ml-2"> 以下欄位皆為非必填資訊</font>
										</div>

										<h6 class="text-black-opacity-05 mx-4 mt-4">姓名</h6>
										<h3 class="text-black mb-4 mx-4">張小明</h3>
										<h6 class="text-black-opacity-05 mx-4">聯絡電話</h6>
										<h3 class="text-black mb-4 mx-4">0900-000-000</h3>
										<h6 class="text-black-opacity-05 mx-4">身份字號</h6>
										<h3 class="text-black mb-4 mx-4">A123456789</h3>
										<h6 class="text-black-opacity-05 mx-4">戶籍地址</h6>
										<h3 class="text-black mb-4 mx-4">台北市忠孝東路3段1號</h3>
										<h6 class="text-black-opacity-05 mx-4">關係</h6>
										<h3 class="text-black mb-4 mx-4">無可奉告</h3>
										<div class="row mb-1 mt-5 mx-3">
											<div class="col-md-12 text-left">
												<div class=""
													style="display: flex; justify-content: center;">
													<h3>
														<a href="#" class="btn btn-edit mr-2 mb-2 ">編輯會員資料</a>
													</h3>
												</div>
											</div>
										</div>
									</div>
								</div>

								<div class="row lg-mx-5 mt-5">
									<div class="col lg-mx-5 border">
										<div class="" style="display: flex; justify-content: center;">
											<h4 class="text-black mt-5">退款帳戶資訊</h4>
											<br>
										</div>
										<div class="" style="display: flex; justify-content: center;">
											<font class="text-black mb-4 lg-ml-2"> 以下欄位皆為非必填資訊</font>
										</div>

										<h6 class="text-black-opacity-05 mt-4 mx-4">銀行名稱</h6>
										<h3 class="text-black mb-4 mx-4">123456</h3>
										<h6 class="text-black-opacity-05 mx-4">分行名稱</h6>
										<h3 class="text-black mb-4 mx-4">123456123456123456</h3>
										<h6 class="text-black-opacity-05 mx-4">受款人姓名</h6>
										<h3 class="text-black mb-4 mx-4">張小明</h3>
										<h6 class="text-black-opacity-05 mx-4">銀行帳號</h6>
										<h3 class="text-black mb-4 mx-4">123456123456123456</h3>
										<div class="row mb-1 mt-5 mx-3">
											<div class="col-md-12 text-left">
												<div class=""
													style="display: flex; justify-content: center;">
													<h3>
														<a href="#" class="btn btn-edit mr-2 mb-2 ">編輯帳戶資料</a>
													</h3>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</section>


					</div>


					<!--分頁3-->

					<div class="tab-pane fade" id="contact" role="tabpanel"
						aria-labelledby="contact-tab">
						<%--@ include file="memberPage/editTest.jsp"--%>
						
					
						<c:choose>
              <c:when test="${checkErr==1}">
              <jsp:include page="memberPage/editTest.jsp" />
               
                
              </c:when>
              <c:otherwise>
                <jsp:include page="memberPage/ShowTest.jsp" />
             ${checkErr}
             </c:otherwise>
            </c:choose>
				
						
						<%-- 
						<c:choose>
							<c:when test="${ErrMsg!=null}">
								<%@ include file="memberPage/editTest.jsp"%>
							</c:when>
							<c:otherwise>
								<%@ include file="memberPage/editTest.jsp"%>
						 ${ErrMsg}
						 </c:otherwise>
						</c:choose>
						--%>
					</div>

				</div>
				<!-- id="myTabContent" -->
			</div>
	</div>
	</section>






<%-- 
<!-- 魔豆 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
      <h4 class="modal-title" id="myModalLabel">
          注意
        </h4>
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
          &times;
        </button>
        
      </div>
      <div class="modal-body">
        是否要放棄本次儲存
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="modalNO">取消放棄
        </button>
        <button type="button" class="btn btn-primary" id="modalOK">
          確定放棄
        </button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal -->
</div>
<!-- 魔豆 -->
--%>

	<jsp:include page="fragment/footer.jsp" />

	<!-- .site-wrap -->

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
	<script
		src="${pageContext.request.contextPath}/file/bootstrap.bundle.js"></script>
</body>
</html>
