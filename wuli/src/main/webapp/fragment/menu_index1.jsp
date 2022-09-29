<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>

    .nav div {
    display: flex;
    justify-content: flex-end;
    align-items: center;
    }
    
    .active {
      background-color: #fff;
      border-radius: 10px 10px 0 0;
    }
    
    .nav div li a {
    display: inline-block;
    height: 50px;
    }
    
    
    .nav li img {
    height: 50px;
    }
    
</style>

<div class="header-top-area">
  <div class="container">
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <ul class="nav nav-tabs notika-menu-wrap menu-it-icon-pro">
          <li><img src='<c:url value="/images/contractQueryImg/icon.jpg" ></c:url>'
              ></li>
              
       <div>       
          <li class="active"><a data-toggle="tab" href="#Home"><i
              class="notika-icon notika-house"></i>房契管理</a></li>
          <li><a data-toggle="tab" href="#Tables"><i
              class="notika-icon notika-windows"></i>合約查詢</a></li>
          <li><a data-toggle="tab" href="#Tables"><i
              class="notika-icon notika-edit"></i>行事曆</a></li>
          <li><a data-toggle="tab" href="#Charts"><i
              class="notika-icon notika-mail"></i>看房預約</a></li>
          <li><a data-toggle="tab" href="#Forms"><i
              class="notika-icon notika-form"></i>報修管理</a></li>
          <li><a data-toggle="tab" href="#Page"><i
              class="notika-icon notika-support"></i>聊天室</a></li>
          <li><a data-toggle="tab" href="#App"><i
              class="notika-icon notika-app"></i>管理員登入</a></li>
        </div>
        </ul>
      </div>
  </div>
</div>