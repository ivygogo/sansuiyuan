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
import tw.edu.ntut.sce.java18.landlord.model.ContractBean;
import tw.edu.ntut.sce.java18.landlord.service.ContractService;
import tw.edu.ntut.sce.java18.landlord.service.impl.ContractServiceImple;

@WebServlet("/ContractNameSearchServlet")
public class ContractNameSearchServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ContractService cs = new ContractServiceImple();
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    request.setAttribute("searchResult", null);
    String name = request.getParameter("SearchResult");
    System.out.println(name);
    List<ContractBean> nameList = new ArrayList<>();
    nameList = cs.nameSearch(name);
    request.setAttribute("searchResult", nameList);
    RequestDispatcher rd = request.getRequestDispatcher("Contract.do");
    rd.forward(request, response);
    //    response.sendRedirect("Contract.do");
  }
}
