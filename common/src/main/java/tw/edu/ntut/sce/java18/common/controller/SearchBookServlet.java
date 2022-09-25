package tw.edu.ntut.sce.java18.common.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("searchBookingServlet")
public class SearchBookServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    request.setCharacterEncoding("UTF-8");
    //    PrintWriter out = response.getWriter();
    System.out.println("測試");
    String url =
        "jdbc:mysql://127.0.0.1/wulidb?useUnicode=yes&"
            + "characterEncoding=utf8&useSSL=false&serverTimezone=Asia/"
            + "Taipei&allowPublicKeyRetrieval=true";
    String userName = "admin";
    String password = "admin123";
    Statement st;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url, userName, password);
      System.out.println("連接資料庫測試");
      //      String bookerName = request.getParameter("bookerName");
      //      String bookerId = request.getParameter("bookerId");
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
      //      Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url, userName, password);
      System.out.println("連接資料庫測試");
      //      String bookerName = request.getParameter("bookerName");
      String bookerId = request.getParameter("bookerId");
      //      String bookDate = request.getParameter("bookDate");

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
