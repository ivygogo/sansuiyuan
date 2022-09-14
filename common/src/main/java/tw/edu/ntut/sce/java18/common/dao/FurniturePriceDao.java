package tw.edu.ntut.sce.java18.common.dao;

import java.util.List;
import tw.edu.ntut.sce.java18.common.model.FurniturePriceBean;

public interface FurniturePriceDao {

  List<FurniturePriceBean> getAllFurniturePrice();

  List<String> getAllFurnitureName();
}
