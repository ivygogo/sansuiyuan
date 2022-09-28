package tw.edu.ntut.sce.java18.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.dao.MemberDao;
import tw.edu.ntut.sce.java18.common.model.MemberBean;
import tw.edu.ntut.sce.java18.common.utils.DBService;

public class MemberDaoImpl_jdbc implements MemberDao {

  private DataSource ds = null;

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
  public boolean checkMemberAccountExists(String mail) {
    return false;
  }

  @Override
  public int saveMember(MemberBean mb) {
    // TODO Auto-generated method stub
    return 0;
  }

  /*用UID查詢會員資料用*/
  @Override
  public MemberBean queryMemberByPrimaryKey(int uId) {
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
          mb.setCounty(rs.getString("county"));
          mb.setDistrict(rs.getString("district"));
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
  public boolean checkMemberUidExists(int uId) {
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
  public int updateMemberInfo(MemberBean member) {
    int n = 0;
    String sql =
        "UPDATE MEMBER SET "
            + " NAME=?,  GENDER=?,  PHONE=?, ID_NUMBER=?,  COUNTY=?, "
            + " DISTRICT=?,  ADDRESS=?,  NICKNAME=?, SCHOOL=?,  PIC=?, "
            + " Signature_1=?,  Signature_2=?,  Signature_3=?, Favor_1=?,  Favor_2=?, "
            + " Favor_3=?,  Open_Tag=?,  Update_Time=?, Last_IP=?  WHERE UID = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql); ) {
      ps.clearParameters();
      ps.setString(1, member.getName());
      ps.setInt(2, member.getGender());
      ps.setString(3, member.getPhone());
      ps.setString(4, member.getIdNumber());
      ps.setString(5, member.getCounty());
      ps.setString(6, member.getDistrict());
      ps.setString(7, member.getAddress());
      ps.setString(8, member.getNickname());
      ps.setString(9, member.getSchool());
      ps.setInt(10, member.getPic());

      if (member.getSignature_1() != null) {
        ps.setInt(11, member.getSignature_1());
      } else {
        ps.setNull(11, Types.INTEGER);
      }

      if (member.getSignature_2() != null) {
        ps.setInt(12, member.getSignature_2());
      } else {
        ps.setNull(12, Types.INTEGER);
      }

      if (member.getSignature_3() != null) {
        ps.setInt(13, member.getSignature_3());
      } else {
        ps.setNull(13, Types.INTEGER);
      }

      if (member.getFavor_1() != null) {
        ps.setInt(14, member.getFavor_1());
      } else {
        ps.setNull(14, Types.INTEGER);
      }

      if (member.getFavor_2() != null) {
        ps.setInt(15, member.getFavor_2());
      } else {
        ps.setNull(15, Types.INTEGER);
      }

      if (member.getFavor_3() != null) {
        ps.setInt(16, member.getFavor_3());
      } else {
        ps.setNull(16, Types.INTEGER);
      }

      ps.setInt(17, member.getOpen_tag());
      ps.setTimestamp(18, member.getUpdate_time());
      ps.setString(19, member.getLast_IP());
      ps.setInt(20, member.getuId());

      n = ps.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "MemberDaoImpl_Jdbc()#updateMemberInfo(MemberBean)發生例外: " + ex.getMessage());
    }

    return n;
  }
}
