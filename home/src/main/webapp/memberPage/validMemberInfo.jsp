<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="tab-pane fade show active" id="home" role="tabpanel"
	aria-labelledby="home-tab">

	<script type="text/javascript">
	
	function doFirstp(){
		
	$("input[name='avatarIcon']").click(
	        function() {//判斷點擊
	        	alert(event.target.id);
	          //$("input[name='avatarIcon']").get(0).checked = false;
	          startAvatar = `${Avatar}`;
	          //alert(startAvatar);
	          let avatarClick = $(
	          "input[name='avatarIcon']:radio:checked").val();
	          let link = "images/avatarImg/";
	          link += avatarClick;
	          link += ".png";
	          $("#avatarImg img").attr('src', link);
	          $("#avaName").html(avatarClick);
	          
	          //alert($("#avaName").text);
	        });
	}
	window.addEventListener('load', doFirstp);
	
	$(function(){
		$("input[name='myGender']").click(function(){
			alert(event.target.value);
			ans = " ";
			
			/*====如果是女生====*/
			if(event.target.value==="female"){
				str =('${femaleAvatar}')
				str = str.substr(0, str.length-1)
				alert(str.split(','));
				female = str.split(',');
				alert(female[0]);
				$("#avatarBlock").html("");
				colNum = female.length / 3;
			  col = 0;
			  while (col < colNum) {
				  ans += "<div class=\"row mb-2\">\n" + "<div class=\"col\" id=\"avatarId"+ (col + 1) + "\" style=\"display: flex; justify-content: center;\">";
			    for (let i = col * 3; i < (col + 1) * 3; i++) {
			    	
			    	if(female[i]==="girl01"){
			    		ans +="<input type=\"radio\" name=\"avatarIcon\" class=\"advice\" value=\""
			                    + female[i]
			                    + "\" "
			                    + "id=\"adviceRadio"
			                    + (i + 1)
			                    + "\" checked hidden />"
			                    + "<label for=\"adviceRadio"
			                    + (i + 1)
			                    + "\" class=\"advice mx-2\" "
			                    + " style=\"background-image: url('images/avataricon/"
			                    + female[i]
			                    + ".png'); background-size: 100px 100px;\"></label>";
			    		
			        let avatarLink = "images/avatarImg/";
		          avatarLink += female[i];
		          avatarLink += ".png";
		          $("#avatarImg img").attr('src', avatarLink);
		          $("#avaName").html(female[i]);
			        
			    	}else{
			    		ans +=
			                "<input type=\"radio\" name=\"avatarIcon\" class=\"advice\" value=\""
			                    + female[i]
			                    + "\" "
			                    + "id=\"adviceRadio"
			                    + (i + 1)
			                    + "\"  hidden />"
			                    + "<label for=\"adviceRadio"
			                    + (i + 1)
			                    + "\" class=\"advice mx-2\" "
			                    + " style=\"background-image: url('images/avataricon/"
			                    + female[i]
			                    + ".png'); background-size: 100px 100px;\"></label>";
			    	}
			    }
			    ans += "</div>\n" + "</div>";
			    col++;
			  }
			  ans += "</div>";
			  console.log(ans);
			  $("#avatarBlock").append(ans);
			}
			
			/*====如果是男生====*/
		      if(event.target.value==="male"){
		        str =('${maleAvatar}')
		        str = str.substr(0, str.length-1)
		        alert(str.split(','));
		        male = str.split(',');
		        alert(male[0]);
		        $("#avatarBlock").html("");
		        colNum = male.length / 3;
		        col = 0;
		        while (col < colNum) {
		          ans += "<div class=\"row mb-2\">\n" + "<div class=\"col\" id=\"avatarId"+ (col + 1) + "\" style=\"display: flex; justify-content: center;\">";
		          for (let i = col * 3; i < (col + 1) * 3; i++) {
		            
		            if(male[i]==="boy01"){
		              ans +="<input type=\"radio\" name=\"avatarIcon\" class=\"advice\" value=\""
		                          + male[i]
		                          + "\" "
		                          + "id=\"adviceRadio"
		                          + (i + 1)
		                          + "\" checked hidden />"
		                          + "<label for=\"adviceRadio"
		                          + (i + 1)
		                          + "\" class=\"advice mx-2\" "
		                          + " style=\"background-image: url('images/avataricon/"
		                          + male[i]
		                          + ".png'); background-size: 100px 100px;\"></label>";
		              
		              let avatarLink = "images/avatarImg/";
		              avatarLink += male[i];
		              avatarLink += ".png";
		              $("#avatarImg img").attr('src', avatarLink);
		              $("#avaName").html(male[i]);
		              
		            }else{
		              ans +=
		                      "<input type=\"radio\" name=\"avatarIcon\" class=\"advice\" value=\""
		                          + male[i]
		                          + "\" "
		                          + "id=\"adviceRadio"
		                          + (i + 1)
		                          + "\"  hidden />"
		                          + "<label for=\"adviceRadio"
		                          + (i + 1)
		                          + "\" class=\"advice mx-2\" "
		                          + " style=\"background-image: url('images/avataricon/"
		                          + male[i]
		                          + ".png'); background-size: 100px 100px;\"></label>";
		            }
		          }
		          ans += "</div>\n" + "</div>";
		          col++;
		        }
		        ans += "</div>";
		        console.log(ans);
		        $("#avatarBlock").append(ans);
		        
		      }
			
		      /*====如果是無可奉告====*/
	          if(event.target.value==="nogender"){
	            str =('${otherAvatar}')
	            str = str.substr(0, str.length-1)
	            alert(str.split(','));
	            nogender = str.split(',');
	            alert(nogender[0]);
	            $("#avatarBlock").html("");
	            colNum = nogender.length / 3;
	            col = 0;
	            while (col < colNum) {
	              ans += "<div class=\"row mb-2\">\n" + "<div class=\"col\" id=\"avatarId"+ (col + 1) + "\" style=\"display: flex; justify-content: center;\">";
	              for (let i = col * 3; i < (col + 1) * 3; i++) {
	                
	                if(nogender[i]==="default"){
	                  ans +="<input type=\"radio\" name=\"avatarIcon\" class=\"advice\" value=\""
	                              + nogender[i]
	                              + "\" "
	                              + "id=\"adviceRadio"
	                              + (i + 1)
	                              + "\" checked hidden />"
	                              + "<label for=\"adviceRadio"
	                              + (i + 1)
	                              + "\" class=\"advice mx-2\" "
	                              + " style=\"background-image: url('images/avataricon/"
	                              + nogender[i]
	                              + ".png'); background-size: 100px 100px;\"></label>";
	                  
	                  let avatarLink = "images/avatarImg/";
	                  avatarLink += nogender[i];
	                  avatarLink += ".png";
	                  $("#avatarImg img").attr('src', avatarLink);
	                  $("#avaName").html(nogender[i]);
	                  
	                }else{
	                  ans +=
	                          "<input type=\"radio\" name=\"avatarIcon\" class=\"advice\" value=\""
	                              + nogender[i]
	                              + "\" "
	                              + "id=\"adviceRadio"
	                              + (i + 1)
	                              + "\"  hidden />"
	                              + "<label for=\"adviceRadio"
	                              + (i + 1)
	                              + "\" class=\"advice mx-2\" "
	                              + " style=\"background-image: url('images/avataricon/"
	                              + nogender[i]
	                              + ".png'); background-size: 100px 100px;\"></label>";
	                }
	              }
	              ans += "</div>\n" + "</div>";
	              col++;
	            }
	            ans += "</div>";
	            console.log(ans);
	            $("#avatarBlock").append(ans);
	            
	          }
		      doFirstp();
		})
	})
	
	
	
		$(function() {
			$('#zipzip').twzipcode({
				'countySel' : `${TempCounty}`,
				'districtSel' : `${TempDistrict}`,
				zipcodeIntoDistrict : true,
				css : [ "county form-control", "district form-control" ],
				countyName : "county", // 自訂城市 select 標籤的 name 值
				districtName : "district", // 自訂區別 select 標籤的 name 值
				onCountySelect : changecb,
				onDistrictSelect : changecb
			});
			var el = document.querySelectorAll("select");

			el[0].className = "form-control";
			el[0].id = "inputState";
			el[1].className = "form-control";
			el[1].id = "inputState2";
			  
			
			function changecb() {
				// 取得縣市 county（返回字串）
				county = $('#zipzip').twzipcode('get', 'county');
				district = $('#zipzip').twzipcode('get', 'district');
				//var result = $('#zipzip').twzipcode('get', 'county,district'); // 以 , 字串傳入
				console.log(county);
				console.log(district);
				var str = county;
				console.log(county[0]);
			}
		});

		$(function() {
			county1 = $('#zipzip').twzipcode('get', 'county');
			district1 = $('#zipzip').twzipcode('get', 'district');
			//console.log(county);
			if(county1[0].length==0||district1[0].length==0){

				  var oldChild = document.getElementById('inputState');
			    $("#inputState").attr('class', "form-control is-invalid");
		      var wrapper = document.createElement('div');
		      wrapper.className = "form-group col-md-6"
		      wrapper.id = "zip1"
		      var oldParent = document.getElementById('zipzip');
		      
		      var child2 = document.createElement('div');
		      child2.className ="invalid-feedback "
		    	child2.id ="countyMsg"
		      oldParent.appendChild(wrapper);
		      
		      wrapper.appendChild(child2);
		      wrapper.insertBefore(oldChild, child2);
		      
          var oldChild2 = document.getElementById('inputState2');
		      var wrapper2 = document.createElement('div');
		      wrapper2.className = "form-group col-md-6";
		      wrapper2.id = "zip2"
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
				var oldChild = document.getElementById('inputState');
			      var wrapper = document.createElement('div');
			      wrapper.className = "form-group col-md-6"
			      wrapper.id = "zip1"
			      var oldParent = document.getElementById('zipzip');
			      oldParent.appendChild(wrapper);
			      wrapper.appendChild(oldChild);

			      var oldChild2 = document.getElementById('inputState2');
			      var wrapper2 = document.createElement('divs');
			      wrapper2.className = "form-group col-md-6";
			      wrapper2.id = "zip2"
			      oldParent.appendChild(wrapper2);
			      wrapper2.appendChild(oldChild2);
			
			}
		})

		
		$("#reset-btn").click(function() {
			let avatarResetLink = "images/avatarImg/";
			avatarResetLink += startAvatar;
			avatarResetLink += ".png";
			$("#avaName").html(startAvatar);
			$("#avatarImg2 img").attr('src', avatarResetLink);
			//alert(startAvatar);
		})
	</script>
	<!-- 內容開始  -->

	<!--分頁1-->

	<div class="row mb-1 mt-5 mx-3">
		<div class="col-md-12 text-left">
			<div class="" style="display: flex; justify-content: center;">
				<h2 class="text-black mb-4">會員基本資料</h2>
				<%-- 
				<p>驗證${isInvalid}</p>
				<p>ErrMsg${ErrMsg.isEmpty()}</p>
				<p>${ErrMsg.errNickname}</p>
				<p>${ErrMsg.errPhone}</p>
				<p>${ErrMsg.errIdNumber}</p>

				<p>${ErrMsg.errGender}</p>

				<p>${ErrMsg.errPhone}</p>
				<p>${ErrMsg.errCounty}</p>
				<p>${ErrMsg.errDistrict}</p>
				<p>${ErrMsg.errAaddress}</p>
				<p>${ErrMsg.errOpenTag}</p>
				<p>${ErrMsg.errSchool}</p>
				<p>${ErrMsg.errCharacter}</p>


				<p>${ErrMsg.errCharacter}</p>
				<p>${ErrMsg.errFavor}</p>
				--%>
			</div>
		</div>
	</div>

	<!-- form開始 -->
	<form action="<c:url value="/MemberInfoUpdate.do"/>" method="post"
		class="p-5 bg-white" enctype="multipart/form-data">
		<section class="site-section" id="about-section">
			<div class="container">


				<div class="row ">
					<!--頭像-->
					<div class="col-sm-12 col-md-12 col-lg-6 mb-3">
						<div class="row ">
							<div class="col" style="display: flex; justify-content: center;"
								id="avatarImg">
								<img src="images/avatarImg/${Avatar}.png"
									alt="Free website template by Free-Template.co"
									class="img-fluid my-avatar">
							</div>
						</div>
						<div class="row mt-4">
							<div class="col" style="display: flex; justify-content: center;">
								<span id="avaName" style="font-size: 22px; color: #37cfa2">${Avatar}</span>
							</div>
						</div>

						<div class="row mt-3 mb-1">
							<div class="col" style="display: flex; justify-content: center;">
								<h5>請選擇頭像</h5>
							</div>
						</div>
						${ansAvatar}
						<!--name = avatarIcon-->
						<!--表單-->

						<div class="form-row mt-2">
							<div class="col">
								<h6>暱稱* ${ErrMsg.errNickname}</h6>
								<c:choose>
									<c:when test="${ErrMsg.errNickname!=null}">
										<input type="text" name="myNickname" class="form-control is-invalid"
											size="10" maxlength="10" id="validationServer01"
											placeholder="" value="${param.myNickname}" required>
										<div class="invalid-feedback">${ErrMsg.errNickname}</div>
									</c:when>

									<c:otherwise>
										<input type="text" name="myNickname"
											class="form-control" size="10" maxlength="10"
											id="validationServer01" placeholder=""
											value="${nickname}" required>
										<div class="invalid-feedback">${ErrMsg.errNickname}</div>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>

					<!--文字-->
					<div class="col-sm-12 col-md-12 col-lg-6">
						<div class="row mt-4">
							<div class="col"></div>
						</div>
						<div class="mx-0">
							<h6 class="text-black-opacity-05">姓名*</h6>
							<c:choose>
								<c:when test="${ErrMsg.errName!=null}">
									<input type="text" name="myName" class="form-control is-invalid"
										id="validationServer01" placeholder="" value="${param.myName}"
										required>
									<div class="invalid-feedback mb-4">${ErrMsg.errName}</div>
								</c:when>

								<c:otherwise>
									<input type="text" name="myName"
										class="form-control" id="validationServer01"
										placeholder="" value="${name}" required>
									<div class="invalid-feedback mb-4">${ErrMsg.errName}</div>
								</c:otherwise>
							</c:choose>

							<h6 class="text-black-opacity-05 mt-4">性別*</h6>
						${ansGender}<br>


							<h6 class="text-black-opacity-05">聯絡手機號碼*</h6>
							<c:choose>
								<c:when test="${ErrMsg.errPhone!=null}">
									<input type="text" name="myPhone" class="form-control is-invalid"
										id="validationServer01" placeholder=""
										value="${param.myPhone}" required>
									<div class="invalid-feedback mb-4">${ErrMsg.errPhone}</div>
								</c:when>

								<c:otherwise>
									<input type="text" name="myPhone"
										class="form-control" id="validationServer01"
										placeholder="" value="${phone}" required>
									<div class="invalid-feedback mb-4">${ErrMsg.errPhone}</div>
								</c:otherwise>
							</c:choose>


							<h6 class="text-black-opacity-05 mt-4">身份字號*</h6>
							<c:choose>
								<c:when test="${ErrMsg.errIdNumber!=null}">
									<input type="text" name="myId" class="form-control is-invalid"
										id="validationServer01" placeholder=""
										value="${param.myId}" required>
									<div class="invalid-feedback mb-4">${ErrMsg.errIdNumber}</div>
								</c:when>

								<c:otherwise>
									<input type="text" name="myId" class="form-control"
										id="validationServer01" placeholder=""
										value="${idNumber}" required>
									<div class="invalid-feedback mb-4">${ErrMsg.errIdNumber}</div>
								</c:otherwise>
							</c:choose>

							<h6 class="text-black-opacity-05 mt-4">戶籍地址*</h6>
							<div class="form-row" id="zipzip"></div>
							

							<h6 class="text-black-opacity-05">地址</h6>			
							<c:choose>
                <c:when test="${ErrMsg.errAaddress!=null}">
                  <input type="text" name="myAdress" class="form-control is-invalid"
                    id="validationServer01" placeholder=""
                    value="${param.myAdress}" required>
                  <div class="invalid-feedback mb-4">${ErrMsg.errAaddress}</div>
                </c:when>

                <c:otherwise>
                  <input type="text" name="myAddress" class="form-control"
                    id="validationServer01" placeholder=""
                    value="${param.myAddress}" required>
                  <div class="invalid-feedback mb-4">${ErrMsg.errAaddress}</div>
                </c:otherwise>
              </c:choose>


							<h6 class="text-black-opacity-05 mt-5">就讀學校</h6>
								<c:choose>
                <c:when test="${ErrMsg.errSchool!=null}">
                  <input type="text" name="mySchool" class="form-control is-invalid"
                    id="validationServer01" placeholder=""
                    value="${param.mySchool}" required>
                  <div class="invalid-feedback mb-4">${ErrMsg.errSchool}</div>
                </c:when>

                <c:otherwise>
                  <input type="text" name="mySchool" class="form-control"
                    id="validationServer01" placeholder=""
                    value="${param.mySchool}" required>
                  <div class="invalid-feedback mb-4">${ErrMsg.errSchool}</div>
                </c:otherwise>
              </c:choose>
								

							<%-- <h6 class="text-black-opacity-05 mt-5">找室友功能1</h6>
							${FindRoommateTag} --%>
							<h6 class="text-black-opacity-05 mt-5">找室友功能</h6>
							${ansRoommate}
							<div class="invalid-feedback mb-4">${errOpenTag}</div>
							<!-- findRoommate -->

							<h6 class="text-black-opacity-05">個性標籤</h6>
							${ansCharacter}
							<input type="hidden" name="myCharacter" class="form-control is-invalid"
                    id="validationServer01" placeholder="">
							 <div class="invalid-feedback mb-4">${ErrMsg.errCharacter}</div>
							<!-- myCharacter -->

							<h6 class="text-black-opacity-05 mt-3">室友條件</h6>
							${ansFavor}
							<input type="hidden" name="myFavor" class="form-control is-invalid"
                    id="validationServer01" placeholder="">
							<div class="invalid-feedback mb-4">${ErrMsg.errFavor}</div>
							<!-- myFavor -->

						</div>
					</div>
				</div>
			</div>
		</section>

		<div class="row mb-1 mt-5 mx-3">
			<div class="col-md-12 text-left">
				<div class="" style="display: flex; justify-content: center;">
					<button class="btn btn-edit mr-2 mb-2" type="subimt">我要儲存</button>
					<button type="button" class="btn btn-edit mr-2 mb-2" onclick="dropForm()" id="dropIt">放棄修改</button>
				</div>
			</div>
		</div>
	</form>
</div>


