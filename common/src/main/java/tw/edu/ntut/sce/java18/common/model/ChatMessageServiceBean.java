package tw.edu.ntut.sce.java18.common.model;

public class ChatMessageServiceBean {
  private int roomId;
  private int sender;
  private int receiver;
  private String content;
  private String currentYear;
  private String currentDate;
  private String currentTime;
  private boolean isRead;

  @Override
  public String toString() {
    return super.toString();
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

  public String getCurrentDate() {
    return currentDate;
  }

  public void setCurrentDate(String currentDate) {
    this.currentDate = currentDate;
  }

  public String getCurrentTime() {
    return currentTime;
  }

  public void setCurrentTime(String currentTime) {
    this.currentTime = currentTime;
  }

  public int getRoomId() {
    return roomId;
  }

  public void setRoomId(int roomId) {
    this.roomId = roomId;
  }

  public String getCurrentYear() {
    return currentYear;
  }

  public void setCurrentYear(String currentYear) {
    this.currentYear = currentYear;
  }

  public boolean isRead() {
    return isRead;
  }

  public void setRead(boolean read) {
    isRead = read;
  }
}
