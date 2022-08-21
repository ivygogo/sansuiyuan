<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="tab-pane fade show active" id="home" role="tabpanel"
	aria-labelledby="home-tab">
	
	<script type="text/javascript">
		$(function() {
			$('#zipzip').twzipcode({
				'countySel' : `${LoginOK.county}`,
				'districtSel' : `${LoginOK.district}`,
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
				var county = $('#zipzip').twzipcode('get', 'county');
				var district = $('#zipzip').twzipcode('get', 'district');
				//var result = $('#zipzip').twzipcode('get', 'county,district'); // 以 , 字串傳入
				//console.log(county);
				//console.log(district);
			}
		});

		$(function() {
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

		})

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
		
		
		
		$("#reset-btn").click(function(){
			let avatarResetLink = "images/avatarImg/";
			avatarResetLink += startAvatar;
			avatarResetLink += ".png";
			$("#avaName").html(startAvatar);
			$("#avatarImg img").attr('src', avatarResetLink);
			//alert(startAvatar);
		})
	</script>
	<!-- 內容開始  -->

	<!--分頁1-->

	<div class="row mb-1 mt-5 mx-3">
		<div class="col-md-12 text-left">
			<div class="" style="display: flex; justify-content: center;">
				<h2 class="text-black mb-4">會員基本資料editmember</h2>
			</div>
		</div>
	</div>

<!-- param.name -->
 <form action="<c:url value="/MemberInfoUpdate.do"/>" method="post" class="p-5 bg-white" enctype="multipart/form-data"> 
	<section class="site-section" id="about-section">
		<div class="container">

			
				<div class="row ">
					<!--頭像-->
					<div class="col-sm-12 col-md-12 col-lg-6 mb-3">
						<div class="row ">
							<div class="col" style="display: flex; justify-content: center;"
								id="avatarImg">
								<img src="${pageContext.request.contextPath}//images/avatarImg/${memberInfo.avatar}"
									alt="Free website template by Free-Template.co"
									class="img-fluid my-avatar">
							</div>
						</div>
						<div class="row mt-4">
              <div class="col" style="display: flex; justify-content: center;">
                <span id="avaName" style="font-size:22px; color:#37cfa2">${Avatar}</span>
              </div>
            </div>
						
						<div class="row mt-3 mb-1">
							<div class="col" style="display: flex; justify-content: center; ">
								<h5>請選擇頭像</h5>
							</div>
						</div>
							 ${FindAvaterTag} <!--name = avatarIcon-->
						<!--表單-->

						<div class="form-row mt-2">
							<div class="col">
								<h6>暱稱</h6>
								<input type="text" name="myNickname"
									class="form-control invalid" size="10" maxlength="10"
									id="validationServer01" placeholder=""
									value="${LoginOK.nickname}" required>
								<div class="invalid-feedback">Looks good!</div>
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
							<input type="text" name="myName" class="form-control invalid"
								value="${LoginOK.name}">
							<div class="invalid-feedback ">Looks good!</div>
							<h6 class="text-black-opacity-05 mt-4">性別*</h6>
							${GenderTags} <br> <!-- name = myGender -->

							<h6 class="text-black-opacity-05">聯絡手機號碼*</h6>
							<input type="text" name = "myPhone" class="form-control"
								value="${LoginOK.phone}">
							<div class="invalid-feedback mb-4">請輸入手機09XX-XXX-XXX</div>

							<h6 class="text-black-opacity-05 mt-4">身份字號*</h6>
							<input type="text" name="myId" class="form-control"
								value="${LoginOK.idNumber}">
							<div class="invalid-feedback mb-4">要判斷身分證</div>

							<h6 class="text-black-opacity-05 mt-4">戶籍地址*</h6>


							<div class="form-row" id="zipzip"></div>
							<!--  name = zipcode /name = county name = distinct
                        <div class="form-group col-md-6">
                          <label for="inputState">區域</label>
                          <select id="inputState" class="form-control">
                            <option selected>Choose...</option>
                            <option>...</option>
                          </select>
                         </div>
                       </div>-->

							<h6 class="text-black-opacity-05">地址</h6>
							<input type="text" name="myAddress" class="form-control"
								value="${LoginOK.address}"> 
							<div class="invalid-feedback mb-4">Looks good!</div>

							<h6 class="text-black-opacity-05 mt-4">就讀學校</h6>
							<input type="text" name="school" class="form-control mb-4"
								value="${LoginOK.school}">
								
							<h6 class="text-black-opacity-05 mt-5">找室友功能</h6>
							${FindRoommateTag} <!-- findRoommate -->

							<h6 class="text-black-opacity-05">個性標籤</h6>
							${CharacterTag} <!-- myCharacter -->

							<h6 class="text-black-opacity-05 mt-3">室友條件</h6>
							${FavorTag} <!-- myFavor -->

						</div>
					</div>
				</div>
		</div>
	</section>

	<div class="row mb-1 mt-5 mx-3">
		<div class="col-md-12 text-left">
			<div class="" style="display: flex; justify-content: center;">
				<button class="btn btn-edit mr-2 mb-2" type="subimt">我要儲存</button>
				<button class="btn btn-edit mr-2 mb-2" type="reset" value="reset" id="reset-btn">重新設定</button>
			</div>
		</div>
	</div>
	</form>
</div>


