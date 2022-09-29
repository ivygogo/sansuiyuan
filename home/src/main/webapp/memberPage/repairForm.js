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


function showFirst() {
  $.getJSON('/home/RepairForm.do?doJob=repairFormInfo').then(res => {
    //console.log(res);
    //console.log(res.repairFormList[1].status);

    if (res.repairFormList.length > 0 && res.roomNumber !== "非租客") {
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
            myStatus = "管理中";
            timeStatus = "管理中";
            break;
          }
          case 2: {
            myStatus = "處理中";
            timeStatus = "處理中";
            break;
          }
          case 3: {
            myStatus = "已完成";
            timeStatus = res.repairFormList[i].repairFormFinishTime;
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

        if (res.repairFormList[i].status == 0) {
          repairTable += `<button class="btntable btn-table mx-1 my-1" id="editRepairFormBtn"
              onclick="updateRepairForm(this)" value="${res.repairFormList[i].repairFormNumber}"
              style="width: 60px; height: 30px;">
              <h6>修改</h6>
            </button>
            <button class="btntable btn-table mx-1 my-1" id="deleteRepairForm"
              onclick="deleteRepairForm(this)" value="${res.repairFormList[i].repairFormNumber}"
              style="width: 60px; height: 30px;">
              <h6>刪除</h6>
            </button>`;
        } else {
          repairTable += `<button class="btntable btn-table mx-1 my-1" id="editRepairFormBtn"
              onclick="viewRepairForm(this)" value="${res.repairFormList[i].repairFormNumber}"
              style="width: 60px; height: 30px;">
              <h6>查看</h6>
            </button>`;
        }

        repairTable += `</div> </td> </tr>`;
      }
      $('#repairForm').append(repairTable);
      $('#newRepairBtn').attr("style","visibility:visible")
     

    } else if (res.roomNumber === "非租客") {
      let info = "<div class='my-5' style='display: flex; justify-content: center;'>" +
        "<h3 class='text-black my-5'>非租客身分無法使用報修功能</h3>" +
        "</div>";

      $('#repairFormPage').html("");
      $('#repairFormPage').load('memberPage/showRepairNoInfo.jsp', function() {
        $('#newRepairBtn').hide();
        $('#showInfo').html("");
        $('#showInfo').append(info);
      });
    } else {
      $('#repairFormPage').html("");
      $('#repairFormPage').load('memberPage/showRepairNoInfo.jsp', function() {
        $('#newRepairBtn').hide();
      });
    }

  });
}


/*列表修改按鈕*/
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
      myformExpectionTime = resData[i].repairFormExpectionTime;
      myformStatus = transfromStatus(resData[i].status);
    }
  }

  let loadpage = "";
  if (myformStatus === "待處理") {
    innerPage = "editRepairForminfo";
    loadpage = "memberPage/editRepairForm.jsp?page=" + myformNumber;
    $('#repairFormPage').html("");
    $('#repairFormPage').load(loadpage,
      function() {
        $('#repairFormNumber').text(myformNumber);
        $('#repairFormStatus').text(myformStatus);
        $('#repairFormRoom').text(myformRoom);
        $('#repairFormApplicant').attr("value", fromApplicant);
        $("input[name='repairFormPhone']").attr("value", myformPhone);
        //$("input[name='repairFormProject']").val("value", myformProjectNameAlias);
        getFurniture(myformProjectNameAlias);
        $("#repairFormCreateTime").text(myformCreatetime);
        $("input[name='repairFormExpectTime']").attr("value", myformExpectionTime);
        //alert(myformExpectionTime)
        $("#repairFormNote").text(myformNote);

        $('#newRepairBtn').hide();
        time = $('#repairFormCreateTime').val();
      });


    //alert(myformProjectNameAlias);

    $("html,body").animate(
      {
        scrollTop: 0,
      },
      600
    );
  } else {
    loadpage = "memberPage/showRepairNoInfo.jsp";
    let showHtml = " <div class='' style='display: flex; justify-content: center;'>"
      + "<h3 class='text-black mt-5'>您目前尚未新增資料</h3>  </div>"
      + "<div class='' style='display: flex; justify-content: center;'>"
      + "<h3 class='text-black'>如有報修需求，請點擊新增按鈕</h3> <br> </div>"
      + "<div class='' style='display: flex; justify-content: center;'>"
      + "<h3 class='text-black mb-5'>以利後續作業</h3> <br> </div>"
      + " <div class='' style='display: flex; justify-content: center;'> "
      + "<h3>"
      + "<button type='button' class='btn btn-edit mr-2 mb-2' "
      + " onclick='dropForm(this)' id='dropIt'> 回前頁 </button> </h3> </div>";



    $('#repairFormPage').html("");
    $('#repairFormPage').load(loadpage,
      function() {
        $('#showInfo').html("");
        $('#showInfo').append(showHtml);
      });
  }
}

/*列表查看按鈕*/
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
      myformExpectionTime = resData[i].repairFormExpectionTime;
      myformStatus = transfromStatus(resData[i].status);
    }
  }
  innerPage = "editRepairForminfo";
  $('#repairFormPage').html("");
  $('#repairFormPage').load('memberPage/showRepairFormContent.jsp',
    function() {
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


  //alert(myformProjectNameAlias);

  $("html,body").animate(
    {
      scrollTop: 0,
    },
    600
  );
}



function transfromStatus(status) {
  let myStatus;
  switch (status) {
    case 0: {
      myStatus = "待處理";
      break;
    }
    case 1: {
      myStatus = "管理中";
      break;
    }
    case 2: {
      myStatus = "處理中";
      break;
    }
    case 3: {
      myStatus = "已完成";
      break;
    }

  }
  return myStatus;
}

function deleteRepairForm(item) {
  myformNumber = item.getAttribute('value');
  var con;
  con = confirm("你確認要刪除報修單" + myformNumber);
  if (con == true) {
    $.ajax({
      data: {
        id: myformNumber //帶入向伺服器傳遞的資訊
      },
      url: '/home/RepairForm.do?page=deleteRepairForm',  //目標Route
      type: 'post', //請求方法
      timeout: 15000, //請求限時，單位是毫秒

      dataType: 'html', //預期從伺服器回傳的資料格式
      success: function() {
        window.location.reload();
      },
      error: function() {
        alert("nono")
      }
    });
  }
}

function getFurniture(myformProjectNameAlias) {
  $.getJSON('/home/RepairForm.do?doJob=getProject').then(res => {
    //console.log(res)
    let projectOption = "";
    for (let i = 0; i < res.furnitureList.length; i++) {
      if (res.furnitureList[i] === myformProjectNameAlias) {
        projectOption += "<option value='" + res.furnitureList[i] + "' selected>" + res.furnitureList[i] + "</option>";
      } else {
        projectOption += "<option value='" + res.furnitureList[i] + "'>" + res.furnitureList[i] + "</option>";
      }
    }
    $('#inputState').append(projectOption);
    //$("#inputState").find("option:contains('"+ `${Project}` +"')").attr("selected",true); 
  })
}




function showNewRepairForm(ridState) {
  let myformNumber;
  let newRoom;
  if (ridState === "getchat") {
    $.getJSON('/home/RepairForm.do?doJob=getchat').then(res => {
      myformNumber = res.formId.repairFormNumber;
     newRoom = Number(res.toRoom);
     //alert(newRoom)
      $.ajax({
        type: 'POST',
        url: '/home/ChatroomServlet?callFrom=createChatroom',
        data: {
          'Id': newRoom,
          'chatTarget': 0,
          'chatType': 'R'
        }
      })

    });

    $.getJSON('/home/RepairForm.do?doJob=repairFormInfo').then(res => {

      for (let i = 0; i < res.repairFormList.length; i++) {
        if (res.repairFormList[i].repairFormNumber === myformNumber) {
          fromApplicant = res.repairFormList[i].applicantName;
          myformRoom = res.repairFormList[i].repairRoomNumber;
          myformPhone = res.repairFormList[i].applicantPhone;
          myformCreatetime = res.repairFormList[i].repairFormCreatTime;
          myformProjectNameAlias = res.repairFormList[i].projectAlias;
          myformNote = res.repairFormList[i].note;
          myformExpectionTime = res.repairFormList[i].repairFormExpectionTime;
          myformStatus = transfromStatus(res.repairFormList[i].status);
        }
      }

      $('#repairFormPage').html("");
      $('#repairFormPage').load('memberPage/showRepairFormContent.jsp',
        function() {
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
    });
    


  }
}