package tw.edu.ntut.sce.java18.common.service;

import java.util.Map;
import tw.edu.ntut.sce.java18.common.dao.RoomTypeDao;
import tw.edu.ntut.sce.java18.common.dao.impl.RoomTypeDaoImpl_JDBC;
import tw.edu.ntut.sce.java18.common.model.RoomTypeBean;
import tw.edu.ntut.sce.java18.common.model.RoomTypeServiceBean;

public class RoomTypeService {

  RoomTypeDao dao;

  public RoomTypeService() {
    dao = new RoomTypeDaoImpl_JDBC();
  }

  public Map<String, RoomTypeServiceBean> createRoomTypeObject(String type) {
    RoomTypeBean roomTypeBean = dao.queryRoomType(type);
    RoomTypeServiceBean roomTypeDaoService = new RoomTypeConverter().convert(roomTypeBean);

    return Map.of(roomTypeDaoService.getType(), roomTypeDaoService);
  }
}
