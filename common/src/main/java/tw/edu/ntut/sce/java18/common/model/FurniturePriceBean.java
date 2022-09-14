package tw.edu.ntut.sce.java18.common.model;

public class FurniturePriceBean {
  int id;
  String name;
  int price;
  String nameAlias;

  public FurniturePriceBeam() {}

  public FurniturePriceBeam(int id, String name, int price, String nameAlias) {
    super();
    this.id = id;
    this.name = name;
    this.price = price;
    this.nameAlias = nameAlias;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getNameAlias() {
    return nameAlias;
  }

  public void setNameAlias(String nameAlias) {
    this.nameAlias = nameAlias;
  }
}
