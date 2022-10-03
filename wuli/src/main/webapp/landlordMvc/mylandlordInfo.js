//>> showLandlordInfoPage，顯示瀏覽畫面

function showLandlordInfoPage() {
  $.ajax({
    type: "GET",
    url: "/wuli/getLandlordInfoGson",
    dataType: "json",
    success: function (response) {
      $("#LandlordName >h3").text(response.resultData.name);
      $("#LandlordPhone >h3").text(response.resultData.phone);
      let landlordAddress = response.resultData.county + response.resultData.district + response.resultData.address;
      $("#LandlordAddress >h3").text(landlordAddress);
      $("#LandlordMail >h3").text(response.resultData.mail);
      let landlordStamp = response.resultData.stampImg;
      $("#LandlordStamp >img").attr("src", landlordStamp);
    },
    error: function (thrownError) {
      console.log(thrownError);
    }
  });
}

function showLandlordEditPage(){
  $.ajax({
    type: "GET",
    url: "/wuli/getLandlordInfoGson",
    dataType: "json",
    success: function (response) {

      $('#landlordName input').val(response.resultData.name);
      $('#landlordPhone input').val(response.resultData.phone);
      //秀出地址
      let landlordCounty = response.resultData.county;
      let landlordDistrict = response.resultData.district;
      //alert(landlordDistrict)
      $(" #county option[value='"+landlordCounty+"']").attr("selected",true);
      showZip (landlordCounty, landlordDistrict);
      $('#landlordAddress input').val(response.resultData.address);
      $('#landlordMail input').val(response.resultData.mail);
      $("#landlordStamp >img").attr("src", response.resultData.stampImg);
      $('#desc').text(response.resultData.stamp);

    }
  });

}

//>>editLandlordPage，縣市區域下拉式選單
function showZip(county, district) {
  $.getJSON('/wuli/file/city.json').then(res => {
    let arrData = res;
    let type = county;
    let filterData = arrData.filter(function (value) {
      return value.CityName === type;
    });
    $.each(filterData, function (index, value) {
      // Now, fill the second dropdown list with bird names.
      for (i = 0; i < value.AreaList.length; i++) {
        $('#district').append('<option value="' + value.AreaList[i].AreaName
          + '">' + value.AreaList[i].AreaName + '</option>');
        console.log(value.AreaList[i])
      }
    });
    $(" #district option[value='" + district + "']").attr("selected", true);
  })
}

//>>產生2層下拉式選單連動
function generateSelect() {
  let arrData = [];

  // 1.將JSON檔案注入
  $.getJSON("/wuli/file/city.json", function (data) {
    let arr_county_type = [];

    // 2.取出CityName的值，放進
    $.each(data, function (index, value) {
      //console.log("index" + index)
      //console.log("value" + value.CityName)
      arr_county_type.push(value.CityName);
      arrData = data;
      //console.log(arrData)
    });

    // Remove duplicates
    arr_county_type = Array.from(new Set(arr_county_type));
    // ref (https://www.encodedna.com/javascript/remove-duplicates-in-javascript-array-using-es6-set-and-from.htm)

    // Fill the first dropdown with unique bird types.
    $.each(arr_county_type, function (index, value) {
      $('#county').append('<option value="' + value + '">' + value +
        '</option>');
    });
  });

//>>editLandlordPage，顯示編輯畫面
  function showLandlordInfoEditPage() {
    let landlordCounty = "";
    let landlordDistrict = "";

    $.ajax({
      type: 'get',
      url: 'getLandlordInfoGson',

      success: function (response) {
        //alert(response.match("^\{(.+:.+,*){1,}\}$"));
        myData = JSON.parse(response);
        console.log(myData);
      },
      error: function (jqXHR, textStatus, errorThrown) {
        console.log('EditForm with error');
        $("#tips").text("系統異常，請聯繫維運單位");
        $("#tips").attr("style", "color:red;");
      }

    });

  }



//>>上傳圖片用到的JS
  function uploadPicture() {
    document.getElementById('upload_img').onchange = fileChange

    function fileChange() {
      let file = document.getElementById('upload_img').files[0]
      let message = file.name
      document.getElementById('desc').textContent = message;
    }

    function format_float(num, pos) {
      var size = Math.pow(10, pos);
      return Math.round(num * size) / size;
    }

    function preview(input) {
      if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {

          $('.preview').attr('src', e.target.result);
          var KB = format_float(e.total / 1024, 2);
          $('.size').text("檔案大小：" + KB + " KB");
        }
        reader.readAsDataURL(input.files[0]);
      }
    }

    $("body").on("change", ".upl", function () {
      preview(this);
    })
  }



  $('#county').change(function () {
    // 將縣市設定為type
    let type = this.options[this.selectedIndex].value;
    //alert(type);

    let filterData = arrData.filter(function (value) {
      return value.CityName === type;
    });
    console.log(filterData)

    $('#district')
    .empty()
    .append('<option value=""> -- 請選擇區域-- </option>');

    $.each(filterData, function (index, value) {
      // Now, fill the second dropdown list with bird names.
      for (i = 0; i < value.AreaList.length; i++) {
        $('#district').append('<option value="' + value.AreaList[i].AreaName
          + '">' + value.AreaList[i].AreaName + '</option>');
        console.log(value.AreaList[i])
      }
    });
  });
}

//>>點擊修改按鈕
function updateLandlordinfo() {
  innerPage = "updateLandlordinfo";
  if (innerPage == "updateLandlordinfo") {
    $('#profile').html("");
    $('#profile').load('landlordInfo/editLandlordInfo');
  }
  $("html,body").animate(
    {
      scrollTop: 0,
    },
    600
  );
}

//>>點擊放棄修改按鈕
function dropForm() {
  $('#profile').html("");
  $('#profile').load('showLandlordInfo');
  //document.location.href="/home/MemberInfo.do"
  //document.location.href = "/memberInfo" ;
}


function saveLandloadForm(){
  const formLandlordName = $('#landlordName input').val();
  const formLandlordPhone = $('#landlordPhone input').val();
  const formLandlordCounty = $('#county').val();
  const formLandlordDistrict = $('#district').val();
  const formLandlordAddress = $('#landlordAddress input').val();
  const formLandlordEmail = $('#landlordMail input').val();
  const formLandlordStamp = $("#landlordStamp >img").attr("src");
  const formLandlordDesc = $('#desc').text();
  console.log(formLandlordName+formLandlordPhone+formLandlordCounty+formLandlordCounty+formLandlordDistrict+formLandlordAddress+formLandlordEmail+formLandlordStamp+formLandlordDesc);


  fetch('landlordInfo/editLandlordInfo', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      'name':formLandlordName,
      'phone':formLandlordPhone,
      'county':formLandlordCounty,
      'district':formLandlordDistrict,
      'address':formLandlordAddress,
      'mail':formLandlordEmail,
      'stamp':formLandlordDesc,
      'stampImg':formLandlordStamp
    })
  })
  .then(resp=>resp.json())
  .then(body => {
    console.log(body);
    if(body.errMeg!== undefined && body.errMeg.length!=0){

      if(body.errMeg.errName!=0){
        $("#errlandlordName").attr("style","visibility: visible");
        $("#errlandlordName").text(body.errMeg.errName);
      }

      if(body.errMeg.errPhone!=0){
        $("#errlandlordPhone").attr("style","visibility: visible");
        $("#errlandlordPhone").text(body.errMeg.errPhone);
      }

      if(body.errMeg.errCounty!=0){
        $("#errlandlordCounty").attr("style","visibility: visible");
        $("#errlandlordCounty").text(body.errMeg.errCounty);
      }
      if(body.errMeg.errDistrict!=0){
        $("#errlandlordDistrict").attr("style","visibility: visible");
        $("#errlandlordDistrict").text(body.errMeg.errDistrict);
      }
      if(body.errMeg.errAddress!=0){
        $("#errlandlordAddress").attr("style","visibility: visible");
        $("#errlandlordAddress").text(body.errMeg.errAddress);
      }
      if(body.errMeg.errMail!=0){
        $("#errlandlordMail").attr("style","visibility: visible");
        $("#errlandlordMail").text(body.errMeg.errMail);
      }

      if(body.errMeg.errImg!=0){
        $("#errlandlordPic").attr("style","visibility: visible");
        $("#errlandlordPic").text(body.errMeg.errImg);
      }
    }
    if(body.success!== undefined &&body.success.length!=0){

      $('#profile').html("");
      $('#profile').load('showLandlordInfo');
    }
  })
  .catch(error => {
    console.log(error);
  });


}

function uploadPic() {
  document.getElementById('upload_img').onchange = fileChange

  function fileChange() {
    let file = document.getElementById('upload_img').files[0]
    message = file.name
    document.getElementById('desc').textContent = message;
  }

  function format_float(num, pos) {
    var size = Math.pow(10, pos);
    return Math.round(num * size) / size;
  }

  function preview(input) {
    if (input.files && input.files[0]) {
      var reader = new FileReader();
      reader.onload = function (e) {

        $('.preview').attr('src', e.target.result);
        var KB = format_float(e.total / 1024, 2);
        $('.size').text("檔案大小：" + KB + " KB");
      }
      reader.readAsDataURL(input.files[0]);
    }
  }

  $("body").on("change", ".upl", function () {
    preview(this);
  })
}
