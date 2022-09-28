package tw.edu.ntut.sce.java18.common.dao;

import tw.edu.ntut.sce.java18.common.dto.MemberRegisterRequest;
import tw.edu.ntut.sce.java18.common.model.MemberBean;

public interface MemberDao {

  boolean checkMemberAccountExists(String mail);

  int saveMember(MemberBean mb);

  MemberBean queryMemberByPrimaryKey(int uId); // 此uId不是帳號，而是PK

  boolean checkMemberUidExists(int uId); // 此uId不是帳號，而是PK

  String checkIdNumber(String formValue, int genderId);

  int updateMemberInfo(MemberBean member);

  boolean mailExists(String mail);

  MemberBean checkIdPassword(String mail, String password);

  Integer insertMemberS(MemberRegisterRequest memberRegisterRequest); // springboot

  MemberBean getMemberByEmail(String email); // springboot
}
