package tw.edu.ntut.sce.java18.common.service;

import tw.edu.ntut.sce.java18.common.dao.impl.RentDao;
import tw.edu.ntut.sce.java18.common.dao.impl.RentDaoImpl;
import tw.edu.ntut.sce.java18.common.model.RentBean;

public class RentService {
  RentDao dao = null;

  public RentService() {
    dao = new RentDaoImpl();
  }

  public RentBean select(String Idnumber) {
    return dao.select(Idnumber);
  }
}
