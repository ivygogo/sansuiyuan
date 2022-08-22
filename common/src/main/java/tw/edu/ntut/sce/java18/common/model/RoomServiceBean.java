package tw.edu.ntut.sce.java18.common.model;

import java.util.ArrayList;

public class RoomServiceBean {

  ArrayList<Integer> availableFloor;
  Long lest;

  public ArrayList<Integer> getAvailableFloor() {
    return availableFloor;
  }

  public void setAvailableFloor(ArrayList<Integer> availableFloor) {
    this.availableFloor = availableFloor;
  }

  public Long getLest() {
    return lest;
  }

  public void setLest(Long lest) {
    this.lest = lest;
  }
}
