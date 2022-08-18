package tw.edu.ntut.sce.java18.common.service;

import tw.edu.ntut.sce.java18.common.dao.RoomTypeDao;
import tw.edu.ntut.sce.java18.common.dao.impl.RoomTypeDaoImpl_JDBC;
import tw.edu.ntut.sce.java18.common.model.RoomTypeBean;
import tw.edu.ntut.sce.java18.common.model.RoomTypeServiceBean;

public class RoomTypeService {

  private final RoomTypeConverter roomTypeConverter;
  RoomTypeDao dao;

  public RoomTypeService() {
    dao = new RoomTypeDaoImpl_JDBC();
    roomTypeConverter = new RoomTypeConverter();
  }

  public RoomTypeServiceBean queryRoomType(String type) {
    RoomTypeBean roomTypeBean = dao.queryRoomType(type);
    return roomTypeConverter.convert(roomTypeBean);
  }
}
