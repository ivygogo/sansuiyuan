<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FaqMvc</title>
</head>
<body>
<table>
  <form:form  method="POST" modelAttribute="FaqMvcTest">
  <tr>  <td>Question:</td> <td><form:input  path="question"/> </td> </tr>
   <tr>  <td>Answer:</td> <td><form:input  path="answer"/> </td> </tr>  
   <tr>  <td>publishTime:</td> <td><form:input  path="publishTime"/> </td> </tr>  
   <tr>  <td>unpublishTime:</td> <td><form:input  path="unpublishTime"/> </td> </tr> 
   <tr>  <td>isShow:</td> <td><form:input  path="isShow"/> </td> </tr> 
   <tr>  <td>createTime:</td> <td><form:input  path="createTime"/> </td> </tr> 
   <tr>  <td>updateTime:</td> <td><form:input  path="updateTime"/> </td> </tr> 
   <tr>  <td>deleteTime:</td> <td><form:input  path="deleteTime"/> </td> </tr> 
  <tr> <td colspan=3>   <input type="submit"> </td>
  </form:form>
</table>   
</body>
</html>