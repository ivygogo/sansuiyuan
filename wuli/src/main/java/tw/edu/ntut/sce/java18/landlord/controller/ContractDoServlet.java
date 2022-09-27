package tw.edu.ntut.sce.java18.landlord.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tw.edu.ntut.sce.java18.landlord.model.ContractBean;
import tw.edu.ntut.sce.java18.landlord.service.ContractService;
import tw.edu.ntut.sce.java18.landlord.service.Imple.ContractServiceImple;

@WebServlet("/Contract.do")
public class ContractDoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    doPost(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");

    ContractService cs = new ContractServiceImple();
    HttpSession session = request.getSession();
    List<ContractBean> allcontract = new ArrayList<>();
    allcontract = cs.getAllContract();
    //   String cbs1 = cs.getStatus("租賃中");
    ContractBean cbs1 = cs.getStatus("租賃中");
    ContractBean cbs2 = cs.getStatus("已退租");
    ContractBean cbs3 = cs.getStatus("租約到期");
    ContractBean cbps1 = cs.getPayment_Status("已繳");
    ContractBean cbps2 = cs.getPayment_Status("未繳");
    ContractBean cbcs1 = cs.getCheck_Status("未點交");
    ContractBean cbcs2 = cs.getCheck_Status("已點交");
    Map<String, ContractBean> map2 = new HashMap<>();
    map2.put("cbs1", cbs1);
    map2.put("cbs2", cbs2);
    map2.put("cbs3", cbs3);
    System.out.println(map2.get("cbs1").getStatus());
    Map<String, ContractBean> map3 = new HashMap<>();
    map3.put("cbps1", cbps1);
    map3.put("cbps2", cbps2);
    Map<String, ContractBean> map4 = new HashMap<>();
    map4.put("cbcs1", cbcs1);
    map4.put("cbcs2", cbcs2);
    session.setAttribute("allContract", allcontract);
    session.setAttribute("contractS", map2);
    session.setAttribute("contractPS", map3);
    session.setAttribute("contractCS", map4);
    //    request.setAttribute("allContract", Allcontract);
    // request.setAttribute("contractS", map2);
    // request.setAttribute("contractPS", map3);
    // request.setAttribute("contractCS", map4);

    RequestDispatcher rd = request.getRequestDispatcher("/contractQuery.jsp");

    rd.forward(request, response);
  }
}
