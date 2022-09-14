let resData;
let myformNumber;
let myformStatus;
let fromApplicant;
let myformRoom;
let myformPhone;
let myformCreatetime;
let myformProjectNameAlias;
let myformNote;
let myformExpectionTime;
let time;

$.getJSON('/home/common/RepairForm.do?doJob=repairFormInfo').then(res => {
  console.log(res);
  //console.log(res.repairFormList[1].status);
  
  if(res.repairFormList.length>0 && res.roomNumber!=="非租客"){
  resData = res.repairFormList;
  let repairTable = "";
  let timeStatus;

  for (let i = 0; i < res.repairFormList.length; i++) {
    let myStatus;
    let status;
    status = res.repairFormList[i].status;

    switch (status) {
      case 0: {
        myStatus = "待處理";
        timeStatus = "待處理";
        break;
      }
      case 1: {
        myStatus = "處理中";
        timeStatus = "評估中";
        break;
      }
      case 2: {
        myStatus = "已完成";
        timeStatus = res.repairFormList[i].finishTime;
        break;
      }
    }

    repairTable += `
      <tr>
        <th scope="row"><div class="text-center">${i + 1}</div></th>
        <td><div class="text-center">${res.repairFormList[i].repairFormNumber}</div></td>
        <td><div class="text-center">${res.repairFormList[i].projectAlias}</div></td>
        <td><div class="text-center">${myStatus}</div></td>
        <td><div class="text-center">${res.repairFormList[i].repairFormCreatTime}</div></td>
        <td><div class="text-center">${timeStatus}</div></td>
        <td><div class="text-center">`;
          
    if(res.repairFormList[i].status==0){
          repairTable += `<button class="btntable btn-table mx-1 my-1" id="editRepairFormBtn"
            onclick="updateRepairForm(this)" value="${res.repairFormList[i].repairFormNumber}"
            style="width: 60px; height: 30px;">
            <h6>修改</h6>
          </button>
          <button class="btntable btn-table mx-1 my-1" id="deleteRepairForm"
            onclick="deleteRepairForm()"
            style="width: 60px; height: 30px;">
            <h6>刪除</h6>
          </button>`;
          } else{
          repairTable +=`<button class="btntable btn-table mx-1 my-1" id="editRepairFormBtn"
            onclick="viewRepairForm(this)" value="${res.repairFormList[i].repairFormNumber}"
            style="width: 60px; height: 30px;">
            <h6>查看</h6>
          </button>`;
          }
          
         repairTable += `</div> </td> </tr>`;
  }
  $('#repairForm').append(repairTable);
  
  } else if(res.roomNumber==="非租客"){
  let info = "<div class='my-5' style='display: flex; justify-content: center;'>"+
      "<h3 class='text-black my-5'>非租客身分無法使用報修功能</h3>"+
    "</div>";
  
  $('#repairFormPage').html("");
  $('#repairFormPage').load('memberPage/showRepairNoInfo.jsp',function(){
  $('#newRepairBtn').hide();
  $('#showInfo').html("");
  $('#showInfo').append(info);});
  } else{
  $('#repairFormPage').html("");
  $('#repairFormPage').load('memberPage/showRepairNoInfo.jsp',function(){
  $('#newRepairBtn').hide();});
  }
  
});



function updateRepairForm(item) {
  myformNumber = item.getAttribute('value');

  for (let i = 0; i < resData.length; i++) {
    if (resData[i].repairFormNumber === myformNumber) {
      fromApplicant = resData[i].applicantName;
      myformRoom = resData[i].repairRoomNumber;
      myformPhone = resData[i].applicantPhone;
      myformCreatetime = resData[i].repairFormCreatTime;
      myformProjectNameAlias = resData[i].projectAlias;
      myformNote = resData[i].note;
      myformExpectionTime= resData[i].repairFormExpectionTime;
      myformStatus = transfromStatus( resData[i].status);
    }
  }
  innerPage = "editRepairForminfo";
  $('#repairFormPage').html("");
  $('#repairFormPage').load('memberPage/editRepairForm.jsp',
    function(){
      $('#repairFormNumber').text(myformNumber);
      $('#repairFormStatus').text(myformStatus);
      $('#repairFormRoom').text(myformRoom);
      $('#repairFormApplicant').text(fromApplicant);
      $("input[name='repairFormPhone']").attr("value",myformPhone);
      $("input[name='repairFormProject']").val("value", myformProjectNameAlias);
      $("input[name='repairFormCreateTime']").attr("value", myformCreatetime);
      $("input[name='repairFormExpectTime']").attr("value",myformExpectionTime);
      $("input[name='repairFormNote']").attr("value",myformNote);
      
      $("#inputState").find("option:contains('"+ myformProjectNameAlias +"')").attr("selected",true);
      $('#newRepairBtn').hide();
      time = $('#repairFormCreateTime').val();
  });
  
 
  alert(myformProjectNameAlias);
  
  $("html,body").animate(
    {
      scrollTop: 0,
    },
    600
  );
}


function viewRepairForm(item) {
  myformNumber = item.getAttribute('value');

  for (let i = 0; i < resData.length; i++) {
    if (resData[i].repairFormNumber === myformNumber) {
      fromApplicant = resData[i].applicantName;
      myformRoom = resData[i].repairRoomNumber;
      myformPhone = resData[i].applicantPhone;
      myformCreatetime = resData[i].repairFormCreatTime;
      myformProjectNameAlias = resData[i].projectAlias;
      myformNote = resData[i].note;
      myformExpectionTime= resData[i].repairFormExpectionTime;
      myformStatus = transfromStatus( resData[i].status);
    }
  }
  innerPage = "editRepairForminfo";
  $('#repairFormPage').html("");
  $('#repairFormPage').load('memberPage/showRepairFormContent.jsp',
    function(){
      $('#repairFormNumber').text(myformNumber);
      $('#repairFormStatus').text(myformStatus);
      $('#repairFormRoom').text(myformRoom);
      $('#repairFormApplicant').text(fromApplicant);
      $("#repairFormPhone").text(myformPhone);
      $("#repairFormProject").text(myformProjectNameAlias);
      $("#repairFormCreateTime").text(myformCreatetime);
      $("#repairFormExpectTime").text(myformExpectionTime);
      $("#repairFormNote").text(myformNote);
      $('#newRepairBtn').hide();
  });
  
 
  alert(myformProjectNameAlias);
  
  $("html,body").animate(
    {
      scrollTop: 0,
    },
    600
  );
}

function transfromStatus(status){
  let myStatus;
  switch (status) {
      case 0: {
        myStatus = "待處理";
        break;
      }
      case 1: {
        myStatus = "處理中";
        break;
      }
      case 2: {
        myStatus = "已完成";
        break;
      }
    }
    return myStatus;
}


