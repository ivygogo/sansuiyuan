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
  public List<RepairFormBean> getReparFormListByApplicant(int memberid) {
    List<RepairFormBean> repairFormList = new ArrayList<>();

    String sql =
        " SELECT * FROM (SELECT* FROM FIX WHERE APPLICANT=? AND STATUS!=99) AS TableA "
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
          repairForm.setApplicant(rs.getInt("Applicant"));
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
      throw new RuntimeException("GuarantorDaoImpl類別#queryGuarantorId()發生例外: " + ex.getMessage());
    }
    return repairFormList;
  }
}
