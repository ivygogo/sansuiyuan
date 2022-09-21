package tw.edu.ntut.sce.java18.common.model;

import java.io.Serializable;

public class RentBean implements Serializable {
  private static final long serialVersionUID = 1L;
  private int uId;
  private String renterName;
  private String renterPhone;
  private String renterIdNumber;
  private String renterAddress;
  private String guarntorName;
  private String guarntorPhone;
  private String guarntorIdNumber;
  private String guarntorAddress;

  public RentBean() {}

  public RentBean(
      int uId,
      String renterName,
      String renterPhone,
      String renterIdNumber,
      String renterAddress,
      String guarntorName,
      String guarntorPhone,
      String guarntorIdNumber,
      String guarntorAddress) {
    this.uId = uId;
    this.renterName = renterName;
    this.renterPhone = renterPhone;
    this.renterIdNumber = renterIdNumber;
    this.renterAddress = renterAddress;
    this.guarntorName = guarntorName;
    this.guarntorPhone = guarntorPhone;
    this.guarntorIdNumber = guarntorIdNumber;
    this.guarntorAddress = guarntorAddress;
  }

  public int getuId() {
    return uId;
  }

  public void setuId(int uId) {
    this.uId = uId;
  }

  public String getRenterName() {
    return renterName;
  }

  public void setRenterName(String renterName) {
    this.renterName = renterName;
  }

  public String getRenterPhone() {
    return renterPhone;
  }

  public void setRenterPhone(String renterPhone) {
    this.renterPhone = renterPhone;
  }

  public String getRenterIdNumber() {
    return renterIdNumber;
  }

  public void setRenterIdNumber(String renterIdNumber) {
    this.renterIdNumber = renterIdNumber;
  }

  public String getRenterAddress() {
    return renterAddress;
  }

  public void setRenterAddress(String renterAddress) {
    this.renterAddress = renterAddress;
  }

  public String getGuarntorName() {
    return guarntorName;
  }

  public void setGuarntorName(String guarntorName) {
    this.guarntorName = guarntorName;
  }

  public String getGuarntorPhone() {
    return guarntorPhone;
  }

  public void setGuarntorPhone(String guarntorPhone) {
    this.guarntorPhone = guarntorPhone;
  }

  public String getGuarntorIdNumber() {
    return guarntorIdNumber;
  }

  public void setGuarntorIdNumber(String guarntorIdNumber) {
    this.guarntorIdNumber = guarntorIdNumber;
  }

  public String getGuarntorAddress() {
    return guarntorAddress;
  }

  public void setGuarntorAddress(String guarntorAddress) {
    this.guarntorAddress = guarntorAddress;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }
}
