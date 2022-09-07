package tw.edu.ntut.sce.java18.common.model;

import java.sql.Timestamp;

public class ChatMessageBean {
  int id;
  int chatroomId;
  int sender;
  int receiver;
  String content;
  Timestamp sendTime;
  Boolean isRead;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getChatroomId() {
    return chatroomId;
  }

  public void setChatroomId(int chatroomId) {
    this.chatroomId = chatroomId;
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

  public Timestamp getSendTime() {
    return sendTime;
  }

  public void setSendTime(Timestamp sendTime) {
    this.sendTime = sendTime;
  }

  public Boolean getRead() {
    return isRead;
  }

  public void setRead(Boolean read) {
    isRead = read;
  }
}
