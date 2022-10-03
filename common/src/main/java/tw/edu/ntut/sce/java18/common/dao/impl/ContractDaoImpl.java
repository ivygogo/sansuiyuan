package tw.edu.ntut.sce.java18.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.dao.ContractDao;
import tw.edu.ntut.sce.java18.common.model.ContractBean;
import tw.edu.ntut.sce.java18.common.model.ContractStatusBean;
import tw.edu.ntut.sce.java18.common.utils.DBService;

public class ContractDaoImpl implements ContractDao {
  private DataSource ds = null;

  public ContractDaoImpl() {
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("ContractDaoImpl類別#建構子發生例外: " + ex.getMessage());
    }
  }

  private static final String INSERT =
      "insert into Tenant "
          + " ( Member_Id, Contract_Number, Begin_Time, End_Time, Room_Number, Deposit ) "
          + " values ( ?, ?, ?, ?, ?, ? ) ";

  private static final String INSERTContract =
      "insert into Contract "
          + " ( Status, Name, Room_Number, Room_Type, Payment_Status, "
          + " Check_Fee, Check_Status, PDF, Signed_Date, Deposit, Hide, MemberID ) "
          + " values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";

  @Override
  public ContractBean insertTenant(ContractBean contract) throws SQLException {
    ContractBean result = null;
    try (Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement(INSERT)) {
      ps.setInt(1, contract.getMember_Id());
      ps.setString(2, contract.getContract_Number());
      ps.setDate(3, contract.getBegin_Time());
      ps.setDate(4, contract.getEnd_Time());
      ps.setString(5, contract.getRoom_Number());
      ps.setInt(6, contract.getDeposit());
      ps.executeUpdate();

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("ContractDaoImpl類別#insertTenant()發生例外: " + ex.getMessage());
    }
    return result;
  }

  @Override
  public ContractStatusBean insertContract(ContractStatusBean contractStatus) throws SQLException {
    ContractStatusBean contractresult = null;
    try (Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement(INSERTContract)) {

      ps.setString(1, contractStatus.getStatus());
      ps.setString(2, contractStatus.getName());
      ps.setString(3, contractStatus.getRoomNumber());
      ps.setString(4, contractStatus.getRoomType());
      ps.setString(5, contractStatus.getPaymentStatus());
      ps.setString(6, contractStatus.getCheckFee());
      ps.setString(7, contractStatus.getCheckStatus());
      ps.setString(8, contractStatus.getPdf());
      ps.setString(9, contractStatus.getSignedDate());
      ps.setString(10, contractStatus.getDeposit());
      ps.setInt(11, contractStatus.getHide());
      ps.setInt(12, contractStatus.getMemberId());
      ps.executeUpdate();

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("ContractDaoImpl類別#insertContract()發生例外: " + ex.getMessage());
    }
    return contractresult;
  }
}
