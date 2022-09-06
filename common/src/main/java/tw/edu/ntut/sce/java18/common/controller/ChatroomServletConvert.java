package tw.edu.ntut.sce.java18.common.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import tw.edu.ntut.sce.java18.common.service.ChatMessageService;
import tw.edu.ntut.sce.java18.common.service.ChatroomService;

public class ChatroomServletConvert {
  // todo reciver or sender都要去member getname , 照片

  public ArrayList<LoadChatroom> getChatroomLastMessage(int id) {

    var chatroomService = new ChatroomService();
    var chatMessageService = new ChatMessageService();
    var chatroomLastMessage = new ArrayList<LoadChatroom>();

    Timestamp currentTime = new Timestamp(System.currentTimeMillis());

    var existChatroomList = chatroomService.getExistChatroom(id);

    for (ArrayList existChatroom : existChatroomList) {
      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
      var chatMessageBean = chatMessageService.getLastMessage((int) existChatroom.get(0));

      LoadChatroom loadChatroom = new LoadChatroom();
      loadChatroom.setChatroomId((int) existChatroom.get(0));
      loadChatroom.setChatroomType((String) existChatroom.get(1));
      loadChatroom.setChatroomName(chatroomService.getChatroomName(loadChatroom.getChatroomId()));
      loadChatroom.setCloseTime(sdf.format(existChatroom.get(2)));
      loadChatroom.setContent(chatMessageBean.getContent());
      loadChatroom.setReceiver(chatMessageBean.getReceiver());
      loadChatroom.setSender(chatMessageBean.getSender());
      loadChatroom.setOpen(currentTime.before((Timestamp) existChatroom.get(2)));

      // loadChatroom.setUnread();   //TODO

      chatroomLastMessage.add(loadChatroom);
    }

    return chatroomLastMessage;
  }

  class LoadChatroom {
    int chatroomId;
    String chatroomType;
    String chatroomName;
    String closeTime;
    int sender;
    int receiver;
    String content;
    int unRead;
    boolean isOpen;



    public boolean isOpen() {
      return isOpen;
    }

    public void setOpen(boolean open) {
      isOpen = open;
    }

    public int getChatroomId() {
      return chatroomId;
    }

    public void setChatroomId(int chatroomId) {
      this.chatroomId = chatroomId;
    }

    public String getChatroomName() {
      return chatroomName;
    }

    public void setChatroomName(String chatroomName) {
      this.chatroomName = chatroomName;
    }

    public String getChatroomType() {
      return chatroomType;
    }

    public void setChatroomType(String chatroomType) {
      this.chatroomType = chatroomType;
    }

    public String getCloseTime() {
      return closeTime;
    }

    public void setCloseTime(String closeTime) {
      this.closeTime = closeTime;
    }

    public int getSender() {
      return sender;
    }

    public void setSender(int sender) {
      this.sender = sender;
    }

    public int getReceiver() {
      return receiver;
    }

    public void setReceiver(int receiver) {
      this.receiver = receiver;
    }

    public String getContent() {
      return content;
    }

    public void setContent(String content) {
      this.content = content;
    }

    public int getUnRead() {
      return unRead;
    }

    public void setUnRead(int unRead) {
      this.unRead = unRead;
    }
  }
}
