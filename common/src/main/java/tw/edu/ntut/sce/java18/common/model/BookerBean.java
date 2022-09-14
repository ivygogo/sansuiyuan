package tw.edu.ntut.sce.java18.common.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookerBean implements Serializable {
  private static final long serialVersionUID = 1L;
  //  private Integer id;
  private Date bookDate;
  private String preferTime;
  private String bookerId;
  private String bookerName;
  private String bookerPhone;
  private String roomtype;
  private String preferFloor;
  private String leadPerson;

  public BookerBean() {
    super();
  }

  public BookerBean(
      //      Integer id,
      Date bookDate,
      String preferTime,
      String bookerId,
      String bookerName,
      String bookerPhone,
      String roomtype,
      String preferFloor,
      String leadPerson) {
    super();
    //    this.id = id;
    this.bookDate = bookDate;
    this.preferTime = preferTime;
    this.bookerId = bookerId;
    this.bookerName = bookerName;
    this.bookerPhone = bookerPhone;
    this.roomtype = roomtype;
    this.preferFloor = preferFloor;
    this.leadPerson = leadPerson;
  }

  //  public Integer getId() {
  //    return id;
  //  }
  //
  //  public void setId(Integer id) {
  //    this.id = id;
  //  }

  public Date getBookDate() {
    return bookDate;
  }

  public void setBookDate(Date bookDate) {
    this.bookDate = bookDate;
  }

  private static SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

  public static Date convertDate(String temp) {
    Date result = new java.util.Date();
    try {
      result = sdf.parse(temp);
    } catch (ParseException e) {
      result = null;
      e.printStackTrace();
    }
    return result;
  }

  public String getPreferTime() {
    return preferTime;
  }

  public void setPreferTime(String preferTime) {
    this.preferTime = preferTime;
  }

  public String getBookerId() {
    return bookerId;
  }

  public void setBookerId(String bookerId) {
    this.bookerId = bookerId;
  }

  public String getBookerName() {
    return bookerName;
  }

  public void setBookerName(String bookerName) {
    this.bookerName = bookerName;
  }

  public String getBookerPhone() {
    return bookerPhone;
  }

  public void setBookerPhone(String bookerPhone) {
    this.bookerPhone = bookerPhone;
  }

  public String getRoomtype() {
    return roomtype;
  }

  public void setRoomtype(String roomtype) {
    this.roomtype = roomtype;
  }

  public String getPreferFloor() {
    return preferFloor;
  }

  public void setPreferFloor(String preferFloor) {
    this.preferFloor = preferFloor;
  }

  public String getLeadPerson() {
    return leadPerson;
  }

  public void setLeadPerson(String leadPerson) {
    this.leadPerson = leadPerson;
  }
}
