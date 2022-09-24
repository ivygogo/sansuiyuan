<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
//tableData = getTableData();
</script>

<div class="breadcomb-area">
  <div class="container">
    <div class="row">
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <div class="breadcomb-list">
          <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 my-3 ">
              <div class="breadcomb-wp">
                <div class="breadcomb-icon">
                  <i class="notika-icon notika-form"></i>
                </div>
                <div class="breadcomb-ctn">
                  <h1>房客報修單管理</h1>
                  <p>
                    <span class="bread-ntd form-intro">房客報修單管理提供您管理房客所送交的報修單需求</span>
                  </p>
                </div>
              </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-3"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="form-example-area">
  <div class="container">
    <div class="row ">
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <div class="form-example-wrap">
          <!-- 開始 -->
          <div class="table-responsive">
            <table id="example" class="table-bordered table display "
              style="width: 95%">
              <thead>
                <tr>
                  <th></th>
                  <th>單號</th>
                  <th>申請人</th>
                  <th>房號</th>
                  <th>項目</th>
                  <th>日期</th>
                  <th>狀態</th>
                  <th>費用</th>
                </tr>
              </thead>
              <tbody>

              </tbody>

            </table>
          </div>
          <%--結束--%>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="form-example-area">
  <div class="container">
    <div class="row mt-5 ">
      <div class="col col-lg-12 col-md-12 col-sm-12 col-xs-12"
        id="pageChange">
        
            <jsp:include page="showRepairFormContent.jsp" />



      </div>
    </div>
    <!-- 結束 -->
  </div>
</div>


<div class="row">
  <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"></div>
</div>

</body>
<script
  src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.js"></script>
<script
  src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script
  src="https://cdn.datatables.net/select/1.4.0/js/dataTables.select.min.js"></script>


<script>

  $(document).ready(function() {
    console.log("start");
    
    $("#showRepairContent").hide();
    table = $('#example').DataTable({
      //data : tableData,
      rowId : 1,
      searching : true,
      language : {
        "processing" : "處理中...",
        "loadingRecords" : "載入中...",
        "lengthMenu" : "顯示 _MENU_ 項結果",
        "info" : "顯示第 _START_ 至 _END_ 項結果，共 _TOTAL_ 項",
        "infoEmpty" : "顯示第 0 至 0 項結果，共 0 項",
        "infoFiltered" : "(從 _MAX_ 項結果中過濾)",
        "searchPlaceholder" : "搜尋報修單",
        "search" : "search",
        "paginate" : {
          "first" : "第一頁",
          "previous" : "上一頁",
          "next" : "下一頁",
          "last" : "最後一頁"
        }
      },
      iDisplayLength : 10,// 每頁顯示筆數
      lengthMenu : [ [ 5, 10, 25, 50, -1 ], [ 5, 10, 25, 50, "All" ] ],
      ajax: {
    	  url: '/wuli/LandlordRepairFormServlet.do',
    		  type:"get",
    		  dataType:"JSON",
    		  dataSrc:function(res){
    			  return getTableData(res);
    		  }
      },
      columnDefs : [ {
        orderable : false,
        className : 'select-checkbox',
        targets : 0

      } ],
      select : {
        style : 'os',
        selector : 'td:first-child'
      },
      order : [ [ 1, 'asc' ] ]
    });
    $('label select').attr("style", "width:50px;")

    table.on('select', function(e, dt, type, indexes) {
      var count = table.rows({
        selected : true
      }).count();
    });
  });


  
  
</script>
