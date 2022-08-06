<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="site-navbar py-4 js-sticky-header site-navbar-target" role="banner">

      <div class="container">
        <div class="row align-items-center mt-1">
          
          <div class="col-6 col-xl-2">
            <h1 class="mb-0 site-logo m-0 p-0"><a href="index.jsp" class="mb-0">${SYSTEM.systemName}</a></h1>
          </div>

          <div class="col-12 col-md-10 d-none d-xl-block">
            <nav class="site-navigation position-relative text-right" role="navigation">
              <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
                <li><a href="#home-section" class="nav-link">關於我們</a></li>
                <li class="nav-item dropdown has-children dropdown arrow-top">
                  <a class="nav-link " href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    房型瀏覽
                  </a>
                  <ul class="dropdown ">
                    <li ><a class="dropdown-item" href="property-room1.html" id="">房型１:單人Ａ</a></li>
                    <li ><hr class="dropdown-divider"></li>
                    <li ><a class="dropdown-item" href="#">房型2</a></li>
                    <li ><hr class="dropdown-divider"></li>
                    <li ><a class="dropdown-item" href="#">房型3</a></li>
                    <li ><hr class="dropdown-divider"></li>
                    <li ><a class="dropdown-item" href="#" id="">房型4:單人Ａ</a></li>
                    <li ><hr class="dropdown-divider"></li>
                    <li ><a class="dropdown-item" href="#">房型5</a></li>
                    <li ><hr class="dropdown-divider"></li>
                    <li ><a class="dropdown-item" href="#">房型6</a></li>
                    <li ><hr class="dropdown-divider"></li>
                  </ul>
                
                </li>
                <li><a href="partner.jsp" class="nav-link ">找室友</a></li>
                <li><a href="#about-section" class="nav-link">討論區</a></li>
                
                <c:if test="${empty LoginOK}">
                <li>
                <a href="login.html" class="nav-link">登入/註冊</a>
                </li>
                </c:if>
                
                <c:if test="${! empty LoginOK }">
                <li>
                <a href="#contact-section" class="nav-link">會員專區</a>
                </li>
                </c:if>
                
              </ul>
              
              
            </nav>
          </div>


          <div class="col-6 d-inline-block d-xl-none ml-md-0 py-2"><a href="#" class="site-menu-toggle js-menu-toggle text-white float-right"><span class="icon-menu h3"></span></a></div>

        </div>
      </div>
      
    </header>
    
    <div class="site-blocks-cover inner-page-cover2 overlay2" style="background-image: url(images/white.png);" data-aos="fade"></div>
    