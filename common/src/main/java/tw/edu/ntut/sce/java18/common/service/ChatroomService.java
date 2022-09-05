package tw.edu.ntut.sce.java18.common.service;

import java.util.ArrayList;
import tw.edu.ntut.sce.java18.common.dao.ChatroomDao;
import tw.edu.ntut.sce.java18.common.dao.impl.ChatroomDaoImpl_JDBC;

public class ChatroomService {
  ChatroomDao dao;

  public ChatroomService() {
    dao = new ChatroomDaoImpl_JDBC();
  }

  // OK 判斷聊天室是否存在
  public int isExist(int member1, int member2) {
    return dao.queryIdByChatroomName(member1 + "_" + member2);
  }
  // OK 製造新聊天室
  public void createChatroom(String type, int member1, int member2) {
    dao.insertChatroom(type, member1, member2);
  }

  public int getChatroomId(String chatroomName) {
    return dao.queryIdByChatroomName(chatroomName);
  }

  // TODO 登入時就要連到自己的聊天室???>

  // TODO 預約成功,找室友配對成功,報修  傳送系統訊息?

  // OK 進到聊天室頁面就要對每個"聊天室"判斷是否唯讀, 並讀出最後一筆訊息 & 未讀量
  public ArrayList<ArrayList> getExistChatroom(int id) {
    return dao.queryExistChatroomBySender(id);
  }

  // TODO 點擊到該聊天室將過去訊息都讀出 (限時?限量?) 並連接websocket,傳送訊息無論是否對面人在都可以將訊息存到DB
  //  public messageAll[] queryAllmessage(){
  //    return message;
  //  }

}
