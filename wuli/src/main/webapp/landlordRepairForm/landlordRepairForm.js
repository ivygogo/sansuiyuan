let data = [];
let myForm;

//給修改和瀏覽用的方法
let dataForm;
function getAllTableData() {
  $.getJSON('/wuli/LandlordRepairFormServlet.do').then(res => {
    dataForm = res;

  });
  return dataForm;
}

//給Datatables用的方法
res = {};
function getTableData(res) {
  mydata = [];
  dataForm = res;
  console.log(res)
  for (let i = 0; i < res.length; i++) {
    let inners = [];
    inners.push("");
    inners.push(res[i].formNumber);
    inners.push(res[i].applicant);
    inners.push(res[i].roomNumber);
    inners.push(res[i].projectNameAlias);
    inners.push(transfromTime(res[i].creatTime));
    inners.push(transfromStatus(res[i].status));
    inners.push(res[i].amount);
    mydata.push(inners);
  }
  //傳資料給table
  return mydata;
}

//轉換資料狀態
function transfromStatus(status) {
  let myStatus;
  switch (status) {
    case 0: {
      myStatus = "A待確認";
      break;
    }
    case 1: {
      myStatus = "B管理中";
      break;
    }
    case 2: {
      myStatus = "C處理中";
      break;
    }
    case 3: {
      myStatus = "D已完成";
      break;
    }
    case 99: {
      myStatus = "E刪除";
      break;
    }
  }
  return myStatus;
}

//轉換日期與時間的格式
function transfromTime(str) {
  if (str != null) {
    var timeSplitSpace = str.split(" ");
    let mounth = transfromMounth(timeSplitSpace[0]);
    let day = timeSplitSpace[1].replace(",", "");
    let year = timeSplitSpace[2].replace(",", "");
    var time = transfromHour(timeSplitSpace[3]);
    let noon = timeSplitSpace[4];
    let total = year + "-" + mounth + "-" + day + " " + time;

    return total;
  } else {
    return null
  }
}

//時間格式補0
function transfromHour(str) {
  let hour = "";
  let min = "";
  let sec = "";
  var timeSplitColon = str.split(":");

  if (timeSplitColon[0].length < 2) {
    hour = timeSplitColon[0].padStart(2, 0);
    //hour="0"+timeSplitColon[0];
  } else {
    hour = timeSplitColon[0];
  }
  if (timeSplitColon[1].length < 2) {
    //min="0"+timeSplitColon[1];
    min = timeSplitColon[1].padStart(2, 0);
  } else {
    min = timeSplitColon[1];
  }
  if (timeSplitColon[2].length < 2) {
    //sec="0"+timeSplitColon[2];
    sec = timeSplitColon[2].padStart(2, 0);
  } else { sec = timeSplitColon[2] }
  return (hour + ":" + min + ":" + sec);
}


function transfromMounth(mounth) {

  switch (mounth) {
    case 'Jan':
      return "01";
      break;
    case 'Feb':
      return "02";
      break;
    case 'Mar':
      return "03";
      break;
    case 'Apr':
      return "04";
      break;
    case 'May':
      return "05";
      break;
    case 'Jun':
      return "06";
      break;
    case 'Jul':
      return "07";
      break;
    case 'Aug':
      return "08";
      break;
    case 'Sep':
      return "09";
      break;
    case 'Oct':
      return "10";
      break;
    case 'Nov':
      return "11";
      break;
    case 'Dec':
      return "12";
      break;

  }
}


function checkRepairFormNumber(number) {
  myForm = getAllTableData();
  let myformNumber = number;
  let jsonForm;
  for (let i = 0; i < myForm.length; i++) {
    if (myForm[i].formNumber === myformNumber) {
      jsonForm = JSON.stringify(myForm[i]);
      //jsonForm = myForm[i]
    }
  }
  let outPut = jsonForm //"["+jsonForm+"]";
  //alert(outPut)
  return outPut;
}




//當房東編輯報修單時，協助房東把狀態+1
function newFormStatus(newStatus) {
  switch (newStatus) {
    case 0:
      newStatus = "1"
      //alert("showForm.status" + newStatus);
      break;
    case 1:
      newStatus = "2"
      break;
    case 2:
      newStatus = "3"
      break;
    case 3:
      newStatus = "3"
      break;
    case 99:
      newStatus = "99"
      break;
    default:
      break;
  }
  return newStatus;
}


//確認table的點擊筆數(2多筆)
let totalFormArr = []
function checkTotalSelect(formNumber) {
  let n = -1;
  if (totalFormArr.length == 0) {
    totalFormArr.push(formNumber);
  } else {
    findTime = -1;
    for (let i = 0; i < totalFormArr.length; i++) {
      if (formNumber === totalFormArr[i]) {
        totalFormArr.splice(i, 1);
        findTime++;
        break;
      }
    }
    if (findTime < 0) {
      totalFormArr.push(formNumber);
    }
  }
  n = totalFormArr.length;

  return n;
}


//確認table的點擊筆數(單筆)
let totalFormStr = "0";
function checkOnlySelect(formNumber) {

  let n = -1;
  if (totalFormStr === "0") {
    totalFormStr = formNumber;
    n++;

  } else if (totalFormStr === formNumber) {
    totalFormStr = "0";
  } else if (totalFormStr !== formNumber) {
    totalFormStr = formNumber;
    n++;
  }
  //alert(n);
  return n;
}


//瀏覽報修單
function showCheckedRepairForm(showForm, number) {
  $("#formNumber h3").text(showForm.formNumber);
  $("#roomNumber h3").text(showForm.roomNumber);
  $("#applicant h3").text(showForm.applicant);
  $("#applicantPhone h3").text(showForm.phone);
  $("#project h3").text(showForm.projectNameAlias);
  $("#repairStatus h3").text(transfromStatus(showForm.status));
  $("#createTime h3").text(transfromTime(showForm.creatTime));
  $("#expectTime h3").text(transfromTime(showForm.expectionTime));
  $("#repairNote h3").text(showForm.note);
  $("#feedbackTime h3").text(transfromTime(showForm.fixTime));
  $("#price h3").text(showForm.amount);
  $("#landlordNote h3").text(showForm.landlordNote);
  $(".landlordedit").attr("value", showForm.formNumber);
  $(".landlordsave").attr("value", showForm.formNumber);
  let selectRows = checkOnlySelect(number)

  if (selectRows < 0) {
    $("#showRepairContent").hide();
    $("#editRepairContent").hide();
  } else {
    $("#showRepairContent").attr("style", "visibility: visible");
  }
}


//點擊編輯按鈕
function editRepairForm(item) {
  myformNumber = item.getAttribute('value');
  let showForm = JSON.parse(checkRepairFormNumber(myformNumber));
  //alert("showForm.status" + showForm.status);
  let newStatus = newFormStatus(showForm.status);
  //alert(myformNumber)
  $("#pageChange").html("");
  $("#pageChange")
    .load(
      'landlordRepairForm/editRepairFormContent.jsp',
      function() {
        $("#formNumber h3").text(showForm.formNumber);
        $("#dropFrom").attr("value", showForm.formNumber);

        $("#roomNumber h3").text(showForm.roomNumber);
        $("#applicant h3").text(showForm.applicant);
        $("#applicantPhone h3").text(showForm.phone);
        $("#project h3").text(showForm.projectNameAlias);
        $("#repairStatus h3").text(
          transfromStatus(showForm.status));
        $("#createTime h3").text(transfromTime(showForm.creatTime));
        $("#expectTime h3").text(transfromTime(showForm.expectionTime));
        $("#repairNote h3").text(showForm.note);
        $("#datetimepicker1 input").attr("value", transfromTime(showForm.fixTime));
        $("#price input").attr("value", showForm.amount);
        $("#landlordNote").text(showForm.landlordNote);
        $('.selectpicker').selectpicker('val', newStatus);
        $('.selectpicker').selectpicker('refresh');
      });
}

//點擊放棄修改
function dropForm(item) {
  $("#pageChange").html("");
  $("#pageChange").load('landlordRepairForm/showRepairFormContent.jsp', function() {

    myformNumber = item.getAttribute('value');
    let showForm = JSON.parse(checkRepairFormNumber(myformNumber));
    showCheckedRepairForm(showForm, myformNumber);
    $("#showRepairContent").attr("style", "visibility: visible");

  });
}

//點擊送出儲存修改
function sendForm() {
    const selectTimePick = $('#datetimepicker1 input').val();
    const thePrice = $('#price input').val();
    const theNote = $('#landlordNote').val();
    const theformNumber = $('#formNumber h3').text();
    const theformStatus = $('#selectStatus').val();
    const selectedClass = $('#' + theformNumber).attr("class");
    $.ajax({
        type: 'POST',
        url: '/wuli/LandlordRepairFormServlet.do',

        data: {
            'selectTimePick': selectTimePick,
            'thePrice': thePrice,
            'theNote': theNote,
            'theformNumber': theformNumber,
            'theformStatus': theformStatus
        },
        
        success: function (response) {
            //alert(response.match("^\{(.+:.+,*){1,}\}$"));
            myresponse = JSON.parse(response);
            if (myresponse.id) {
                $('#example').DataTable().ajax.reload();
                $("#pageChange").html("");
                $("#pageChange")
                    .load(
                        'landlordRepairForm/showRepairFormContent.jsp',
                        function () {
                            $('#' + theformNumber).attr("class", selectedClass);
                            showCheckedRepairForm(myresponse, theformNumber);
                            $("#showRepairContent").attr("style", "visibility: visible");
                        });

            } else {
                result = JSON.parse(response);
                errAmount = result.amountErr;
                errFixtime = result.fixTimeErr;
                errStatus = result.statusErr;
                errSystem = result.systemErr;
                
                if (errFixtime.length != 0) {
                    $("#fixTimeErr").attr("style",
                        "visibility: visible;");
                    $("#fixTimeErr").text(errFixtime);
                }
                if (errAmount.length != 0) {
                    $("#amountErr").attr("style",
                        "visibility: visible;");
                    $("#amountErr").text(errAmount);
                    $("#price").attr("class",
                        "nk-int-st-invalid mx-3 mb-2");
                }
                if (errStatus.length != 0) {
                    $("#statusErr").attr("style",
                        "visibility: visible;");
                    $("#statusErr").text(errStatus);
                }
                if (systemErr.length != 0) {
                    $("#tips").text("系統異常，請聯繫維運單位");
                    $("#tips").attr("style", "color:red;");
                }
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            //console.log('EditForm with error');
            $("#tips").text("系統異常，請聯繫維運單位");
            $("#tips").attr("style", "color:red;");
        }
    })
}

/*點擊table時，頁面下方會show出報修單資料，如果停在修改頁面，判斷阻止事件發生*/
$(document).ready(function() {
  $('#example tbody').on('click', 'tr td:first-child', function() {
    //找出報修單號
    let number = table.row($(this).closest('tr')).data()[1];
    //alert (number)
    var qs = document.querySelector("form");
    //alert(qs)
    if (qs == null) {
      let showForm = JSON.parse(checkRepairFormNumber(number));
      showCheckedRepairForm(showForm, number);
      //alert(number)
    }
    if (qs != null) {
      //alert(qs)
      var con;
      con = confirm("你確認要放棄未填寫完成的表單嗎?");
      if (con == true) {
        //alert("放棄")
        $("#pageChange")
          .load(
            'landlordRepairForm/showRepairFormContent.jsp',
            function() {
              let showForm = JSON.parse(checkRepairFormNumber(number));
              showCheckedRepairForm(showForm, number);
              $("#showRepairContent").attr("style", "visibility: visible");

            });
      } else {
        //alert("不放棄")
        event.stopPropagation();
        //table.row(':eq(0)', {page : 'current'}).deselect();
        //table.row(':eq(0)', {page : 'current'}).select();
      }
    }

  });
});
