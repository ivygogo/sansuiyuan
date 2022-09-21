package tw.edu.ntut.sce.java18.common.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faq")
public class FaqMvcTest implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "Question", columnDefinition = "VARCHAR(45)")
  private String question;

  @Column(name = "Answer", columnDefinition = "VARCHAR(45)")
  private String answer;

  // @Column(name = "Publish_Time", columnDefinition = "DATETIME")
  // @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "Publish_Time")
  private Timestamp publishTime;

  // @Column(name = "Unpublish_Time", columnDefinition = "DATETIME")
  // @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "Unpublish_Time")
  private Timestamp unpublishTime;

  @Column(name = "IsShow", columnDefinition = "TINYINT")
  private int isShow;

  // @Column(name = "CREATE_Time", columnDefinition = "DATETIME")
  // @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "CREATE_Time")
  private Timestamp createTime;

  @Column(name = "Update_Time")
  // @Temporal(TemporalType.TIMESTAMP)
  private Timestamp updateTime;

  @Column(name = "Delete_Time")
  // @Temporal(TemporalType.TIMESTAMP)
  private Timestamp deleteTime;

  public FaqMvcTest() {}

  public FaqMvcTest(
      Integer id,
      String question,
      String answer,
      Timestamp publishTime,
      Timestamp unpublishTime,
      int isShow,
      Timestamp createTime,
      Timestamp updateTime,
      Timestamp deleteTime) {
    super();
    this.id = id;
    this.question = question;
    this.answer = answer;
    this.publishTime = publishTime;
    this.unpublishTime = unpublishTime;
    this.isShow = isShow;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.deleteTime = deleteTime;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Integer getId() {
    return id;
  }

  public String getQuestion() {
    return question;
  }

  public String getAnswer() {
    return answer;
  }

  public Timestamp getPublishTime() {
    return publishTime;
  }

  public Timestamp getUnpublishTime() {
    return unpublishTime;
  }

  public int getIsShow() {
    return isShow;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  public Timestamp getUpdateTime() {
    return updateTime;
  }

  public Timestamp getDeleteTime() {
    return deleteTime;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public void setPublishTime(Timestamp publishTime) {
    this.publishTime = publishTime;
  }

  public void setUnpublishTime(Timestamp unpublishTime) {
    this.unpublishTime = unpublishTime;
  }

  public void setIsShow(int isShow) {
    this.isShow = isShow;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  public void setUpdateTime(Timestamp updateTime) {
    this.updateTime = updateTime;
  }

  public void setDeleteTime(Timestamp deleteTime) {
    this.deleteTime = deleteTime;
  }
}
