package tw.edu.ntut.sce.java18.landlord.model;

import java.io.Serializable;

public class ContractRoom_TypeItemsBean implements Serializable {

  private static final long serialVersionUID = 1L;
  String Room_Type;
  Integer TV;
  Integer WaterHeater;
  Integer Airconditioner;
  Integer Freezer;
  Integer Screen;
  Integer Chair;
  Integer SingleBed;
  Integer DoubleBed;
  Integer SmallDesk;
  Integer BigDesk;
  Integer SmallSideTable;
  Integer BigSideTable;
  Integer Wardrobe;

  public ContractRoom_TypeItemsBean() {}

  public ContractRoom_TypeItemsBean(
      String room_Type,
      Integer tV,
      Integer waterHeater,
      Integer airconditioner,
      Integer freezer,
      Integer screen,
      Integer chair,
      Integer singleBed,
      Integer doubleBed,
      Integer smallDesk,
      Integer bigDesk,
      Integer smallSideTable,
      Integer bigSideTable,
      Integer wardrobe) {
    super();
    Room_Type = room_Type;
    TV = tV;
    WaterHeater = waterHeater;
    Airconditioner = airconditioner;
    Freezer = freezer;
    Screen = screen;
    Chair = chair;
    SingleBed = singleBed;
    DoubleBed = doubleBed;
    SmallDesk = smallDesk;
    BigDesk = bigDesk;
    SmallSideTable = smallSideTable;
    BigSideTable = bigSideTable;
    Wardrobe = wardrobe;
  }

  public String getRoom_Type() {
    return Room_Type;
  }

  public void setRoom_Type(String room_Type) {
    Room_Type = room_Type;
  }

  public Integer getTV() {
    return TV;
  }

  public void setTV(Integer tV) {
    TV = tV;
  }

  public Integer getWaterHeater() {
    return WaterHeater;
  }

  public void setWaterHeater(Integer waterHeater) {
    WaterHeater = waterHeater;
  }

  public Integer getAirconditioner() {
    return Airconditioner;
  }

  public void setAirconditioner(Integer airconditioner) {
    Airconditioner = airconditioner;
  }

  public Integer getFreezer() {
    return Freezer;
  }

  public void setFreezer(Integer freezer) {
    Freezer = freezer;
  }

  public Integer getScreen() {
    return Screen;
  }

  public void setScreen(Integer screen) {
    Screen = screen;
  }

  public Integer getChair() {
    return Chair;
  }

  public void setChair(Integer chair) {
    Chair = chair;
  }

  public Integer getSingleBed() {
    return SingleBed;
  }

  public void setSingleBed(Integer singleBed) {
    SingleBed = singleBed;
  }

  public Integer getDoubleBed() {
    return DoubleBed;
  }

  public void setDoubleBed(Integer doubleBed) {
    DoubleBed = doubleBed;
  }

  public Integer getSmallDesk() {
    return SmallDesk;
  }

  public void setSmallDesk(Integer smallDesk) {
    SmallDesk = smallDesk;
  }

  public Integer getBigDesk() {
    return BigDesk;
  }

  public void setBigDesk(Integer bigDesk) {
    BigDesk = bigDesk;
  }

  public Integer getSmallSideTable() {
    return SmallSideTable;
  }

  public void setSmallSideTable(Integer smallSideTable) {
    SmallSideTable = smallSideTable;
  }

  public Integer getBigSideTable() {
    return BigSideTable;
  }

  public void setBigSideTable(Integer bigSideTable) {
    BigSideTable = bigSideTable;
  }

  public Integer getWardrobe() {
    return Wardrobe;
  }

  public void setWardrobe(Integer wardrobe) {
    Wardrobe = wardrobe;
  }
}
