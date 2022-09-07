package tw.edu.ntut.sce.java18.common.dao;

import java.util.ArrayList;

public interface ChatroomDao {

  void insertChatroom(String type, int member1, int member2);

  int queryIdByChatroomName(String chatroomName);

  String queryChatroomNameById(int chatroomId);

  ArrayList<ArrayList> queryExistChatroomByUser(int member);

  void updateCloseTime(int roomId, int time);
}
