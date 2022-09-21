package tw.edu.ntut.sce.java18.common.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import tw.edu.ntut.sce.java18.common.model.MemberBean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRowMapper implements RowMapper<MemberBean> {

  @Override
  public MemberBean mapRow(ResultSet resultSet, int i) throws SQLException {
    MemberBean memberBean = new MemberBean();
    memberBean.setuId(resultSet.getInt("UId"));
    memberBean.setName(resultSet.getString("Name"));
    memberBean.setGender(resultSet.getInt("Gender"));
    memberBean.setPhone(resultSet.getString("Phone"));
    memberBean.setIdNumber(resultSet.getString("Id_Number"));
    memberBean.setMail(resultSet.getString("Mail"));
    memberBean.setPassword(resultSet.getString("Password"));
    memberBean.setAddress(resultSet.getString("Address"));
    memberBean.setNickname(resultSet.getString("Nickname"));


    return memberBean;
  }
}
