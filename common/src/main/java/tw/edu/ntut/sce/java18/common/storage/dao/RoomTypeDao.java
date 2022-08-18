package tw.edu.ntut.sce.java18.common.storage.dao;

import tw.edu.ntut.sce.java18.common.storage.model.RoomTypeBean;

public interface RoomTypeDao {

  RoomTypeBean queryRoomType(String type);
}
