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
					<c:when test="${LoginOK.guarantorList==null}">
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
						<%-- table 開始 --%>
						<c:forEach var="guarantor" items="${LoginOK.guarantorList}" varStatus="vs">
						<c:if test="${vs.first}">
						<div class="table-responsive">
						<table class="table table-striped ">
							<thead>
								<tr>
									<th scope="col "><div class="text-center">#</div></th>
									<th scope="col text-center"><div class="text-center">姓名</div></th>
									<th scope="col text-center"><div class="text-center">關係</div></th>
									<th scope="col text-center"><div class="text-center">身分證號</div></th>
									<th scope="col text-center"><div class="text-center">聯絡電話</div></th>
									<th scope="col text-center"><div class="text-center">地址</div></th>
									<th scope="col text-center"><div class="text-center">功能</div></th>
								</tr>
							</thead>
							<tbody>
							</c:if>
								<tr>
									<th scope="row"><div class="text-center">${vs.index+1}</div></th>
									<td><div class="text-center">${guarantor.name}</div></td>
									<td><div class="text-center">${guarantor.relation}</div></td>
									<td><div class="text-center">${guarantor.id_number}</div></td>
									<td><div class="text-center">${guarantor.phone}</div></td>
									<td><div class="text-center">${guarantor.county}${guarantor.district}${guarantor.address}</div></td>
									<td><div class="text-center">
										
										<button class="btntable btn-table mx-1 my-1" id="editContractInfo"
                      onclick="updateContractinfo(${vs.index})"
                      style="width: 60px; height: 30px;">
                      <h6>修改</h6>
                    </button>
                    <button class="btntable btn-table mx-1 my-1" id="editContractInfo"
                      onclick="updateContractinfo()"
                      style="width: 60px; height: 30px;">
                      <h6>刪除</h6>
                    </button></div>
									</td>
								</tr>
								
                <c:if test="${vs.last}">
							</tbody>
						</table>
						</div>
						</c:if>
  </c:forEach>

						<div class="" style="display: flex; justify-content: center;">
							<h3>
								<button class="btn btn-edit mr-2 mb-4 mt-4" id="editContractInfo"
									onclick="insertContractinfo()">新增契約簽訂資訊</button>
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
											onclick="updateContractinfo()">新增退款資訊</button>
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
											onclick="updateContractinfo()">編輯退款資訊</button>
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

