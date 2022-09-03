package tw.edu.ntut.sce.java18.landlord.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.utils.DBService;
import tw.edu.ntut.sce.java18.landlord.model.LandlordInfo;
import tw.edu.ntut.sce.java18.landlord.model.LandlordInfoDao;

public class LandlordInfoDaoImpl implements LandlordInfoDao {
  private DataSource ds = null;

  public LandlordInfoDaoImpl() {
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("LandlordInfoDaoImpl類別#建構子發生例外: " + ex.getMessage());
    }
  }

  @Override
  public LandlordInfo queryLandlordInfoByPrimaryKey(int id) {
    LandlordInfo landlordInfo = null;
    String sql = "SELECT * FROM property_management WHERE ID = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, id);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          landlordInfo = new LandlordInfo();
          landlordInfo.setId(rs.getInt("id"));
          landlordInfo.setName(rs.getString("name"));
          landlordInfo.setPhone(rs.getString("phone"));
          landlordInfo.setCounty(rs.getString("county"));
          landlordInfo.setDistrict(rs.getString("district"));
          landlordInfo.setAddress(rs.getString("address"));
          landlordInfo.setMail(rs.getString("mail"));
          landlordInfo.setStamp(rs.getString("Stamp"));
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "LandlordInfoDaoImpl類別#queryLandlordInfoByPrimaryKey()發生例外: " + ex.getMessage());
    }
    return landlordInfo;
  }

  @Override
  public int updateLandlordInfo(LandlordInfo landlordInfo) {
    int n = 0;
    String sql =
        "UPDATE PROPERTY_MANAGEMENT SET "
            + " NAME=?,  PHONE=?,  COUNTY=?, "
            + " DISTRICT=?, ADDRESS=?  ,MAIL=?,  STAMP=? WHERE ID = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql); ) {
      ps.clearParameters();
      ps.setString(1, landlordInfo.getName());
      ps.setString(2, landlordInfo.getPhone());
      ps.setString(3, landlordInfo.getCounty());
      ps.setString(4, landlordInfo.getDistrict());
      ps.setString(5, landlordInfo.getAddress());
      ps.setString(6, landlordInfo.getMail());
      ps.setString(7, landlordInfo.getStamp());
      ps.setInt(8, landlordInfo.getId());
      // System.out.println("LandlordInfoDaoImpl#updateLandlordInfo" + landlordInfo.getId());
      n = ps.executeUpdate();

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "LandlordInfoDaoImpl#updateLandlordInfo(LandlordInfo)發生例外: " + ex.getMessage());
    }
    return n;
  }
}
