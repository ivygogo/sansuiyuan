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
import tw.edu.ntut.sce.java18.landlord.model.ContractBean;
import tw.edu.ntut.sce.java18.landlord.service.ContractService;
import tw.edu.ntut.sce.java18.landlord.service.Imple.ContractServiceImple;

@WebServlet("/wuli/ContractServlet")
public class ContractServlet extends HttpServlet {
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

    List<ContractBean> Allcontract = new ArrayList<>();
    Allcontract = cs.getAllContract();

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
    Map<String, ContractBean> map3 = new HashMap<>();
    map3.put("cbps1", cbps1);
    map3.put("cbps2", cbps2);
    Map<String, ContractBean> map4 = new HashMap<>();
    map4.put("cbcs1", cbcs1);
    map4.put("cbcs2", cbcs2);
    request.setAttribute("allContract", Allcontract);
    request.setAttribute("contractS", map2);
    request.setAttribute("contractPS", map3);
    request.setAttribute("contractCS", map4);

    RequestDispatcher rd = request.getRequestDispatcher("/wuli/Wuli.jsp");

    rd.forward(request, response);
  }
}
