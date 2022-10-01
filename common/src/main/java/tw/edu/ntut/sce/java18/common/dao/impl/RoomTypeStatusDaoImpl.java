package tw.edu.ntut.sce.java18.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.dao.RoomTypeStatusDao;
import tw.edu.ntut.sce.java18.common.model.ContractStatusBean;
import tw.edu.ntut.sce.java18.common.utils.DBService;

public class RoomTypeStatusDaoImpl implements RoomTypeStatusDao {
  private final DataSource ds;

  public RoomTypeStatusDaoImpl() {
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("RoomTypeDaoImpl_JDBC類別 #建構子發生例外: " + ex.getMessage());
    }
  }

  @Override
  public ContractStatusBean queryRoomTypeStatus(String roomNumber) {
    String sql = "SELECT status FROM contract WHERE Room_Number = ?";
    ContractStatusBean result = new ContractStatusBean();

    try (Connection connection = ds.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql)) {
      stmt.setString(1, roomNumber);
      // try (ResultSet resultSet = stmt.executeQuery()) {
      ResultSet rset = stmt.executeQuery();
      while (rset.next()) {
        result = new ContractStatusBean();
        result.setStatus(rset.getString("status"));
        //  }
        System.out.println(rset.getString("status"));
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "RoomTypeStatusDaoImpl類別#queryRoomTypeStatus()發生例外: " + ex.getMessage());
    }
    return result;
  }
}
