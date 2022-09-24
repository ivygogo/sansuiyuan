package tw.edu.ntut.sce.java18.landlord.controller;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tw.edu.ntut.sce.java18.landlord.service.ContractService;
import tw.edu.ntut.sce.java18.landlord.service.Imple.ContractServiceImple;

@WebServlet("/wuli/Update")
public class Update extends HttpServlet {
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

    String number = request.getParameter("selects");
    System.out.println(number);
    String[] CID = number.split(",");
    System.out.println(CID);
    System.out.println(Arrays.toString(CID));
    for (int i = 0; i < CID.length; i++) {
      System.out.println(CID[i]);
      cs.changeHide(Integer.parseInt(CID[i].trim()));
    }

    response.sendRedirect("ContractServlet");
  }
}
