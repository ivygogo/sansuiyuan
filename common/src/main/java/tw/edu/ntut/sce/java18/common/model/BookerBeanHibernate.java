package tw.edu.ntut.sce.java18.common.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookingexample")
public class BookerBeanHibernate implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "Booker_Id")
  private Integer bookerId;

  @Column(name = "Book_Date")
  private Date bookDate;

  @Column(name = "Prefer_Time")
  private String preferTime;

  @Column(name = "Booker_Name")
  private String bookerName;

  @Column(name = "Booker_Phone")
  private String bookerPhone;

  @Column(name = "Roomtype")
  private String roomtype;

  @Column(name = "Prefer_Floor")
  private String preferFloor;

  @Column(name = "Lead_Person")
  private String leadPerson;

  public BookerBeanHibernate() {
    super();
  }

  public BookerBeanHibernate(
      Integer bookerId,
      Date bookDate,
      String preferTime,
      String bookerName,
      String bookerPhone,
      String roomtype,
      String preferFloor,
      String leadPerson) {
    super();
    this.bookDate = bookDate;
    this.preferTime = preferTime;
    this.bookerId = bookerId;
    this.bookerName = bookerName;
    this.bookerPhone = bookerPhone;
    this.roomtype = roomtype;
    this.preferFloor = preferFloor;
    this.leadPerson = leadPerson;
  }

  public Date getBookDate() {
    return bookDate;
  }

  public void setBookDate(Date bookDate) {
    this.bookDate = bookDate;
  }

  private static SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

  public static Date convertDate(String temp) {
    Date result = (Date) new java.util.Date();
    try {
      result = (Date) sdf.parse(temp);
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

  public Integer getBookerId() {
    return bookerId;
  }

  public void setBookerId(Integer bookerId) {
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
