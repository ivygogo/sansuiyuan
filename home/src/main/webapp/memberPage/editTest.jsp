<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row mb-1 mt-5 mx-3">
	<div class="col-md-12 text-left">
		<div class="" style="display: flex; justify-content: center;">
		  <h1>${memberInfo.name}</h1>
			<h3>
				<button class="btn btn-edit mr-2 mb-2" id="editTTT" onclick="updateTestinfo()">
					編輯會員資料</a>
			</h3>
		</div>
	</div>
</div>