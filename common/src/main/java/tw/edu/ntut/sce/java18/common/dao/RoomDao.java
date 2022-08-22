package tw.edu.ntut.sce.java18.common.dao;

import java.util.ArrayList;
import java.util.Map;
import tw.edu.ntut.sce.java18.common.model.RoomBean;

public interface RoomDao {

  Map<Integer, Long> getAvailableFloorCount(String type);

  ArrayList<String> getEmptyRoom();

  RoomBean queryRoom(String sql);

  // 預計參數型態使用ContractBean
  void updateRoom();

  void newRoom();
}
