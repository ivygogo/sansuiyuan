package tw.edu.ntut.sce.java18.common.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = "Member")
public class MemberBean implements Serializable {
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
  Integer signature_1;
  Integer signature_2;
  Integer signature_3;
  Integer favor_1;
  Integer favor_2;
  Integer favor_3;
  Integer pair_1;
  Integer pair_2;
  Integer pair_3;
  Integer pair_4;
  Integer pair_5;
  Integer open_tag;
  Timestamp create_time;
  Timestamp update_time;
  String last_IP;
  @Transient
  String signatureAll;
  @Transient
  String favorStrAll;
  @Transient
  String avatar;
  @Transient
  String level;
  @Transient
  List<String> contract;
  @Transient
  List<TenantBean> tenant;
  @Transient
  List<GuarantorBean> guarantorList;
  @Transient
  List<RefundAccountBean> refundAccountList;
  @Transient
  GuarantorBean guarantor;
  @Transient
  RefundAccountBean refundAccount;
  /* ====== 建構子 ======*/
  public MemberBean() {
  }

  public MemberBean(String name,
                    int gender,
                    String phone,
                    String idNumber,
                    String mail,
                    String password,
                    String address,
                    String nickname,
                    Timestamp create_time) {
    super();
    this.name = name;
    this.gender = gender;
    this.phone = phone;
    this.idNumber = idNumber;
    this.mail = mail;
    this.password = password;
    this.address = address;
    this.nickname = nickname;
    this.create_time = create_time;
  }
  /* ====== getter ======*/

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

  public Integer getSignature_1() {
    return signature_1;
  }

  public Integer getSignature_2() {
    return signature_2;
  }

  public Integer getSignature_3() {
    return signature_3;
  }

  public Integer getFavor_1() {
    return favor_1;
  }

  public Integer getFavor_2() {
    return favor_2;
  }

  public Integer getFavor_3() {
    return favor_3;
  }

  public Integer getPair_1() {
    return pair_1;
  }

  public Integer getPair_2() {
    return pair_2;
  }

  public Integer getPair_3() {
    return pair_3;
  }

  public Integer getPair_4() {
    return pair_4;
  }

  public Integer getPair_5() {
    return pair_5;
  }

  public Integer getOpen_tag() {
    return open_tag;
  }

  public Timestamp getCreate_time() {
    return create_time;
  }

  public Timestamp getUpdate_time() {
    return update_time;
  }

  public String getLast_IP() {
    return last_IP;
  }

  public String getSignatureAll() {
    return signatureAll;
  }

  public String getFavorStrAll() {
    return favorStrAll;
  }

  public String getAvatar() {
    return avatar;
  }

  public String getLevel() {
    return level;
  }

  public List<String> getContract() {
    return contract;
  }

  public List<TenantBean> getTenant() {
    return tenant;
  }

  public List<GuarantorBean> getGuarantorList() {
    return guarantorList;
  }

  public List<RefundAccountBean> getRefundAccountList() {
    return refundAccountList;
  }

  public GuarantorBean getGuarantor() {
    return guarantor;
  }

  public RefundAccountBean getRefundAccount() {
    return refundAccount;
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

  public void setSignature_1(Integer signature_1) {
    this.signature_1 = signature_1;
  }

  public void setSignature_2(Integer signature_2) {
    this.signature_2 = signature_2;
  }

  public void setSignature_3(Integer signature_3) {
    this.signature_3 = signature_3;
  }

  public void setFavor_1(Integer favor_1) {
    this.favor_1 = favor_1;
  }

  public void setFavor_2(Integer favor_2) {
    this.favor_2 = favor_2;
  }

  public void setFavor_3(Integer favor_3) {
    this.favor_3 = favor_3;
  }

  public void setPair_1(Integer pair_1) {
    this.pair_1 = pair_1;
  }

  public void setPair_2(Integer pair_2) {
    this.pair_2 = pair_2;
  }

  public void setPair_3(Integer pair_3) {
    this.pair_3 = pair_3;
  }

  public void setPair_4(Integer pair_4) {
    this.pair_4 = pair_4;
  }

  public void setPair_5(Integer pair_5) {
    this.pair_5 = pair_5;
  }

  public void setOpen_tag(Integer open_tag) {
    this.open_tag = open_tag;
  }

  public void setCreate_time(Timestamp create_time) {
    this.create_time = create_time;
  }

  public void setUpdate_time(Timestamp update_time) {
    this.update_time = update_time;
  }

  public void setLast_IP(String last_IP) {
    this.last_IP = last_IP;
  }

  public void setSignatureAll(String signatureAll) {
    this.signatureAll = signatureAll;
  }

  public void setFavorStrAll(String favorStrAll) {
    this.favorStrAll = favorStrAll;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public void setContract(List<String> contract) {
    this.contract = contract;
  }

  public void setTenant(List<TenantBean> tenant) {
    this.tenant = tenant;
  }

  public void setGuarantorList(List<GuarantorBean> guarantor) {
    this.guarantorList = guarantor;
  }

  public void setRefundAccountList(List<RefundAccountBean> refundAccount) {
    this.refundAccountList = refundAccount;
  }

  public void setGuarantor(GuarantorBean guarantor) {
    this.guarantor = guarantor;
  }

  public void setRefundAccount(RefundAccountBean refundAccount) {
    this.refundAccount = refundAccount;
  }
}
