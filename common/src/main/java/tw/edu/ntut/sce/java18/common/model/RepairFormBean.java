package tw.edu.ntut.sce.java18.common.model;

import java.sql.Timestamp;

public class RepairFormBean {
  private static final long serialVersionUID = 1L;
  Integer id;
  String formNumber;
  String roomNumber;
  Integer applicant;
  String phone;
  Timestamp creatTime;
  Timestamp expectionTime;
  Timestamp fixTime;
  Timestamp finishTime;
  Integer project;
  String note;
  Integer status;
  Integer amount;

  String projectName;
  Integer projectPrice;
  String projectNameAlias;

  public RepairFormBean() {}

  public RepairFormBean(
      Integer id,
      String formNumber,
      String roomNumber,
      Integer applicant,
      String phone,
      Timestamp creatTime,
      Timestamp expectionTime,
      Timestamp fixTime,
      Timestamp finishTime,
      Integer project,
      String note,
      Integer status,
      Integer amount,
      String projectName,
      Integer projectPrice,
      String projectNameAlias) {

    this.id = id;
    this.formNumber = formNumber;
    this.roomNumber = roomNumber;
    this.applicant = applicant;
    this.phone = phone;
    this.creatTime = creatTime;
    this.expectionTime = expectionTime;
    this.fixTime = fixTime;
    this.finishTime = finishTime;
    this.project = project;
    this.note = note;
    this.status = status;
    this.amount = amount;
    this.projectName = projectName;
    this.projectPrice = projectPrice;
    this.projectNameAlias = projectNameAlias;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Integer getId() {
    return id;
  }

  public String getFormNumber() {
    return formNumber;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public Integer getApplicant() {
    return applicant;
  }

  public String getPhone() {
    return phone;
  }

  public Timestamp getCreatTime() {
    return creatTime;
  }

  public Timestamp getExpectionTime() {
    return expectionTime;
  }

  public Timestamp getFixTime() {
    return fixTime;
  }

  public Timestamp getFinishTime() {
    return finishTime;
  }

  public Integer getProject() {
    return project;
  }

  public String getNote() {
    return note;
  }

  public Integer getStatus() {
    return status;
  }

  public Integer getAmount() {
    return amount;
  }

  public String getProjectName() {
    return projectName;
  }

  public Integer getProjectPrice() {
    return projectPrice;
  }

  public String getProjectNameAlias() {
    return projectNameAlias;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setFormNumber(String formNumber) {
    this.formNumber = formNumber;
  }

  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
  }

  public void setApplicant(Integer applicant) {
    this.applicant = applicant;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setCreatTime(Timestamp creatTime) {
    this.creatTime = creatTime;
  }

  public void setExpectionTime(Timestamp expectionTime) {
    this.expectionTime = expectionTime;
  }

  public void setFixTime(Timestamp fixTime) {
    this.fixTime = fixTime;
  }

  public void setFinishTime(Timestamp finishTime) {
    this.finishTime = finishTime;
  }

  public void setProject(Integer project) {
    this.project = project;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public void setProjectPrice(Integer projectPrice) {
    this.projectPrice = projectPrice;
  }

  public void setProjectNameAlias(String projectNameAlias) {
    this.projectNameAlias = projectNameAlias;
  }
}
