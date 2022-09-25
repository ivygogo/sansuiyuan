package tw.edu.ntut.sce.java18.landlord.model;

import java.io.Serializable;

public class ContractBean implements Serializable {
  private static final long serialVersionUID = 1L;
  Integer CID;
  String Status;
  String Name;
  String PDF;
  String Room_Number;
  String Room_Type;
  String Payment_Status;
  String Check_Fee;
  String Check_Status;
  String Signed_Date;
  String Deposit;
  Integer Hide;

  public ContractBean() {}

  public ContractBean(
      Integer cID,
      String status,
      String name,
      String pDF,
      String room_Number,
      String room_Type,
      String payment_Status,
      String check_Fee,
      String check_Status,
      String signed_Date,
      String deposit,
      Integer hide) {
    super();
    CID = cID;
    Status = status;
    Name = name;
    PDF = pDF;
    Room_Number = room_Number;
    Room_Type = room_Type;
    Payment_Status = payment_Status;
    Check_Fee = check_Fee;
    Check_Status = check_Status;
    Signed_Date = signed_Date;
    Deposit = deposit;
    Hide = hide;
  }

  public Integer getCID() {
    return CID;
  }

  public void setCID(Integer cID) {
    CID = cID;
  }

  public String getStatus() {
    return Status;
  }

  public void setStatus(String status) {
    Status = status;
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }

  public String getPDF() {
    return PDF;
  }

  public void setPDF(String pDF) {
    PDF = pDF;
  }

  public String getRoom_Number() {
    return Room_Number;
  }

  public void setRoom_Number(String room_Number) {
    Room_Number = room_Number;
  }

  public String getRoom_Type() {
    return Room_Type;
  }

  public void setRoom_Type(String room_Type) {
    Room_Type = room_Type;
  }

  public String getPayment_Status() {
    return Payment_Status;
  }

  public void setPayment_Status(String payment_Status) {
    Payment_Status = payment_Status;
  }

  public String getCheck_Fee() {
    return Check_Fee;
  }

  public void setCheck_Fee(String check_Fee) {
    Check_Fee = check_Fee;
  }

  public String getCheck_Status() {
    return Check_Status;
  }

  public void setCheck_Status(String check_Status) {
    Check_Status = check_Status;
  }

  public String getSigned_Date() {
    return Signed_Date;
  }

  public void setSigned_Date(String signed_Date) {
    Signed_Date = signed_Date;
  }

  public String getDeposit() {
    return Deposit;
  }

  public void setDeposit(String deposit) {
    Deposit = deposit;
  }

  public Integer getHide() {
    return Hide;
  }

  public void setHide(Integer hide) {
    Hide = hide;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }
}
