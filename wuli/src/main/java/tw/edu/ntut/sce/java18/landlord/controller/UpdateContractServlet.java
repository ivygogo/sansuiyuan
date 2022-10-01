package tw.edu.ntut.sce.java18.landlord.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tw.edu.ntut.sce.java18.landlord.service.ContractService;
import tw.edu.ntut.sce.java18.landlord.service.impl.ContractServiceImple;

@WebServlet("/Update")
public class UpdateContractServlet extends HttpServlet {
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
    //    HttpSession session = request.getSession();
    Map<String, String> errorMsgs = new HashMap<String, String>();
    request.setAttribute("ErrMsg", errorMsgs);
    ContractService cs = new ContractServiceImple();
    String number = request.getParameter("selects");
    errorMsgs.put("CIDError", "");
    if (number == null || number.trim().length() == 0) {
      errorMsgs.put("CIDError", "請打勾框框後，在進行刪除!");
      //      response.sendRedirect("Contract.do");
      RequestDispatcher rd = request.getRequestDispatcher("Contract.do");
      rd.forward(request, response);
    } else {
      System.out.println(number);
      String[] CID = number.split(",");
      System.out.println(CID);
      System.out.println(Arrays.toString(CID));
      for (int i = 0; i < CID.length; i++) {
        System.out.println(CID[i]);
        cs.changeHide0(Integer.parseInt(CID[i].trim()));
      }
      response.sendRedirect("Contract.do");
    }
  }
}
