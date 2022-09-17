package tw.edu.ntut.sce.java18.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.dao.RepairFormDao;
import tw.edu.ntut.sce.java18.common.model.RepairFormBean;
import tw.edu.ntut.sce.java18.common.utils.DBService;

public class RepairFormDaoImpl_JDBC implements RepairFormDao {
  private DataSource ds = null;

  public RepairFormDaoImpl_JDBC() {
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("RepairFormDaoImpl_JDBC類別#建構子發生例外: " + ex.getMessage());
    }
  }

  @Override
  public List<RepairFormBean> getRepairFormListByApplicant(int memberid) {
    List<RepairFormBean> repairFormList = new ArrayList<>();
    // 99為隱藏
    String sql =
        " SELECT * FROM (SELECT* FROM FIX WHERE Member_ID=? AND STATUS!=99) AS TableA "
            + " JOIN furniture_price AS TableB ON TableB.id=TableA.Project ";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, memberid);
      try (ResultSet rs = ps.executeQuery(); ) {
        while (rs.next()) {
          RepairFormBean repairForm = new RepairFormBean();
          repairForm.setId(rs.getInt("id"));
          repairForm.setFormNumber(rs.getString("Form_Number"));
          repairForm.setRoomNumber(rs.getString("Room_Number"));
          repairForm.setMemberId(rs.getInt("Member_ID"));
          repairForm.setApplicant(rs.getString("Applicant"));
          repairForm.setPhone(rs.getString("Phone"));
          repairForm.setCreatTime(rs.getTimestamp("CREATE_Time"));
          repairForm.setExpectionTime(rs.getTimestamp("Expection_Time"));
          repairForm.setFixTime(rs.getTimestamp("Fix_Time"));
          repairForm.setFinishTime(rs.getTimestamp("Finish_Time"));
          repairForm.setProject(rs.getInt("Project"));
          repairForm.setNote(rs.getString("Note"));
          repairForm.setStatus(rs.getInt("Status"));
          repairForm.setAmount(rs.getInt("Amount"));
          repairForm.setProjectName(rs.getString("Name"));
          repairForm.setProjectPrice(rs.getInt("Price"));
          repairForm.setProjectNameAlias(rs.getString("alias_name"));
          repairFormList.add(repairForm);
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "RepairFormDaoImpl_JDBC類別#getRepairFormListByApplicant()發生例外: " + ex.getMessage());
    }
    return repairFormList;
  }

  @Override
  public int checkRepairFormAmount(int memberid, String beginTime, String endTime) {
    String sql =
        " SELECT COUNT(*) FROM fix WHERE Member_ID =? AND create_time "
            + " BETWEEN \" "
            + beginTime
            + " 00:00:00\" AND \" "
            + endTime
            + " 23:59:59\" ";
    System.out.println(sql);
    int n = -1;
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, memberid);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          n = rs.getInt(1);
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "RepairFormDaoImpl_JDBC類別#checkRepairFormAmount()發生例外: " + ex.getMessage());
    }
    return n;
  }

  @Override
  public int saveRepairForm(RepairFormBean repairFormBean) {
    //    String sql =
    //        "INSERT INTO FIX ( Form_Number, Room_Number, Member_ID, Applicant, Phone, CREATE_Time,
    // "
    //            + "Expection_Time, Fix_Time, Finish_Time, Project, Note, Status, Amount)"
    //            + " values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    String sql =
        "INSERT INTO FIX ( Form_Number, Room_Number, Member_ID, Applicant, Phone, CREATE_Time, "
            + "Expection_Time, Project, Note, Status)"
            + " values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    int n = -1;
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setString(1, repairFormBean.getFormNumber());
      ps.setString(2, repairFormBean.getRoomNumber());
      ps.setInt(3, repairFormBean.getMemberId());
      ps.setString(4, repairFormBean.getApplicant());
      ps.setString(5, repairFormBean.getPhone());
      ps.setTimestamp(6, repairFormBean.getCreatTime());
      ps.setTimestamp(7, repairFormBean.getExpectionTime());
      // ps.setTimestamp(8, repairFormBean.getFixTime());
      // ps.setTimestamp(9, repairFormBean.getFinishTime());
      ps.setInt(8, repairFormBean.getProject());
      ps.setString(9, repairFormBean.getNote());
      ps.setInt(10, repairFormBean.getStatus());
      // ps.setInt(11, repairFormBean.getAmount());
      n = ps.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "RepairFormDaoImpl_JDBC類別#saveRepairForm()發生例外: " + ex.getMessage());
    }
    return n;
  }

  @Override
  public int updateRepairForm(RepairFormBean repairFormBean) {
    String sql =
        " UPDATE FIX SET Applicant = ?, Phone = ?, "
            + "Expection_Time=?, Project=?, "
            + " Note = ? "
            + " WHERE Form_Number = ?"; // 8
    int n = -1;
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setString(1, repairFormBean.getApplicant());
      ps.setString(2, repairFormBean.getPhone());
      ps.setTimestamp(3, repairFormBean.getExpectionTime());
      ps.setInt(4, repairFormBean.getProject());
      ps.setString(5, repairFormBean.getNote());
      // ps.setInt(6, repairFormBean.getStatus());
      // ps.setInt(7, repairFormBean.getAmount());
      ps.setString(6, repairFormBean.getFormNumber());
      n = ps.executeUpdate();

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "RepairFormDaoImpl_JDBC類別#updateRepairForm()發生例外: " + ex.getMessage());
    }

    return n;
  }

  @Override
  public int deleteRepairForm(String formNumber) {
    String sql = " UPDATE FIX SET Status = 99 " + " WHERE Form_Number = ?";
    int n = -1;
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setString(1, formNumber);
      n = ps.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "RepairFormDaoImpl_JDBC類別#deleteRepairForm()發生例外: " + ex.getMessage());
    }

    return n;
  }
}
