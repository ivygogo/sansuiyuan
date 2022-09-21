package tw.edu.ntut.sce.java18.common.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class GuarantorBean implements Serializable {
  private static final long serialVersionUID = 1L;
  Integer id;
  Integer member_id;
  String name;
  String id_number;
  String phone;
  String county;
  String district;
  String address;
  String relation;
  Timestamp create_time;
  Timestamp update_time;

  /* ====== 建構子 ======*/
  public GuarantorBean() {}

  /* ====== setter & getter ======*/
  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Integer getId() {
    return id;
  }

  public Integer getMember_id() {
    return member_id;
  }

  public String getName() {
    return name;
  }

  public String getId_number() {
    return id_number;
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

  public String getRelation() {
    return relation;
  }

  public Timestamp getCreate_time() {
    return create_time;
  }

  public Timestamp getUpdate_time() {
    return update_time;
  }

  /* ====== setter======*/
  public void setId(Integer id) {
    this.id = id;
  }

  public void setMember_id(Integer member_id) {
    this.member_id = member_id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId_number(String id_number) {
    this.id_number = id_number;
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

  public void setRelation(String relation) {
    this.relation = relation;
  }

  public void setCreate_time(Timestamp create_time) {
    this.create_time = create_time;
  }

  public void setUpdate_time(Timestamp update_time) {
    this.update_time = update_time;
  }
}
