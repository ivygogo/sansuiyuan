package tw.edu.ntut.sce.java18.common.model;

public class RoomTypeServiceBean {
  private String type;
  private String name;
  private int chair;
  private Bed bed;
  private Desk desk;
  private SideTable sideTable;
  private int wardrobe;
  private String size;
  private double price;
  private boolean balcony;
  private String[] pics;
  private int total;

  public RoomTypeServiceBean() {}

  public void setType(String type) {
    this.type = type;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setChair(int chair) {
    this.chair = chair;
  }

  public void setBed(Bed bed) {
    this.bed = bed;
  }

  public void setDesk(Desk desk) {
    this.desk = desk;
  }

  public void setSideTable(SideTable sideTable) {
    this.sideTable = sideTable;
  }

  public void setWardrobe(int wardrobe) {
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

  public void setTotal(int total) {
    this.total = total;
  }

  public String getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public int getChair() {
    return chair;
  }

  public Bed getBed() {
    return bed;
  }

  public Desk getDesk() {
    return desk;
  }

  public SideTable getSideTable() {
    return sideTable;
  }

  public int getWardrobe() {
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

  public int getTotal() {
    return total;
  }

  public static class Bed {
    String name;
    int quantity;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getQuantity() {
      return quantity;
    }

    public void setQuantity(int quantity) {
      this.quantity = quantity;
    }
  }

  public static class Desk {
    String name;
    int quantity;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getQuantity() {
      return quantity;
    }

    public void setQuantity(int quantity) {
      this.quantity = quantity;
    }
  }

  public static class SideTable {
    String name;
    int quantity;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getQuantity() {
      return quantity;
    }

    public void setQuantity(int quantity) {
      this.quantity = quantity;
    }
  }
}
