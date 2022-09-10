package tw.edu.ntut.sce.java18.common.dao;

import java.util.ArrayList;

public interface ChatroomDao {

  void insertChatroom(String type, int member1, int member2);

  String queryChatroomNameById(int chatroomId);

  int queryIdByChatroomName(String chatroomName, String chatroomType);

  int queryIdByChatroomName(String chatroomName);

  ArrayList<ArrayList> queryExistChatroomByUser(int member);

  void updateCloseTime(int roomId, int time);
}
