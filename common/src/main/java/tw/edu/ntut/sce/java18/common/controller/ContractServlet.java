package tw.edu.ntut.sce.java18.common.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tw.edu.ntut.sce.java18.common.model.ContractBean;
import tw.edu.ntut.sce.java18.common.service.ContractService;

@WebServlet("/rentContractServlet.do")
public class ContractServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  public void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    request.setCharacterEncoding("UTF-8");

    String body = request.getReader().lines().collect(Collectors.joining());
    Type type = new TypeToken<Map<String, String>>() {}.getType();
    Map<String, String> map = new Gson().fromJson(body, type);

    java.text.SimpleDateFormat sf = new java.text.SimpleDateFormat("yyyyMMdd");
    String beginTime = map.get("startY") + map.get("startMM") + map.get("startDD");
    String endTime = map.get("endY") + map.get("endMM") + map.get("endDD");
    //    System.out.println("beginTime為:" + beginTime);
    //    System.out.println("endTime為:" + endTime);

    Date beginTimeSqlDate = null, endTimeSqlDate = null;
    try {
      java.util.Date beginTimeDate = sf.parse(beginTime);
      java.util.Date endTimeDate = sf.parse(endTime);
      beginTimeSqlDate = new Date(beginTimeDate.getTime());
      endTimeSqlDate = new Date(endTimeDate.getTime());
    } catch (ParseException e1) {
      e1.printStackTrace();
    }

    //    System.out.println("beginTimeSqlDate為:" + beginTimeSqlDate);
    //    System.out.println("endTimeSqlDate為:" + endTimeSqlDate);
    System.out.println("rentUid為:" + map.get("rentUid"));

    Integer member_Id = Integer.parseInt(map.get("rentUid"));
    String contract_Number = map.get("pdfName");
    Date begin_Time = beginTimeSqlDate;
    Date end_Time = endTimeSqlDate;
    String room_Number = map.get("roomNumber");
    Integer deposit = Integer.parseInt(map.get("rent"));

    System.out.println(map);
    System.out.println("Integer member_Id:" + member_Id);
    System.out.println("String contract_Number:" + contract_Number);
    System.out.println("Date begin_Time:" + begin_Time);
    System.out.println("Date end_Time:" + end_Time);
    System.out.println("String room_Number:" + room_Number);
    System.out.println("Integer deposit:" + deposit);

    ContractBean contract =
        new ContractBean(member_Id, contract_Number, begin_Time, end_Time, room_Number, deposit);
    ContractService service = new ContractService();
    try {
      service.insertTenant(contract);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
    dispatcher.forward(request, response);
  }
}
