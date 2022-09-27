<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>

<style>
.font {
	color: white;
	padding: 10px;
}

.bkground {
	background-color: #01c293;
	width: 100%;
	margin: auto;
}

tr:focus {
    background-color: #DAFFCC;
  }

#status {
	border: 1px solid green;
	height: 280px;
	width: 1300px;
	margin: auto;
	position: relative;
}

select {
	border: 0;
}

input {
	width: 15px;
	height: 15px;
}
</style>

<title>山水苑</title>
</head>
<body>
	<div style="position: relative;">
		<img src='<c:url value="/images/contract/icon.jpg" ></c:url>'
			width="100" height="50">
		<div style="position: absolute; display: inline-block; right: 150px;">

		</div>
		<div style="position: absolute; right: 0; top: 0;">
			<img src='<c:url value="/images/contract/user.png" ></c:url>'
				width="40" height="40">
			<p style="display: inline-block; letter-spacing: 1px;">山水苑 aaa111
				登出</p>
		</div>
	</div>

	<div style="position: relative;">
		<table class="bkground">
			<tr>
				<td class="font">房契管理</td>
				<td>合約查詢</td>
				<td class="font">看房預約</td>
				<td class="font">報修管理</td>
				<td class="font">討論區</td>
				<td class="font">聊天室</td>
				<td class="font">廣告管理</td>
				<td class="font">行事曆</td>

			</tr>

		</table>
	</div>

      
		
		<div class="d-flex justify-content-center">
			
				<div class="p-4"><img src='<c:url value="/images/contract/refresh.png" ></c:url>' width="30" height="30" style="cursor: pointer; display: inline; top: 200px;" onclick="window.location.reload();"> Refresh </div>
				<div class="p-4"><a href="ContractHide"><img src='<c:url value="/images/contract/undo.png" ></c:url>' width="30" height="30" style="top: 200px;"></a></div>
	 <div class="p-4">
        <form action="Update" method="post" name="delete">
          <input type="image"
            src='<c:url value="/images/contract/trash.png" ></c:url>'
            style="top: 200px; cursor: pointer; width: 30px; height: 30px;"
            id="hide"> <input type="hidden" name="selects" value=""
            id="formUpdate">
         </form>
      </div>
  <div class="p-4 mr-3">  
   <span style="display: inline; font-weight: bold; font-size: 20px">關鍵字</span><input style="width: 250px; height: 30px;" type="text">
  <img src='<c:url value="/images/contract/search.png" ></c:url>' width="30" height="30">
  </div> 
        </div> 
       
		
		


			


			
					
			

			
				
			

	


	<hr style="margin-top: 20px;">
	<div id="status" class="overflow-auto" style="margin-top: 20px; border-radius: 40px;">
	<table class="table" >
        <thead>
          <tr style="background-color: #01c293;">
            <th><input type="checkbox" id="allCK"></th>
            <th>合約狀態</th>
            <th>合約編號</th>
            <th>租客姓名</th>
            <th>房號</th>
            <th>房型</th>
            <th>繳費</th>
            <th>費用</th>
            <th>點交</th>
            <th>合約</th>
            <th>簽約日期</th>
               
          </tr>
        </thead>
            
        <c:forEach items="${allContract}" var="contract">
                 
          <tbody >
            <tr tabindex="1" id="contract${contract.CID}" class="CT">
              <th><form style="display: inline;"><input type="checkbox" class="ck" id="delete${contract.CID}"value="${contract.CID}"></form></th>
              <td><input type="text" value="${contract.status}"id="status${contract.CID}" style="display: none;" class="ST">${contract.status}</td>
              <td><input type="hidden" value="${contract.CID}" id="CID${contract.CID}">${contract.CID}</td>
              <td><input type="text" value="${contract.name}" id="name${contract.CID}" style="display: none;" class="nickName">${contract.name}</td>
              <td><input type="hidden" value="${contract.room_Number}" id="room_Number${contract.CID}" class="roomNumber">${contract.room_Number}</td>
              <td>${contract.room_Type}</td>
              <td><input type="hidden" value="${contract.payment_Status}" id="payment_Status${contract.CID}" class="PS">${contract.payment_Status}</td>
              <td><input type="hidden" value="${contract.check_Fee}" id="check_Fee${contract.CID}" class="CheckFee">${contract.check_Fee}</td>
              <td><input type="hidden" value="${contract.check_Status}" id="check_Status${contract.CID}" class="CS">${contract.check_Status}</td>
              <input type="hidden" value="${contract.deposit}" id="deposit${contract.CID}" class="Deposit">
              <td><input type="hidden" value="${contract.PDF}" id="PDF${contract.CID}" class="pdf">${contract.PDF}</td>
              <td><input type="hidden" value="${contract.signed_Date}">${contract.signed_Date}</td>       
            </tr>
          </tbody>
  
        </c:forEach>
      </table>
	  </div>

	

	<br>

	<!-- -------------- ------------------------------------------------>



	<div
		style="position: relative; border: 1px solid green; height: 800px; width: 1300px; border-radius: 50px;"
		class="container-fluid">


		<div style="margin: 0px 0 0 1200px"></div>

		<div style="position: relative; padding: 30px;">


			<form action="modify" style="display: inline;" method="post"
				name="formModify">
				<div id="checkboxgroup1">

					<p style="display: inline;">合約狀態 :</p>
					<input type="hidden" name="status" id="ContractStatus" value="">



					<input type="checkbox" id="cks1" value="${contractS.cbs2.status}"
						class="status" onclick="return false;">租賃中 <input
						type="checkbox" id="cks2" value="${contractS.cbs2.status}"
						class="status" onclick="return false;">已退租 <input
						type="checkbox" id="cks3" value="${contractS.cbs3.status}"
						class="status" onclick="return false;">租約到期 <img
						src='<c:url value="/images/contract/edit.png" ></c:url>'
						style="width: 30px; height: 30px; display: inline; margin-left: 800px; margin-bottom: 17px; cursor: pointer;"
						id="edit"> <input type="image" id="save"
						src='<c:url value="/images/contract/save.png" ></c:url>'
						style="width: 30px; height: 30px; cursor: pointer; display: inline; margin-left: 50px;">
				</div>

				<script>
					$('#checkboxgroup1 input').click(
							function() {
								if ($(this).prop('checked')) {
									$('#checkboxgroup1 input:checkbox').prop(
											'checked', false);
									$(this).prop('checked', true)
								}
							});
				</script>
				<input type="hidden" id="input6" value="" name="CID">


				<div>
					<p style="display: inline; margin-top: 15px; margin-bottom: 10px;">租客名字:</p>
					<input type="text" id="input1" disabled="disabled" name="name"
						value=""
						style="border: none; width: 150px; height: 30px; background-color: white; display: inline;">
				</div>

				<p style="display: inline;">合約 :</p>
				<input type="text" id="input2" disabled="disabled" value=""
					name="PDF"
					style="border: none; width: 130px; height: 30px; background-color: white; display: inline;">


				<div>
					<p style="display: inline; margin-top: 15px; margin-bottom: 10px;">房號:</p>
					<input type="text" id="input3" disabled="disabled"
						name="room_Number" value=""
						style="border: none; width: 100px; height: 30px; background-color: white; display: inline;">
				</div>
				<div id="checkboxgroup2">
					<p style="display: inline;">繳費狀態 :</p>
					<input type="checkbox" id="ckps1" class="payment_status"
						value="${contractPS.cbps1.payment_Status}"> 已繳 <input
						type="checkbox" id="ckps2" class="payment_status"
						value="${contractPS.cbps2.payment_Status}"> 未繳 <input
						type="hidden" id="ContractPayment_status" name="payment_Status"
						value="">
				</div>
				<script>
					$('#checkboxgroup2 input').click(
							function() {
								if ($(this).prop('checked')) {
									$('#checkboxgroup2 input:checkbox').prop(
											'checked', false);
									$(this).prop('checked', true)
								}
							});
				</script>
				<div>
					<p style="display: inline; margin-top: 10px; margin-bottom: 10px;">押金:</p>
					<input type="text" id="input4" disabled="disabled" value=""
						name="deposit"
						style="border: none; width: 100px; height: 20px; background-color: white; display: inline;">
				</div>

				<div>

					<p style="display: inline; margin-top: 15px; margin-bottom: 10px;">費用結算:</p>
					<input type="text" id="input5" disabled="disabled" name="check_Fee"
						value=""
						style="border: none; width: 65px; height: 30px; background-color: white; display: inline;">
					<input type="checkbox"> 電費 <input type="checkbox"
						style="margin-left: 10px;">其他
				</div>


				<div style="position: absolute; display: block; margin-top: 5px;"
					id="checkboxgroup3">
					<p style="display: inline;">退租點交:</p>
					<input type="checkbox" id="ckcs1" class="check_status"
						value="${contractCS.cbcs1.check_Status}"> 未點交 <input
						type="checkbox" id="ckcs2" class="check_status"
						value="${contractCS.cbcs2.check_Status}"> 已點交 <input
						type="hidden" id="ContractCheck_status" name="check_Status"
						value="">
				</div>
				<script>
					$('#checkboxgroup3 input').click(
							function() {
								if ($(this).prop('checked')) {
									$('#checkboxgroup3 input:checkbox').prop(
											'checked', false);
									$(this).prop('checked', true)
								}
							});
				</script>
			</form>

			<div style="position: absolute; margin-top: 30px; width: 1000px;">
				<p>房間內設備乙方應小心愛惜使用,若因人為因素導致損壞時,乙方顯負賠償之責,設備詳細如下</p>
			</div>
			<div
				style="position: absolute; margin-top: 100px; margin-left: 50px; width: 1000px">
				<form action="" style="display: block;">
					<div>
						<input type="checkbox"> 3.5呎床頭櫃(金額:3.300元/個)
					</div>
					<div>
						<input type="checkbox"> 3.5呎*6.2呎床板(金額:1.800元/張)
					</div>
					<div>
						<input type="checkbox"> 3.5呎書桌(金額:3.400元/張)
					</div>
					<div>
						<input type="checkbox"> 3.5*6.2呎彈簧床(金額:3.300元/張)
					</div>
					<div>
						<input type="checkbox"> 5呎彈簧床(金額:3.500元/個)
					</div>
					<div>
						<input type="checkbox"> 5呎*6.2呎床板(金額:2.000元/張)
					</div>
					<div>
						<input type="checkbox"> 5呎書桌(金額:3.600元/張)
					</div>
					<div>
						<input type="checkbox"> 5呎*6.2呎彈簧床(金額:3.500元/張)
					</div>
					<div>
						<input type="checkbox"> 衣櫃(金額:4.500元/個)
					</div>
					<div>
						<input type="checkbox"> 椅子(金額:1.800元/個)
					</div>
					<div>
						<input type="checkbox"> 浴室鏡子+流理台(金額:900元/鏡子.600元/流理臺)
					</div>
					<div>
						<input type="checkbox"> 紗窗(金額:2.000元/大紗窗.1.600元/小紗窗)
					</div>
					<div>
						<input type="checkbox"> 落地紗窗(金額:2.200元)
					</div>
					<div>
						<input type="checkbox">
						國際牌32吋液晶電視(TH-L32C50W)(金額:11.000元/台)
					</div>
					<div>
						<input type="checkbox"> 國際牌冰箱(NR-B133T)(金額:10.500元/台)
					</div>
				</form>

			</div>


		</div>

	</div>
</body>



<!-- ----------------------------------------------- -->
<script>
	window.addEventListener('load', doFirst);

	let input1 = document.getElementById("input1")
	let input2 = document.getElementById("input2")
	let input3 = document.getElementById("input3")
	let input4 = document.getElementById("input4")
	let input5 = document.getElementById("input5")
	let input6 = document.getElementById("input6")
	let renting = "${contractS.cbs1.status}"
	let retreat = "${contractS.cbs2.status}"
	let expired = "${contractS.cbs3.status}"
	let cks1 = document.getElementById("cks1")
	let cks2 = document.getElementById("cks2")
	let cks3 = document.getElementById("cks3")
	let hide = document.getElementById("hide")
	let edit = document.getElementById("edit")
	let ckps1 = document.getElementById("ckps1")
	let ckps2 = document.getElementById("ckps2")
	let paid = "${contractPS.cbps1.payment_Status}"
	let unpaid = "${contractPS.cbps2.payment_Status}"
	let ckcs1 = document.getElementById("ckcs1")
	let ckcs2 = document.getElementById("ckcs2")
	let unHandover = "${contractCS.cbcs1.check_Status}"
	let handover = "${contractCS.cbcs2.check_Status}"
	let ContractStatus = document.getElementById("ContractStatus")
	let ck = document.querySelectorAll(".ck");
	let ContractPayment_status = document
			.getElementById("ContractPayment_status")
	let ContractCheck_status = document.getElementById("ContractCheck_status")

	console.log("--------------------")
	let allCK = document.getElementById("allCK")
	let clip = document.getElementById('clip')
	let ckPS = document.getElementById("ckPS")
	let ckCS = document.getElementById("ckCS")
	let nickName = document.querySelectorAll(".nickName")
	let pdf = document.querySelectorAll('.pdf')
	let roomNumber = document.querySelectorAll('.roomNumber')
	let Deposit = document.querySelectorAll('.Deposit')
	let CheckFee = document.querySelectorAll('.CheckFee')
	let PS = document.querySelectorAll(".PS")
	let ST = document.querySelectorAll(".ST")
	let CS = document.querySelectorAll(".CS")
	let CT = document.querySelectorAll(".CT")
	console.log(CT.length)
	let cover = document.querySelectorAll(".cover")
	let status = document.querySelectorAll(".status")
	let payment_status = document.querySelectorAll(".payment_status")
	let check_status = document.querySelectorAll(".check_status")
	let save = document.getElementById("save")
	let formUpdate = document.getElementById("formUpdate")
	function doFirst() {

		allCK.addEventListener('click', selectAll)
		edit.addEventListener('click', alter)
		save.addEventListener('click', change)
		hide.addEventListener('click', deliver)
		showAll()
		test()
		statusCheckbox()
		payment_StatusCheckbox()
		check_StatusCheckbox()

		// <!-- ---------------預先讀取資料 --------------->
		for (let i = 0; i < CT.length; i++) {
			let contract = document.getElementById("contract" + ck[i].value)
			let status = document.getElementById("status" + ck[i].value)
			let CID = document.getElementById("CID" + ck[i].value)
			let name = document.getElementById("name" + ck[i].value)
			let room_Number = document.getElementById("room_Number"
					+ ck[i].value)
			let payment_Status = document.getElementById("payment_Status"
					+ ck[i].value)
			let check_Status = document.getElementById("check_Status"
					+ ck[i].value)
			let check_Fee = document.getElementById("check_Fee" + ck[i].value)
			let PDF = document.getElementById("PDF" + ck[i].value)
			let deposit = document.getElementById("deposit" + ck[i].value)
			input1.value = name.value
			input2.value = PDF.value
			input3.value = room_Number.value
			input4.value = deposit.value
			input5.value = check_Fee.value
			input6.value = CID.value
			ContractStatus.value = status.value
			ContractPayment_status.value = payment_Status.value
			ContractCheck_status.value = check_Status.value
			// --------合約狀態判斷式----------
			if (status.value === renting) {
				cks1.checked = true;
				cks2.checked = false;
				cks3.checked = false;
			} else if (status.value === retreat) {
				cks2.checked = true;
				cks1.checked = false;
				cks3.checked = false;
			} else if (status.value === expired) {
				cks3.checked = true;
				cks1.checked = false;
				cks2.checked = false;
			}
			// --------繳費狀態判斷式----------
			if (payment_Status.value === paid) {
				ckps1.checked = true;
				ckps2.checked = false;

			} else if (payment_Status.value === unpaid) {
				ckps2.checked = true;
				ckps1.checked = false;
			}
			// --------點交判斷式----------
			if (check_Status.value === unHandover) {
				ckcs1.checked = true;
				ckcs2.checked = false;
			} else if (check_Status.value === handover) {
				ckcs1.checked = false;
				ckcs2.checked = true;
			}

		}

	}

	function showAll() {

		for (let i = 0; i < CT.length; i++) {
			let contract = document.getElementById("contract" + ck[i].value)
			let status = document.getElementById("status" + ck[i].value)
			let CID = document.getElementById("CID" + ck[i].value)
			let name = document.getElementById("name" + ck[i].value)
			let room_Number = document.getElementById("room_Number"
					+ ck[i].value)
			let payment_Status = document.getElementById("payment_Status"
					+ ck[i].value)
			let check_Status = document.getElementById("check_Status"
					+ ck[i].value)
			let check_Fee = document.getElementById("check_Fee" + ck[i].value)
			let PDF = document.getElementById("PDF" + ck[i].value)
			let deposit = document.getElementById("deposit" + ck[i].value)
			contract.addEventListener("click", function() {
				input1.value = name.value
				input2.value = PDF.value
				input3.value = room_Number.value
				input4.value = deposit.value
				input5.value = check_Fee.value
				input6.value = CID.value
				ContractStatus.value = status.value
				ContractPayment_status.value = payment_Status.value
				ContractCheck_status.value = check_Status.value
				// --------合約狀態判斷式----------
				if (status.value === renting) {
					cks1.checked = true;
					cks2.checked = false;
					cks3.checked = false;
				} else if (status.value === retreat) {
					cks2.checked = true;
					cks1.checked = false;
					cks3.checked = false;
				} else if (status.value === expired) {
					cks3.checked = true;
					cks1.checked = false;
					cks2.checked = false;
				}
				// --------繳費狀態判斷式----------
				if (payment_Status.value === paid) {
					ckps1.checked = true;
					ckps2.checked = false;

				} else if (payment_Status.value === unpaid) {
					ckps2.checked = true;
					ckps1.checked = false;
				}
				// --------點交判斷式----------
				if (check_Status.value === unHandover) {
					ckcs1.checked = true;
					ckcs2.checked = false;
				} else if (check_Status.value === handover) {
					ckcs1.checked = false;
					ckcs2.checked = true;
				}

			})

		}
	}

	function test() {
		let selectsArray = []
		let ck = document.querySelectorAll(".ck");
		console.log(ck)
		console.log("--------------------------------------")
		for (let i = 0; i < ck.length; i++) {

			console.log(ck[i].className)
			console.log(ck[i].className.replace(/[^0-9]/ig, ""))
			checkbox = document.getElementById("delete" + ck[i].value)

			checkbox.addEventListener("click", function(e) {

				console.log(selectsArray)
				let number = parseInt(e.target.value)
				let index = selectsArray.indexOf(number)
				console.log(index + " -- " + " -- " + number + " -- "
						+ " -- --" + e.target.value)
				if (index !== -1) {
					selectsArray.splice(index, 1)
				} else {
					selectsArray.push(number)
				}
				formUpdate.value = selectsArray
				console.log(formUpdate.value)
			})
		}
	}

	function deliver() {
		document.forms['delete'].submit();
	}
	function change() {
		document.forms['formModify'].submit();
	}
	function selectAll() {
		let selectsArray = []
		for (i = 0; i < ck.length; i++) {
			ck[i].checked = true;
			selectsArray.push(ck[i].value)
			formUpdate.value = selectsArray

		}
	}

	function alter() {
		for (let i = 0; i < status.length; i++) {
			status[i].removeAttribute('onclick');
		}
		input1.removeAttribute('disabled');
		input1.style.border = '1px solid lightgreen'
		input2.removeAttribute('disabled');
		input2.style.border = '1px solid lightgreen'
		input3.removeAttribute('disabled');
		input3.style.border = '1px solid lightgreen'
		input4.removeAttribute('disabled');
		input4.style.border = '1px solid lightgreen'
		input5.removeAttribute('disabled');
		input5.style.border = '1px solid lightgreen'
	}

	function statusCheckbox() {
		for (let i = 1; i <= status.length; i++) {
			console.log(status.length)
			console.log(status)
			console.log("===================================")
			checkboxStatus = document.getElementById("cks" + i)

			checkboxStatus.addEventListener("click", function(e) {
				let value = e.target.value
				ContractStatus.value = value

			})
		}
	}

	function payment_StatusCheckbox() {
		for (let i = 1; i <= payment_status.length; i++) {
			console.log(payment_status.length)
			console.log(payment_status)
			checkboxPayment_Status = document.getElementById("ckps" + i)
			checkboxPayment_Status.addEventListener("click", function(e) {
				let value = e.target.value
				ContractPayment_status.value = value

			})
		}
	}

	function check_StatusCheckbox() {
		for (let i = 1; i <= check_status.length; i++) {
			checkboxCheck_Status = document.getElementById("ckcs" + i)
			checkboxCheck_Status.addEventListener("click", function(e) {
				let value = e.target.value
				ContractCheck_status.value = value
			})
		}
	}
</script>
</html>