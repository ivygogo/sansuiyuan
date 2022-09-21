<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="<c:url value="/LandlordInfo.do"/>" method="post"
                class="">
                
                  
                    <div class="row d-flex justify-content-end" >
                      <div class="col" style="border-width:1px; border-style:solid; border-color:#666;">
                        <div class="form-element-list">
                          <div class="basic-tb-hd mx-4 my-5" style="text-align:center;">
                            <h1>編輯報修單</h1>
                          </div>
                          <div class="row mx-5">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                              <h4 class="text-black">物業名稱</h4>
                              <div class="form-group">
                                <div class="nk-int-st">
                                  <input type="text" name="applicant"
                                    class="form-control input-lg "
                                    placeholder="Input Large" id ="applicant">
                                </div>
                              </div>
                            </div>
                          </div>

                          <div class="row mx-5 mt-3">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                              <h4 class="text-black">電話</h4>
                              <div class="form-group">
                                <div class="nk-int-st">
                                  <input type="text" name="landlordPhone"
                                    class="form-control input-lg "
                                    placeholder="Input Large">
                                </div>
                              </div>
                            </div>
                          </div>


                          <div class="row ms-5 mt-3">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">


                              <h4 class="text-black">地址</h4>

                              <div class="row mt-4">
                                <div class="form-group">
                                  <div class="form-row" id="zipzip"></div>

                                  <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                                    <div class="form-group me-5">
                                      <div class="nk-int-st">
                                        <input type="text" name="landlordAddress"
                                          class="form-control input-lg "
                                          placeholder="Input Large">
                                      </div>
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
                                <div class="nk-int-st">
                                  <input type="email" name="landlordMail"
                                    class="form-control input-lg"
                                    placeholder="Input Large" required>
                                </div>
                              </div>
                            </div>
                          </div>

                          <div class="row mx-5 mt-4">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                              <div class="form-group">
                                <div class="nk-int-st">
                                  <h4 class="text-black">公司章</h4>
                                  <div class="row mx-1 my-3">
                                    <div
                                      class="col-lg-12 col-md-12 col-sm-12 col-xs-12 imgShow"
                                      id="landlordStamp">
                                      <img class="preview my-2"
                                        style="max-height: 280px; display: block; margin: auto;">
                                    </div>
                                  </div>
                                  <div class="row mx-1 my-3">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                      <div class="size mt-1"></div>
                                      <div id="desc" class="mt-1"></div>

                                    </div>
                                  </div>

                                  <div class="btn-group images-cropper-pro">
                                    <label class="btn btn-edit img-cropper-cp"> <input
                                      id="upload_img" style="display: none;" type="file"
                                      class="upl" name="file"
                                      accept="image/png, image/jpeg, image/jpg"> <i
                                      class="fa fa-photo"></i> 上傳圖片
                                    </label>

                                  </div>

                                </div>
                              </div>
                            </div>
                          </div>

                          <div class="row mx-5 mt-4">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                              <div class=""
                                style="display: flex; justify-content: center;">
                                <button class="btn btn-edit">儲存資料</button>
                                <button class="btn btn-edit mx-5" onclick="dropForm()"
                                  id="dropIt">放棄儲存</button>
                              </div>
                            </div>
                          </div>

                        </div>
                      </div>
                    </div>

              </form>
