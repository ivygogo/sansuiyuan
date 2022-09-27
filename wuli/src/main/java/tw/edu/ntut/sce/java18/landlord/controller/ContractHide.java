package tw.edu.ntut.sce.java18.landlord.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

@WebServlet("/ContractHide")
public class ContractHide extends HttpServlet {
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
    HttpSession session = request.getSession();
    ContractService cs = new ContractServiceImple();
    List<ContractBean> allHideContract = new ArrayList<>();
    allHideContract = cs.getAllHideContract();
    //    request.setAttribute("allHideContract", Allcontract);
    session.setAttribute("allHideContract", allHideContract);
    RequestDispatcher rd = request.getRequestDispatcher("/wuliContract/contractHide.jsp");

    rd.forward(request, response);
  }
}
