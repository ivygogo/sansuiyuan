<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta content="text/html" charset="UTF-8">
  <title>房型瀏覽</title>
</head>
<body>
<%@include file="fragment/menu_index.jsp" %>
<%@include file="roomType/roomType_content.html" %>

<div id="formDialogDiv" class="d-none">
  <%@include file="booking/booking.jsp" %>
</div>

<%@include file="fragment/footer.jsp" %>

</body>
</html>
