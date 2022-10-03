package tw.edu.ntut.sce.java18.common.model;

import java.io.Serializable;

public class ContractStatusBean implements Serializable {
  private static final long serialVersionUID = 1L;
  // Integer cId;
  String status;
  String name;
  String roomNumber;
  String roomType;
  String paymentStatus;
  String checkFee;
  String checkStatus;
  String pdf;
  String signedDate;
  String deposit;
  Integer hide;
  Integer memberId;

  public ContractStatusBean() {}

  public ContractStatusBean(
      //   Integer cId,
      String status,
      String name,
      String roomNumber,
      String roomType,
      String paymentStatus,
      String checkFee,
      String checkStatus,
      String pdf,
      String signedDate,
      String deposit,
      Integer hide,
      Integer memberId) {
    //  this.cId = cId;
    this.status = status;
    this.name = name;
    this.roomNumber = roomNumber;
    this.roomType = roomType;
    this.paymentStatus = paymentStatus;
    this.checkFee = checkFee;
    this.checkStatus = checkStatus;
    this.pdf = pdf;
    this.signedDate = signedDate;
    this.deposit = deposit;
    this.hide = hide;
    this.memberId = memberId;
  }

  //  public Integer getcId() {
  //    return cId;
  //  }
  //
  //  public void setcId(Integer cId) {
  //    this.cId = cId;
  //  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
  }

  public String getRoomType() {
    return roomType;
  }

  public void setRoomType(String roomType) {
    this.roomType = roomType;
  }

  public String getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(String paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public String getCheckFee() {
    return checkFee;
  }

  public void setCheckFee(String checkFee) {
    this.checkFee = checkFee;
  }

  public String getCheckStatus() {
    return checkStatus;
  }

  public void setCheckStatus(String checkStatus) {
    this.checkStatus = checkStatus;
  }

  public String getPdf() {
    return pdf;
  }

  public void setPdf(String pdf) {
    this.pdf = pdf;
  }

  public String getSignedDate() {
    return signedDate;
  }

  public void setSignedDate(String signedDate) {
    this.signedDate = signedDate;
  }

  public String getDeposit() {
    return deposit;
  }

  public void setDeposit(String deposit) {
    this.deposit = deposit;
  }

  public Integer getHide() {
    return hide;
  }

  public void setHide(Integer hide) {
    this.hide = hide;
  }

  public Integer getMemberId() {
    return memberId;
  }

  public void setMemberId(Integer memberId) {
    this.memberId = memberId;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }
}
