package tw.edu.ntut.sce.java18.common.controller;

import tw.edu.ntut.sce.java18.common.model.RoomServiceBean;
import tw.edu.ntut.sce.java18.common.model.RoomTypeServiceBean;
import tw.edu.ntut.sce.java18.common.model.RoomTypeServletBean;

public class RoomTypeServletConverter {

  public RoomTypeServletBean convert(RoomTypeServiceBean srcRoomType, RoomServiceBean srcRoom) {
    var roomType = new RoomTypeServletBean();
    roomType.setPrice(srcRoomType.getPrice());
    roomType.setType(srcRoomType.getType());
    roomType.setBalcony(srcRoomType.getBalcony());
    roomType.setName(srcRoomType.getName());
    roomType.setSize(srcRoomType.getSize());
    roomType.setChair("椅子 <br/> * " + srcRoomType.getChair());
    roomType.setWardrobe("衣櫃 <br/> * " + srcRoomType.getWardrobe());
    roomType.setPics(srcRoomType.getPics());

    roomType.setBed(
        srcRoomType.getBed().getName() + "<br/> * " + srcRoomType.getBed().getQuantity());
    roomType.setDesk(
        srcRoomType.getDesk().getName() + "<br/> * " + srcRoomType.getDesk().getQuantity());
    roomType.setSideTable(
        srcRoomType.getSideTable().getName()
            + "<br/> *"
            + srcRoomType.getSideTable().getQuantity());
    roomType.setRest(srcRoom.getLest().intValue());
    roomType.setAvailableFloors(srcRoom.getAvailableFloor());

    return roomType;
  }
}
