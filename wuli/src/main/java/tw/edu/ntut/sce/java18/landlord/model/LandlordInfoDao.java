package tw.edu.ntut.sce.java18.landlord.model;

public interface LandlordInfoDao {

  LandlordInfo queryLandlordInfoByPrimaryKey(int id);

  public int updateLandlordInfo(LandlordInfo landlordInfo);
}
