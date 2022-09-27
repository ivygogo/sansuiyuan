<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
  crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

tr:focus {
  background-color: #DAFFCC;
}

</style>
</head>
<body>
  <form action='<%=request.getContextPath()%>/ReturnContract' method='post' name="ReturnContract">
        <input type="hidden" value="" name="CID" id="CID">
    <table class="table" >
      <thead>
        <tr style="background-color: #01c293;">
        
          <th>合約狀態</th>
          <th>合約編號</th>
          <th>租客姓名</th>
          <th>房號</th>
          <th>房型</th>
          <th>繳費</th>
          <th>費用</th>
          <th>點交</th>
          <th>合約</th>
          <th>簽約日期</th>
                    <th></th>
        </tr>
      </thead>
          
      <c:forEach items="${allHideContract}" var="contract">
               
        <tbody >
          <tr id="contract${contract.CID}" tabindex="1" class="EachContract">
            <th>${contract.status}</th>
            <td><input type="hidden" value="${contract.CID}" id="number${contract.CID}" class="counts">${contract.CID}</td>
            <td>${contract.name}</td>
            <td>${contract.room_Number}</td>
                        <td>${contract.room_Type}</td>
                        <td>${contract.payment_Status}</td>
                        <td>${contract.check_Fee}</td>
                        <td>${contract.check_Status}</td>
                        <td>${contract.PDF}</td>
                        <td>${contract.signed_Date}</td>
                       <td><input type="submit" id="btn"value="復原"></td> 
          </tr>
        </tbody>

      </c:forEach>
    </table>




  

  </form>
  <footer class="fixed-bottom">
  <div class="container" align="center">
    <a href="<%=request.getContextPath()%>/Contract.do">回上頁</a>
  </div>
</footer>
</body>

<script>
window.addEventListener('load',doFirst);
let number = document.getElementById('number')
let counts = document.querySelectorAll(".counts")
let EachContract = document.querySelectorAll(".EachContract")
let CID = document.getElementById('CID')
let btn = document.getElementById('btn')

function doFirst(){
sendCID()
btn.addEventListener('click',deliver)
}
function sendCID(){
for(let i = 0 ; i < EachContract.length; i++ ){
    let contract = document.getElementById("contract"+counts[i].value)
    console.log(counts[i].value)
    let number = document.getElementById("number" +counts[i].value)
     contract.addEventListener('click',function(){
        CID.value = number.value
       
     })

}

}

function deliver(){
    document.forms['ReturnContract'].submit()
}

</script>
</html>