package tw.edu.ntut.sce.java18.tenant.findFriend.model;

import java.util.List;

public class FriendBean {
  Integer id;
  String name;
  String school;
  String avatar;
  Integer gender;
  List<String> signatures;
  List<String> favors;

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSchool() {
    return school;
  }

  public String getAvatar() {
    return avatar;
  }

  public Integer getGender() {
    return gender;
  }

  public List<String> getSignatures() {
    return signatures;
  }

  public List<String> getFavors() {
    return favors;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public void setSignatures(List<String> signatures) {
    this.signatures = signatures;
  }

  public void setFavors(List<String> favors) {
    this.favors = favors;
  }
}
