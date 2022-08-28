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
import tw.edu.ntut.sce.java18.common.model.TenantBean;
import tw.edu.ntut.sce.java18.common.utils.DBService;
import tw.edu.ntut.sce.java18.tenant.memberInfo.dao.TenantDao;

public class TenantDaoImpl implements TenantDao {
  private DataSource ds = null;

  public TenantDaoImpl() {
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("TenantDaoImpl類別#建構子發生例外: " + ex.getMessage());
    }
  }

  /*======以Member_Id判斷租約是否存在======*/
  @Override
  public boolean checkTenantIdExists(int memberId) {
    boolean exist = false;
    String sql = "SELECT * FROM Tenant WHERE Member_Id = ?";
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
      throw new RuntimeException("TenantDaoImpl類別#idExists()發生例外: " + ex.getMessage());
    }
    return exist;
  }

  /*======儲存合約資料======*/
  @Override
  public int saveTenant(TenantBean tenant) {
    String sql =
        " insert into Tenant "
            + " (Member_Id, Contract_Number, Begin_Time, End_Time, Room_Number, Deposit) "
            + " values(?, ?, ?, ?, ?, ?) ";
    int n = 0;
    try (Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, tenant.getMember_Id());
      ps.setString(2, tenant.getContract_Number());
      ps.setDate(3, tenant.getBegin_Time());
      ps.setDate(4, tenant.getEnd_Time());
      ps.setString(5, tenant.getRoom_Number());
      ps.setInt(6, tenant.getDeposit());

      n = ps.executeUpdate();

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("TenantDaoImpl類別#saveTenant()發生例外: " + ex.getMessage());
    }
    return n;
  }

  /*======查詢合約資料======*/
  @Override
  public TenantBean queryTenantByMemberId(int memberId) {
    TenantBean tb = null;
    String sql = "SELECT * FROM Tenant WHERE Member_Id = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, memberId);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          tb = new TenantBean();
          tb.setId(rs.getInt("Id"));
          tb.setMember_Id(rs.getInt("Member_Id"));
          tb.setContract_Number(rs.getString("Contract_Number"));
          tb.setBegin_Time(rs.getDate("begin_Time"));
          tb.setEnd_Time(rs.getDate("end_Time"));
          tb.setRoom_Number(rs.getString("room_Number"));
          tb.setDeposit(rs.getInt("deposit"));
        }
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("TenantDaoImpl類別#queryTenant()發生例外: " + ex.getMessage());
    }
    return tb;
  }

  @Override
  public List<TenantBean> getContractInfo(int memberId) {
    DataSource ds = null;
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("TenantDaoImpl類別#getContractInfo()發生例外: " + ex.getMessage());
    }

    TenantBean tb = null;
    List<TenantBean> tenantList = new ArrayList<>();
    String sql = "SELECT * FROM Tenant where member_Id = ? Order by Begin_time desc ";

    try (Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement(sql); ) {
      ps.setInt(1, memberId);
      try (ResultSet rs = ps.executeQuery(); ) {
        while (rs.next()) {
          tb = new TenantBean();
          tb.setId(rs.getInt("ID"));
          tb.setMember_Id(rs.getInt("Member_Id"));
          tb.setContract_Number(rs.getString("Contract_Number"));
          tb.setBegin_Time(rs.getDate("begin_Time"));
          tb.setEnd_Time(rs.getDate("end_Time"));
          tb.setRoom_Number(rs.getString("room_Number"));
          tb.setDeposit(rs.getInt("deposit"));
          tenantList.add(tb);
        }
      }
    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }
    return tenantList;
  }
}
