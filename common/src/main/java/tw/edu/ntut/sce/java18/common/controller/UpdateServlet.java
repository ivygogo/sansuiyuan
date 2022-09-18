package tw.edu.ntut.sce.java18.common.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/booking/UpdateBookServlet")
public class UpdateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String bookerId = request.getParameter("bookerId");
    String preferTime = request.getParameter("preferTime");
    System.out.println(bookerId);
    System.out.println(preferTime);
    try {
      // 載入資料庫驅動，註冊到驅動管理器
      Class.forName("com.mysql.jdbc.Driver");
      // 資料庫連線字串
      String url =
          "jdbc:mysql://127.0.0.1/wulidb?useUnicode=yes&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Taipei&allowPublicKeyRetrieval=true";
      // 資料庫使用者名稱
      String username = "admin";
      // 資料庫密碼
      String password = "admin123";
      // 建立Connection連線
      Connection conn = DriverManager.getConnection(url, username, password);

      String sql = "update bookingexample set prefer_time=? where booker_id=?";
      // 獲取PreparedStatement
      PreparedStatement ps = conn.prepareStatement(sql);

      ps.setString(1, preferTime);

      ps.setString(2, bookerId);

      ps.executeUpdate();

      ps.close();

      conn.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    //    request.setAttribute("preferTime", preferTime);
    RequestDispatcher rd = request.getRequestDispatcher("/booking/showBookList.jsp");
    rd.forward(request, response);
  }
}
