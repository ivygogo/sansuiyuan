package tw.edu.ntut.sce.java18.common.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class RefundAccountBean implements Serializable {

  private static final long serialVersionUID = 1L;
  Integer uId;
  Integer member_id;
  String refundBank;
  String bankStore;
  String phone;
  String refundName;
  Timestamp create_time;
  Timestamp update_time;

  public RefundAccountBean() {
    // TODO Auto-generated constructor stub
  }

  /* ====== 建構子 ======*/
  public RefundAccountBean(
      Integer uId,
      Integer member_id,
      String refundBank,
      String bankStore,
      String phone,
      String refundName,
      Timestamp create_time,
      Timestamp update_time) {
    super();
    this.uId = uId;
    this.member_id = member_id;
    this.refundBank = refundBank;
    this.bankStore = bankStore;
    this.phone = phone;
    this.refundName = refundName;
    this.create_time = create_time;
    this.update_time = update_time;
  }

  /* ====== getter ======*/
  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Integer getuId() {
    return uId;
  }

  public Integer getMember_id() {
    return member_id;
  }

  public String getRefundBank() {
    return refundBank;
  }

  public String getBankStore() {
    return bankStore;
  }

  public String getPhone() {
    return phone;
  }

  public String getRefundName() {
    return refundName;
  }

  public Timestamp getCreate_time() {
    return create_time;
  }

  public Timestamp getUpdate_time() {
    return update_time;
  }

  /* ====== setter ======*/
  public void setuId(Integer uId) {
    this.uId = uId;
  }

  public void setMember_id(Integer member_id) {
    this.member_id = member_id;
  }

  public void setRefundBank(String refundBank) {
    this.refundBank = refundBank;
  }

  public void setBankStore(String bankStore) {
    this.bankStore = bankStore;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setRefundName(String refundName) {
    this.refundName = refundName;
  }

  public void setCreate_time(Timestamp create_time) {
    this.create_time = create_time;
  }

  public void setUpdate_time(Timestamp update_time) {
    this.update_time = update_time;
  }
}
