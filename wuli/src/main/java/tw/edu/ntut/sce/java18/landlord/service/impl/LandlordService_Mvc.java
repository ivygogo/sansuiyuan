package tw.edu.ntut.sce.java18.landlord.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.edu.ntut.sce.java18.landlord.dao.LandlordDao_Mvc;
import tw.edu.ntut.sce.java18.landlord.model.LandlordBeanM;

@Transactional
@Service
public class LandlordService_Mvc
    implements tw.edu.ntut.sce.java18.landlord.service.LandlordService_Mvc {
  LandlordDao_Mvc landlordInfoDao;

  @Autowired
  public LandlordService_Mvc(LandlordDao_Mvc landlordInfoDao) {
    this.landlordInfoDao = landlordInfoDao;
  }

  @Override
  public LandlordBeanM queryLandlordInfoByPrimaryKey(int id) {
    return landlordInfoDao.queryLandlordInfoByPrimaryKey(id);
  }

  @Override
  public void updateLandlordInfo(LandlordBeanM landlordInfo) {
    landlordInfoDao.updateLandlordInfo(landlordInfo);
  }

  @Override
  public LandlordBeanM findByPrimaryKey(int key) {
    return landlordInfoDao.findByPrimaryKey(key);
  }

  @Override
  public LandlordBeanM findByName(String name) {
    return landlordInfoDao.findByName(name);
  }

  @Override
  public int saveLandlord(LandlordBeanM landlordInfo) {
    return landlordInfoDao.saveLandlord(landlordInfo);
  }

  @Override
  public void updateLandlord(LandlordBeanM landlordInfo) {
    landlordInfoDao.updateLandlord(landlordInfo);
  }

  @Override
  public void deleteLandlordByPrimaryKey(int key) {
    landlordInfoDao.deleteLandlordByPrimaryKey(key);
  }

  @Override
  public List<LandlordBeanM> findAllLandlords() {
    return landlordInfoDao.findAllLandlords();
  }

  @Override
  public void deleteLandlord() {
    landlordInfoDao.deleteLandlord();
  }

  @Override
  public boolean isLandlordExist(LandlordBeanM landlordInfo) {
    return landlordInfoDao.isLandlordExist(landlordInfo);
  }

  @Override
  public String checkLandlordId(String memberId) {
    return landlordInfoDao.checkLandlordId(memberId);
  }

  @Override
  public void evictLandlord(LandlordBeanM landlordInfo) {
    landlordInfoDao.evictLandlord(landlordInfo);
  }

  @Override
  public Map<String, String> getErrorMsgs(LandlordBeanM newBean) {
    Matcher matcher;
    Map<String, String> errorMsgs = new HashMap<>();
    String name = newBean.getName();
    String phone = newBean.getPhone().replaceAll("\\s*", "");
    String county = newBean.getCounty();
    String district = newBean.getDistrict();
    String address = newBean.getAddress();
    String mail = newBean.getMail();
    String pic = newBean.getStampImg();

    // 1.判斷名稱是否空白
    if (name == null || name.trim().length() == 0) {
      errorMsgs.put("errName", "必須輸入公司名稱");
    }

    // 2.判斷電話是否空白
    if (phone.length() != 10) {
      errorMsgs.put("errPhone", "手機電話為09開頭且總數為10碼");
    } else if (!phone.startsWith("09")) {
      errorMsgs.put("errPhone", "請輸入以「09」為開頭的手機電話");
    } else if (phone.length() == 10 && phone.startsWith("09")) {
      Pattern pattern = Pattern.compile("\\d{8}");
      matcher = pattern.matcher(phone.substring(2));
      if (!matcher.matches()) {
        errorMsgs.put("errPhone", "手機電話格式後8碼錯誤");
        // str.matches("[0-9]{4}-[0-9]{6}")
      }
    }

    // 3. 判斷縣市區域
    if (county == null || county.trim().length() == 0) {
      System.out.println(county);
      errorMsgs.put("errCounty", "必須輸入縣市");
    }

    if (district == null || district.trim().length() == 0) {
      errorMsgs.put("errDistrict", "必須輸入區域");
    }

    if (address == null || address.trim().length() == 0) {
      errorMsgs.put("errAddress", "必須輸入地址");
    }

    // 4. 判斷信箱
    if (mail == null || mail.trim().length() == 0) {
      errorMsgs.put("errMail", "必須輸入信箱");
    }

    // 5. 判斷圖片
    if (pic == null || pic.trim().length() == 0) {
      errorMsgs.put("errImg", "必須上傳公司大小章");
    }
    return errorMsgs;
  }
}
