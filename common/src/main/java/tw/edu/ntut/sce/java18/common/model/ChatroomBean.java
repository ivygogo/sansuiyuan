package tw.edu.ntut.sce.java18.common.model;

import java.sql.Timestamp;

public class ChatroomBean {
  int id;
  String chatType;
  int member1;
  int member2;
  Timestamp createTime;
  Timestamp closeTime;
  boolean isOpen;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getChatType() {
    return chatType;
  }

  public void setChatType(String chatType) {
    this.chatType = chatType;
  }

  public int getMember1() {
    return member1;
  }

  public void setMember1(int member1) {
    this.member1 = member1;
  }

  public int getMember2() {
    return member2;
  }

  public void setMember2(int member2) {
    this.member2 = member2;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  public Timestamp getCloseTime() {
    return closeTime;
  }

  public void setCloseTime(Timestamp closeTime) {
    this.closeTime = closeTime;
  }

  public boolean isOpen() {
    return isOpen;
  }

  public void setOpen(boolean open) {
    isOpen = open;
  }
}
