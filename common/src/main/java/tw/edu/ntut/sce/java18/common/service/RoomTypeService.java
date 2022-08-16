package tw.edu.ntut.sce.java18.common.service;

import java.util.Map;
import tw.edu.ntut.sce.java18.common.dao.RoomTypeDao;
import tw.edu.ntut.sce.java18.common.dao.impl.RoomTypeDaoImpl_JDBC;
import tw.edu.ntut.sce.java18.common.model.RoomTypeBean;

public class RoomTypeService {

  RoomTypeDao dao;

  public RoomTypeService() {
    dao = new RoomTypeDaoImpl_JDBC();
  }

  public RoomTypeBean queryRoomType(String type) {
    return dao.queryRoomType(type);
  }

  //  public RoomTypeService createRoomTypeObject(String type) {
  //    RoomTypeService roomTypeService = new RoomTypeService();
  //
  //    RoomTypeBean roomTypeBean = dao.queryRoomType(type);
  //
  //    Map<String, Objects> info =
  //        new HashMap() {
  //          {
  //            put("availableFloor", roomTypeBean.getAvailableFloor());
  //            put("balcony", roomTypeBean.getBalcony());
  //            put("bed", roomTypeBean.getBed());
  //            put("chair", roomTypeBean.getChair());
  //            put("desk", roomTypeBean.getDesk());
  //            put("name", roomTypeBean.getName());
  //            put("pic", roomTypeBean.getPic());
  //            put("price", roomTypeBean.getPrice());
  //            put("rest", roomTypeBean.getRest());
  //            put("sideTable", roomTypeBean.getSideTable());
  //            put("size", roomTypeBean.getSize());
  //            put("wardrobe", roomTypeBean.getWardrobe());
  //          }
  //        };
  //    roomTypeService.setType(roomTypeBean.getType());
  //    roomTypeService.setInfo(info);
  //
  //    return roomTypeService;
  //  }

  public Map<String, RoomTypeBean> createRoomTypeObject2(String type) {
    RoomTypeBean roomTypeBean = dao.queryRoomType(type);
    return Map.of(roomTypeBean.getType(), roomTypeBean);
  }
}
