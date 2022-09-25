package tw.edu.ntut.sce.java18.common.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tw.edu.ntut.sce.java18.common.dao.impl.BookDAO;
import tw.edu.ntut.sce.java18.common.model.BookerBean;

@WebServlet("/")
public class BookingServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private BookDAO bookingDao;

  @Override
  public void init() {
    bookingDao = new BookDAO();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String action = request.getServletPath();

    try {
      switch (action) {
        case "/new":
          showNewForm(request, response);
          break;
        case "/insert":
          insertUser(request, response);
          break;
        case "/delete":
          deleteUser(request, response);
          break;
        case "/edit":
          showEditForm(request, response);
          break;
        case "/update":
          updateUser(request, response);
          break;
        default:
          listUser(request, response);
          break;
      }
    } catch (SQLException ex) {
      throw new ServletException(ex);
    }
  }

  private void listUser(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException, ServletException {
    List<BookerBean> listUser = bookingDao.selectAllUsers();
    request.setAttribute("listUser", listUser);
    RequestDispatcher dispatcher = request.getRequestDispatcher("bookinglist.jsp");
    dispatcher.forward(request, response);
  }

  private void showNewForm(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("book-form.jsp");
    dispatcher.forward(request, response);
  }

  private void showEditForm(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    BookerBean existingUser = bookingDao.selectUser(id);
    RequestDispatcher dispatcher = request.getRequestDispatcher("book-form.jsp");
    request.setAttribute("user", existingUser);
    dispatcher.forward(request, response);
  }

  private void insertUser(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    Integer bookerId = null;
    try {
      bookerId = Integer.parseInt(request.getParameter("bookerId").trim());
    } catch (NumberFormatException e1) {
      bookerId = (int) (Math.random() * 999999) + 900000;
    }

    System.out.println(bookerId);
    String bookDate = request.getParameter("bookDate");
    Date date = null;
    try {
      date = java.sql.Date.valueOf(bookDate);
    } catch (Exception e) {
      e.printStackTrace();
    }
    String preferTime = request.getParameter("preferTime");
    String bookerName = request.getParameter("bookerName");
    String bookerPhone = request.getParameter("bookerPhone");
    String roomtype = request.getParameter("roomtype");
    String preferFloor = request.getParameter("preferFloor");
    String leadPerson = request.getParameter("leadPerson");
    BookerBean newBooker =
        new BookerBean(
            bookerId, date, preferTime, bookerName, bookerPhone, roomtype, preferFloor, leadPerson);
    bookingDao.insertUser(newBooker);
    response.sendRedirect("list");
  }

  private void updateUser(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int bookerId = Integer.parseInt(request.getParameter("bookerId").trim());
    String bookDate = request.getParameter("bookDate");
    Date date = null;
    try {
      date = java.sql.Date.valueOf(bookDate);
    } catch (Exception e) {
      e.printStackTrace();
    }
    String preferTime = request.getParameter("preferTime");
    String bookerName = request.getParameter("bookerName");
    String bookerPhone = request.getParameter("bookerPhone");
    String roomtype = request.getParameter("roomtype");
    String preferFloor = request.getParameter("preferFloor");
    String leadPerson = request.getParameter("leadPerson");

    BookerBean booker =
        new BookerBean(
            bookerId, date, preferTime, bookerName, bookerPhone, roomtype, preferFloor, leadPerson);
    bookingDao.updateUser(booker);
    response.sendRedirect("list");
  }

  private void deleteUser(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int id = Integer.parseInt(request.getParameter("bookerId"));
    bookingDao.deleteUser(id);
    response.sendRedirect("list");
  }
}
