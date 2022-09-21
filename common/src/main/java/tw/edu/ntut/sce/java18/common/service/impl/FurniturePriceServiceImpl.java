package tw.edu.ntut.sce.java18.common.service.impl;

import java.util.List;
import tw.edu.ntut.sce.java18.common.dao.FurniturePriceDao;
import tw.edu.ntut.sce.java18.common.dao.impl.FurniturePriceDaoImpl;
import tw.edu.ntut.sce.java18.common.model.FurniturePriceBean;
import tw.edu.ntut.sce.java18.common.service.FurniturePriceService;

public class FurniturePriceServiceImpl implements FurniturePriceService {
  FurniturePriceDao furniturePriceDao;

  public FurniturePriceServiceImpl() {
    furniturePriceDao = new FurniturePriceDaoImpl();
  }

  @Override
  public List<FurniturePriceBean> getAllFurniturePrice() {
    return furniturePriceDao.getAllFurniturePrice();
  }

  @Override
  public List<String> getAllFurnitureName() {
    return furniturePriceDao.getAllFurnitureName();
  }

  @Override
  public int getFurnitureIdByName(String name) {
    // TODO Auto-generated method stub
    return furniturePriceDao.getFurnitureIdByName(name);
  }
}
