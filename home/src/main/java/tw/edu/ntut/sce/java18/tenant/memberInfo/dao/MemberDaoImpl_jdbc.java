package tw.edu.ntut.sce.java18.tenant.memberInfo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.dao.MemberDao;
import tw.edu.ntut.sce.java18.common.model.MemberBean;
import tw.edu.ntut.sce.java18.common.utils.DBService;

public class MemberDaoImpl_jdbc implements MemberDao {

  private DataSource ds = null;
  private Connection conn = null;

  public MemberDaoImpl_jdbc() {
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("MemberDaoImpl_Jdbc類別#建構子發生例外:" + ex.getMessage());
    }
  }

  @Override
  public boolean idExists(String mail) {
    return false;
  }

  @Override
  public int saveMember(MemberBean mb) {
    // TODO Auto-generated method stub
    return 0;
  }

  /*用UID查詢會員資料用*/
  @Override
  public MemberBean queryMemberId(int uId) {
    MemberBean mb = null;
    String sql = "SELECT * FROM Member WHERE uId = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql); ) {
      ps.setInt(1, uId);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          mb = new MemberBean();
          mb.setuId(rs.getInt("uId"));
          mb.setName(rs.getString("name"));
          mb.setGender(rs.getInt("gender"));
          mb.setPhone(rs.getString("phone"));
          mb.setIdNumber(rs.getString("id_Number"));
          mb.setMail(rs.getString("mail"));
          mb.setPassword(rs.getString("password"));
          mb.setAddress(rs.getString("address"));
          mb.setNickname(rs.getString("nickname"));
          mb.setState(rs.getInt("state"));
          mb.setCode(rs.getString("code"));
          mb.setSchool(rs.getString("school"));
          mb.setPic(rs.getInt("pic"));
          mb.setSignature_1(rs.getInt("signature_1"));
          mb.setSignature_2(rs.getInt("signature_2"));
          mb.setSignature_3(rs.getInt("signature_3"));
          mb.setFavor_1(rs.getInt("favor_1"));
          mb.setFavor_2(rs.getInt("favor_2"));
          mb.setFavor_3(rs.getInt("favor_3"));
          mb.setPair_1(rs.getInt("pair_1"));
          mb.setPair_2(rs.getInt("pair_2"));
          mb.setPair_3(rs.getInt("pair_3"));
          mb.setPair_4(rs.getInt("pair_4"));
          mb.setPair_5(rs.getInt("pair_5"));
          mb.setOpen_tag(rs.getInt("open_tag"));
          mb.setCreate_time(rs.getTimestamp("create_time"));
          mb.setUpdate_time(rs.getTimestamp("update_time"));
          mb.setLast_IP(rs.getString("last_IP"));
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("MemberDaoImpl_Jdbc類別#queryMember()發生例外: " + ex.getMessage());
    }
    return mb;
  }

  /*用UID查詢會員資料用*/
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
      throw new RuntimeException("MemberDaoImpl_Jdbc類別#uIdExists()發生例外:" + ex.getMessage());
    }
    return exist;
  }

  @Override
  public MemberBean getMemberInfo(int uId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setConnection(Connection conn) {
    this.conn = conn;
  }
}
