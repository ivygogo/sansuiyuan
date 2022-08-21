<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div class="row mb-1 mt-5 mx-3">
	<div class="col-md-12 text-left">
		<div class="" style="display: flex; justify-content: center;">
			<h2 class="text-black mb-4">會員基本測試</h2>
		</div>
	</div>
</div>
<form action="<c:url value="/TestServlet.do"/>" method="post"
	class="p-5 bg-white" enctype="multipart/form-data" id="sysform">
	<h6 class="text-black-opacity-05">姓名*</h6>
	<input type="text" name="myName" class="form-control is-invalid "
		value="${LoginOK.name}">
	<div class="invalid-feedback mb-4">${ErrMsg.errName}</div>
<h6 class="text-black-opacity-05">個性標籤</h6>
              ${CharacterTag} <!-- myCharacter -->
	<div class="row mb-1 mt-5 mx-3">
		<div class="col-md-12 text-left">
			<div class="" style="display: flex; justify-content: center;">
				<button class="btn btn-edit mr-2 mb-2" type="subimt" >我要儲存</button>
				<button class="btn btn-edit mr-2 mb-2" type="reset" value="reset"
					id="reset-btn">重新設定</button>
			</div>
		</div>
	</div>

</form>