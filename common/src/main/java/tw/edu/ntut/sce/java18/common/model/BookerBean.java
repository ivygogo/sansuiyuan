package tw.edu.ntut.sce.java18.common.model;

public class BookerBean implements java.io.Serializable {
  private static final long serialVersionUID = 1L;
  String name;
  String tel;
  String email;
  String roomType;
  String[] floor;
  String date;
  String[] time;

  public BookerBean() {}

  public BookerBean(
      String name,
      String tel,
      String email,
      String roomType,
      String[] floor,
      String date,
      String[] time) {
    super();
    this.name = name;
    this.tel = tel;
    this.email = email;
    this.roomType = roomType;
    this.floor = floor;
    this.date = date;
    this.time = time;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRoomType() {
    return roomType;
  }

  public void setRoomType(String roomType) {
    this.roomType = roomType;
  }

  public String[] getFloor() {
    return floor;
  }

  public void setFloor(String[] floor) {
    this.floor = floor;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String[] getTime() {
    return time;
  }

  public void setTime(String[] time) {
    this.time = time;
  }
}
