package tw.edu.ntut.sce.java18.common.service;

import tw.edu.ntut.sce.java18.common.dao.RoomDao;
import tw.edu.ntut.sce.java18.common.dao.impl.RoomDaoImpl_JDBC;
import tw.edu.ntut.sce.java18.common.model.RoomServiceBean;

public class RoomService {
  RoomDao dao;

  public RoomService() {
    dao = new RoomDaoImpl_JDBC();
  }

  public RoomServiceBean queryAvailableFloorCount(String type) {
    var availableFloorCount = dao.getAvailableFloorCount(type);
    var roomServiceBean =
        new RoomServiceConverter().convertAvailableFloorTotal(availableFloorCount);
    return roomServiceBean;
  }
}
