package tw.edu.ntut.sce.java18.common.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import tw.edu.ntut.sce.java18.common.dao.ChatMessageDao;
import tw.edu.ntut.sce.java18.common.dao.impl.ChatMessageDaoImpl_JDBC;
import tw.edu.ntut.sce.java18.common.dao.impl.ChatroomDaoImpl_JDBC;
import tw.edu.ntut.sce.java18.common.model.ChatMessageBean;
import tw.edu.ntut.sce.java18.common.model.ChatMessageServiceBean;

public class ChatMessageService {
  ChatMessageDao dao;

  public ChatMessageService() {
    dao = new ChatMessageDaoImpl_JDBC();
  }

  public int getChatroomId(ChatMessageServiceBean message) {
    var chatroomDao = new ChatroomDaoImpl_JDBC();

    int member1;
    int member2;
    if (message.getReceiver() > message.getSender()) {
      member1 = message.getSender();
      member2 = message.getReceiver();
    } else {
      member1 = message.getReceiver();
      member2 = message.getSender();
    }
    String chatroomName = member1 + "_" + member2;
    return chatroomDao.queryIdByChatroomName(chatroomName);
  }

  public void createMessage(ChatMessageServiceBean message) {
    message.setRoomId(new ChatMessageService().getChatroomId(message));
    dao.insertMessage(message);
  }

  public ChatMessageBean getLastMessage(int roomId) {
    return dao.queryLastMessage(roomId);
  }

  public ArrayList<ChatMessageServiceBean> getAllMessage(int chatroomId) {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    ArrayList<ChatMessageServiceBean> messageServiceBeanArrayList = new ArrayList<>();
    var chatMessageBeanList = dao.queryHistoryMessage(chatroomId);

    for (ChatMessageBean messageBean : chatMessageBeanList) {
      ChatMessageServiceBean serviceBean = new ChatMessageServiceBean();
      serviceBean.setReceiver(messageBean.getReceiver());
      serviceBean.setContent(messageBean.getContent());
      serviceBean.setSender(messageBean.getSender());
      serviceBean.setRead(messageBean.getRead());
      serviceBean.setCurrentYear(sdf.format(messageBean.getSendTime()).substring(0, 4));
      serviceBean.setCurrentDate(sdf.format(messageBean.getSendTime()).substring(5, 10));
      serviceBean.setCurrentTime(sdf.format(messageBean.getSendTime()).substring(11, 16));
      messageServiceBeanArrayList.add(serviceBean);
    }

    return messageServiceBeanArrayList;
  }

  public int getUnreadCount(int roomId, int userId) {
    return dao.queryUnreadCount(roomId, userId);
  }

  public void changeReadStatus(int roomId, int userId) {
    dao.updateUnReadStatus(roomId, userId);
  }
}
