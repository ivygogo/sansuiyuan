package tw.edu.ntut.sce.java18.common.dao;

import java.util.ArrayList;
import tw.edu.ntut.sce.java18.common.model.ChatMessageBean;
import tw.edu.ntut.sce.java18.common.model.ChatMessageServiceBean;

public interface ChatMessageDao {
  void insertMessage(ChatMessageServiceBean message);

  ArrayList<ChatMessageBean> queryHistoryMessage(int chatroomId);

  ChatMessageBean queryLastMessage(int chatroomId);

  int queryUnreadCount(int roomId, int user);

  int queryAllUnreadCount(int user);

  void updateUnReadStatus(int roomId, int user);
}
