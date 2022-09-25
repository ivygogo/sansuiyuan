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

@WebServlet("/booking/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String bookerId = request.getParameter("bookerId");
    try {
      // 載入資料庫驅動，註冊到驅動管理器
      //      Class.forName("com.mysql.jdbc.Driver");
      // 資料庫連線字串
      String url =
          "jdbc:mysql://127.0.0.1/wulidb?useUnicode=yes&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Taipei&allowPublicKeyRetrieval=true";
      // 資料庫使用者名稱
      String username = "admin";
      // 資料庫密碼
      String password = "admin123";
      // 建立Connection連線
      Connection conn = DriverManager.getConnection(url, username, password);
      // 刪除圖書資訊的SQL語句
      String sql = "delete from bookingexample where booker_id=?";
      // 獲取PreparedStatement
      PreparedStatement ps = conn.prepareStatement(sql);
      // 對SQL語句中的第一個佔位符賦值
      ps.setString(1, bookerId);
      // 執行更新操作
      ps.executeUpdate();
      // 關閉PreparedStatement
      ps.close();
      // 關閉Connection
      conn.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    RequestDispatcher rd = request.getRequestDispatcher("/booking/showBookList.jsp");
    rd.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
