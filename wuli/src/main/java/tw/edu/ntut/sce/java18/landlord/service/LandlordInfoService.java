package tw.edu.ntut.sce.java18.landlord.service;

import tw.edu.ntut.sce.java18.landlord.dao.impl.LandlordInfoDaoImpl;
import tw.edu.ntut.sce.java18.landlord.dao.LandlordInfoDao;
import tw.edu.ntut.sce.java18.landlord.model.LandlordInfo;

public class LandlordInfoService {
  LandlordInfoDao landlordInfoDao;

  public LandlordInfoService() {

    landlordInfoDao = new LandlordInfoDaoImpl();
  }

  public LandlordInfo queryLandlordInfoByPrimaryKey(int id) {
    var landlordInfo = landlordInfoDao.queryLandlordInfoByPrimaryKey(id);
    return landlordInfo;
  }

  public int updateLandlordInfo(LandlordInfo landlordInfo) {
    return landlordInfoDao.updateLandlordInfo(landlordInfo);
  }
}
