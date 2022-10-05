package tw.edu.ntut.sce.java18.landlord.service;

import java.util.List;
import java.util.Map;
import tw.edu.ntut.sce.java18.landlord.model.LandlordBeanM;

public interface LandlordService_Mvc {
  LandlordBeanM queryLandlordInfoByPrimaryKey(int id);

  void updateLandlordInfo(LandlordBeanM landlordInfo);

  LandlordBeanM findByPrimaryKey(int key);

  LandlordBeanM findByName(String name);

  int saveLandlord(LandlordBeanM landlordInfo);

  void updateLandlord(LandlordBeanM landlordInfo);

  void deleteLandlordByPrimaryKey(int key);

  List<LandlordBeanM> findAllLandlords();

  void deleteLandlord();

  boolean isLandlordExist(LandlordBeanM landlordInfo);

  String checkLandlordId(String memberId);

  void evictLandlord(LandlordBeanM landlordInfo);

  Map<String, String> getErrorMsgs(LandlordBeanM newBean);
}
