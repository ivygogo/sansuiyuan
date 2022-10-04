package tw.edu.ntut.sce.java18.landlord.service;

import java.sql.SQLException;
import tw.edu.ntut.sce.java18.landlord.dao.LandlordInfoDao;
import tw.edu.ntut.sce.java18.landlord.dao.impl.LandlordInfoDaoImpl;
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

  public LandlordInfo checkIdPassword(String mail, String password) throws SQLException {
    LandlordInfo landlordInfo = landlordInfoDao.checkIdPassword(mail, password);
    return landlordInfo;
  }
}
