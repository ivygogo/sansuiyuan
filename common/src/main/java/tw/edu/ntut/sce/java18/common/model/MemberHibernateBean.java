package tw.edu.ntut.sce.java18.common.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "MemberHibernateBean")
public class MemberHibernateBean implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer uId;

  String name;
  Integer gender;
  String phone;
  String idNumber;
  String mail;
  String password;
  String county;
  String district;
  String address;
  String nickname;
  Integer state;
  String code;
  String school;
  Integer pic;
  Integer signature1;
  Integer signature2;
  Integer signature3;
  Integer favor1;
  Integer favor2;
  Integer favor3;
  Integer pair1;
  Integer pair2;
  Integer pair3;
  Integer pair4;
  Integer pair5;
  boolean openTag;
  Timestamp createTime;
  Timestamp updateTime;
  String lastIp;

  public MemberHibernateBean() {}

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Integer getuId() {
    return uId;
  }

  public String getName() {
    return name;
  }

  public Integer getGender() {
    return gender;
  }

  public String getPhone() {
    return phone;
  }

  public String getIdNumber() {
    return idNumber;
  }

  public String getMail() {
    return mail;
  }

  public String getPassword() {
    return password;
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

  public String getNickname() {
    return nickname;
  }

  public Integer getState() {
    return state;
  }

  public String getCode() {
    return code;
  }

  public String getSchool() {
    return school;
  }

  public Integer getPic() {
    return pic;
  }

  public Integer getSignature1() {
    return signature1;
  }

  public Integer getSignature2() {
    return signature2;
  }

  public Integer getSignature3() {
    return signature3;
  }

  public Integer getFavor1() {
    return favor1;
  }

  public Integer getFavor2() {
    return favor2;
  }

  public Integer getFavor3() {
    return favor3;
  }

  public Integer getPair1() {
    return pair1;
  }

  public Integer getPair2() {
    return pair2;
  }

  public Integer getPair3() {
    return pair3;
  }

  public Integer getPair4() {
    return pair4;
  }

  public Integer getPair5() {
    return pair5;
  }

  public boolean getOpenTag() {
    return openTag;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  public Timestamp getUpdateTime() {
    return updateTime;
  }

  public String getLastIp() {
    return lastIp;
  }
  /* ====== setter ======*/

  public void setuId(Integer uId) {
    this.uId = uId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public void setPic(Integer pic) {
    this.pic = pic;
  }

  public void setSignature1(Integer signature1) {
    this.signature1 = signature1;
  }

  public void setSignature2(Integer signature2) {
    this.signature2 = signature2;
  }

  public void setSignature3(Integer signature3) {
    this.signature3 = signature3;
  }

  public void setFavor1(Integer favor1) {
    this.favor1 = favor1;
  }

  public void setFavor2(Integer favor2) {
    this.favor2 = favor2;
  }

  public void setFavor3(Integer favor3) {
    this.favor3 = favor3;
  }

  public void setPair1(Integer pair1) {
    this.pair1 = pair1;
  }

  public void setPair2(Integer pair2) {
    this.pair2 = pair2;
  }

  public void setPair3(Integer pair3) {
    this.pair3 = pair3;
  }

  public void setPair4(Integer pair4) {
    this.pair4 = pair4;
  }

  public void setPair5(Integer pair5) {
    this.pair5 = pair5;
  }

  public void setOpenTag(boolean openTag) {
    this.openTag = openTag;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  public void setUpdateTime(Timestamp updateTime) {
    this.updateTime = updateTime;
  }

  public void setLastIp(String lastIp) {
    this.lastIp = lastIp;
  }
}
