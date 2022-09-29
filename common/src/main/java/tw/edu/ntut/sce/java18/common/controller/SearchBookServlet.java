package tw.edu.ntut.sce.java18.common.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.utils.DBService;

// @WebServlet("searchBookingServlet")
public class SearchBookServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private DataSource ds = null;

  public SearchBookServlet() {
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("AvatarDaoImpl類別#建構子發生例外: " + ex.getMessage());
    }
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    request.setCharacterEncoding("UTF-8");
    System.out.println("測試");
    Statement st;
    try {
      Connection conn = ds.getConnection();
      System.out.println("連接資料庫測試");
      String bookDate = request.getParameter("bookDate");
      ArrayList al = null;
      ArrayList book_list = new ArrayList();
      String query = "select * from bookingexample where " + "book_date='" + bookDate + "'";
      System.out.println("SQL指令: " + query);
      st = conn.createStatement();
      ResultSet rs = st.executeQuery(query);

      while (rs.next()) {
        al = new ArrayList();
        al.add(rs.getString(1));
        al.add(rs.getString(2));
        al.add(rs.getString(3));
        al.add(rs.getString(4));
        al.add(rs.getString(5));
        al.add(rs.getString(6));
        al.add(rs.getString(7));
        al.add(rs.getString(8));
        System.out.println("al :: " + al);
        book_list.add(al);
      }
      request.setAttribute("booklist", book_list);
      System.out.println("booklist " + book_list);
      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bookinglist.jsp");
      dispatcher.forward(request, response);
      conn.close();
      System.out.println("測試結束連線");
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      Connection conn = ds.getConnection();
      System.out.println("連接資料庫測試");
      String bookerId = request.getParameter("bookerId");
      ArrayList al = null;
      ArrayList book_list = new ArrayList();
      String query = "select * from bookingexample where " + "booker_id='" + bookerId + "'";
      System.out.println("SQL指令: " + query);
      st = conn.createStatement();
      ResultSet rs = st.executeQuery(query);

      while (rs.next()) {
        al = new ArrayList();

        al.add(rs.getString(1));
        al.add(rs.getString(2));
        al.add(rs.getString(3));
        al.add(rs.getString(4));
        al.add(rs.getString(5));
        al.add(rs.getString(6));
        al.add(rs.getString(7));
        al.add(rs.getString(8));
        System.out.println("al :: " + al);
        book_list.add(al);
      }
      request.setAttribute("booklist", book_list);
      System.out.println("booklist " + book_list);
      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bookinglist.jsp");
      dispatcher.forward(request, response);
      conn.close();
      System.out.println("測試結束連線");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
