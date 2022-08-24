package tw.edu.ntut.sce.java18.common.model;

import java.util.ArrayList;

public class RoomServiceBean {

  ArrayList<Integer> availableFloor;
  Integer lest;

  public ArrayList<Integer> getAvailableFloor() {
    return availableFloor;
  }

  public void setAvailableFloor(ArrayList<Integer> availableFloor) {
    this.availableFloor = availableFloor;
  }

  public Integer getLest() {
    return lest;
  }

  public void setLest(Integer lest) {
    this.lest = lest;
  }
}
