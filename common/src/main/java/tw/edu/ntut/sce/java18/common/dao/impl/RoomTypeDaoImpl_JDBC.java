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

          roomTypeBean.setTV(resultSet.getInt("TV"));
          roomTypeBean.setRefrigerator(resultSet.getInt("Refrigerator"));
          roomTypeBean.setAirCondition(resultSet.getInt("AirCondition"));
          roomTypeBean.setHeater(resultSet.getInt("Heater"));
          roomTypeBean.setMirror(resultSet.getInt("Mirror"));
          roomTypeBean.setFlowTable(resultSet.getInt("Flow_Table"));
          roomTypeBean.setSideTableS(resultSet.getInt("Side_Table_S"));
          roomTypeBean.setSideTableL(resultSet.getInt("Side_Table_L"));
          roomTypeBean.setBedBoardS(resultSet.getInt("Bed_Board_S"));
          roomTypeBean.setBedBoardL(resultSet.getInt("Bed_Board_S"));
          roomTypeBean.setDeskS(resultSet.getInt("Desk_S"));
          roomTypeBean.setDeskL(resultSet.getInt("Desk_L"));
          roomTypeBean.setBedS(resultSet.getInt("Bed_S"));
          roomTypeBean.setBedL(resultSet.getInt("Bed_L"));
          roomTypeBean.setWindowScreenS(resultSet.getInt("Window_Screen_S"));
          roomTypeBean.setWindowScreenL(resultSet.getInt("Window_Screen_L"));
          roomTypeBean.setWindowScreenG(resultSet.getInt("Window_Screen_G"));
          roomTypeBean.setWardrobe(resultSet.getInt("Wardrobe"));
          roomTypeBean.setChair(resultSet.getInt("Chair"));
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("RoomTypeDaoImpl_JDBC類別#queryRoomType()發生例外: " + ex.getMessage());
    }
    return roomTypeBean;
  }

  @Override
  public void updateRoomTypeInfo(RoomTypeBean roomTypeBean) {
    String sql =
        "UPDATE MEMBER SET "
            + " NAME=?,  GENDER=?,  PHONE=?, ID_NUMBER=?,  COUNTY=?, "
            + " DISTRICT=?,  ADDRESS=?,  NICKNAME=?, SCHOOL=?,  PIC=?, "
            + " Signature_1=?,  Signature_2=?,  Signature_3=?, Favor_1=?,  Favor_2=?, "
            + " Favor_3=?,  Open_Tag=?,  Update_Time=?, Last_IP=?  WHERE UID = ?";
  }
}
