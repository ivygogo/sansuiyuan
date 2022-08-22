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
    roomType.setBalcony(src.getBalcony());
    roomType.setName(src.getName());
    roomType.setSize(src.getSize());
    roomType.setWardrobe(src.getQWardrobe());
    roomType.setTotal(src.getTotal());
    roomType.setChair(src.getQChair());

    roomType.setBed(convertBed(src));
    roomType.setDesk(convertDesk(src));
    roomType.setSideTable(convertSideTable(src));

    String[] arrPics = {src.getPic1(), src.getPic2(), src.getPic3()};
    roomType.setPics(arrPics);
    return roomType;
  }

  private SideTable convertSideTable(RoomTypeBean src) {
    SideTable sideTable = new SideTable();
    if (src.getQSideTableS() != 0) {
      sideTable.setName("小床頭櫃");
      sideTable.setPrice(src.getPSideTableS());
      sideTable.setQuantity(src.getQSideTableS());
    } else {
      sideTable.setName("大床頭櫃");
      sideTable.setPrice(src.getPSideTableL());
      sideTable.setQuantity(src.getQSideTableL());
    }
    return sideTable;
  }

  private Bed convertBed(RoomTypeBean src) {
    Bed bed = new Bed();
    if (src.getQBedS() != 0) {
      bed.setName("單人床");
      bed.setPrice(src.getPBedS());
      bed.setQuantity(src.getQBedS());
      bed.setPriceBedBoard(src.getPBedBoardS());
    } else {
      bed.setName("雙人床");
      bed.setPrice(src.getPBedL());
      bed.setQuantity(src.getQBedL());
      bed.setPriceBedBoard(src.getPBedBoardL());
    }
    return bed;
  }

  private Desk convertDesk(RoomTypeBean src) {
    Desk desk = new Desk();
    if (src.getQDeskS() != 0) {
      desk.setName("小桌子");
      desk.setPrice(src.getPDeskS());
      desk.setQuantity(src.getQDeskS());
    } else {
      desk.setName("大桌子");
      desk.setPrice(src.getPDeskL());
      desk.setQuantity(src.getQDeskL());
    }
    return desk;
  }
}
