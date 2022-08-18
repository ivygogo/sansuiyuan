package tw.edu.ntut.sce.java18.common.storage;

import tw.edu.ntut.sce.java18.common.model.RoomTypeServiceBean;
import tw.edu.ntut.sce.java18.common.storage.converter.RoomTypeConverter;
import tw.edu.ntut.sce.java18.common.storage.dao.RoomTypeDao;
import tw.edu.ntut.sce.java18.common.storage.dao.impl.RoomTypeDaoImpl_JDBC;
import tw.edu.ntut.sce.java18.common.storage.model.RoomTypeBean;

public class RoomTypeStorage {

  private final RoomTypeDao dao;
  private final RoomTypeConverter roomTypeConverter;

  public RoomTypeStorage() {
    dao = new RoomTypeDaoImpl_JDBC();
    roomTypeConverter = new RoomTypeConverter();
  }

  public RoomTypeServiceBean queryRoomType(String type) {
    RoomTypeBean roomTypeBean = dao.queryRoomType(type);
    return roomTypeConverter.convert(roomTypeBean);
  }
}
