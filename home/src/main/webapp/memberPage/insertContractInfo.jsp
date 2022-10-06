<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	$(function() {
		$('#myzip').twzipcode({
			'countySel' : `${memberInfo.county}`,
			'districtSel' : `${memberInfo.district}`,
			zipcodeIntoDistrict : true,
			css : [ "county form-control", "district form-control" ],
			countyName : "county2",
			districtName : "district2",
			onCountySelect : changecb,
			onDistrictSelect : changecb
		});
		var el = document.querySelectorAll("select");

		el[0].className = "form-control";
		el[0].id = "inputState3";
		el[1].className = "form-control";
		el[1].id = "inputState4";

		function changecb() {
			var county = $('#myzip').twzipcode('get', 'county2');
			var district = $('#myzip').twzipcode('get', 'district2');
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
			<h2 class="text-black mb-4">契約簽訂資訊</h2>
		</div>
	</div>
</div>
<section class="site-section" id="about-section">
	<form name="contractInfo"
		action="<c:url value="/MemberContractInfoUpdate.do"/>" method="post"
		class="bg-white" enctype="multipart/form-data">
		<div class="container px-5 border">

			<div class="row lg-mx-5">
				<div class="col lg-mx-5  ">
					<div class="" style="display: flex; justify-content: center;">
						<h4 class="text-black mt-5">監護人／緊急聯絡人</h4>
						<br>
					</div>
					<div class="" style="display: flex; justify-content: center;">
						<font class="text-red mb-4 lg-ml-2" style="color: red;">小叮嚀:簽約前請先完成以下欄位資訊，以利加速簽約程序</font>
						<input type="text" id="insertContractInfo" value="insertContractInfo"
							name="profile" hidden>
					</div>
				</div>
			</div>
			<% session.setAttribute("guarantorId", "insertPage"); %>
			<div class="row lg-mx-5">
				<div class="col lg-mx-5 ">
					<h6 class="text-black-opacity-05 mx-4">姓名</h6>
					<input type="text"  class="form-control col-12 mb-4 mx-4"
						name="guarantorName" value="${param.guarantorName}">
				</div>

				<div class="col lg-mx-5  ">
					<h6 class="text-black-opacity-05 mx-4">關係</h6>
					<input type="text"  class="form-control col-12 mb-4 mx-4"
						name="guarantorRelation" value="${param.guarantorRelation}">
				</div>
			</div>

			<div class="row lg-mx-5">
				<div class="col lg-mx-5 ">
					<h6 class="text-black-opacity-05 mx-4">身份字號</h6>
					<input type="text"
						class="form-control col-12 mx-4 mb-4"
						name="guarantorIdNumber" value="${param.guarantorIdNumber}">
				</div>
				<div class="col lg-mx-5">
					<h6 class="text-black-opacity-05 mx-4">聯絡手機號碼</h6>
					<input type="text" 
						class="form-control mx-4 col-12 mb-4" name="guarantorPhone"
						value="${param.guarantorPhone}">
				</div>
			</div>
			<div class="row lg-mx-5">
				<div class="col lg-mx-5 ">
					<h6 class="text-black-opacity-05 mx-4">戶籍地址</h6>
					<div class="form-row ml-3" id="myzip"></div>
				</div>
				<div class="col lg-mx-5 ">
					<h6 class="text-black-opacity-05 mx-4">&nbsp;</h6>
					<input type="text" id="fname"
						class="form-control mx-4 col-md-12"
						name="guarantorAddress" value="${param.guarantorAddress}">
				</div>
			</div>
		</div>



		<div class="row mb-1 mt-5 mx-3">
			<div class="col-md-12 text-left">
				<div class="" style="display: flex; justify-content: center;">
					<button class="btn btn-edit mr-2 mb-2" type="submit">我要儲存</button>
					<button type="button"  class="btn btn-edit mr-2 mb-2" onclick="dropForm()" id="dropIt">放棄新增</button>
				</div>
			</div>
		</div>

	</form>
</section>

