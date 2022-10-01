<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker" ).datepicker({ dateFormat: "yy-mm-dd" });
  });
  </script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form  method="post" name="frm" action="search" >
<table  align="center" class="btn btn-success" style="background-color:#01c293;" >
<tr><td >帳號: </td>
<td><input  type="text" name="bookerId" id="bookerId">
</td><td >日期: </td>
<td><input  type="text" name="bookDate" id="datepicker">
</td><td colspan=2 align="center">
<input  type="submit" name="submit" value="搜尋"></td></tr>
</table>
</form>
</body>
</html>