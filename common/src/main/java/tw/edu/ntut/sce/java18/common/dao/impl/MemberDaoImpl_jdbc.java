package tw.edu.ntut.sce.java18.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import tw.edu.ntut.sce.java18.common.dao.MemberDao;
import tw.edu.ntut.sce.java18.common.dto.MemberRegisterRequest;
import tw.edu.ntut.sce.java18.common.model.MemberBean;
import tw.edu.ntut.sce.java18.common.rowmapper.MemberRowMapper;
import tw.edu.ntut.sce.java18.common.utils.DBService;

@Component
public class MemberDaoImpl_jdbc implements MemberDao {

  private DataSource ds = null;

  @Autowired(required = false)
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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

  /*===確認身分證號是否正確===*/
  @Override
  public String checkIdNumber(String formValue, int genderId) {
    String errMsg = "";
    String idNumber = "";
    int countyCode = -1;
    idNumber = formValue.replaceAll("\\s*", "");
    countyCode = (int) (idNumber.substring(0, 1).toUpperCase().charAt(0));
    List<Integer> code = new ArrayList<>();

    if (idNumber == null || idNumber.trim().length() == 0) {
      errMsg = "必須輸入身分證號";

    } else if (idNumber.length() != 10) {
      errMsg = "身分證號格式錯誤";

    } else if (countyCode < 65 || countyCode > 90) {
      errMsg = "身分證號縣市碼不正確";

    } else if (genderId != Character.getNumericValue(idNumber.charAt(1))) {
      errMsg = "身分證號性別碼不正確";

    } else if (!(idNumber.substring(2)).matches("[0-9]{8}")) {
      errMsg = "身分證號格式不正確";

    } else if (idNumber.length() == 10 && (idNumber.substring(2)).matches("[0-9]{8}")) {

      code.add((int) idNumber.substring(0, 1).toUpperCase().charAt(0));
      // System.out.println((int) idNumber.substring(0, 1).toUpperCase().charAt(0));
      for (int i = 1; i < idNumber.length(); i++) {
        int num =
            (Character.getNumericValue(idNumber.substring(i, (i + 1)).toUpperCase().charAt(0)));
        code.add(num);
      }
      int[] weight = {
        10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 30,
        31, 32, 33
      };
      int firstCode = weight[(code.get(0) - 65)];

      int sum = (firstCode / 10) * 1 + (firstCode % 10) * 9;

      int encode = 8;
      for (int i = 1; i <= (idNumber.length() - 1); i++) {
        sum += code.get(i) * encode;
        // System.out.println("sum" + i + ":" + sum);
        encode--;
      }
      sum += code.get(9);

      if (sum % 10 != 0) {
        errMsg = "身分證號格式不正確";
      } else {
        errMsg = null;
      }
    }
    return errMsg;
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

  // 註冊會員資料
  @Override
  public Integer insertMember(MemberRegisterRequest memberRegisterRequest) {
    String sql = "INSERT INTO member" +
        "(name,gender,phone,Id_Number,mail,password,address,nickname) " +
        "VALUE(:memberName,:memberGender,:memberPhone,:IdNumber,:memberMail,:memberPwd,:memberAdd,:nickName)";

    Map<String,Object> map = new HashMap<>();
    map.put("memberName",memberRegisterRequest.getName());
    map.put("memberGender",memberRegisterRequest.getGender());
    map.put("memberPhone",memberRegisterRequest.getPhone());
    map.put("IdNumber",memberRegisterRequest.getIdNumber());
    map.put("memberMail",memberRegisterRequest.getMail());
    map.put("memberPwd",memberRegisterRequest.getPassword());
    map.put("memberAdd",memberRegisterRequest.getAddress());
    map.put("nickName",memberRegisterRequest.getNickname());

    KeyHolder keyHolder = new GeneratedKeyHolder();
    namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map),keyHolder);

    int memberId = keyHolder.getKey().intValue();

    return memberId;

  }

  @Override
  public MemberBean getMemberByEmail(String mail) {
    String sql = "SELECT UId,name,gender,Id_Number,mail,password,address,nickname FROM member WHERE mail = :mail";

    Map<String,Object> map = new HashMap<>();
    map.put("mail",mail);

    List<MemberBean> memberList = namedParameterJdbcTemplate.query(sql,map,new MemberRowMapper());

    if (memberList.size() > 0 ){
      return memberList.get(0);
    }else {
      return null;
    }

  }


}
