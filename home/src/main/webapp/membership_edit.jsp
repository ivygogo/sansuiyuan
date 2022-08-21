<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 
////////////////////////////////////////////////////////////////

Author: Free-Template.co
Author URL: http://free-template.co.
License: https://creativecommons.org/licenses/by/3.0/
License URL: https://creativecommons.org/licenses/by/3.0/
Site License URL: https://free-template.co/template-license/
  
Website:  https://free-template.co
Facebook: https://www.facebook.com/FreeDashTemplate.co
Twitter:  https://twitter.com/Free_Templateco
RSS Feed: https://feeds.feedburner.com/Free-templateco

////////////////////////////////////////////////////////////////
-->
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>${SYSTEM.systemName}-編輯會員資料</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <meta name="author" content="Free-Template.co" />

    <link rel="shortcut icon" href="ftco-32x32.png">

    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,900|Oswald:300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/icomoon/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.theme.default.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.fancybox.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-datepicker.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/flaticon/font/flaticon.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/aos.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

    <script>

      var triggerTabList = [].slice.call(document.querySelectorAll('#myTab a'))
      triggerTabList.forEach(function (triggerEl) {
        var tabTrigger = new bootstrap.Tab(triggerEl)
      
        triggerEl.addEventListener('click', function (event) {
          event.preventDefault()
          tabTrigger.show()
        })
      })    
        </script>
    
  </head>
  <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
  
  <div class="site-wrap">

    <div class="site-mobile-menu site-navbar-target">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>
   
    
    <header class="site-navbar py-4 js-sticky-header site-navbar-target" role="banner">

      <div class="container">
        <div class="row align-items-center">
          
          <div class="col-6 col-xl-2">
            <h1 class="mb-0 site-logo m-0 p-0"><a href="index.html" class="mb-0">Warehouse</a></h1>
          </div>

          <div class="col-12 col-md-10 d-none d-xl-block">
            <nav class="site-navigation position-relative text-right has-children"  role="navigation">

              <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
                <li><a href="index.html#home-section" class="nav-link">Home</a></li>
                <li>
                  <a href="index.html#properties-section" class="nav-link active">Properties</a>
                </li>
                <li><a href="index.html#agents-section" class="nav-link">Agents</a></li>
                <li><a href="index.html#about-section" class="nav-link">About</a></li>
                <li><a href="index.html#news-section" class="nav-link">News</a></li>
                <li><a href="index.html#contact-section" class="nav-link">Contact</a></li>
                <li class="nav-item dropdown ">
                  <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Dropdown
                  </a>
                  <ul class="dropdown-menu">
                    <li ><a class="dropdown-item" href="#" id="">Action</a></li>
                    <li ><a class="dropdown-item" href="#">Another action</a></li>
                    <li ><hr class="dropdown-divider"></li>
                    <li ><a class="dropdown-item" href="#">Something else here</a></li>
                  </ul>
                </li>
        
              </ul>
            </nav>
          </div>


          <div class="col-6 d-inline-block d-xl-none ml-md-0 py-3"><a href="#" class="site-menu-toggle js-menu-toggle text-white float-right"><span class="icon-menu h3"></span></a></div>

        </div>
      </div>
      
    </header>

    <div class="site-blocks-cover inner-page-cover2 overlay2" data-aos="fade" style="background-color: url(images/white.png);"></div>

    <!-- 內容開始  -->
    <section class="login-block">
      <div class="container mt-5 mb-5">
        <!--標題-->
        <div class="row mb-1 mt-5">
          <div class="col-md-7 text-left">
            <h2 class="section-title mb-3">會員專區</h2>
            <p class="lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Minus minima neque tempora reiciendis.</p>
          </div>
        </div>

        <!--tabs-->
        <ul class="nav nav-tabs" id="myTab" role="tablist">
          <li class="nav-item" role="presentation">
            <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">基本資訊
            </button>
          </li>
          <li class="nav-item mx-2" role="presentation">
            <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">契約簽訂資訊
            </button>
          </li>
        </ul>
        <div class="tab-content" id="myTabContent">
          <!--分頁1-->
          <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
            
            <div class="row mb-1 mt-5 mx-3">
              <div class="col-md-12 text-left">
                <div class="" style="display: flex; justify-content: center; ">
                  <h2 class="text-black mb-4">會員基本資料</h2>
                </div>
              </div>
            </div>

            <section class="site-section" id="about-section">
              <div class="container" >
                
                <div class="row " >
                    <!--頭像-->
                  <div class="col-sm-12 col-md-12 col-lg-6 mb-5">
                    <div class="row " >
                      <div class="col" style="display: flex; justify-content: center; ">                          
                            <img src="images/girl-2.webp" alt="Free website template by Free-Template.co" class="img-fluid">
                      </div>
                    </div>
                    <!--表單-->
                  <form action="#" method="post" class="p-5 bg-white">
                    
                    <div class="row mt-4">  
                      <div class="col" style="display: flex; justify-content: center; ">
                        <h4>身份：租客</h4>
                      </div>
                    </div>

                    <div class="form-row mt-2"> 
                      <div class="col">
                        <h6>暱稱</h6>
                        <input type="text" id="fname" class="form-control is-invalid" size="10" maxlength="10" id="validationServer01" placeholder="First name" value="Mark" required>
                        <div class="invalid-feedback">Looks good!</div>
                      </div>
                    </div>
                  </div>

                  <!--文字-->
                  <div class="col-sm-12 col-md-12 col-lg-6">
                    <div class="row mt-4">
                      <div class="col">
                      </div>
                    </div>
                    <div class="mx-0" >
                      <h6 class="text-black-opacity-05">姓名*</h6>
                      <input type="text" id="fname" class="form-control is-invalid ">
                      <div class="invalid-feedback mb-4">Looks good!</div>
                      <h6 class="text-black-opacity-05">性別*</h6>
                      <input type="radio" id="html" name="fav_language" value="male" class="mr-2">
                      <label class="text-black" for="r1"><span>男生</span></label>
                      <input type="radio" id="html" name="fav_language" value="male" class="mr-2">
                      <label class="text-black" for="r1"><span>女生</span></label>
                      <input type="radio" id="html" name="fav_language" value="male" class="mr-2">
                      <label class="text-black" for="r1"><span>不公開</span></label>
                      
                      
                      
                      <h6 class="text-black-opacity-05">聯絡手機號碼*</h6>
                      <input type="text" id="fname" class="form-control is-invalid">
                      <div class="invalid-feedback mb-4">請輸入手機09XX-XXX-XXX</div>

                      <h6 class="text-black-opacity-05">身份字號*</h6>
                      <input type="text" id="fname" class="form-control is-invalid">
                      <div class="invalid-feedback mb-4">要判斷身分證</div>

                      <h6 class="text-black-opacity-05">戶籍地址*</h6>
                      <div class="form-row">
                        <div class="form-group col-md-6">
                          <label for="inputCity">縣市</label>
                          <select id="inputState" class="form-control">
                            <option selected>Choose...</option>
                            <option>...</option>
                          </select>
                        </div>
                        <div class="form-group col-md-6">
                          <label for="inputState">區域</label>
                          <select id="inputState" class="form-control">
                            <option selected>Choose...</option>
                            <option>...</option>
                          </select>
                        </div>
                      </div>
                      <h6 class="text-black-opacity-05">地址</h6>
                      <input type="text" id="fname" class="form-control is-invalid">
                      <div class="invalid-feedback mb-4">Looks good!</div>
                      
                      <h6 class="text-black-opacity-05 mt-5">找室友功能</h6>
                      <input type="radio" id="html" name="fav_language" value="male" class="mr-2">
                      <label class="text-black" for="r1"><span>開啟</span></label>
                      <input type="radio" id="html" name="fav_language" value="male" class="mr-2">
                      <label class="text-black" for="r1"><span>關閉</span></label>
                      
                      <h6 class="text-black-opacity-05">就讀學校</h6>
                      <input type="text" id="fname" class="form-control mb-4">

                      <h6 class="text-black-opacity-05">個性標籤</h6>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
                        <label class="form-check-label mx-2" for="inlineCheckbox1">活潑開朗
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
                        <label class="form-check-label mx-2" for="inlineCheckbox2">安靜內向
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
                        <label class="form-check-label mx-2" for="inlineCheckbox3">喜歡運動
                        </label>
                      </div>


                      <h6 class="text-black-opacity-05 mt-3">室友條件</h6>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
                        <label class="form-check-label mx-2" for="inlineCheckbox1">活潑開朗
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
                        <label class="form-check-label mx-2" for="inlineCheckbox2">安靜內向
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
                        <label class="form-check-label mx-2" for="inlineCheckbox3">喜歡運動
                        </label>
                      </div>
                        
                      </div>
                  </div>
                </div>
              </div>
            </section>

            <div class="row mb-1 mt-5 mx-3">
              <div class="col-md-12 text-left">
                <div class="" style="display: flex; justify-content: center; ">
                  <button class="btn btn-edit mr-2 mb-2" type="subimt">我要儲存</button>
                  <button class="btn btn-edit mr-2 mb-2" type="reset">重新設定</button>
                </div>
              </div>
            </div>
          </form>
          </div>
          <!--分頁2-->
          <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
            <!--標題2-->
            <div class="row mb-1 mt-5 ml-3">
              <div class="col-md-12 text-left">
                <div class="" style="display: flex; justify-content: center; ">
                  <h2 class="text-black mb-4">契約簽訂資訊</h2>
                </div>
              </div>
            </div>

            <section class="site-section" id="about-section">
              <div class="container px-5" >
                <!--表單-->
              <form action="#" method="post" class="bg-white">
                <div class="row lg-mx-5">
                  <div class="col lg-mx-5 border ">
                    <div class="" style="display: flex; justify-content: center;">
                      <h4 class="text-black mt-5">監護人／緊急聯絡人</h4><br>
                    </div>
                    <div class="" style="display: flex; justify-content: center; ">
                      <font class="text-black mb-4 lg-ml-2"> 以下欄位皆為非必填資訊</font>
                    </div>

                    <h6 class="text-black-opacity-05 mx-4 mt-4 ">姓名</h6>
                    <input type="text" id="fname" class="form-control col-6 mb-4 mx-4">

                      <h6 class="text-black-opacity-05 mx-4">聯絡手機號碼</h6>
                      <input type="text" id="fname" class="form-control is-invalid col-6 mx-4">
                      <div class="invalid-feedback mb-4 mx-4">請輸入手機09XX-XXX-XXX</div>


                      <h6 class="text-black-opacity-05 mx-4">身份字號</h6>
                      <input type="text" id="fname" class="form-control is-invalid col-6 mx-4">
                      <div class="invalid-feedback mb-4 mx-4">請輸入手機09XX-XXX-XXX</div>

                      <h6 class="text-black-opacity-05 mx-4">戶籍地址</h6>
                      <div class="form-row  mx-4">
                        <div class="form-group col-md-6">
                          <label for="inputCity">縣市</label>
                          <select id="inputState" class="form-control">
                            <option selected>Choose...</option>
                            <option>...</option>
                          </select>
                        </div>
                        <div class="form-group col-md-6">
                          <label for="inputState ">區域</label>
                          <select id="inputState" class="form-control">
                            <option selected>Choose...</option>
                            <option>...</option>
                          </select>
                        </div>
                      </div>
                      <h6 class="text-black-opacity-05 mx-4">地址</h6>
                      <input type="text" id="fname" class="form-control is-invalid mx-4 col-md-6">
                      <div class="invalid-feedback mb-4 mx-4">Looks good!</div>

                      <h6 class="text-black-opacity-05 mx-4">關係</h6>
                      <input type="text" id="fname" class="form-control col-6 mb-4 mx-4">

                      <div class="row mb-1 mt-5 mx-3">
                        <div class="col-md-12 text-left">
                          <div class="" style="display: flex; justify-content: center; ">
                            <button class="btn btn-edit mr-2 mb-2" type="subimt">我要儲存</button>
                            <button class="btn btn-edit mr-2 mb-2" type="reset">重新設定</button>
                          </div>
                        </div>
                      </div>

                    </div>
                  </div>
                </form>

                  <div class="row lg-mx-5 mt-5">
                    <div class="col lg-mx-5 border">
                      <div class="" style="display: flex; justify-content: center;">
                        <h4 class="text-black mt-5">退款帳戶資訊</h4><br>
                      </div>
                      <div class="" style="display: flex; justify-content: center; ">
                        <font class="text-black mb-4 lg-ml-2"> 以下欄位皆為非必填資訊</font>
                      </div>

                    <form action="#" method="post" class="bg-white">
                      <div class="form-row  mx-4">
                        <div class="form-group col-md-6">
                          <label for="inputCity">銀行代碼</label>
                          <select id="inputState" class="form-control">
                            <option selected>Choose...</option>
                            <option>...</option>
                          </select>
                        </div>
                        <div class="form-group col-md-6">
                          <label for="inputCity">分行名稱</label>
                          <input type="text" id="fname" class="form-control is-invalid">
                          <div class="invalid-feedback mb-4 ">請輸入手機09XX-XXX-XXX</div>
                        </div>
                        <div class="form-group col-md-6">
                          <label for="inputCity">受款人姓名</label>
                          <input type="text" id="fname" class="form-control is-invalid">
                          <div class="invalid-feedback mb-4 ">請輸入手機09XX-XXX-XXX</div>
                        </div>
                        <div class="form-group col-md-6">
                          <label for="inputCity">銀行帳號</label>
                          <input type="text" id="fname" class="form-control is-invalid">
                          <div class="invalid-feedback mb-4 ">請輸入手機09XX-XXX-XXX</div>
                        </div>
                      </div>

                      <div class="row mb-1 mt-5 mx-3">
                        <div class="col-md-12 text-left">
                          <div class="" style="display: flex; justify-content: center; ">
                            <button class="btn btn-edit mr-2 mb-2" type="subimt">我要儲存</button>
                            <button class="btn btn-edit mr-2 mb-2" type="reset">重新設定</button>
                          </div>
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </section>


          </div>

      </div>
    </section>

     

    

    <!--footer-->
    <footer class="site-footer">
      <div class="container">
        <div class="row">
          <div class="col-md-8">
            <div class="row">
              <div class="col-md-5">
                <h2 class="footer-heading mb-4">About Us</h2>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Neque facere laudantium magnam voluptatum autem. Amet aliquid nesciunt veritatis aliquam.</p>
              </div>
              <div class="col-md-3 mx-auto">
                <h2 class="footer-heading mb-4">Quick Links</h2>
                <ul class="list-unstyled">
                  <li><a href="#">About Us</a></li>
                  <li><a href="#">Services</a></li>
                  <li><a href="#">Testimonials</a></li>
                  <li><a href="#">Contact Us</a></li>
                </ul>
              </div>
              
            </div>
          </div>
          <div class="col-md-4">
            <div class="mb-4">
              <h2 class="footer-heading mb-4">Subscribe Newsletter</h2>
            <form action="#" method="post" class="footer-subscribe">
              <div class="input-group mb-3">
                <input type="text" class="form-control border-secondary text-white bg-transparent" placeholder="Enter Email" aria-label="Enter Email" aria-describedby="button-addon2">
                <div class="input-group-append">
                  <button class="btn btn-primary text-black" type="button" id="button-addon2">Send</button>
                </div>
              </div>
            </form>  
            </div>
            
            <div class="">
              <h2 class="footer-heading mb-4">Follow Us</h2>
                <a href="#" class="pl-0 pr-3"><span class="icon-facebook"></span></a>
                <a href="#" class="pl-3 pr-3"><span class="icon-twitter"></span></a>
                <a href="#" class="pl-3 pr-3"><span class="icon-instagram"></span></a>
                <a href="#" class="pl-3 pr-3"><span class="icon-linkedin"></span></a>
            </div>


          </div>
        </div>
        <div class="row pt-5 mt-5 text-center">
          <div class="col-md-12">
            <div class="border-top pt-5">
            <!-- Link back to Free-Template.co can't be removed. Template is licensed under CC BY 3.0. -->
            <p class="copyright"><small>&copy; <script>document.write(new Date().getFullYear());</script> Warehouse. All Rights Reserved.  Design by <a href="https://free-template.co" target="_blank">Free-Template.co</a></small></p>
            </div>
          </div>
          
        </div>
      </div>
    </footer>

  <!-- .site-wrap -->

  <a href="#top" class="gototop"><span class="icon-angle-double-up"></span></a> 

  <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
  <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/jquery.countdown.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap-datepicker.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
  <script src="${pageContext.request.contextPath}/js/aos.js"></script>
  <script src="${pageContext.request.contextPath}/js/jquery.fancybox.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/jquery.sticky.js"></script>
  <script src="${pageContext.request.contextPath}/js/main.js"></script>
  <script src="${pageContext.request.contextPath}/file/bootstrap.bundle.js"></script>


  </body>
</html>