package tw.edu.ntut.sce.java18.common.model;

import java.util.ArrayList;

public class RoomTypeServletBean {
  private String type;
  private String name;
  private String chair;
  private String bed;
  private String desk;
  private String sideTable;
  private String wardrobe;
  private String size;
  private double price;
  private boolean balcony;
  private String[] pics;
  private int rest;
  private ArrayList<Integer> availableFloors;

  public RoomTypeServletBean() {}

  public void setType(String type) {
    this.type = type;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setChair(String chair) {
    this.chair = chair;
  }

  public void setBed(String bed) {
    this.bed = bed;
  }

  public void setDesk(String desk) {
    this.desk = desk;
  }

  public void setSideTable(String sideTable) {
    this.sideTable = sideTable;
  }

  public void setWardrobe(String wardrobe) {
    this.wardrobe = wardrobe;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setBalcony(boolean balcony) {
    this.balcony = balcony;
  }

  public void setPics(String[] pics) {
    this.pics = pics;
  }

  public void setRest(int rest) {
    this.rest = rest;
  }

  public void setAvailableFloors(ArrayList<Integer> availableFloors) {
    this.availableFloors = availableFloors;
  }

  public String getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public String getChair() {
    return chair;
  }

  public String getBed() {
    return bed;
  }

  public String getDesk() {
    return desk;
  }

  public String getSideTable() {
    return sideTable;
  }

  public String getWardrobe() {
    return wardrobe;
  }

  public String getSize() {
    return size;
  }

  public double getPrice() {
    return price;
  }

  public boolean getBalcony() {
    return balcony;
  }

  public String[] getPics() {
    return pics;
  }

  public int getRest() {
    return rest;
  }

  public ArrayList<Integer> getAvailableFloors() {
    return availableFloors;
  }
}
