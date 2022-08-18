package tw.edu.ntut.sce.java18.common.controller.converter;

import tw.edu.ntut.sce.java18.common.controller.model.RoomTypeControllerBean;
import tw.edu.ntut.sce.java18.common.model.RoomTypeServiceBean;

public class RoomTypeConverter {

  public RoomTypeControllerBean convert(RoomTypeServiceBean src) {
    var roomType = new RoomTypeControllerBean();

    roomType.setType(src.getType());

    var bed = src.getBed();
    roomType.setBed(bed.getDisplayName() + "<br/> * " + bed.getQuantity());

    return roomType;
  }
}
