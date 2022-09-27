<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@ page import="java.util.*" %> 
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%-- <jsp:include page="/searchBooking.jsp"></jsp:include> --%>
<table width="700px" 
style="border:1px solid #000000;">
<tr>
<td colspan=8 align="center"
style="background-color:ffeeff">
<b>預約單</b></td>
</tr>
<tr style="background-color:efefef;">
<td><b>會員編號</b></td>
<td><b>預約日期</b></td>
<td><b>預約時段</b></td>
<td><b>預約人姓名</b></td>
<td><b>預約人電話</b></td>
<td><b>房型</b></td>
<td><b>樓層偏好</b></td>
<td><b>服務人員</b></td>

</tr>
<%

int count=0;
String color = "#F9EBB3";


if(request.getAttribute("booklist")!=null)
{
ArrayList al = (ArrayList)request.getAttribute("booklist");
Iterator itr = al.iterator();


while(itr.hasNext()){

if((count%2)==0){
color = "#eeffee";
}
else{
color = "#F9EBB3";
}
count++;
ArrayList booklist = (ArrayList)itr.next();
%>
<tr style="background-color:<%=color%>;">
<td><%=booklist.get(0)%></td>
<td><%=booklist.get(1)%></td>
<td><%=booklist.get(2)%></td>
<td><%=booklist.get(3)%></td>
<td><%=booklist.get(4)%></td>
<td><%=booklist.get(5)%></td>
<td><%=booklist.get(6)%></td>
<td><%=booklist.get(7)%></td>
<td>
<a href="edit?id=<c:out value='<%=booklist.get(0)%>' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; 
<a href="delete?bookerId=<c:out value='<%=booklist.get(0)%>' />">Delete</a></td>
</tr>
<%
}
}
%>
<%
if(count==0){
%>
<tr>
<td colspan=8 align="center"
style="background-color:eeffee"><b>沒有</b></td>
</tr>
<%
}
%>
</table>
</body>
</html>