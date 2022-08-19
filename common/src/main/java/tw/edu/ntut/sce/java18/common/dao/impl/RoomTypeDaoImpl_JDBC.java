package tw.edu.ntut.sce.java18.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.dao.RoomTypeDao;
import tw.edu.ntut.sce.java18.common.model.RoomTypeBean;
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
  public RoomTypeBean queryRoomTypeInfo(String type) {

    String sql = "SELECT * FROM roomtype WHERE type = ?";
    var roomTypeBean = new RoomTypeBean();
    try (Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, type);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          roomTypeBean.setType(resultSet.getString("Type"));
          roomTypeBean.setName(resultSet.getString("Name"));
          roomTypeBean.setTotal(resultSet.getInt("Total"));
          roomTypeBean.setPrice(resultSet.getInt("Price"));
          roomTypeBean.setSize(resultSet.getString("Size"));
          roomTypeBean.setBalcony(resultSet.getBoolean("Balcony"));
          roomTypeBean.setPic1(resultSet.getString("Pic1"));
          roomTypeBean.setPic2(resultSet.getString("Pic2"));
          roomTypeBean.setPic3(resultSet.getString("Pic3"));

          roomTypeBean.setQTV(resultSet.getInt("Q_TV"));
          roomTypeBean.setQRefrigerator(resultSet.getInt("Q_Refrigerator"));
          roomTypeBean.setQAirCondition(resultSet.getInt("Q_AirCondition"));
          roomTypeBean.setQHeater(resultSet.getInt("Q_Heater"));
          roomTypeBean.setQMirror(resultSet.getInt("Q_Mirror"));
          roomTypeBean.setQFlowTable(resultSet.getInt("Q_Flow_Table"));
          roomTypeBean.setQSideTableS(resultSet.getInt("Q_Side_Table_S"));
          roomTypeBean.setQSideTableL(resultSet.getInt("Q_Side_Table_L"));
          roomTypeBean.setQBedBoardS(resultSet.getInt("Q_Bed_Board_S"));
          roomTypeBean.setQBedBoardL(resultSet.getInt("Q_Bed_Board_S"));
          roomTypeBean.setQDeskS(resultSet.getInt("Q_Desk_S"));
          roomTypeBean.setQDeskL(resultSet.getInt("Q_Desk_L"));
          roomTypeBean.setQBedS(resultSet.getInt("Q_Bed_S"));
          roomTypeBean.setQBedL(resultSet.getInt("Q_Bed_L"));
          roomTypeBean.setQWindowScreenS(resultSet.getInt("Q_Window_Screen_S"));
          roomTypeBean.setQWindowScreenL(resultSet.getInt("Q_Window_Screen_L"));
          roomTypeBean.setQWindowScreenG(resultSet.getInt("Q_Window_Screen_G"));
          roomTypeBean.setQWardrobe(resultSet.getInt("Q_Wardrobe"));
          roomTypeBean.setQChair(resultSet.getInt("Q_Chair"));

          roomTypeBean.setPTV(resultSet.getInt("Q_TV"));
          roomTypeBean.setPRefrigerator(resultSet.getInt("P_Refrigerator"));
          roomTypeBean.setPAirCondition(resultSet.getInt("P_AirCondition"));
          roomTypeBean.setPHeater(resultSet.getInt("P_Heater"));
          roomTypeBean.setPMirror(resultSet.getInt("P_Mirror"));
          roomTypeBean.setPFlowTable(resultSet.getInt("P_Flow_Table"));
          roomTypeBean.setPSideTableS(resultSet.getInt("P_Side_Table_S"));
          roomTypeBean.setPSideTableL(resultSet.getInt("P_Side_Table_L"));
          roomTypeBean.setPBedBoardS(resultSet.getInt("P_Bed_Board_S"));
          roomTypeBean.setPBedBoardL(resultSet.getInt("P_Bed_Board_S"));
          roomTypeBean.setPDeskS(resultSet.getInt("P_Desk_S"));
          roomTypeBean.setPDeskL(resultSet.getInt("P_Desk_L"));
          roomTypeBean.setPBedS(resultSet.getInt("P_Bed_S"));
          roomTypeBean.setPBedL(resultSet.getInt("P_Bed_L"));
          roomTypeBean.setPWindowScreenS(resultSet.getInt("P_Window_Screen_S"));
          roomTypeBean.setPWindowScreenL(resultSet.getInt("P_Window_Screen_L"));
          roomTypeBean.setPWindowScreenG(resultSet.getInt("P_Window_Screen_G"));
          roomTypeBean.setPWardrobe(resultSet.getInt("P_Wardrobe"));
          roomTypeBean.setPChair(resultSet.getInt("P_Chair"));
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("RoomTypeDaoImpl_JDBC類別#queryRoomType()發生例外: " + ex.getMessage());
    }
    return roomTypeBean;
  }

  @Override
  public RoomTypeBean updateRoomTypeInfo(String type) {
    return null;
  }
}
