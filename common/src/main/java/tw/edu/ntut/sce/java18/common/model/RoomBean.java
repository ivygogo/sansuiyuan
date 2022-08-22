package tw.edu.ntut.sce.java18.common.model;

public class RoomBean {
  Integer id;
  String roomId;
  String building;
  Integer floor;
  String location;
  String roomType;
  String tenantId;
  String contractId;

  public RoomBean() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRoomId() {
    return roomId;
  }

  public void setRoomId(String roomId) {
    this.roomId = roomId;
  }

  public String getBuilding() {
    return building;
  }

  public void setBuilding(String building) {
    this.building = building;
  }

  public int getFloor() {
    return floor;
  }

  public void setFloor(int floor) {
    this.floor = floor;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getRoomType() {
    return roomType;
  }

  public void setRoomType(String roomType) {
    this.roomType = roomType;
  }

  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }

  public String getContractId() {
    return contractId;
  }

  public void setContractId(String contractId) {
    this.contractId = contractId;
  }
}
