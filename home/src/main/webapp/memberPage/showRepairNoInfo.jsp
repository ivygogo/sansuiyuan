<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row lg-mx-5">
	<div class="col lg-mx-5 mx-5 border my-5" id="showInfo">
		<div class="" style="display: flex; justify-content: center;">
			<h3 class="text-black mt-5">您目前尚未新增資料</h3>
		</div>
		<div class="" style="display: flex; justify-content: center;">
			<h3 class="text-black">如有報修需求，請點擊新增按鈕</h3>
			<br>
		</div>

		<div class="" style="display: flex; justify-content: center;">
			<h3 class="text-black mb-5">以利後續作業</h3>
			<br>
		</div>
		<div class="" style="display: flex; justify-content: center;">
			<h3>
				<button class="btn btn-edit mr-2 mb-2" id="editContractInfo"
					onclick=" updateRepairPage(0)">新增報修單</button>
			</h3>
		</div>
	</div>
</div>