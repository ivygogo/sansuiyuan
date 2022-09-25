<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value='css/style.css'/>">
<link rel="stylesheet"
	href="//cdn.datatables.net/select/1.4.0/js/dataTables.select.min.js">
<link rel="stylesheet"
	href="//cdn.datatables.net/select/1.4.0/css/select.dataTables.css">
</head>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
data=[];


let myForm;


$.getJSON('/home/BookTest.do').then(res => {
  console.log(res);
  myForm = res;
  for (let i = 0; i < res.length; i++) {
	    let inners = [];
	    inners.push("");
      inners.push(res[i].bookDate);
      inners.push(res[i].bookerId);
      inners.push(res[i].bookerName);
      inners.push(res[i].bookerPhone);
      inners.push(res[i].leadPerson);
      inners.push(res[i].preferFloor);
	    inners.push(res[i].preferTime);
	    inners.push(res[i].roomtype);
	    data.push(inners);
	    
	  }
  console.log(data);
	  
  })
  

  //$('#inputState').append(projectOption);

</script>

<body>
	<table id="example" class="display" style="width: 100%">
		<thead>
			<tr>
				<th>NO</th>
				<th>bookDate</th>
				<th>bookerId</th>
				<th>bookerName</th>
				<th>bookerPhone</th>
				<th>leadPerson</th>
				<th>preferFloor</th>
				<th>preferTime</th>
				<th>roomtype</th>
			</tr>
		</thead>
		<tbody>

		</tbody>

	</table>
</body>
<!-- <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script> -->
<!-- <script src="https://cdn.datatables.net/select/1.4.0/js/dataTables.select.min.js"></script> -->
<script src="js/bootstrap.min.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/select/1.4.0/js/dataTables.select.min.js"></script>
<script>

//     var data = [
//         ["",
//             "A3602022-09-16A1",
//             "蘇酥酥",
//             "CL11F1A",
//             "冷氣",
//             "日期",
//             "狀態",
//             "$3,120"
//         ],
//         ["",
//             "A3602022-09-16A2",
//             "蘇酥酥",
//             "CL11F1A",
//             "冷氣",
//             "日期",
//             "狀態",
//             "$3,120"
//         ],
//         ["",
//             "A3602022-09-16A3",
//             "蘇酥酥",
//             "CL11F1A",
//             "冷氣",
//             "日期",
//             "狀態",
//             "$3,120"
//         ], ["",
//             "A3602022-09-16A4",
//             "蘇酥酥",
//             "CL11F1A",
//             "冷氣",
//             "日期",
//             "狀態",
//             "$3,120"
//         ],
//         ["",
//             "A3602022-09-16A5",
//             "蘇酥酥",
//             "CL11F1A",
//             "冷氣",
//             "日期",
//             "狀態",
//             "$3,120"
//         ],
//         ["",
//             "A3602022-09-16A6",
//             "蘇酥酥",
//             "CL11F1A",
//             "冷氣",
//             "日期",
//             "狀態",
//             "$3,120"
//         ],
//         ["",
//             "A3602022-09-16A7",
//             "蘇酥酥",
//             "CL11F1A",
//             "冷氣",
//             "日期",
//             "狀態",
//             "$3,120"
//         ]
//         , ["",
//             "A3602022-09-16A8",
//             "蘇酥酥",
//             "CL11F1A",
//             "冷氣",
//             "日期",
//             "狀態",
//             "$3,120"
//         ],
//         ["",
//             "A3602022-09-16A9",
//             "蘇酥酥",
//             "CL11F1A",
//             "冷氣",
//             "日期",
//             "狀態",
//             "$3,120"
//         ]
//     ]

    $(document).ready(function () {
        table = $('#example').DataTable({
            data: data,
            rowId: 1,
            searching: true,
            oLanguage: {    // 中文化  
                "sLengthMenu": "每頁顯示 _MENU_筆",
                "sZeroRecords": "沒有找到符合條件的資料",
                "sProcessing": "載入中...",
                "sInfo": "當前第 _START_ - _END_ 筆　共計 _TOTAL_ 筆",
                "sInfoEmpty": "沒有記錄",
                "sInfoFiltered": "(從 _MAX_ 條記錄中過濾)",
                "sSearch": "搜尋：",
                "oPaginate": {
                    "sFirst": "首頁",
                    "sPrevious": "前一頁",
                    "sNext": "後一頁",
                    "sLast": "尾頁"
                }
            },
            iDisplayLength: 5,// 每頁顯示筆數 
            lengthMenu: [[5, 10, 25, 50, -1], [5, 10, 25, 50, "All"]],

            columnDefs: [{
                orderable: false,
                className: 'select-checkbox',
                targets: 0

            }],
            select: {
                style: 'multi',
                selector: 'td:first-child'
            },
            order: [[1, 'asc']]
        });
    });

    $('#example tbody').on('click', 'tr td:first-child', function () {
        //console.log(table.cell(this).render());
        //console.log(table.row($(this).closest('tr')).data());

        // THIS LINE HERE IS NEW
//         console.log(table.row($(this).closest('tr')).data()[1]);
    });
</script>
</html>