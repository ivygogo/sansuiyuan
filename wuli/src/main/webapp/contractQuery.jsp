<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="author" content="Free-Template.co" />
<meta http-equiv="expires" content="0">
<!-- favicon
    ============================================ -->
<link rel="shortcut icon"
  type="${pageContext.request.contextPath}/image/x-icon"
  href="img/favicon.ico">
<!-- Google Fonts
            ============================================ -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900"
  rel="stylesheet">
<!-- Bootstrap CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/bootstrap.min.css">

<!-- owl.carousel CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/owl.carousel.css">
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/owl.theme.css">
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/owl.transitions.css">
<!-- meanmenu CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/meanmenu/meanmenu.min.css">
<!-- animate CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/animate.css">
<!-- summernote CSS
    ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/summernote/summernote.css">
<!-- Range Slider CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/themesaller-forms.css">

<!-- normalize CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/normalize.css">
<!-- mCustomScrollbar CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/scrollbar/jquery.mCustomScrollbar.min.css">
<!-- bootstrap select CSS
    ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/bootstrap-select/bootstrap-select.css">
<!-- datapicker CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/datapicker/datepicker3.css">
<!-- Color Picker CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/color-picker/farbtastic.css">
<!-- main CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/chosen/chosen.css">

<!-- notification CSS
    ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/notification/notification.css">
<!-- dropzone CSS
    ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/dropzone/dropzone.css">
<!-- jvectormap CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/jvectormap/jquery-jvectormap-2.0.3.css">
<!-- notika icon CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/notika-custom-icon.css">
<!-- wave CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/wave/waves.min.css">
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/wave/button.css">
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<!-- main CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/main.css">
<!-- style CSS
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/style.css">
<!-- responsive CSS 
            ============================================ -->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/responsive.css">
<!-- modernizr JS
            ============================================ -->
<script
  src="${pageContext.request.contextPath}/js/vendor/modernizr-2.8.3.min.js"></script>
<!-- cropper CSS
    ============================================-->
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/cropper/cropper.min.css">
<script type="text/javascript"
  src="${pageContext.request.contextPath}/file/jquery-2.1.1.min.js"></script>
<script type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment-with-locales.min.js"></script>
<script type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.css">
<link href="https://fonts.googleapis.com/css2?family=Material+Icons"
  rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
  src="${pageContext.request.contextPath}/landlordRepairForm/landlordRepairForm.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<style>
.font {
  color: white;
  padding: 10px;
}

.bkground {
  background-color: #01c293;
  width: 100%;
  margin: auto;
}

tr:focus {
  background-color: #DAFFCC;
}

#status1 {
  border: 3px solid #01c293;
  height: 280px;
  width: 1150px;
  margin: auto;
  position: relative;
}

#status2 {
  border: 3px solid #01c293;
  height: 180px;
  width: 1150px;
  margin: auto;
  position: relative;

}

select {
  border: 0;
}

input {
  width: 15px;
  height: 15px;
}
</style>


</head>

<body>


  <%@include file="fragment/menu_index.jsp"%>

  <div class="d-flex justify-content-center">

    <div class="p-4">

      <img
        src='<c:url value="/images/contractQueryImg/refresh.png" ></c:url>'
        width="30" height="30"
        style="cursor: pointer; display: inline; top: 200px;"
        onclick="window.location.assign('/wuli/Contract.do');">
      Refresh
    </div>
    <div class="p-4">
      <a href="ContractHide"><img
        src='<c:url value="/images/contractQueryImg/undo.png" ></c:url>'
        width="30" height="30" style="top: 200px;"></a>
    </div>
    <div class="p-4">
      <form action="Update" method="post" name="delete">
        <img
          src='<c:url value="/images/contractQueryImg/trash.png" ></c:url>'
          style="cursor: pointer; top: 200px; width: 30px; height: 30px;"
          id="trashcan" onclick="deliver()"> <input type="hidden"
          name="selects" value="" id="formUpdate">
      </form>
    </div>
    <div class="p-4">
      <span style="color: red; font: normal 1.2em bold monospace;"
        id="errorMsg">${ErrMsg.CIDError}</span>
    </div>
  </div>



  <div id="status1" class="overflow-auto"
    style="margin-top: 1px; border-radius: 20px;">
    <table class="table">
      <thead>
        <tr style="background-color: #01c293;">
          <th><input type="checkbox" id="allCK"></th>
          <th>合約狀態</th>
          <th>合約編號</th>
          <th>租客姓名</th>
          <th>房號</th>
          <th>房型</th>
          <th>繳費</th>
          <th>費用</th>
          <th>點交</th>
          <th>合約</th>
          <th>簽約日期</th>

        </tr>
      </thead>





      <!-- -------------------------allContract---------------------------------- -->


      <c:forEach items="${allContract}" var="contract">

        <tbody>
          <tr tabindex="1" id="contract${contract.CID}" class="CT">
            <th>
              <form style="display: inline;">
                <input type="checkbox" class="ck" id="delete${contract.CID}"
                  value="${contract.CID}">
              </form>
            </th>
            <td><input type="text" value="${contract.status}"
              id="status${contract.CID}" style="display: none;" class="ST">${contract.status}</td>
            <td><input type="hidden" value="${contract.CID}"
              id="CID${contract.CID}">${contract.CID}</td>
            <td><input type="text" value="${contract.name}"
              id="name${contract.CID}" style="display: none;" class="nickName">${contract.name}</td>
            <td><input type="hidden" value="${contract.room_Number}"
              id="room_Number${contract.CID}" class="roomNumber">${contract.room_Number}</td>
            <td>${contract.room_Type}<input type="hidden"
              value="${contract.room_Type}" id="room_Type${contract.CID}"
              class="room_Type"></td>
            <td><input type="hidden" value="${contract.payment_Status}"
              id="payment_Status${contract.CID}" class="PS">${contract.payment_Status}
            </td>
            <td><input type="hidden" value="${contract.check_Fee}"
              id="check_Fee${contract.CID}" class="CheckFee">${contract.check_Fee}</td>
            <td><input type="hidden" value="${contract.check_Status}"
              id="check_Status${contract.CID}" class="CS">${contract.check_Status}</td>
            <input type="hidden" value="${contract.deposit}"
              id="deposit${contract.CID}" class="Deposit">
            <td><input type="hidden" value="${contract.PDF}"
              id="PDF${contract.CID}" class="pdf">${contract.PDF}</td>
            <td><input type="hidden" value="${contract.signed_Date}">${contract.signed_Date}
            </td>
          </tr>
        </tbody>
      </c:forEach>
    </table>
  </div>


  <!-- 搜尋bar -->
  <div class="d-flex justify-content-center">
    <div class="p-4">
      <form action="ContractNameSearchServlet" method="post"
        name="searchForm">
        <span style="display: inline; font-weight: bold; font-size: 20px">姓名：</span>
        <input style="width: 250px; height: 30px;" type="text" value=""
          name="SearchResult"> <img
          src='<c:url value="/images/contractQueryImg/search.png" ></c:url>'
          width="30" height="30" style="cursor: pointer;" id="searchBar">
      </form>
    </div>
  </div>

  <!-- -------------------------searchContract---------------------------------- -->



  <div id="status2" class="overflow-auto"
    style="margin-top: 1px; border-radius: 20px;">
    <table class="table">
      <thead>
        <tr style="background-color: #01c293;">
          <th></th>
          <th>合約狀態</th>
          <th>合約編號</th>
          <th>租客姓名</th>
          <th>房號</th>
          <th>房型</th>
          <th>繳費</th>
          <th>費用</th>
          <th>點交</th>
          <th>合約</th>
          <th>簽約日期</th>

        </tr>
      </thead>
      <div id="forTesting">
        <c:forEach items="${searchResult}" var="searchResult">
          <tbody>
            <tr tabindex="1" id="searchContract${searchResult.CID}"
              class="searchCT">
              <th>
                <form style="display: inline;">
                  <input type="checkbox" class="searchCheckBox"
                    id="searchCheckBoxs${searchResult.CID}"
                    value="${searchResult.CID}">
                </form>
              </th>
              <td><input type="text" value="${searchResult.status}"
                id="searchStatus${searchResult.CID}" style="display: none;">${searchResult.status}</td>
              <td><input type="hidden" value="${searchResult.CID}"
                id="searchCID${searchResult.CID}">${searchResult.CID}</td>
              <td><input type="text" value="${searchResult.name}"
                id="searchName${searchResult.CID}" style="display: none;">${searchResult.name}</td>
              <td><input type="hidden" value="${searchResult.room_Number}"
                id="searchRoom_Number${searchResult.CID}">${searchResult.room_Number}</td>
              <td><input type="hidden" value="${searchResult.room_Type}"
                id="searchRoom_Type${searchResult.CID}">${searchResult.room_Type}</td>
              <td><input type="hidden"
                value="${searchResult.payment_Status}"
                id="searchPayment_Status${searchResult.CID}">${searchResult.payment_Status}</td>
              <td><input type="hidden" value="${searchResult.check_Fee}"
                id="searchCheck_Fee${searchResult.CID}">${searchResult.check_Fee}</td>
              <td><input type="hidden"
                value="${searchResult.check_Status}"
                id="searchCheck_Status${searchResult.CID}">${searchResult.check_Status}</td>
              <input type="hidden" value="${searchResult.deposit}"
                id="searchDeposit${searchResult.CID}">
              <td><input type="hidden" value="${searchResult.PDF}"
                id="searchPDF${searchResult.CID}">${searchResult.PDF}</td>
              <td><input type="hidden" value="${searchResult.signed_Date}"
                id="searchSigned_Date${searchResult.CID}">${searchResult.signed_Date}</td>
              <input type="hidden" value="${searchResult.hide}"
                id="searchHide${searchResult.CID}">
            </tr>
          </tbody>
        </c:forEach>
      </div>
    </table>

  </div>
  <br>



  <!-- -------------- ------------------------------------------------>
  <div
    style="position: relative; border: 1px solid green; height: 800px; width: 1150px; border-radius: 50px;"
    class="container-fluid">
    <div style="margin: 0px 0 0 1200px"></div>
    <div style="position: relative; padding: 30px;">


      <form action="modify" style="display: inline;" method="post"
        name="formModify">
        <div id="checkboxgroup1">

          <p style="display: inline;">合約狀態 :</p>
          <input type="hidden" id="ContractStatus" name="status" value="">
          <input type="checkbox" id="cks1" value="${contractS.cbs2.status}"
            class="statusClass" onclick="return false;">租賃中 <input
            type="checkbox" id="cks2" value="${contractS.cbs2.status}"
            class="statusClass" onclick="return false;">已退租 <input
            type="checkbox" id="cks3" value="${contractS.cbs3.status}"
            class="statusClass" onclick="return false;">租約到期 <img
            src='<c:url value="/images/contractQueryImg/edit.png" ></c:url>'
            style="width: 30px; height: 30px; display: inline; margin-left: 900px; margin-bottom: 17px; cursor: pointer;"
            id="edit"> <input type="image" id="save"
            src='<c:url value="/images/contractQueryImg/save.png" ></c:url>'
            style="width: 30px; height: 30px; cursor: pointer; display: inline; margin-left: 50px;">
        </div>

        <script>
          $('#checkboxgroup1 input').click(
              function() {
                if ($(this).prop('checked')) {
                  $('#checkboxgroup1 input:checkbox').prop(
                      'checked', false);
                  $(this).prop('checked', true)
                }
              });
        </script>

        <input type="hidden" id="input6" value="" name="CID">


        <div>
          <p style="display: inline; margin-top: 15px; margin-bottom: 10px;">租客名字：</p>
          <input type="text" id="input1" disabled="disabled" name="name"
            value=""
            style="border: none; width: 150px; height: 30px; background-color: white; display: inline;">
        </div>

        <p style="display: inline;">合約 :</p>
        <input type="text" id="input2" disabled="disabled" value=""
          name="PDF"
          style="border: none; width: 90px; height: 30px; background-color: white; display: inline;">


        <div>
          <p style="display: inline; margin-top: 15px; margin-bottom: 10px;">房號：</p>
          <input type="text" id="input3" disabled="disabled"
            name="room_Number" value=""
            style="border: none; width: 60px; height: 30px; background-color: white; display: inline;">
        </div>
        <div id="checkboxgroup2">
          <p style="display: inline;">繳費狀態：</p>
          <input type="checkbox" id="ckps1" class="payment_status"
            value="${contractPS.cbps1.payment_Status}" onclick="return false;">
          已繳 <input type="checkbox" id="ckps2" class="payment_status"
            value="${contractPS.cbps2.payment_Status}" onclick="return false;">
          未繳 <input type="hidden" id="ContractPayment_status"
            name="payment_Status" value="">
        </div>
        <script>
          $('#checkboxgroup2 input').click(
              function() {
                if ($(this).prop('checked')) {
                  $('#checkboxgroup2 input:checkbox').prop(
                      'checked', false);
                  $(this).prop('checked', true)
                }
              });
        </script>
        <div>
          <p style="display: inline; margin-top: 10px; margin-bottom: 10px;">押金：</p>
          <input type="text" id="input4" disabled="disabled" value=""
            name="deposit"
            style="border: none; width: 80px; height: 30px; background-color: white; display: inline;">
        </div>

        <div>

          <p style="display: inline; margin-top: 15px; margin-bottom: 10px;">費用結算：</p>
          <input type="text" id="input5" disabled="disabled" name="check_Fee"
            value=""
            style="border: none; width: 65px; height: 30px; background-color: white; display: inline;">
          <!-- <input type="checkbox"> 電費 
          <input type="checkbox"style="margin-left: 10px;">其他 -->
        </div>


        <div style="position: absolute; display: block; margin-top: 5px;"
          id="checkboxgroup3">
          <p style="display: inline;">退租點交：</p>
          <input type="checkbox" id="ckcs1" class="check_status"
            value="${contractCS.cbcs1.check_Status}" onclick="return false;">未點交
          <input type="checkbox" id="ckcs2" class="check_status"
            value="${contractCS.cbcs2.check_Status}" onclick="return false;">
          已點交 <input type="hidden" id="ContractCheck_status"
            name="check_Status" value="">
        </div>
        <script>
          $('#checkboxgroup3 input').click(
              function() {
                if ($(this).prop('checked')) {
                  $('#checkboxgroup3 input:checkbox').prop(
                      'checked', false);
                  $(this).prop('checked', true)
                }
              });
        </script>
      </form>
      <!-- -------------- ------------------------------------------------>



      <div class="d-flex m-5 justify-content-center">
        <div class=" room-type-main-side-block col-md-6 col-12"
          id="RoomItems" style="display: none;">
          <div class="p-3 room-type-side-regin"
            style="border: 1px solid green;">
            <h3>房間設備：</h3>
            <span class="row d-flex justify-content-around align-items-center">
              <span class="col-2 text-center"> <span
                class="row material-icons">tv</span>
                <div class="row">
                  <div class="col text-center">電視</div>
                </div>
                <div class="row">
                  <div class="col text-center">
                    <input type="text" id="TV" value=""
                      style="border: none; width: 30px; outline: none;"
                      readonly="readonly">
                  </div>
                </div>
            </span> <span class="col-2 text-center"> <span
                class="row material-icons">shower</span>
                <div class="row">
                  <div class="col text-center text-nowrap">熱水器</div>
                </div>
                <div class="row">
                  <div class="col text-center">
                    <input type="text" id="WaterHeater" value=""
                      style="border: none; width: 30px; outline: none;"
                      readonly="readonly">
                  </div>
                </div>
            </span> <span class="col-2 text-center"> <span
                class="material-icons">air</span>
                <div class="row">
                  <div class="col text-center">冷氣</div>
                </div>
                <div class="row">
                  <div class="col text-center">
                    <input type="text" id="Airconditioner" value=""
                      style="border: none; width: 30px; outline: none;"
                      readonly="readonly">
                  </div>
                </div>
            </span> <span class="col-2 text-center"> <span
                class="material-icons">kitchen</span>
                <div class="row">
                  <div class="col text-center">冰箱</div>
                </div>
                <div class="row">
                  <div class="col text-center">
                    <input type="text" id="Freezer" value=""
                      style="border: none; width: 30px; outline: none;"
                      readonly="readonly">
                  </div>
                </div>
            </span> <span class="col-2 text-center"> <span
                class="col material-icons text-center">window</span>
                <div class="row">
                  <div class="col text-center">紗窗</div>
                </div>
                <div class="row">
                  <div class="col text-center">
                    <input type="text" id="Window" value=""
                      style="border: none; width: 30px; outline: none;"
                      readonly="readonly">
                  </div>
                </div>
            </span>
            </span>
            <hr />
            <span class="row d-flex justify-content-around"> <span
              class="col-2 text-center"> <span class="material-icons">chair_alt</span>
                <div class="row">
                  <div class="col text-center" id="room-item-chair">椅子</div>
                </div>
                <div class="row">
                  <div class="col text-center">
                    <input type="text" id="Chair" value=""
                      style="border: none; width: 30px; outline: none;"
                      readonly="readonly">
                  </div>
                </div>
            </span> <span class="col-2 text-center "> <span
                class="row material-icons">single_bed</span>
                <div class="row">
                  <div class="col text-center text-nowrap" id="room-item-bed">床</div>
                </div>

                <div class="row">
                  <div class="col text-center">
                    <input type="text" id="Bed" value=""
                      style="border: none; width: 50px; outline: none;"
                      readonly="readonly">
                  </div>
                </div>
            </span> <span class="col-2 text-center"> <span
                class="row material-icons">desk</span>
                <div class="row">
                  <div class="col text-center text-nowrap" id="room-item-desk">桌子</div>
                </div>
                <div class="row">
                  <div class="col text-center">
                    <input type="text" id="Desk" value=""
                      style="border: none; width: 50px; outline: none;"
                      readonly="readonly">
                  </div>
                </div>
            </span> <span class="col-2 text-center"> <span
                class="row material-icons ">all_inbox</span>
                <div class="row">
                  <div class="col text-center text-nowrap"
                    id="room-item-sideTable">床頭櫃</div>
                </div>
                <div class="row">
                  <div class="col text-center">
                    <input type="text" id="SideTable" value=""
                      style="border: none; width: 50px; outline: none;"
                      readonly="readonly">
                  </div>
                </div>
            </span> <span class="col-2 text-center"> <span
                class="row material-icons">door_sliding</span>
                <div class="row">
                  <div class="col text-center" id="room-item-wardrobe">衣櫃</div>
                </div>
                <div class="row">
                  <div class="col text-center">
                    <input type="text" id="Wardrobe" value=""
                      style="border: none; width: 30px; outline: none;"
                      readonly="readonly">
                  </div>
                </div>
            </span> <span class="col-2 text-center d-none" id="room-item-balcony">
                <span class="row material-icons">balcony</span>
                <div class="row">
                  <div class="col text-center">陽台</div>
                </div>
            </span>
            </span>
            <hr>

            <h3>公共設施：</h3>

            <span class="row d-flex justify-content-around"> <span
              class="col-2 text-center"> <span class="material-icons">elevator
              </span>
                <div class="row">
                  <div class="col text-center">電梯</div>
                </div>
            </span> <span class="col-2 text-center"> <span
                class="material-icons" title="投幣式">on_device_training </span>
                <div class="row">
                  <div class="col text-center">洗衣機</div>
                </div>
            </span> <span class="col-2 text-center"> <span
                class="material-icons" title="投幣式">local_laundry_service
              </span>
                <div class="row">
                  <div class="col text-center">烘衣機</div>
                </div>
            </span> <span class="col-2 text-center"> <span
                class="material-icons">wifi </span>
                <div class="row">
                  <div class="col text-center">無線網路</div>
                </div>
            </span> <span class="col-2 text-center"> </span>
            </span>
          </div>
        </div>
      </div>
    </div>

  </div>
</body>
<!-- ----------------------------------------------- -->
<script>
  window.addEventListener('load', doFirst);
  let searchCheckBox = document.querySelectorAll(".searchCheckBox")
  let searchCT = document.querySelectorAll(".searchCT")
  let searchBar = document.getElementById("searchBar")
  let input1 = document.getElementById("input1")
  let input2 = document.getElementById("input2")
  let input3 = document.getElementById("input3")
  let input4 = document.getElementById("input4")
  let input5 = document.getElementById("input5")
  let input6 = document.getElementById("input6")
  let renting = "${contractS.cbs1.status}"
  let retreat = "${contractS.cbs2.status}"
  let expired = "${contractS.cbs3.status}"
  let cks1 = document.getElementById("cks1")
  let cks2 = document.getElementById("cks2")
  let cks3 = document.getElementById("cks3")
  let trashcan = document.getElementById("trashcan")
  let edit = document.getElementById("edit")
  let ckps1 = document.getElementById("ckps1")
  let ckps2 = document.getElementById("ckps2")
  let paid = "${contractPS.cbps1.payment_Status}"
  let unpaid = "${contractPS.cbps2.payment_Status}"
  let ckcs1 = document.getElementById("ckcs1")
  let ckcs2 = document.getElementById("ckcs2")
  let unHandover = "${contractCS.cbcs1.check_Status}"
  let handover = "${contractCS.cbcs2.check_Status}"
  let ContractStatus = document.getElementById("ContractStatus")
  let ck = document.querySelectorAll(".ck");
  let ContractPayment_status = document
      .getElementById("ContractPayment_status")
  let ContractCheck_status = document.getElementById("ContractCheck_status")
  console.log("--------------------")
  let allCK = document.getElementById("allCK")
  let clip = document.getElementById('clip')
  let ckPS = document.getElementById("ckPS")
  let ckCS = document.getElementById("ckCS")
  let nickName = document.querySelectorAll(".nickName")
  let pdf = document.querySelectorAll('.pdf')
  let roomNumber = document.querySelectorAll('.roomNumber')
  let Deposit = document.querySelectorAll('.Deposit')
  let CheckFee = document.querySelectorAll('.CheckFee')
  let PS = document.querySelectorAll(".PS")
  let ST = document.querySelectorAll(".ST")
  let CS = document.querySelectorAll(".CS")
  let CT = document.querySelectorAll(".CT")
  console.log(CT.length)
  let cover = document.querySelectorAll(".cover")
  let statusClass = document.querySelectorAll(".statusClass")
  let payment_status = document.querySelectorAll(".payment_status")
  let check_status = document.querySelectorAll(".check_status")
  let save = document.getElementById("save")
  let formUpdate = document.getElementById("formUpdate")
  let TV = document.getElementById("TV")
  let WaterHeater = document.getElementById("WaterHeater")
  let Airconditioner = document.getElementById("Airconditioner")
  let Freezer = document.getElementById("Freezer")
  let window1 = document.getElementById("Window")
  let Chair = document.getElementById("Chair")
  let Bed = document.getElementById("Bed")
  let Desk = document.getElementById("Desk")
  let SideTable = document.getElementById("SideTable")
  let Wardrobe = document.getElementById("Wardrobe")
  let RoomItems = document.getElementById("RoomItems")

  function doFirst() {
    window.history.replaceState(null, null, window.location.href);
    window.reload
    allCK.addEventListener('click', selectAll)
    edit.addEventListener('click', alter)
    save.addEventListener('click', change)
    trashcan.addEventListener('click', deliver)
    searchBar.addEventListener('click', searchContent)
    showAll()
    deleteContractMethod()
    deleteSearchContractMethod()
    statusCheckbox()
    payment_StatusCheckbox()
    check_StatusCheckbox()
    searchAllContract()

    // <!-- ---------------預先讀取資料 --------------->

    let contract = document.getElementById("contract" + ck[0].value)
    let status = document.getElementById("status" + ck[0].value)
    let CID = document.getElementById("CID" + ck[0].value)
    let name = document.getElementById("name" + ck[0].value)
    let room_Number = document.getElementById("room_Number" + ck[0].value)
    let payment_Status = document.getElementById("payment_Status"
        + ck[0].value)
    let check_Status = document
        .getElementById("check_Status" + ck[0].value)
    let check_Fee = document.getElementById("check_Fee" + ck[0].value)
    let PDF = document.getElementById("PDF" + ck[0].value)
    let deposit = document.getElementById("deposit" + ck[0].value)
    input1.value = name.value
    input2.value = PDF.value
    input3.value = room_Number.value
    input4.value = deposit.value
    input5.value = check_Fee.value
    input6.value = CID.value
    ContractStatus.value = status.value
    ContractPayment_status.value = payment_Status.value
    ContractCheck_status.value = check_Status.value
    // --------合約狀態判斷式----------
    if (status.value === renting) {
      cks1.checked = true;
      cks2.checked = false;
      cks3.checked = false;
    } else if (status.value === retreat) {
      cks2.checked = true;
      cks1.checked = false;
      cks3.checked = false;
    } else if (status.value === expired) {
      cks3.checked = true;
      cks1.checked = false;
      cks2.checked = false;
    }
    // --------繳費狀態判斷式----------
    if (payment_Status.value === paid) {
      ckps1.checked = true;
      ckps2.checked = false;
    } else if (payment_Status.value === unpaid) {
      ckps2.checked = true;
      ckps1.checked = false;
    }
    // --------點交判斷式----------
    if (check_Status.value === unHandover) {
      ckcs1.checked = true;
      ckcs2.checked = false;
    } else if (check_Status.value === handover) {
      ckcs1.checked = false;
      ckcs2.checked = true;
    }

  }
  function showAll() {
    for (let i = 0; i < CT.length; i++) {
      let contract = document.getElementById("contract" + ck[i].value)
      let status = document.getElementById("status" + ck[i].value)
      let CID = document.getElementById("CID" + ck[i].value)
      let name = document.getElementById("name" + ck[i].value)
      let room_Number = document.getElementById("room_Number"
          + ck[i].value)
      let payment_Status = document.getElementById("payment_Status"
          + ck[i].value)
      let check_Status = document.getElementById("check_Status"
          + ck[i].value)
      let check_Fee = document.getElementById("check_Fee" + ck[i].value)
      let PDF = document.getElementById("PDF" + ck[i].value)
      let deposit = document.getElementById("deposit" + ck[i].value)
      let room_Type = document.getElementById("room_Type" + ck[i].value)
      contract
          .addEventListener(
              "click",
              function() {
                input1.value = name.value
                input2.value = PDF.value
                input3.value = room_Number.value
                input4.value = deposit.value
                input5.value = check_Fee.value
                input6.value = CID.value
                ContractStatus.value = status.value
                ContractPayment_status.value = payment_Status.value
                ContractCheck_status.value = check_Status.value
                RoomItems.removeAttribute('style');
                // --------合約狀態判斷式----------
                if (status.value === renting) {
                  cks1.checked = true;
                  cks2.checked = false;
                  cks3.checked = false;
                } else if (status.value === retreat) {
                  cks2.checked = true;
                  cks1.checked = false;
                  cks3.checked = false;
                } else if (status.value === expired) {
                  cks3.checked = true;
                  cks1.checked = false;
                  cks2.checked = false;
                }
                // --------繳費狀態判斷式----------
                if (payment_Status.value === paid) {
                  ckps1.checked = true;
                  ckps2.checked = false;
                } else if (payment_Status.value === unpaid) {
                  ckps2.checked = true;
                  ckps1.checked = false;
                }
                // --------點交判斷式----------
                if (check_Status.value === unHandover) {
                  ckcs1.checked = true;
                  ckcs2.checked = false;
                } else if (check_Status.value === handover) {
                  ckcs1.checked = false;
                  ckcs2.checked = true;
                }
                //                   ------------  // 房型判斷式------------
                if (room_Type.value == "單人房A") {
                  TV.value = `*${allRoomType.get(0).TV}`
                  WaterHeater.value = `*${allRoomType.get(0).waterHeater}`
                  Airconditioner.value = `*${allRoomType.get(0).airconditioner}`
                  Freezer.value = `*${allRoomType.get(0).freezer}`
                  window1.value = `*${allRoomType.get(0).screen}`
                  Chair.value = `*${allRoomType.get(0).chair}`
                  Bed.value = `(雙)*${allRoomType.get(0).doubleBed}`
                  Desk.value = `(大)*${allRoomType.get(0).bigDesk}`
                  SideTable.value = `(大)*${allRoomType.get(0).bigSideTable}`
                  Wardrobe.value = `*${allRoomType.get(0).wardrobe}`
                } else if (room_Type.value == "單人房B") {
                  TV.value = `*${allRoomType.get(1).TV}`
                  WaterHeater.value = `*${allRoomType.get(1).waterHeater}`
                  Airconditioner.value = `*${allRoomType.get(1).airconditioner}`
                  Freezer.value = `*${allRoomType.get(1).freezer}`
                  window1.value = `*${allRoomType.get(1).screen}`
                  Chair.value = `*${allRoomType.get(1).chair}`
                  Bed.value = `(雙)*${allRoomType.get(1).doubleBed}`
                  Desk.value = `(大)*${allRoomType.get(1).bigDesk}`
                  SideTable.value = `(大)*${allRoomType.get(1).bigSideTable}`
                  Wardrobe.value = `*${allRoomType.get(1).wardrobe}`
                } else if (room_Type.value == "單人房C") {
                  TV.value = `*${allRoomType.get(2).TV}`
                  WaterHeater.value = `*${allRoomType.get(2).waterHeater}`
                  Airconditioner.value = `*${allRoomType.get(2).airconditioner}`
                  Freezer.value = `*${allRoomType.get(2).freezer}`
                  window1.value = `*${allRoomType.get(2).screen}`
                  Chair.value = `*${allRoomType.get(2).chair}`
                  Bed.value = `(雙)*${allRoomType.get(2).doubleBed}`
                  Desk.value = `(大)*${allRoomType.get(2).bigDesk}`
                  SideTable.value = `(大)*${allRoomType.get(2).bigSideTable}`
                  Wardrobe.value = `*${allRoomType.get(2).wardrobe}`
                } else if (room_Type.value == "雙人房A") {
                  TV.value = `*${allRoomType.get(3).TV}`
                  WaterHeater.value = `*${allRoomType.get(3).waterHeater}`
                  Airconditioner.value = `*${allRoomType.get(3).airconditioner}`
                  Freezer.value = `*${allRoomType.get(3).freezer}`
                  window1.value = `*${allRoomType.get(3).screen}`
                  Chair.value = `*${allRoomType.get(3).chair}`
                  Bed.value = `(單)*${allRoomType.get(3).singleBed}`
                  Desk.value = `(小)*${allRoomType.get(3).smallDesk}`
                  SideTable.value = `(小)*${allRoomType.get(3).smallSideTable}`
                  Wardrobe.value = `*${allRoomType.get(3).wardrobe}`
                } else if (room_Type.value == "雙人房B") {
                  TV.value = `*${allRoomType.get(4).TV}`
                  WaterHeater.value = `*${allRoomType.get(4).waterHeater}`
                  Airconditioner.value = `*${allRoomType.get(4).airconditioner}`
                  Freezer.value = `*${allRoomType.get(4).freezer}`
                  window1.value = `*${allRoomType.get(4).screen}`
                  Chair.value = `*${allRoomType.get(4).chair}`
                  Bed.value = `(單)*${allRoomType.get(4).singleBed}`
                  Desk.value = `(小)*${allRoomType.get(4).smallDesk}`
                  SideTable.value = `(小)*${allRoomType.get(4).smallSideTable}`
                  Wardrobe.value = `*${allRoomType.get(4).wardrobe}`
                } else if (room_Type.value == "雙人房C") {
                  TV.value = `*${allRoomType.get(5).TV}`
                  WaterHeater.value = `*${allRoomType.get(5).waterHeater}`
                  Airconditioner.value = `*${allRoomType.get(5).airconditioner}`
                  Freezer.value = `*${allRoomType.get(5).freezer}`
                  window1.value = `*${allRoomType.get(5).screen}`
                  Chair.value = `*${allRoomType.get(5).chair}`
                  Bed.value = `(雙)*${allRoomType.get(5).doubleBed}`
                  Desk.value = `(大)*${allRoomType.get(5).bigDesk}`
                  SideTable.value = `(大)*${allRoomType.get(5).bigSideTable}`
                  Wardrobe.value = `*${allRoomType.get(5).wardrobe}`
                }
              })
    }
  }

  function deleteContractMethod() {
    let selectsArray = []
    let ck = document.querySelectorAll(".ck");

    console.log(ck)
    console.log("--------------------------------------")

    for (let i = 0; i < ck.length; i++) {
      let checkbox = document.getElementById("delete" + ck[i].value)
      checkbox.addEventListener("click", function(e) {
        console.log(selectsArray)
        let number = parseInt(e.target.value)
        let index = selectsArray.indexOf(number)
        console.log(index + " -- " + " -- " + number + " -- "
            + " -- --" + e.target.value)
        if (index !== -1) {
          selectsArray.splice(index, 1)
        } else {
          selectsArray.push(number)
        }
        formUpdate.value = selectsArray
        console.log(formUpdate.value)
      })
    }

  }
  function deleteSearchContractMethod() {
    let selectsArray = []
    let searchCheckBox = document.querySelectorAll(".searchCheckBox");
    for (let i = 0; i < searchCheckBox.length; i++) {

      let searchCheckBoxs = document.getElementById("searchCheckBoxs"
          + searchCheckBox[i].value)
      searchCheckBoxs.addEventListener("click", function(e) {

        console.log(selectsArray)
        let number = parseInt(e.target.value)
        let index = selectsArray.indexOf(number)
        console.log(index + " -- " + " -- " + number + " -- "
            + " -- --" + e.target.value)
        if (index !== -1) {
          selectsArray.splice(index, 1)
        } else {
          selectsArray.push(number)
        }
        formUpdate.value = selectsArray
        console.log(formUpdate.value)
      })
    }
  }

  function change() {
    document.forms['formModify'].submit();
  }

  function selectAll() {
    let selectsArray = []
    for (i = 0; i < ck.length; i++) {
      ck[i].checked = true;
      selectsArray.push(ck[i].value)
      formUpdate.value = selectsArray
    }
  }
  function alter() {
    for (let i = 0; i < statusClass.length; i++) {
      statusClass[i].removeAttribute('onclick');
    }
    for (let i = 0; i < payment_status.length; i++) {
      payment_status[i].removeAttribute('onclick');
    }
    for (let i = 0; i < check_status.length; i++) {
      check_status[i].removeAttribute('onclick');
    }
    input1.removeAttribute('disabled');
    input1.style.border = '2px solid black'
    input2.removeAttribute('disabled');
    input2.style.border = '2px solid black'
    input3.removeAttribute('disabled');
    input3.style.border = '2px solid black'
    input4.removeAttribute('disabled');
    input4.style.border = '2px solid black'
    input5.removeAttribute('disabled');
    input5.style.border = '2px solid black'
  }
  function statusCheckbox() {
    for (let i = 1; i <= statusClass.length; i++) {
      console.log(statusClass.length)
      console.log(statusClass)
      console.log("===================================")
      checkboxStatus = document.getElementById("cks" + i)
      checkboxStatus.addEventListener("click", function(e) {
        let value = e.target.value
        ContractStatus.value = value
      })
    }
  }
  function payment_StatusCheckbox() {
    for (let i = 1; i <= payment_status.length; i++) {
      console.log(payment_status.length)
      console.log(payment_status)
      checkboxPayment_Status = document.getElementById("ckps" + i)
      checkboxPayment_Status.addEventListener("click", function(e) {
        let value = e.target.value
        ContractPayment_status.value = value
      })
    }
  }
  function check_StatusCheckbox() {
    for (let i = 1; i <= check_status.length; i++) {
      checkboxCheck_Status = document.getElementById("ckcs" + i)
      checkboxCheck_Status.addEventListener("click", function(e) {
        let value = e.target.value
        ContractCheck_status.value = value
      })
    }
  }
  function searchContent() {
    document.forms['searchForm'].submit();
  }
  function deliver() {
    document.forms['delete'].submit();
    console.log("-------change---------")
    let forTesting = document.getElementById("forTesting")
    let searchChange = document.querySelector(".searchCT")
    console.log("-------try---------" + searchChange.length)
    for (let i = 0; i < searchChange.length; i++) {
      searchChange[i].innerHTML() = ""
      console.log("-------test---------")
    }

  }
  function searchAllContract() {
    for (let i = 0; i < searchCT.length; i++) {
      let searchContract = document.getElementById("searchContract"
          + searchCheckBox[i].value)
      let searchStatus = document.getElementById("searchStatus"
          + searchCheckBox[i].value)
      let searchCID = document.getElementById("searchCID"
          + searchCheckBox[i].value)
      let searchnName = document.getElementById("searchName"
          + searchCheckBox[i].value)
      let searchRoom_Number = document.getElementById("searchRoom_Number"
          + searchCheckBox[i].value)
      let searchPayment_Status = document
          .getElementById("searchPayment_Status"
              + searchCheckBox[i].value)
      let searchCheck_Status = document
          .getElementById("searchCheck_Status"
              + searchCheckBox[i].value)
      let searchCheck_Fee = document.getElementById("searchCheck_Fee"
          + searchCheckBox[i].value)
      let searchPDF = document.getElementById("searchPDF"
          + searchCheckBox[i].value)
      let searchDeposit = document.getElementById("searchDeposit"
          + searchCheckBox[i].value)
      let searchRoom_Type = document.getElementById("searchRoom_Type"
          + searchCheckBox[i].value)
      searchContract
          .addEventListener(
              'click',
              function() {
                input1.value = searchnName.value
                input2.value = searchPDF.value
                input3.value = searchRoom_Number.value
                input4.value = searchDeposit.value
                input5.value = searchCheck_Fee.value
                input6.value = searchCID.value
                ContractStatus.value = searchStatus.value
                ContractPayment_status.value = searchPayment_Status.value
                ContractCheck_status.value = searchCheck_Status.value
                RoomItems.removeAttribute('style');
                // --------合約狀態判斷式----------
                if (searchStatus.value === renting) {
                  cks1.checked = true;
                  cks2.checked = false;
                  cks3.checked = false;
                } else if (searchStatus.value === retreat) {
                  cks2.checked = true;
                  cks1.checked = false;
                  cks3.checked = false;
                } else if (searchStatus.value === expired) {
                  cks3.checked = true;
                  cks1.checked = false;
                  cks2.checked = false;
                }
                // --------繳費狀態判斷式----------
                if (searchPayment_Status.value === paid) {
                  ckps1.checked = true;
                  ckps2.checked = false;
                } else if (searchPayment_Status.value === unpaid) {
                  ckps2.checked = true;
                  ckps1.checked = false;
                }
                // --------點交判斷式----------
                if (searchCheck_Status.value === unHandover) {
                  ckcs1.checked = true;
                  ckcs2.checked = false;
                } else if (searchCheck_Status.value === handover) {
                  ckcs1.checked = false;
                  ckcs2.checked = true;
                }
                //                   ------------  // 房型判斷式------------
                if (searchRoom_Type.value == "單人房A") {
                  TV.value = `*${allRoomType.get(0).TV}`
                  WaterHeater.value = `*${allRoomType.get(0).waterHeater}`
                  Airconditioner.value = `*${allRoomType.get(0).airconditioner}`
                  Freezer.value = `*${allRoomType.get(0).freezer}`
                  window1.value = `*${allRoomType.get(0).screen}`
                  Chair.value = `*${allRoomType.get(0).chair}`
                  Bed.value = `(雙)*${allRoomType.get(0).doubleBed}`
                  Desk.value = `(大)*${allRoomType.get(0).bigDesk}`
                  SideTable.value = `(大)*${allRoomType.get(0).bigSideTable}`
                  Wardrobe.value = `*${allRoomType.get(0).wardrobe}`
                } else if (searchRoom_Type.value == "單人房B") {
                  TV.value = `*${allRoomType.get(1).TV}`
                  WaterHeater.value = `*${allRoomType.get(1).waterHeater}`
                  Airconditioner.value = `*${allRoomType.get(1).airconditioner}`
                  Freezer.value = `*${allRoomType.get(1).freezer}`
                  window1.value = `*${allRoomType.get(1).screen}`
                  Chair.value = `*${allRoomType.get(1).chair}`
                  Bed.value = `(雙)*${allRoomType.get(1).doubleBed}`
                  Desk.value = `(大)*${allRoomType.get(1).bigDesk}`
                  SideTable.value = `(大)*${allRoomType.get(1).bigSideTable}`
                  Wardrobe.value = `*${allRoomType.get(1).wardrobe}`
                } else if (searchRoom_Type.value == "單人房C") {
                  TV.value = `*${allRoomType.get(2).TV}`
                  WaterHeater.value = `*${allRoomType.get(2).waterHeater}`
                  Airconditioner.value = `*${allRoomType.get(2).airconditioner}`
                  Freezer.value = `*${allRoomType.get(2).freezer}`
                  window1.value = `*${allRoomType.get(2).screen}`
                  Chair.value = `*${allRoomType.get(2).chair}`
                  Bed.value = `(雙)*${allRoomType.get(2).doubleBed}`
                  Desk.value = `(大)*${allRoomType.get(2).bigDesk}`
                  SideTable.value = `(大)*${allRoomType.get(2).bigSideTable}`
                  Wardrobe.value = `*${allRoomType.get(2).wardrobe}`
                } else if (searchRoom_Type.value == "雙人房A") {
                  TV.value = `*${allRoomType.get(3).TV}`
                  WaterHeater.value = `*${allRoomType.get(3).waterHeater}`
                  Airconditioner.value = `*${allRoomType.get(3).airconditioner}`
                  Freezer.value = `*${allRoomType.get(3).freezer}`
                  window1.value = `*${allRoomType.get(3).screen}`
                  Chair.value = `*${allRoomType.get(3).chair}`
                  Bed.value = `(單)*${allRoomType.get(3).singleBed}`
                  Desk.value = `(小)*${allRoomType.get(3).smallDesk}`
                  SideTable.value = `(小)*${allRoomType.get(3).smallSideTable}`
                  Wardrobe.value = `*${allRoomType.get(3).wardrobe}`
                } else if (searchRoom_Type.value == "雙人房B") {
                  TV.value = `*${allRoomType.get(4).TV}`
                  WaterHeater.value = `*${allRoomType.get(4).waterHeater}`
                  Airconditioner.value = `*${allRoomType.get(4).airconditioner}`
                  Freezer.value = `*${allRoomType.get(4).freezer}`
                  window1.value = `*${allRoomType.get(4).screen}`
                  Chair.value = `*${allRoomType.get(4).chair}`
                  Bed.value = `(單)*${allRoomType.get(4).singleBed}`
                  Desk.value = `(小)*${allRoomType.get(4).smallDesk}`
                  SideTable.value = `(小)*${allRoomType.get(4).smallSideTable}`
                  Wardrobe.value = `*${allRoomType.get(4).wardrobe}`
                } else if (searchRoom_Type.value == "雙人房C") {
                  TV.value = `*${allRoomType.get(5).TV}`
                  WaterHeater.value = `*${allRoomType.get(5).waterHeater}`
                  Airconditioner.value = `*${allRoomType.get(5).airconditioner}`
                  Freezer.value = `*${allRoomType.get(5).freezer}`
                  window1.value = `*${allRoomType.get(5).screen}`
                  Chair.value = `*${allRoomType.get(5).chair}`
                  Bed.value = `(雙)*${allRoomType.get(5).doubleBed}`
                  Desk.value = `(大)*${allRoomType.get(5).bigDesk}`
                  SideTable.value = `(大)*${allRoomType.get(5).bigSideTable}`
                  Wardrobe.value = `*${allRoomType.get(5).wardrobe}`
                }
              })
    }
  }
</script>
<%@include file="fragment/footer.jsp"%>
</body>
</html>