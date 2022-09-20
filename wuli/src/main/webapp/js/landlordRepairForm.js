let data = [];
let myForm;


$.getJSON('/wuli/LandlordRepairFormServlet.do').then(res => {
  console.log(res);
  myForm = res;

  for (let i = 0; i < res.length; i++) {
    let inners = [];
    inners.push("");
    inners.push(res[i].formNumber);
    inners.push(res[i].applicant);
    inners.push(res[i].roomNumber);
    inners.push(res[i].projectNameAlias);
    inners.push(transfromTime(res[i].creatTime));
    inners.push(transfromStatus(res[i].status));
    inners.push(res[i].projectPrice);
    data.push(inners);
  }
  console.log(data);

  //$('#inputState').append(projectOption);
});

function getFromInfo(formnumber) {
  for (let i = 0; i < myForm.length; i++) {

  }
}

function transfromStatus(status) {
  let myStatus;
  switch (status) {
    case 0: {
      myStatus = "A待確認";
      break;
    }
    case 1: {
      myStatus = "B處理中";
      break;
    }
    case 2: {
      myStatus = "C已完成";
      break;
    }
    case 99: {
      myStatus = "D刪除";
      break;
    }
  }
  return myStatus;
}


function transfromTime(str) {
  var timeSplitSpace = str.split(" ");
  let mounth = transfromMounth(timeSplitSpace[0]);
  let day = timeSplitSpace[1].replace(",", "");
  let year = timeSplitSpace[2].replace(",", "");
  var time = timeSplitSpace[3];
  let noon = timeSplitSpace[4];
  let total = year + "/" + mounth + "/" + day + " " + noon + " " + time;
  return total;
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

function checkRepairFormNumber(formNumber) {
  let myformNumber = formNumber;

  let jsonForm;
  let formResult = [];
  for (let i = 0; i < myForm.length; i++) {
    if (myForm[i].formNumber === myformNumber) {
      jsonForm = JSON.stringify(myForm[i]);
      //jsonForm = myForm[i]

    }
  }
  let outPut = jsonForm //"["+jsonForm+"]";
  return outPut;
}

let totalFormArr = []
function checkTotalSelect(formNumber) {
  let n = -1;
  if (totalFormArr.length == 0) {
    totalFormArr.push(formNumber);
  } else {
    findTime=-1;
    for (let i = 0; i < totalFormArr.length; i++) {
      if (formNumber === totalFormArr[i]) {
        totalFormArr.splice(i, 1);
        findTime++;
        break;
      }
    }
    if (findTime<0){
    totalFormArr.push(formNumber);
    }
  }
  n = totalFormArr.length;
  
  return n;
}

let totalFormStr="0";
function checkOnlySelect(formNumber) {
  

  let n = -1;
  if(totalFormStr ==="0"){
  totalFormStr = formNumber;
  n++;
  
  } else if (totalFormStr ===formNumber){
  totalFormStr = "0";
  } else if (totalFormStr !==formNumber){
  totalFormStr = formNumber;
  n++;
  }
  
  return n;
}
