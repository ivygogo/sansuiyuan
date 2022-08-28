<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
$(function() {
    $('#myzip').twzipcode({
      'countySel2' : `${memberInfo.county}`,
      'districtSel2' : `${memberInfo.district}`,
      zipcodeIntoDistrict : true,
      css : [ "county form-control", "district form-control" ],
      countyName : "county2", // 自訂城市 select 標籤的 name 值
      districtName : "district2", // 自訂區別 select 標籤的 name 值
      onCountySelect : changecb,
      onDistrictSelect : changecb
    });
    var el = document.querySelectorAll("select");

    el[0].className = "form-control";
    el[0].id = "inputState3";
    el[1].className = "form-control";
    el[1].id = "inputState4";

    function changecb() {
      // 取得縣市 county（返回字串）
      var county = $('#myzip').twzipcode('get', 'county2');
      var district = $('#myzip').twzipcode('get', 'district2');
      //var result = $('#zipzip').twzipcode('get', 'county,district'); // 以 , 字串傳入
      //console.log(county);
      //console.log(district);
    }
  });

  $(function() {
    var oldChild = document.getElementById('inputState3');
    var wrapper = document.createElement('div');
    wrapper.className = "form-group col-md-6"
    wrapper.id = "zip3"
    var oldParent = document.getElementById('myzip');
    oldParent.appendChild(wrapper);
    wrapper.appendChild(oldChild);

    var oldChild2 = document.getElementById('inputState4');
    var wrapper2 = document.createElement('div');
    wrapper2.className = "form-group col-md-6";
    wrapper2.id = "zip4"
    oldParent.appendChild(wrapper2);
    wrapper2.appendChild(oldChild2);

  })
</script>
<div class="row mb-1 mt-5 ml-3">
	<div class="col-md-12 text-left">
		<div class="" style="display: flex; justify-content: center;">
			<h2 class="text-black mb-2">契約簽訂資訊</h2>
		</div>
	</div>
</div>
<section class="site-section" id="about-section">
	<form name="refundInfo" action="<c:url value="/MemberRefundAccountUpdate.do"/>" method="post" class="bg-white" enctype="multipart/form-data">
		
		<div class="row lg-mx-5">
        <div class="col lg-mx-5 ">
        
        </div>
    </div>
<br>
		<div class="container px-5 border">
			<div class="row lg-mx-5">
				<div class="col lg-mx-5 ">
					<div class="" style="display: flex; justify-content: center;">
						<h4 class="text-black mt-5">退款帳戶資訊Edit</h4>
					</div>
					<div class="" style="display: flex; justify-content: center;">
						<font class="text-black lg-ml-2"> 以下欄位皆為非必填資訊</font>
					</div>
				</div>
			</div>

			<div class="row lg-mx-5 mt-5">
				<div class="col lg-mx-5 ">
					<h6 class="text-black-opacity-05 mx-4">銀行名稱</h6>
					<input type="text" id="fname" name="refundBank"
						class="form-control col-12 mx-4"
						value="${LoginOK.refundAccount.refundBank}">
				</div>
				<div class="col lg-mx-5 ">
					<h6 class="text-black-opacity-05 mx-4">分行名稱</h6>
					<input type="text" id="fname" name="refundBankstore"
						class="form-control col-12 mx-4"
						value="${LoginOK.refundAccount.bankStore}">
				</div>
			</div>

			<div class="row lg-mx-5 my-4">
				<div class="col lg-mx-5">
					<h6 class="text-black-opacity-05 mx-4">受款人姓名</h6>
					<input type="text" id="fname" name="refundName"
						class="form-control col-12 mx-4"
						value="${LoginOK.refundAccount.refundName}">
				</div>
				<div class="col lg-mx-5">
					<h6 class="text-black-opacity-05 mx-4">銀行帳號</h6>
					<input type="text" id="fname" name="bankAccount"
						class="form-control col-12 mx-4"
						value="${LoginOK.refundAccount.bankAccount}">
					
				</div>
			</div>
		</div>

		<div class="row mb-1 mt-5 mx-3">
			<div class="col-md-12 text-left">
				<div class="" style="display: flex; justify-content: center;">
					<button class="btn btn-edit mr-2 mb-2" type="submit">我要儲存</button>
					<button type="button"  class="btn btn-edit mr-2 mb-2" onclick="dropForm()" id="dropIt">放棄修改</button>
				</div>
			</div>
		</div>

	</form>
</section>

