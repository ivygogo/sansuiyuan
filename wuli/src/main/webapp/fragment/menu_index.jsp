<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Main Menu area start-->    
<div class="main-menu-area mg-tb-40">
  <div class="container">
    <div class="row">
      
        <ul class="nav nav-tabs notika-menu-wrap menu-it-icon-pro">
          <li><img src='<c:url value="/images/contractQueryImg/icon.png" ></c:url>'
              width="100" height="50"></li>
          <li class="active"><a data-toggle="tab" href="#Home"><i
              class="notika-icon notika-house"></i>房契管理</a></li>
          <li><a data-toggle="tab" href="#mailbox"><i
              class="notika-icon notika-mail"></i>合約查詢</a></li>
          <li><a data-toggle="tab" href="#Interface"><i
              class="notika-icon notika-edit"></i>行事曆</a></li>
          <li><a data-toggle="tab" href="#Charts"><i
              class="notika-icon notika-bar-chart"></i>預約管理</a></li>
          <li><a data-toggle="tab" href="#Tables"><i
              class="notika-icon notika-windows"></i>報修管理</a></li>
          <li><a data-toggle="tab" href="#Forms"><i
              class="notika-icon notika-form"></i>聊天室</a></li>
          <li><a data-toggle="tab" href="#Page"><i
              class="notika-icon notika-support"></i>物業資訊</a></li>
          <li><a data-toggle="tab" href="#Appviews"><i
              class="notika-icon notika-app"></i>管理員登入</a></li>
        </ul>
        
        <div class="tab-content custom-menu-content">
          <div id="Home"
            class="tab-pane in active notika-tab-menu-bg animated flipInX">
            <ul class="notika-main-menu-dropdown">
              <li><a href="http://localhost:8080/wuli/rent.jsp">房契管理</a></li>
            </ul>
          </div>
          <div id="mailbox"
            class="tab-pane notika-tab-menu-bg animated flipInX">
            <ul class="notika-main-menu-dropdown">
              <li><a href="http://localhost:8080/wuli/Contract.do">合約查詢</a></li>
            </ul>
          </div>
          <div id="Interface"
            class="tab-pane notika-tab-menu-bg animated flipInX">
            <ul class="notika-main-menu-dropdown">
              <li><a href="animations.html">行事曆</a></li>
            </ul>
          </div>
          <div id="Charts"
            class="tab-pane notika-tab-menu-bg animated flipInX">
            <ul class="notika-main-menu-dropdown">
              <li><a href="http://localhost:8080/wuli/bookinglist.jsp">預約管理</a></li>
            </ul>
          </div>
          <div id="Tables"
            class="tab-pane notika-tab-menu-bg animated flipInX">
            <ul class="notika-main-menu-dropdown">
              <li><a href="http://localhost:8080/wuli/lanlordRepairForm.jsp">報修管理</a></li>
            </ul>
          </div>
          <div id="Forms"
            class="tab-pane notika-tab-menu-bg animated flipInX">
            <ul class="notika-main-menu-dropdown">
              <li><a href="http://localhost:8080/wuli/chatRoom.jsp">聊天室</a></li>
            </ul>
          </div>
          <div id="Page" class="tab-pane notika-tab-menu-bg animated flipInX">
            <ul class="notika-main-menu-dropdown">
              <li><a href="http://localhost:8080/wuli/memberInfo.jsp">物業資訊</a></li>
            </ul>
          </div>
          <div id="Appviews"
            class="tab-pane notika-tab-menu-bg animated flipInX">
            <ul class="notika-main-menu-dropdown">
              <li><a href="http://localhost:8080/home/login/login.jsp">管理員登入</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Main Menu area End-->