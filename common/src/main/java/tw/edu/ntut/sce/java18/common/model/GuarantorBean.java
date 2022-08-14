package tw.edu.ntut.sce.java18.common.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class GuarantorBean implements Serializable {
  private static final long serialVersionUID = 1L;
  Integer uId;
  Integer member_id;
  String name;
  String id_number;
  String phone;
  String address;
  String relation;
  Timestamp create_time;
  Timestamp update_time;

  /* ====== 建構子 ======*/
  public GuarantorBean() {}

  public GuarantorBean(
      Integer uId,
      Integer member_id,
      String name,
      String id_number,
      String phone,
      String address,
      String relation,
      Timestamp create_time,
      Timestamp update_time) {
    super();
    this.uId = uId;
    this.member_id = member_id;
    this.name = name;
    this.id_number = id_number;
    this.phone = phone;
    this.address = address;
    this.relation = relation;
    this.create_time = create_time;
    this.update_time = update_time;
  }

  /* ====== setter & getter ======*/
  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Integer getuId() {
    return uId;
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
  public void setuId(Integer uId) {
    this.uId = uId;
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
