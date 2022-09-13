package tw.edu.ntut.sce.java18.common.service;

import java.util.ArrayList;
import tw.edu.ntut.sce.java18.common.dao.ChatroomDao;
import tw.edu.ntut.sce.java18.common.dao.impl.ChatroomDaoImpl_JDBC;

public class ChatroomService {
  ChatroomDao dao;

  public ChatroomService() {
    dao = new ChatroomDaoImpl_JDBC();
  }

  public int isExist(int member1, int member2, String chatroomType) {
    return dao.queryIdByChatroomName(member1 + "_" + member2, chatroomType);
  }

  public void createChatroom(String type, int member1, int member2) {
    dao.insertChatroom(type, member1, member2);
  }

  public int getChatroomId(String chatroomName, String chatType) {
    return dao.queryIdByChatroomName(chatroomName, chatType);
  }

  public int getChatroomId(String chatroomName) {
    return dao.queryIdByChatroomName(chatroomName);
  }

  public String getChatroomName(int roomId) {
    return dao.queryChatroomNameById(roomId);
  }

  // TODO 登入時就要連到自己的聊天室???>

  // OK 進到聊天室頁面就要對每個"聊天室"判斷是否唯讀, 並讀出最後一筆訊息 & 未讀量
  public ArrayList<ArrayList> getExistChatroom(int id) {
    return dao.queryExistChatroomByUser(id);
  }

  public void changeCloseTime(int roomId, int time) {
    dao.updateCloseTime(roomId, time);
  }
}
