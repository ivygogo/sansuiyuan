package tw.edu.ntut.sce.java18.landlord.service;

import tw.edu.ntut.sce.java18.landlord.model.LandlordInfo;
import tw.edu.ntut.sce.java18.landlord.model.LandlordInfoDao;
import tw.edu.ntut.sce.java18.landlord.model.impl.LandlordInfoDaoImpl;

public class LanlordInfoService {
  LandlordInfoDao landlordInfoDao;

  public LanlordInfoService() {

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
