package tw.edu.ntut.sce.java18.common.service;

import tw.edu.ntut.sce.java18.common.model.RoomTypeBean;
import tw.edu.ntut.sce.java18.common.model.RoomTypeServiceBean;
import tw.edu.ntut.sce.java18.common.model.RoomTypeServiceBean.Bed;
import tw.edu.ntut.sce.java18.common.model.RoomTypeServiceBean.Desk;
import tw.edu.ntut.sce.java18.common.model.RoomTypeServiceBean.SideTable;

public class RoomTypeServiceConverter {

  public RoomTypeServiceBean convert(RoomTypeBean src) {
    var roomType = new RoomTypeServiceBean();
    roomType.setPrice(src.getPrice());
    roomType.setType(src.getType());
    roomType.setBalcony(src.isBalcony());
    roomType.setName(src.getName());
    roomType.setSize(src.getSize());
    roomType.setWardrobe(src.getWardrobe());
    roomType.setTotal(src.getTotal());
    roomType.setChair(src.getChair());

    roomType.setBed(convertBed(src));
    roomType.setDesk(convertDesk(src));
    roomType.setSideTable(convertSideTable(src));

    String[] arrPics = {src.getPic1(), src.getPic2(), src.getPic3()};
    roomType.setPics(arrPics);
    return roomType;
  }

  private SideTable convertSideTable(RoomTypeBean src) {
    SideTable sideTable = new SideTable();
    if (src.getSideTableS() != 0) {
      sideTable.setName("(小)床頭櫃");
      sideTable.setQuantity(src.getSideTableS());
    } else {
      sideTable.setName("(大)床頭櫃");
      sideTable.setQuantity(src.getSideTableL());
    }
    return sideTable;
  }

  private Bed convertBed(RoomTypeBean src) {
    Bed bed = new Bed();
    if (src.getBedS() != 0) {
      bed.setName("單人床");
      bed.setQuantity(src.getBedS());
    } else {
      bed.setName("雙人床");
      bed.setQuantity(src.getBedL());
    }
    return bed;
  }

  private Desk convertDesk(RoomTypeBean src) {
    Desk desk = new Desk();
    if (src.getDeskS() != 0) {
      desk.setName("(小)書桌");
      desk.setQuantity(src.getDeskS());
    } else {
      desk.setName("(大)書桌");
      desk.setQuantity(src.getDeskL());
    }
    return desk;
  }
}
