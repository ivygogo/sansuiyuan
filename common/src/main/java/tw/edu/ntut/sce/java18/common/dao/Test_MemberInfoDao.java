package tw.edu.ntut.sce.java18.common.dao;

import java.sql.Connection;
import tw.edu.ntut.sce.java18.common.model.MemberInfo;

public interface Test_MemberInfoDao {

  boolean idExists(String mail);

  int saveMemberInfo(MemberInfo memberinfo);

  MemberInfo queryMemberId(int uId); // 此uId不是帳號，而是PK

  boolean uIdExists(int uId); // 此uId不是帳號，而是PK

  MemberInfo getMemberInfo(int uId);

  void setConnection(Connection con);
}
