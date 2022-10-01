package tw.edu.ntut.sce.java18.common.dao;

import tw.edu.ntut.sce.java18.common.model.ContractStatusBean;

public interface RoomTypeStatusDao {

  ContractStatusBean queryRoomTypeStatus(String roomNumber);
}
