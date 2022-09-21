package tw.edu.ntut.sce.java18.common.service;

import tw.edu.ntut.sce.java18.common.model.MemberBean;

public interface MemberService {
  boolean mailExists(String mail);

  int saveMember(MemberBean mb);
}
