package tw.edu.ntut.sce.java18.landlord.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tw.edu.ntut.sce.java18.landlord.service.ContractService;
import tw.edu.ntut.sce.java18.landlord.service.Imple.ContractServiceImple;

@WebServlet("/wuli/modify")
public class modify extends HttpServlet {
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
    String status = request.getParameter("status");
    String name = request.getParameter("name");
    String PDF = request.getParameter("PDF");
    String room_Number = request.getParameter("room_Number");
    String payment_Status = request.getParameter("payment_Status");
    String deposit = request.getParameter("deposit");
    String check_Fee = request.getParameter("check_Fee");
    String check_Status = request.getParameter("check_Status");
    int CID = Integer.parseInt(request.getParameter("CID").trim());
    cs.modifyContract(
        status, name, PDF, room_Number, payment_Status, deposit, check_Fee, check_Status, CID);
    System.out.println(payment_Status);

    response.sendRedirect("ContractServlet");
  }
}
