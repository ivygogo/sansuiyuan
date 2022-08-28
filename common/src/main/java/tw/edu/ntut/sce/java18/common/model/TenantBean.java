package tw.edu.ntut.sce.java18.common.model;

import java.io.Serializable;
import java.sql.Date;

public class TenantBean implements Serializable {

  private static final long serialVersionUID = 1L;
  Integer id;
  Integer Member_Id;
  String Contract_Number;
  Date Begin_Time;
  Date End_Time;
  String Room_Number;
  Integer Deposit;

  /* ====== 建構子 ======*/
  public TenantBean() {}

  public TenantBean(
      Integer id,
      Integer member_Id,
      String contract_Number,
      Date begin_Time,
      Date end_Time,
      String room_Number,
      Integer deposit) {
    super();
    this.id = id;
    Member_Id = member_Id;
    Contract_Number = contract_Number;
    Begin_Time = begin_Time;
    End_Time = end_Time;
    Room_Number = room_Number;
    Deposit = deposit;
  }

  /* ====== getter ======*/

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Integer getId() {
    return id;
  }

  public Integer getMember_Id() {
    return Member_Id;
  }

  public String getContract_Number() {
    return Contract_Number;
  }

  public Date getBegin_Time() {
    return Begin_Time;
  }

  public Date getEnd_Time() {
    return End_Time;
  }

  public String getRoom_Number() {
    return Room_Number;
  }

  public Integer getDeposit() {
    return Deposit;
  }

  /* ====== setter======*/
  public void setId(Integer id) {
    this.id = id;
  }

  public void setMember_Id(Integer member_Id) {
    Member_Id = member_Id;
  }

  public void setContract_Number(String contract_Number) {
    Contract_Number = contract_Number;
  }

  public void setBegin_Time(Date begin_Time) {
    Begin_Time = begin_Time;
  }

  public void setEnd_Time(Date end_Time) {
    End_Time = end_Time;
  }

  public void setRoom_Number(String room_Number) {
    Room_Number = room_Number;
  }

  public void setDeposit(Integer deposit) {
    Deposit = deposit;
  }
}
