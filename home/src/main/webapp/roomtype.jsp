<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet"
  href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
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
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script type="text/javascript">
  $(function() {
    $("#datepicker").datepicker({
      minDate : +0,
      maxDate : "+14D",
      dateFormat : "yy-mm-dd"
    });
  });
</script>
</html>
