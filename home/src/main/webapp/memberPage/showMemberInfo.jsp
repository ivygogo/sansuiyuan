<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String editState = request.getParameter("edit");
System.out.print("editState"+editState);
if (editState!=null&&editState.equals("drop")){
request.setAttribute("guarantorIsInvalid", false);
request.setAttribute("isInvalid", false);
request.setAttribute("RefundIsInvalid", false);

System.out.print("editState:::::"+editState);
}
%>


<div class="row mb-1 mt-5 mx-3">
	<div class="col-md-12 text-left">
		<div class="" style="display: flex; justify-content: center;">
			<h2 class="text-black mb-4">會員基本資料${isInvalid}</h2>
		</div>
	</div>
</div>
<div class="row mb-1 mx-3">
<div class="col-md-12 text-left">
	<div class="" style="display: flex; justify-content: center;">
		<h6 class="text mb-4" style="color: red;">請注意: *為必填資料</h6>
	</div>
</div>
</div>

<section class="site-section" id="about-section">
	<div class="container">

		<div class="row ">
			<!--頭像-->
			<div class="col-sm-12 col-md-12 col-lg-6 mb-5">
				<div class="row ">
					<div class="col" style="display: flex; justify-content: center;">
						<img
							src="${pageContext.request.contextPath}//images/avatarImg/${Avatar}.png"
							alt="Free website template by Free-Template.co"
							class="img-fluid my-avatar">
					</div>
				</div>

				<div class="row mt-2">
					<div class="col" style="display: flex; justify-content: center;">
						<h4>${LoginOK.level}</h4>

					</div>
				</div>

				<div class="row mt-2">
					<div class="col" style="display: flex; justify-content: center;">
						<div>
							<font>帳號:</font> <font style="font-size: 20px; color: #37cfa2;">${LoginOK.mail}</font><br>
							<font>暱稱:</font> <font style="font-size: 20px; color: #37cfa2;">${LoginOK.nickname}</font><br>
							<c:if test="${memberInfo.contract.size()>0}">
								<font>合約:</font>
								<br>
								<ul>
									<c:forEach var="contract" items="${LoginOK.contract}">
										<li><a href="https://tw.yahoo.com"><font
												style="font-size: 20px; color: #37cfa2;">${contract}.pdf</font></a>
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
					<div class="col"></div>
				</div>
				<div class="mx-0">
					<h6 class="text-black-opacity-05">姓名</h6>
					<h3 class="text-black mb-4">${LoginOK.name}</h3>
					<h6 class="text-black-opacity-05">性別</h6>
					<h3 class="text-black mb-4">
						<c:if test="${LoginOK.gender ==0}">
                      男生
                      </c:if>
						<c:if test="${LoginOK.gender ==1}">
                      女生
                      </c:if>
						<c:if test="${LoginOK.gender ==2}">
                      無可奉告
                      </c:if>

					</h3>
					<h6 class="text-black-opacity-05">聯絡電話</h6>
					<h3 class="text-black mb-4">${LoginOK.phone}</h3>
					<h6 class="text-black-opacity-05">身份字號</h6>
					<h3 class="text-black mb-4">${LoginOK.idNumber}</h3>
					<h6 class="text-black-opacity-05">戶籍地址</h6>
					<h3 class="text-black mb-4">${LoginOK.county}${LoginOK.district}${LoginOK.address}</h3>
					<h6 class="text-black-opacity-05 mt-5">找室友功能</h6>
					<h3 class="text-black  mb-4">
						<c:if test="${LoginOK.open_tag ==1}">
                      開啟
                      </c:if>
						<c:if test="${LoginOK.open_tag ==0}">
                      關閉
                      </c:if>
					</h3>
					<h6 class="text-black-opacity-05">就讀學校</h6>
					<h3 class="text-black mb-4">${LoginOK.school}</h3>
					<h6 class="text-black-opacity-05">個性標籤</h6>
					<h3 class="text-black mb-4">${LoginOK.signatureAll}</h3>
					<h6 class="text-black-opacity-05">室友條件</h6>
					<h3 class="text-black mb-4">${LoginOK.favorStrAll}</h3>

				</div>
			</div>
		</div>
	</div>
</section>

<div class="row mb-1 mt-5 mx-3">
	<div class="col-md-12 text-left">
		<div class="" style="display: flex; justify-content: center;">
			<h3>
				<button class="btn btn-edit mr-2 mb-2" id="editMemberinfo"
					onclick="updateMemberinfo()">編輯會員資料</button>
			</h3>
		</div>
	</div>
</div>

