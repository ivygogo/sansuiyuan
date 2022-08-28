package tw.edu.ntut.sce.java18.tenant.memberInfo.dao;

import tw.edu.ntut.sce.java18.common.model.MemberBean;

public interface MemberDao {

  boolean checkMemberAccountExists(String mail);

  int saveMember(MemberBean mb);

  MemberBean queryMemberByPrimaryKey(int uId); // 此uId不是帳號，而是PK

  boolean checkMemberUidExists(int uId); // 此uId不是帳號，而是PK

  String checkIdNumber(String formValue, int genderId);

  int updateMemberInfo(MemberBean member);
}
