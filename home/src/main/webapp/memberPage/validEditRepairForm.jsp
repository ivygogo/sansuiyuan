<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
 String formNumber = (String)session.getAttribute("RepairFormNumber");
 session.setAttribute("RepairFormNumber", formNumber);
 session.setAttribute("page", "editForm");
%>
<script type="text/javascript">
$.getJSON('/home/common/RepairForm.do?doJob=getProject').then(res => {
	console.log(res)
	let projectOption="";
	for (let i = 0; i < res.furnitureList.length; i++) {
		projectOption += "<option value='" + res.furnitureList[i] + "'>" + res.furnitureList[i] + "</option>";
	}
	$('#inputState').append(projectOption);
	$("#inputState").find("option:contains('"+ `${Project}` +"')").attr("selected",true); 
});


</script>


<div class="row mb-1 mt-5 ml-3">
	<div class="col-md-12 text-left">
		<div class="" style="display: flex; justify-content: center;">
			<h2 class="text-black mb-4">editValid報修單</h2>
		</div>
	</div>
</div>

<section class="site-section" id="about-section">
	<form name="repairFormInfo"
		action="<c:url value="/common/RepairForm.do"/>" method="POST"
		class="bg-white">
		<input type="text" id="updateContractInfo" value="updateContractInfo"
			name="profile" hidden />

		<div class="container px-5 border">
			<div class="row">
				<div class="col">

					<div class="row mt-5">
						<div class="col">
							<h6 class="text-black-opacity-05">單號B</h6>
							<h3 class="text-black-opacity-05" id="repairFormNumber">${RepairFormNumber}</h3>
						</div>
						<div class="col">
							<h6 class="text-black-opacity-05 ">報修處理進度</h6>
							<h3 class="text-black-opacity-05" id="repairFormStatus">${FormStatus}</h3>

						</div>
					</div>

					<div class="row mt-5">
						<div class="col">
							<h6 class="text-black-opacity-05">房號</h6>
							<h3 class="text-black-opacity-05" id="repairFormRoom">${roomNumber}</h3>
						</div>
						<div class="col">
							<h6 class="text-black-opacity-05">報修申請日期</h6>
							<h3 class="text-black-opacity-05" id="repairFormCreateTime">${expectTime}</h3>

						</div>
					</div>

					<div class="row mt-5">
						<div class="col">
							<h6 class="text-black-opacity-05 ">申請人</h6>
							<c:choose>
								<c:when test="${ErrMsg.Aapplicant!=null}">
									<input type="text" name="repairFormApplicant"
										id="repairFormApplicant"
										class="form-control is-invalid col-12 px-4"
										value="${param.repairFormApplicant}">
									<div class="invalid-feedback col-12 px-2">${ErrMsg.Aapplicant}</div>
								</c:when>
								<c:otherwise>
									<input type="text" id="repairFormApplicant"
										class="form-control col-12 px-4" name="repairFormApplicant"
										value="${Aapplicant}">
								</c:otherwise>
							</c:choose>
						</div>

						<div class="col">
							<h6 class="text-black-opacity-05 ">項目</h6>
							<c:choose>
								<c:when test="${ErrMsg.Project!=null}">
									<select name="project" class="form-control is-invalid"
										id="inputState">
									</select>
									<div class="invalid-feedback col-12 px-2">${ErrMsg.Project}</div>
								</c:when>
								<c:otherwise>
									<select name="project" class="form-control" id="inputState">
									</select>
								</c:otherwise>
							</c:choose>
						</div>
					</div>

					<div class="row mt-5">
						<div class="col">
							<h6 class="text-black-opacity-05">連絡電話</h6>
							<c:choose>
								<c:when test="${ErrMsg.errPhone!=null}">
									<input type="text" name="repairFormPhone" id="repairFormPhone"
										class="form-control is-invalid col-12 px-4"
										value="${param.repairFormPhone}">
									<div class="invalid-feedback col-12 px-2">${ErrMsg.errPhone}</div>
								</c:when>

								<c:otherwise>
									<input type="text" id="repairFormPhone"
										class="form-control col-12 px-4" name="repairFormPhone"
										value="${Phone}">
								</c:otherwise>
							</c:choose>
						</div>
						<div class="col">
							<h6 class="text-black-opacity-05 ">期望修繕時間</h6>
							<c:choose>
								<c:when test="${ErrMsg.expectTime!=null}">
									<input type="text" name="repairFormExpectTime"
										id="repairFormExpectTime"
										class="form-control is-invalid col-12 px-4 datepicker"
										value="${param.repairFormExpectTime}">
									<div class="invalid-feedback col-12 px-2">${ErrMsg.expectTime}</div>
								</c:when>

								<c:otherwise>
									<input type="text" id="repairFormExpectTime"
										class="form-control col-12 px-4 datepicker"
										name="repairFormExpectTime" value="${expectTime}">
								</c:otherwise>
							</c:choose>
						</div>
					</div>

					<div class="row mt-5">
						<div class="col">
							<h6 class="text-black-opacity-05">備註</h6>
							<textarea type="text" id="repairFormNote"
								class="form-control col-12 px-4" name="repairFormNote"
								maxlength="15">${param.repairFormNote}</textarea>
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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
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

})
/*
$('#submit').click(function () {
	const myformNumber = $("#repairFormNumber").text() 
	const myroomNumber = $("#").
	const myformcreateTime = $("#").
	const myformapplicant = $("#").
	const myformproject = $("#").
	const myformphone = $("#").
	const myformexpectTime = $("#").
	const myformnote = $("#").

    const selectTimePick = $('#preferTime').val()
    const selectFloor = $('#preferFloor').val()
    const selectDate = $('#datepicker').val()
    const selectUserName = $('#bookerName').val()
    const selectRoomType = $('#booking-room-type').val()

    $.ajax({
      type: 'POST',
      url: '/wuli/ChatroomServlet?callFrom=createChatroom',
      data: {
        'Id': userId,
        'chatTarget': 0,
        'chatType': 'B',
        'userName': selectUserName,
        'timePick': selectTimePick,
        'floor': selectFloor,
        'selectDate': selectDate,
        'roomType': selectRoomType
      },
      err: function () {
        console.log('createChatroom with error')
      }
    })
  })*/
</script>
