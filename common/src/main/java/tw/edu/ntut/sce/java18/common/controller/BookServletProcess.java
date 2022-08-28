package tw.edu.ntut.sce.java18.common.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tw.edu.ntut.sce.java18.common.model.BookerBean;

@WebServlet("/booking/booking.do")
public class BookServletProcess extends HttpServlet {
  private static final long serialVersionUID = 1L;
  final String DEFAULT_NAME = "某某同學";
  final String DEFAULT_TEL = "(未輸入)";
  final String DEFAULT_EMAIL = "(未輸入)";
  final String DEFAULT_ROOMTYPE = "(未選擇房型)";
  final String DEFAULT_FLOOR = "(未選擇樓層)";
  final String DEFAULT_DATE = "(未選擇日期)";
  final String DEFAULT_TIME = "(未選擇時段)";

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
    String name = request.getParameter("userName");
    if (name == null || name.length() == 0) {
      name = DEFAULT_NAME;
    }
    String tel = request.getParameter("tel");
    if (tel == null || name.length() == 0) {
      tel = DEFAULT_TEL;
    }
    String email = request.getParameter("eMail");
    if (email == null || name.length() == 0) {
      email = DEFAULT_EMAIL;
    }
    String roomType = request.getParameter("roomType");

    if (roomType == null || roomType.length() == 0) {
      roomType = DEFAULT_ROOMTYPE;
    }

    String date = request.getParameter("date");

    if (date == null || date.length() == 0) {
      date = DEFAULT_DATE;
    }
    String[] time = request.getParameterValues("time");
    String[] floor = request.getParameterValues("floor");

    //    BookerBean booker =
    //        new BookerBean("阿布拉", "0936123456", "gg@gmail.com", "A房型", "低樓層", "2009-12-31",
    // "13-30");
    BookerBean booker = new BookerBean(name, tel, email, roomType, floor, date, time);

    request.setAttribute("booker", booker);

    RequestDispatcher rd = request.getRequestDispatcher("/booking/displayBookingInfo.jsp");
    rd.forward(request, response);
  }
}
