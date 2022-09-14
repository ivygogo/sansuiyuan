package tw.edu.ntut.sce.java18.common.model;

public class RepairFormServiceBean {
  private static final long serialVersionUID = 1L;
  Integer id;
  String repairFormNumber;
  String repairRoomNumber;
  String applicantName;
  String applicantPhone;
  String repairFormCreatTime;
  String repairFormExpectionTime;
  String repairFormFixTime;
  String repairFormFinishTime;
  String projectAlias;
  String note;
  Integer status;

  public RepairFormServiceBean() {}

  public RepairFormServiceBean(
      Integer id,
      String repairFormNumber,
      String repairRoomNumber,
      String applicantName,
      String applicantPhone,
      String repairFormCreatTime,
      String repairFormExpectionTime,
      String repairFormFixTime,
      String repairFormFinishTime,
      String projectAlias,
      String note,
      Integer status) {
    super();
    this.id = id;
    this.repairFormNumber = repairFormNumber;
    this.repairRoomNumber = repairRoomNumber;
    this.applicantName = applicantName;
    this.applicantPhone = applicantPhone;
    this.repairFormCreatTime = repairFormCreatTime;
    this.repairFormExpectionTime = repairFormExpectionTime;
    this.repairFormFixTime = repairFormFixTime;
    this.repairFormFinishTime = repairFormFinishTime;
    this.projectAlias = projectAlias;
    this.note = note;
    this.status = status;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Integer getId() {
    return id;
  }

  public String getRepairFormNumber() {
    return repairFormNumber;
  }

  public String getRepairRoomNumber() {
    return repairRoomNumber;
  }

  public String getApplicantName() {
    return applicantName;
  }

  public String getApplicantPhone() {
    return applicantPhone;
  }

  public String getRepairFormCreatTime() {
    return repairFormCreatTime;
  }

  public String getRepairFormExpectionTime() {
    return repairFormExpectionTime;
  }

  public String getRepairFormFixTime() {
    return repairFormFixTime;
  }

  public String getRepairFormFinishTime() {
    return repairFormFinishTime;
  }

  public String getProjectAlias() {
    return projectAlias;
  }

  public String getNote() {
    return note;
  }

  public Integer getStatus() {
    return status;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setRepairFormNumber(String repairFormNumber) {
    this.repairFormNumber = repairFormNumber;
  }

  public void setRepairRoomNumber(String repairRoomNumber) {
    this.repairRoomNumber = repairRoomNumber;
  }

  public void setApplicantName(String applicantName) {
    this.applicantName = applicantName;
  }

  public void setApplicantPhone(String applicantPhone) {
    this.applicantPhone = applicantPhone;
  }

  public void setRepairFormCreatTime(String repairFormCreatTime) {
    this.repairFormCreatTime = repairFormCreatTime;
  }

  public void setRepairFormExpectionTime(String repairFormExpectionTime) {
    this.repairFormExpectionTime = repairFormExpectionTime;
  }

  public void setRepairFormFixTime(String repairFormFixTime) {
    this.repairFormFixTime = repairFormFixTime;
  }

  public void setRepairFormFinishTime(String repairFormFinishTime) {
    this.repairFormFinishTime = repairFormFinishTime;
  }

  public void setProjectAlias(String projectAlias) {
    this.projectAlias = projectAlias;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
