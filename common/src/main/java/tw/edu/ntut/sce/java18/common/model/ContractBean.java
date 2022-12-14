package tw.edu.ntut.sce.java18.common.model;

import java.io.Serializable;
import java.sql.Date;

public class ContractBean implements Serializable {

  private static final long serialVersionUID = 1L;
  //  Integer id;
  Integer Member_Id;
  String Contract_Number;
  Date Begin_Time;
  Date End_Time;
  String Room_Number;
  Integer Deposit;

  public ContractBean() {}

  public ContractBean(
      Integer member_Id,
      String contract_Number,
      Date begin_Time,
      Date end_Time,
      String room_Number,
      Integer deposit) {
    Member_Id = member_Id;
    Contract_Number = contract_Number;
    Begin_Time = begin_Time;
    End_Time = end_Time;
    Room_Number = room_Number;
    Deposit = deposit;
  }

  public Integer getMember_Id() {
    return Member_Id;
  }

  public void setMember_Id(Integer member_Id) {
    Member_Id = member_Id;
  }

  public String getContract_Number() {
    return Contract_Number;
  }

  public void setContract_Number(String contract_Number) {
    Contract_Number = contract_Number;
  }

  public Date getBegin_Time() {
    return Begin_Time;
  }

  public void setBegin_Time(Date begin_Time) {
    Begin_Time = begin_Time;
  }

  public Date getEnd_Time() {
    return End_Time;
  }

  public void setEnd_Time(Date end_Time) {
    End_Time = end_Time;
  }

  public String getRoom_Number() {
    return Room_Number;
  }

  public void setRoom_Number(String room_Number) {
    Room_Number = room_Number;
  }

  public Integer getDeposit() {
    return Deposit;
  }

  public void setDeposit(Integer deposit) {
    Deposit = deposit;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }
}
