package tw.edu.ntut.sce.java18.tenant.memberInfo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.dao.RefundAccountDao;
import tw.edu.ntut.sce.java18.common.model.RefundAccountBean;
import tw.edu.ntut.sce.java18.common.utils.DBService;

public class RefundAccountDaoImpl implements RefundAccountDao {
  private DataSource ds = null;
  private Connection conn = null;

  public RefundAccountDaoImpl() {
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("RefundAccountDaoImpl類別#建構子發生例外: " + ex.getMessage());
    }
  }

  /*======查詢退款帳號ID是否存在======*/
  @Override
  public boolean idExists(int uId) {
    boolean exist = false;
    String sql = "SELECT * FROM Refund_Account WHERE ID = ?";
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
      throw new RuntimeException("RefundAccountDaoImpl類別#idExists()發生例外: " + ex.getMessage());
    }
    return exist;
  }

  /*======儲存退款帳號等資料======*/
  @Override
  public int saveRefundAccount(RefundAccountBean rab) {
    String sql =
        " insert into Guarantor "
            + " (member_id, refundBank, bankStore, phone, refundName, create_time, update_time) "
            + " values(?, ?, ?, ?, ?, ?, ?) ";
    int n = 0;
    try (Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, rab.getMember_id());
      ps.setString(2, rab.getRefundBank());
      ps.setString(3, rab.getBankStore());
      ps.setString(4, rab.getPhone());
      ps.setString(5, rab.getRefundName());
      ps.setTimestamp(7, rab.getCreate_time());
      ps.setTimestamp(8, rab.getUpdate_time());
      n = ps.executeUpdate();

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("RefundAccountDaoImpl類別#saveCf()發生例外: " + ex.getMessage());
    }
    return n;
  }

  /*======查詢退款帳號資料======*/
  @Override
  public RefundAccountBean queryRefundAccountId(int uId) {
    RefundAccountBean rab = null;
    String sql = "SELECT * FROM Refund_Account WHERE ID = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, uId);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          rab = new RefundAccountBean();
          rab.setuId(rs.getInt("uId"));
          rab.setMember_id(rs.getInt("Member_id"));
          rab.setRefundBank(rs.getString("refundBank"));
          rab.setBankStore(rs.getString("bankStore"));
          rab.setPhone(rs.getString("phone"));
          rab.setRefundName(rs.getString("refundName"));
          rab.setCreate_time(rs.getTimestamp("setCreate_time"));
          rab.setUpdate_time(rs.getTimestamp("update_time"));
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "RefundAccountDaoImpl類別#queryGuarantorId()發生例外: " + ex.getMessage());
    }
    return rab;
  }

  @Override
  public RefundAccountBean getRefundAccount(int Member_Id) {
    RefundAccountBean rab = null;
    String sql = "SELECT * FROM Refund_Account WHERE Member_Id = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, Member_Id);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          rab = new RefundAccountBean();
          rab.setuId(rs.getInt("uId"));
          rab.setMember_id(rs.getInt("Member_id"));
          rab.setRefundBank(rs.getString("refundBank"));
          rab.setBankStore(rs.getString("bankStore"));
          rab.setPhone(rs.getString("phone"));
          rab.setRefundName(rs.getString("refundName"));
          rab.setCreate_time(rs.getTimestamp("setCreate_time"));
          rab.setUpdate_time(rs.getTimestamp("update_time"));
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "RefundAccountDaoImpl類別#queryGuarantorId()發生例外: " + ex.getMessage());
    }
    return rab;
  }

  @Override
  public void setConnection(Connection con) {
    this.conn = con;
  }
}
