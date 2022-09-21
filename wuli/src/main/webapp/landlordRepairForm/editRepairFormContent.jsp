<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="form-example-wrap px-5" id="editRepairContent"">
	<div class="row">
		<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10"></div>
		<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ms-5">
			<button type="button" style="width: 50px">
				<img src="${pageContext.request.contextPath}/file/icon/diskette.png">
			</button>
		</div>
	</div>
	<form name='formType' action="<c:url value='/common/RepairForm.do'/>" method="POST" class="bg-white">
	<div class="row px-5 py-2">
		<div class="col"
			style="border-width: 1px; border-style: solid; border-color: #666;">

			<div class="cmp-tb-hd mx-4 mt-5" style="text-align: center;">

				<h1>修改報修單</h1>
			</div>

			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
					<div class="form-example-int ">
						<div class="form-group mx-5 mt-4">
							<h4 class="text-black">單號</h4>
							<div class="hrinfo mb-3"></div>
							<div class="nk-int-st mx-3 mb-4 text-black-50" id="formNumber">
								<h3></h3>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
					<div class="form-example-int mt-4">
						<div class="form-group mx-5 mt-4">
							<h4 class="text-black mt-4">房號</h4>
							<div class="hrinfo mb-3"></div>
							<div class="nk-int-st mx-3 mb-4 text-black-50" id="roomNumber">
								<h3></h3>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
					<div class="form-example-int ">
						<div class="form-group mx-5 mt-4">
							<h4 class="text-black">申請人</h4>
							<div class="hrinfo mb-3"></div>
							<div class="nk-int-st mx-3 mb-4 text-black-50" id="applicant">
								<h3></h3>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
					<div class="form-example-int mt-4">
						<div class="form-group mx-5 mt-4">
							<h4 class="text-black mt-4">電話</h4>
							<div class="hrinfo mb-3"></div>
							<div class="nk-int-st mx-3 mb-4 text-black-50"
								id="applicantPhone">
								<h3></h3>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
					<div class="form-example-int ">
						<div class="form-group mx-5 mt-4">
							<h4 class="text-black">項目</h4>
							<div class="hrinfo mb-3"></div>
							<div class="nk-int-st mx-3 mb-4 text-black-50" id="project">
								<h3></h3>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
					<div class="form-example-int mt-4">
						<div class="form-group mx-5 mt-4">
							<h4 class="text-black mt-4">狀態</h4>
							<div class="hrinfo mb-3"></div>
							<div class="nk-int-st mx-3 mb-4 text-black-50" id="repairStatus">
								<h3></h3>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
					<div class="form-example-int ">
						<div class="form-group mx-5 mt-4">
							<h4 class="text-black">申請日期</h4>
							<div class="hrinfo mb-3"></div>
							<div class="nk-int-st mx-3 mb-4 text-black-50" id="createTime">
								<h3></h3>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
					<div class="form-example-int mt-4">
						<div class="form-group mx-5 mt-4">
							<h4 class="text-black mt-4" >期望修繕時間</h4>
							<div class="hrinfo mb-3"></div>
							<div class="nk-int-st mx-3 mb-4 text-black-50" id="expectTime">
								<h3></h3>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="form-example-int mt-4">
						<div class="form-group mx-5 mt-4">
							<h4 class="text-black mt-4">備註</h4>
							<div class="hrinfo mb-3"></div>
							<div class="nk-int-st mx-3 mb-4 text-black-50" id="repairNote">
								<h3></h3>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%--分隔線--%>
			<hr style="border-top: 1px dotted #666;">

			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
					<div class="form-example-int ">
						<div class="form-group mx-5 mt-4">
							<h4 class="text" style="color:#37cfa2;">回覆修繕時間</h4>
							<div class="hrinfo mb-3"></div>
							<div class='input-group date py-2' id='datetimepicker1'>
								<input type='text' class="form-control" /> <span
									class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
					<div class="form-example-int mt-4">
						<div class="form-group mx-5 mt-4">
							<h4 class="text mt-4" style="color:#37cfa2;">費用</h4>
							<div class="hrinfo mb-3"></div>
							<div class="nk-int-st mx-3 mb-4 text-black-50" id="price">
							<input type="text" name="applicant"
                                    class="form-control input-lg "
                                    placeholder="Input Large">

							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="form-example-int mt-4">
						<div class="form-group mx-5 mt-4">
							<h4 class="text mt-4" style="color:#37cfa2;">備註</h4>
							<div class="hrinfo mb-3"></div>
							<div class="nk-int-st mx-3 mb-4 text-black-50">
								<textarea  type="text" id="repairFormNote" class="form-control col-12 px-4"
                name="landlordNote" value=" " maxlength="15"> </textarea>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%--
			<div class="" style="display: flex; justify-content: center;">
				<button class="btn btn-edit" id="editLandlordinfo"
					onclick="updateLandlordinfo()">編輯資料</button>
			</div>
			--%>
		</div>
	</div>
	</form>
</div>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>



<script type="text/javascript">
    $(function () {
        $('#datetimepicker1').datetimepicker(
        		{locale: 'zh-tw',//使用繁體中文界面
        	      format: 'YYYY-MM-D HH:mm:ss',//日期時間格式
        	      ignoreReadonly: true  //禁止使用者輸入 啟用唯讀
        		}
        		);
    });
 </script>

