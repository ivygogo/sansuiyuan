package tw.edu.ntut.sce.java18.common.service;

import tw.edu.ntut.sce.java18.common.model.RoomTypeBean;
import tw.edu.ntut.sce.java18.common.model.RoomTypeServiceBean;

public class RoomTypeDaoService {

  public RoomTypeServiceBean roomTypeDaoService(RoomTypeBean roomTypeBean) {
    RoomTypeServiceBean roomTypeServiceBean = new RoomTypeServiceBean();
    String bed, desk, sideTable;

    roomTypeServiceBean.setPrice(roomTypeBean.getPrice());
    roomTypeServiceBean.setType(roomTypeBean.getType());
    roomTypeServiceBean.setBalcony(roomTypeBean.getBalcony());
    roomTypeServiceBean.setName(roomTypeBean.getName());
    roomTypeServiceBean.setSize(roomTypeBean.getSize());
    roomTypeServiceBean.setChair("椅子 * " + roomTypeBean.getQ_Chair());
    roomTypeServiceBean.setChair("椅子 * " + roomTypeBean.getQ_Chair());
    roomTypeServiceBean.setWardrobe("衣櫃 * " + roomTypeBean.getQ_Wardrobe());

    int rest = roomTypeBean.getTotal() - 0;
    if (roomTypeBean.getQ_Bed_S() != 0) {
      bed = "單人床 * " + roomTypeBean.getQ_Bed_S();
    } else {
      bed = "雙人床 * " + roomTypeBean.getQ_Bed_L();
    }

    if (roomTypeBean.getQ_Desk_S() != 0) {
      desk = "3.5呎桌子 * " + roomTypeBean.getQ_Desk_S();
    } else {
      desk = "5呎桌子 * " + roomTypeBean.getQ_Desk_L();
    }

    if (roomTypeBean.getQ_Side_Table_S() != 0) {
      sideTable = "3.5呎床頭櫃 * " + roomTypeBean.getQ_Side_Table_S();
    } else {
      sideTable = "5呎床頭櫃 * " + roomTypeBean.getQ_Side_Table_L();
    }
    String[] arrPics = {roomTypeBean.getPic1(), roomTypeBean.getPic2(), roomTypeBean.getPic3()};
    int[] arrAvailableFloorA = {1, 3, 8};

    roomTypeServiceBean.setRest(rest);
    roomTypeServiceBean.setBed(bed);
    roomTypeServiceBean.setDesk(desk);
    roomTypeServiceBean.setSideTable(sideTable);
    roomTypeServiceBean.setPics(arrPics);
    roomTypeServiceBean.setAvailableFloors(arrAvailableFloorA);
    return roomTypeServiceBean;
  }
}
