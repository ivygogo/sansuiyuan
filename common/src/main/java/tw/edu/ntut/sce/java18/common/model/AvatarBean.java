package tw.edu.ntut.sce.java18.common.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class AvatarBean implements Serializable {

  private static final long serialVersionUID = 1L;

  Integer id;
  String avatarName;
  Integer genderType;
  Integer isShow;
  Timestamp createtime;
  Timestamp updatetime;
  /* ====== 建構子 ======*/
  public AvatarBean() {}

  public AvatarBean(
      Integer id,
      String avatarName,
      Integer genderType,
      Integer isShow,
      Timestamp createtime,
      Timestamp updatetime) {
    super();
    this.id = id;
    this.avatarName = avatarName;
    this.genderType = genderType;
    this.isShow = isShow;
    this.createtime = createtime;
    this.updatetime = updatetime;
  }

  /* ====== getter ======*/
  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Integer getId() {
    return id;
  }

  public String getAvatarName() {
    return avatarName;
  }

  public Integer getGenderType() {
    return genderType;
  }

  public Integer getIsShow() {
    return isShow;
  }

  public Timestamp getCreatetime() {
    return createtime;
  }

  public Timestamp getUpdatetime() {
    return updatetime;
  }
  /* ====== setter ======*/
  public void setId(Integer id) {
    this.id = id;
  }

  public void setAvatarName(String avatarName) {
    this.avatarName = avatarName;
  }

  public void setGenderType(Integer genderType) {
    this.genderType = genderType;
  }

  public void setIsShow(Integer isShow) {
    this.isShow = isShow;
  }

  public void setCreatetime(Timestamp createtime) {
    this.createtime = createtime;
  }

  public void setUpdatetime(Timestamp updatetime) {
    this.updatetime = updatetime;
  }
}
