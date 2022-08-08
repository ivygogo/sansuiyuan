package tw.edu.ntut.sce.java18.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import tw.edu.ntut.sce.java18.common.utils.DBService;

public class EDMTableResetDemo {
  public static final String UTF8_BOM = "\uFEFF"; // 定義 UTF-8的BOM字元

  public static void main(String args[]) {

    try (Connection connection =
            DriverManager.getConnection(
                DBService.getDbTableUrl(), DBService.getUser(), DBService.getPassword());
        Statement stmt = connection.createStatement(); ) {

      stmt.executeUpdate(DBService.getDropFaq());
      System.out.println("表格刪除成功");
      stmt.executeUpdate(DBService.getCreateFaq());
      System.out.println("表格產生成功");

    } catch (SQLException e) {
      System.err.println("新建表格時發生SQL例外: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
