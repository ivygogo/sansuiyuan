package tw.edu.ntut.sce.java18.common.service.impl;

import tw.edu.ntut.sce.java18.common.dao.MemberDao;
import tw.edu.ntut.sce.java18.common.dao.impl.MemberDaoImpl_jdbc;
import tw.edu.ntut.sce.java18.common.model.MemberBean;
import tw.edu.ntut.sce.java18.common.service.MemberService;

public class MemberServiceImpl implements MemberService {
  MemberDao dao;

  public MemberServiceImpl() {
    this.dao = new MemberDaoImpl_jdbc();
  }

  @Override
  public boolean mailExists(String mail) {
    return dao.mailExists(mail);
  }

  @Override
  public int saveMember(MemberBean mb) {
    return dao.saveMember(mb);
  }
}
