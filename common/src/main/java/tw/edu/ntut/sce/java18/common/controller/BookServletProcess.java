package tw.edu.ntut.sce.java18.common.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tw.edu.ntut.sce.java18.common.model.BookerBean;
import tw.edu.ntut.sce.java18.common.service.BookingService;

@WebServlet("/booking/booking.do")
public class BookServletProcess extends HttpServlet {
  private static final long serialVersionUID = 1L;

  //  final String DEFAULT_NAME = "某某同學";
  //  final String DEFAULT_TEL = "(未輸入)";
  //  final String DEFAULT_EMAIL = "(未輸入)";
  //  final String DEFAULT_ROOMTYPE = "(未選擇房型)";
  //  final String DEFAULT_FLOOR = "(未選擇樓層)";
  //  final String DEFAULT_DATE = "(未選擇日期)";
  //  final String DEFAULT_TIME = "(未選擇時段)";

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
    Collection<String> errorMessage = new ArrayList<String>();
    request.setAttribute("ErrorMsg", errorMessage);

    // NEEDFIX    自動編碼新增不進資料庫
    //    String id = request.getParameter("id");
    //    Integer dId = -1;
    //    if (id != null && id.trim().length() > 0) {
    //      try {
    //        dId = Integer.parseInt(id.trim());
    //      } catch (NumberFormatException e) {
    //        ;
    //      }
    //    }
    String bookDate = request.getParameter("bookDate");
    java.sql.Date date = null;

    if (bookDate != null && bookDate.trim().length() > 0) {
      try {
        date = java.sql.Date.valueOf(bookDate);
      } catch (IllegalArgumentException e) {
        ;
      }
    }
    String preferTime = request.getParameter("preferTime");
    String bookerId = request.getParameter("bookerId");
    String bookerName = request.getParameter("bookerName");
    String bookerPhone = request.getParameter("bookerPhone");
    String roomtype = request.getParameter("roomtype");
    String preferFloor = request.getParameter("preferFloor");
    String leadPerson = request.getParameter("leadPerson");

    BookerBean booker =
        new BookerBean(
            date, preferTime, bookerId, bookerName, bookerPhone, roomtype, preferFloor, leadPerson);
    BookingService service = new BookingService();
    try {
      service.insertBooker(booker);
      request.setAttribute("bookerBean", booker);
      RequestDispatcher rd = request.getRequestDispatcher("/booking/displayBookingInfo.jsp");
      rd.forward(request, response);
      return;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
