package tw.edu.ntut.sce.java18.common.dao;

import java.util.ArrayList;
import tw.edu.ntut.sce.java18.common.dao.impl.ChatroomDaoImpl_JDBC.ExistChatroomBean;

public interface ChatroomDao {

  void insertChatroom(String type, int member1, int member2, String createTime, String closeTime);

  String queryChatroomNameById(int chatroomId);

  int queryIdByChatroomName(String chatroomName, String chatroomType);

  int queryIdByChatroomName(String chatroomName);

  ArrayList<ExistChatroomBean> queryExistChatroomByUser(int member);

  void updateCloseTime(int roomId, int time);
}
