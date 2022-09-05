package tw.edu.ntut.sce.java18.common.service;

import tw.edu.ntut.sce.java18.common.model.ChatMessageBean;
import tw.edu.ntut.sce.java18.common.model.ChatMessageServiceBean;

public class ChatMessageServiceConverter {
  ChatMessageServiceBean message;

  public ChatMessageServiceBean convertMessageBean(ChatMessageBean messageDao) {

    int year = messageDao.getSendTime().getYear();
    String monthday =
        messageDao.getSendTime().getMonth() + "/" + messageDao.getSendTime().getDate();
    long time = messageDao.getSendTime().getTime();

    System.out.println(year + monthday + time);

    message.setRoomId(messageDao.getChatroomId());
    message.setReceiver(messageDao.getReceiver());
    message.setSender(messageDao.getSender());
    var sendTime = messageDao.getSendTime().toLocalDateTime();

    message.setCurrentYear(sendTime.getYear() + "");
    message.setCurrentDate(sendTime.getMonthValue() + "/" + sendTime.getDayOfMonth());
    message.setCurrentTime(sendTime.getHour() + ":" + sendTime.getMinute());
    message.setContent(messageDao.getContent());
    System.out.println("after connver");

    return message;
  }
}
