<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
$.getJSON('/home/common/RepairForm.do?doJob=getProject').then(res => {
  console.log(res)
  let projectOption="";
  projectOption +="<option value='0'>請選擇報修項目</option>";
  for (let i = 0; i < res.furnitureList.length; i++) {
    projectOption += "<option value='" + res.furnitureList[i] + "'>" + res.furnitureList[i] + "</option>";
  }
  $('#inputState').append(projectOption);
  $('#repairFormRoom').text(res.roomNumber);
  $('#repairFormApplicant').text(res.memberName);
  $('#repairFormPhone').attr("value",res.memberPhone);
});
</script>

<form name="insertRepairFormInfo" action="<c:url value="#"/>"
	method="POST" class="bg-white" enctype="multipart/form-data">
	<input type="text" id="insertRepairFormInfo"
		value="insertRepairFormInfo" name="profile" hidden />

	<div class="container px-5 border">
		<div class="row">
			<div class="col">
			
				<div class="row mt-5">
            <div class="col">
              <h6 class="text-black-opacity-05">房號 insert</h6>
              <h3 class="text-black-opacity-05" id="repairFormRoom"></h3>
            </div>
            <div class="col">
              <h6 class="text-black-opacity-05 ">申請人</h6>
              <h3 class="text-black-opacity-05" id="repairFormApplicant"></h3>
            </div>
          </div>

          <div class="row mt-5">
            <div class="col">
              <h6 class="text-black-opacity-05">連絡電話</h6>
              <input type="text" id="repairFormPhone" class="form-control col-12 px-4"
                name="repairFormPhone" value="null">
            </div>
            <div class="col">
              <h6 class="text-black-opacity-05 ">項目</h6>
              <select name="county" class="form-control" id="inputState">
              
              </select>
            </div>
          </div>

          <div class="row mt-5">
            <div class="col">
              <h6 class="text-black-opacity-05">報修申請日期</h6>
              <input type="text" id="repairFormCreateTime" class="form-control col-12 px-4 datepicker"
                name="repairFormCreateTime" value="null">
                
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
              <input type="text" id="fname" class="form-control col-12 px-4"
                name="repairFormNote" value=" ">
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

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
//let tempCreateTime;
//let tempExpectTime;

$(document).ready(function(){
  tempCreateTime= $('#repairFormCreateTime').attr("value");
  tempExpectTime= $('#repairFormExpectTime').attr("value");
})
$('#repairFormCreateTime').datepicker({
   language: 'zh-CN',
   format: 'yyyy/mm/dd',
   startDate: 0
  });
$('#repairFormCreateTime').datepicker( "setDate" , ${tempCreateTime});

$('#repairFormExpectTime').datepicker({
     language: 'zh-CN',
     format: 'yyyy/mm/dd',
     startDate: 0
    });
  $('#repairFormExpectTime').datepicker( "setDate" , ${tempExpectTime});

</script>