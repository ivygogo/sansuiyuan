package tw.edu.ntut.sce.java18.common.storage.converter;

import tw.edu.ntut.sce.java18.common.model.RoomTypeServiceBean;
import tw.edu.ntut.sce.java18.common.model.RoomTypeServiceBean.Bed;
import tw.edu.ntut.sce.java18.common.storage.model.RoomTypeBean;

public class RoomTypeConverter {

  public RoomTypeServiceBean convert(RoomTypeBean roomTypeBean) {
    RoomTypeServiceBean roomTypeServiceBean = new RoomTypeServiceBean();
    String desk, sideTable;

    roomTypeServiceBean.setPrice(roomTypeBean.getPrice());
    roomTypeServiceBean.setType(roomTypeBean.getType());
    roomTypeServiceBean.setBalcony(roomTypeBean.getBalcony());
    roomTypeServiceBean.setName(roomTypeBean.getName());
    roomTypeServiceBean.setSize(roomTypeBean.getSize());
    roomTypeServiceBean.setChair("椅子 * " + roomTypeBean.getQ_Chair());
    roomTypeServiceBean.setChair("椅子 * " + roomTypeBean.getQ_Chair());
    roomTypeServiceBean.setWardrobe("衣櫃 * " + roomTypeBean.getQ_Wardrobe());

    int total = roomTypeBean.getTotal();
    roomTypeServiceBean.setTotal(total);

    var bed = new Bed();
    if (roomTypeBean.getQ_Bed_S() != 0) {
      bed.setDisplayName("單人床");
      bed.setQuantity(roomTypeBean.getQ_Bed_S());
    } else {
      bed.setDisplayName("雙人床");
      bed.setQuantity(roomTypeBean.getQ_Bed_L());
    }
    roomTypeServiceBean.setBed(bed);

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

    //    roomTypeServiceBean.setBed(bed);
    roomTypeServiceBean.setDesk(desk);
    roomTypeServiceBean.setSideTable(sideTable);
    roomTypeServiceBean.setPics(arrPics);
    roomTypeServiceBean.setAvailableFloors(arrAvailableFloorA);
    return roomTypeServiceBean;
  }
}
