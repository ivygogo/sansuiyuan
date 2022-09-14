package tw.edu.ntut.sce.java18.common.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
    Map<String, String> errorMessage = new HashMap<>();
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
    if (bookDate == null || bookDate.trim().length() == 0) {
      errorMessage.put("bookDate", "請選擇日期");
    }
    if (bookDate != null && bookDate.trim().length() > 0) {
      try {
        date = java.sql.Date.valueOf(bookDate);
      } catch (IllegalArgumentException e) {
        errorMessage.put("bookDate", "請選擇ISO 8601變更日期格式");
      }
    }
    String preferTime = request.getParameter("preferTime");
    if (preferTime == null || preferTime.trim().length() == 0) {
      errorMessage.put("preferTime", "請選擇時段");
    }
    String bookerId = request.getParameter("bookerId");
    if (bookerId == null || bookerId.trim().length() == 0) {
      errorMessage.put("bookerId", "帳號欄必須輸入");
    }
    String bookerName = request.getParameter("bookerName");
    if (bookerName == null || bookerName.trim().length() == 0) {
      errorMessage.put("bookerName", "姓名欄必須輸入");
    }
    String bookerPhone = request.getParameter("bookerPhone");
    if (bookerPhone == null || bookerPhone.trim().length() == 0) {
      errorMessage.put("bookerPhone", "電話欄必須輸入");
    }
    String roomtype = request.getParameter("roomtype");
    if (roomtype == null || roomtype.trim().length() == 0) {
      errorMessage.put("roomtype", "房型欄必須輸入");
    }
    String preferFloor = request.getParameter("preferFloor");
    if (preferFloor == null || preferFloor.trim().length() == 0) {
      errorMessage.put("preferFloor", "請選擇偏好樓層");
    }
    String leadPerson = request.getParameter("leadPerson");

    if (!errorMessage.isEmpty()) {
      RequestDispatcher rd = request.getRequestDispatcher("/booking/booking.jsp");
      rd.forward(request, response);
      return;
    }

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
    try {
      service.delete(bookerId);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
