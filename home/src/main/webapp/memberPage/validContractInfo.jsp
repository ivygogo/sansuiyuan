<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	$(function() {
		$('#myzip').twzipcode({
			'countySel' : `${TempCounty2}`,
			'districtSel' : `${TempDistrict2}`,
			zipcodeIntoDistrict : true,
			css : [ "county form-control", "district form-control" ],
			countyName : "county2", 
			districtName : "district2",
			onCountySelect : changecb,
			onDistrictSelect : changecb
		});
		var el = document.querySelectorAll("select");

		el[0].className = "form-control";
		el[0].id = "inputState3";
		el[1].className = "form-control";
		el[1].id = "inputState4";

		function changecb() {
			var county = $('#myzip').twzipcode('get', 'county2');
			var district = $('#myzip').twzipcode('get', 'district2');
		}
	});
	
	$(function() {
      county1 = $('#myzip').twzipcode('get', 'county');
      district1 = $('#myzip').twzipcode('get', 'district');
      if(county1[0].length==0||district1[0].length==0){

          var oldChild = document.getElementById('inputState3');
          $("#inputState3").attr('class', "form-control is-invalid");
          var wrapper = document.createElement('div');
          wrapper.className = "form-group col-md-6"
          wrapper.id = "zip3"
          var oldParent = document.getElementById('myzip');
          
          var child2 = document.createElement('div');
          child2.className ="invalid-feedback "
          child2.id ="countyMsg"
          oldParent.appendChild(wrapper);
          
          wrapper.appendChild(child2);
          wrapper.insertBefore(oldChild, child2);
          
          var oldChild2 = document.getElementById('inputState4');
          var wrapper2 = document.createElement('div');
          wrapper2.className = "form-group col-md-6";
          wrapper2.id = "zip4"
          var child3 = document.createElement('div');
          child3.className ="invalid-feedback "
          child3.id ="districtMsg"
          oldParent.appendChild(wrapper2);
          wrapper2.appendChild(child3);
          wrapper2.insertBefore(oldChild2, child3);
          $("#countyMsg").html('${ErrMsg.errCounty}');
          $("#districtMsg").html('${ErrMsg.errDistrict}');
      }else{
        //alert("noerr")
        var oldChild = document.getElementById('inputState3');
            var wrapper = document.createElement('div');
            wrapper.className = "form-group col-md-6"
            wrapper.id = "zip3"
            var oldParent = document.getElementById('myzip');
            oldParent.appendChild(wrapper);
            wrapper.appendChild(oldChild);

            var oldChild2 = document.getElementById('inputState4');
            var wrapper2 = document.createElement('div');
            wrapper2.className = "form-group col-md-6";
            wrapper2.id = "zip4"
            oldParent.appendChild(wrapper2);
            wrapper2.appendChild(oldChild2);
      
      }
    })
	
</script>

<div class="row mb-1 mt-5 ml-3">
	<div class="col-md-12 text-left">
		<div class="" style="display: flex; justify-content: center;">
			<h2 class="text-black mb-4">契約簽訂資訊valid</h2>
		</div>
	</div>
</div>

<section class="site-section" id="about-section">
	<form name="contractInfo"
		action="<c:url value="/MemberContractInfoUpdate.do"/>" method="post"
		class="bg-white" enctype="multipart/form-data">
		<div class="container px-5 border">

			<div class="row lg-mx-5">
				<div class="col lg-mx-5  ">
					<div class="" style="display: flex; justify-content: center;">
						<h4 class="text-black mt-5">監護人／緊急聯絡人</h4>
						<br>
					</div>
					<div class="" style="display: flex; justify-content: center;">
						<font class="text-red mb-4 lg-ml-2" style="color: blue;">小叮嚀:簽約前請先完成以下欄位資訊，以利加速簽約程序</font>
						<input type="text" id="insertContractInfo"
							value="insertContractInfo" name="profile" hidden>
					</div>
					<div class="" style="display: flex; justify-content: center;">
            <h4 class="text-black mt-5">${ErrMsg.errForm }</h4>
            <br>
          </div>
				</div>
			</div>

			<div class="row lg-mx-5 mt-2">

				<div class="col lg-mx-5 ">
					<h6 class="text-black-opacity-05 mx-4">姓名</h6>
					<c:choose>
						<c:when test="${ErrMsg.errGuarantorName!=null}">
							<input type="text" id="fname"
								class="form-control col-12  mx-4 is-invalid"
								name="guarantorName" value="${param.guarantorName}" required>
							<div class="invalid-feedback mx-4">${ErrMsg.errGuarantorName}</div>
						</c:when>

						<c:otherwise>
							<input type="text" id="fname"
								class="form-control col-12 mb-4 mx-4 " name="guarantorName"
								value="${guarantorName}" required>
						</c:otherwise>
					</c:choose>
				</div>

				<div class="col lg-mx-5">
					<h6 class="text-black-opacity-05 mx-4">關係</h6>
					<c:choose>
            <c:when test="${ErrMsg.errGuarantorRelation!=null}">
              <input type="text" id="fname"
                class="form-control col-12 mb-4 mx-4 is-invalid"
                name="guarantorRelation" value="${param.guarantorRelation}" required>
              <div class="invalid-feedback mx-4 ">${ErrMsg.errGuarantorName}</div>
            </c:when>

            <c:otherwise>
              <input type="text" id="fname"
                class="form-control col-12 mb-4 mx-4 " name="guarantorRelation"
                value="${guarantorRelation}" required>
            </c:otherwise>
          </c:choose>
				</div>
			</div>

			<div class="row lg-mx-5 mt-2">
				<div class="col lg-mx-5 ">
					<h6 class="text-black-opacity-05 mx-4">保證人身份證字號</h6>
						
						<c:choose>
            <c:when test="${ErrMsg.errIdNumber!=null}">
              <input type="text" id="fname"
                class="form-control col-12  mx-4 is-invalid"
                name="guarantorIdNumber" value="${param.guarantorIdNumber}" required>
              <div class="invalid-feedback mx-4">${ErrMsg.errIdNumber}</div>
            </c:when>

            <c:otherwise>
              <input type="text" id="fname"
                class="form-control col-12  mx-4 " name="guarantorIdNumber"
                value="${guarantorIdNumber}" required>
            </c:otherwise>
          </c:choose>
					
				</div>
				
				<div class="col lg-mx-5 ">
					<h6 class="text-black-opacity-05 mx-4">聯絡手機號碼</h6>
						
						<c:choose>
            <c:when test="${ErrMsg.errPhone!=null}">
              <input type="text" id="fname"
                class="form-control col-12  mx-4 is-invalid"
                name="guarantorPhone" value="${param.guarantorPhone}" required>
              <div class="invalid-feedback mx-4">${ErrMsg.errPhone}</div>
            </c:when>

            <c:otherwise>
              <input type="text" id="fname"
                class="form-control col-12 mx-4 " name="guarantorPhone"
                value="${guarantorPhone}" required>
            </c:otherwise>
          </c:choose>

				</div>
			</div>
			<div class="row lg-mx-5 mt-2">
				<div class="col lg-mx-5 ">
					<h6 class="text-black-opacity-05 mx-4">戶籍地址</h6>
					<div class="form-row ml-3" id="myzip"></div>
					<input type="text" class="form-control is-invalid" hidden>
					
				</div>
				
				<div class="col lg-mx-5 ">
					<h6 class="text-black-opacity-05 mx-4">&nbsp;</h6>
					<c:choose>
            <c:when test="${ErrMsg.errAddress!=null}">
              <input type="text" id="fname"
                class="form-control col-12 mx-4 is-invalid"
                name="guarantorAddress" value="${param.guarantorAddress}" required>
              <div class="invalid-feedback mx-4">${ErrMsg.errAddress}</div>
            </c:when>

            <c:otherwise>
              <input type="text" id="fname"
                class="form-control col-12 mb-4 mx-4 " name="guarantorAddress"
                value="${guarantorAddress}" required>
            </c:otherwise>
          </c:choose>
					
				</div>
			</div>
		</div>


		<div class="row mb-1 mt-5 mx-3">
			<div class="col-md-12 text-left">
				<div class="" style="display: flex; justify-content: center;">
					<button class="btn btn-edit mr-2 mb-2" type="submit">我要儲存</button>
					<button type="button" class="btn btn-edit mr-2 mb-2" onclick="dropForm(this)" id="dropIt">放棄修改</button>
				</div>
			</div>
		</div>

	</form>
</section>

