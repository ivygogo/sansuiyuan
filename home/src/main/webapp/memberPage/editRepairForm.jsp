<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
 String formNumber = request.getParameter("page");
System.out.println("!!!!!!!"+formNumber);
 session.setAttribute("RepairFormNumber", formNumber);
 session.setAttribute("page", "editForm");
%>
<script type="text/javascript">

</script>


<div class="row mb-1 mt-5 ml-3">
	<div class="col-md-12 text-left">
		<div class="" style="display: flex; justify-content: center;">
			<h2 class="text-black mb-4">EDIT報修單</h2>
		</div>
	</div>
</div>

<section class="site-section" id="about-section">
	<form name="repairFormInfo"
		action="<c:url value="/common/RepairForm.do"/>" method="POST"
		class="bg-white" >
		<input type="text" id="updateContractInfo" value="updateContractInfo"
			name="profile" hidden />

		<div class="container px-5 border">
        <div class="row">
            <div class="col">

					<div class="row mt-5">
						<div class="col">
							<h6 class="text-black-opacity-05">單號B</h6>
							<h3 class="text-black-opacity-05" id="repairFormNumber"></h3>
						</div>
						<div class="col">
							<h6 class="text-black-opacity-05 ">報修處理進度</h6>
							<h3 class="text-black-opacity-05" id="repairFormStatus"></h3>
							
						</div>
					</div>

					<div class="row mt-5">
						<div class="col">
							<h6 class="text-black-opacity-05">房號</h6>
							<h3 class="text-black-opacity-05" id="repairFormRoom"></h3>
						</div>
						<div class="col">
						<h6 class="text-black-opacity-05">報修申請日期</h6>
              <h3 class="text-black-opacity-05" id="repairFormCreateTime"></h3>
							
						</div>
					</div>

					<div class="row mt-5">
						<div class="col">
						<h6 class="text-black-opacity-05 ">申請人</h6>
                <input type="text" id="repairFormApplicant" class="form-control col-12 px-4 datepicker"
                name="repairFormApplicant" value="null">
							
						</div>
						<div class="col">
							<h6 class="text-black-opacity-05 ">項目</h6>
							<select name="project" class="form-control" id="inputState">
							
							</select>
						</div>
					</div>

					<div class="row mt-5">
						<div class="col">
							<h6 class="text-black-opacity-05">連絡電話</h6>
              <input type="text" id="fname" class="form-control col-12 px-4"
                name="repairFormPhone" value="${LoginOK.guarantor.id_number}">
						</div>
						<div class="col">
							<h6 class="text-black-opacity-05 ">期望修繕時間</h6>
							<input type="text" id="repairFormExpectTime" class="form-control col-12 datepicker"
								name="repairFormExpectTime" value="null">
						</div>
					</div>

					<div class="row mt-5">
            <div class="col">
              <h6 class="text-black-opacity-05">備註</h6>
              <textarea  type="text" id="repairFormNote" class="form-control col-12 px-4"
                name="repairFormNote" value=" " maxlength="15"> </textarea>
            </div>
          </div>


					<div class="row mb-1 mt-5 mx-3">
						<div class="col-md-12 text-left">
							<div class="" style="display: flex; justify-content: center;">
								<button class="btn btn-edit mr-2 mb-2" type="submit">我要儲存</button>
								<button type="button" class="btn btn-edit mr-2 mb-2"
									onclick="dropForm(this)" id="dropIt">放棄修改</button>
							</div>
						</div>
					</div>
			


		</div>
</div>
</div>

	</form>
</section>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
let expectdate = $("#repairFormExpectTime").val();

$('#repairFormExpectTime').datepicker({
	   language: 'zh-CN',
	   format: 'yyyy/mm/dd',
	   startDate: '+7d'
	  }).on("change", function() {
		  
	        if($("#repairFormExpectTime").datepicker().val()==null){
	            $('#repairFormExpectTime').attr("value",expectdate);
	            
	          }else{
	            $('#repairFormExpectTime').attr("value",$("#repairFormExpectTime").datepicker().val());
	          }
	          
	        });
$('#repairFormExpectTime').datepicker( "setDate" ,expectdate);
//alert("尾巴" + expectdate)
})

</script>
