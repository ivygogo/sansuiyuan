package tw.edu.ntut.sce.java18.common.service;

import java.util.List;
import tw.edu.ntut.sce.java18.common.model.FurniturePriceBean;

public interface FurniturePriceService {

  List<FurniturePriceBean> getAllFurniturePrice();

  List<String> getAllFurnitureName();
}
