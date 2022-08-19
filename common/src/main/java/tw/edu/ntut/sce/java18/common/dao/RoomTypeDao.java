package tw.edu.ntut.sce.java18.common.dao;

import tw.edu.ntut.sce.java18.common.model.RoomTypeBean;

public interface RoomTypeDao {

  RoomTypeBean queryRoomTypeInfo(String type);

  RoomTypeBean updateRoomTypeInfo(String type);
}
