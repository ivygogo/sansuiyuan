package tw.edu.ntut.sce.java18.landlord.model;

import java.io.Serializable;

public class LandlordInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  Integer id;
  String name;
  String phone;
  String county;
  String district;
  String address;
  String mail;
  String stamp;
  String password;

  public LandlordInfo() {}

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }

  public String getCounty() {
    return county;
  }

  public String getDistrict() {
    return district;
  }

  public String getAddress() {
    return address;
  }

  public String getMail() {
    return mail;
  }

  public String getStamp() {
    return stamp;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public void setStamp(String stamp) {
    this.stamp = stamp;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
