package tw.edu.ntut.sce.java18.common.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class CharacterAndFavorBean implements Serializable {
  private static final long serialVersionUID = 1L;
  Integer id;
  Integer type;
  String name;
  Integer isShow;
  Timestamp createtime;
  Timestamp update_time;
  Timestamp delete_time;

  /* ====== 建構子 ======*/
  public CharacterAndFavorBean() {}

  /* ====== getter ======*/
  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Integer getId() {
    return id;
  }

  public Integer getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public Integer getIsShow() {
    return isShow;
  }

  public Timestamp getCreatetime() {
    return createtime;
  }

  public Timestamp getUpdate_time() {
    return update_time;
  }

  public Timestamp getDelete_time() {
    return delete_time;
  }

  /* ====== setter ======*/

  public void setId(Integer id) {
    this.id = id;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setIsShow(Integer isShow) {
    this.isShow = isShow;
  }

  public void setCreatetime(Timestamp createtime) {
    this.createtime = createtime;
  }

  public void setUpdate_time(Timestamp update_time) {
    this.update_time = update_time;
  }

  public void setDelete_time(Timestamp delete_time) {
    this.delete_time = delete_time;
  }
}
