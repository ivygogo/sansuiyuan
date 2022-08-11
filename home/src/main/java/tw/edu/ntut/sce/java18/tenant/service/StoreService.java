package tw.edu.ntut.sce.java18.tenant.service;

import java.util.List;
import tw.edu.ntut.sce.java18.tenant.dao.StoreDao;
import tw.edu.ntut.sce.java18.tenant.dao.StoreJDBCDao;
import tw.edu.ntut.sce.java18.tenant.model.Store;

public class StoreService {

  private final StoreDao storeDao = new StoreJDBCDao();

  public List<Store> getStores() {
    return storeDao.getStores();
  }
}
