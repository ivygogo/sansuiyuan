package tw.edu.ntut.sce.java18.common.service;

import tw.edu.ntut.sce.java18.common.dao.RoomTypeStatusDao;
import tw.edu.ntut.sce.java18.common.dao.impl.RoomTypeStatusDaoImpl;
import tw.edu.ntut.sce.java18.common.model.ContractStatusBean;

public class RoomTypeStatusService {
  RoomTypeStatusDao dao;

  public RoomTypeStatusService() {
    dao = new RoomTypeStatusDaoImpl();
  }

  public ContractStatusBean queryRoomTypeStatus(String roomNumber) {
    return dao.queryRoomTypeStatus(roomNumber);
  }
}
