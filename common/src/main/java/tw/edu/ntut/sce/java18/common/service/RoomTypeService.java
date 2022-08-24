package tw.edu.ntut.sce.java18.common.service;

import tw.edu.ntut.sce.java18.common.dao.RoomTypeDao;
import tw.edu.ntut.sce.java18.common.dao.impl.RoomTypeDaoImpl_JDBC;
import tw.edu.ntut.sce.java18.common.model.RoomTypeServiceBean;

public class RoomTypeService {
  RoomTypeDao dao;

  public RoomTypeService() {
    dao = new RoomTypeDaoImpl_JDBC();
  }

  public RoomTypeServiceBean queryRoomType(String type) {

    var roomTypeBean = dao.queryRoomTypeInfo(type);
    return new RoomTypeServiceConverter().convert(roomTypeBean);
  }
}
