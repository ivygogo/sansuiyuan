package tw.edu.ntut.sce.java18.common.dao;

import java.util.List;
import tw.edu.ntut.sce.java18.common.model.MemberBean;

public interface MemberDao_Hibernate {

  MemberBean queryMemberByUId(Integer uId);

  void updateOpenStage(int userId, Integer openTag);

  List<Integer> queryFindingUIdList();
}
