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
import tw.edu.ntut.sce.java18.common.dao.impl.BookDaoHibernate;
import tw.edu.ntut.sce.java18.common.model.BookerBeanHibernate;

@WebServlet("/bookH.do")
public class BookServletHibernate extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private BookDaoHibernate bookDaoHibernate;

  @Override
  public void init() {
    bookDaoHibernate = new BookDaoHibernate();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String action = request.getServletPath();

    try {
      switch (action) {
        case "new":
          showNewForm(request, response);
          break;
        case "insert":
          insertUser(request, response);
          break;
        case "delete":
          deleteUser(request, response);
          break;
        case "edit":
          showEditForm(request, response);
          break;
        case "update":
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
    List<BookerBeanHibernate> listUser = bookDaoHibernate.getAllUser();
    System.out.println(listUser);
    request.setAttribute("listUser", listUser);
    RequestDispatcher dispatcher = request.getRequestDispatcher("bookinglistH.jsp");
    dispatcher.forward(request, response);
  }

  private void showNewForm(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
    dispatcher.forward(request, response);
  }

  private void showEditForm(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    BookerBeanHibernate existingUser = bookDaoHibernate.getUser(id);
    RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
    request.setAttribute("user", existingUser);
    dispatcher.forward(request, response);
  }

  private void insertUser(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    Integer bookerId = null;
    try {
      bookerId = Integer.parseInt(request.getParameter("bookerId").trim());
    } catch (NumberFormatException e1) {
      bookerId = (int) (Math.random() * 999999999) + 900000000;
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
    BookerBeanHibernate newBooker =
        new BookerBeanHibernate(
            bookerId, date, preferTime, bookerName, bookerPhone, roomtype, preferFloor, leadPerson);

    bookDaoHibernate.saveUser(newBooker);
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

    BookerBeanHibernate user =
        new BookerBeanHibernate(
            bookerId, date, preferTime, bookerName, bookerPhone, roomtype, preferFloor, leadPerson);

    bookDaoHibernate.updateUser(user);
    response.sendRedirect("list");
  }

  private void deleteUser(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    bookDaoHibernate.deleteUser(id);
    response.sendRedirect("list");
  }
}
