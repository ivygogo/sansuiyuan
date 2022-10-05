<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
  $(document).ready(function () {
    generateSelect();
    showLandlordEditPage()
    uploadPic()
  });


</script>

<div class="breadcomb-area">
  <div class="container">
    <div class="row">
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <div class="breadcomb-list">
          <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 my-3 ">
              <div class="breadcomb-wp">
                <div class="breadcomb-icon">
                  <i class="notika-icon notika-form"></i>
                </div>
                <div class="breadcomb-ctn">
                  <h1>會員中心－物業資訊</h1>
                  <p>
                    <span class="bread-ntd form-intro">歡迎使用山水苑管理系統，查看您的會員基本資料</span>
                  </p>
                </div>
              </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-3"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<%--Breadcomb area End--%>
<%--Form Examples area start--%>

<div class="form-element-area">
  <div class="container">
    <div class="row">
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <div class="form-element-list">
          <div class="basic-tb-hd mx-4 my-5">
            <h1>編輯物業資訊</h1>
          </div>

          <!--landlordName-->
          <div class="row mx-5">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
              <h4 class="text-black">物業名稱</h4>
              <div class="form-group">
                <div class="nk-int-st" id="landlordName">
                  <input type="text" name="landlordName"
                         class="form-control input-lg "
                         placeholder="Input Large"/>
                </div>
                <div class="invalid-feedback mx-1 my-2" id="errlandlordName"
                     style="visibility: hidden"
                ></div>
              </div>
            </div>
          </div>

          <!--landlordPhone-->
          <div class="row mx-5 mt-3">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
              <h4 class="text-black">電話</h4>
              <div class="form-group">
                <div class="nk-int-st" id="landlordPhone">
                  <input type="text" name="landlordPhone"
                         class="form-control input-lg "
                         placeholder="Input Large"/>
                </div>
                <div class="invalid-feedback mx-1 my-2" id="errlandlordPhone"></div>
              </div>
            </div>
          </div>

          <!--county + district + address-->
          <div class="row ms-5 mt-3">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
              <h4 class="text-black">地址</h4>
              <div class="row mt-4">
                <div class="form-group">

                  <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12 mt-2">
                    <div style="border-bottom: 1px solid #ccc;">
                      <select class="pretty-select form-control px-2"
                              id='county' name="county">
                        <option value=''>-- 請選擇縣市 --</option>
                      </select>
                    </div>
                    <div class="invalid-feedback mx-1 mb-4"
                         id="errlandlordCounty" style="visibility: hidden"></div>
                  </div>
                  <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12 mt-2">
                    <div style="border-bottom: 1px solid #ccc;">
                      <select class="pretty-select form-control"
                              id='district' name="district">
                        <option value=''>-- 請選擇區域 --</option>
                      </select>
                    </div>
                    <div class="invalid-feedback mx-1 mb-4"
                         id="errlandlordDistrict"
                         style="visibility: hidden"></div>
                  </div>


                  <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                    <div class="form-group me-5">
                      <div class="nk-int-st" id="landlordAddress">
                        <input type="text"
                               name="landlordAddress"
                               class="form-control input-lg "
                               placeholder="Input Large"/>
                      </div>
                      <div class="invalid-feedback mx-1 mb-4"
                           id="errlandlordAddress"
                           style="visibility: hidden"></div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="row mx-5">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
              <h4 class="text-black">信箱</h4>
              <div class="form-group">
                <div class="nk-int-st" id="landlordMail">
                  <input type="email" name="landlordMail"
                         class="form-control input-lg"
                         placeholder="Input Large"
                         required="required"/>
                </div>
                <div class="invalid-feedback mx-1 mb-4"
                     id="errlandlordMail" style="visibility: hidden"></div>
              </div>
            </div>
          </div>

          <div class="row mx-5 mt-4">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
              <div class="form-group">
                <div class="nk-int-st">
                  <h4 class="text-black">公司章</h4>
                  <div class="row mx-1 my-3">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 imgShow"
                         id="landlordStamp">
                      <img class="preview my-2"
                           style="max-height: 280px; display:block; margin:auto;">
                    </div>
                  </div>
                  <div class="row mx-1 my-3">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                      <div class="size mt-1"></div>
                      <div id="desc" class="mt-1"></div>
                      <div class="invalid-feedback mx-1 mb-4"
                           id="errlandlordPic" style="visibility: hidden"></div>
                    </div>
                  </div>

                  <div class="btn-group images-cropper-pro">
                    <label class="btn btn-edit img-cropper-cp">
                      <input path="uploadImg"
                             id="upload_img" style="display: none;"
                             type="file"
                             class="upl" name="file"
                             accept="image/png, image/jpeg, image/jpg"/>
                      <i class="fa fa-photo"></i> 上傳圖片
                    </label>

                  </div>

                </div>
              </div>
            </div>
          </div>

          <div class="row mx-5 mt-4">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
              <div class="" style="display: flex; justify-content: center;">
                <button class="btn btn-edit" onclick="saveLandloadForm()">儲存資料</button>
                <button class="btn btn-edit mx-5" onclick="dropForm()"
                        id="dropIt">放棄儲存
                </button>
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>
  </div>
</div>
<script src="l"></script>
