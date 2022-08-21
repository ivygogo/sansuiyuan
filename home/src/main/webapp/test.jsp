<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
var triggerTabList = [].slice.call(document.querySelectorAll('#myTab a'))
triggerTabList.forEach(function (triggerEl) {
  var tabTrigger = new bootstrap.Tab(triggerEl)
  console.log(tabTrigger);
  triggerEl.addEventListener('click', function (event) {
    event.preventDefault()
    console.log("hi");
    tabTrigger.show()
  })
})    

function doFirst(){

$('#myTabs a[href="#profile"]').tab('show') // Select tab by name
$('#home').hide()
$('#profile').show()
$("#home-tab").attr("class", 'nav-link')
$("#profile-tab").attr('class', "nav-link active")

$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
  e.target // newly activated tab
  e.relatedTarget // previous active tab
})
//alert(checkPage)
}
window.addEventListener('load', doFirst);
</script>

</head>
<body>
<ul class="nav nav-tabs" id="myTab" role="tablist">
  <li class="nav-item" role="presentation">
    <button class="nav-link active " id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="false">Home</button>
  </li>
  
  <li class="nav-item" role="presentation">
    <a class="nav-link" id="messages-tab" data-bs-toggle="tab" data-bs-target="#messages" type="button" role="tab" aria-controls="messages" aria-selected="false">Messages</a>
  </li>
  <li class="nav-item" role="presentation">
    <button class="nav-link" id="settings-tab" data-bs-toggle="tab" data-bs-target="#settings" type="button" role="tab" aria-controls="settings" aria-selected="false">Settings</button>
  </li>
  <li class="nav-item" role="presentation">
    <a class="nav-link " id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false" href="profile">Profile</a>
  </li>
</ul>

<div class="tab-content">
  <div class="tab-pane active" id="home" role="tabpanel" aria-labelledby="home-tab">1...</div>
  <div class="tab-pane" id="profile" role="tabpanel" aria-labelledby="profile-tab">2...</div>
  <div class="tab-pane" id="messages" role="tabpanel" aria-labelledby="messages-tab">..3.</div>
  <div class="tab-pane" id="settings" role="tabpanel" aria-labelledby="settings-tab">..4.</div>
</div>





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