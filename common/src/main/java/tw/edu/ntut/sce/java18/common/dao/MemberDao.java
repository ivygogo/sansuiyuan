package tw.edu.ntut.sce.java18.common.dao;

import java.sql.Connection;
import tw.edu.ntut.sce.java18.common.model.MemberBean;

public interface MemberDao {

  boolean idExists(String mail);

  int saveMember(MemberBean mb);

  MemberBean queryMemberId(int uId); // 此uId不是帳號，而是PK

  boolean uIdExists(int uId); // 此uId不是帳號，而是PK

  MemberBean getMemberInfo(int uId);

  String checkIdNumber(String formValue, int genderId);

  void setConnection(Connection con);

  int updateMemberInfo(MemberBean bean);
}
