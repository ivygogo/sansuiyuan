package tw.edu.ntut.sce.java18.common.controller;

import tw.edu.ntut.sce.java18.common.model.RoomTypeServiceBean;
import tw.edu.ntut.sce.java18.common.model.RoomTypeServletBean;

public class RoomTypeServletConverter {

  public RoomTypeServletBean convert(RoomTypeServiceBean src) {
    var roomType = new RoomTypeServletBean();
    roomType.setPrice(src.getPrice());
    roomType.setType(src.getType());
    roomType.setBalcony(src.getBalcony());
    roomType.setName(src.getName());
    roomType.setSize(src.getSize());
    roomType.setChair("椅子 <br/> * " + src.getChair());
    roomType.setWardrobe("衣櫃 <br/> * " + src.getWardrobe());
    roomType.setPics(src.getPics());

    roomType.setBed(src.getBed().getName() + "<br/> * " + src.getBed().getQuantity());
    roomType.setDesk(src.getDesk().getName() + "<br/> * " + src.getDesk().getQuantity());
    roomType.setSideTable(
        src.getSideTable().getName() + "<br/> *" + src.getSideTable().getQuantity());

    roomType.setRest(src.getTotal());
    int[] arrAvailableFloorA = {1, 3, 8};
    roomType.setAvailableFloors(arrAvailableFloorA);

    return roomType;
  }
}
