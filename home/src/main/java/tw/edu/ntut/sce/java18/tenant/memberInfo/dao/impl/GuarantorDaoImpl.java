package tw.edu.ntut.sce.java18.tenant.memberInfo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.model.GuarantorBean;
import tw.edu.ntut.sce.java18.common.utils.DBService;
import tw.edu.ntut.sce.java18.tenant.memberInfo.dao.GuarantorDao;

public class GuarantorDaoImpl implements GuarantorDao {
  private DataSource ds = null;

  public GuarantorDaoImpl() {
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("GuarantorDaoImpl類別#建構子發生例外: " + ex.getMessage());
    }
  }

  /*======查詢保證人ID是否存在======*/
  @Override
  public boolean checkGuarantorIdExists(int memberId) {
    boolean exist = false;
    String sql = "SELECT * FROM Guarantor WHERE MEMBER_ID = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, memberId);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          exist = true;
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("GuarantorDaoImpl類別#idExists()發生例外: " + ex.getMessage());
    }
    return exist;
  }

  /*======儲存保證人等資料======*/
  @Override
  public int saveGuarantor(GuarantorBean guarantor) {
    String sql =
        " insert into Guarantor  (member_id, NAME, id_number, phone, county, District, address,"
            + " relation, create_time, update_time)  values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    int n = 0;
    try (Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, guarantor.getMember_id());
      ps.setString(2, guarantor.getName());
      ps.setString(3, guarantor.getId_number());
      ps.setString(4, guarantor.getPhone());
      ps.setString(5, guarantor.getCounty());
      ps.setString(6, guarantor.getDistrict());
      ps.setString(7, guarantor.getAddress());
      ps.setString(8, guarantor.getRelation());
      ps.setTimestamp(9, guarantor.getCreate_time());
      ps.setTimestamp(10, guarantor.getUpdate_time());
      n = ps.executeUpdate();

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("GuarantorDaoImpl類別#saveCf()發生例外: " + ex.getMessage());
    }
    return n;
  }

  /*======查詢保證人等資料======*/
  @Override
  public GuarantorBean queryGuarantorByPrimaryKey(int id) {
    GuarantorBean gb = null;
    String sql = "SELECT * FROM Guarantor WHERE ID = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, id);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          gb = new GuarantorBean();
          gb.setId(rs.getInt("Id"));
          gb.setMember_id(rs.getInt("Member_id"));
          gb.setName(rs.getString("name"));
          gb.setId_number(rs.getString("id_number"));
          gb.setPhone(rs.getString("phone"));
          gb.setCounty(rs.getString("county"));
          gb.setDistrict(rs.getString("district"));
          gb.setAddress(rs.getString("address"));
          gb.setRelation(rs.getString("relation"));
          gb.setCreate_time(rs.getTimestamp("Create_time"));
          gb.setUpdate_time(rs.getTimestamp("update_time"));
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("GuarantorDaoImpl類別#queryGuarantorId()發生例外: " + ex.getMessage());
    }
    return gb;
  }

  @Override
  public GuarantorBean queryGuarantorByMemberId(int memberId) {
    GuarantorBean gb = null;
    String sql = "SELECT * FROM Guarantor WHERE Member_ID = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, memberId);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          gb = new GuarantorBean();
          gb.setId(rs.getInt("Id"));
          gb.setMember_id(rs.getInt("Member_id"));
          gb.setName(rs.getString("name"));
          gb.setId_number(rs.getString("id_number"));
          gb.setPhone(rs.getString("phone"));
          gb.setCounty(rs.getString("county"));
          gb.setDistrict(rs.getString("district"));
          gb.setAddress(rs.getString("address"));
          gb.setRelation(rs.getString("relation"));
          gb.setCreate_time(rs.getTimestamp("Create_time"));
          gb.setUpdate_time(rs.getTimestamp("update_time"));
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("GuarantorDaoImpl類別#queryGuarantorId()發生例外: " + ex.getMessage());
    }
    return gb;
  }

  /*======取得保證人等資料======*/
  @Override
  public List<GuarantorBean> getGuarantorInfo(int memberId) {
    List<GuarantorBean> guarantorList = new ArrayList<>();
    GuarantorBean gb = null;

    String sql = " SELECT * FROM Guarantor WHERE MEMBER_ID = ? ";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, memberId);
      try (ResultSet rs = ps.executeQuery(); ) {
        while (rs.next()) {
          gb = new GuarantorBean();
          gb.setId(rs.getInt("id"));
          gb.setMember_id(rs.getInt("Member_id"));
          gb.setName(rs.getString("name"));
          gb.setId_number(rs.getString("id_number"));
          gb.setPhone(rs.getString("phone"));
          gb.setCounty(rs.getString("county"));
          gb.setDistrict(rs.getString("district"));
          gb.setAddress(rs.getString("address"));
          gb.setRelation(rs.getString("relation"));
          // gb.setCreate_time(rs.getTimestamp("CREATE_Time"));
          // gb.setUpdate_time(rs.getTimestamp("update_time"));
          guarantorList.add(gb);
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("GuarantorDaoImpl類別#queryGuarantorId()發生例外: " + ex.getMessage());
    }
    System.out.println("queryGuarantorId: " + guarantorList.size());
    return guarantorList;
  }

  @Override
  public int updateGuarantorInfo(GuarantorBean guarantor) {
    int n = 0;
    String sql =
        "UPDATE GUARANTOR SET "
            + " name=?,  id_number=?, phone=?,  COUNTY=?, "
            + " DISTRICT=?, ADDRESS=?  ,RELATION=?,  update_time=? WHERE ID = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql); ) {
      ps.clearParameters();
      ps.setString(1, guarantor.getName());
      ps.setString(2, guarantor.getId_number());
      ps.setString(3, guarantor.getPhone());
      ps.setString(4, guarantor.getCounty());
      ps.setString(5, guarantor.getDistrict());
      ps.setString(6, guarantor.getAddress());
      ps.setString(7, guarantor.getRelation());
      ps.setTimestamp(8, guarantor.getUpdate_time());
      ps.setInt(9, guarantor.getId());
      System.out.println("GuarantorDaoImpl#updateGuarantorInfo" + guarantor.getId());
      n = ps.executeUpdate();

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "GuarantorDaoImpl#updateGuarantorInfo(GuarantorBean)發生例外: " + ex.getMessage());
    }

    return n;
  }
}
