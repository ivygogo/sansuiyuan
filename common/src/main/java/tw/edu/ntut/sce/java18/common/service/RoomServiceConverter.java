package tw.edu.ntut.sce.java18.common.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import tw.edu.ntut.sce.java18.common.model.RoomServiceBean;

public class RoomServiceConverter {

  public RoomServiceBean convertAvailableFloorTotal(Map<Integer, Long> availableFloorCount) {

    RoomServiceBean roomServiceBean = new RoomServiceBean();
    ArrayList<Integer> availableFloorList = new ArrayList<>();

    AtomicReference<Long> longAtomicReference =
        new AtomicReference<>(0L); // 要把變數丟數lambda需要使用AtomicReference
    availableFloorCount.entrySet().stream()
        .filter(f -> f.getValue() > 0)
        .forEach(
            (f -> {
              availableFloorList.add(f.getKey());
              longAtomicReference.updateAndGet(v -> v + f.getValue());
            }));
    Long lest = longAtomicReference.get();

    roomServiceBean.setAvailableFloor(availableFloorList);
    roomServiceBean.setLest(lest);
    return roomServiceBean;
  }
}
