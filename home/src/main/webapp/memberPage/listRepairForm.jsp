<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="table-responsive">
	<table class="table table-striped ">
		<thead>
			<tr>
				<th scope="col"><div class="text-center">編號</div></th>
				<th scope="col text-center"><div class="text-center">單號</div></th>
				<th scope="col text-center"><div class="text-center">項目</div></th>
				<th scope="col text-center"><div class="text-center">進度查詢</div></th>
				<th scope="col text-center"><div class="text-center">申請報修日期</div></th>
				<th scope="col text-center"><div class="text-center">完成報修日期</div></th>
				<th scope="col text-center"><div class="text-center">功能</div></th>
			</tr>
		</thead>
		<tbody id="repairForm">

		</tbody>
	</table>
	<% session.setAttribute("page", null);%>
</div>