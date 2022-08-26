package tw.edu.ntut.sce.java18.tenant.memberInfo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.dao.GuarantorDao;
import tw.edu.ntut.sce.java18.common.model.GuarantorBean;
import tw.edu.ntut.sce.java18.common.utils.DBService;

public class GuarantorDaoImpl implements GuarantorDao {
  private DataSource ds = null;
  private Connection conn = null;

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
  public boolean uIdExists(int uId) {
    boolean exist = false;
    String sql = "SELECT * FROM Guarantor WHERE ID = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, uId);
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
  public int saveGuarantor(GuarantorBean gb) {
    String sql =
        " insert into Guarantor "
            + " (member_id, NAME, id_number, phone, address, relation, create_time, update_time) "
            + " values(?, ?, ?, ?, ?, ?, ?, ?) ";
    int n = 0;
    try (Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, gb.getMember_id());
      ps.setString(2, gb.getName());
      ps.setString(3, gb.getId_number());
      ps.setString(4, gb.getPhone());
      ps.setString(5, gb.getAddress());
      ps.setString(6, gb.getRelation());
      ps.setTimestamp(7, gb.getCreate_time());
      ps.setTimestamp(8, gb.getUpdate_time());
      n = ps.executeUpdate();

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("GuarantorDaoImpl類別#saveCf()發生例外: " + ex.getMessage());
    }
    return n;
  }

  /*======查詢保證人等資料======*/
  @Override
  public GuarantorBean queryGuarantorId(int uId) {
    GuarantorBean gb = null;
    String sql = "SELECT * FROM Guarantor WHERE ID = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, uId);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          gb = new GuarantorBean();
          gb.setuId(rs.getInt("uId"));
          gb.setMember_id(rs.getInt("Member_id"));
          gb.setName(rs.getString("name"));
          gb.setId_number(rs.getString("id_number"));
          gb.setPhone(rs.getString("phone"));
          gb.setAddress(rs.getString("address"));
          gb.setRelation(rs.getString("relation"));
          gb.setCreate_time(rs.getTimestamp("setCreate_time"));
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
  public GuarantorBean getGuarantorInfo(int member_id) {
    GuarantorBean gb = null;
    String sql = "SELECT * FROM Guarantor WHERE ID = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, member_id);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          gb = new GuarantorBean();
          gb.setuId(rs.getInt("uId"));
          gb.setMember_id(rs.getInt("Member_id"));
          gb.setName(rs.getString("name"));
          gb.setId_number(rs.getString("id_number"));
          gb.setPhone(rs.getString("phone"));
          gb.setAddress(rs.getString("address"));
          gb.setRelation(rs.getString("relation"));
          gb.setCreate_time(rs.getTimestamp("setCreate_time"));
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
  public void setConnection(Connection con) {
    this.conn = con;
  }
}
