package tw.edu.ntut.sce.java18.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.dao.ContractDao;
import tw.edu.ntut.sce.java18.common.model.ContractBean;
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
}
