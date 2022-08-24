package tw.edu.ntut.sce.java18.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.dao.RoomDao;
import tw.edu.ntut.sce.java18.common.model.RoomBean;
import tw.edu.ntut.sce.java18.common.utils.DBService;

public class RoomDaoImpl_JDBC implements RoomDao {

  private final DataSource ds;

  public RoomDaoImpl_JDBC() {
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("RoomDaoImpl_JDBC類別 #建構子發生例外: " + ex.getMessage());
    }
  }

  @Override
  public Map<Integer, Integer> getAvailableFloorCount(String type) {

    Map<Integer, Integer> availableFloorCount = new HashMap<>();

    for (var f = 1; f <= 8; f++) {
      String sql =
          "SELECT COUNT(FLOOR) FROM room WHERE Tenant_Number IS NULL AND Roomtype='"
              + type
              + "' and FLOOR="
              + f;
      try (Connection connection = ds.getConnection();
          PreparedStatement ps = connection.prepareStatement(sql);
          ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          Integer count = rs.getInt(1);
          availableFloorCount.put(f, count);
        }
      } catch (SQLException ex) {
        ex.printStackTrace();
        throw new RuntimeException(
            "MemberDaoImpl_Jdbc()#getAvailableFloor()發生例外: " + ex.getMessage());
      }
    }
    return availableFloorCount;
  }

  @Override
  public ArrayList<String> getEmptyRoom() {
    ArrayList<String> emptyRoom = new ArrayList<>();
    String sql = "SELECT RoomId FROM room WHERE Tenant_Number IS NULL";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {
      if (rs.next()) {
        String empty = rs.getString(1);
        emptyRoom.add(empty);
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "MemberDaoImpl_Jdbc()#getAvailableFloor()發生例外: " + ex.getMessage());
    }
    return emptyRoom;
  }

  @Override
  public RoomBean queryRoom(String type) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void newRoom() {
    String sql =
        "DROP TABLE IF EXISTS `room`;\n"
            + "   CREATE TABLE `room` (\n"
            + "  `Rid` int NOT NULL AUTO_INCREMENT,\n"
            + "  `Room_Number` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,\n"
            + "  `Building` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL,\n"
            + "  `Floor` int NOT NULL,\n"
            + "  `Location` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL,\n"
            + "  `Roomtype_Number` int NOT NULL,\n"
            + "  `Tenant_Number` int DEFAULT NULL,\n"
            + "  `Contract_Number` int DEFAULT NULL,\n"
            + "  PRIMARY KEY (`Rid`),\n"
            + "  UNIQUE KEY `Room_Number_UNIQUE` (`Room_Number`)\n"
            + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ;\n";
    throw new UnsupportedOperationException();
  }

  // 預計參數型態使用ContractBean
  @Override
  public void updateRoom() {
    // 參數預計是要使用Contractbeam
    //    String sql =
    //        "update Member set"
    //            + " Tenant_Number=?, Contract_Number=? where RoomId = ? ";
    //
    //    try (Connection connection = ds.getConnection();
    //        PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
    //      prepareStatement.setInt(1, contractbeam.getTenantId());
    //      prepareStatement.setInt(2, contractbeam.getContractId());
    //      prepareStatement.setString(3, contractbeam.getRoomId());
    //
    //    } catch (SQLException e) {
    //      throw new UnsupportedOperationException();
    //      throw new RuntimeException(e);
    //    }
  }
}
