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
  public RoomTypeBean queryRoomType(String type) {
    RoomTypeBean roomTypeBean = null;
    String sql = "SELECT * FROM roomtype WHERE type = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, type);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          roomTypeBean = new RoomTypeBean();
          roomTypeBean.setPrice(resultSet.getInt("Price"));
          roomTypeBean.setType(resultSet.getString("Type"));
          roomTypeBean.setBalcony(resultSet.getBoolean("Balcony"));
          //          roomTypeBean.setBed(resultSet.getString("Bed"));
          //          roomTypeBean.setChair(resultSet.getString("Chair"));
          //          roomTypeBean.setDesk(resultSet.getString("Desk"));
          roomTypeBean.setName(resultSet.getString("Name"));
          //          roomTypeBean.setRest(resultSet.getInt("Rest"));
          //          roomTypeBean.setSideTable(resultSet.getString("SideTable"));
          roomTypeBean.setSize(resultSet.getDouble("Size"));
          //          roomTypeBean.setWardrobe(resultSet.getString("Wardrobe"));

          String[] arrPics = {
            resultSet.getString("Pic1"), resultSet.getString("Pic2"), resultSet.getString("Pic3")
          };

          roomTypeBean.setPics(arrPics);
          roomTypeBean.setRest(6);
          roomTypeBean.setBed("雙人床");
          roomTypeBean.setDesk("大桌子");
          roomTypeBean.setChair("椅子*1");
          roomTypeBean.setWardrobe("衣櫃1");
          roomTypeBean.setSideTable("小床頭櫃");
          int[] arrAvailableFloorA = {1, 3, 8};
          roomTypeBean.setAvailableFloors(arrAvailableFloorA);
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("RoomTypeDaoImpl_JDBC類別#queryRoomType()發生例外: " + ex.getMessage());
    }
    return roomTypeBean;
  }
}
