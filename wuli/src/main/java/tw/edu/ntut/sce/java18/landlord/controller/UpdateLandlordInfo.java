package tw.edu.ntut.sce.java18.landlord.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import tw.edu.ntut.sce.java18.landlord.model.LandlordBeanM;
import tw.edu.ntut.sce.java18.landlord.service.LandlordService_Mvc;

@Controller
public class UpdateLandlordInfo {
  LandlordService_Mvc landlordService;
  ProcessImg processImg;
  int memberIdForTest = 1;

  @Autowired
  public UpdateLandlordInfo(LandlordService_Mvc landlordService, ProcessImg processImg) {
    this.landlordService = landlordService;
    this.processImg = processImg;
  }

  @GetMapping(value = {"landlordInfo/editLandlordInfo"})
  public String showLandlordInfoEdit() {
    return "landlordMvc/editLandlordInfo";
  }

  @PostMapping(
      value = "landlordInfo/editLandlordInfo",
      consumes = "application/json",
      produces = "application/json")
  public @ResponseBody Map<String, Map<String, String>> editLandlordEdit(
      @RequestBody LandlordBeanM landlordInfo) {
    Map<String, String> map = new HashMap<>();
    System.out.println("ok" + landlordInfo);
    landlordInfo.setId(memberIdForTest);

    map = landlordService.getErrorMsgs(landlordInfo);
    if (!map.isEmpty()) {
      var errMap = Map.of("errMeg", map);
      return errMap;

    } else {

      if (landlordInfo.getStamp() == null) {
        System.out.println("沒有圖片");
      }

      var saveMap = new HashMap<String, Map<String, String>>();
      try {
        String imgBase64Src = landlordInfo.getStampImg();
        int n = imgBase64Src.indexOf("base64,");
        String imgBase64 = imgBase64Src.substring(n + 7);
        String newImgFileName =
            processImg.saveImage(imgBase64, landlordInfo.getStamp(), landlordInfo.getId());

        landlordInfo.setStamp(newImgFileName);

        // update
        landlordService.updateLandlord(landlordInfo);
        // saveImage.saveImage
        map.put("successMsg", "更新成功");
        saveMap.put("success", map);

      } catch (Exception e) {
        e.printStackTrace();
        map.put("fail", "更新失敗");
        saveMap.put("fail", map);
      }
      return saveMap;
    }
  }
}
