package tw.edu.ntut.sce.java18.common.storage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.storage.dao.RoomTypeDao;
import tw.edu.ntut.sce.java18.common.storage.model.RoomTypeBean;
import tw.edu.ntut.sce.java18.common.utils.DBService;

public class RoomTypeDaoImpl_JDBC implements RoomTypeDao {
  private final DataSource ds;

  public RoomTypeDaoImpl_JDBC() {
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("RoomTypeDaoImpl_JDBC類別 #建構子發生例外: " + ex.getMessage());
    }
  }

  @Override
  public RoomTypeBean queryRoomType(String type) {
    RoomTypeBean roomTypeBean = null;
    String sql = "SELECT * FROM roomtype WHERE type = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, type);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          roomTypeBean = new RoomTypeBean();
          roomTypeBean.setType(resultSet.getString("Type"));
          roomTypeBean.setName(resultSet.getString("Name"));
          roomTypeBean.setTotal(resultSet.getInt("Total"));
          roomTypeBean.setPrice(resultSet.getInt("Price"));
          roomTypeBean.setSize(resultSet.getDouble("Size"));
          roomTypeBean.setBalcony(resultSet.getBoolean("Balcony"));
          roomTypeBean.setPic1(resultSet.getString("Pic1"));
          roomTypeBean.setPic2(resultSet.getString("Pic2"));
          roomTypeBean.setPic3(resultSet.getString("Pic3"));

          roomTypeBean.setQ_TV(resultSet.getInt("Q_TV"));
          roomTypeBean.setQ_Refrigerator(resultSet.getInt("Q_Refrigerator"));
          roomTypeBean.setQ_AirCondition(resultSet.getInt("Q_AirCondition"));
          roomTypeBean.setQ_Heater(resultSet.getInt("Q_Heater"));
          roomTypeBean.setQ_Mirror(resultSet.getInt("Q_Mirror"));
          roomTypeBean.setQ_Flow_Table(resultSet.getInt("Q_Flow_Table"));
          roomTypeBean.setQ_Side_Table_S(resultSet.getInt("Q_Side_Table_S"));
          roomTypeBean.setQ_Side_Table_L(resultSet.getInt("Q_Side_Table_L"));
          roomTypeBean.setQ_Bed_Board_S(resultSet.getInt("Q_Bed_Board_S"));
          roomTypeBean.setQ_Bed_Board_L(resultSet.getInt("Q_Bed_Board_S"));
          roomTypeBean.setQ_Desk_S(resultSet.getInt("Q_Desk_S"));
          roomTypeBean.setQ_Desk_L(resultSet.getInt("Q_Desk_L"));
          roomTypeBean.setQ_Bed_S(resultSet.getInt("Q_Bed_S"));
          roomTypeBean.setQ_Bed_L(resultSet.getInt("Q_Bed_L"));
          roomTypeBean.setQ_Window_Screen_S(resultSet.getInt("Q_Window_Screen_S"));
          roomTypeBean.setQ_Window_Screen_L(resultSet.getInt("Q_Window_Screen_L"));
          roomTypeBean.setQ_Window_Screen_G(resultSet.getInt("Q_Window_Screen_G"));
          roomTypeBean.setQ_Wardrobe(resultSet.getInt("Q_Wardrobe"));
          roomTypeBean.setQ_Chair(resultSet.getInt("Q_Chair"));

          roomTypeBean.setP_TV(resultSet.getInt("Q_TV"));
          roomTypeBean.setP_Refrigerator(resultSet.getInt("P_Refrigerator"));
          roomTypeBean.setP_AirCondition(resultSet.getInt("P_AirCondition"));
          roomTypeBean.setP_Heater(resultSet.getInt("P_Heater"));
          roomTypeBean.setP_Mirror(resultSet.getInt("P_Mirror"));
          roomTypeBean.setP_Flow_Table(resultSet.getInt("P_Flow_Table"));
          roomTypeBean.setP_Side_Table_S(resultSet.getInt("P_Side_Table_S"));
          roomTypeBean.setP_Side_Table_L(resultSet.getInt("P_Side_Table_L"));
          roomTypeBean.setP_Bed_Board_S(resultSet.getInt("P_Bed_Board_S"));
          roomTypeBean.setP_Bed_Board_L(resultSet.getInt("P_Bed_Board_S"));
          roomTypeBean.setP_Desk_S(resultSet.getInt("P_Desk_S"));
          roomTypeBean.setP_Desk_L(resultSet.getInt("P_Desk_L"));
          roomTypeBean.setP_Bed_S(resultSet.getInt("P_Bed_S"));
          roomTypeBean.setP_Bed_L(resultSet.getInt("P_Bed_L"));
          roomTypeBean.setP_Window_Screen_S(resultSet.getInt("P_Window_Screen_S"));
          roomTypeBean.setP_Window_Screen_L(resultSet.getInt("P_Window_Screen_L"));
          roomTypeBean.setP_Window_Screen_G(resultSet.getInt("P_Window_Screen_G"));
          roomTypeBean.setP_Wardrobe(resultSet.getInt("P_Wardrobe"));
          roomTypeBean.setP_Chair(resultSet.getInt("P_Chair"));
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("RoomTypeDaoImpl_JDBC類別#queryRoomType()發生例外: " + ex.getMessage());
    }
    return roomTypeBean;
  }
}
