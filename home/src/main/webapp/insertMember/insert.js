function insert() {
  var userName = document.getElementById("userName").value;
  var nickName = document.getElementById("nickName").value;
  var name_id = document.getElementById("name_id").value;
  var email = document.getElementById("email").value;
  var password = document.getElementById("password").value;
  var gender = document.getElementById("gender").value;
  var phone = document.getElementById("phone").value;
  var address = document.getElementById("address").value;

  var request = new XMLHttpRequest();
  request.onreadystatechange = function () {
    if (this.readyState == XMLHttpRequest.DONE && this.status == 200) {
      var count = parseInt(this.responseText);
      if (count == 0) {
        window.alert("新增失敗")
      } else {
        window.alert("新增成功")
        window.location.href = "list.html"; // 導頁
      }
    }
  }
  request.open("POST", "/insertMember", true);
  request.setRequestHeader("content-type", "application/json");
  var obj = {
    "userName": userName, "nickName": nickName, "name_id": name_id,"email": email,"password": password,
    "gender": gender,"phone": phone,"address": address
  };
  var json = JSON.stringify(obj);
  request.send(json);
}

function clearField() {
  document.getElementById("userName").value = "";
  document.getElementById("nickName").value = "";
  document.getElementById("name_id").value = "";
  document.getElementById("email").value = "";
  document.getElementById("password").value = "";
  document.getElementById("gender").value = "";
  document.getElementById("phone").value = "";
  document.getElementById("address").value = "";

}
