<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

				<c:choose>
					<c:when test="${LoginOK.guarantor==null}">
						<div class="row lg-mx-5">
							<div class="col lg-mx-5 mx-5 border ">
								<div class="" style="display: flex; justify-content: center;">
									<h3 class="text-black mt-5">您目前尚未新增資料</h3>
								</div>
								<div class="" style="display: flex; justify-content: center;">
									<h3 class="text-black">如有租屋需求</h3>
									<br>
								</div>
								<div class="" style="display: flex; justify-content: center;">
									<h3 class="text-black">請先填妥監護人／緊急聯絡人資料</h3>
									<br>
								</div>
								<div class="" style="display: flex; justify-content: center;">
									<h3 class="text-black mb-5">以利後續簽約作業</h3>
									<br>
								</div>
								<div class="" style="display: flex; justify-content: center;">
									<h3>
										<button class="btn btn-edit mr-2 mb-2" id="editContractInfo"
											onclick="updateContractinfo()">新增契約簽訂資訊</button>
									</h3>
								</div>
							</div>
						</div>
					</c:when>

					<c:otherwise>
					<h6 class="text-black-opacity-05 mt-4 mx-4">姓名</h6>
            <h3 class="text-black mb-4 mx-4">${LoginOK.guarantor.name}</h3>
            <h6 class="text-black-opacity-05 mx-4">關係</h6>
            <h3 class="text-black mb-4 mx-4">${LoginOK.guarantor.relation}</h3>
            <h6 class="text-black-opacity-05 mx-4">身分證號</h6>
            <h3 class="text-black mb-4 mx-4">${LoginOK.guarantor.id_number}</h3>
            <h6 class="text-black-opacity-05 mx-4">聯絡電話</h6>
            <h3 class="text-black mb-4 mx-4">${LoginOK.guarantor.phone}</h3>
					  <h6 class="text-black-opacity-05 mx-4">地址</h6>
            <h3 class="text-black mb-4 mx-4">${LoginOK.guarantor.county}${LoginOK.guarantor.district}${LoginOK.guarantor.address}</h3>

						<div class="" style="display: flex; justify-content: center;">
							<h3>
								<button class="btn btn-edit mr-2 mb-4 mt-4" id="editContractInfo"
									onclick="updateContractinfo()">修改契約簽訂資訊</button>
							</h3>
						</div>
					</c:otherwise>
				</c:choose>

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
				<c:choose>
					<c:when test="${LoginOK.refundAccount==null}">
						<div class="row lg-mx-5">
							<div class="col lg-mx-5 mx-5 border mb-5">
								<div class="" style="display: flex; justify-content: center;">
									<h3 class="text-black mt-5">您目前尚未新增資料</h3>
								</div>
								<div class="" style="display: flex; justify-content: center;">
									<h3 class="text-black">如有租屋需求</h3>
									<br>
								</div>
								<div class="" style="display: flex; justify-content: center;">
									<h3 class="text-black">請先填妥監護人／緊急聯絡人資料</h3>
									<br>
								</div>
								<div class="" style="display: flex; justify-content: center;">
									<h3 class="text-black mb-5">以利後續簽約作業</h3>
									<br>
								</div>
								<div class="" style="display: flex; justify-content: center;">
									<h3>
										<button class="btn btn-edit mr-2 mb-2" id="editContractInfo"
											onclick="updateRefundinfo()">新增退款資訊</button>
									</h3>
								</div>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<h6 class="text-black-opacity-05 mt-4 mx-4">銀行名稱</h6>
						<h3 class="text-black mb-4 mx-4">${LoginOK.refundAccount.refundBank}</h3>
						<h6 class="text-black-opacity-05 mx-4">分行名稱</h6>
						<h3 class="text-black mb-4 mx-4">${LoginOK.refundAccount.bankStore}</h3>
						<h6 class="text-black-opacity-05 mx-4">受款人姓名</h6>
						<h3 class="text-black mb-4 mx-4">${LoginOK.refundAccount.refundName}</h3>
						<h6 class="text-black-opacity-05 mx-4">銀行帳號</h6>
						<h3 class="text-black mb-4 mx-4">${LoginOK.refundAccount.bankAccount}</h3>

						<div class="row mb-4 mt-4 mx-3">
							<div class="col-md-12 text-left">
								<div class="" style="display: flex; justify-content: center;">
									<h3>
										<button class="btn btn-edit mr-2 mb-4" id="editContractInfo"
											onclick="updateRefundinfo()">編輯退款資訊</button>
									</h3>
								</div>
							</div>
						</div>
					</c:otherwise>
				</c:choose>

			</div>
		</div>


	</div>
</section>

