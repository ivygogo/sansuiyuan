<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


            
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
                            <img src="${pageContext.request.contextPath}//images/avatarImg/${memberInfo.avatar}" alt="Free website template by Free-Template.co" class="img-fluid my-avatar">
                      </div>
                    </div>
                    
                    <div class="row mt-2">  
                      <div class="col" style="display: flex; justify-content: center; ">
                        <h4>${memberInfo.level}</h4>
                        
                      </div>
                    </div>
                    
                    <div class="row mt-2">  
                      <div class="col" style="display: flex; justify-content: center; ">
                        <div>
                          <font>帳號:</font>
                          <font style="font-size:20px; color:#37cfa2;">${memberInfo.mail}</font><br>
                          <font>暱稱:</font>
                          <font style="font-size:20px; color:#37cfa2;">${memberInfo.nickname}</font><br>
                          <c:if test="${memberInfo.contract.size()>0}">
                          <font>合約:</font><br>
                          <ul>
                          <c:forEach var="contract" items="${memberInfo.contract}">
                          <li>
                          <a href="https://tw.yahoo.com"><font style="font-size:20px; color:#37cfa2;">${contract}.pdf</font></a>
                          </li>
                          </c:forEach>
                          </ul>
                          </c:if>
                        </div>
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
                      <h6 class="text-black-opacity-05">姓名</h6>
                      <h3 class="text-black mb-4">${memberInfo.name}</h3>
                      <h6 class="text-black-opacity-05">性別</h6>
                      <h3 class="text-black mb-4">
                      <c:if test= "${memberInfo.gender ==0}">
                      男生
                      </c:if>
                      <c:if test= "${memberInfo.gender ==1}">
                      女生
                      </c:if>
                      <c:if test= "${memberInfo.gender ==2}">
                      無可奉告
                      </c:if>
                      
                      </h3>
                      <h6 class="text-black-opacity-05">聯絡電話</h6>
                      <h3 class="text-black mb-4">${memberInfo.phone}</h3>
                      <h6 class="text-black-opacity-05">身份字號</h6>
                      <h3 class="text-black mb-4">${memberInfo.idNumber}</h3>
                      <h6 class="text-black-opacity-05">戶籍地址</h6>
                      <h3 class="text-black mb-4">${memberInfo.address}</h3>
                      <h6 class="text-black-opacity-05 mt-5">找室友功能</h6>
                      <h3 class="text-black  mb-4">
                      <c:if test= "${memberInfo.open_tag ==1}">
                      開啟
                      </c:if>
                      <c:if test= "${memberInfo.open_tag ==0}">
                      關閉
                      </c:if>
                      </h3>
                      <h6 class="text-black-opacity-05">就讀學校</h6>
                      <h3 class="text-black mb-4">${memberInfo.school}</h3>
                      <h6 class="text-black-opacity-05">個性標籤</h6>
                      <h3 class="text-black mb-4">${memberInfo.signatureAll}</h3>
                      <h6 class="text-black-opacity-05">室友條件</h6>
                      <h3 class="text-black mb-4">${memberInfo.favorStrAll}</h3>
                        
                      </div>
                  </div>
                </div>
              </div>
            </section>

            <div class="row mb-1 mt-5 mx-3">
              <div class="col-md-12 text-left">
                <div class="" style="display: flex; justify-content: center; ">
                  <h3><button class="btn btn-edit mr-2 mb-2" id ="editMemerinfo" onclick="updateMemberinfo()">編輯會員資料</button></h3>
                </div>
              </div>
            </div>
            
         