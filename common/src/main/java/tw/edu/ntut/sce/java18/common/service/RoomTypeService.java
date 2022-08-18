package tw.edu.ntut.sce.java18.common.service;

import tw.edu.ntut.sce.java18.common.model.RoomTypeServiceBean;
import tw.edu.ntut.sce.java18.common.storage.RoomTypeStorage;

public class RoomTypeService {

  private final RoomTypeStorage roomTypeStorage;

  public RoomTypeService() {
    roomTypeStorage = new RoomTypeStorage();
  }

  public RoomTypeServiceBean queryRoomType(String type) {
    RoomTypeServiceBean roomType = roomTypeStorage.queryRoomType(type);
    int rentCount = 查詢已出租房間數();
    roomType.setRest(roomType.getTotal() - rentCount);
    return roomType;
  }

  // TODO
  private int 查詢已出租房間數() {
    return 10;
  }
}
