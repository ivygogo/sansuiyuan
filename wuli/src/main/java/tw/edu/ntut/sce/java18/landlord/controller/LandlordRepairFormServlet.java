package tw.edu.ntut.sce.java18.landlord.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tw.edu.ntut.sce.java18.common.model.RepairFormBean;
import tw.edu.ntut.sce.java18.common.service.impl.RepairFormServiceImpl;

/** Servlet implementation class LandlordRepairFormServlet */
@WebServlet("/LandlordRepairFormServlet.do")
public class LandlordRepairFormServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public LandlordRepairFormServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    final Gson gson = new Gson();
    response.setContentType("text/html; charset=UTF-8;");
    response.setCharacterEncoding("UTF-8");
    HttpSession session = request.getSession();
    var printWriter = response.getWriter();
    List<RepairFormBean> repairFormList = new ArrayList<>();
    repairFormList = new RepairFormServiceImpl().queryAllRepairForm();

    var reparFormListJson = gson.toJson(repairFormList);
    printWriter.print(reparFormListJson);
    System.out.println(reparFormListJson);
    printWriter.flush();
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}
}
