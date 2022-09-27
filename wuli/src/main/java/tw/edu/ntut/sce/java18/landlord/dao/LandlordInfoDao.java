package tw.edu.ntut.sce.java18.landlord.dao;

import tw.edu.ntut.sce.java18.landlord.model.LandlordInfo;

public interface LandlordInfoDao {

  LandlordInfo queryLandlordInfoByPrimaryKey(int id);

  public int updateLandlordInfo(LandlordInfo landlordInfo);
}
