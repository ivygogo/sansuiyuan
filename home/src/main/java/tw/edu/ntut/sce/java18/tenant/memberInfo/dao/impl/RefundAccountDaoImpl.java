package tw.edu.ntut.sce.java18.tenant.memberInfo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.model.RefundAccountBean;
import tw.edu.ntut.sce.java18.common.utils.DBService;
import tw.edu.ntut.sce.java18.tenant.memberInfo.dao.RefundAccountDao;

public class RefundAccountDaoImpl implements RefundAccountDao {
  private DataSource ds = null;

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
  public boolean checkRefundAccountIdExists(int id) {
    boolean exist = false;
    String sql = "SELECT * FROM Refund_Account WHERE ID = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, id);
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

  /*======查詢退款帳號ID是否存在======*/
  @Override
  public boolean checkRefundAccountIdExistsByMemberId(int memberId) {
    boolean exist = false;
    String sql = "SELECT * FROM Refund_Account WHERE Member_Id = ?";
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
      throw new RuntimeException("RefundAccountDaoImpl類別#idExists()發生例外: " + ex.getMessage());
    }
    return exist;
  }

  /*======儲存退款帳號等資料======*/
  @Override
  public int saveRefundAccount(RefundAccountBean refundAccount) {
    String sql =
        " insert into Refund_Account  (member_id, refundBank, bankStore, BANKACCOUNT, refundName,"
            + " createtime, updatetime)  values(?, ?, ?, ?, ?, ?, ?) ";
    int n = 0;
    try (Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, refundAccount.getMember_id());
      ps.setString(2, refundAccount.getRefundBank());
      ps.setString(3, refundAccount.getBankStore());
      ps.setString(4, refundAccount.getBankAccount());
      ps.setString(5, refundAccount.getRefundName());
      ps.setTimestamp(6, refundAccount.getCreate_time());
      ps.setTimestamp(7, refundAccount.getUpdate_time());
      n = ps.executeUpdate();

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("RefundAccountDaoImpl類別#saveCf()發生例外: " + ex.getMessage());
    }
    return n;
  }

  /*======查詢退款帳號資料======*/
  @Override
  public RefundAccountBean queryRefundAccountByPrimaryKey(int id) {
    RefundAccountBean rab = null;
    String sql = "SELECT * FROM Refund_Account WHERE ID = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, id);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          rab = new RefundAccountBean();
          rab.setId(rs.getInt("id"));
          rab.setMember_id(rs.getInt("Member_id"));
          rab.setRefundBank(rs.getString("refundBank"));
          rab.setBankStore(rs.getString("bankStore"));
          rab.setBankAccount(rs.getString("bankAccount"));
          rab.setRefundName(rs.getString("refundName"));
          rab.setCreate_time(rs.getTimestamp("Createtime"));
          rab.setUpdate_time(rs.getTimestamp("updatetime"));
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "RefundAccountDaoImpl類別#queryRefundAccountId()發生例外: " + ex.getMessage());
    }
    return rab;
  }

  @Override
  public RefundAccountBean queryRefundAccountByMemberId(int memberId) {
    RefundAccountBean refundAccount = null;
    String sql = "SELECT * FROM Refund_Account WHERE Member_Id = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, memberId);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          refundAccount = new RefundAccountBean();
          refundAccount.setId(rs.getInt("id"));
          refundAccount.setMember_id(rs.getInt("Member_id"));
          refundAccount.setRefundBank(rs.getString("refundBank"));
          refundAccount.setBankStore(rs.getString("bankStore"));
          refundAccount.setBankAccount(rs.getString("bankAccount"));
          refundAccount.setRefundName(rs.getString("refundName"));
          refundAccount.setCreate_time(rs.getTimestamp("Createtime"));
          refundAccount.setUpdate_time(rs.getTimestamp("Updatetime"));
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "RefundAccountDaoImpl類別#RefundAccountBean()發生例外: " + ex.getMessage());
    }
    return refundAccount;
  }

  @Override
  public int updateRefundAccount(RefundAccountBean refundAccountBean) {
    int n = 0;
    String sql =
        "UPDATE REFUND_ACCOUNT SET "
            + " RefundBank=?,  BankStore=?, BankAccount=?,  RefundName=?, "
            + " UPDATETIME=? WHERE Member_id = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql); ) {
      ps.clearParameters();
      ps.setString(1, refundAccountBean.getRefundBank());
      ps.setString(2, refundAccountBean.getBankStore());
      ps.setString(3, refundAccountBean.getBankAccount());
      ps.setString(4, refundAccountBean.getRefundName());
      ps.setTimestamp(5, refundAccountBean.getUpdate_time());
      ps.setInt(6, refundAccountBean.getMember_id());
      System.out.println("RefundAccountDaoImpl#updateGuarantorInfo" + refundAccountBean.getId());
      n = ps.executeUpdate();

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "RefundAccountDaoImpl#updateGuarantorInfo(GuarantorBean)發生例外: " + ex.getMessage());
    }

    return n;
  }
}
