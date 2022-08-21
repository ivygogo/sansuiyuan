package tw.edu.ntut.sce.java18.tenant.memberInfo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.dao.MemberInfoDao;
import tw.edu.ntut.sce.java18.common.model.MemberInfo;
import tw.edu.ntut.sce.java18.common.utils.DBService;

public class MemberInfoDaoImpl implements MemberInfoDao {
  private DataSource ds = null;
  private Connection conn = null;

  public MemberInfoDaoImpl() {
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("MemberInfoDaoImpl類別#建構子發生例外:" + ex.getMessage());
    }
  }

  @Override
  public boolean idExists(String mail) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int saveMemberInfo(MemberInfo memberinfo) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public MemberInfo queryMemberId(int uId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean uIdExists(int uId) {
    boolean exist = false;
    String sql = "SELECT * FROM Member WHERE UID = ?";

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
      throw new RuntimeException("MemberInfoDaoImpl類別#uIdExists()發生例外:" + ex.getMessage());
    }
    return exist;
  }

  @Override
  public MemberInfo getMemberInfo(int uId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setConnection(Connection con) {
    // TODO Auto-generated method stub

  }
}
